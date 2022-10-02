package org.mintic.backiniciosesion.seguridad;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FiltroAutorizacionJWT extends OncePerRequestFilter {

    private final String cabecera = "Authorization";
    private final String prefijo = "Bearer ";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        try {
            if (existeToken(request)) {
                Claims claims = verificarToken(request);
                if (claims.get("datos") != null) {
                    configurarContexto(claims);
                } else {
                    SecurityContextHolder.clearContext();
                }
            } else {
                SecurityContextHolder.clearContext();
            }
            chain.doFilter(request, response);
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException e) {
            logger.info(e);
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
        }
    }

    private Claims verificarToken(HttpServletRequest request) {
        byte[] keyBytes = LLave.PRIVADA.getBytes(StandardCharsets.UTF_8);
        SecretKey llave = Keys.hmacShaKeyFor(keyBytes);

        String jwtToken = request.getHeader(cabecera).replace(prefijo, "");
        return Jwts.parserBuilder().setSigningKey(llave).build().parseClaimsJws(jwtToken).getBody();
    }

    private void configurarContexto(Claims claims) {
        List<String> permisoRol = (List<String>) claims.get("authorities");
        UsernamePasswordAuthenticationToken autorizado = new UsernamePasswordAuthenticationToken(claims.getSubject(),
                null, permisoRol.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
        SecurityContextHolder.getContext().setAuthentication(autorizado);
    }

    private boolean existeToken(HttpServletRequest request) {
        String miCabecera = request.getHeader(cabecera);
        return !(miCabecera == null || !miCabecera.startsWith(prefijo));
    }

}

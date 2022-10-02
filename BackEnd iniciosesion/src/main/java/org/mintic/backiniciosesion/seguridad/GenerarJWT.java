package org.mintic.backiniciosesion.seguridad;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.mintic.backiniciosesion.dtos.DTOAccesoRespuesta;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GenerarJWT {

    public String obtener(List<DTOAccesoRespuesta> info) {
        int valor = 60 * 60 * 24 * 1; // un día

        byte[] keyBytes = LLave.PRIVADA.getBytes(StandardCharsets.UTF_8);
        SecretKey llave = Keys.hmacShaKeyFor(keyBytes);

        List<GrantedAuthority> permisosPara = AuthorityUtils.commaSeparatedStringToAuthorityList("ROL_USUARIO");

        String token = Jwts.builder()
                .setIssuer("anguerrco")
                .setSubject("autenticación")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + valor))
                .claim("authorities", permisosPara.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .claim("datos", info.get(0))
                .signWith(llave).compact();

        return token;
    }

}

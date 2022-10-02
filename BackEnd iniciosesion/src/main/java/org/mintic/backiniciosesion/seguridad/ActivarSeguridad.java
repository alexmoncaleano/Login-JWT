package org.mintic.backiniciosesion.seguridad;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class ActivarSeguridad {

    @Value("${spring.security.debug}")
    private boolean activarTraceo;

    @Bean
    public SecurityFilterChain filtrosDeSeguridad(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .addFilterAfter(new FiltroAutorizacionJWT(), UsernamePasswordAuthenticationFilter.class).authorizeRequests()
                .antMatchers("/acceso/**").permitAll()
                .anyRequest().authenticated()
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer aplicarSeguridadWeb() {
        return ((modoWeb) -> {
            modoWeb.debug(activarTraceo).ignoring()
                    .antMatchers("/css/**", "/js/**", "/img/**", "/lib/**", "/favicon.ico");
        });
    }

}

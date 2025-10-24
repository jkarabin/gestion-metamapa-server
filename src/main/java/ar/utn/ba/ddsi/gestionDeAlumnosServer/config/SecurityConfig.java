package ar.utn.ba.ddsi.gestionDeAlumnosServer.config;

import ar.utn.ba.ddsi.gestionDeAlumnosServer.filters.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    System.out.println("=== CONFIGURANDO SECURITY ===");

    http
        .csrf(AbstractHttpConfigurer::disable)
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests(auth -> {
          // Rutas públicas de autenticación
          auth.requestMatchers("/api/auth", "/api/auth/refresh").permitAll();

          // PERMITIR GET A COLECCIONES
          auth.requestMatchers(HttpMethod.GET, "/api/colecciones").permitAll();

          // Rutas autenticadas
          auth.requestMatchers("/api/auth/user/roles-permisos").authenticated();

          // El resto de las rutas (ej: /api/alumnos) requieren autenticación
          auth.anyRequest().authenticated();
        })
        .addFilterBefore(new JwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

    return http.build();
  }
}
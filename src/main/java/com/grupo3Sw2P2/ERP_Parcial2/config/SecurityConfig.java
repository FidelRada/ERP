/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo3Sw2P2.ERP_Parcial2.config;

import java.util.Arrays;

/**
 *
 * @author fidel
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfig {

    private final UserDetailsService customUserDetailsService;

    public SecurityConfig(UserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/public/**").permitAll()
                .anyRequest().authenticated()
            )
//            .formLogin(form -> form
//                .loginPage("/login")
//                .permitAll()
//            )
            .httpBasic((t) -> {
              
            });

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
     // Configura las reglas de CORS
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200")); // Orígenes permitidos
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS")); // Métodos permitidos
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type")); // Encabezados permitidos
        configuration.setAllowCredentials(true); // Permitir credenciales (si es necesario)

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration); // Aplicar configuración a todas las rutas
        return source;
    }
}


//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Autowired
//    private CustomUserDetailsService customUserDetailsService; // Servicio para cargar el usuario
//
//    // Configuración del proveedor de autenticación
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(customUserDetailsService)
//            .passwordEncoder(passwordEncoder()); // Define cómo se codifican las contraseñas
//    }
//
//    // Método para definir el codificador de contraseñas (ej. BCrypt)
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    // Configuración de autorización de solicitudes HTTP
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable() // Desactiva CSRF si no es necesario (útil para APIs)
//            .authorizeRequests()
//            .antMatchers("/public/**").permitAll() // Define rutas públicas sin necesidad de autenticación
//            .anyRequest().authenticated() // Requiere autenticación para cualquier otra ruta
//            .and()
//            .formLogin() // Habilita el inicio de sesión con formulario (opcional)
//            .and()
//            .httpBasic(); // Habilita autenticación básica (opcional, por ejemplo, para APIs)
//    }
//}

//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .authorizeHttpRequests(authz -> authz
//                .requestMatchers("/api/personas/**").hasRole("ADMIN") // Solo los usuarios con rol "ADMIN" pueden acceder a /api/personas
//                .anyRequest().authenticated()
//            )
//            .httpBasic(); // Autenticación básica
//            // Desactivar CSRF solo para desarrollo o pruebas
//        http.csrf().disable();
//        return http.build();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user1 = User.builder()
//            .username("admin")
//            .password(passwordEncoder().encode("admin123"))
//            .roles("ADMIN") // Asigna el rol "ADMIN" a este usuario
//            .build();
//
//        UserDetails user2 = User.builder()
//            .username("user")
//            .password(passwordEncoder().encode("user123"))
//            .roles("USER") // Asigna el rol "USER" a este usuario
//            .build();
//
//        return new InMemoryUserDetailsManager(user1, user2);
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}


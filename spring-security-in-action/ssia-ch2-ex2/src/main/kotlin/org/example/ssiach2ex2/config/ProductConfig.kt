package org.example.ssiach2ex2.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain

@Configuration
class ProductConfig {

    @Autowired
    private lateinit var customAuthenticationProvider: CustomAuthenticationProvider

//    @Bean
//    fun userDetailsService(): UserDetailsService {
//        val inMemoryUserDetailsManager = InMemoryUserDetailsManager()
//        val user = User.withUsername("john")
//            .password("12345")
//            .authorities("read")
//            .build()
//        inMemoryUserDetailsManager.createUser(user)
//
//        return inMemoryUserDetailsManager
//    }
//
//    @Bean
//    fun passwordEncoder(): PasswordEncoder {
//        return NoOpPasswordEncoder.getInstance()
//    }


    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http.authenticationProvider(customAuthenticationProvider)
        http.httpBasic()
        http.authorizeRequests().anyRequest().authenticated()
        return http.build()
    }
}
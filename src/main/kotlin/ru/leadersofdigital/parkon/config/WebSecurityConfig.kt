package ru.leadersofdigital.parkon.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter


@Configuration
@EnableWebSecurity
class WebSecurityConfig : WebSecurityConfigurerAdapter() {

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
            .anyRequest().permitAll()
    }

    /* @Bean
     public override fun userDetailsService(): UserDetailsService {
         val user: UserDetails = User.withDefaultPasswordEncoder()
             .username("user")
             .password("password")
             .roles("USER")
             .build()
         return InMemoryUserDetailsManager(user)
     }*/
}

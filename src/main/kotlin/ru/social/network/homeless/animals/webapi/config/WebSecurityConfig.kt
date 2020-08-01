package ru.social.network.homeless.animals.webapi.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.security.web.util.matcher.AntPathRequestMatcher
import ru.social.network.homeless.animals.webapi.service.auth.UserAuthenticationService


@Configuration
@EnableWebSecurity
class WebSecurityConfig(val authenticationService: UserAuthenticationService,
                        val statelessAuthFilter: StatelessAuthFilter) : WebSecurityConfigurerAdapter() {


    override fun configure(http: HttpSecurity) {
        http
                .addFilterBefore(statelessAuthFilter, UsernamePasswordAuthenticationFilter::class.java)
                .authorizeRequests()
                    .antMatchers("/", "/reg").permitAll()
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .permitAll()
                .and()
                    .logout()
                    .logoutRequestMatcher(AntPathRequestMatcher("/logout"))
                    .permitAll()
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth
                .userDetailsService(authenticationService)
                .passwordEncoder(passwordEncoder())
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}
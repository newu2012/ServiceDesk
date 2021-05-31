package team.dna2.serviceDesk_server.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import team.dna2.serviceDesk_server.databaseService.services.UserService;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter  {
    @Resource
    UserService userService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                    .disable()
                //^чтобы позволить отправлять post-, patch-, put- запросы, в прод нужно будет добавить csrf tokens
                .httpBasic()
                //^сообщает Spring, чтобы он ожидал базовую HTTP аутентификацию Basic username:password
                    .and()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .and()
                .authorizeRequests()
                    .antMatchers("/developer/**").hasRole("DEVELOPER")
                    .antMatchers("/member/**").hasAnyRole("MEMBER", "DEVELOPER", "OWNER")
                    .antMatchers("/owner/**").hasAnyRole("OWNER", "DEVELOPER")
                .anyRequest().authenticated()
                .and()
                //Настройка для входа в систему
                .formLogin()
                    .loginPage("/login").permitAll()
                    .and()
                    .logout().permitAll();
    }

}

package com.nood.hrm.security;

import com.nood.hrm.security.auth.AuthFailureHandler;
import com.nood.hrm.security.auth.AuthSuccessHandler;
import com.nood.hrm.security.auth.LogoutSuccessHandler;
import com.nood.hrm.security.auth.RestAuthAccessDeniedHandler;
import com.nood.hrm.security.user.CustomPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailServiceImpl;

    @Autowired
    private AuthSuccessHandler authSuccessHandler;

    @Autowired
    private AuthFailureHandler authFailureHandler;

//    @Autowired
    private RestAuthAccessDeniedHandler restAuthAccessDeniedHandler;

    @Autowired
    private LogoutSuccessHandler logoutSuccessHandler;

    @Bean
    public PasswordEncoder encoder() {
//        return new BCryptPasswordEncoder();
        return new CustomPasswordEncoder();
    }

//    @Bean
//    public PasswordEncoder md5Encoder() {
//        return new Md5PasswordEncoder();
//    }

    // 认证操作
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailServiceImpl).passwordEncoder(encoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

        http.headers().frameOptions().sameOrigin();

        http.authorizeRequests()
                .antMatchers(
                        "/login.html",
                        "/my/**",
                        "/treetable-lay/**",
                        "/xadmin/**",
                        "/xadmin2/**",
                        "/ztree/**",
                        "/component/**",
                        "/statics/**"
                        ).permitAll()
                .anyRequest().authenticated();

        http.formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/login")
            .successHandler(authSuccessHandler)
            .failureHandler(authFailureHandler);

        http.logout().permitAll()
            .invalidateHttpSession(true)
            .deleteCookies("JESSONID")
            .logoutSuccessHandler(logoutSuccessHandler);

        http.exceptionHandling()
                .accessDeniedHandler(restAuthAccessDeniedHandler);

////         403
//        http.exceptionHandling()
//                .accessDeniedPage("/error/403.html");

//        http.formLogin()
//                .loginProcessingUrl("/user/login")
//                .defaultSuccessUrl("/success.html")
//                .loginPage("/login.html");

//        http.logout()
//                .logoutUrl("/logout").logoutSuccessUrl("/test/hello").permitAll();


//        // 自动登录
//        http.rememberMe()
//                .tokenRepository(persistentTokenRepository())
//                .tokenValiditySeconds(60)                      // 设置有效时长，单位为s
//                .userDetailsService(userDetailsService);


    }
}

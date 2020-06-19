package com.it.tacocloud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import javax.sql.DataSource;

/**
 * @author gxp
 * @version 1.0
 * @date 2020/6/18 11:42
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

//    /**
//     * 基于内存的用户存储
//     * 报错java.lang.IllegalArgumentException: There is no PasswordEncoder mapped for the id "null"
//     * @param auth
//     * @throws Exception
//     */
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("zhangsan").password("123456").authorities("ROLE_USER")
//                .and()
//                .withUser("lisi").password("123456").authorities("ROLE_USER");
//    }

//    /**
//     * 基于JDBC的用户存储
//     * @param auth
//     * @throws Exception
//     */
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication().dataSource(dataSource)
//                .usersByUsernameQuery("select username, password, enabled from Users " +
//                        " where username = ?")
//                .authoritiesByUsernameQuery("select username, authority from UserAuthorities " +
//                        " where username = ?")
//                .passwordEncoder(new StandardPasswordEncoder("53cr3t"));
//    }

    /**
     * 以LDAP作为后端的用户存储
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.ldapAuthentication()
            .userSearchBase("ou=people")
            .userSearchFilter("{uid={0}}")
            .groupSearchBase("ou=groups")
            .groupSearchFilter("member={0}")
            .passwordCompare()
            .passwordEncoder(new BCryptPasswordEncoder())
            .passwordAttribute("passcode");


    }
}

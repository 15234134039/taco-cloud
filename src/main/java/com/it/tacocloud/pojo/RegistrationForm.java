package com.it.tacocloud.pojo;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author gxp
 * @version 1.0
 * @date 2020/6/19 17:13
 */
@Data
public class RegistrationForm {

    private String username;
    private String password;
    private String fullname;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(username, passwordEncoder.encode(password),
                fullname, street, city, state, zip, phone);
    }

}


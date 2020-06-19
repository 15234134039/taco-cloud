package com.it.tacocloud.data;

import com.it.tacocloud.pojo.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author gxp
 * @version 1.0
 * @date 2020/6/19 16:16
 */
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}

package com.it.tacocloud.data;

import com.it.tacocloud.pojo.Order;

import com.it.tacocloud.pojo.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


/**
 * @author gxp
 * @version 1.0
 * @date 2020/6/17 14:58
 */
public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findByUserOrderByPlacedAtDesc(User user, Pageable pageable);


}

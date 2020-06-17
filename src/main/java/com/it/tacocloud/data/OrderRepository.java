package com.it.tacocloud.data;

import com.it.tacocloud.pojo.Order;

/**
 * @author gxp
 * @version 1.0
 * @date 2020/6/17 14:58
 */
public interface OrderRepository {

    Order save(Order order);
}

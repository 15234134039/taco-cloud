package com.it.tacocloud.data;

import com.it.tacocloud.pojo.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 * @author gxp
 * @version 1.0
 * @date 2020/6/17 14:58
 */
public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findByDeliveryZip(String deliveryZip);

    List<Order> readOrderByDeliveryZipAndPlacedAtBetween(String deliveryZip, Date startDate, Date endDate);

    /**
     * 加上Query注解后，方法名可以自定义
     * @return
     */
    @Query("Order o where o.deliveryCity = 'Seattle'")
    List<Order> findInSeattle();


}

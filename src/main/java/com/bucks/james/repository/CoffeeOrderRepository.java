package com.bucks.james.repository;

import com.bucks.james.entity.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author: JamesZhan
 * @create: 2020 - 05 - 28 23:43
 */
public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
    /**
     * 根据客户名称进行订单查询， 并且按照订单序列号排序3
     * @param customer
     * @return
     */
    List<CoffeeOrder> findByCustomerOrderById(String customer);

    /**
     * 根据Item进行查询
     * @param name
     * @return
     */
    List<CoffeeOrder> findByItems(String name);
}

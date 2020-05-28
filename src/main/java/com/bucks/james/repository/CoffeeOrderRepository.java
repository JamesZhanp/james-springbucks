package com.bucks.james.repository;

import com.bucks.james.entity.CoffeeOrder;
import org.springframework.data.repository.CrudRepository;

/**
 * @author: JamesZhan
 * @create: 2020 - 05 - 28 23:43
 */
public interface CoffeeOrderRepository extends CrudRepository<CoffeeOrder, Long> {
}

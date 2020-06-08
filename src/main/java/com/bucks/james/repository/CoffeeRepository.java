package com.bucks.james.repository;

import com.bucks.james.entity.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: JamesZhan
 * @create: 2020 - 05 - 28 23:41
 */
public interface CoffeeRepository extends JpaRepository<Coffee, Long> {

}
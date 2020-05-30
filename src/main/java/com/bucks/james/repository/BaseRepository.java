package com.bucks.james.repository;

import com.bucks.james.entity.BaseEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author: JamesZhan
 * @create: 2020 - 05 - 30 10:53
 */
public interface BaseRepository<T, Long> extends CrudRepository<T, Long> {
    List<T> findTop3ByOrderByUpdateTimeDescIdAsc();
}

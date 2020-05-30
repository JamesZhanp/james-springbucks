package com.bucks.james.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author: JamesZhan
 * @create: 2020 - 05 - 28 23:31
 */

@Entity
@Table(name = "T_ORDER")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Builder
public class CoffeeOrder extends BaseEntity implements Serializable {

//    @Id
//    @GeneratedValue
//    private Long id;

    private String customer;

    @ManyToMany
    @JoinTable(name = "T_ORDER_COFFEE")
    private List<Coffee> items;

    @Enumerated
    @Column(nullable = false)
    private OrderState state;

//    @Column(updatable = false)
//    @CreationTimestamp
//    private Date createTime;

//    @UpdateTimestamp
//    private Date updateTime;
}




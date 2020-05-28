package com.bucks.james.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;
import org.joda.money.Money;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author: JamesZhan
 * @create: 2020 - 05 - 27 0:08
 */

@Data
@Table(name = "T_MENU")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Coffee implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @Column
    @Type(type = "org.jadira.usertype.momneyandcurrency.joda.PersistentMoneyAmount",
            parameters = {@org.hibernate.annotations.Parameter(name = "currencyCode", value = "CNY")})
    private Money price;

    /**
     *     声明禁止修改
      */
    @Column(updatable = false)
    @CreationTimestamp
    private Date createTime;

    @UpdateTimestamp
    private Date updateTime;
}

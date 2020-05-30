package com.bucks.james.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;
import org.joda.money.Money;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author: JamesZhan
 * @create: 2020 - 05 - 27 0:08
 */

@Entity
@Data
@Table(name = "T_MENU")
@AllArgsConstructor
@NoArgsConstructor
/**
 * 只有当callSuper 为true的时候， toString才会将父类的属性增加到子类的 toString 当中
 */
@ToString(callSuper = true)
@Builder
public class Coffee extends BaseEntity implements Serializable {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;

    private String name;

    @Column
    @Type(type = "org.jadira.usertype.moneyandcurrency.joda.PersistentMoneyAmount",
            parameters = {@org.hibernate.annotations.Parameter(name = "currencyCode", value = "CNY")})
    private Money price;

//    /**
//     *     声明禁止修改
//      */
//    @Column(updatable = false)
//    @CreationTimestamp
//    private Date createTime;
//
//    @UpdateTimestamp
//    private Date updateTime;
}

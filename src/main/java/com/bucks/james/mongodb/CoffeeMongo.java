package com.bucks.james.mongodb;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.money.Money;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author: JamesZhan
 * @create: 2020 - 06 - 04 21:35
 */

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CoffeeMongo {

    @Id
    private String id;
    private String name;
    private Money price;
    private Date createTime;
    private Date updateTime;
}

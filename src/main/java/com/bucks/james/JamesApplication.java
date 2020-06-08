package com.bucks.james;

import com.bucks.james.convert.MoneyReadConverter;
import com.bucks.james.entity.Coffee;
import com.bucks.james.entity.CoffeeOrder;
import com.bucks.james.entity.OrderState;
import com.bucks.james.mongodb.CoffeeMongo;
import com.bucks.james.repository.CoffeeRepository;
import com.bucks.james.service.CoffeeOrderService;
import com.bucks.james.service.CoffeeService;
import com.mongodb.client.result.UpdateResult;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

//@SpringBootApplication(scanBasePackages = "com.bucks.james.service")
@EnableJpaRepositories
@Slf4j
@EnableTransactionManagement
public class JamesApplication implements ApplicationRunner {

//    @Autowired
//    private CoffeeRepository coffeeRepository;
//
//    @Autowired
//    private CoffeeService coffeeService;
//
//    @Autowired
//    private CoffeeOrderService orderService;


//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        log.info("All Coffee: {}", coffeeRepository.findAll());
//
//        Optional<Coffee> latte = coffeeService.findOneCoffee("Latte");
//        if (latte.isPresent()){
//            CoffeeOrder order = orderService.createOrder("Li Lei", latte.get());
//            log.info("Update INIT to PAID: {}", orderService.updateState(order, OrderState.PAID));
//            log.info("Update PAID to INIT: {}", orderService.updateState(order, OrderState.INIT));
//        }
//    }

    public static void main(String[] args) {
        SpringApplication.run(JamesApplication.class, args);
    }
// mongodb 相关的内容
    @Autowired
    private MongoTemplate mongoTemplate;
    @Bean
    public MongoCustomConversions mongoCustomConversions() {
        return new MongoCustomConversions(Arrays.asList(new MoneyReadConverter()));
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        CoffeeMongo espresso = CoffeeMongo.builder()
                .name("espresso")
                .price(Money.of(CurrencyUnit.of("CNY"), 20.0))
                .createTime(new Date())
                .updateTime(new Date()).build();
        CoffeeMongo saved = mongoTemplate.save(espresso);
        log.info("Coffee {}", saved);

        List<Coffee> list = mongoTemplate.find(
                query(where("name").is("espresso")), Coffee.class);
        log.info("Find {} Coffee", list.size());
        list.forEach(c -> log.info("Coffee {}", c));

        Thread.sleep(1000);
        // 为了看更新时间
        UpdateResult result = mongoTemplate.updateFirst(query(where("name").is("espresso")),
                new Update().set("price", Money.ofMajor(CurrencyUnit.of("CNY"), 30))
                        .currentDate("updateTime"),
                Coffee.class);
        log.info("Update Result: {}", result.getModifiedCount());
        Coffee updateOne = mongoTemplate.findById(saved.getId(), Coffee.class);
        log.info("Update Result: {}", updateOne);

        mongoTemplate.remove(updateOne);
    }
}

package com.lastcivilization.itemwriteservice.infrastructure.application.config;

import com.lastcivilization.itemwriteservice.domain.ItemServiceImp;
import com.lastcivilization.itemwriteservice.domain.port.ItemRepository;
import com.lastcivilization.itemwriteservice.domain.port.ItemService;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("com.lastcivilization.itemwriteservice.infrastructure.database")
@EnableJpaRepositories("com.lastcivilization.itemwriteservice.infrastructure.database")
@ComponentScan("com.lastcivilization.itemwriteservice")
class BeanConfiguration {

    @Bean
    ItemService itemService(ItemRepository itemRepository){
        return new ItemServiceImp(itemRepository);
    }
}

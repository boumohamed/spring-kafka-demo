package me.bouzri.springcloudekafkademo.services;

import me.bouzri.springcloudekafkademo.entities.PageEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
public class PageEventService {
    @Bean
    public Consumer<PageEvent> pageEventConsumer()
    {
        return (input) -> {
            System.out.println("--------------------------");
            System.out.println(input);
            System.out.println("--------------------------");
        };
    }
}
package com.rivaldy.customer.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BasicConfig {

    @Bean
    public FormatDate formatDate(){
        return new FormatDate();
    }
}

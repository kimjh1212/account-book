package com.jihwan.accountbook.service.configuration;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Slf4j
@Configuration
public class GsonConfiguration {

    @Bean("gson")
    public Gson gson() {
        return new GsonBuilder().create();
    }
}

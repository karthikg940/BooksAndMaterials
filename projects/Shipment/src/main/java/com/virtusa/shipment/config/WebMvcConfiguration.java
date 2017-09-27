package com.virtusa.shipment.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new ByteArrayHttpMessageConverter());
        converters.add(jsonMessageConverter());
        super.configureMessageConverters(converters);
    }

    private static HttpMessageConverter<Object> jsonMessageConverter() {
        MappingJackson2HttpMessageConverter jsonConverter = null;
        try {
            jsonConverter = new MappingJackson2HttpMessageConverter(jsonMapperFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonConverter;
    }

    private static ObjectMapper jsonMapperFactory() {
        Jackson2ObjectMapperBuilder mapperBuilder = new Jackson2ObjectMapperBuilder();
        SimpleModule module = new SimpleModule();
        mapperBuilder.modulesToInstall(module);
        return mapperBuilder.build();
    }

}

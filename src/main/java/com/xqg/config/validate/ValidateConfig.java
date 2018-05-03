package com.xqg.config.validate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

/**
 * 创建用户: 刘建德
 * 创建时间: 2018-03-16 下午3:09
 * 描   述: 如果想要使用springboot的validate验证接口参数需要创建该bean
 */
@Configuration
public class ValidateConfig {

    //如果想要使用@Validated进行Controller的参数验证需要注入该Bean
    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }
}

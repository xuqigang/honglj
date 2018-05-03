package com.xqg.config.database;

import com.alibaba.fastjson.JSON;
import com.xqg.config.log.WebLogAspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.regex.Pattern;

/**
 * 创建用户:杨辽
 * 创建时间: 2017-11-23 下午9:13
 * 描   述:
 **/
@Aspect
@Order(5)
@Configuration
public class SqlInjectInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebLogAspect.class);

    @Pointcut("execution(public * com.xqg.mapper.*..*.*(..))")
    public void webSql() {
    }

    //使用@Before在切入点开始处切入内容
    @Before("webSql()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {

        for (Object o : joinPoint.getArgs()) {
            if (o instanceof String) {
                if (isValid((String) o)) {
                    throw new Exception("疑似 SQL 注入");
                }
            }

            if (!(o instanceof Integer)) {
                String s = JSON.toJSONString(o);
                if (isValid(s)) {
                    throw new Exception("疑似 SQL 注入");
                }
            }
        }
    }

    private static String reg = "(?:')|(?:--)|(/\\*(?:.|[\\n\\r])*?\\*/)|(\\b(select|update|union|and|or|delete|insert|trancate|char|into|substr|ascii|declare|exec|count|master|into|drop|execute)\\b)";

    private static Pattern sqlPattern = Pattern.compile(reg, Pattern.CASE_INSENSITIVE);

    private boolean isValid(String str) {
        if (sqlPattern.matcher(str).find()) {
            LOGGER.info("未能通过过滤器 ---> {}", str);
            return true;
        }
        return false;
    }

}
package com.tencent.bbm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author bbm
 * 启动
 */
@SpringBootApplication
@EnableAspectJAutoProxy
@EnableSwagger2
@Slf4j
@EnableCaching
public class BbmApplication {

    /**
     * main
     * @param args 参数
     */
    public static void main(String[] args) {
        SpringApplication.run(BbmApplication.class, args);
        log.info("init success");
    }

}

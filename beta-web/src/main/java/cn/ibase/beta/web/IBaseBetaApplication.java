package cn.ibase.beta.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: song
 * @Date: 2019/9/11
 */
@SpringBootApplication(scanBasePackages = {"cn.ibase.beta"})
@MapperScan("cn.ibase.beta.*.dao")
public class IBaseBetaApplication {
    public static void main(String[] args) {
        SpringApplication.run(IBaseBetaApplication.class, args);
    }
}

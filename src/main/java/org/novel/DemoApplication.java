package org.novel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 项目入口
 */

@SpringBootApplication// 启动springboot
@MapperScan("org.novel.mapper")
public class DemoApplication// 入口类
{
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}

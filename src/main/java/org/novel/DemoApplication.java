package org.novel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目入口
 *
 */

@RestController// 表示该类为控制器
@SpringBootApplication// 启动springboot
public class DemoApplication// 入口类
{
    @RequestMapping("/")
    String home() {
        String name = "tang";
        
        return "Hello " + name + "!";
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}

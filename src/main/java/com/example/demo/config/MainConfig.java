package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author liyangdan
 * @date 2019/1/23 12:55 PM
 */
@Configuration
@Import({Square.class, Circular.class})
public class MainConfig {
}

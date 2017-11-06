package com.lqkj;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by lijunhong on 17/11/4.
 * 配置war包部署,servlet依赖
 */
public class ServletInit extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ZygxyApplication.class);
    }
}

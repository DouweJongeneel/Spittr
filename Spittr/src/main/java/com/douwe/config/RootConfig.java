package com.douwe.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Milan_Verheij on 02-08-16.
 *
 * Rootconfig voor application context
 */

@Configuration
@ComponentScan(basePackages = { "com.douwe" },
        excludeFilters = {
                @Filter(type= FilterType.ANNOTATION, value = EnableWebMvc.class)
        })

public class RootConfig {
}

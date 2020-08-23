package com.xwtec.dataSource;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2020/8/23.
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String value();
}
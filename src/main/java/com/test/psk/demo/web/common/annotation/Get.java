package com.test.psk.demo.web.common.annotation;


import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping(method = RequestMethod.GET)
@ResponseBody
public @interface Get {

    @AliasFor(annotation = RequestMapping.class)
    String[] produces() default "application/json; charset=utf-8";

    @AliasFor(annotation = RequestMapping.class)
    String[] value() default {};

}

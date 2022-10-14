package com.ui.api.automation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Component
@EnableConfigurationProperties
public @interface ObjectConfiguration {

}

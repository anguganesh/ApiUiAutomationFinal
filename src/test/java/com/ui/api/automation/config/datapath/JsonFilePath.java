package com.ui.api.automation.config.datapath;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.ui.api.automation.annotation.ObjectConfiguration;
import com.ui.api.automation.configuration.YamlSourceFactory;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;



@Component
//@PropertySource(value= {"classpath:jsonPathLocation.properties"})
@PropertySource(value= {"classpath:yamlAndJsonPathLocation.yml"}, factory = YamlSourceFactory.class)
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "target.application.jsonfilepath")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JsonFilePath {

	String loginJsonFilePath;
}
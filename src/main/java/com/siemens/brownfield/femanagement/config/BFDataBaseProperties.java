package com.siemens.brownfield.femanagement.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "spring.datasource.bf")
public class BFDataBaseProperties {
    String url;
    String username;
    String password;
    String driverClassName;
}

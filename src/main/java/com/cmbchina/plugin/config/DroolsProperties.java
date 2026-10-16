package com.cmbchina.plugin.config;


import com.cmbchina.plugin.entity.Range;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @description: some desc
 * @author: IT006901
 * @date: 2026/3/5
 */
@Component
@PropertySource(value = "classpath:config/drools.properties")
@ConfigurationProperties(prefix = "drools")
public class DroolsProperties {

    private Integer defaultValue;

    private Map<Integer, Range> rules;

    public Integer getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(Integer defaultValue) {
        this.defaultValue = defaultValue;
    }

    public Map<Integer, Range> getRules() {
        return rules;
    }

    public void setRules(Map<Integer, Range> rules) {
        this.rules = rules;
    }
}
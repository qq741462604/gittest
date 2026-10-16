package com.cmbchina.plugin.service;

/**
 * @description: some desc
 * @author: IT006901
 * @date: 2026/3/5
 */
import com.cmbchina.plugin.config.DroolsProperties;
import com.cmbchina.plugin.entity.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class StrategyService {

    @Autowired
    private DroolsProperties properties;

    // public StrategyService(DroolsProperties properties) {
    //     this.properties = properties;
    // }

    public Integer match(int score) {

        for (Map.Entry<Integer, Range> entry : properties.getRules().entrySet()) {

            if (entry.getValue().contains(score)) {
                return entry.getKey();
            }
        }

        return properties.getDefaultValue();
    }
}

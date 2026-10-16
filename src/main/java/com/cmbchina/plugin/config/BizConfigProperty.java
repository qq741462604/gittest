package com.cmbchina.plugin.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author 西安真的好热
 * @date 2025/8/12 10:22
 */
@Data
@Configuration
public class BizConfigProperty {
    /**
     * 不需要有
     */
    @Value("${rtd.eventSourceId:107}")
    private String eventSourceId;
}


package com.cmbchina.plugin.utils;

import com.cmbchina.plugin.config.BizConfigProperty;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


/**
 * @author 80231496
 */
@Slf4j
@Component
public class ResourceUtils implements ApplicationContextAware {

    private final static ResourceUtils INSTANCE = new ResourceUtils();
    private static ApplicationContext applicationContext;

    public static ResourceUtils getInstance() {
        return INSTANCE;
    }

    public static BizConfigProperty getBizConfigProperty() {
        return applicationContext.getBean(BizConfigProperty.class);
    }

    @Override
    public void setApplicationContext(final @NotNull ApplicationContext applicationContext) throws BeansException {
        ResourceUtils.applicationContext = applicationContext;
    }


}

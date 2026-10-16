package com.cmbchina.plugin.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextBeanUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public SpringContextBeanUtil() {
        // 什么都不用做
        super();
    }

    @Override
    public synchronized void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextBeanUtil.applicationContext = applicationContext;
    }

    public static synchronized  ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static Object getBean(String name) {
        return applicationContext.getBean(name);
    }

}

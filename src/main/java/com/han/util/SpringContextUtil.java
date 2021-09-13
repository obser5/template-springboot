package com.han.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;

/**
 * Spring容器工具类，解决线程注入时NullPointException的问题
 *
 * @author HanMingjie
 * @since 2021/9/10
 */
public class SpringContextUtil implements ApplicationContextAware {
    private static ApplicationContext context = null;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    /**
     * 通过beanName获取实例
     *
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName) {
        return context.getBean(beanName);
    }

    /**
     * 容器中是否存在beanName实例
     *
     * @param beanName
     * @return
     */
    public static boolean containsBean(String beanName) {
        return context.containsBean(beanName);
    }
}

package cn.stylefeng.guns;

import org.springframework.context.ApplicationContext;

public class SpringContextUtil
{
    private static ApplicationContext applicationContext;
    
    public static ApplicationContext getApplicationContext() {
        return SpringContextUtil.applicationContext;
    }
    
    public static void setApplicationContext(final ApplicationContext applicationContext) {
        SpringContextUtil.applicationContext = applicationContext;
    }
    
    public static Object getBean(final String name) {
        return SpringContextUtil.applicationContext.getBean(name);
    }
    
    public static Object getBean(final Class<?> requiredType) {
        return SpringContextUtil.applicationContext.getBean((Class)requiredType);
    }
}

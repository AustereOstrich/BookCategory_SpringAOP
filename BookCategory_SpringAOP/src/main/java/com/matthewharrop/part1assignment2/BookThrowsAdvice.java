package com.matthewharrop.part1assignment2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.support.GenericXmlApplicationContext;
import java.lang.reflect.Method;

public class BookThrowsAdvice implements ThrowsAdvice {

    private static Logger logger = LoggerFactory.getLogger(
            BookThrowsAdvice.class);

    public static void main (String[] args) throws Exception {

        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("applicationContext.xml");
        context.refresh();

        Book book = (Book) context.getBean("book3");

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(book);
        proxyFactory.addAdvice(new BookThrowsAdvice());
        Book proxy = (Book) proxyFactory.getProxy();

        try {
            proxy.throwException();
        } catch (Exception exception) {

        }
    }

    public void afterThrowing(Method method, Object[] args, Object target,
                                       RuntimeException e) throws Throwable {
        logger.info("***");
        logger.info("RuntimeException Captured");
        logger.info("Caught: " + e.getClass().getName());
        logger.info("Method: " + method.getName());
        System.out.println("***");
    }

}

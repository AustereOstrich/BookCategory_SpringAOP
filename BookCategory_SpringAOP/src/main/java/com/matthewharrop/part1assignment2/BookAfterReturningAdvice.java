package com.matthewharrop.part1assignment2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.lang.reflect.Method;

public class BookAfterReturningAdvice implements AfterReturningAdvice {

    private static Logger logger = LoggerFactory.getLogger(
            com.matthewharrop.part1assignment2.BookAfterReturningAdvice.class);

    public static void main (String[] args) {

        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("applicationContext.xml");
        context.refresh();

        Book book = (Book) context.getBean("book2");

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new BookAfterReturningAdvice());
        proxyFactory.setTarget(book);
        Book proxy = (Book) proxyFactory.getProxy();
        proxy.reading();

    }

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        logger.info("After '" + method.getName() + "' write the book review.");
    }
}

package com.matthewharrop.part1assignment2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.lang.reflect.Method;

public class BookBeforeAdvice implements MethodBeforeAdvice {

        private static Logger logger = LoggerFactory.getLogger(
                com.matthewharrop.part1assignment2.BookBeforeAdvice.class);

        public static void main(String[] args) {

            GenericXmlApplicationContext context = new GenericXmlApplicationContext();
            context.load("applicationContext.xml");
            context.refresh();

            Book book = (Book) context.getBean("book1");

            ProxyFactory proxyFactory = new ProxyFactory();
            proxyFactory.addAdvice(new BookBeforeAdvice());
            proxyFactory.setTarget(book);
            Book bookProxy = (Book) proxyFactory.getProxy();
            bookProxy.reading();

        }

    public void before(Method method, Object[] objects, Object o) throws Throwable {
        logger.info("Before '" + method.getName() + "' buy the book.");
    }
}

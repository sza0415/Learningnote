package org.sza;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.sza.service.BookService;

public class Main {
    public static void main(String[] args) {
//        使用Spring ClassPathXmlApplicationContext 完成IOC容器的创建
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        使用getBean(String name)方法，其name参数就是我们在bean配置的id，通过这个id来创造对象
        BookService bookService = (BookService)context.getBean("bookService");
        bookService.save();
    }
}
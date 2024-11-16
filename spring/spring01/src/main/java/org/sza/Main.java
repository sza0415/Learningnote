package org.sza;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.sza.config.SpringConfig;
import org.sza.dao.BookDao;
import org.sza.service.BookService;

public class Main {
    public static void main(String[] args) {
////        使用Spring ClassPathXmlApplicationContext 完成IOC容器的创建
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml.txt");
//        BookService bookService = (BookService) context.getBean("bookService");
//        bookService.save();

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookDao bookDao = (BookDao) context.getBean("bookDao");
        bookDao.save();
        BookService bookService = context.getBean(BookService.class);
        bookService.save();
    }
}
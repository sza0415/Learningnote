package org.sza.service.impl;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.sza.dao.BookDao;
import org.sza.dao.UserDao;
import org.sza.service.BookService;
@Component
public class BookServiceImpl implements BookService, InitializingBean , DisposableBean {


    private UserDao userDao;
    private BookDao bookDao;
//    private int connectionCount;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public BookServiceImpl() {
        System.out.println("BookServiceImpl");
    }

    @Override
    public void save() {
//        System.out.println("save book service" + connectionCount);
        bookDao.save();
//        userDao.save();
    }

//    public void setBookDao(BookDao bookDao) {
//        this.bookDao = bookDao;
//        System.out.println("BookServiceImpl setBookDao");
//    }
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//        System.out.println("BookServiceImpl setUserDao");
//    }
    public void setConnectionCount(int connectionCount) {
//        this.connectionCount = connectionCount;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy book service");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("after properties set book service");
    }
}

package org.sza.dao.impl;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.sza.dao.BookDao;
@Component("bookDao")
public class BookDaoImpl implements BookDao , InitializingBean , DisposableBean {

    public BookDaoImpl() {
        System.out.println("BookDaoImpl");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy book dao");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet book dao");
    }


    @Override
    public void save() {
        System.out.println("save book dao");
    }

}

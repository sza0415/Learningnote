package org.sza.dao.impl;

import org.sza.dao.BookDao;

public class BookDaoImpl implements BookDao {
    @Override
    public void save() {
        System.out.println("save book dao");
    }
}

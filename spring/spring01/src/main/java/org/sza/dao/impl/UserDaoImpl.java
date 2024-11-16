package org.sza.dao.impl;

import org.sza.dao.UserDao;

public class UserDaoImpl implements UserDao {
    public UserDaoImpl() {
        System.out.println("UserDaoImpl");
    }

    @Override
    public void save() {
        System.out.println("UserDao save");
    }
}

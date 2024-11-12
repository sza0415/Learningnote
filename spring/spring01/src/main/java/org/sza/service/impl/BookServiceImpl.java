package org.sza.service.impl;
import org.sza.dao.BookDao;
import org.sza.service.BookService;

public class BookServiceImpl implements BookService {
    private BookDao bookDao_;
    @Override
    public void save() {
        System.out.println("save book service");
        bookDao_.save();
    }

    public void setBookDao1(BookDao bookDao_) {
        this.bookDao_ = bookDao_;
    }
}

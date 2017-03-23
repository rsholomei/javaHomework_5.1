package com.geekhub.dao.impl;

import com.geekhub.dao.GuestBookDao;
import com.geekhub.dao.mapper.GuestBookMapper;
import com.geekhub.model.GuestBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

@Service
public class GuestBookDaoImpl extends JdbcDaoSupport implements GuestBookDao{

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Override
    public void saveGuestBook(GuestBook guestBook) {
        try {
            this.getJdbcTemplate().update
                    ("INSERT INTO GuestBook (NameGuest, Message, Rating ) VALUES(?,?,?)",
                            new Object[] { guestBook.getName(), guestBook.getMessage(), guestBook.getRating() });
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteGuestBookById(int guestBook_Id) {
        try {
            this.getJdbcTemplate().update("delete from GuestBook where GuestBook_ID = ?",
                    guestBook_Id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<GuestBook> getAllGuestBook() {
        return this.getJdbcTemplate().query("select * from GuestBook",
                new GuestBookMapper());
    }
}

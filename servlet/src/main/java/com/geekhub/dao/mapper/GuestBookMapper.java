package com.geekhub.dao.mapper;

import com.geekhub.model.GuestBook;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class GuestBookMapper implements RowMapper<GuestBook> {

    public GuestBook mapRow(ResultSet rs, int rowNum) throws SQLException {
        GuestBook guestBook = new GuestBook();
        guestBook.setId(rs.getLong("GuestBook_ID"));
        guestBook.setName(rs.getString("NameGuest"));
        guestBook.setMessage(rs.getString("Message"));
        guestBook.setRating(rs.getInt("Rating"));
        return guestBook;
    }
}

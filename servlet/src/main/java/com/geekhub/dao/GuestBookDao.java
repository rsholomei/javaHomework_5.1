package com.geekhub.dao;

import com.geekhub.model.GuestBook;

import java.util.List;

public interface GuestBookDao {
    void saveGuestBook(GuestBook guestBook);
    void deleteGuestBookById(int guestBook_Id);
    GuestBook getGuestBookById(int guestBook_Id);
    List<GuestBook> getAllGuestBook();
}

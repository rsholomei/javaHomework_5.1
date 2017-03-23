package com.geekhub.servlets;

import com.geekhub.config.AppConfig;
import com.geekhub.dao.GuestBookDao;
import com.geekhub.dao.impl.GuestBookDaoImpl;
import com.geekhub.model.GuestBook;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GuestBookServlet", urlPatterns = "/guestBook")
public class GuestBookServlet extends HttpServlet {

    private GuestBookDao guestBookDao;

    @Override
    public void init() throws ServletException {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        guestBookDao = context.getBean(GuestBookDaoImpl.class);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = "";
        if(request.getParameterMap().containsKey("action")){
            action=request.getParameter("action");
        }
        if(action.equalsIgnoreCase("delete")){
            guestBookDao.deleteGuestBookById(Integer.parseInt(request.getParameter("id")));
            response.sendRedirect("/guestBook");
            return;
        }
        request.setAttribute("guestBooks", guestBookDao.getAllGuestBook());
        request.getRequestDispatcher("/guestBook.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GuestBook guestBook = new GuestBook();
        guestBook.setName(request.getParameter("name"));
        guestBook.setMessage(request.getParameter("message"));
        guestBook.setRating(Integer.parseInt(request.getParameter("rating")));

        guestBookDao.saveGuestBook(guestBook);
        response.sendRedirect("/guestBook");
    }
}

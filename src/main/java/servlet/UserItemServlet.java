package servlet;

import manager.ItemManager;
import model.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/item/user")
public class UserItemServlet extends HttpServlet {
    ItemManager itemManager = new ItemManager();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Item> itemList = itemManager.getAll();
        req.setAttribute("items", itemList);
        req.getRequestDispatcher("/WEB-INF/item.jsp").forward(req, resp);
    }
}

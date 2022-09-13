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

@WebServlet(urlPatterns = "/items")
public class CategoryServlet extends HttpServlet {
    ItemManager itemManager = new ItemManager();
    List<Item> categoryList = null;
    int categoryId;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        categoryId = Integer.parseInt(req.getParameter("categoryId"));
        categoryList = itemManager.getItemByCategory(categoryId);
        if (categoryList.size() != 0) {
            req.setAttribute("catList", categoryList);
            req.getRequestDispatcher("/").forward(req, resp);
        }else {categoryList = itemManager.getLast();
            req.setAttribute("catList", categoryList);
            req.getRequestDispatcher("/").forward(req, resp);
        }
    }
}


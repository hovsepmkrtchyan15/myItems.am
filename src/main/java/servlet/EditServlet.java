package servlet;

import manager.ItemManager;
import model.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/edit")
public class EditServlet extends HttpServlet {

    ItemManager itemManager = new ItemManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       int id = Integer.parseInt(req.getParameter("itemId"));
       Item item = itemManager.getById(id);
        req.setAttribute("item", item);
        req.getRequestDispatcher("/WEB-INF/editItem.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String title = req.getParameter("title");
        double price = Double.parseDouble(req.getParameter("price"));

        Item item = Item.builder()
                .id(id)
                .title(title)
                .price(price)

                .build();
        itemManager.edit(item);
        resp.sendRedirect("/item/show");
    }
}


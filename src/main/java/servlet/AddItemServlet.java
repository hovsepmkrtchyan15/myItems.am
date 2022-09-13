package servlet;

import manager.ItemManager;
import manager.UserManager;
import model.Item;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet(urlPatterns = "/item/add")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 100)
public class AddItemServlet extends HttpServlet {

    ItemManager itemManager = new ItemManager();

    private static final String IMAGE_PATH ="C:\\Users\\Hoso\\Desktop\\Java project\\itemImage\\";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/itemAdd.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String title = req.getParameter("title");
        double price = Double.parseDouble(req.getParameter("price"));
        int categoryId = Integer.parseInt(req.getParameter("categoryName"));
        Part picPart = req.getPart("pic");

        String fileName = null;

        if (picPart.getSize() != 0) {
            long nanoTime = System.nanoTime();
            fileName = nanoTime + "_" + picPart.getSubmittedFileName();
            picPart.write(IMAGE_PATH + fileName);
        }
        User user = (User)req.getSession().getAttribute("user");
        int id = user.getId();

        Item item = Item.builder()
                .title(title)
                .price(price)
                .categoryId(categoryId)
                .picUrl(fileName)
                .userId(id)
                .build();
        itemManager.addItem(item);
        resp.sendRedirect("/item/show");
    }
}


package manager;

import db.DBConnectionProvider;
import model.Category;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CategoryManager {

    private Connection connection = DBConnectionProvider.getInstance().getConnection();

    public List<Category> getAll() {
        String catSql = "Select * from category";
        List<Category> categoryList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(catSql);
            while (resultSet.next()) {

                categoryList.add(getCategoryFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }

    private Category getCategoryFromResultSet(ResultSet resultSet) {
        Category category = new Category();
        try {
            category.setId(resultSet.getInt("id"));
            category.setCategoryName(resultSet.getString("name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }return category;

    }
}

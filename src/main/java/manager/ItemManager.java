package manager;

import db.DBConnectionProvider;
import model.Item;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemManager {

    private Connection connection = DBConnectionProvider.getInstance().getConnection();

    public void addItem(Item item) {


        String sql = "insert into item(title,price,category_id, pic_url,user_id) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, item.getTitle());
            ps.setDouble(2, item.getPrice());
            ps.setInt(3, item.getCategoryId());
            ps.setString(4, item.getPicUrl());
            ps.setInt(5, item.getUserId());
            ps.executeUpdate();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Item> getAll() {
        String sql = "select * from item";
        List<Item> itemList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                itemList.add(getUserFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return itemList;
    }


    private Item getUserFromResultSet(ResultSet resultSet) throws SQLException {
        Item item = new Item();
        item.setId(resultSet.getInt("id"));
        item.setTitle(resultSet.getString("title"));
        item.setPrice(resultSet.getDouble("price"));
        item.setCategoryId(resultSet.getInt("category_id"));
        item.setPicUrl(resultSet.getString("pic_url"));
        item.setUserId(resultSet.getInt("user_id"));

        return item;
    }

    public List<Item> getItemByCategory(int categoryId) {
        String sql = "select * from item where category_id =" + categoryId + " " + "LIMIT 20";
        List<Item> itemList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                itemList.add(getUserFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return itemList;
    }

    public List<Item> getLast() {
        String sql = "select * from item LIMIT 20";
        List<Item> itemList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                itemList.add(getUserFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return itemList;
    }

    public void edit(Item item) {
        String sql = "update item set title = ?,price = ? WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, item.getTitle());
            ps.setDouble(2, item.getPrice());
            ps.setInt(3, item.getId());


            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Item getById(int id) {
        String sql = "select * from item where id = " + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                return getUserFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void removeById(int id) {
        String sql = "delete from item where id = " + id;
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


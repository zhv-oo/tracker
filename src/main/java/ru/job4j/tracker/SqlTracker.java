package ru.job4j.tracker;


import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {

    private Connection cn;

    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement statement =
                     cn.prepareStatement("insert into items (id, name, date) values (?, ?, ?);")) {
            statement.setInt(1, item.getId());
            statement.setString(2, item.getName());
            statement.setDate(3, Date.valueOf(String.valueOf(item.getCreated())));
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean rsl = false;
        try (PreparedStatement statement =
                     cn.prepareStatement("update items set name = ?, date = ? where id = ?;")) {
            statement.setString(1, item.getName());
            statement.setDate(2, Date.valueOf(String.valueOf(item.getCreated())));
            statement.setString(2, item.getName());
            statement.execute();
            rsl = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public boolean delete(int id) {
        boolean rsl = false;
        try (PreparedStatement statement =
                     cn.prepareStatement("delete from items where id = ?;")) {
            statement.setString(1, String.valueOf(id));
            statement.execute();
            rsl = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public List<Item> findAll() {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement statement = cn.prepareStatement("select * from items")) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    items.add(new Item(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            Timestamp.valueOf(String.valueOf(resultSet.getDate("date")
                                    .toLocalDate())).toLocalDateTime()
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement statement =
                     cn.prepareStatement("select * from items where name = ?")) {
            statement.setString(1, key);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    items.add(new Item(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            Timestamp.valueOf(String.valueOf(resultSet.getDate("date")
                                    .toLocalDate())).toLocalDateTime()
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public Item findById(int id) {
        Item item = null;
        try (PreparedStatement statement =
                     cn.prepareStatement("select * from items where id = ?")) {
            statement.setString(1, String.valueOf(id));
            try (ResultSet resultSet = statement.executeQuery()) {
                item = new Item(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        Timestamp.valueOf(String.valueOf(resultSet.getDate("date")
                                .toLocalDate())).toLocalDateTime()
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }
}
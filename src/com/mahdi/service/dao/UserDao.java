package com.mahdi.service.dao;

import com.mahdi.service.model.DaoException;
import com.mahdi.service.model.Entity;
import com.mahdi.service.model.UserEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao extends Dao {

    public UserDao() throws Exception {

    }

    public boolean login(String username, String password) throws DaoException {
        String sql = "SELECT * FROM user WHERE username LIKE ? AND password LIKE ?";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            rs.last();
            if (rs.getRow() == 0)
                return false;
            else
                return true;
        } catch (SQLException e) {
            throw new DaoException(e);
        }

    }

    @Override
    public void create(Entity entity) throws SQLException {
        UserEntity bookEntity = (UserEntity) entity;
        String sql = "INSERT INTO user (username,password) VALUES(?,?);";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, bookEntity.getUsername());
        ps.setString(2, bookEntity.getPassword());
        ps.executeUpdate();
    }

    @Override
    public Entity read(int id) throws SQLException {
        String sql = "SELECT * FROM user WHERE id=?;";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        int idBook = rs.getInt("id");
        String username = rs.getString("username");
        String password = rs.getString("password");
        return new UserEntity(idBook, username, password);
    }

    @Override
    public void update(Entity entity) throws SQLException {
        UserEntity bookEntity = (UserEntity) entity;
        String sql = "UPDATE user SET username=?,password=? WHERE id=?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, bookEntity.getUsername());
        ps.setString(2, bookEntity.getPassword());
        ps.setInt(3, bookEntity.getId());
        ps.executeUpdate();
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM user WHERE id=?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public Entity[] readAll() throws SQLException {
        String sql = "SELECT * FROM user";
        UserEntity[] be = null;

        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        rs.last();// move to last row
        be = new UserEntity[rs.getRow()]; // get row count
        rs.beforeFirst(); // move to first row
        int i = 0;
        while (rs.next()) {
            int idBook = rs.getInt("id");
            String username = rs.getString("username");
            String password = rs.getString("password");
            be[i] = new UserEntity(idBook, username, password);
            i++;
        }
        return be;
    }

    @Override
    public void empty() throws SQLException {
        String sql = "DELETE FROM user";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.executeUpdate();
    }
}

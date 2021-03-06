package com.mahdi.service.dao;



import com.mahdi.service.model.Entity;

import java.sql.SQLException;

public interface Crud {

    void create(Entity entity) throws SQLException;

    Entity read(int id)throws SQLException;

    void update(Entity entity)throws SQLException;

    void delete(int id)throws SQLException;

    Entity[] readAll()throws SQLException;

    void empty()throws SQLException;
}

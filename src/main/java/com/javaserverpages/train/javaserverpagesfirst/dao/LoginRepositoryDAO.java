package com.javaserverpages.train.javaserverpagesfirst.dao;

import com.javaserverpages.train.javaserverpagesfirst.conn.SingleConnectionDataBase;
import com.javaserverpages.train.javaserverpagesfirst.model.ModelLogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginRepositoryDAO {

    private final Connection connection;

    public LoginRepositoryDAO() {
        this.connection = SingleConnectionDataBase.getConnection();
    }

    public boolean validateAuthentication(final ModelLogin modelLogin) throws Exception {
        String sql = "SELECT login, pass FROM model_login WHERE login = ? AND pass = ?";


        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, modelLogin.getLogin());
        statement.setString(2, modelLogin.getPassword());

        ResultSet resultSet = statement.executeQuery();

        return resultSet.next();
    }
}

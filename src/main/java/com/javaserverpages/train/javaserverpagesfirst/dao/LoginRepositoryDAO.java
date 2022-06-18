package com.javaserverpages.train.javaserverpagesfirst.dao;

import com.javaserverpages.train.javaserverpagesfirst.conn.SingleConnectionDataBase;
import com.javaserverpages.train.javaserverpagesfirst.model.ModelLogin;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginRepositoryDAO implements Serializable {
    private static final long serialVersionUID = 1L;

    private final Connection connection;

    public LoginRepositoryDAO() {
        this.connection = SingleConnectionDataBase.getConnection();
    }

    public boolean validateAuthentication(ModelLogin modelLogin) throws Exception {
        String sql = "SELECT * FROM model_login WHERE login = ? AND password = ?";


        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, modelLogin.getLogin());
        statement.setString(2, modelLogin.getPassword());

        ResultSet resultSet = statement.executeQuery();

        return resultSet.next();
    }
}

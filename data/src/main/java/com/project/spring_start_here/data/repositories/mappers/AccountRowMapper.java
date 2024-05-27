package com.project.spring_start_here.data.repositories.mappers;

import com.project.spring_start_here.data.model.Account;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper<Account> {

    @Override
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account a = new Account();
        a.setId(resultSet.getInt("id"));
        a.setName(resultSet.getString("name"));
        a.setAmount(resultSet.getBigDecimal("amount"));
        return a;
    }

}

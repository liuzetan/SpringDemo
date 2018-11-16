package com.dao;

import com.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;

@Repository
public class JdbcDataDaoImpl implements JdbcDataDao {

    @Autowired(required = true)
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addUser(User user) {
//        initClassPathXmlApplication();
        String sql = "insert into testuser(name, age, lengthOfDick, sex) " + "values (?,?,?,?)";
        Object[] params = {user.getName(), user.getAge(), user.getLengthOfDick(), user.getSex()};
        int[] types = {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
        jdbcTemplate.update(sql, params, types);
    }
}

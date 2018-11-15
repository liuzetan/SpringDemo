package com.dao;

import com.bean.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;

@Repository("jdbcDataDAO")
public class JdbcDataDaoImpl implements JdbcDataDao {

    private JdbcTemplate jdbcTemplate;

    public void initClassPathXmlApplication () {
        if (jdbcTemplate == null) {
            ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("database.xml");
            jdbcTemplate = (JdbcTemplate) cpx.getBean("jdbcTemplate");
        }
    }

    @Override
    public void addUser(User user) {
        initClassPathXmlApplication();
        String sql = "insert into testuser(name, age, lengthOfDick, sex) " + "values (?,?,?,?)";
        Object[] params = {user.getName(), user.getAge(), user.getLengthOfDick(), user.getSex()};
        int[] types = {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
        jdbcTemplate.update(sql, params, types);
    }
}

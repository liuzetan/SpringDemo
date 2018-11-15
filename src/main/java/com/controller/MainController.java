package com.controller;

import com.bean.User;
import com.dao.JdbcDataDaoImpl;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class MainController {
    @Resource
    private JdbcDataDaoImpl jdbcDataDAO;
    public void setJdbcDataDAO(JdbcDataDaoImpl jdbcDataDAO) {
        this.jdbcDataDAO = jdbcDataDAO;
    }


    @RequestMapping("/test")
    public String Test() {
        return "Abcde";
    }

    @RequestMapping(value = "/abc", method = RequestMethod.POST)
    public String post(@RequestParam(value = "a") String a, @RequestParam(value = "b") String b) {
        return a + " and " + b;
    }

    @RequestMapping(value = "/abdc", method = RequestMethod.POST)
    public String post(@RequestBody String b) {
        return "abcd" + b;
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public String addUser(@RequestBody String string) {
        User user = new Gson().fromJson(string, User.class);
        System.out.println(user);
//        user.setName((String) bean.get("name"));
//        user.setAge((String) bean.get("age"));
//        user.setLengthOfDick((String) bean.get("lengthOfDick"));
//        user.setSex((String) bean.get("sex"));
        jdbcDataDAO.addUser(user);
        return user.toString();
    }
}

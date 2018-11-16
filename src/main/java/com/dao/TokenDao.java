package com.dao;

import com.bean.TokenBean;

public interface TokenDao {

    /**
     * 登录或注册时写入token
     *
     * @param tokenBean
     */
    void saveOrUpdageToken(TokenBean tokenBean);

    /**
     * 根据电话号码获取token
     *
     * @param phone
     * @return
     */
    TokenBean isTokenAvailable(String phone);

}

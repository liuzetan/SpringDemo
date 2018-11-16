package com.dao;

import com.bean.TokenBean;

import java.util.ArrayList;
import java.util.List;

public class TokenDaoImpl implements TokenDao {
    List<TokenBean> list = new ArrayList<>();
    @Override
    public void saveOrUpdageToken(TokenBean tokenBean) {
        list.add(tokenBean);
    }

    @Override
    public TokenBean isTokenAvailable(String phone) {

        return null;
    }
}

package com.cj.crm.settings.dao;

import com.cj.crm.settings.domain.User;

import java.util.Map;

public interface UserDao {
    User login(Map<String, String> map);
}

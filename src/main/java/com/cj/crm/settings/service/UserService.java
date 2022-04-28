package com.cj.crm.settings.service;

import com.cj.crm.Exception.loginException;
import com.cj.crm.settings.domain.User;

public interface UserService {
    User login(String loginName, String loginPwd, String ip) throws loginException;
}

package com.cj.crm.settings.service.Impl;

import com.cj.crm.Exception.loginException;
import com.cj.crm.settings.dao.UserDao;
import com.cj.crm.settings.domain.User;
import com.cj.crm.settings.service.UserService;
import com.cj.crm.utils.DateTimeUtil;
import com.cj.crm.utils.SqlSessionUtil;

import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao userDao = SqlSessionUtil.getSqlSession().getMapper(UserDao.class);

    @Override
    public User login(String loginName, String loginPwd, String ip) throws loginException {
        Map<String, String> map = new HashMap<>();
        map.put("loginName",loginName);
        map.put("loginPwd",loginPwd);

        User user = userDao.login(map);

        if(user==null){
            throw new loginException("账号密码错误");
        }

        String expireTime = user.getExpireTime();
        String currentTime = DateTimeUtil.getSysTime();
        if(expireTime.compareTo(currentTime)<0){
            throw new loginException("过期了");
        }

        String lockState = user.getLockState();
        if ("0".equals(lockState)){
            throw new loginException("账号被锁定");
        }

        String allowIp = user.getAllowIps();
        if(!allowIp.contains(ip)){
            throw new loginException("ip受限制");
        }
        return user;
    }
}

package com.lixingyuan.crm.setings.service.Impl;

import com.lixingyuan.crm.setings.dao.UserDao;
import com.lixingyuan.crm.setings.service.UserService;
import com.lixingyuan.crm.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class UserServiceImpl implements UserService {
    private UserDao userDao = SqlSessionUtil.getSqlSession().getMapper(UserDao.class);
}

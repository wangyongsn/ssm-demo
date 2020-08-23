package com.xwtec.service.impl;

import com.xwtec.dao.UserMapper;
import com.xwtec.dataSource.DataSource;
import com.xwtec.service.ISalveUserService;
import com.xwtec.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2020/8/22.
 */
@Service
@DataSource("dataSource")
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Map<String, Object>> qryUser() {
        return userMapper.qryUser();
    }
}
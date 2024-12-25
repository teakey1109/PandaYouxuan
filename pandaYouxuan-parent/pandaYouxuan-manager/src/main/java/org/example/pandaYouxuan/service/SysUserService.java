package org.example.pandaYouxuan.service;

import org.example.dto.system.LoginDto;
import org.example.vo.system.LoginVo;

public interface SysUserService {

    /**
     * 根据用户名查询用户数据
     * @param loginDto 登录用户信息
     * @return LoginVo 用户登录结果类
     */
    public LoginVo login(LoginDto loginDto);
}

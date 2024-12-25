package org.example.pandaYouxuan.service.impl;

import com.alibaba.fastjson.JSON;
import org.example.dto.system.LoginDto;
import org.example.entity.system.SysUser;
import org.example.exception.PandaException;
import org.example.pandaYouxuan.mapper.SysUserMapper;
import org.example.pandaYouxuan.service.SysUserService;
import org.example.vo.common.ResultCodeEnum;
import org.example.vo.system.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public LoginVo login(LoginDto loginDto) {

        // 根据用户名查询用户
        SysUser sysUser = sysUserMapper.selectByUserName(loginDto.getUserName());
        if (sysUser == null) {
            throw new PandaException(ResultCodeEnum.LOGIN_ERROR);
        }

        // 验证密码是否正确
        String inputPassword = loginDto.getPassword();
        String md5InputPassword = DigestUtils.md5DigestAsHex(inputPassword.getBytes());
        if (!md5InputPassword.equals(sysUser.getPassword())) {
            throw new PandaException(ResultCodeEnum.LOGIN_ERROR);
        }

        // 生成令牌, 保存数据到Redis中
        String token = UUID.randomUUID().toString().replace("-", "");
        redisTemplate.opsForValue().set("user:login:" + token, JSON.toJSONString(sysUser), 30, TimeUnit.MINUTES);

        // 构建响应结果对象
        LoginVo loginVo = new LoginVo();
        loginVo.setToken(token);
        loginVo.setRefresh_token("");
        return loginVo;
    }
}

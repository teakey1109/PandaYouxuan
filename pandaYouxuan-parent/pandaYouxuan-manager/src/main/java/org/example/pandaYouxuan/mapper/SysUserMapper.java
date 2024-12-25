package org.example.pandaYouxuan.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.entity.system.SysUser;

@Mapper
public interface SysUserMapper {

    /**
     * 根据用户名查询用户数据
     * @param username 用户名
     * @return SysUser
     */
    public SysUser selectByUserName(String username);
}

package com.raxcl.blog.service;

import com.raxcl.blog.dao.pojo.SysUser;
import com.raxcl.blog.vo.Result;

public interface SysUserService {
    SysUser findUserById(Long id);

    SysUser findUser(String account, String pwd);

    Result getUserInfoByToken(String token);

    SysUser findUserByAccount(String account);

    void save(SysUser sysUser);
}

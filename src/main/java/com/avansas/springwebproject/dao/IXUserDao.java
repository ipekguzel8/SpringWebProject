package com.avansas.springwebproject.dao;

import com.avansas.springwebproject.dto.UserDto;
import com.avansas.springwebproject.entities.XUser;

import java.util.List;

public interface IXUserDao {
    public List<XUser> findAll();
    public void delete(XUser user);
    public void save(XUser user);
    public XUser getById(Long id);
    public XUser loginAut(UserDto userDto);
}

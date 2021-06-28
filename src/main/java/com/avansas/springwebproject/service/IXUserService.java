package com.avansas.springwebproject.service;

import com.avansas.springwebproject.dto.UserDto;
import com.avansas.springwebproject.entities.XUser;

import java.util.List;

public interface IXUserService {
    public List<XUser> findAll();
    public void delete(XUser user);
    public void save(XUser user);
    public XUser getById(Long id);
    public XUser loginAuth(UserDto userDto);
}

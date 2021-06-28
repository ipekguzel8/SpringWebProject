package com.avansas.springwebproject.service;

import com.avansas.springwebproject.dao.BaseDao;
import com.avansas.springwebproject.dao.IXUserDao;
import com.avansas.springwebproject.dao.XUserDao;
import com.avansas.springwebproject.dto.UserDto;
import com.avansas.springwebproject.entities.BaseEntity;
import com.avansas.springwebproject.entities.XUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class XUserService extends BaseService<XUser, XUserDao> implements IXUserService {

    @Autowired
    public XUserService(XUserDao userDao) {
        super(userDao);
    }

    @Transactional
    public List<XUser> getAll() {
        return this.dao.findAll();
    }

    @Transactional
    public void add(XUser user) {
        this.dao.save(user);
    }

    @Transactional
    public void delete(XUser user) {
        this.dao.delete(user);
    }

    @Transactional
    public XUser getById(Long id) {
       return this.dao.getById(id);
    }

    @Override
    @Transactional
    public XUser loginAuth(UserDto userDto) {
        return this.dao.loginAut(userDto);
    }

}

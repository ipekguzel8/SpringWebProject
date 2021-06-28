package com.avansas.springwebproject.dao;

import com.avansas.springwebproject.dto.UserDto;
import com.avansas.springwebproject.entities.XUser;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class XUserDao extends BaseDao<XUser> implements IXUserDao {
    @Autowired
    private EntityManager entityManager;
    public XUserDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public XUser loginAut(UserDto userDto) {
        Session session = entityManager.unwrap(Session.class);
        Query query = entityManager.createQuery("SELECT user FROM XUser user WHERE user.name = :name and user.password= :password");
        query.setParameter("name",userDto.getName());
        query.setParameter("password",userDto.getPassword());
        List resultList = query.getResultList();
        return (XUser) resultList.get(0);
    }
}

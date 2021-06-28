package com.avansas.springwebproject.dao;

import com.avansas.springwebproject.entities.BaseEntity;
import com.avansas.springwebproject.entities.XUser;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Getter
@Setter
@Repository
public class BaseDao <J extends BaseEntity> {
    private J j;
    @Autowired
    private EntityManager entityManager;
    private Class<J> xUserClass;
    public BaseDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public void save(J entity) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(entity);
    }

    public void delete(J entity) {
        Session session = entityManager.unwrap(Session.class);
        J userToDelete = (J) session.get(XUser.class, entity.getId());
        session.delete(userToDelete);
    }
    public List<J> findAll() {
        Session session = entityManager.unwrap(Session.class);
        List<J> filmActor = session.createQuery("from "+XUser.class.getSimpleName()).getResultList();
        return filmActor;
    }
    public J getById(Long id) {
        Session session = entityManager.unwrap(Session.class);
        XUser user = session.get(XUser.class, id);
        return (J) user;
    }
}

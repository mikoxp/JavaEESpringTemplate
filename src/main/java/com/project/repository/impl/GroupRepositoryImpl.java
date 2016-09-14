package com.project.repository.impl;

import com.project.entities.Group;
import com.project.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * @author moles
 */
@Repository
public class GroupRepositoryImpl implements GroupRepository {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    /**
     * @param id id
     * @return group
     */
    @Override
    public Group getForId(int id) {
        Group group = null;
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            group = entityManager.find(Group.class, id);
            entityManager.getTransaction().commit();
        } catch (Exception e) {

        } finally {
            entityManager.close();
        }
        return group;
    }

    /**
     * @return group list
     */
    @Override
    public List<Group> getAll() {
        List<Group> groups = null;
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("SELECT e FROM Group e ");
            groups = new ArrayList<>(query.getResultList());
            entityManager.getTransaction().commit();
        } catch (Exception e) {

        } finally {
            entityManager.close();
        }
        return groups;
    }

    /**
     * @param group
     * @return result
     */
    @Override
    public Boolean update(Group group) {
        return null;
    }
}

package com.project.repository;

import com.project.entities.Group;

import java.util.List;

/**
 * @author moles
 */
public interface GroupRepository {
    /**
     * @param id id
     * @return group
     */
    public Group getForId(int id);

    /**
     * @return groupList
     */
    public List<Group> getAll();


    /**
     * @param group
     * @return result
     */
    public Boolean update(Group group);
}

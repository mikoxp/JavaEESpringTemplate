package com.project.controllerRest;

import com.project.entities.Group;
import com.project.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * rest controller for group data
 *
 * @author moles
 */
@RestController
@RequestMapping("/group")
public class GroupController {
    @Autowired
    private GroupRepository groupRepository;

    /**
     * @return group list
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Group> getAll() {
        return groupRepository.getAll();
    }

}

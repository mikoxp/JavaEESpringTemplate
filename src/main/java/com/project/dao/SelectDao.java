package com.project.dao;

import java.util.List;

/**
 * Created by moles on 03.08.2016.
 *
 * @author moles
 */
public class SelectDao {
    List<Integer> ids;
    int action;

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}

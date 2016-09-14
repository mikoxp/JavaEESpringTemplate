package com.project.dao;

/**
 * Created by moles on 03.08.2016.
 *
 * @author moles
 */
public class MassageDao {
    int code;
    String massage;

    public MassageDao() {
        this.code = 0;
        this.massage = "";
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}

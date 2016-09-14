package com.project.dao;

/**
 * Created by seo on 28.07.2016.
 * Dao used to response
 *
 * @author moles
 */
public class Dao<T> {
    private T value;

    public Dao(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
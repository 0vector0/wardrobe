package com.github.mykhalechko.wardrobe.dao;

import com.github.mykhalechko.wardrobe.models.Item;

import java.io.Serializable;


public class ItemDao<E extends Serializable> extends AbstractDao<E> {

    public ItemDao() {
        super();
        setClazz((Class<E>) Item.class);
    }
}

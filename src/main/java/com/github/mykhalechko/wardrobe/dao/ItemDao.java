package com.github.mykhalechko.wardrobe.dao;

import java.io.Serializable;


public class ItemDao<Item extends Serializable> extends AbstractDao<Item> {

    public ItemDao() {
        super();
        setClazz((Class<Item>) com.github.mykhalechko.wardrobe.models.Item.class);
    }
}

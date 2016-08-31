package com.github.mykhalechko.wardrobe.dao;

import com.github.mykhalechko.wardrobe.models.Consumer;

import java.io.Serializable;


public class ConsumerDao<E extends Serializable> extends AbstractDao<E> {

    public ConsumerDao() {
        super();
        setClazz((Class<E>) Consumer.class);
    }
}

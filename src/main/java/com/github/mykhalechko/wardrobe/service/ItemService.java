package com.github.mykhalechko.wardrobe.service;


import com.github.mykhalechko.wardrobe.dao.ItemDao;
import com.github.mykhalechko.wardrobe.models.Item;

import java.util.List;

public class ItemService {

    private static ItemDao itemDao;

    public ItemService() {
        itemDao = new ItemDao();
    }

    public void persist(Item entity) {
        itemDao.persist(entity);
    }

    public void update(Item entity) {
        itemDao.update(entity);
    }

    public Item findById(String id) {
        Item item = (Item) itemDao.findById(id);
        return item;
    }

    public void delete(String id) {
        Item item = (Item) itemDao.findById(id);
        itemDao.delete(item);
    }

    public List<Item> findAll() {
        List<Item> items = itemDao.findAll();
        return items;
    }


    public ItemDao itemDao() {
        return itemDao;
    }

}

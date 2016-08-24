package com.github.mykhalechko.wardrobe.service;


import com.github.mykhalechko.wardrobe.dao.ItemDao;
import com.github.mykhalechko.wardrobe.models.Item;

import java.util.List;

public class ItemService {

    private static ItemDao itemDao;

    public ItemService() {
        itemDao = new ItemDao();
    }

    public  void persist(Item entity) {
        itemDao.openCurrentSessionwithTransaction();
        itemDao.persist(entity);
        itemDao.closeCurrentSessionwithTransaction();
    }

    public void update(Item entity) {
        itemDao.openCurrentSessionwithTransaction();
        itemDao.update(entity);
        itemDao.closeCurrentSessionwithTransaction();
    }

    public Item findById(String id) {
        itemDao.openCurrentSession();
        Item item = itemDao.findById(id);
        itemDao.closeCurrentSession();
        return item;
    }

    public void delete(String id) {
        itemDao.openCurrentSessionwithTransaction();
        Item item = itemDao.findById(id);
        itemDao.delete(item);
        itemDao.closeCurrentSessionwithTransaction();
    }

    public List<Item> findAll() {
        itemDao.openCurrentSession();
        List<Item> items = itemDao.findAll();
        itemDao.closeCurrentSession();
        return items;
    }

    public void deleteAll() {
        itemDao.openCurrentSessionwithTransaction();
        itemDao.deleteAll();
        itemDao.closeCurrentSessionwithTransaction();
    }

    public ItemDao itemDao() {
        return itemDao;
    }

}

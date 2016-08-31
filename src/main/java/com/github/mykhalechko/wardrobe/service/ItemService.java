package com.github.mykhalechko.wardrobe.service;


import com.github.mykhalechko.wardrobe.dao.ItemDao;
import com.github.mykhalechko.wardrobe.models.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("itemService")
public class ItemService {

    private static ItemDao<Item> itemDao;

    public ItemService() {
        itemDao = new ItemDao<Item>();
    }

    public void persist(Item entity) {
        itemDao.persist(entity);
    }

    public void update(Item entity) {
        itemDao.update(entity);
    }

    public Item findById(String id) {
        return itemDao.findById(id);
    }

    public void delete(String id) {
        Item item = itemDao.findById(id);
        itemDao.delete(item);
    }

    public List<Item> findAll() {
        return itemDao.findAll();
    }

    public ItemDao<Item> itemDao() {
        return itemDao;
    }

}

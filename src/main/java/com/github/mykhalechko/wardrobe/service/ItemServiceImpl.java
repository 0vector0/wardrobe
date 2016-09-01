package com.github.mykhalechko.wardrobe.service;


import com.github.mykhalechko.wardrobe.dao.ItemDao;
import com.github.mykhalechko.wardrobe.dao.ItemDaoImpl;
import com.github.mykhalechko.wardrobe.models.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private ItemDao itemDao;

    public ItemServiceImpl() {
        this.itemDao = new ItemDaoImpl();
    }

    public void addItem(Item item) {
        itemDao.addItem(item);
    }

    public void updateItem(Item item) {
        itemDao.updateItem(item);
    }

    public void removeItem(int id) {
        itemDao.removeItem(id);
    }

    public Item getItemById(int id) {
        return itemDao.getItemById(id);
    }

    public List<Item> listItems() {
        return itemDao.listItems();
    }
}

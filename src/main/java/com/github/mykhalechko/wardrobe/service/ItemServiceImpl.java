package com.github.mykhalechko.wardrobe.service;


import com.github.mykhalechko.wardrobe.dao.ItemDao;
import com.github.mykhalechko.wardrobe.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
//   TODO дописать private
    private ItemDao itemDao;


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

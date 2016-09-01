package com.github.mykhalechko.wardrobe.service;

import com.github.mykhalechko.wardrobe.models.Item;

import java.util.List;

public interface ItemService {
    public void addItem(Item item);

    public void updateItem(Item item);

    public void removeItem(int id);

    public Item getItemById(int id);

    public List<Item> liItems();
}

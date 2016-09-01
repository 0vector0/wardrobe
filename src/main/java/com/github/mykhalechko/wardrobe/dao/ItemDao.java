package com.github.mykhalechko.wardrobe.dao;

import com.github.mykhalechko.wardrobe.models.Item;

import java.util.List;

public interface ItemDao  {

    public void addItem(Item item);

    public void updateItem(Item item);

    public void removeItem(int id);

    public Item getItemById(int id);

    public List<Item> listItems();

}

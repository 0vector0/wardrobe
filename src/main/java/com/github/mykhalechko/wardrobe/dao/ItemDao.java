package com.github.mykhalechko.wardrobe.dao;

import com.github.mykhalechko.wardrobe.models.Item;

import java.util.List;

/**
 * Created by vector on 01.09.2016.
 */
public interface ItemDao  {

    public void addItem(Item item);

    public void updateItem(Item item);

    public void removeItem(int id);

    public Item getItemById(int id);

    public List<Item> liItems();

}

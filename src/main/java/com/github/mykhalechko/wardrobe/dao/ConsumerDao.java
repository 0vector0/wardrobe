package com.github.mykhalechko.wardrobe.dao;

import com.github.mykhalechko.wardrobe.models.Consumer;

import java.util.List;

public interface ConsumerDao {

    public void addConsumer(Consumer consumer);

    public void updateConsumer(Consumer consumer);

    public void removeConsumer(int id);

    public Consumer getConsumerById(int id);

    public List<Consumer> liConsumers();

}

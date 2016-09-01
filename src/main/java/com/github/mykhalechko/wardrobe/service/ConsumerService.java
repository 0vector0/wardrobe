package com.github.mykhalechko.wardrobe.service;


import com.github.mykhalechko.wardrobe.dao.ConsumerDao;
import com.github.mykhalechko.wardrobe.models.Consumer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumerService {

    private static ConsumerDao<Consumer> consumerDao;

    public ConsumerService() {
        consumerDao = new ConsumerDao<Consumer>();
    }

    public void add(Consumer entity) {
        consumerDao.add(entity);
    }

    public void update(Consumer entity) {
        consumerDao.update(entity);
    }

    public Consumer findById(String id) {
        return consumerDao.findById(id);
    }

    public void delete(String id) {
        Consumer consumer = consumerDao.findById(id);
        consumerDao.delete(consumer);
    }

    public List<Consumer> findAll() {
        return consumerDao.findAll();
    }

    public ConsumerDao<Consumer> consumerDao() {
        return consumerDao;
    }

}

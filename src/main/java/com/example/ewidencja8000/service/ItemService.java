package com.example.ewidencja8000.service;

import com.example.ewidencja8000.model.Item;
import com.example.ewidencja8000.repository.IItemDAO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService implements IItemService {

    @Autowired
    private final IItemDAO itemDAO;
    public ItemService(IItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }
    @Override
    @Transactional
    public Optional<Item> getById(int id) {
        return this.itemDAO.getById(id);
    }
    @Override
    @Transactional
    public List<Item> getAll() {
        return this.itemDAO.getAll();
    }
    @Transactional
    public void saveOrUpdate(Item item) {
        this.itemDAO.saveOrUpdate(item);
    }
    @Override
    @Transactional
    public void delete(int id){
        itemDAO.delete(id);
    }

    @Override
    @Transactional
    public List<Item> getByCurrentPlace(String place)
    {
        return this.itemDAO.getByCurrentPlace(place);
    }

    @Override
    @Transactional
    public List<Item> getByOriginPlace(String origin)
    {
        return this.itemDAO.getByOriginPlace(origin);
    }

    @Override
    @Transactional
    public Optional<Item> getBySerial(String serial)
    {
        return this.itemDAO.getBySerial(serial);
    }

}
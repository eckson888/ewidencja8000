package com.example.ewidencja8000.service;

import com.example.ewidencja8000.model.Item;

import java.util.List;
import java.util.Optional;

public interface IItemService {
    void saveOrUpdate(Item item);
    Optional<Item> getById(int id);
    Optional<Item> getBySerial(String serial);
    List<Item> getByCurrentPlace(String place);
    List<Item> getByOriginPlace(String place);
    List<Item> getAll();
    void delete(int id);
}
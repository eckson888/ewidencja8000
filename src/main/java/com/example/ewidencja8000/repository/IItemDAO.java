package com.example.ewidencja8000.repository;

import com.example.ewidencja8000.model.Item;

import java.util.List;
import java.util.Optional;

public interface IItemDAO {
    Optional<Item> getById(int id);
    Optional<Item> getBySerial(String serial);
    List<Item> getAll();
    void saveOrUpdate(Item item);
    void delete(int id);
    List<Item> getByCurrentPlace(String place);
    List<Item> getByOriginPlace(String place);
}

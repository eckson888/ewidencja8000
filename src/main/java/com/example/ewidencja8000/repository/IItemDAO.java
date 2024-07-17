package com.example.ewidencja8000.repository;

import com.example.ewidencja8000.model.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IItemDAO {
    Optional<Item> getById(int id);
//    Optional<Item> getBySerial(String serial);
    List<Item> getAll();
    void saveOrUpdate(Item item);
    void delete(int id);
//    List<Item> getByCurrentPlace(String place);
//    List<Item> getByOriginPlace(String place);

//
//    @Query(value = "SELECT * FROM item i WHERE" +
//            " i.brand LIKE %:keyword% OR" +
//            " i.model LIKE %:keyword% OR" +
//            " i.serial LIKE %:keyword% OR" +
//            " i.current LIKE %:keyword% OR" +
//            " i.origin LIKE %:keyword% OR" +
//            " i.responsible LIKE %:keyword%",
//            nativeQuery = true)
    List<Item> findByKeyword(String keyword);
}

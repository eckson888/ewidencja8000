package com.example.ewidencja8000.repository;

import com.example.ewidencja8000.model.Item;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ItemDAO implements IItemDAO {

    private final String GET_BY_ID_JPQL = "SELECT i FROM com.example.ewidencja8000.model.Item i WHERE i.id = :id";

    private final String SEARCH_BY_ALL =
            "SELECT i FROM com.example.ewidencja8000.model.Item i WHERE" +
            " i.brand LIKE '%' || :keyword || '%' OR" +
            " i.model LIKE '%' || :keyword || '%' OR" +
            " i.serial LIKE '%' || :keyword || '%' OR" +
            " i.current LIKE '%' || :keyword || '%' OR" +
            " i.origin LIKE '%' || :keyword || '%' OR" +
            " i.responsible LIKE '%' || :keyword || '%'";
    @PersistenceContext
    private EntityManager entityManager;
    private final String GET_ALL_JPQL = "FROM com.example.ewidencja8000.model.Item";

    public ItemDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public Optional<Item> getById(int id) {
        TypedQuery<Item> query = entityManager.createQuery(GET_BY_ID_JPQL, Item.class);
        query.setParameter("id", id);
        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
//    }
//
//
//    @Override
//    public Optional<Item> getBySerial(String serial) {
//        TypedQuery<Item> query = entityManager.createQuery(GET_BY_SERIAL, Item.class);
//        query.setParameter("serial", serial);
//        try {
//            return Optional.of(query.getSingleResult());
//        } catch (NoResultException e) {
//            return Optional.empty();
//        }
//    }
//

    @Override
    public List<Item> getAll() {
        TypedQuery<Item> query = entityManager.createQuery(GET_ALL_JPQL, Item.class);
        List<Item> result = query.getResultList();
        return result;
    }

    @Override
    public void saveOrUpdate(Item item) {
        System.out.println("ITEM " + item);
        if (getById(item.getId()).isEmpty()) {
            entityManager.persist(item);
        } else {
            entityManager.merge(item);
        }
    }


    @Override
    public void delete(int id) {
        Item item = getById(id).orElse(null);
        if (item != null) {
            entityManager.remove(item);
        }
    }


    @Override
    public List<Item> findByKeyword(String keyword) {
        TypedQuery<Item> query = entityManager.createQuery(SEARCH_BY_ALL, Item.class);
        query.setParameter("keyword", keyword.toUpperCase());
        try {
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

}

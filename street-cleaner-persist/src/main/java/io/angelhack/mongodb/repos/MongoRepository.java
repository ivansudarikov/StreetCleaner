package io.angelhack.mongodb.repos;

import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;

/**
 * @author amylniko
 */
public class MongoRepository<E,K>  {

    @Autowired
    private Datastore datastore;

    private Class<E> classType;

    public void save(E entity) {
        datastore.save(entity);
    }

    public List<E> findAll() {
        return datastore.find(classType).asList();
    }

    public MongoRepository(Class<E> entityClass) {
        this.classType = entityClass;
    }

    public void delete(E entity) {
        datastore.delete(entity);
    }

    public E find(K key) {
        return datastore.find(classType,"_id",key).get();
    }

    public E findOneByField(String fieldName, Object keyValue) {
        return datastore.find(classType,fieldName,keyValue).get();
    }

    public Collection<E> findByField(String fieldName, Object keyValue) {
        return datastore.find(classType,fieldName,keyValue).asList();
    }

}

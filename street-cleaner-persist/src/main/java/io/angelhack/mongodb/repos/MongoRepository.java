package io.angelhack.mongodb.repos;

import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;

/**
 * Abstract class for all repos.
 * Contains datastore and default methods.
 *
 * @author amylniko
 */
public abstract class MongoRepository<E,K>  {

    /**
     * Morphia datastore. Used to create queries.
     * Contains connection to MongoDB
     */
    @Autowired
    protected Datastore datastore;

    /**
     * Entity class.
     */
    protected Class<E> classType;

    /**
     * Default method for save entity.
     *
     * @param entity entity to be saved
     */
    public void save(E entity) {
        datastore.save(entity);
    }

    /**
     * Default method, which finds all entities in collection.
     *
     * @return all entities in collection
     */
    public List<E> findAll() {
        return datastore.find(classType).asList();
    }

    /**
     * Public constructor. Need to be passed entity class for default methods implemetation.
     * @param entityClass entity class
     */
    public MongoRepository(Class<E> entityClass) {
        this.classType = entityClass;
    }

    /**
     * Default method for removing entity from collection.
     *
     * @param entity entity to be removed
     */
    public void delete(E entity) {
        datastore.delete(entity);
    }

    /**
     * Default method for getting entity by entity ID (unique).
     *
     * @param key entity ID
     * @return entity if it exists in collection, otherwise null
     */
    public E find(K key) {
        return datastore.find(classType,"id",key).get();
    }

    /**
     * Default method for getting one entity from collection by given field
     *
     * @param fieldName field to compare
     * @param keyValue field's to compare value
     * @return entity if it exists in collection, otherwise null
     */
    public E findOneByField(String fieldName, Object keyValue) {
        return datastore.find(classType,fieldName,keyValue).get();
    }

    /**
     * Default method for getting entities from collection by given field
     *
     * @param fieldName field to compare
     * @param keyValue field's to compare value
     * @return entities if it exists in collection, otherwise null
     */
    public Collection<E> findByField(String fieldName, Object keyValue) {
        return datastore.find(classType,fieldName,keyValue).asList();
    }

}

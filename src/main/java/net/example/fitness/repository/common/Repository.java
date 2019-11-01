package net.example.fitness.repository.common;

import net.example.fitness.model.common.Entity;

import java.util.Collection;

public interface Repository<T extends Entity> {
    boolean create(T entity);

    T read(Long id);

    Collection<T> readAll();

    boolean update(T bodyParameters);

    boolean delete(Long id);
}

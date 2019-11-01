package net.example.fitness.repository;

import net.example.fitness.model.BodyParameters;
import net.example.fitness.repository.common.Repository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Service
public class BodyRepository implements Repository<BodyParameters> {

    private ConcurrentMap<Long, BodyParameters> repository = new ConcurrentHashMap<>();

    @Override
    public boolean create(BodyParameters bodyParameters) {
        repository.put(bodyParameters.getId(), bodyParameters);
        return true;
    }

    @Override
    public BodyParameters read(Long id) {
        return repository.get(id);
    }

    @Override
    public Collection<BodyParameters> readAll() {
        return repository.values();
    }

    @Override
    public boolean update(BodyParameters bodyParameters) {
        if (repository.containsKey(bodyParameters.getId())) {
            repository.put(bodyParameters.getId(), bodyParameters);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return repository.remove(id) != null;
    }
}


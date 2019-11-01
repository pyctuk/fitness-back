package net.example.fitness.rest;

import net.example.fitness.model.BodyParameters;
import net.example.fitness.repository.common.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.OK;

@RestController
public class BodyRest {

    private Repository<BodyParameters> repository;

    @Autowired
    public BodyRest(Repository<BodyParameters> repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<String> create(BodyParameters bodyParameters) {
        if (repository.create(bodyParameters)) {
            return new ResponseEntity<>("Parameter added", OK);
        }
        return new ResponseEntity<>("Some troubles", INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value = "/read/{id}", method = RequestMethod.GET)
    public ResponseEntity<BodyParameters> read(Long id) {
        return new ResponseEntity<>(repository.read(id), OK);
    }

    @RequestMapping(value = "/readAll", method = RequestMethod.GET)
    public ResponseEntity<Collection<BodyParameters>> readAdd() {
        return new ResponseEntity<>(repository.readAll(), OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<String> update(BodyParameters bodyParameters) {
        if (repository.update(bodyParameters)) {
            return new ResponseEntity<>("Update successful", OK);
        }
        return new ResponseEntity<>("Some troubles while updating", INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(Long id) {
        if (repository.delete(id)) {
            return new ResponseEntity<>("Delete successful", OK);
        }
        return new ResponseEntity<>("Some trouble while deleting", INTERNAL_SERVER_ERROR);
    }
}

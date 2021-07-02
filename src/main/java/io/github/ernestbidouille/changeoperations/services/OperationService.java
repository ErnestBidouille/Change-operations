package io.github.ernestbidouille.changeoperations.services;

import io.github.ernestbidouille.changeoperations.models.Operation;
import io.github.ernestbidouille.changeoperations.repositories.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OperationService {
    @Autowired
    OperationRepository operationRepository;

    public List<Operation> getAllOperations() {
        List<Operation> operations = new ArrayList<Operation>();
        operationRepository.findAll().forEach(operation -> operations.add(operation));
        return operations;
    }

    public Operation getOperationById(Long id) {
        return operationRepository.findById(id).get();
    }

    public void saveOrUpdate(Operation operation) {
        operationRepository.save(operation);
    }

    public void delete(Long id) {
        operationRepository.deleteById(id);
    }

    public void update(Operation operation, Long operationId) {
        operationRepository.save(operation);
    }
}

package io.github.ernestbidouille.changeoperations.repositories;

import io.github.ernestbidouille.changeoperations.models.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation, Long> {
}

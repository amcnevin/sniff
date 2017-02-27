package org.technodrome.sniff.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.technodrome.sniff.domain.model.Signal;

/**
 * Repository for obtaining Signals
 */
public interface SignalRepository extends JpaRepository<Signal, Long> {

}

package org.technodrome.sniff.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.technodrome.sniff.domain.model.SignalPulse;

/**
 *  Repository for obtaining SignalPulses
 */
public interface SignalPulseRepository extends JpaRepository<SignalPulse, Long> {

}

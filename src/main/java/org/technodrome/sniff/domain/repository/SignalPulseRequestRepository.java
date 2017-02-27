package org.technodrome.sniff.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.technodrome.sniff.domain.model.SignalPulseRequest;

/**
 * Repository for obtaining SignalPulseRequests
 */
public interface SignalPulseRequestRepository extends JpaRepository<SignalPulseRequest, Long> {

}

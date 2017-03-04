package org.technodrome.sniff.service;

import org.technodrome.sniff.domain.model.SignalPulseRequest;

/**
 *  Ingestion Facade
 */
public interface IngestionService {

    void ingestPulse(final SignalPulseRequest request);

}

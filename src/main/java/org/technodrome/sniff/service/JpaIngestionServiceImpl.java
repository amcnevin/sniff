package org.technodrome.sniff.service;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.technodrome.sniff.domain.model.Signal;
import org.technodrome.sniff.domain.model.SignalPulse;
import org.technodrome.sniff.domain.model.SignalPulseRequest;
import org.technodrome.sniff.domain.repository.SignalPulseRepository;
import org.technodrome.sniff.domain.repository.SignalPulseRequestRepository;
import org.technodrome.sniff.domain.repository.SignalRepository;

import java.util.Objects;

@Service
@AllArgsConstructor(suppressConstructorProperties = true)
public class JpaIngestionServiceImpl implements IngestionService {

    @Autowired
    @NonNull
    private SignalRepository signalRepo;

    @Autowired
    @NonNull
    private SignalPulseRepository pulseRepo;

    @Autowired
    @NonNull
    private SignalPulseRequestRepository requestRepo;


    public void ingestPulse(final SignalPulseRequest request) {
        Objects.requireNonNull(request);
        SignalPulse pulse = request.getSignalPulse();
        Objects.requireNonNull(pulse);
        Signal signal = pulse.getSignal();
        Objects.requireNonNull(signal);

        signalRepo.save(signal);
        pulseRepo.save(pulse);
        requestRepo.saveAndFlush(request);
    }

}

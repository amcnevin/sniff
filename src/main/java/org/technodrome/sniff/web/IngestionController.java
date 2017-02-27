package org.technodrome.sniff.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.technodrome.sniff.domain.model.Signal;
import org.technodrome.sniff.domain.model.SignalPulse;
import org.technodrome.sniff.domain.model.SignalPulseRequest;
import org.technodrome.sniff.domain.repository.SignalPulseRepository;
import org.technodrome.sniff.domain.repository.SignalPulseRequestRepository;
import org.technodrome.sniff.domain.repository.SignalRepository;

@RestController
@RequestMapping("/ingestion")
public class IngestionController {

    @Autowired
    private SignalPulseRequestRepository requestRepo;

    @Autowired
    private SignalPulseRepository pulseRepo;

    @Autowired
    private SignalRepository signalRepo;

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody Boolean ingestPulse(@RequestBody SignalPulseRequest request) {

        SignalPulse pulse = request.getSignalPulse();
        Signal signal = pulse.getSignal();

        signalRepo.save(signal);
        pulseRepo.save(pulse);
        SignalPulseRequest updated = requestRepo.saveAndFlush(request);

        return true;
    }
}

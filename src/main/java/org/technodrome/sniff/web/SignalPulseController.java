package org.technodrome.sniff.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.technodrome.sniff.domain.model.SignalPulse;
import org.technodrome.sniff.domain.repository.SignalPulseRepository;
import java.util.Collection;

@RestController
@RequestMapping("/signalPulse")
public class SignalPulseController {

    @Autowired
    private SignalPulseRepository pulseRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<SignalPulse> getAllSignalPulses() {
        return pulseRepository.findAll();
    }

}

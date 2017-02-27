package org.technodrome.sniff.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.technodrome.sniff.domain.model.Signal;
import org.technodrome.sniff.domain.repository.SignalRepository;
import java.util.Collection;

@RestController
@RequestMapping("/signals")
public class SignalController {

    @Autowired
    private SignalRepository signalRepo;

    @RequestMapping(method= RequestMethod.GET)
    public @ResponseBody Collection<Signal> getAllSignals() {
        return signalRepo.findAll();
    }

}

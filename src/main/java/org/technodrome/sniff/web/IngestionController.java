package org.technodrome.sniff.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.technodrome.sniff.domain.model.SignalPulseRequest;
import org.technodrome.sniff.service.IngestionService;

@RestController
@RequestMapping("/ingestion")
@Slf4j
@AllArgsConstructor(suppressConstructorProperties = true)
public class IngestionController {

    @Autowired
    private IngestionService ingestionService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.CREATED)
    public void ingestPulse(@RequestBody SignalPulseRequest request) {
        ingestionService.ingestPulse(request);
    }

    @ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR,
            reason="Internal Server Error")
    @ExceptionHandler(Exception.class)
    public void failure(Exception ex) {
            LOG.error("Failed to Ingest", ex);
    }

}

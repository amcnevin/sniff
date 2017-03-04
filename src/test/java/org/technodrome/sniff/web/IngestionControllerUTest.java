package org.technodrome.sniff.web;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.technodrome.sniff.domain.model.SignalPulseRequest;
import org.technodrome.sniff.service.IngestionService;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class IngestionControllerUTest {

    @Mock
    private IngestionService mockedService;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    private IngestionController uut;

    private SignalPulseRequest testRequest;

    @Before
    public void setUp() {
        uut  = new IngestionController(mockedService);
        testRequest = new SignalPulseRequest();
    }

    @Test
    public void testIngestPulse() {
        uut.ingestPulse(testRequest);
        verify(mockedService, times(1)).ingestPulse(testRequest);
        verifyNoMoreInteractions(mockedService);
    }




}
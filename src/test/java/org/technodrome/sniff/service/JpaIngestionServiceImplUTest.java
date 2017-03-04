package org.technodrome.sniff.service;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.technodrome.sniff.domain.model.Signal;
import org.technodrome.sniff.domain.model.SignalPulse;
import org.technodrome.sniff.domain.model.SignalPulseRequest;
import org.technodrome.sniff.domain.repository.SignalPulseRepository;
import org.technodrome.sniff.domain.repository.SignalPulseRequestRepository;
import org.technodrome.sniff.domain.repository.SignalRepository;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class JpaIngestionServiceImplUTest {

    @Mock
    private SignalRepository mockedSignalRepo;

    @Mock
    private SignalPulseRepository mockedPulseRepo;

    @Mock
    private SignalPulseRequestRepository mockedRequestRepo;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    private JpaIngestionServiceImpl uut;


    @Before
    public void setUp() throws Exception {

        uut = new JpaIngestionServiceImpl(mockedSignalRepo, mockedPulseRepo, mockedRequestRepo);
    }

    @Test(expected=NullPointerException.class)
    public void testNullRequest() {
        uut.ingestPulse(null);
    }

    @Test(expected=NullPointerException.class)
    public void testNullPulse() {
        SignalPulseRequest request = new SignalPulseRequest();
        uut.ingestPulse(request);
    }

    @Test(expected=NullPointerException.class)
    public void testNullSignal() {
        SignalPulseRequest request = new SignalPulseRequest();
        SignalPulse pulse = new SignalPulse();
        request.setSignalPulse(pulse);
        uut.ingestPulse(request);
    }

    @Test
    public void testPopulatedRequest() {
        SignalPulseRequest request = new SignalPulseRequest();
        SignalPulse pulse = new SignalPulse();
        Signal signal = new Signal();
        pulse.setSignal(signal);
        request.setSignalPulse(pulse);

        uut.ingestPulse(request);

        verify(mockedSignalRepo, times(1)).save(signal);
        verify(mockedPulseRepo, times(1)).save(pulse);
        verify(mockedRequestRepo, times(1)).saveAndFlush(request);
        verifyNoMoreInteractions(mockedRequestRepo, mockedPulseRepo, mockedSignalRepo);
    }
}
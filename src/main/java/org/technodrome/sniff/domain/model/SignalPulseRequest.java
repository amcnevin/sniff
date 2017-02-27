package org.technodrome.sniff.domain.model;


import lombok.Data;

import javax.persistence.*;

/**
 * The Ingestion Request with corresponding meta data
 */
@Data
@Entity
public class SignalPulseRequest {

    @Id
    @GeneratedValue
    private Long id;
    @Lob
    private String encoded;
    private String ingestionTimestamp;
    @OneToOne
    private SignalPulse signalPulse;

    SignalPulseRequest() {}
}

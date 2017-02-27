package org.technodrome.sniff.domain.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * the state of the capture of a signal
 */
@Data
@Entity
public class SignalPulse {

   @Id
   @GeneratedValue
   private Long id;
   private String captureTimestamp;
   private String quality;
   @OneToOne
   private Signal signal;

   SignalPulse() {}

}

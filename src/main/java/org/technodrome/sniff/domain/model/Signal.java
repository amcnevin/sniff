package org.technodrome.sniff.domain.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * A Wifi Signal Pojo
 */
@Data
@Entity
public class Signal {

    @Id
    @GeneratedValue
    private Long id;
  	private String address;
    private String encryption;
    private String essid;
    private String protocol;
    private String rate;
    private String IE2;
    private String IE;
    private String frequency;

    Signal() {}

}

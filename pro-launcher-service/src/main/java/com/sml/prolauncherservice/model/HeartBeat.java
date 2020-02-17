package com.sml.prolauncherservice.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class HeartBeat implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public HeartBeat(String name) {
        this.name = name;
    }
}

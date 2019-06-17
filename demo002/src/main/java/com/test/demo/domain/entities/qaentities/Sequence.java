package com.test.demo.domain.entities.qaentities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by huangguoping.
 */
@Entity
@Table(name = "sys_sequence")
public class Sequence {
    @Id
    private Integer id;

    @Column(name = "flag_name")
    private String flagName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFlagName() {
        return flagName;
    }

    public void setFlagName(String flagName) {
        this.flagName = flagName;
    }
}

package com.dku.dandev.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Testcase {
    @Id
    private Long id;
    private Object input;
    private Object output;
    @ManyToOne
    private Problem problem;
}

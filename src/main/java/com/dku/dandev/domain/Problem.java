package com.dku.dandev.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Problem {
    @Id
    private Long id;
    @Lob
    private String question;
    @Lob
    private String example;


}

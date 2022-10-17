package com.dku.dandev.dto;

import javax.persistence.Lob;

public class SubmissionDto {
    private Long problemId;
    @Lob
    private String code;

    public SubmissionDto(Long problemId, String code) {
        this.problemId = problemId;
        this.code = code;
    }

    public Long getProblemId() {
        return problemId;
    }

    public void setProblemId(Long problemId) {
        this.problemId = problemId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

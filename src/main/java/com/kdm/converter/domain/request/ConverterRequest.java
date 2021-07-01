/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdm.converter.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

/**
 *
 * @author kasun.madusanke
 */
@Component
public class ConverterRequest {

    private String jobId;
    private String fileName;

    /**
     * @return the jobId
     */
    @JsonProperty("job_id")
    public String getJobId() {
        return jobId;
    }

    /**
     * @return the fileName
     */
    @JsonProperty("file_name")
    public String getFileName() {
        return fileName;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}

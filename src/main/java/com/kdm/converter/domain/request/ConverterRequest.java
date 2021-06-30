/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdm.converter.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author kasun.madusanke
 */
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
}

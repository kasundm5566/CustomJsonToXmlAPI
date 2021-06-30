/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdm.converter.domain.jmf;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kasun.madusanke
 */
@XmlRootElement(name = "Command")
public class Command {

    private String id;
    private String type;
    private QueueSubmissionParams queueSubmissionParams;

    @XmlAttribute(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlAttribute(name = "Type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlElement(name = "QueueSubmissionParams")
    public QueueSubmissionParams getQueueSubmissionParams() {
        return queueSubmissionParams;
    }

    public void setQueueSubmissionParams(QueueSubmissionParams queueSubmissionParams) {
        this.queueSubmissionParams = queueSubmissionParams;
    }

}

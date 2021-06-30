/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdm.converter.domain.jdf;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kasun.madusanke
 */
@XmlRootElement(name = "ResourcePool")
public class ResourcePool {

    private RunList runList;

    @XmlElement(name = "RunList")
    public RunList getRunList() {
        return runList;
    }

    public void setRunList(RunList runList) {
        this.runList = runList;
    }

}

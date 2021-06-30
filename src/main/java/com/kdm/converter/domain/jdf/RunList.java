/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdm.converter.domain.jdf;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kasun.madusanke
 */
@XmlRootElement(name = "RunList")
public class RunList {

    private String status;
    private LayoutElement layoutElement;

    @XmlAttribute(name = "Status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlElement(name = "LayoutElement")
    public LayoutElement getLayoutElement() {
        return layoutElement;
    }

    public void setLayoutElement(LayoutElement layoutElement) {
        this.layoutElement = layoutElement;
    }
}

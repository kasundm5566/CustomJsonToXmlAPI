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

@XmlRootElement(name = "LayoutElement")
public class LayoutElement {
    private FileSpec fileSpec;

    @XmlElement(name = "FileSpec")
    public FileSpec getFileSpec() {
        return fileSpec;
    }

    public void setFileSpec(FileSpec fileSpec) {
        this.fileSpec = fileSpec;
    }
    
    
}

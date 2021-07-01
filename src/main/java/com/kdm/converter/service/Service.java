/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdm.converter.service;

import com.kdm.converter.domain.jdf.FileSpec;
import com.kdm.converter.domain.jdf.JDF;
import com.kdm.converter.domain.jdf.LayoutElement;
import com.kdm.converter.domain.jdf.ResourcePool;
import com.kdm.converter.domain.jdf.RunList;
import com.kdm.converter.domain.jmf.Command;
import com.kdm.converter.domain.request.ConverterRequest;
import com.kdm.converter.domain.jmf.JMF;
import com.kdm.converter.domain.jmf.QueueSubmissionParams;
import java.io.File;
import java.io.FileNotFoundException;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import org.springframework.core.io.FileUrlResource;
import org.springframework.http.MediaType;

/**
 *
 * @author kasun.madusanke
 */
@RestController
public class Service {

    private static final String JMF_XML = "JMF.xml";
    private static final String JDF_XML = "JDF.xml";

    @RequestMapping(value = "/jmf", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    public ResponseEntity<Resource> convertJsonToJmfXML(@RequestBody ConverterRequest request) {
        Resource resource = null;

        // Create JMF object
        QueueSubmissionParams submissionParams = new QueueSubmissionParams();
        submissionParams.setUrl("cid:jdfcontent");
        submissionParams.setReturnUrl("<http://abc.com/jdf>");

        Command command = new Command();
        command.setId("C001");
        command.setType("SubmitQueueEntry");
        command.setQueueSubmissionParams(submissionParams);

        JMF jmf = new JMF();
        jmf.setSenderId("SRQ");
        jmf.setXmlns("<http://www.CIP4.org/JDFSchema_1_1>");
        jmf.setCommand(command);

        try {
            // Create XML
            JAXBContext context = JAXBContext.newInstance(JMF.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(jmf, new File(JMF_XML));
            resource = loadFileAsResource(JMF_XML);
        } catch (Exception ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Setting up response headers
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + JMF_XML);
        headers.add(HttpHeaders.TRANSFER_ENCODING, "8bit");

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/vnd.cip4-jmf+xml; charset=UTF-8"))
                .headers(headers)
                .body(resource);
    }

    @RequestMapping(value = "/jdf", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    public ResponseEntity<Resource> convertJsonToJdfXML(@RequestBody ConverterRequest request) {
        Resource resource = null;

        // Create JDF object
        FileSpec fileSpec = new FileSpec();
        fileSpec.setUrl(request.getFileName());

        LayoutElement layoutElement = new LayoutElement();
        layoutElement.setFileSpec(fileSpec);

        RunList runList = new RunList();
        runList.setStatus("Available");
        runList.setLayoutElement(layoutElement);

        ResourcePool resourcePool = new ResourcePool();
        resourcePool.setRunList(runList);

        JDF jdf = new JDF();
        jdf.setJobId(request.getJobId());
        jdf.setResourcePool(resourcePool);

        try {
            // Create XML
            JAXBContext context = JAXBContext.newInstance(JDF.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(jdf, new File(JDF_XML));
            resource = loadFileAsResource(JDF_XML);
        } catch (Exception ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Setting up response headers
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + JDF_XML);
        headers.add(HttpHeaders.TRANSFER_ENCODING, "8bit");

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/vnd.cip4-jdf+xml; charset=UTF-8"))
                .headers(headers)
                .body(resource);
    }

    private Resource loadFileAsResource(String fileName) throws Exception {
        Resource resource = new FileUrlResource(fileName);
        if (resource.exists()) {
            return resource;
        } else {
            throw new FileNotFoundException("File not found.");
        }
    }
}

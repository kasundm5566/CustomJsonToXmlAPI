/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdm.converter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.kdm.converter.domain.request.ConverterRequest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.core.io.Resource;

/**
 *
 * @author kasun.madusanke
 */
@SpringBootTest(classes = {Service.class, ConverterRequest.class})
public class ServiceTests {

    @Autowired
    ConverterRequest converterRequest;

    @Autowired
    Service service;

    @Test
    public void testJsonToJmfXMLHeaders() {
        converterRequest.setFileName("test_file");
        converterRequest.setJobId("J0001");

        ResponseEntity<Resource> res = service.convertJsonToJmfXML(converterRequest);
        assertEquals(200, res.getStatusCodeValue());
        assertEquals(true, res.getBody().isFile());
        assertEquals("application/vnd.cip4-jmf+xml;charset=UTF-8", res.getHeaders().get("Content-Type").get(0));
        assertEquals("8bit", res.getHeaders().get("Transfer-Encoding").get(0));
    }

    @Test
    public void testJsonToJdfXMLHeaders() {
        converterRequest.setFileName("test_file");
        converterRequest.setJobId("J0001");

        ResponseEntity<Resource> res = service.convertJsonToJdfXML(converterRequest);
        assertEquals(200, res.getStatusCodeValue());
        assertEquals(true, res.getBody().isFile());
        assertEquals("application/vnd.cip4-jdf+xml;charset=UTF-8", res.getHeaders().get("Content-Type").get(0));
        assertEquals("8bit", res.getHeaders().get("Transfer-Encoding").get(0));
    }

}

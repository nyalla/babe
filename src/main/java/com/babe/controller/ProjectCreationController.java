package com.babe.controller;

import com.babe.beans.Payload;
import com.babe.services.ProjectCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class ProjectCreationController
{

    @Autowired
    ProjectCreationService projectCreationService;

    @PostMapping(path = "/create", consumes = "application/json")
    public ResponseEntity<?> trigger(HttpServletResponse response, @RequestBody Payload payload)
    {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/zip"));
        String outputFilename = "sample.zip";
        headers.setContentDispositionFormData(outputFilename, outputFilename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

        byte[] projectByteContent = projectCreationService.createProject(payload);

        if (projectByteContent != null)
        {
            return new ResponseEntity<>(projectByteContent, headers, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("Nothing is there ", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello Java Code Geeks!";
    }


}

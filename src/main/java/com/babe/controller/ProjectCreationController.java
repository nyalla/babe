package com.babe.controller;

import com.babe.beans.Payload;
import com.babe.services.ProjectCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletResponse;

public class ProjectCreationController
{

    @Autowired
    ProjectCreationService projectCreationService;

    @PostMapping(path = "/create", consumes = "application/json", produces = "application/zip")
    public void trigger(HttpServletResponse response, @RequestBody Payload payload)
    {

        projectCreationService.createProject(payload);


    }
}

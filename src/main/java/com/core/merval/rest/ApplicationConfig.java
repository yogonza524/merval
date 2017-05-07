/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.core.merval.rest;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;
import org.primefaces.component.messages.Messages;

/**
 * 
 * @author Gonzalo H. Mendoza
 * email: yogonza524@gmail.com
 * StackOverflow: http://stackoverflow.com/users/5079517/gonza
 */
@javax.ws.rs.ApplicationPath("rest")
public class ApplicationConfig extends Application {

    
    

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }


    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.core.merval.rest.Rest.class);
    }
}

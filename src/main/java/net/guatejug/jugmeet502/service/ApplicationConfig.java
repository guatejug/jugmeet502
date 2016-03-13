/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.guatejug.jugmeet502.service;

import java.util.Set;
import javax.mvc.security.Csrf;
import javax.ws.rs.core.Application;

/**
 *
 * @author shaka
 */
@javax.ws.rs.ApplicationPath("app")
public class ApplicationConfig extends Application {

    public ApplicationConfig() {
        
   //     this.getProperties().put("mvcVersion", "EDR2");
   //     this.getProperties().put(Csrf.CSRF_PROTECTION, Csrf.CsrfOptions.EXPLICIT);
    }

    
    @Override
    public Set<Class<?>> getClasses() {

        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(net.guatejug.jugmeet502.HelloController.class);
        resources.add(net.guatejug.jugmeet502.controller.AttendeeController.class);
        resources.add(net.guatejug.jugmeet502.controller.CategoryController.class);
    }
    
}

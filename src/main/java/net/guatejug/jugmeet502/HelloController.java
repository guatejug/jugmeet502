package net.guatejug.jugmeet502;

import javax.inject.Inject;
import javax.mvc.Models;
import javax.mvc.Viewable;
import javax.mvc.annotation.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import org.glassfish.ozark.ext.handlebars.HandlebarsViewEngine;

@Controller
@Path("hello")
public class HelloController {

    @Inject
    private Models models;

//    @GET
//    public String sayHello(@QueryParam("name") String name) {
//        String message = "Hello " + name;
//        models.put("message", message);
//        return "/hello.jsp";
//    }
    
    @GET
    public Viewable mvc(@QueryParam("name") String name) {
        String message = "Hello " + name;
        models.put("message", message);
        return new Viewable("/hello.html", models, HandlebarsViewEngine.class);
    }
}

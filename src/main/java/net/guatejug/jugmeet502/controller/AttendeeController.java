package net.guatejug.jugmeet502.controller;

import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.mvc.Viewable;
import javax.mvc.annotation.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import net.guatejug.jugmeet502.dao.AttendeeDao;
import net.guatejug.jugmeet502.domain.Attendee;
import org.glassfish.ozark.ext.handlebars.HandlebarsViewEngine;

/**
 *
 * @author tuxtor
 */
@Controller
@Path("attendee")
public class AttendeeController {

    @EJB
    private AttendeeDao attendeeDao;
    
    @Inject
    private Attendee attendee;
    
    @Inject
    private transient Logger logger;
    
    @GET
    @Path("listall")
    public Viewable listAll() {
//        List<Category> categories = this.categoryDao.listAll(null, null);
//        models.put("categories", categories);
        logger.info("este es un log");
        return new Viewable("/views/attendee/list.html", HandlebarsViewEngine.class);
    }

    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.guatejug.jugmeet502.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.mvc.Models;
import javax.mvc.Viewable;
import javax.mvc.annotation.Controller;
import javax.validation.Valid;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import net.guatejug.jugmeet502.dao.CategoryDao;
import net.guatejug.jugmeet502.domain.Category;
import org.glassfish.ozark.ext.handlebars.HandlebarsViewEngine;

/**
 *
 * @author Mario Batres
 */
@Controller
@Path("category")
public class CategoryController {

    private static final Logger LOGGER = Logger.getLogger(CategoryController.class.getName());

    @Inject
    private Models models;

    @EJB
    private CategoryDao categoryDao;

    @GET
    @Path("listall")
    public Viewable listAll() {
        List<Category> categories = this.categoryDao.listAll(null, null);
        models.put("categories", categories);
        return new Viewable("/views/category/listall.html", models, HandlebarsViewEngine.class);
    }

    @GET
    @Path("create")
    public Viewable preCreate() {
        LOGGER.info("create");
        
        models.put("category", new Category());
        return new Viewable("/views/category/create.html", models, HandlebarsViewEngine.class);
    }

    @POST
    @Path("create")
    public Viewable create(@BeanParam Category category) {

        LOGGER.log(Level.INFO, "category.name:  {0}", category.getName());
        try {
            this.categoryDao.create(category);
            models.put("message", "category_save");
            models.put("category", new Category());
        } catch (Exception ex) {
            models.put("error", true);
            models.put("message", "error_default");
            models.put("category", category);
            LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return new Viewable("/views/category/create.html", models, HandlebarsViewEngine.class);
    }
}

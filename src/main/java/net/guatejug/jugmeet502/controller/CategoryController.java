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
import javax.mvc.binding.BindingResult;
import javax.validation.Valid;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
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
    private BindingResult br;

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
    @ValidateOnExecution(type = ExecutableType.NONE)
    public Viewable create(@Valid @BeanParam Category category) {

        if (!this.br.isFailed()) {

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
        } else {
            models.put("message", this.br.getAllMessages());
        }
        return new Viewable("/views/category/create.html", models, HandlebarsViewEngine.class);
    }

    @GET
    @Path("update")
    public Viewable preUpdate(@QueryParam("c") Integer categoryId) {
        LOGGER.log(Level.INFO, "categoryId: {0}", categoryId);

        try {
            Category category = this.categoryDao.findById(categoryId);
            models.put("category", category);
        } catch (Exception ex) {
            models.put("error", true);
            models.put("message", "error_default");
            LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return new Viewable("/views/category/update.html", models, HandlebarsViewEngine.class);
    }

    @POST
    @Path("update")
    @ValidateOnExecution(type = ExecutableType.NONE)
    public Viewable update(@Valid @BeanParam Category category) {
        LOGGER.log(Level.INFO, "category: {0}", category);

        if (!this.br.isFailed()) {
            try {
                this.categoryDao.update(category);
                models.put("category", category);
                models.put("message", "category_update");
            } catch (Exception ex) {
                models.put("error", true);
                models.put("message", "error_default");
                LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
            }
        } else {
            models.put("message", this.br.getAllMessages());
        }
        return new Viewable("/views/category/update.html", models, HandlebarsViewEngine.class);
    }
}

package net.guatejug.jugmeet502.service;

import java.util.logging.Logger;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;


/**
 * CDI log producer
 * 
 * @author tuxtor
 *
 */
public class LoggerProducer {
    
    @Produces  
    public Logger produceLogger(InjectionPoint caller) {  
        return Logger.getLogger(caller.getClass().getName());
    }  
}

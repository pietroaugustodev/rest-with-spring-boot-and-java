package br.com.pietro.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testLogController {

    private final Logger logger = LoggerFactory.getLogger(testLogController.class.getName());

    @GetMapping("/test")
    public String testLog(){
        logger.debug("Nivel debub");
        logger.info("Nivel info");
        logger.warn("Nivel warn");
        logger.error("Nivel error");

        return "Logging generated";
    }
}

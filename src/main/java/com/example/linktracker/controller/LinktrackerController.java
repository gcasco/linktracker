package com.example.linktracker.controller;

import com.example.linktracker.exception.LinkInvalidException;
import com.example.linktracker.exception.LinkNotFoundException;
import com.example.linktracker.model.LinkInputDTO;
import com.example.linktracker.model.LinkOutputDTO;
import com.example.linktracker.service.ILinktrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.net.URL;

@RestController
public class LinktrackerController {
    @Autowired
    private ILinktrackerService service;

    public static boolean isValid(String url) {
        /* Try creating a valid URL */
        try {
            new URL(url).toURI();
            return true;
        }

        // If there was an Exception
        // while creating URL object
        catch (Exception e) {
            return false;
        }
    }

    ///Redirect
    @GetMapping(value = "link/{linkId}", params = {"password"})
    public RedirectView redirectView(@PathVariable Integer linkId, @RequestParam("password") String password) throws LinkNotFoundException, LinkInvalidException {
        String url = service.getLink(linkId, password);
        return new RedirectView(url);
    }

    ///Invalidate
    @PostMapping("/invalidate/{linkId}")
    public void invalidateLink(@PathVariable Integer linkId) throws LinkNotFoundException, LinkInvalidException {
        service.invalidateLink(linkId);
    }

    ///Metrics
    @GetMapping("/metrics/{linkId}")
    public Integer getMetricsByLinkId(@PathVariable Integer linkId) throws LinkNotFoundException, LinkInvalidException {

        return service.getMetrics(linkId);
    }

    ///CreateLink
    @PostMapping("/link")
    public LinkOutputDTO redirectPostToPostESTEMETODOESTAMAL(@RequestBody LinkInputDTO linkId) throws LinkInvalidException {
        LinkOutputDTO linkOutputDTO = new LinkOutputDTO();
        if (isValid(linkId.getUrl())) {
            linkOutputDTO.setLinId(service.addLink(linkId));
        } else {
            throw new LinkInvalidException();
        }

        return linkOutputDTO;
    }

    @ExceptionHandler(LinkInvalidException.class)
    public ResponseEntity<String> handlerException(LinkInvalidException linkInvalidException) {
        return new ResponseEntity<>(linkInvalidException.getMESSAGE(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(LinkNotFoundException.class)
    public ResponseEntity<String> handlerException(LinkNotFoundException linkNotFoundException) {

        return new ResponseEntity<>(linkNotFoundException.getMESSAGE(), HttpStatus.NOT_FOUND);
    }


}

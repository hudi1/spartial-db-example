package org.example.rest;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.example.model.spartial.ColaMarkets;
import org.example.service.SpartialService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    private Logger log = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private SpartialService spartialService;

    @RequestMapping(value = "/vloz", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<String> vloz(HttpServletRequest request) {
        spartialService.vlozZaznam();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Collection<Result>> list(HttpServletRequest request) {
        List<ColaMarkets> list = spartialService.listZaznam();
        return new ResponseEntity<>(mapuj(list), null, HttpStatus.OK);
    }

    private List<Result> mapuj(List<ColaMarkets> dbList) {
        return dbList.stream().map(Result::new).collect(Collectors.toList());
    }

}

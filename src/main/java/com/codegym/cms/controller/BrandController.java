package com.codegym.cms.controller;


import com.codegym.cms.model.entity.car.Brand;
import com.codegym.cms.model.service.car.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/brand/")
@CrossOrigin("*")
public class BrandController {
    @Autowired
    private IBrandService service;

    @GetMapping("list")
    public ResponseEntity<List<Brand>> brandList() {
        List<Brand> list = service.findALl();
        return new ResponseEntity <>(list, HttpStatus.OK);
    }
}

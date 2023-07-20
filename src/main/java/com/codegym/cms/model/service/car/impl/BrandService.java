package com.codegym.cms.model.service.car.impl;

import com.codegym.cms.model.entity.car.Brand;
import com.codegym.cms.model.repository.IBrandRepository;
import com.codegym.cms.model.service.car.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService implements IBrandService {
    @Autowired
    private IBrandRepository repository;

    @Override
    public List<Brand> findALl() {
        return repository.findAll();
    }
}

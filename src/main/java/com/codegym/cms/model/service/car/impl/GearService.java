package com.codegym.cms.model.service.car.impl;


import com.codegym.cms.model.entity.car.Gear;
import com.codegym.cms.model.repository.IGearRepository;
import com.codegym.cms.model.service.car.IGearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GearService implements IGearService {
    @Autowired
    private IGearRepository repository;
    @Override
    public List<Gear> findAll() {
        return repository.getListGear();
    }
}

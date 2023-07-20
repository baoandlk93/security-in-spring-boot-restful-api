package com.codegym.cms.model.service.car;


import com.codegym.cms.model.entity.car.Gear;

import java.util.List;

public interface IGearService {
    List<Gear> findAll();
}

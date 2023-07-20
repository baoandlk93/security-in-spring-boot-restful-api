package com.codegym.cms.model.service.car.impl;


import com.codegym.cms.model.dto.CarDto;
import com.codegym.cms.model.dto.ICarDto;
import com.codegym.cms.model.entity.car.Brand;
import com.codegym.cms.model.entity.car.Car;
import com.codegym.cms.model.entity.car.Gear;
import com.codegym.cms.model.repository.IBrandRepository;
import com.codegym.cms.model.repository.ICarRepository;
import com.codegym.cms.model.repository.IGearRepository;
import com.codegym.cms.model.service.car.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService implements ICarService {
    @Autowired
    private ICarRepository repository;

    @Autowired
    private IGearRepository gearRepository;

    @Autowired
    private IBrandRepository brandRepository;

    @Override
    public Page<ICarDto> findAllCar(Pageable pageable, String name) {
        return repository.findAllCarByOther(pageable, name);
    }

    @Override
    public Optional<ICarDto> findByIdDto(int id) {
        return repository.findByIdCar(id);
    }

    @Override
    public Optional<Car> findById(int id) {
        return repository.findCarById(id);
    }

    @Override
    public void deleteCar(int id) {
        repository.deleteCar(id);
    }

    @Override
    public List<Gear> gearList() {
        return gearRepository.findAll();
    }

    @Override
    public List<Brand> brandList() {
        return brandRepository.findAll();
    }

    @Override
    public List<ICarDto> findAllCarByCustomer(int id) {
        return null;
    }

    @Override
    public void addNewCar(CarDto carDto) {
        repository.addNewCar(carDto);
    }
}

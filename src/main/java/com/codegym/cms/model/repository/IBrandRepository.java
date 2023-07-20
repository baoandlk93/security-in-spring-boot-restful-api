package com.codegym.cms.model.repository;


import com.codegym.cms.model.entity.car.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IBrandRepository extends JpaRepository<Brand, Integer> {
}

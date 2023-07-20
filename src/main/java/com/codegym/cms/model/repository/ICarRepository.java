package com.codegym.cms.model.repository;


import com.codegym.cms.model.dto.CarDto;
import com.codegym.cms.model.dto.ICarDto;
import com.codegym.cms.model.entity.car.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface ICarRepository extends JpaRepository<Car, Integer> {
    @Query(value = "SELECT car.id AS id, " +
            "car.name AS name, " +
            "car.accreditation AS accreditation, " +
            "car.color AS color, " +
            "car.designs AS designs, " +
            "car.drive_shaft AS driveShaft," +
            "car.engine_displacement AS engineDisplacement, " +
            "car.fuel AS fuel, " +
            "car.number_of_mile_traveled AS numberOfMileTraveled, " +
            "car.number_of_seat AS numberOfSeat," +
            " car.origin AS origin, " +
            "car.picture AS picture, " +
            "car.price AS price, " +
            "car.year AS year," +
            "car.is_delete, " +
            "car.status AS status, " +
            "car.brand_id, " +
            "car.gear_id, " +
            "brand.name AS brandName, " +
            "gear.name AS gearName " +
            " FROM car " +
            "JOIN brand ON car.brand_id = brand.id " +
            "JOIN gear ON car.gear_id = gear.id " +
            "WHERE car.is_delete = 0 AND car.name LIKE %:name% " +
            "ORDER BY car.id", nativeQuery = true,
    countQuery = "SELECT count(*) " +
            "FROM car " +
            "JOIN brand ON car.brand_id = brand.id " +
            "JOIN gear ON car.gear_id = gear.id " +
            "WHERE car.is_delete = 0 AND car.name LIKE %:name% " +
            "ORDER BY car.id")
    Page<ICarDto> findAllCarByOther(Pageable pageable, @Param("name") String name);
    @Query(value = "SELECT car.id AS id, " +
            "car.name AS name, " +
            "car.accreditation AS accreditation, " +
            "car.color AS color, " +
            "car.designs AS designs, " +
            "car.drive_shaft AS driveShaft," +
            "car.engine_displacement AS engineDisplacement, " +
            "car.fuel AS fuel, " +
            "car.number_of_mile_traveled AS numberOfMileTraveled, " +
            "car.number_of_seat AS numberOfSeat," +
            " car.origin AS origin, " +
            "car.picture AS picture, " +
            "car.price AS price, " +
            "car.year AS year,car.is_delete, " +
            "car.status AS status, " +
            "car.brand_id, " +
            "car.gear_id, " +
            "brand.name AS brandName, " +
            "gear.name AS gearName" +
            " FROM car " +
            "JOIN brand ON car.brand_id = brand.id " +
            "JOIN gear ON car.gear_id = gear.id " +
            "WHERE car.is_delete = 0 AND car.id =:id", nativeQuery = true,
            countQuery = "SELECT count(*) " +
                    "FROM car " +
                    "JOIN brand ON car.brand_id = brand.id " +
                    "JOIN gear ON car.gear_id = gear.id " +
                    "WHERE car.is_delete = 0 AND car.id =:id")
    Optional<ICarDto> findByIdCar(@Param("id") int id);
    @Modifying
    @Query(value = "UPDATE car SET is_delete = 1 WHERE id =:id",nativeQuery = true)
    void deleteCar(int id);
    @Query(value = "SELECT car.id, " +
            "car.name , " +
            "car.accreditation, " +
            "car.color, " +
            "car.designs , " +
            "car.drive_shaft," +
            "car.engine_displacement, " +
            "car.fuel , " +
            "car.number_of_mile_traveled, " +
            "car.number_of_seat ," +
            " car.origin , " +
            "car.picture , " +
            "car.price , " +
            "car.year ," +
            "car.is_delete, " +
            "car.status , " +
            "car.brand_id, " +
            "car.gear_id, " +
            "brand.name , " +
            "gear.name " +
            " FROM car " +
            "JOIN brand ON car.brand_id = brand.id " +
            "JOIN gear ON car.gear_id = gear.id " +
            "WHERE car.is_delete = 0 AND car.id =:id", nativeQuery = true,
            countQuery = "SELECT count(*) " +
                    "FROM car " +
                    "JOIN brand ON car.brand_id = brand.id " +
                    "JOIN gear ON car.gear_id = gear.id " +
                    "WHERE car.is_delete = 0 AND car.id =:id")
    Optional<Car> findCarById(int id);
    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO car (name, accreditation, color, designs, drive_shaft, engine_displacement, fuel, number_of_mile_traveled, number_of_seat, origin, picture, price, status, year, brand_id, gear_id) " +
            "VALUES (:#{#c.name}, :#{#c.accreditation}, :#{#c.color}, :#{#c.designs}, :#{#c.driveShaft}, :#{#c.engineDisplacement}, :#{#c.fuel}, :#{#c.numberOfMileTraveled}, :#{#c.numberOfSeat}, :#{#c.origin}, :#{#c.picture}, :#{#c.price}, :#{#c.status}, :#{#c.year}, :#{#c.brand.id}, :#{#c.gear.id})")
    void addNewCar(@Param("c") CarDto carDto);

}

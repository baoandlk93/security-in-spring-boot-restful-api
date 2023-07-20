package com.codegym.cms.model.dto;


import com.codegym.cms.model.entity.car.Brand;
import com.codegym.cms.model.entity.car.Gear;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor
public class CarDto {
    private Long id;
    private String name;
    private Brand brand;
    private String color;
    private String designs;
    private Gear gear;
    private String year;
    private int numberOfSeat;
    private boolean status;
    private double price;
    private String picture;
    private String fuel;
    private boolean accreditation;
    private String origin;
    private int numberOfMileTraveled;
    private String driveShaft;
    private String engineDisplacement;
    private boolean isDelete;

//    public CarDto() {
//    }
//
//    public CarDto(String name, Brand brand, String color, String designs, Gear gear, String year, int numberOfSeat, boolean status, double price, String picture, String fuel, boolean accreditation, String origin, int numberOfMileTraveled, String driveShaft) {
//        this.name = name;
//        this.brand = brand;
//        this.color = color;
//        this.designs = designs;
//        this.gear = gear;
//        this.year = year;
//        this.numberOfSeat = numberOfSeat;
//        this.status = status;
//        this.price = price;
//        this.picture = picture;
//        this.fuel = fuel;
//        this.accreditation = accreditation;
//        this.origin = origin;
//        this.numberOfMileTraveled = numberOfMileTraveled;
//        this.driveShaft = driveShaft;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Brand getBrand() {
//        return brand;
//    }
//
//    public void setBrand(Brand brand) {
//        this.brand = brand;
//    }
//
//    public String getColor() {
//        return color;
//    }
//
//    public void setColor(String color) {
//        this.color = color;
//    }
//
//    public String getDesigns() {
//        return designs;
//    }
//
//    public void setDesigns(String designs) {
//        this.designs = designs;
//    }
//
//    public Gear getGear() {
//        return gear;
//    }
//
//    public void setGear(Gear gear) {
//        this.gear = gear;
//    }
//
//    public String getYear() {
//        return year;
//    }
//
//    public void setYear(String year) {
//        this.year = year;
//    }
//
//    public int getNumberOfSeat() {
//        return numberOfSeat;
//    }
//
//    public void setNumberOfSeat(int numberOfSeat) {
//        this.numberOfSeat = numberOfSeat;
//    }
//
//    public boolean isStatus() {
//        return status;
//    }
//
//    public void setStatus(boolean status) {
//        this.status = status;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    public String getPicture() {
//        return picture;
//    }
//
//    public void setPicture(String picture) {
//        this.picture = picture;
//    }
//
//    public String getFuel() {
//        return fuel;
//    }
//
//    public void setFuel(String fuel) {
//        this.fuel = fuel;
//    }
//
//    public boolean isAccreditation() {
//        return accreditation;
//    }
//
//    public void setAccreditation(boolean accreditation) {
//        this.accreditation = accreditation;
//    }
//
//    public String getOrigin() {
//        return origin;
//    }
//
//    public void setOrigin(String origin) {
//        this.origin = origin;
//    }
//
//    public int getNumberOfMileTraveled() {
//        return numberOfMileTraveled;
//    }
//
//    public void setNumberOfMileTraveled(int numberOfMileTraveled) {
//        this.numberOfMileTraveled = numberOfMileTraveled;
//    }
//
//    public String getDriveShaft() {
//        return driveShaft;
//    }
//
//    public void setDriveShaft(String driveShaft) {
//        this.driveShaft = driveShaft;
//    }
//
//    public String getEngineDisplacement() {
//        return engineDisplacement;
//    }
//
//    public void setEngineDisplacement(String engineDisplacement) {
//        this.engineDisplacement = engineDisplacement;
//    }
//
//    public boolean isDelete() {
//        return isDelete;
//    }
//
//    public void setDelete(boolean delete) {
//        isDelete = delete;
//    }
}

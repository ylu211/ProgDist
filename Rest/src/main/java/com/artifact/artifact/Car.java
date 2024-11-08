package com.artifact.artifact;

public class Car {
    private String plateNumber;
    private String brand;
    private int price;
    private boolean isRented;
    private Dates rentalDates;

    public Car (String plateNumber, String brand, int price, boolean isRented) {
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.price = price;
        this.isRented = isRented;
        this.rentalDates = null;
    }
    public Dates getRentalDates() {
        return rentalDates;
    }
    public void setRentalDates(Dates rentalDates) {
        this.rentalDates = rentalDates;
    }
    public String getPlateNumber() {
        return plateNumber;
    }
    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public boolean isRented() {
        return isRented;
    }
    public void setRented(boolean isRented) {
        this.isRented = isRented;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day01carssortedali;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author alagh
 */

class Car {

    public Car(String makeModel, double engineSizeL, int prodYear) {
        this.makeModel = makeModel;
        this.engineSizeL = engineSizeL;
        this.prodYear = prodYear;
    }

    private String makeModel;
    private double engineSizeL;
    private int prodYear;

    @Override
    public String toString() {
        return "Car{" + "makeModel=" + makeModel + ", engineSizeL=" + engineSizeL + ", prodYear=" + prodYear + '}';
    }
    
     public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public double getEngineSizeL() {
        return engineSizeL;
    }

    public void setEngineSizeL(double engineSizeL) {
        this.engineSizeL = engineSizeL;
    }

    public int getProdYear() {
        return prodYear;
    }

    public void setProdYear(int prodYear) {
        this.prodYear = prodYear;
    }
    
    }



public class Day01CarsSortedAli {

    static ArrayList<Car> parking = new ArrayList<>();

    static void readDataFromFile() {
        try (Scanner fileInput = new Scanner(new File("cars.txt"))) {
            while (fileInput.hasNextLine()) {
                try {
                    String line = fileInput.nextLine();
                    String[] data = line.split(";");
                    if (data.length != 3) {
                        System.out.println("Error in line, skipping");
                        continue;
                    }
                    String makeModel = data[0];
                    double engSize = Double.parseDouble(data[1]);
                    int yop = Integer.parseInt(data[2]);
                    parking.add(new Car(makeModel, engSize, yop));
                } catch (NumberFormatException ex) {
                    System.out.println("Error in line, skipping: " + ex);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    public static void main(String[] args) {
        readDataFromFile();
        System.out.println("==== Parking:");
        for (Car car : parking) {
            System.out.println(car);
        }
        // sort by makeModel
        parking.sort((Car c1, Car c2) -> c1.getMakeModel().compareTo(c2.getMakeModel()));
        System.out.println("==== Parking sorted by make model:");
        for (Car car : parking) {
            System.out.println(car);
        }
        // sort by engine size
        parking.sort((Car c1, Car c2) -> Double.compare(c1.getEngineSizeL(), c2.getEngineSizeL()));
        System.out.println("==== Parking sorted by engine size:");
        for (Car car : parking) {
            System.out.println(car);
        }
        // sort by yop
        parking.sort((Car c1, Car c2) -> c2.getProdYear() - c1.getProdYear());
        System.out.println("==== Parking sorted by prod year:");
        for (Car car : parking) {
            System.out.println(car);
        }
        // sort by year then makeModel
        Comparator<Car> compProdYearMakeModel = Comparator.comparing(Car::getProdYear).thenComparing(Car::getMakeModel); //.reversed();
        parking.sort(compProdYearMakeModel);
        System.out.println("==== Parking sorted by prod year then make model:");
        for (Car car : parking) {
            System.out.println(car);
        }
    }
    
}

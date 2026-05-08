package com.pluralsight.ui;

import com.pluralsight.filemanager.DealershipFileManager;
import com.pluralsight.models.Dealership;
import com.pluralsight.models.Vehicle;

import java.util.List;


public class UserInterface {
    private Dealership dealership;
    private void init() {
        DealershipFileManager fileManager = new DealershipFileManager("inventory.csv");
        this.dealership = fileManager.getDealership();
    }

    public void display() {
        init();
        while (true) {
            System.out.println("""
                    
                    ---------- Car Dealer ----------
                    1. Search By Price
                    2. Search By Make/Model
                    3. Search By Year
                    4. Search By Color
                    5. Search By Mileage
                    6. Search By Vehicle Type
                    7. List All Vehicles
                    8. Add Vehicle
                    9. Remove Vehicle
                    99. Quit (Exit App)
                    """);
            int command = Console.promptForInt("Enter # choice: ");

            switch (command) {
                case 1 -> processGetByPriceRequest();
                case 2 -> processGetByMakeModelRequest();
                case 3 -> processGetByYearRequest();
                case 4 -> processGetByColorRequest();
                case 5 -> processGetByMileageRequest();
                case 6 -> processGetByVehicleTypeRequest();
                case 7 -> processGetAllVehiclesRequest();
                case 8 -> processAddVehicleRequest();
                case 9 -> processRemoveVehicleRequest();
                case 99 -> {
                    System.out.println("Thank you! Goodbye.");
                    return;
                }
                default -> System.out.println("Invalid # choice. Please enter from the given # choices.");
            }
        }
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        if (vehicles.isEmpty()){
            System.out.println("No vehicles found.");
        }
        System.out.println("-------- Inventory --------");
        for (Vehicle v : vehicles) {
            System.out.printf("VIN: %d | %d %s %s | Type: %s | Color: %s | Miles: %d | Price: $%.2f%n",
                    v.getVin(), v.getYear(), v.getMake(), v.getModel(),
                    v.getVehicleType(), v.getColor(), v.getOdometer(), v.getPrice());
        }
    }

    private void processGetByPriceRequest() {
    }

    private void processGetByMakeModelRequest() {
    }

    private void processGetByYearRequest() {
    }

    private void processGetByColorRequest() {
    }

    private void processGetByMileageRequest() {
    }

    private void processGetByVehicleTypeRequest() {
    }

    private void processGetAllVehiclesRequest() {
        List<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }

    private void processAddVehicleRequest() {
    }

    private void processRemoveVehicleRequest() {
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ppp;
import java.util.*;
/**
 *
 * @author Omar_Lord_War
 */


import java.util.*;




public class PPP {
    public static void main(String[] args) {
        Admin admin = new Admin();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Are you an admin? (yes/no): ");
            String response = scanner.next();
            if (response.equalsIgnoreCase("yes")) {
                if (admin.authenticateAdmin()) {
                    System.out.println("Admin authentication successful.");
                    admin.adminOperations();
                } else {
                    System.out.println("Incorrect password. Access denied.");
                }
            } else if(response.equalsIgnoreCase("no")){
                User.UserMenu();
                User.UserOperations();
            } else {
                System.out.println("Invalid choice. Please try again using 'yes' or 'no'.");
            }

        }
    }
}

class Medicine extends Patient {
    private String price;
    private String dose;

    public Medicine(String name , String price , String dose) {
        this.name = name;
        this.price = price;
        this.dose = dose;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }
    public String getDose() {
        return dose;
    }

}




class Patient {
    String name;
    String id;
    String age;
    List<Medicine> medicines;


    public Patient() {
        this.medicines = new ArrayList<>();
    }

    public void addMedicine(Medicine medicine) {
        medicines.add(medicine);
    }

    public void removeMedicine(String medicineName) {
        medicines.removeIf(medicine -> medicine.getName().equalsIgnoreCase(medicineName));
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }
}


class Admin  {

    private static final String ADMIN_PASSWORD = "The_Void";
    private static final List<Patient> patientList = new ArrayList<>();

    boolean authenticateAdmin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the admin password: ");
        String password = scanner.next();
        return password.equals(ADMIN_PASSWORD);
    }

    private void addPatient(Patient patient) {
        patientList.add(patient);
    }

    private void deletePatient(String id) {
        for (Patient patient : patientList) {
            if (patient.id.equals(id)) {
                patientList.remove(patient);
                System.out.println("Patient deleted");
                return;
            }
        }
        System.out.println("Patient not found");
    }

    public static void searchPatient(String id) {
        for (Patient patient : patientList) {
            if (patient.id.equals(id)) {
                printPatientInfo(patient);
                return;
            }
        }
        System.out.println("Patient not found");
    }

    private void editPatient(String id, Patient newPatient) {
        for (Patient patient : patientList) {
            if (patient.id.equals(id)) {
                patientList.remove(patient);
                patientList.add(newPatient);
                System.out.println("Patient updated");
                return;
            }
        }
        System.out.println("Patient not found");
    }


    public void removeMedicine(String patientId, String medicineName) {
        for (Patient patient : patientList) {
            if (patient.id.equals(patientId)) {
                patient.removeMedicine(medicineName);
                System.out.println("Medicine removed from patient.");
                return;
            }
        }
        System.out.println("Patient not found.");
    }


    private void sortPatients() {
        Collections.sort(patientList, Comparator.comparing(patient -> patient.name));
        System.out.println("Patients sorted by name");
    }

    private void displayPatients() {
        for (Patient patient : patientList) {
            printPatientInfo(patient);
        }
    }

    private static void printPatientInfo(Patient patient) {
        System.out.println("##############################");
        System.out.println("Patient Name: " + patient.name);
        System.out.println("Patient ID: " + patient.id);
        System.out.println("Patient Age: " + patient.age);


        List<Medicine> medicines = patient.getMedicines();
        if (!medicines.isEmpty()) {
            System.out.println("Medicines:");
            for (Medicine medicine : medicines) {
                System.out.println("  - Name: " + medicine.getName());
                System.out.println("    Price: " + medicine.getPrice());
                System.out.println("    Dose: " + medicine.getDose());
            }
        } else {
            System.out.println("No medicines associated with this patient.");
        }


        System.out.println("##############################");
    }

    public void adminOperations() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            adminMenu();
            String choice = scanner.next();

            switch (choice) {
                case "1":
                    addPatient(createPatient());
                    break;
                case "2":
                    System.out.println("Enter patient ID to delete: ");
                    String id = scanner.next();
                    deletePatient(id);
                    break;
                case "3":
                    System.out.println("Enter patient ID to search: ");
                    String searchId = scanner.next();
                    searchPatient(searchId);
                    break;
                case "4":
                    System.out.println("Enter patient ID to edit: ");
                    String editId = scanner.next();
                    editPatient(editId, createPatient());
                    break;
                case "5":
                    sortPatients();
                    break;
                case "6":
                    displayPatients();
                    break;

                case "7":
                    System.out.println("Enter patient ID to remove medicine from: ");
                    String patientIdToRemoveMedicine = scanner.next();
                    System.out.println("Enter medicine name to remove: ");
                    String medicineNameToRemove = scanner.next();
                    removeMedicine(patientIdToRemoveMedicine, medicineNameToRemove);
                    break;

                case "8":
                    System.out.println("Enter patient ID to show medicines: ");
                    String showMedicinesId = scanner.next();
                    showPatientMedicines(showMedicinesId);
                    break;

                case "9":
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void adminMenu() {
        System.out.println("1. Add Patient");
        System.out.println("2. Delete Patient");
        System.out.println("3. Search Patient");
        System.out.println("4. Edit Patient");
        System.out.println("5. Sort Patients");
        System.out.println("6. Display Patients");
        System.out.println("7. Delete Medicine");
        System.out.println("8. Show patient Medicine");
        System.out.println("9. Exit");
        System.out.print("Enter your choice: ");
    }

    private Patient createPatient() {
        Scanner scanner = new Scanner(System.in);
        Patient patient = new Patient();

        System.out.println("Enter patient name: ");
        patient.name = scanner.next();

        System.out.println("Enter patient ID: ");
        patient.id = scanner.next();

        System.out.println("Enter patient age: ");
        patient.age = scanner.next();

        List<Medicine> medicines = new ArrayList<>();
        while (true) {
            System.out.println("Do you want to add a medicine ? (yes/no): ");
            String response = scanner.next();
            if (response.equalsIgnoreCase("yes")) {
                Medicine medicine = createMedicine();
                medicines.add(medicine);
                patient.medicines = medicines;
            } else if(response.equalsIgnoreCase("no")){
                break;
            } else {
                System.out.println("Invalid choice. Please try again using 'yes' or 'no'.");
            }

        }
        return patient;
    }

    private Medicine createMedicine() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter medicine name: ");
        String name = scanner.next();
        System.out.println("Enter medicine price: ");
        String price = scanner.next();
        System.out.println("Enter patient dose: ");
        String dose = scanner.next();
        return new Medicine(name,price,dose);
    }

    static void showPatientMedicines(String patientId) {
        for (Patient patient : patientList) {
            if (patient.id.equals(patientId)) {
                List<Medicine> medicines = patient.getMedicines();
                if (!medicines.isEmpty()) {
                    System.out.println("Medicines for Patient " + patient.name + " (ID: " + patient.id + "):");
                    for (Medicine medicine : medicines) {
                        System.out.println("  - Name: " + medicine.getName());
                        System.out.println("    Price: " + medicine.getPrice());
                        System.out.println("    Dose: " + medicine.getDose());
                    }
                } else {
                    System.out.println("No medicines associated with this patient.");
                }
                return;
            }
        }
        System.out.println("Patient not found.");
    }
}




class User extends Admin{
    static void UserMenu() {
        System.out.println("Welcome! You are a regular user.");
        System.out.println("1. Search Patient");
        System.out.println("2. Show Patient Medicines");
        System.out.println("9. Log out");
        System.out.print("Enter your choice: ");
    }
    static void UserOperations() {
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();
        switch (choice) {
            case "1":
                System.out.println("Enter patient ID to search: ");
                String searchId = scanner.next();
                Admin.searchPatient(searchId);
                break;

            case "2":
                System.out.println("Enter patient ID to show medicines: ");
                String showMedicinesId = scanner.next();
                showPatientMedicines(showMedicinesId);
                break;

            case "9":
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}







/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pp;
import java.util.*;

class Patient {
    String name;
    Float id;
    int age;
    String medicine;
    String dose;
}

public class Pp {
    private static List<Patient> patientList = new ArrayList<>();

    private static Patient createPatient() {
        Scanner scanner = new Scanner(System.in);
        Patient patient = new Patient();

        System.out.println("Enter patient name: ");
        patient.name = scanner.next();

        System.out.println("Enter patient ID: ");
        patient.id = scanner.nextFloat();

        System.out.println("Enter patient age: ");
        patient.age = scanner.nextInt();

        System.out.println("Enter patient medicine: ");
        patient.medicine = scanner.next();

        System.out.println("Enter patient dose: ");
        patient.dose = scanner.next();

        return patient;
    }

    private static void addPatient() {
        patientList.add(createPatient());
    }

    private static void deletePatient() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter patient ID to delete: ");
        int id = scanner.nextInt();

        Patient toRemove = null;
        for (Patient patient : patientList) {
            if (patient.id == id) {
                toRemove = patient;
                break;
            }
        }

        if (toRemove != null) {
            patientList.remove(toRemove);
            System.out.println("Patient deleted");
        } else {
            System.out.println("Patient not found");
        }
    }

    private static void searchPatient() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter patient ID to search: ");
        int id = scanner.nextInt();

        for (Patient patient : patientList) {
            if (patient.id == id) {
                printPatientInfo(patient);
                return;
            }
        }
        System.out.println("Patient not found");
    }

    private static void editPatient() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter patient ID to edit: ");
        int id = scanner.nextInt();

        for (Patient patient : patientList) {
            if (patient.id == id) {
                patientList.remove(patient);
                System.out.println("Enter new patient details:");
                patientList.add(createPatient());
                System.out.println("Patient updated");
                return;
            }
        }
        System.out.println("Patient not found");
    }

    private static void sortPatients() {
        Collections.sort(patientList, Comparator.comparing(patient -> patient.name));
        System.out.println("Patients sorted by name");
    }

    private static void displayPatients() {
        for (Patient patient : patientList) {
            printPatientInfo(patient);
        }
    }

    private static void printPatientInfo(Patient patient) {
        System.out.println("##############################");
        System.out.println("Patient Name: " + patient.name);
        System.out.println("Patient ID: " + patient.id);
        System.out.println("Patient Age: " + patient.age);
        System.out.println("Patient Medicine: " + patient.medicine);
        System.out.println("Patient Dose: " + patient.dose);
        System.out.println("##############################");
    }

    private static void printMenu() {
        System.out.println("1. Add Patient");
        System.out.println("2. Delete Patient");
        System.out.println("3. Search Patient");
        System.out.println("4. Edit Patient");
        System.out.println("5. Sort Patients");
        System.out.println(
                "6. Display Patients");
        System.out.println("9. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void main(String[] args) {
        while(true) {
            printMenu();

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch(choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    deletePatient();
                    break;
                case 3:
                    searchPatient();
                    break;
                case 4:
                    editPatient();
                    break;
                case 5:
                    sortPatients();
                    break;
                case 6:
                    displayPatients();
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DisasterManagement {

    static class Shelter {
        String name;
        String address;
        int capacity;
        int currentOccupants;
        List<String> resources;

        public Shelter(String name, String address, int capacity) {
            this.name = name;
            this.address = address;
            this.capacity = capacity;
            this.currentOccupants = 0;
            this.resources = new ArrayList<>();
        }

        public boolean addOccupants(int num) {
            if (currentOccupants + num <= capacity) {
                currentOccupants += num;
                return true;
            } else {
                return false;
            }
        }

        public void addResource(String resource) {
            resources.add(resource);
        }

        @Override
        public String toString() {
            return "Shelter Name: " + name + ", Address: " + address + ", Capacity: " + capacity + ", Current Occupants: " + currentOccupants + ", Resources: " + resources;
        }
    }

    static class Volunteer {
        String name;
        String contact;
        String skills;

        public Volunteer(String name, String contact, String skills) {
            this.name = name;
            this.contact = contact;
            this.skills = skills;
        }

        @Override
        public String toString() {
            return "Volunteer Name: " + name + ", Contact: " + contact + ", Skills: " + skills;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Shelter> shelters = new ArrayList<>();
        Map<String, Volunteer> volunteers = new HashMap<>();

        while (true) {
            System.out.println("\nDisaster Management System");
            System.out.println("1. Add Shelter");
            System.out.println("2. View Shelters");
            System.out.println("3. Add Occupants to Shelter");
            System.out.println("4. Add Resource to Shelter");
            System.out.println("5. Register Volunteer");
            System.out.println("6. View Volunteers");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Shelter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter Capacity: ");
                    int capacity = scanner.nextInt();
                    shelters.add(new Shelter(name, address, capacity));
                    System.out.println("Shelter added successfully.");
                    break;
                case 2:
                    System.out.println("\nList of Shelters:");
                    for (Shelter shelter : shelters) {
                        System.out.println(shelter);
                    }
                    break;
                case 3:
                    System.out.print("Enter Shelter Name: ");
                    String shelterName = scanner.nextLine();
                    Shelter selectedShelter = null;
                    for (Shelter shelter : shelters) {
                        if (shelter.name.equalsIgnoreCase(shelterName)) {
                            selectedShelter = shelter;
                            break;
                        }
                    }
                    if (selectedShelter != null) {
                        System.out.print("Enter number of occupants to add: ");
                        int occupants = scanner.nextInt();
                        if (selectedShelter.addOccupants(occupants)) {
                            System.out.println("Occupants added successfully.");
                        } else {
                            System.out.println("Not enough capacity to add occupants.");
                        }
                    } else {
                        System.out.println("Shelter not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Shelter Name: ");
                    String shelterNameForResource = scanner.nextLine();
                    Shelter shelterForResource = null;
                    for (Shelter shelter : shelters) {
                        if (shelter.name.equalsIgnoreCase(shelterNameForResource)) {
                            shelterForResource = shelter;
                            break;
                        }
                    }
                    if (shelterForResource != null) {
                        System.out.print("Enter resource to add: ");
                        String resource = scanner.nextLine();
                        shelterForResource.addResource(resource);
                        System.out.println("Resource added successfully.");
                    } else {
                        System.out.println("Shelter not found.");
                    }
                    break;
                case 5:
                    System.out.print("Enter Volunteer Name: ");
                    String volunteerName = scanner.nextLine();
                    System.out.print("Enter Contact: ");
                    String contact = scanner.nextLine();
                    System.out.print("Enter Skills: ");
                    String skills = scanner.nextLine();
                    volunteers.put(volunteerName.toLowerCase(), new Volunteer(volunteerName, contact, skills));
                    System.out.println("Volunteer registered successfully.");
                    break;
                case 6:
                    System.out.println("\nList of Volunteers:");
                    for (Volunteer volunteer : volunteers.values()) {
                        System.out.println(volunteer);
                    }
                    break;
                case 7:
                    System.out.println("Exiting the system. Stay safe!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

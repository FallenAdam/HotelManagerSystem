import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

class Hotel {
    static ArrayList<Food> menu = new ArrayList<>();

    static {
        readMenuFromFile("menu.txt");
    }

    static void readMenuFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int itemno = Integer.parseInt(parts[0]);
                String itemName = parts[1];
                float price = Float.parseFloat(parts[2]);
                menu.add(new Food(itemno, itemName, 0, price));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static holder hotel_ob = new holder();
    static Scanner sc = new Scanner(System.in);

    static void CustDetails(int i, int rn) {
        String name, contact, gender;
        String name2 = null, contact2 = null;
        String gender2 = "";
        System.out.print("\nEnter customer name: ");
        name = sc.next();
        System.out.print("Enter contact number: ");
        contact = sc.next();
        System.out.print("Enter gender: ");
        gender = sc.next();
        if (i < 3) {
            System.out.print("Enter second customer name: ");
            name2 = sc.next();
            System.out.print("Enter contact number: ");
            contact2 = sc.next();
            System.out.print("Enter gender: ");
            gender2 = sc.next();
        }

        switch (i) {
            case 1:
                hotel_ob.luxury_doubleroom[rn] = new Doubleroom(name, contact, gender, name2, contact2, gender2);
                break;
            case 2:
                hotel_ob.deluxe_doubleroom[rn] = new Doubleroom(name, contact, gender, name2, contact2, gender2);
                break;
            case 3:
                hotel_ob.luxury_singleroom[rn] = new Singleroom(name, contact, gender);
                break;
            case 4:
                hotel_ob.deluxe_singleroom[rn] = new Singleroom(name, contact, gender);
                break;
            default:
                System.out.println("Wrong option");
                break;
        }
    }

    static void bookroom(int i) {
        int j;
        int rn;
        System.out.println("\nChoose room number from : ");
        switch (i) {
            case 1:
                for (j = 0; j < hotel_ob.luxury_doubleroom.length; j++) {
                    if (hotel_ob.luxury_doubleroom[j] == null) {
                        System.out.print(j + 1 + ",");
                    }
                }
                System.out.print("\nEnter room number: ");
                try {
                    rn = sc.nextInt();
                    rn--;
                    if (hotel_ob.luxury_doubleroom[rn] != null)
                        throw new NotAvailable();
                    CustDetails(i, rn);
                } catch (Exception e) {
                    System.out.println("Invalid Option");
                    return;
                }
                break;
            case 2:
                for (j = 0; j < hotel_ob.deluxe_doubleroom.length; j++) {
                    if (hotel_ob.deluxe_doubleroom[j] == null) {
                        System.out.print(j + 11 + ",");
                    }
                }
                System.out.print("\nEnter room number: ");
                try {
                    rn = sc.nextInt();
                    rn = rn - 11;
                    if (hotel_ob.deluxe_doubleroom[rn] != null)
                        throw new NotAvailable();
                    CustDetails(i, rn);
                } catch (Exception e) {
                    System.out.println("Invalid Option");
                    return;
                }
                break;
            case 3:
                for (j = 0; j < hotel_ob.luxury_singleroom.length; j++) {
                    if (hotel_ob.luxury_singleroom[j] == null) {
                        System.out.print(j + 31 + ",");
                    }
                }
                System.out.print("\nEnter room number: ");
                try {
                    rn = sc.nextInt();
                    rn = rn - 31;
                    if (hotel_ob.luxury_singleroom[rn] != null)
                        throw new NotAvailable();
                    CustDetails(i, rn);
                } catch (Exception e) {
                    System.out.println("Invalid Option");
                    return;
                }
                break;
            case 4:
                for (j = 0; j < hotel_ob.deluxe_singleroom.length; j++) {
                    if (hotel_ob.deluxe_singleroom[j] == null) {
                        System.out.print(j + 41 + ",");
                    }
                }
                System.out.print("\nEnter room number: ");
                try {
                    rn = sc.nextInt();
                    rn = rn - 41;
                    if (hotel_ob.deluxe_singleroom[rn] != null)
                        throw new NotAvailable();
                    CustDetails(i, rn);
                } catch (Exception e) {
                    System.out.println("Invalid Option");
                    return;
                }
                break;
            default:
                System.out.println("Enter valid option");
                break;
        }
        System.out.println("Room Booked");
    }

    static void features(int i) {
        switch (i) {
            case 1:
                System.out.println("Number of double beds : 1\nAC : Yes\nFree breakfast : Yes\nCharge per day:4000 ");
                break;
            case 2:
                System.out.println("Number of double beds : 1\nAC : No\nFree breakfast : Yes\nCharge per day:3000  ");
                break;
            case 3:
                System.out.println("Number of single beds : 1\nAC : Yes\nFree breakfast : Yes\nCharge per day:2200  ");
                break;
            case 4:
                System.out.println("Number of single beds : 1\nAC : No\nFree breakfast : Yes\nCharge per day:1200 ");
                break;
            default:
                System.out.println("Enter valid option");
                break;
        }
    }

    static void availability(int i) {
        int j, count = 0;
        switch (i) {
            case 1:
                for (j = 0; j < 10; j++) {
                    if (hotel_ob.luxury_doubleroom[j] == null)
                        count++;
                }
                break;
            case 2:
                for (j = 0; j < 20; j++) {
                    if (hotel_ob.deluxe_doubleroom[j] == null)
                        count++;
                }
                break;
            case 3:
                for (j = 0; j < 10; j++) {
                    if (hotel_ob.luxury_singleroom[j] == null)
                        count++;
                }
                break;
            case 4:
                for (j = 0; j < 20; j++) {
                    if (hotel_ob.deluxe_singleroom[j] == null)
                        count++;
                }
                break;
            default:
                System.out.println("Enter valid option");
                break;
        }
        System.out.println("Number of rooms available : " + count);
    }


    static void bill(int rn, int rtype) {
        double roomCharge = 0;
        double foodCharge = 0;

        // Calculate room charge based on room type
        switch (rtype) {
            case 1:
                roomCharge = 4000;
                break;
            case 2:
                roomCharge = 3000;
                break;
            case 3:
                roomCharge = 2200;
                break;
            case 4:
                roomCharge = 1200;
                break;
            default:
                System.out.println("Invalid Room Type");
                return;
        }

        // Calculate food charge
        ArrayList<Food> foodList = getFoodList(rn, rtype);
        for (Food item : foodList) {
            foodCharge += item.price * item.quantity;
        }

        // Calculate total amount
        double totalAmount = roomCharge + foodCharge;

        // Print the bill
        printBill(rn, rtype, roomCharge, foodCharge, totalAmount);

        // Write the bill to the revenue file
        writeRevenueToFile(rtype, totalAmount);
    }

    static ArrayList<Food> getFoodList(int rn, int rtype) {
        switch (rtype) {
            case 1:
                return hotel_ob.luxury_doubleroom[rn].food;
            case 2:
                return hotel_ob.deluxe_doubleroom[rn].food;
            case 3:
                return hotel_ob.luxury_singleroom[rn].food;
            case 4:
                return hotel_ob.deluxe_singleroom[rn].food;
            default:
                return new ArrayList<>(); // Return empty list for invalid room type
        }
    }

    static void printBill(int rn, int rtype, double roomCharge, double foodCharge, double totalAmount) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        System.out.println("\n********************************************");
        System.out.println("************* "+ Main.hotel+" ****************");
        System.out.println("                  Bill");
        System.out.println("********************************************");
        System.out.println("Date and Time: " + formattedDateTime);
        System.out.println("Room Type: " + getRoomTypeName(rtype));
        System.out.println("Room Charge: $" + roomCharge);
        System.out.println("Food Charge: $" + foodCharge);
        System.out.println("Total Amount: $" + totalAmount);
        System.out.println("********************************************");
    }

    static void writeRevenueToFile(int rtype, double totalAmount) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("revenue.txt", true))) {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = now.format(formatter);

            String roomTypeName = getRoomTypeName(rtype);

            // Write the revenue data to the file
            writer.write(formattedDateTime + "\t" + roomTypeName + "\t$" + totalAmount);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error writing revenue: " + e.getMessage());
        }
    }

    // Helper method to get the room type name
    static String getRoomTypeName(int rtype) {
        switch (rtype) {
            case 1:
                return "Luxury Double Room";
            case 2:
                return "Deluxe Double Room";
            case 3:
                return "Luxury Single Room";
            case 4:
                return "Deluxe Single Room";
            default:
                return "Unknown Room Type";
        }
    }

    static void readRevenue() {
        try (BufferedReader reader = new BufferedReader(new FileReader("revenue.txt"))) {
            System.out.println("Date and Time\t\t\tRoom Type\t\t\tTotal Amount");
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");
                String formattedDateTime = parts[0];
                String roomType = parts[1];
                double totalAmount = Double.parseDouble(parts[2].substring(1)); // Remove the dollar sign
                System.out.printf("%s\t\t%s\t\t$%.2f\n", formattedDateTime, roomType, totalAmount);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    static void deallocate(int rn, int rtype) {
        char w;
        switch (rtype) {
            case 1:
                if (hotel_ob.luxury_doubleroom[rn] != null)
                    System.out.println("Room used by " + hotel_ob.luxury_doubleroom[rn].name);
                else {
                    System.out.println("Empty Already");
                    return;
                }
                System.out.println("Do you want to checkout ?(y/n)");
                w = sc.next().charAt(0);
                if (w == 'y' || w == 'Y') {
                    bill(rn, rtype);
                    hotel_ob.luxury_doubleroom[rn] = null;
                    System.out.println("Deallocated successfully");
                }
                break;
            case 2:
                if (hotel_ob.deluxe_doubleroom[rn] != null)
                    System.out.println("Room used by " + hotel_ob.deluxe_doubleroom[rn].name);
                else {
                    System.out.println("Empty Already");
                    return;
                }
                System.out.println(" Do you want to checkout ?(y/n)");
                w = sc.next().charAt(0);
                if (w == 'y' || w == 'Y') {
                    bill(rn, rtype);
                    hotel_ob.deluxe_doubleroom[rn] = null;
                    System.out.println("Deallocated successfully");
                }
                break;
            case 3:
                if (hotel_ob.luxury_singleroom[rn] != null)
                    System.out.println("Room used by " + hotel_ob.luxury_singleroom[rn].name);
                else {
                    System.out.println("Empty Already");
                    return;
                }
                System.out.println(" Do you want to checkout ? (y/n)");
                w = sc.next().charAt(0);
                if (w == 'y' || w == 'Y') {
                    bill(rn, rtype);
                    hotel_ob.luxury_singleroom[rn] = null;
                    System.out.println("Deallocated successfully");
                }
                break;
            case 4:
                if (hotel_ob.deluxe_singleroom[rn] != null)
                    System.out.println("Room used by " + hotel_ob.deluxe_singleroom[rn].name);
                else {
                    System.out.println("Empty Already");
                    return;
                }
                System.out.println(" Do you want to checkout ? (y/n)");
                w = sc.next().charAt(0);
                if (w == 'y' || w == 'Y') {
                    bill(rn, rtype);
                    hotel_ob.deluxe_singleroom[rn] = null;
                    System.out.println("Deallocated successfully");
                }
                break;
            default:
                System.out.println("\nEnter valid option : ");
                break;
        }
    }

    static void order(int rn, int rtype) {
        int i, q;
        char wish;
        try {
            System.out.println("\n==========\n   Menu:  \n==========");
            System.out.println("Item No\tItem Name\tPrice");
            for (Food item : menu) {
                System.out.println(item.itemno + "\t" + item.itemName + "\t" + item.price);
            }
            ArrayList<Food> orderedItems = new ArrayList<>();
            do {
                System.out.println("\nEnter item number to order: ");
                i = sc.nextInt();
                System.out.print("Quantity- ");
                q = sc.nextInt();

                // Find the ordered food item in the menu
                Food orderedFood = null;
                for (Food item : menu) {
                    if (item.itemno == i) {
                        orderedFood = item;
                        break;
                    }
                }

                if (orderedFood != null) {
                    orderedItems.add(new Food(orderedFood.itemno, orderedFood.itemName, q, orderedFood.price)); // Pass quantity to constructor
                } else {
                    System.out.println("Invalid item number.");
                }

                System.out.println("Do you want to order anything else ? (y/n)");
                wish = sc.next().charAt(0);
            } while (wish == 'y' || wish == 'Y');

            // Store the ordered food items in the appropriate room
            switch (rtype) {
                case 1:
                    hotel_ob.luxury_doubleroom[rn].food.addAll(orderedItems);
                    break;
                case 2:
                    hotel_ob.deluxe_doubleroom[rn].food.addAll(orderedItems);
                    break;
                case 3:
                    hotel_ob.luxury_singleroom[rn].food.addAll(orderedItems);
                    break;
                case 4:
                    hotel_ob.deluxe_singleroom[rn].food.addAll(orderedItems);
                    break;
            }

        } catch (NullPointerException e) {
            System.out.println("\nRoom not booked");
        } catch (Exception e) {
            System.out.println("Cannot be done");
        }
    }
}
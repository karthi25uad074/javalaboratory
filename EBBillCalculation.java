import java.util.Scanner;

public class EBBillCalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int consumerNo, previousReading, currentReading, units;
        String consumerName, connectionType;
        double bill = 0;

        System.out.print("Enter Consumer Number: ");
        consumerNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Consumer Name: ");
        consumerName = sc.nextLine();

        System.out.print("Enter Connection Type (Domestic/Commercial): ");
        connectionType = sc.nextLine();

        System.out.print("Enter Previous Meter Reading: ");
        previousReading = sc.nextInt();

        System.out.print("Enter Current Meter Reading: ");
        currentReading = sc.nextInt();

        units = currentReading - previousReading;

        if (units < 0) {
            System.out.println("Invalid Meter Reading!");
            return;
        }

        if (connectionType.equalsIgnoreCase("Domestic")) {

            if (units <= 100) {
                bill = 0;
            } else if (units <= 200) {
                bill = (units - 100) * 2;
            } else if (units <= 500) {
                bill = (100 * 2) + ((units - 200) * 4);
            } else {
                bill = (100 * 2) + (300 * 4) + ((units - 500) * 6);
            }

        } else if (connectionType.equalsIgnoreCase("Commercial")) {

            if (units <= 100) {
                bill = units * 2;
            } else if (units <= 200) {
                bill = (100 * 2) + ((units - 100) * 4);
            } else if (units <= 500) {
                bill = (100 * 2) + (100 * 4) + ((units - 200) * 6);
            } else {
                bill = (100 * 2) + (100 * 4) + (300 * 6) + ((units - 500) * 7);
            }

        } else {
            System.out.println("Invalid Connection Type!");
            return;
        }

        System.out.println("\n----- EB BILL -----");
        System.out.println("Consumer Number : " + consumerNo);
        System.out.println("Consumer Name   : " + consumerName);
        System.out.println("Connection Type : " + connectionType);
        System.out.println("Units Consumed  : " + units);
        System.out.println("Total Bill      : Rs. " + bill);

        sc.close();
    }
}

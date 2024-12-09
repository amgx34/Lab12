import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSaver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> records = new ArrayList<>();
        boolean moreRecords = true;

        while (moreRecords) {
            System.out.print("Enter First Name: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter Last Name: ");
            String lastName = scanner.nextLine();
            System.out.print("Enter ID Number: ");
            String idNumber = scanner.nextLine();
            System.out.print("Enter Email: ");
            String email = scanner.nextLine();
            System.out.print("Enter Year of Birth: ");
            String yearOfBirth = scanner.nextLine();

            records.add(firstName + "," + lastName + "," + idNumber + "," + email + "," + yearOfBirth);

            System.out.print("Add another record? (yes/no): ");
            String response = scanner.nextLine();
            moreRecords = response.equalsIgnoreCase("yes");
        }

        System.out.print("Enter output file name (with .csv extension): ");
        String fileName = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("./src/" + fileName))) {
            for (String record : records) {
                writer.write(record);
                writer.newLine();
            }
            System.out.println("Data saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

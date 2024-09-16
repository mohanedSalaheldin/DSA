package impls;

import java.io.*;
import java.net.*;
import java.util.*;

public class RanNumsClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345)) {
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter the number of random numbers:");
            int count = scanner.nextInt();
            System.out.println("Enter the minimum range:");
            int min = scanner.nextInt();
            System.out.println("Enter the maximum range:");
            int max = scanner.nextInt();

            output.writeInt(count);
            output.writeInt(min);
            output.writeInt(max);

            int receivedCount = input.readInt();
            System.out.println("Random numbers received from server:");
            for (int i = 0; i < receivedCount; i++) {
                System.out.println(input.readInt());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}


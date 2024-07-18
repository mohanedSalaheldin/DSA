import java.io.*;
import java.net.*;
import java.util.*;



public class RanNumsServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server is listening on port 12345");
            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    System.out.println("Client connected");
                    DataInputStream input = new DataInputStream(socket.getInputStream());
                    DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                    int count = input.readInt();
                    int min = input.readInt();
                    int max = input.readInt();
                    Set<Integer> randomNumbers = generateRandomNumbers(count, min, max);
                    output.writeInt(randomNumbers.size());
                    for (int number : randomNumbers) {
                        output.writeInt(number);
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static Set<Integer> generateRandomNumbers(int count, int min, int max) {
        Set<Integer> numbers = new HashSet<>();
        Random random = new Random();
        while (numbers.size() < count) {
            int number = random.nextInt((max - min) + 1) + min;
            numbers.add(number);
        }
        return numbers;
    }
}


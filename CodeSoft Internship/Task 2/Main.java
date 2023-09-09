import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = "";

        System.out.println("Word Counter Application");
        System.out.println("1. Enter text");
        System.out.println("2. Read from a file");
        System.out.print("Choose an option (1 or 2): ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (choice == 1) {
            System.out.print("Enter your text: ");
            text = scanner.nextLine();
        } else if (choice == 2) {
            System.out.print("Enter the file path: ");
            String filePath = scanner.nextLine();
            try {
                text = readFromFile(filePath);
            } catch (IOException e) {
                System.err.println("Error reading from the file: " + e.getMessage());
                System.exit(1);
            }
        } else {
            System.out.println("Invalid choice. Exiting.");
            System.exit(1);
        }

        scanner.close();

        // Split the text into words using space or punctuation as delimiters
        String[] words = text.split("[\\s\\p{Punct}]+");

        // Initialize a counter variable to keep track of the number of words
        int wordCount = words.length;

        // Create a map to store word frequency
        Map<String, Integer> wordFrequency = new HashMap<>();

        // Populate word frequency map and ignore common words
        for (String word : words) {
            word = word.toLowerCase(); // Convert to lowercase for case-insensitive counting
            if (!isCommonWord(word)) {
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        }

        // Display the total word count
        System.out.println("Total word count: " + wordCount);

        // Display word frequency statistics
        System.out.println("\nWord Frequency Statistics:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Read text from a file and return it as a string
    private static String readFromFile(String filePath) throws IOException {
        StringBuilder text = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                text.append(line).append(" ");
            }
        }
        return text.toString();
    }

    // Define a list of common words to ignore during word counting
    private static boolean isCommonWord(String word) {
        String[] commonWords = {"the", "and", "in", "to", "of", "a", "for", "on", "with", "as", "an", "by"};
        for (String common : commonWords) {
            if (word.equals(common)) {
                return true;
            }
        }
        return false;
    }
}

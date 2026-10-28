import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

public class LogAnalyzer {
    public static void main(String[] args) {
        Path[] files = {
            Paths.get("app1.txt"),
            Paths.get("app2.txt"),
            Paths.get("app3.txt")
        };

        String[][] data = {
            {"Application started", "ERROR: Connection failed",
             "Application stopped"},
            {"User logged in", "ERROR: Invalid input"},
            {"System running", "All services active",
             "ERROR: File missing"}
        };

        try {
            // Create sample text files
            for (int i = 0; i < files.length; i++) {
                Files.write(files[i], List.of(data[i]));
            }

            int totalLines = 0;
            int errorLines = 0;

            // Analyze each file
            for (Path file : files) {
                int fileLines = 0;

                for (String line : Files.readAllLines(file)) {
                    fileLines++;
                    totalLines++;

                    if (line.contains("ERROR")) {
                        errorLines++;
                    }
                }

                BasicFileAttributes attr =
                    Files.readAttributes(
                        file, BasicFileAttributes.class
                    );

                System.out.println("File: " + file.getFileName());
                System.out.println("Lines: " + fileLines);
                System.out.println("Size: " + attr.size() + " bytes");
                System.out.println();
            }

            System.out.println("Total lines: " + totalLines);
            System.out.println("Lines containing ERROR: " + errorLines);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
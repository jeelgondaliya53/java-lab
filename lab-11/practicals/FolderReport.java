import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FolderReport {
    public static void main(String[] args) {
        Path root = Paths.get(".");

        Path report = Paths.get("folder_report.txt");

        try {
            StringBuilder result = new StringBuilder();

            result.append("FOLDER TREE REPORT\n");
            result.append("==================\n");

            Files.walkFileTree(root, new SimpleFileVisitor<Path>() {

                @Override
                public FileVisitResult visitFile(
                    Path file, BasicFileAttributes attrs
                ) throws IOException {

                    if (!file.toAbsolutePath().normalize()
                            .equals(report.toAbsolutePath().normalize())) {

                        result.append("Name: ")
                              .append(file)
                              .append("\n");

                        result.append("Size: ")
                              .append(attrs.size())
                              .append(" bytes\n");

                        result.append("Modified: ")
                              .append(attrs.lastModifiedTime())
                              .append("\n\n");
                    }

                    return FileVisitResult.CONTINUE;
                }
            });

            Files.writeString(report, result.toString());

            System.out.println("Report created successfully.");
            System.out.println("Saved to: " + report.toAbsolutePath());

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
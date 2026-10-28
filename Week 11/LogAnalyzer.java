import java.io.*;
import java.nio.file.*;
import java.util.*;

public class LogAnalyzer {

    public static void main(String[] args) {

        String keyword = "ERROR";

        try {
            Files.write(
                Path.of("log1.txt"),
                Arrays.asList(
                    "INFO: Program started",
                    "ERROR: File not found",
                    "INFO: Processing data",
                    "ERROR: Invalid input"
                )
            );

            Files.write(
                Path.of("log2.txt"),
                Arrays.asList(
                    "INFO: User logged in",
                    "INFO: Data loaded",
                    "ERROR: Database connection failed",
                    "INFO: Program completed"
                )
            );

            System.out.println("Log files created.\n");

        } catch (IOException e) {
            System.out.println("Error creating files: " + e);
        }

        int totalLines = 0;
        int keywordLines = 0;

        try {
            Path[] files = {
                Path.of("log1.txt"),
                Path.of("log2.txt")
            };

            for (Path file : files) {

                int fileLines = 0;
                int fileKeywordLines = 0;

                try (BufferedReader reader =
                         Files.newBufferedReader(file)) {

                    String line;

                    while ((line = reader.readLine()) != null) {

                        fileLines++;
                        totalLines++;

                        if (line.contains(keyword)) {
                            fileKeywordLines++;
                            keywordLines++;
                        }
                    }
                }

                long size = Files.size(file);

                System.out.println("File: " + file.getFileName());
                System.out.println("Size: " + size + " bytes");
                System.out.println("Total Lines: " + fileLines);
                System.out.println("Lines containing " + keyword + ": "
                                   + fileKeywordLines);
                System.out.println();
            }

            System.out.println("----- Overall Result -----");
            System.out.println("Total Lines: " + totalLines);
            System.out.println("Total Lines containing " + keyword + ": "
                               + keywordLines);

        } catch (IOException e) {
            System.out.println("Error reading files: " + e);
        }
    }
}
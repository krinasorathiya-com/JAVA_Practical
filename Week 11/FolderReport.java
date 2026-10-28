import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.stream.*;

public class FolderReport {

    public static void main(String[] args) {

        Path folder = Path.of("MyFolder");
        Path report = Path.of("folder_report.txt");

        try {

            if (!Files.exists(folder)) {
                Files.createDirectory(folder);

                Files.write(
                    folder.resolve("file1.txt"),
                    "This is first file.".getBytes()
                );

                Files.write(
                    folder.resolve("file2.txt"),
                    "This is second file.".getBytes()
                );

                System.out.println("Sample folder and files created.");
            }

            try (BufferedWriter writer =
                    Files.newBufferedWriter(report)) {

                writer.write("FOLDER FILE REPORT");
                writer.newLine();
                writer.write("==================");
                writer.newLine();

                try (Stream<Path> paths = Files.walk(folder)) {

                    paths.filter(Files::isRegularFile)
                        .forEach(path -> {

                        try {

                            long size = Files.size(path);

                            FileTime modifiedTime =
                                Files.getLastModifiedTime(path);

                            writer.write(
                                "File Name: " +
                                path.getFileName()
                            );

                            writer.newLine();

                            writer.write(
                                "Path: " + path
                            );

                            writer.newLine();

                            writer.write(
                                "Size: " + size + " bytes"
                            );

                            writer.newLine();

                            writer.write(
                                "Modified Time: " +
                                modifiedTime
                            );

                            writer.newLine();

                            writer.write("------------------");
                            writer.newLine();

                        } catch (IOException e) {
                            System.out.println(
                                "Error reading file: " + path
                            );
                        }
                    });
                }
            }

            System.out.println(
                "Folder report generated successfully."
            );

            System.out.println(
                "Report saved in: " + report
            );

        } catch (IOException e) {
            System.out.println(
                "Error: " + e.getMessage()
            );
        }
    }
}
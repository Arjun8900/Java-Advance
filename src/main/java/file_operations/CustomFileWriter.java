package file_operations;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CustomFileWriter {
    public static void main(String[] args) {
//        writeToTempFile("respose");

        writeUsingFileWriter("fileWriterOutput.txt");

        writeUsingBufferedWriter("bufferedWriterOutput.txt");

        writeUsingPrintWriter("printWriter.txt");

        writeUsingFiles("files.txt");

        writeUsingOutputStream("outputStream.txt");
    }

    /**
     * Use FileWriter when number of write operations are less
     *
     * @param fileName
     */
    private static void writeUsingFileWriter(String fileName) {
        File file = new File(fileName);
        String separator = System.getProperty("line.separator");
        try (FileWriter fr = new FileWriter(file)) {
            fr.write("Data from file writer " + separator);
            fr.write("Data from file writer2 " + separator);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Use BufferedWriter when number of write operations are more
     * It uses internal buffer to reduce real IO operations and saves time
     *
     * @param fileName
     */
    private static void writeUsingBufferedWriter(String fileName) {
        int noOfLines = 5;
        File file = new File(fileName);
        String lineSeparator = System.getProperty("line.separator");
        String dataWithNewLine = "data";
        try (BufferedWriter br = new BufferedWriter(new FileWriter(file))) {
            for (int i = 0; i < noOfLines; i++) {
                br.write(dataWithNewLine + i);
                br.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Use Streams when you are dealing with raw data
     *
     * @param fileName
     */
    private static void writeUsingOutputStream(String fileName) {
        String rawData = "This is raw data";
        try (OutputStream os = Files.newOutputStream(new File(fileName).toPath())) {
            os.write(rawData.getBytes(), 0, rawData.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Use Files class from Java 1.7 to write files, internally uses OutputStream
     *
     * @param fileName
     */
    private static void writeUsingFiles(String fileName) {
        String data = "data to write";
        try {
            Files.write(Paths.get(fileName), data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeUsingPrintWriter(String fileName) {
        String data = "This is raw data";
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
            pw.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToTempFile(String name) {
        try {
            File file = File.createTempFile(name, ".csv");
            System.out.println(file.getName());
            System.out.println(file.getAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

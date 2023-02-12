package file_operations;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;

public class CustomFileReader {
    private static final int DEFAULT_BUFFER_SIZE = 8 * 1024 * 1024 ; // 8 Mb

    public static void main(String[] args) {
//        read("fileWriterOutput.txt");
//        read2("fileWriterOutput.txt");
        long start = 0;
        start = System.currentTimeMillis();
        readAndWriteViaBufferedReader("fileWriterOutput.txt", "BufferedReader.txt");
        System.out.printf("Time taken by BufferedReader= %s%n", (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        readAndWriteViaBufferedInputStream("fileWriterOutput.txt", "BufferedOutputStream.txt");
        System.out.printf("Time taken by BufferedInputStream= %s%n", (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        readAndWriteViaFileChannel("fileWriterOutput.txt", "FileChannel.txt");
        System.out.printf("Time taken by fileChannel= %s%n", (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        readAndWriteViaInputStream("fileWriterOutput.txt", "OutputStream.txt");
        System.out.printf("Time taken by InputStream= %s%n", (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        readAndWriteViaFileReader("fileWriterOutput.txt", "FileReader.txt");
        System.out.printf("Time taken by FileReader= %s%n", (System.currentTimeMillis() - start));
    }

    /**
     * Use buffered reader when file is plane text
     *
     * @param fileName
     */
    public static void readAndWriteViaBufferedReader(String fileName, String outputFileName) {
        try (BufferedReader is = new BufferedReader(new FileReader(fileName));
             BufferedWriter os = new BufferedWriter(new FileWriter(outputFileName))) {
            String line;
            while ((line = is.readLine()) != null) {
                os.write(line);
            }
            os.flush();
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Use BufferedInputStream when file contains binary data, as we'd be converting the data to String
     *
     * @param fileName
     */
    public static void readAndWriteViaBufferedInputStream(String fileName, String outputFileName) {
        try (BufferedInputStream is = new BufferedInputStream(Files.newInputStream(new File(fileName).toPath()));
             BufferedOutputStream os = new BufferedOutputStream(Files.newOutputStream(new File(outputFileName).toPath()))) {
            int line;
            byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
            while ((line = is.read(buffer)) != -1) {
                os.write(buffer, 0, line);
            }
            os.flush();
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * FileChannel takes 20% less time than BufferedReader
     *
     * @param fileName
     */
    public static void readAndWriteViaFileChannel(String fileName, String outputFileName) {
        try (FileChannel source = new FileInputStream(fileName).getChannel();
             FileChannel target = new FileOutputStream(outputFileName).getChannel();) {

            ByteBuffer buffer = ByteBuffer.allocateDirect(DEFAULT_BUFFER_SIZE);
            while (source.read(buffer) != -1) {
                buffer.flip();
                target.write(buffer);
                buffer.clear();
                //do read operations here
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void readAndWriteViaInputStream(String fileName, String outputFileName) {
        try (InputStream is = Files.newInputStream(new File(fileName).toPath());
             OutputStream os = Files.newOutputStream(new File(outputFileName).toPath())) {
            int line;
            while ((line = is.read()) != -1) {
                os.write((char)line);
            }
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readAndWriteViaFileReader(String fileName, String outputFileName) {
        try (FileReader input = new FileReader(fileName);
             FileWriter fileWriter = new FileWriter(outputFileName)) {
            int line;
            while ((line = input.read()) != -1) {
                fileWriter.write((char) line);
            }
            fileWriter.flush();
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

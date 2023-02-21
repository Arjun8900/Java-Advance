package file_operations.customs;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCustom {
    private static String file = "C:\\Users\\akanwal\\Documents\\CODE\\Java-Advance\\FileReader.txt";
    private static boolean atEOF = false;
    private static int maxFieldCount = 5;
    private static StreamTokenizer parser;
    private static char[] separators = new char[]{','};

    public static void main(String[] args) throws IOException {
        InputStream queryResultStream = new FileInputStream(file);
        parser = new StreamTokenizer(queryResultStream);
        List<String> nextRecord;
        do {
            nextRecord = nextRecordLocal();
        } while (nextRecord != null);
        System.out.println(nextRecord);

    }
    private static  ArrayList<String> nextRecordLocal() throws IOException {
        if (atEOF) {
            return null;
        }

        ArrayList<String> record = new ArrayList<String>(maxFieldCount);

        StringBuilder fieldValue = null;

        while(true) {
            int token = parser.nextToken();

            if (token == StreamTokenizer.TT_EOF) {
                addField(record, fieldValue);
                atEOF = true;
                break;
            }

            if (token == StreamTokenizer.TT_EOL) {
                addField(record, fieldValue);
                break;
            }

            if (token == StreamTokenizer.TT_WORD) {
                if (fieldValue != null) {
                    System.out.println("ERROR");
                    throw new RuntimeException("Error");
                }

                fieldValue = new StringBuilder(parser.sval);
                continue;
            }

            if (Arrays.binarySearch(separators, (char)token) >= 0) {
                addField(record, fieldValue);
                fieldValue = null;
                continue;
            }

            if (token == '"') {
                if (fieldValue != null) {
                    System.out.println("ERROR");
                    throw new RuntimeException("Error");
                }


                while(true) {
                    token = parser.nextToken();

                    if (token == StreamTokenizer.TT_EOF) {
                        atEOF = true;
                        System.out.println("ERROR");
                        throw new RuntimeException("Error");
                    }

                    if (token == StreamTokenizer.TT_EOL) {
                        fieldValue = appendFieldValue(fieldValue, "\n");
                        continue;
                    }

                    if (token == StreamTokenizer.TT_WORD) {
                        fieldValue = appendFieldValue(fieldValue, parser.sval);
                        continue;
                    }

                    if (Arrays.binarySearch(separators, (char)token) >= 0) {
                        fieldValue = appendFieldValue(fieldValue, token);
                        continue;
                    }

                    if (token == '"') {
                        int nextToken = parser.nextToken();
                        if (nextToken == '"') {
                            //escaped quote
                            fieldValue = appendFieldValue(fieldValue, nextToken);
                            continue;
                        }

                        if (nextToken == StreamTokenizer.TT_WORD) {
                            System.out.println("ERROR");
                            throw new RuntimeException("Error");
                        } else {
                            parser.pushBack();
                            break;
                        }
                    }
                }
            }
        }

        if (record.size() > maxFieldCount) {
            maxFieldCount = record.size();
        }

        return record;
    }

    private static void addField(ArrayList<String> record, StringBuilder fieldValue) {
        record.add(fieldValue == null ? null : fieldValue.toString());
    }

    private static StringBuilder appendFieldValue(StringBuilder fieldValue, String token) {
        if (fieldValue == null) {
            fieldValue = new StringBuilder();
        }

        fieldValue.append(token);

        return fieldValue;
    }

    private static StringBuilder appendFieldValue(StringBuilder fieldValue, int token)  {
        return appendFieldValue(fieldValue, ""+(char)token);
    }
}

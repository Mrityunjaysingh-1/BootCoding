package org.bootcoding.services;


import com.opencsv.CSVReader;
import org.bootcoding.utils.FileRead;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReader implements FileRead {
    @Override
    public List<String> read(String filePath) {
        List<String> rows = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;
            reader.readNext();
            while ((nextLine = reader.readNext()) != null) {
                StringBuilder row = new StringBuilder();
                for (String value : nextLine) {
                    row.append(value).append(",");
                }
                // Remove the trailing comma
//                if (row.length() > 0) {
//                    row.setLength(row.length() - 1);
//                }
                //add all row to list
                rows.add(row.toString());
            }
        } catch (Exception e) {
            // Handle file reading exceptions here
            e.printStackTrace();
        }
        return rows;
    }
}

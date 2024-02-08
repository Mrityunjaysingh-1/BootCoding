package org.bootcoding.services;

import org.bootcoding.model.Assignment;

import java.util.ArrayList;
import java.util.List;

public class AssignmentService {
    public List<Assignment> readFromFile(String filePath){
        List<Assignment> assignmentList = new ArrayList<>();
        CsvFileReader csvFileReader = new CsvFileReader();
        List<String> data = csvFileReader.read(filePath);

        for(String row: data){
//            Assignment sendToConvert = convert(row);
            Assignment assignment = convertObject(row);
            assignmentList.add(assignment);
//            System.out.println(row);

        }

        return assignmentList;
    }

    public Assignment convertObject(String row){
        // logic to split row string
        String[] values = row.split(",");
        // build Assignment object
        try{
            return new Assignment(Integer.parseInt(values[0]),values[1],values[3],Double.parseDouble(values[4]),Boolean.parseBoolean(values[5]));
        }catch (Exception e){
            return new Assignment(Integer.parseInt(values[0]),values[1],values[3],0.0d,Boolean.parseBoolean(values[5]));
        }
    }

    public void JsonConvert(List<Assignment> object){
        JsonFileWriter jsonFileWriter = new JsonFileWriter();
        jsonFileWriter.write(object);
    }
}

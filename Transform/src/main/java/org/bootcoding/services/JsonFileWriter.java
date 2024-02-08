package org.bootcoding.services;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.bootcoding.model.Assignment;
import org.bootcoding.utils.FileWriter;

import java.io.File;
import java.util.List;

public class JsonFileWriter implements FileWriter {
    @Override
    public void write(List<Assignment> list) {
        ObjectMapper mapper = new ObjectMapper();
        try{
            mapper.writeValue(new File("question.json"), list);
            System.out.println("File has been created.");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}

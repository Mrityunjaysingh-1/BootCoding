package org.bootcoding;

import org.bootcoding.model.Assignment;
import org.bootcoding.services.AssignmentService;

public class Main {
    public static void main(String[] args) {
        AssignmentService csv = new AssignmentService();
        csv.JsonConvert(csv.readFromFile("W:\\java\\Transform\\src\\main\\java\\org\\bootcoding\\services\\questions.csv"));
    }
}

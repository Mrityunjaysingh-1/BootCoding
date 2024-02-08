package org.bootcoding.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Assignment {
    int QID;
    String title;
    String difficulty;
    Double acceptanceRate;
    Boolean paidOnly;

}

package com.example.lab52.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Tracker {
    private String id;
    private String name;
    private String title;
    private String description;
    private String status;
    private String companyName;

}

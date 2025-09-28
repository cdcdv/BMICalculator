package com.example.bmicalculator.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BmiResponse {
    private double bmi;
    private String category;
    private String interpretation;
}
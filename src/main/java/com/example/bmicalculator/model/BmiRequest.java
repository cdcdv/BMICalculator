package com.example.bmicalculator.model;

import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class BmiRequest {
    @Positive(message = "Height must be a positive number")
    private double heightInCm;
    
    @Positive(message = "Weight must be a positive number")
    private double weightInKg;
}
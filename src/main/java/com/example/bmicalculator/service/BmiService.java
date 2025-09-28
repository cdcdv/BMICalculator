package com.example.bmicalculator.service;

import org.springframework.stereotype.Service;
import com.example.bmicalculator.model.BmiRequest;
import com.example.bmicalculator.model.BmiResponse;

@Service
public class BmiService {

    public BmiResponse calculateBmi(BmiRequest request) {
        double heightInMeters = request.getHeightInCm() / 100.0;
        double bmi = request.getWeightInKg() / (heightInMeters * heightInMeters);
        
        return BmiResponse.builder()
                .bmi(Math.round(bmi * 100.0) / 100.0)
                .category(getBmiCategory(bmi))
                .interpretation(getInterpretation(bmi))
                .build();
    }

    private String getBmiCategory(double bmi) {
        if (bmi < 18.5) return "Underweight";
        if (bmi < 25.0) return "Normal weight";
        if (bmi < 30.0) return "Overweight";
        return "Obese";
    }

    private String getInterpretation(double bmi) {
        if (bmi < 18.5) return "You are underweight. Consider consulting a healthcare provider.";
        if (bmi < 25.0) return "You have a healthy weight. Maintain it with balanced diet and regular exercise.";
        if (bmi < 30.0) return "You are overweight. Consider lifestyle modifications for weight management.";
        return "You are obese. Please consult a healthcare provider for weight management guidance.";
    }
}
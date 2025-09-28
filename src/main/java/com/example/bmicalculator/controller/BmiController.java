package com.example.bmicalculator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bmicalculator.model.BmiRequest;
import com.example.bmicalculator.model.BmiResponse;
import com.example.bmicalculator.service.BmiService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/bmi")
@RequiredArgsConstructor
@Tag(name = "BMI Calculator", description = "API endpoints for BMI calculations")
public class BmiController {
    private final BmiService bmiService;

    @PostMapping("/calculate")
    @Operation(summary = "Calculate BMI", description = "Calculates BMI based on height and weight")
    public ResponseEntity<BmiResponse> calculateBmi(@Valid @RequestBody BmiRequest request) {
        return ResponseEntity.ok(bmiService.calculateBmi(request));
    }
}
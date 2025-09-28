package com.example.bmicalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.bmicalculator.model.BmiRequest;
import com.example.bmicalculator.service.BmiService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class BmiCalculatorApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BmiService bmiService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void calculateBmi_ValidInput_ReturnsCorrectBmi() throws Exception {
        BmiRequest request = new BmiRequest();
        request.setHeightInCm(170);
        request.setWeightInKg(70);

        mockMvc.perform(post("/api/v1/bmi/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());

        double expectedBmi = 24.22;
        double actualBmi = bmiService.calculateBmi(request).getBmi();
        assertEquals(expectedBmi, actualBmi, 0.01);
    }

    @Test
    void calculateBmi_InvalidInput_ReturnsBadRequest() throws Exception {
        BmiRequest request = new BmiRequest();
        request.setHeightInCm(-170);
        request.setWeightInKg(-70);

        mockMvc.perform(post("/api/v1/bmi/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }
}
package com.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcularComisionController {

    @GetMapping("/getComision")
    public CalcularComision getComision(
        @RequestParam(value = "marcaTarjeta", defaultValue = "") String marcaTarjeta,
        @RequestParam(value = "importe", defaultValue = "0.0f") String importeString) {
            float importe = Float.parseFloat(importeString);
            return new CalcularComision(marcaTarjeta, importe);
        }
}

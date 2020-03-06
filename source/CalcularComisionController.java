package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcularComisionController {
    private static final String template = "Hello, %s!";
    private static final AtomicLong counter = new AtomicLong();

    @GetMapping("/getComision")
    public CalcularComision getComision(
        @RequestParam(value = "marcaTarjeta", defaultValue = "") String marcaTarjeta,
        @RequestParam(value = "importe", defaultValue = 0.0) float importe) {
            return new CalcularComision(marcaTarjeta, importe);
        }
}
package com.example.restservice;

import java.time.LocalDate;

class CalcularComision {

    public final float content;

    public CalcularComision (String marca, float monto) {
        this.content = getComision(marca, monto);
    }

    public float getComision(String marca, float monto) {
        LocalDate today = LocalDate.now();
        switch (marca) {
            case "SQUA":
                return ((float)today.getMonthValue()) / ((float)today.getYear());
            case "SCO":
                return 0.5f * ((float)today.getDayOfMonth());
            case "PERE":
                return ((float)today.getMonthValue()) * 0.1f;
            case "":
                return 0.0f;
            default:
                return 0.0f;
        }
    }
}

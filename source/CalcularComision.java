package com.example.restservice;

class CalcularComision {
    public final long id;
    public final String content;

    public CalcularComision (String marca, float monto) {
        // this.id = id;
        // this.content = content;
        this.content = getComision(marca, monto);
    }

    // public getId() {return this.id;}

    // public getContent(){return this.content;}

    public getComision(String marca, float monto) {
        LocalDate today = LocalDate.now();
        switch (marca) {
            case "SQUA":
                return ((float)today.getYear()) / ((float)today.getMonthValue());
            case "SCO":
                return 0.5f * ((float)today.getDayOfMonth());
            case "PERE":
                return ((float)today.getMonthValue()) * 0.1f;
            default:
                return 0.0f;
        }
    }
}
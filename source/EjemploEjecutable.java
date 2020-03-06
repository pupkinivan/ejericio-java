import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/*   Argumentos para crear una tarjeta deben ser:
 * 1. marca
 * 2. número de tarjeta
 * 3. nombre de dueño de tarjeta
 * 4. fecha de vencimiento
 * 
 * 

*/

class EjemploEjecutable {
    public static void main(String[] args){

        // 1. método que devuelva toda la info de una tarjeta
        Tarjeta ricardito = new Tarjeta("SQUA", "Ricardo Ordóñez", "4654354354", "04/16");
        System.out.println("La info de la tarjeta de Ricardito es:\n" + ricardito.getAllDetails() + "\n");

        // 2. informar si una operación es válida
        Operacion opereta = new Operacion(ricardito, 567.63f);
        System.out.println(String.format("–¿Es válida la operación de Ricardito por $567.63?\n–%s.\n", opereta.isValid()));

        // 3. informar si una tarjeta es válida
        System.out.println(String.format("–¿Es válida la tarjeta de Ricardito?\n–%b.\n", ricardito.isCardValid()));

        // 4. comparar igualdad de dos tarjetas
        Tarjeta pipo = new Tarjeta("PERE", "Pedro Sanfalópulos", "3844363", "12/20");
        System.out.println(String.format("Son la misma las tarjetas de Pipo y Ricardito?\n–%s.\n", ricardito.equals(pipo)));

        // 5. obtener tasa de operación a través de marca e importe
        System.out.println(String.format("La tasa de operación para Ricardito (fuere la operación válida) sería de $%f.", opereta.getCharge()));
    }
}

interface Card {
	String cardBrand = "";
	String holderName = "";
	String cardNumber = "";
    LocalDate expirationDate = null;

    // abstract String setCardBrand();
    // abstract String setHolderName();
    // abstract String setCardNumber();
    // abstract Date setExpirationDate();
    
    // default String getCardBrand(){
    //     return cardBrand;
    // }
    // default String getHolderName(){
    //     return holderName;
    // }
    // default String getCardNumber(){
    //     return cardNumber;
    // }
    // default LocalDate getExpirationDate(){
    //     return expirationDate;
    // }

}

class Operacion {
    private float amount;
    private String cardBrand;
    private Tarjeta card;

    public Operacion (Tarjeta tarjeta, float monto) {
        this.amount = monto;
        this.card = tarjeta;
        this.cardBrand = tarjeta.getCardBrand();
    }

    public float getMonto() {return amount;}

    public float getCharge() {
        return (float)this.card.getRate() * (float)this.amount;
    }

    public boolean isValid() {
        if (amount < 1000 && this.card.isCardValid()) {
            return true;
        } else {
            return false;
        }
    }

    // private void setBrand(String marca) {
    //     this.cardBrand = marca;
    // }
}

class Tarjeta implements Card {
    private String cardBrand;
    private String holderName;
    private String cardNumber;
    private LocalDate expirationDate;

    public Tarjeta (
        String marcaTarjeta,
        String nombreDueno,
        String numeroTarjeta,
        String fechaExpiracion) {
            setCardBrand(marcaTarjeta);
            setCardNumber(numeroTarjeta);
            setExpirationDate(fechaExpiracion);
            setHolderName(nombreDueno);
    }

    private void setCardBrand(String marcaTarjeta) {
        this.cardBrand = marcaTarjeta;
    }
    private void setHolderName (String nombreDueno){
        this.holderName = nombreDueno;
    }
    private void setCardNumber(String numeroTarjeta){
        this.cardNumber = numeroTarjeta;
    }
    private void setExpirationDate(String fechaExpiracion){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/yy/dd");
        this.expirationDate = LocalDate.parse(fechaExpiracion+"/01", format);
    }

	public boolean isCardValid() {
        LocalDate today = LocalDate.now();

        if (expirationDate.isAfter(today) &&
            !cardBrand.equals("") &&
            !holderName.equals("") &&
            !cardNumber.equals("")) {
                return true;
        } else {
            return false;
        }
    }

	public boolean equals(Tarjeta otraTarjeta) {
        if (this.getCardBrand().equals(otraTarjeta.getCardBrand()) ||
            this.getCardNumber().equals(otraTarjeta.getCardNumber()) ||
            this.getHolderName().equals(otraTarjeta.getHolderName()) ||
            this.getExpirationDate() == otraTarjeta.getExpirationDate()) {
                return true;
        } else {
            return false;
        }
    }

    public String getCardBrand(){
        return cardBrand;
    }
    public String getHolderName(){
        return holderName;
    }
    public String getCardNumber(){
        return cardNumber;
    }
    public LocalDate getExpirationDate(){
        return expirationDate;
    }

    public String getAllDetails(){
        return String.format("Card holder: %s.\nCard brand: %s.\nCard number: %s.\nExpiration date: %s.",
            getHolderName(), getCardBrand(), getCardNumber(), getExpirationDate());
    }

	public float getRate() {
        LocalDate today = LocalDate.now();
        switch (cardBrand) {
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

    // Ver si funcionan los defaults de la interfaz
    // default String getCardBrand(){
    //     return cardBrand;
    // }
    // default String getHolderName(){
    //     return holderName;
    // }
    // default String getCardNumber(){
    //     return cardNumber;
    // }
    // default LocalDate getExpirationDate(){
    //     return expirationDate;
    // }
}
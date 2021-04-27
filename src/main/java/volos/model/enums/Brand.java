package volos.model.enums;

import volos.util.WrongInputException;

public enum Brand {
    Chanel ("Chanel"),
    Gucci ("Gucci"),
    Zara ("Zara"),
    Fendi ("Fendi"),
    Mango ("Mango");
    private String brand_s;

    Brand(String brand_s) {
        this.brand_s = brand_s;
    }

    public String getBrand_s() {
        return brand_s;
    }

    public static Brand getTypeByUrl(String url) throws WrongInputException {
        for (Brand env : values()) {
            if (env.getBrand_s().equals(url)) {
                return env;
            }
        }
        throw new WrongInputException("None brand found with url: [" + url + "]");
    }

    @Override
    public String toString() {
        return "Brand: "+ brand_s;
    }
}

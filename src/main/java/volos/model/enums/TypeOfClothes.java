package volos.model.enums;

import volos.util.WrongInputException;

public enum TypeOfClothes {
    Pants ("Pants"),
    Jeans ("Jeans"),
    Leggings ("Leggings"),
    Shorts ("Shorts"),
    Skirt ("Skirt");
    private String type;

    TypeOfClothes(String type) {
        this.type = type;
    }

    public String gettype() {
        return type;
    }

    public static TypeOfClothes getTypeByUrl(String url) throws WrongInputException {
        for (TypeOfClothes env : values()) {
            if (env.gettype().equals(url)) {
                return env;
            }
        }
        throw new WrongInputException("No enum found with url: [" + url + "] in Type Clothes");
    }

    @Override
    public String toString() {
        return type;
    }
}

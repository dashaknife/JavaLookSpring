package volos.model.enums;

import volos.util.WrongInputException;

public enum Size {
    Xs ("extrasmall"),
    S ("small"),
    M ("middle"),
    L ("large"),
    XL ("extralarge");
    private String size_s;

    Size(String size_s) {
        this.size_s = size_s;
    }

    public String getSize_s() {
        return size_s;
    }

    public static Size getTypeByUrl(String url) throws WrongInputException {
        for (Size env : values()) {
            if (env.getSize_s().equals(url)) {
                return env;
            }
        }
        throw new WrongInputException("None size found with url: [" + url + "]");
    }

    @Override
    public String toString() {
        return "Size: "+ size_s;
    }
}

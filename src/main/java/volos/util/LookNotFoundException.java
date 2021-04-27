package volos.util;

import volos.model.enums.Brand;
import volos.model.enums.Size;

import java.util.NoSuchElementException;

public class LookNotFoundException extends NoSuchElementException {

    public LookNotFoundException(String name) {
        super("No look with name: " + name + " found");
    }
    public LookNotFoundException(long id) {
        super("No look with " + id + " id found");
    }
    public LookNotFoundException(Size s) {
        super("No look with " + s + " size found");
    }
    public LookNotFoundException(Brand b) {
        super("No look with " + b + " brand found");
    }
}

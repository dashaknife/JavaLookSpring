package volos.service;

import volos.model.Look;
import volos.model.enums.Brand;
import volos.model.enums.Size;
import volos.model.enums.TypeOfClothes;

import java.util.List;
import java.util.Optional;

public interface LookService {
    List<Look> getLooks();
    Look getLookByName(String name);
    Look getLookById(Long id);

    void saveLook(Look look);
    void updateLook(Long id, Look look);
    void deleteLookById(Long id);

    List<Look> findLooksBySize (String s);
    List<Look> findLooksByColor (String c);
    List<Look> findLooksByBrand (String b);
    List<Look> findLooksByTypeOfClothes (String t);
}

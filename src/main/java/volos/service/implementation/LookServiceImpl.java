package volos.service.implementation;

import lombok.RequiredArgsConstructor;
import volos.exception.ObjectNotFoundException;
import volos.model.Look;
import volos.model.enums.Brand;
import volos.model.enums.Color;
import volos.model.enums.Size;
import org.springframework.stereotype.Service;
import volos.model.enums.TypeOfClothes;
import volos.repository.LookRepository;
import volos.service.LookService;


import java.util.List;

@RequiredArgsConstructor
@Service
public class LookServiceImpl implements LookService {

    private final LookRepository lookRepository;

    public List<Look> getLooks () {
        return lookRepository.findAll();
    }

    public Look getLookById (Long id) {
        return lookRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(Look.class.getName(), id));
    }
    
    public Look getLookByName (String name) {
        return lookRepository.findByName(name).orElseThrow(() -> new ObjectNotFoundException(Look.class.getName(), name));
    }

    public List<Look> findLooksBySize (String s) {
        return  lookRepository.findAllBySize(Size.getTypeByUrl(s));
    }
    public List<Look> findLooksByColor (String c) {
        return  lookRepository.findAllByColor(Color.getTypeByUrl(c));
    }
    public List<Look> findLooksByBrand (String b) {
        return  lookRepository.findAllByBrand(Brand.getTypeByUrl(b));
    }
    public List<Look> findLooksByTypeOfClothes (String t) {
        return  lookRepository.findAllByTypeOfClothes(TypeOfClothes.getTypeByUrl(t));
    }

    public void saveLook(Look look) {
        lookRepository.save(look);
    }
    public void updateLook(Long id, Look look) {
        if(lookRepository.findById(id).isEmpty())
            throw new ObjectNotFoundException(Look.class.getName(),id);
        look.setId(id);
        lookRepository.save(look);
    }
    public void deleteLookById(Long id) {
        if(lookRepository.findById(id).isEmpty())
            throw new ObjectNotFoundException(Look.class.getName(),id);
        lookRepository.deleteById(id);
    }





}

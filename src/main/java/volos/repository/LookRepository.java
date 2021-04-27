package volos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import volos.model.Look;
import volos.model.enums.Brand;
import volos.model.enums.Color;
import volos.model.enums.Size;
import volos.model.enums.TypeOfClothes;

import java.util.List;
import java.util.Optional;

public interface LookRepository extends JpaRepository<Look, Long> {

     Optional<Look> findByName (String name);

     List<Look> findAllBySize(Size s);
     List<Look> findAllByColor(Color c);
     List<Look> findAllByBrand(Brand s);
     List<Look> findAllByTypeOfClothes(TypeOfClothes t);
}

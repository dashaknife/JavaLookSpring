//package volos.repository;
//
//import volos.util.LookNotFoundException;
//import volos.model.Look;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//@Repository
//public class LookRepositoryImpl implements LookRepository{
//
//    private Long counter = 0L;
//    private final List<Look> looks = new ArrayList<>();
//
//    public LookRepositoryImpl() {
//
//    }
//
//    public Optional<Look> findLookById (Long id) {
//        return findAllLooks().stream().
//                filter(l -> l.getId().equals(id))
//                .findFirst();
//    }
//    public Optional<Look> findLookByName (String name) {
//        return findAllLooks().stream().
//                filter(l -> l.getName().equals(name))
//                .findFirst();
//    }
//    public List<Look> findAllLooks () {
//        return looks;
//    }
//
//    public void saveLook (Look look) {
//        look.setId(++counter);
//        looks.add(look);
//    }
//    public void updateLook (Look look) {
//        Look tmp = findLookById(look.getId()).orElseThrow(() -> new LookNotFoundException(look.getId()));
//        findAllLooks().set(looks.indexOf(tmp),look);
//    }
//    public void deleteLook (Long id) {
//        Optional<Look> look = findLookById(id);
//        look.ifPresent(looks::remove);
//    }
//
//
//}

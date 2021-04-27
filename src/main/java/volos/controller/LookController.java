package volos.controller;

import lombok.RequiredArgsConstructor;
import volos.model.enums.TypeOfClothes;
import volos.util.LookNotFoundException;
import volos.util.WrongInputException;
import volos.model.Look;
import volos.model.enums.Brand;
import volos.model.enums.Size;
import volos.service.LookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("look")
public class LookController {


    private final LookService lookService;


    @GetMapping("/")
    public List<Look> allLooks() {
        return lookService.getLooks();
    }

    @GetMapping("name/{name}")
    public Look findLookByName (@PathVariable String name) throws LookNotFoundException {
            return lookService.getLookByName(name);
    }

    @GetMapping("{id}")
    public Look findLookById (@PathVariable Long id) {
        return lookService.getLookById(id);
    }

    @GetMapping("size/{s}")
    public List<Look> findLooksBySize (@PathVariable String s) {
        return lookService.findLooksBySize(s);
    }

    @GetMapping("color/{c}")
    public List<Look> findLooksByColor (@PathVariable String c) {
        return lookService.findLooksByColor(c);
    }

    @GetMapping("brand/{b}")
    public List<Look> findLooksByBrand (@PathVariable String b) {
        return lookService.findLooksByBrand(b);
    }

    @GetMapping("type/{t}")
    public List<Look> findLooksByTypeOfUpperClothes (@PathVariable String t) {
        return lookService.findLooksByTypeOfClothes(t);
    }

    @PostMapping
    public List<Look> saveLook(@RequestBody Look look) {
        lookService.saveLook(look);
        return lookService.getLooks();
    }

    @PutMapping("{id}")
    public List<Look> updateLook(@PathVariable Long id, @RequestBody Look look) {
        lookService.updateLook(id, look);
        return lookService.getLooks();
    }

    @DeleteMapping("{id}")
    public void deleteLook(@PathVariable Long id) {
        lookService.deleteLookById(id);
    }
}

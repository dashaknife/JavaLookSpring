package volos;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import volos.context.Application;
import volos.controller.LookController;
import volos.exception.ObjectNotFoundException;
import volos.model.Look;
import volos.model.enums.Brand;
import volos.model.enums.Color;
import volos.model.enums.Size;
import volos.model.enums.TypeOfClothes;

import java.util.LinkedList;
import java.util.List;

public class LookTestIT {
    AnnotationConfigApplicationContext context;
    LookController lookController;
    List<Look> expected = new LinkedList<>();
    Long savedID = null;

    @Before
    public void setUp () {
        context = new AnnotationConfigApplicationContext(Application.class);

        lookController = context.getBean(LookController.class);

        expected = lookController.allLooks();
    }
    @Test
    public void findAllLooks_isFindCorrect_true () {
        //GIVEN
        List<Look> expected1 = new LinkedList<>();
        expected1.add(new Look(1L, "look1", 20,  Size.S,  Color.White,  Brand.Zara,   TypeOfClothes.Pants));
        expected1.add(new Look(2L, "look2", 40,  Size.L,  Color.Black,  Brand.Fendi,  TypeOfClothes.Skirt));
        expected1.add(new Look(3L, "look3", 50,  Size.XL, Color.Pink,   Brand.Chanel, TypeOfClothes.Leggings));
        expected1.add(new Look(4L, "look4", 121, Size.M,  Color.Orange, Brand.Gucci,  TypeOfClothes.Jeans));
        expected1.add(new Look(5L, "look5", 50,  Size.Xs, Color.Black,  Brand.Mango,  TypeOfClothes.Shorts));

        //WHEN
        List<Look> actual = lookController.allLooks();
        //THEN
        Assert.assertEquals(expected1,actual);
    }
    @Test
    public void findLookByID_isFindCorrect_true () {
        //GIVEN
        //WHEN
        Look actual = lookController.findLookById(2L);
        //THEN
        Assert.assertEquals(expected.get(1),actual);
    }
    @Test(expected = ObjectNotFoundException.class)
    public void findLookByID_whenIdIsInvalid_true () {
        //GIVEN
        //WHEN
        lookController.findLookById(100L);
        //THEN
    }
    @Test
    public void findLookByName_isFindCorrect_true () {
        //GIVEN
        //WHEN
        Look actual = lookController.findLookByName("look1");
        //THEN
        Assert.assertEquals(expected.get(0),actual);
    }
    @Test(expected = ObjectNotFoundException.class)
    public void findLookByName_whenNameIsInvalid_true () {
        //GIVEN
        //WHEN
        lookController.findLookByName("ErrorName");
        //THEN
    }
    @Test
    public void saveLook_isSaveCorrect_true () {
        //GIVEN
        Look test = new Look("look6", 500,  Size.S, Color.White,  Brand.Mango,  TypeOfClothes.Shorts);
        expected.add(test);
        //WHEN
        lookController.saveLook(test);
        List<Look> actual = lookController.allLooks();
        savedID = actual.get(actual.size()-1).getId();
        expected.get(expected.size()-1).setId(savedID);
        //THEN
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void updateLook_isUpdateCorrect_true () {
        //GIVEN
        Look test = new Look("look6", 50,  Size.Xs, Color.Black,  Brand.Mango,  TypeOfClothes.Shorts);
        lookController.saveLook(test);
        List<Look> actual = lookController.allLooks();
        savedID = actual.get(actual.size()-1).getId();

        Look test2 = new Look("update", 10,  Size.Xs, Color.Black,  Brand.Zara,  TypeOfClothes.Shorts);
        expected.add(test2);
        //WHEN
        actual = lookController.updateLook(savedID,test2);
        //THEN
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void deleteLook_isDeleteCorrect_true () {
        //GIVEN
        Look test = new Look("look6", 50,  Size.Xs, Color.Black,  Brand.Mango,  TypeOfClothes.Shorts);
        lookController.saveLook(test);
        List<Look> actual = lookController.allLooks();
        savedID = actual.get(actual.size()-1).getId();
        //WHEN
        lookController.deleteLook(savedID);
        actual = lookController.allLooks();
        savedID = null;
        //THEN
        Assert.assertEquals(expected,actual);
    }
    @After
    public void tearDown () {
        if (savedID!=null)
            lookController.deleteLook(savedID);
    }
}

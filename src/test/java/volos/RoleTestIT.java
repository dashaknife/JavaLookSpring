package volos;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import volos.context.Application;
import volos.controller.RoleController;
import volos.exception.ObjectNotFoundException;
import volos.model.RoleUser;

import java.util.LinkedList;
import java.util.List;


public class RoleTestIT {

    RoleController roleController;
    List<RoleUser> expected = new LinkedList<>();
    Long savedID = null;
    @Before
    public void setUp () {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);

        roleController = context.getBean(RoleController.class);

        expected = roleController.findAllRoles();
    }
    @Test
    public void findAllRoles_isFindCorrect_true () {
        //GIVEN
        List<RoleUser> expected1 = new LinkedList<>();
        expected1.add(new RoleUser(1L, "admin", 3));
        expected1.add(new RoleUser(2L, "editor", 2));
        expected1.add(new RoleUser(3L, "user", 1));
        //WHEN
        List<RoleUser> actual = roleController.findAllRoles();
        //THEN
        Assert.assertEquals(expected1,actual);
    }
    @Test
    public void findRoleByID_isFindCorrect_true () {
        //GIVEN
        RoleUser expected = new RoleUser(2L, "editor", 2);
        //WHEN
        RoleUser actual = roleController.findRoleById(2L);
        //THEN
        Assert.assertEquals(expected,actual);
    }
    @Test(expected = ObjectNotFoundException.class)
    public void findRoleByID_whenIdIsInvalid_true () {
        //GIVEN
        //WHEN
        roleController.findRoleById(100L);
        //THEN
    }
    @Test
    public void saveRole_isSaveCorrect_true () {
        //GIVEN
        RoleUser test = new RoleUser("test", 10);
        //WHEN
        RoleUser actual = roleController.saveRole(test);
        savedID = actual.getIdRole();
        test.setIdRole(savedID);

        //THEN
        Assert.assertEquals(test,actual);
    }
    @Test
    public void updateRole_isUpdateCorrect_true () {
        //GIVEN
        RoleUser test = new RoleUser("test", 10);
        roleController.saveRole(test);
        List<RoleUser> actual = roleController.findAllRoles();
        savedID = actual.get(actual.size()-1).getIdRole();

        RoleUser test1 = new RoleUser("testUPDATE", 10);
        expected.add(test1);
        //WHEN
        actual = roleController.updateRole(savedID,test1);
        //THEN
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void deleteRole_isDeleteCorrect_true () {
        //GIVEN
        RoleUser test = new RoleUser("test", 10);
        roleController.saveRole(test);
        List<RoleUser> actual = roleController.findAllRoles();
        savedID = actual.get(actual.size()-1).getIdRole();
        //WHEN
        actual = roleController.deleteRole(savedID);
        savedID = null;
        //THEN
        Assert.assertEquals(expected,actual);
    }
    @After
    public void tearDown () {
        if (savedID!=null)
        roleController.deleteRole(savedID);
    }
}
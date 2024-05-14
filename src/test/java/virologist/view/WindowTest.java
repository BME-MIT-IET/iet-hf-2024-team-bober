package virologist.view;

import virologist.control.*;
import virologist.model.Game;
import virologist.model.Virologist;
import virologist.model.equipments.Axe;
import virologist.model.equipments.Equipment;

import org.junit.jupiter.api.*;
import org.mockito.internal.matchers.Or;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Robot;
import java.awt.event.InputEvent;

import javax.swing.*;

@TestMethodOrder (MethodOrderer.OrderAnnotation.class)
public class WindowTest {

    private static Loader loader;
    private static Controller controller;
    
    private static int leftClick;

    private static Window window;

    private static Robot robot;

    @BeforeAll
    public static void createEnvironment(){
        try{
            loader = new Loader();
            controller = new Controller(loader.loadGame("maps/map3.txt"));
            window = controller.getWindow();
            window.getFrame().setLocation(0, 0);
            robot = new Robot();
            leftClick = InputEvent.BUTTON1_DOWN_MASK;
        }
        catch (Exception e){
            System.err.println("Nem létező pálya!");
        }
    }

    //TODO: Ez valamiért nem működik, nem kapja meg jól az ablakhoz tartozó MenuBar-t
    /*@Test
    public void playerActionsCollectedTest() {
        JFrame frame = window.getFrame();

        String[] expectedStrings = {
                "attack",
                "move",
                "drop",
                "lootAminoFrom",
                "lootNucleoFrom",
                "lootEquipmentFrom",
                "collect",
                "learn",
                "equip",
                "inject",
                "endTurn"
        };

        int[] expectedSubMenuCounts = {
                1, 2, 0, 0, 0, 0, 0, 0, 0, 1, 0
        };

        int menusCount = frame.getJMenuBar().getMenuCount();
        assertEquals(expectedStrings.length, menusCount);
        for (int i = 0; i < menusCount; i++) {
            JMenu menu = frame.getJMenuBar().getMenu(i);
            assertEquals(expectedStrings[i], menu.getText());
            int menuItemCount = menu.getItemCount();
            assertEquals(expectedSubMenuCounts[i], menuItemCount);
        }
    }*/

    @Test @Order (1)
    public void moveTest(){
        robot.delay(100);
        robot.mouseMove(20, 40);
        robot.delay(200);
        robot.mousePress(leftClick);
        robot.mouseRelease(leftClick);
        robot.mouseMove(20, 90);
        robot.delay(200);
        robot.mouseMove(200, 90);
        robot.mousePress(leftClick);
        robot.mouseRelease(leftClick);
        robot.delay(200);
        assertEquals("Field2", Game.Create().GetCurrentPlayer().getField().getName());
    }

    @Test @Order (2)
    public void endTurnTest(){
        Virologist player1 = Game.Create().GetCurrentPlayer();
        robot.delay(100);
        robot.mouseMove(20, 40);
        robot.delay(100);
        robot.mousePress(leftClick);
        robot.mouseRelease(leftClick);
        robot.delay(100);
        robot.mouseMove(20, 270);
        robot.delay(100);
        robot.mousePress(leftClick);
        robot.mouseRelease(leftClick);
        robot.delay(100);
        assertNotEquals(player1, Game.Create().GetCurrentPlayer());
        robot.mouseMove(350, 350);
        robot.mousePress(leftClick);
        robot.mouseRelease(leftClick);
        robot.delay(200);
    }

    @Test @Order (3)
    public void dropTest(){
        robot.mouseMove(20, 40);
        robot.mousePress(leftClick);
        robot.mouseRelease(leftClick);
        robot.delay(200);
        robot.mouseMove(20, 100);
        robot.mousePress(leftClick);
        robot.mouseRelease(leftClick);
        robot.delay(200);
        assertEquals(0, Game.Create().GetCurrentPlayer().GetEquipments().size());
        robot.delay(100);
        robot.mouseMove(20, 40);
        robot.delay(100);
        robot.mousePress(leftClick);
        robot.mouseRelease(leftClick);
        robot.delay(100);
        robot.mouseMove(20, 270);
        robot.delay(100);
        robot.mousePress(leftClick);
        robot.mouseRelease(leftClick);
        robot.delay(100);
    }

    @Test @Order (4)
    public void equipTest(){
        int numEquipment = Game.Create().GetCurrentPlayer().GetEquipments().size();
        robot.mouseMove(20, 40);
        robot.mousePress(leftClick);
        robot.mouseRelease(leftClick);
        robot.delay(200);
        robot.mouseMove(20, 230);
        robot.mousePress(leftClick);
        robot.mouseRelease(leftClick);
        robot.delay(200);
        assertTrue(Game.Create().GetCurrentPlayer().GetEquipments().size() > numEquipment);
    }

    @Test @Order (5)
    public void attackTest(){
        int numPlayers = Game.Create().getVirologists().size();
        robot.delay(100);
        robot.mouseMove(20, 40);
        robot.mousePress(leftClick);
        robot.mouseRelease(leftClick);
        robot.delay(100);
        robot.mouseMove(20, 60);
        robot.delay(200);
        robot.mousePress(leftClick);
        robot.mouseRelease(leftClick);
        robot.delay(100);
        robot.mouseMove(170, 60);
        robot.delay(100);
        robot.mousePress(leftClick);
        robot.mouseRelease(leftClick);
        robot.delay(100);
        assertTrue(Game.Create().getVirologists().size() < numPlayers);
    }

    

    @Test @Order (6)
    public void lootAminoFromTest(){

    }

    @Test @Order (7)
    public void lootNucleoFromTest(){

    }

    @Test @Order (8)
    public void lootEquipmentFromTest(){
        
    }

    @Test @Order (9)
    public void collectTest(){

    }

    @Test @Order (10)
    public void learnTest(){

    }

    @Test @Order (11)
    public void injectTest(){

    }

}

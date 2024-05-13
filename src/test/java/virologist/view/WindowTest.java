package virologist.view;

import virologist.control.*;
import virologist.model.Game;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Robot;

import javax.swing.*;

public class WindowTest {

    private static Loader loader;
    private static Controller controller;
    
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
        }
        catch (Exception e){
            System.err.println("Nem létező pálya!");
        }
    }

    @Test
    public void playerActionsCollectedTest(){
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
        for(int i = 0; i < menusCount; i++){
            JMenu menu = frame.getJMenuBar().getMenu(i);
            assertEquals(expectedStrings[i], menu.getText());
            int menuItemCount = menu.getItemCount();
            assertEquals(expectedSubMenuCounts[i], menuItemCount);
        }
    }

    @Test
    public void moveTest(){
        robot.mouseMove(10, 10);
        robot.mousePress(0);
        robot.mouseRelease(0);
        robot.mouseMove(10, 40);
        robot.delay(500);
        robot.mouseMove(40, 40);
        robot.mousePress(0);
        robot.mouseRelease(0);
        assertEquals("Field2", Game.Create().GetCurrentPlayer().getField().getName());
    }

    @Test
    public void attackTest(){

    }

    @Test
    public void dropTest(){

    }

    @Test
    public void lootAminoFromTest(){

    }

    @Test
    public void lootNucleoFromTest(){

    }

    @Test
    public void lootEquipmentFromTest(){
        
    }

    @Test
    public void collectTest(){

    }

    @Test
    public void learnTest(){

    }

    @Test
    public void equipTest(){

    }

    @Test
    public void injectTest(){

    }

    @Test
    public void endTurnTest(){

    }
}

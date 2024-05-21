package virologist.view;

import virologist.control.*;
import virologist.model.Game;
import virologist.model.Virologist;
import virologist.model.codes.BlockCode;
import virologist.model.map.*;
import virologist.view.window.Window;

import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Robot;
import java.awt.event.InputEvent;

@Tag("GUI")
@TestMethodOrder (MethodOrderer.OrderAnnotation.class)
public class WindowTest {

    private static Loader loader;
    private static Controller controller;
    
    private static int leftClick;

    private static Window window;

    private static Robot robot;

    private static final int ROBOT_DELAY = 200;

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

    
    @Test @Order (1)
    public void moveTest(){
        robot.delay(ROBOT_DELAY);
        clickAt(20, 40);
        robot.mouseMove(20, 90);
        robot.delay(ROBOT_DELAY);
        clickAt(200, 90);
        robot.delay(ROBOT_DELAY);
        assertEquals("Field2", Game.Create().GetCurrentPlayer().getField().getName());
    }

    @Test @Order (2)
    public void endTurnTest(){
        Virologist player1 = Game.Create().GetCurrentPlayer();
        robot.delay(ROBOT_DELAY);
        clickAt(20, 40);
        robot.delay(ROBOT_DELAY);
        clickAt(20, 270);
        robot.delay(ROBOT_DELAY);
        assertNotEquals(player1, Game.Create().GetCurrentPlayer());
        robot.delay(ROBOT_DELAY);
    }

    @Test @Order (3)
    public void dropTest(){
        clickAt(20, 40);
        robot.delay(ROBOT_DELAY);
        clickAt(20, 100);
        robot.delay(ROBOT_DELAY);
        assertEquals(0, Game.Create().GetCurrentPlayer().GetEquipments().size());
        robot.delay(ROBOT_DELAY);
        clickAt(20, 40);
        robot.delay(ROBOT_DELAY);
        clickAt(20, 270);
        robot.delay(ROBOT_DELAY);
    }

    @Test @Order (4)
    public void equipTest(){
        int numEquipment = Game.Create().GetCurrentPlayer().GetEquipments().size();
        clickAt(20, 40);
        robot.delay(ROBOT_DELAY);
        clickAt(20, 230);
        robot.delay(ROBOT_DELAY);
        assertTrue(Game.Create().GetCurrentPlayer().GetEquipments().size() > numEquipment);
    }

    @Test @Order (5)
    public void attackTest(){
        int numPlayers = Game.Create().getVirologists().size();
        Game.Create().GetCurrentPlayer().SetActionCount(3);
        clickAt(20, 40);
        robot.delay(ROBOT_DELAY);
        clickAt(20, 90);
        robot.delay(ROBOT_DELAY);
        clickAt(180, 90);
        robot.delay(ROBOT_DELAY);
        clickAt(20, 40);
        robot.delay(ROBOT_DELAY);
        clickAt(20, 60);
        robot.delay(ROBOT_DELAY);
        clickAt(170, 60);
        robot.delay(ROBOT_DELAY);
        assertTrue(Game.Create().getVirologists().size() < numPlayers);
    }

    @Test @Order (6)
    public void endTurnTestBigButton(){
        Virologist player1 = Game.Create().GetCurrentPlayer();
        clickAt(530, 530);
        robot.delay(ROBOT_DELAY);
        assertNotEquals(player1, Game.Create().GetCurrentPlayer());
    }

    @Test @Order (7)
    public void lootAminoFromTest(){
        int amino = Game.Create().GetCurrentPlayer().GetAminoAcid();
        Game.Create().GetCurrentPlayer().IncreaseLimit(20);
        Game.Create().GetCurrentPlayer().SetActionCount(3);
        clickAt(20, 40);
        robot.delay(ROBOT_DELAY);
        clickAt(20, 120);
        robot.delay(ROBOT_DELAY);
        clickAt(170, 120);
        robot.delay(ROBOT_DELAY);
        assertTrue(Game.Create().GetCurrentPlayer().GetAminoAcid() > amino);
    }

    @Test @Order (8)
    public void lootNucleoFromTest(){
        int nucleo = Game.Create().GetCurrentPlayer().GetNucleotide();
        clickAt(20, 40);
        robot.delay(ROBOT_DELAY);
        clickAt(20, 150);
        robot.delay(ROBOT_DELAY);
        clickAt(170, 150);
        robot.delay(ROBOT_DELAY);
        assertTrue(Game.Create().GetCurrentPlayer().GetAminoAcid() > nucleo);
    }

    @Test @Order (9)
    public void lootEquipmentFromTest(){
        int numEquipment = Game.Create().GetCurrentPlayer().GetEquipments().size();
        clickAt(20, 40);
        robot.delay(ROBOT_DELAY);
        clickAt(20, 180);
        robot.delay(ROBOT_DELAY);
        clickAt(170, 180);
        robot.delay(ROBOT_DELAY);
        assertTrue(Game.Create().GetCurrentPlayer().GetEquipments().size() > numEquipment);
    }

    @Test @Order (10)
    public void collectTest(){
        Field warehouse = Game.Create().GetFields().get(0);
        for (Field field : Game.Create().GetFields()) {
            if(field instanceof Warehouse){
                warehouse = field;
                break;
            }
        }

        warehouse.AddVirologist(Game.Create().GetCurrentPlayer());
        Game.Create().GetCurrentPlayer().IncreaseLimit(30);
        Game.Create().GetCurrentPlayer().SetActionCount(3);
        int amino = Game.Create().GetCurrentPlayer().GetAminoAcid();
        int nucleo = Game.Create().GetCurrentPlayer().GetNucleotide();
        clickAt(20, 40);
        robot.delay(ROBOT_DELAY);
        clickAt(20, 200);
        robot.delay(ROBOT_DELAY);
        assertTrue(Game.Create().GetCurrentPlayer().GetAminoAcid() > amino || Game.Create().GetCurrentPlayer().GetNucleotide() > nucleo);
    }

    @Test @Order (11)
    public void learnTest(){
        Field lab = Game.Create().GetFields().get(0);
        for (Field field : Game.Create().GetFields()) {
            if(field instanceof Laboratory){
                lab = field;
                break;
            }
        }

        lab.AddVirologist(Game.Create().GetCurrentPlayer());
        Game.Create().GetCurrentPlayer().SetActionCount(3);
        int codes = Game.Create().GetCurrentPlayer().getGeneticCodes().size();
        clickAt(20, 40);
        robot.delay(ROBOT_DELAY);
        clickAt(20, 210);
        robot.delay(ROBOT_DELAY);
        assertTrue(Game.Create().GetCurrentPlayer().getGeneticCodes().size() > codes);
    }

    @Test @Order (12)
    public void injectTest(){
        int amino = Game.Create().GetCurrentPlayer().GetAminoAcid();
        int nucleo = Game.Create().GetCurrentPlayer().GetNucleotide();
        Game.Create().GetCurrentPlayer().AddGeneticCode(new BlockCode(10, 10, 2));
        clickAt(20, 40);
        robot.delay(ROBOT_DELAY);
        clickAt(20, 250);
        robot.delay(ROBOT_DELAY);
        clickAt(170, 250);
        robot.delay(ROBOT_DELAY);
        clickAt(200, 250);
        robot.delay(ROBOT_DELAY);
        assertTrue(amino > Game.Create().GetCurrentPlayer().GetAminoAcid() || nucleo > Game.Create().GetCurrentPlayer().GetNucleotide());
    }

    private void clickAt(int x, int y){
        robot.mouseMove(x, y);
        robot.delay(ROBOT_DELAY);
        robot.mousePress(leftClick);
        robot.mouseRelease(leftClick);
    }
}

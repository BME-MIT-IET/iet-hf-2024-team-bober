package virologist;

import virologist.control.Controller;
import virologist.control.Loader;

public class Main {

    /**
     * Alkalmazás belépési pontja.
     * @param args parancsori argumentumok.
     */
    public static void main(String[] args){
        String mapPath = "maps/map3.txt";
        if (args.length > 0)
            mapPath = args[0];
        try {
            Loader loader = new Loader();
            Controller controller = new Controller(loader.loadGame(mapPath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

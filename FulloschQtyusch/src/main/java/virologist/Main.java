package virologist;

import virologist.control.Controller;
import virologist.control.Loader;
//TODO comment
//TODO 2 virologist.Main osztaly is van, sztem lehetne a controlban, de itt is jo akar
public class Main {

    /**
     * Alkalmazás belépési pontja.
     * @param args parancsori argumentumok.
     */
    public static void main(String[] args){
        String mapPath = "/home/adrian/sc/felev-6/IET/hazi/iet-hf-2024-team-bober/FulloschQtyusch/maps/map1.txt";
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

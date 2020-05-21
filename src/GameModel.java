
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

public class GameModel {
    private static long points=0;
    private int day =1;
    private List<VirusSpreadListener> list= new ArrayList<>();
    private List<Country> world= new ArrayList<>();



    public GameModel(){
        setWorld();
        addVirusSpreadListeners(world);
    }

    /*public void addVirusSpreadListener(VirusSpreadListener v){
        list.add(v);
    }*/

    private void addVirusSpreadListeners(List<Country> vList){
        list.addAll(vList);
    }

    public void fireEvent(EventObject e){
        for(VirusSpreadListener v : list){
            v.SpreadVirus();
        }
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void increaseDay(){
        day += 1;
    }

    private void setWorld(){
        world.add(new Country(1373000000,"Chiny",790,360));
        world.get(0).setVirusSpreading(true);  // Rozpoczecie rozprzestrzeniania VIRUSA

        world.add(new Country(146000000,"Rosja",765,270));
        world.add(new Country(56020,"Grenlandia",390,205));
        world.add(new Country(205000000,"Brazylia",350,530));
        world.add(new Country(45000000,"Argentyna",310,605));
        world.add(new Country(50000000,"Kolumbia",325,470));
        world.add(new Country(125000000,"Meksyk",243,430));
        world.add(new Country(320000000,"USA",225,360));
        world.add(new Country(20000000,"Kanada",195,290));
        world.add(new Country(58000000,"RPA",590,560));
        world.add(new Country(900000000,"Afryka śr.",560,470));
        world.add(new Country(115000000,"Afryka pół.",525,400));
        world.add(new Country(34000000,"Arabia Saud.",630,410));
        world.add(new Country(9000000,"Australia",860,530));
        world.add(new Country(741000000,"Europa",560,315));
        world.add(new Country(20000000,"Skandynawia",555,210));
        world.add(new Country(1300000000,"Indie",735,400));
        world.add(new Country(65000000,"UK",520,315));
        world.add(new Country(350000,"Islandia",445,275));
    }

    public List<Country> getWorld() {
        return world;
    }

    public static long getPoints() {
        return points;
    }

    public static void setPoints(long points) {
        GameModel.points = points;
    }

    public static void increasePoints(long p) {
        points += p;
    }
}

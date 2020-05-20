import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

public class GameModel {
    private int day =1;
    private List<VirusSpreadListener> list= new ArrayList<>();
    private List<Country> world= new ArrayList<>();

    public GameModel(){
        setWorld();
    }

    public void addVirusSpreadListener(VirusSpreadListener v){
        list.add(v);
    }

    public void fireEvent(EventObject e){
        for(VirusSpreadListener v : list){
            v.SpreadVirus();
        }
    }

    public int getDay() {
        return day;
    }

    public void increaseDay(){
        day += 1;
    }

    private void setWorld(){
        world.add(new Country(1,"Rosja",765,270));
        world.add(new Country(1,"Grenlandia",390,205));
        world.add(new Country(1,"Brazylia",350,530));
        world.add(new Country(1,"Argentyna",310,605));
        world.add(new Country(1,"Kolumbia",325,470));
        world.add(new Country(1,"Meksyk",243,430));
        world.add(new Country(1,"USA",225,360));
        world.add(new Country(1,"Kanada",195,290));
        world.add(new Country(1,"RPA",590,560));
        world.add(new Country(1,"Afryka śr.",560,470));
        world.add(new Country(1,"Afryka pół.",525,400));
        world.add(new Country(1,"Arabia Saud.",630,410));
        world.add(new Country(1,"Australia",860,530));
        world.add(new Country(1,"Europa",560,315));
        world.add(new Country(1,"Chiny",790,360));
        world.add(new Country(1,"Skandynawia",555,210));
        world.add(new Country(1,"Indie",735,400));
        world.add(new Country(1,"UK",520,315));
        world.add(new Country(1,"Islandia",445,275));
    }

    public List<Country> getWorld() {
        return world;
    }
}

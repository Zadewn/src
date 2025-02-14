import java.util.*;

public class NavioCargueiro extends Embarcacao{
    private ArrayList<Container> conteineres = new ArrayList<Container>();
    
    public ArrayList getConteineres(){
        return conteineres;
    }

    public void setConteineres(Container container){
        if(container != null){
            conteineres.add(container);
        }
    }

}
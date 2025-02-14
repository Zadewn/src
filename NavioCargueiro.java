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

    public void calcularPeso(){
        pesoAdicional += capitao.getPeso();
        if(tripulacao.isEmpty() == false){
            for (Object pessoa : tripulacao) {
                Pessoa p = (Pessoa) pessoa;
                pesoAdicional += p.getPeso();
            }
        }if(conteineres.isEmpty() == false){
            for (Object container : conteineres) {
                Container c = (Container) container;
                pesoAdicional += c.getPeso();
            }
        }
    }

}
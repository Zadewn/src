import controller.EclusaSupController;
import model.EclusaSup;
import view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        double tempoParaEncher = 30;  
        double tempoParaEsvaziar = 30; 

        EclusaSup sup = new EclusaSup(tempoParaEncher, tempoParaEsvaziar);

        EclusaSupController controller = new EclusaSupController(sup);

        ConsoleView view = new ConsoleView(controller);

        view.exibirMenu();
    }
}

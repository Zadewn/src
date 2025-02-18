import controller.EclusaSupController;
import model.EclusaSup;
import view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        double tempoParaEncher = 30;  
        double tempoParaEsvaziar = 30; 

        // Cria o modelo (Lock)
        EclusaSup lock = new EclusaSup(tempoParaEncher, tempoParaEsvaziar);

        // Cria o controller
        EclusaSupController controller = new EclusaSupController(lock);

        // Cria a view (console)
        ConsoleView view = new ConsoleView(controller);

        // Inicia a interação
        view.exibirMenu();
    }
}

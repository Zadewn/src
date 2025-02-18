import controller.LockController;
import model.Lock;
import view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        double tempoParaEncher = 30;  
        double tempoParaEsvaziar = 30; 

        // Cria o modelo (Lock)
        Lock lock = new Lock(tempoParaEncher, tempoParaEsvaziar);

        // Cria o controller
        LockController controller = new LockController(lock);

        // Cria a view (console)
        ConsoleView view = new ConsoleView(controller);

        // Inicia a interação
        view.exibirMenu();
    }
}

import controller.LockController;
import model.Lock;
import view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        double tempoParaEncher = 30;   // Exemplo: 30 min
        double tempoParaEsvaziar = 30; // Exemplo: 30 min

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

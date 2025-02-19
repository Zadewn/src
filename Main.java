import controller.EclusaSupController;
import model.EclusaSup;
import view.ConsoleView;

public class Main {
    public static void main(String[] args) {

        EclusaSup sup = new EclusaSup();

        EclusaSupController controller = new EclusaSupController(sup);

        ConsoleView view = new ConsoleView(controller);

        view.exibirMenu();
    }
}

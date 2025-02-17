import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class EclusaView {
    public static void atualizarBotao(Button button, boolean aberto) {
        button.setStyle(aberto ? "-fx-background-color: green;" : "-fx-background-color: red;");
    }

    public static void atualizarNivelAgua(ImageView agua, double nivel) {
        agua.setLayoutY(nivel);
    }
}

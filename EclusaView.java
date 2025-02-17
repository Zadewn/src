import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class EclusaView {
    public static void atualizarComporta(Button button, ImageView comporta, boolean aberta) {
        comporta.setVisible(aberta);
        button.setStyle(aberta ? "-fx-background-color: green;" : "-fx-background-color: red;");
    }

    public static void atualizarNivelAgua(ImageView agua, double nivel) {
        agua.setLayoutY(nivel);
    }
}

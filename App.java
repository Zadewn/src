import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class App extends Application{
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("layout.fxml"));
        Parent root = fxmlLoader.load();
        Scene tela = new Scene(root);

        primaryStage.setTitle("POO das Canoas");
        primaryStage.setScene(tela);
        primaryStage.show();
    }

    public class EclusaView {
    public static void atualizarBotao(Button button, boolean aberto) {
        button.setStyle(aberto ? "-fx-background-color: green;" : "-fx-background-color: red;");
    }

    public static void atualizarNivelAgua(ImageView agua, double nivel) {
        agua.setLayoutY(nivel);
    }
}
}



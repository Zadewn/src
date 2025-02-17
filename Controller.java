import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Controller {
    @FXML private AnchorPane mainPane;
    @FXML private ImageView AguaEclusa;
    @FXML private ImageView ComportaMar;
    @FXML private ImageView ComportaRio;
    @FXML private Button comportaMarButton;
    @FXML private Button comportaRioButton;
    @FXML private ProgressBar progressBar;

    private EclusaService eclusaService;

    @FXML
    public void initialize() {
        Eclusa eclusa = new Eclusa();
        Main = new EclusaService(eclusa);
        progressBar.setProgress(0);
    }

    @FXML
    private void toggleComportaRio(ActionEvent event) {
        try {
            boolean aberta = Main.alternarComportaRio();
            EclusaView.atualizarComporta(comportaRioButton, ComportaRio, aberta);
        } catch (AbrirComportaInvalidaException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void toggleComportaMar(ActionEvent event) {
        try {
            boolean aberta = Main.alternarComportaMar();
            EclusaView.atualizarComporta(comportaMarButton, ComportaMar, aberta);
        } catch (AbrirComportaInvalidaException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void encherEclusa(ActionEvent event) {
        EclusaView.atualizarNivelAgua(AguaEclusa, 157);
        progressBar.setProgress(1.0);
    }

    @FXML
    private void secarEclusa(ActionEvent event) {
        EclusaView.atualizarNivelAgua(AguaEclusa, 206);
        progressBar.setProgress(0.0);
    }

    @FXML
    private void requisitarLancha(ActionEvent event) {
        ImageView navio = EmbarcacaoFactory.criarEmbarcacao("@../../Navios/X.png", 100, 250);
        mainPane.getChildren().add(navio);
        navio.toFront();
    }

    @FXML
    private void requisitarCruzeiro(ActionEvent event) {
        ImageView navio = EmbarcacaoFactory.criarEmbarcacao("@../../Navios/X.png", 50, 200);
        mainPane.getChildren().add(navio);
        navio.toFront();
    }
}

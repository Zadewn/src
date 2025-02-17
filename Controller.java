//import javafx.animation.KeyFrame;
//import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
//import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
//import javafx.util.Duration;
import javafx.scene.layout.AnchorPane;

public class Controller {

    @FXML
    private AnchorPane mainPane;

    @FXML
    private ImageView AguaEclusa;

    @FXML
    private ImageView ComportaMar;

    @FXML
    private ImageView ComportaRio;

    @FXML
    private Button EncherEclusa;

    @FXML
    private Button PararEclusa;

    @FXML
    private Button RequesitarCargueiroMar;

    @FXML
    private Button RequesitarCargueiroRio;

    @FXML
    private Button RequesitarCruzeiroMar;

    @FXML
    private Button RequesitarCruzeiroRio;

    @FXML
    private Button RequesitarLanchaMar;

    @FXML
    private Button RequesitarLanchaRio;

    @FXML
    private Button SecarEclusa;

    @FXML
    private Button comportaMarButton;

    @FXML
    private Button comportaRioButton;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private TextField NumeroFilaMar;

    @FXML
    private TextField NumeroFilaRio;

    //private Timeline timeline;
    //private boolean animacaoRodando = false;

    private Eclusa eclusa = new Eclusa();

    @FXML
    public void initialize() {
        progressBar.setProgress(0);
        atualizarBotao(comportaRioButton, ComportaRio);
        atualizarBotao(comportaMarButton, ComportaMar);
    }

    @FXML
    private void requisitarLancha(ActionEvent event) {
        adicionarEmbarcacao("lancha", "@../../Navios/X.png", 100, 250);
    }

    @FXML
    private void requisitarCruzeiro(ActionEvent event) {
        adicionarEmbarcacao("cruzeiro", "@../../Navios/X.png", 50, 200);
    }

    private void adicionarEmbarcacao(String tipo, String caminhoImagem, double x, double y) {
        ImageView navio = new ImageView(caminhoImagem);
        navio.setFitWidth(80); 
        navio.setFitHeight(40);
        navio.setLayoutX(x); 
        navio.setLayoutY(y); 

        mainPane.getChildren().add(navio);
        navio.toFront();
    }

    @FXML
    private void toggleComportaRio(ActionEvent event) throws AbrirComportaInvalidaException {
        eclusa.alterarComportaRio();
        if (eclusa.getComportaRio()) {
            toggleComporta(comportaRioButton, ComportaRio);
        }
    }

    @FXML
    private void toggleComportaMar(ActionEvent event) throws AbrirComportaInvalidaException {
        eclusa.alterarComportaMar();
        if (eclusa.getComportaMar()) {
            toggleComporta(comportaMarButton, ComportaMar);
        } 
    }

    private void toggleComporta(Button button, ImageView comporta) {
        boolean visivel = !comporta.isVisible();
        comporta.setVisible(visivel);
        atualizarBotao(button, comporta);
    }

    private void atualizarBotao(Button button, ImageView comporta) {
        if (comporta.isVisible()) {
            button.setStyle("-fx-background-color: green;");
        } else {
            button.setStyle("-fx-background-color: red;");
        }
    }

    @FXML
    private void encherEclusa(ActionEvent event) {
        AguaEclusa.setLayoutY(157); 
        progressBar.setProgress(1.0); 
    }
    
    @FXML
    private void secarEclusa(ActionEvent event) {
        AguaEclusa.setLayoutY(206); 
        progressBar.setProgress(0.0); 
    }
    
    @FXML
    private void pararEclusa(ActionEvent event) {
    }

    /*@FXML
    private void encherEclusa() {
        if (animacaoRodando) return;
        animacaoRodando = true;
        iniciarAnimacao(AguaEclusa.getLayoutY(), 157, progressBar.getProgress(), 1);
    }

    @FXML
    private void secarEclusa() {
        if (animacaoRodando) return;
        animacaoRodando = true;
        iniciarAnimacao(AguaEclusa.getLayoutY(), 206, progressBar.getProgress(), 0);
    }

    @FXML
    private void pararEclusa() {
        if (timeline != null) {
            timeline.stop();
            animacaoRodando = false;
        }
    }

    private void iniciarAnimacao(double inicioY, double fimY, double progressoInicial, double progressoFinal) {
        double distancia = Math.abs(fimY - inicioY);
        timeline = new Timeline(
            new KeyFrame(Duration.millis(50), _ -> {
                double posicaoAtual = AguaEclusa.getLayoutY();
                if ((fimY > inicioY && posicaoAtual >= fimY) || (fimY < inicioY && posicaoAtual <= fimY)) {
                    timeline.stop();
                    animacaoRodando = false;
                    return;
                }

                double d = (fimY > inicioY) ? 1 : -1;
                AguaEclusa.setLayoutY(posicaoAtual + d);
                double t = Math.abs((posicaoAtual - inicioY) / distancia);
                progressBar.setProgress(progressoInicial + t * (progressoFinal - progressoInicial));
            })
        );

        timeline.setCycleCount((int) distancia);
        timeline.setOnFinished( _ -> {
            progressBar.setProgress(progressoFinal);
            animacaoRodando = false;
        });
        timeline.play();
    }*/
}

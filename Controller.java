import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Controller {

    @FXML private AnchorPane mainPane;
    @FXML private ImageView AguaEclusa;
    @FXML private ImageView ComportaMar;
    @FXML private ImageView ComportaRio;
    @FXML private Button comportaMarButton;
    @FXML private Button comportaRioButton;

    private Eclusa eclusa; 

    @FXML
    public void initialize() {
        eclusa = new Eclusa();
    }

    @FXML
    private void toggleComportaRio(ActionEvent event) {
        try {
            boolean aberta = Main.alternarComportaRio(eclusa); 
            EclusaView.atualizarComporta(comportaRioButton, ComportaRio, aberta);
        } catch (AbrirComportaInvalidaException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void toggleComportaMar(ActionEvent event) {
        try {
            boolean aberta = Main.alternarComportaMar(eclusa); 
            EclusaView.atualizarComporta(comportaMarButton, ComportaMar, aberta);
        } catch (AbrirComportaInvalidaException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void encherEclusa(ActionEvent event) {
        EclusaView.atualizarNivelAgua(AguaEclusa, 157);
    }

    @FXML
    private void secarEclusa(ActionEvent event) {
        EclusaView.atualizarNivelAgua(AguaEclusa, 206); 
    }

    @FXML
    private void requisitarLancha(ActionEvent event) {
        
    }

    @FXML
    private void requisitarCruzeiro(ActionEvent event) {
        
        
    }
}

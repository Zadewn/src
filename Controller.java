import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Controller {

    @FXML private ImageView AguaEclusa;
    @FXML private TextField CanosAbertos;
    @FXML private TextField Cconteineres;
    @FXML private TextField Cconteineres1;
    @FXML private ImageView ComportaMar;
    @FXML private ImageView ComportaRio;
    @FXML private TextField Cpesoconteineres;
    @FXML private TextField Cpesoconteineres1;
    @FXML private Button EncherEclusa;
    @FXML private TextField LTCcapitão;
    @FXML private TextField LTCcapitão1;
    @FXML private TextField LTCcargamax;
    @FXML private TextField LTCcargamax1;
    @FXML private TextField LTCcomprimento;
    @FXML private TextField LTCcomprimento1;
    @FXML private TextField LTCid;
    @FXML private TextField LTCid1;
    @FXML private TextField LTClargura;
    @FXML private TextField LTClargura1;
    @FXML private TextField LTCpassageiros;
    @FXML private TextField LTCpassageiros1;
    @FXML private TextField LTCpesopassageiros;
    @FXML private TextField LTCpesopassageiros1;
    @FXML private TextField NumeroFilaMar;
    @FXML private TextField NumeroFilaRio;
    @FXML private Button RequesitarCargueiroMar;
    @FXML private Button RequesitarCargueiroRio;
    @FXML private Button RequesitarCruzeiroMar;
    @FXML private Button RequesitarCruzeiroRio;
    @FXML private Button RequesitarLanchaMar;
    @FXML private Button RequesitarLanchaRio;
    @FXML private Button SecarEclusa;
    @FXML private TextField TelaAvisos;
    @FXML private Button comportaMarButton;
    @FXML private Button comportaRioButton;
    @FXML private AnchorPane mainPane;
    @FXML private Button requisitarC;
    @FXML private Button requisitarLT;


    private Eclusa eclusa; 

    @FXML
    public void initialize() {
        eclusa = new Eclusa();

        @SuppressWarnings("unused")
        ChangeListener<String> listener = (observable, oldValue, newValue) -> {
            requisitarLT.setDisable(!camposPreenchidos(false));
            requisitarC.setDisable(!camposPreenchidos(true));
        };

        LTCid.textProperty().addListener(listener);
        LTCcomprimento.textProperty().addListener(listener);
        LTClargura.textProperty().addListener(listener);
        LTCpassageiros.textProperty().addListener(listener);
        LTCpesopassageiros.textProperty().addListener(listener);
        LTCcargamax.textProperty().addListener(listener);
        LTCcapitão.textProperty().addListener(listener);
        Cconteineres.textProperty().addListener(listener);
        Cpesoconteineres.textProperty().addListener(listener);
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

    private boolean camposPreenchidos(boolean isCargueiro) {
        if (LTCid.getText().isEmpty() || LTCcomprimento.getText().isEmpty() || LTClargura.getText().isEmpty() ||
            LTCpassageiros.getText().isEmpty() || LTCpesopassageiros.getText().isEmpty() ||
            LTCcargamax.getText().isEmpty() || LTCcapitão.getText().isEmpty()) {
            return false;
        }

        if (isCargueiro && (Cconteineres.getText().isEmpty() || Cpesoconteineres.getText().isEmpty())) {
            return false;
        }
    
        return true;
    }

    private void configurarCamposParaRequisicao(boolean isCargueiro) {
        LTCid.setVisible(true);
        LTCcomprimento.setVisible(true);
        LTClargura.setVisible(true);
        LTCpassageiros.setVisible(true);
        LTCpesopassageiros.setVisible(true);
        LTCcargamax.setVisible(true);
        LTCcapitão.setVisible(true);

        LTCid1.setVisible(true);
        LTCcomprimento1.setVisible(true);
        LTClargura1.setVisible(true);
        LTCpassageiros1.setVisible(true);
        LTCpesopassageiros1.setVisible(true);
        LTCcargamax1.setVisible(true);
        LTCcapitão1.setVisible(true);
    
        Cconteineres.setVisible(isCargueiro);
        Cpesoconteineres.setVisible(isCargueiro);
        Cconteineres1.setVisible(isCargueiro);
        Cpesoconteineres1.setVisible(isCargueiro);
    
        requisitarLT.setVisible(!isCargueiro);
        requisitarC.setVisible(isCargueiro);
    }

    @FXML
    private void requisitarLanchaRio(ActionEvent event) {
        configurarCamposParaRequisicao(false);
        requisitarLT.setDisable(!camposPreenchidos(false));

        String nomeCapitao = LTCcapitão.getText();
        float largura = Float.parseFloat(LTCcomprimento.getText());  
        float comprimento = Float.parseFloat(LTCcomprimento.getText());
        int nPassageiros = Integer.parseInt(LTCpassageiros.getText());
        float mediaPesoPassageiros = Float.parseFloat(LTCpesopassageiros.getText());
        int ID = Integer.parseInt(LTCid.getText());
        float cargaMax = Float.parseFloat(LTCcargamax.getText());
        char sentido = 'R';  

        Main.requisitarLanchaRio(eclusa, largura, comprimento, nPassageiros, mediaPesoPassageiros, ID, cargaMax, nomeCapitao, sentido);

        requisitarLT.setDisable(!camposPreenchidos(false));
    }

    @FXML
    private void requisitarLanchaMar(ActionEvent event) {
        configurarCamposParaRequisicao(false);
        requisitarLT.setDisable(!camposPreenchidos(false));

        String nomeCapitao = LTCcapitão.getText();
        float largura = Float.parseFloat(LTCcomprimento.getText()); 
        float comprimento = Float.parseFloat(LTCcomprimento.getText());
        int nPassageiros = Integer.parseInt(LTCpassageiros.getText());
        float mediaPesoPassageiros = Float.parseFloat(LTCpesopassageiros.getText());
        int ID = Integer.parseInt(LTCid.getText());
        float cargaMax = Float.parseFloat(LTCcargamax.getText());
        char sentido = 'R';  

        Main.requisitarLanchaMar(eclusa, largura, comprimento, nPassageiros, mediaPesoPassageiros, ID, cargaMax, nomeCapitao, sentido);

        requisitarLT.setDisable(!camposPreenchidos(false));
    }

    @FXML
    private void requisitarCruzeiroRio(ActionEvent event) {
        configurarCamposParaRequisicao(false);
        requisitarLT.setDisable(!camposPreenchidos(false));

        String nomeCapitao = LTCcapitão.getText();
        float largura = Float.parseFloat(LTCcomprimento.getText());
        float comprimento = Float.parseFloat(LTCcomprimento.getText());
        int nPassageiros = Integer.parseInt(LTCpassageiros.getText());
        float mediaPesoPassageiros = Float.parseFloat(LTCpesopassageiros.getText());
        int ID = Integer.parseInt(LTCid.getText());
        float cargaMax = Float.parseFloat(LTCcargamax.getText());
        char sentido = 'R';  

        Main.requisitarNavioTurismoRio(eclusa, largura, comprimento, nPassageiros, mediaPesoPassageiros, ID, cargaMax, nomeCapitao, sentido);

        requisitarLT.setDisable(!camposPreenchidos(false));
    }

    @FXML
    private void requisitarCruzeiroMar(ActionEvent event) {
        configurarCamposParaRequisicao(false);
        requisitarLT.setDisable(!camposPreenchidos(false));

        String nomeCapitao = LTCcapitão.getText();
        float largura = Float.parseFloat(LTCcomprimento.getText());
        float comprimento = Float.parseFloat(LTCcomprimento.getText());
        int nPassageiros = Integer.parseInt(LTCpassageiros.getText());
        float mediaPesoPassageiros = Float.parseFloat(LTCpesopassageiros.getText());
        int ID = Integer.parseInt(LTCid.getText());
        float cargaMax = Float.parseFloat(LTCcargamax.getText());
        char sentido = 'M';  

        Main.requisitarNavioTurismoMar(eclusa, largura, comprimento, nPassageiros, mediaPesoPassageiros, ID, cargaMax, nomeCapitao, sentido);

        requisitarLT.setDisable(!camposPreenchidos(false));
    }

    @FXML
    private void requisitarNavioCargueiroRio(ActionEvent event) {
        configurarCamposParaRequisicao(true);
        requisitarC.setDisable(!camposPreenchidos(true));
        String nomeCapitao = LTCcapitão.getText();
        float largura = Float.parseFloat(LTCcomprimento.getText());
        float comprimento = Float.parseFloat(LTCcomprimento.getText());
        int nPassageiros = Integer.parseInt(LTCpassageiros.getText());
        float mediaPesoPassageiros = Float.parseFloat(LTCpesopassageiros.getText());
        int nConteineres = Integer.parseInt(Cconteineres.getText());
        float mediaPesoConteineres = Float.parseFloat(Cpesoconteineres.getText());
        int ID = Integer.parseInt(LTCid.getText());
        float cargaMax = Float.parseFloat(LTCcargamax.getText());
        char sentido = 'R';  
    
        Main.requisitarNavioCargueiroRio(eclusa, largura, comprimento, nPassageiros, mediaPesoPassageiros, nConteineres, mediaPesoConteineres, ID, cargaMax, nomeCapitao, sentido);

        requisitarC.setDisable(!camposPreenchidos(true));
    }
    
    @FXML
    private void requisitarNavioCargueiroMar(ActionEvent event) {
        configurarCamposParaRequisicao(true);
        requisitarC.setDisable(!camposPreenchidos(true));
        String nomeCapitao = LTCcapitão.getText();
        float largura = Float.parseFloat(LTCcomprimento.getText());
        float comprimento = Float.parseFloat(LTCcomprimento.getText());
        int nPassageiros = Integer.parseInt(LTCpassageiros.getText());
        float mediaPesoPassageiros = Float.parseFloat(LTCpesopassageiros.getText());
        int nConteineres = Integer.parseInt(Cconteineres.getText());
        float mediaPesoConteineres = Float.parseFloat(Cpesoconteineres.getText());
        int ID = Integer.parseInt(LTCid.getText());
        float cargaMax = Float.parseFloat(LTCcargamax.getText());
        char sentido = 'M';  

        Main.requisitarNavioCargueiroMar(eclusa, largura, comprimento, nPassageiros, mediaPesoPassageiros, nConteineres, mediaPesoConteineres, ID, cargaMax, nomeCapitao, sentido);

        requisitarC.setDisable(!camposPreenchidos(true));
    }

    @FXML
    private void requisitarLT(ActionEvent event) throws InterruptedException{
        tornarCamposInvisiveis();

    }

    @FXML
    private void requisitarC(ActionEvent event) throws InterruptedException{
        tornarCamposInvisiveis();

    }

    private void tornarCamposInvisiveis() {
        LTCid.setVisible(false);
        LTCcomprimento.setVisible(false);
        LTClargura.setVisible(false);
        LTCpassageiros.setVisible(false);
        LTCpesopassageiros.setVisible(false);
        LTCcargamax.setVisible(false);
        LTCcapitão.setVisible(false);
    
        Cconteineres.setVisible(false);
        Cpesoconteineres.setVisible(false);
    
        LTCid1.setVisible(false);
        LTCcomprimento1.setVisible(false);
        LTClargura1.setVisible(false);
        LTCpassageiros1.setVisible(false);
        LTCpesopassageiros1.setVisible(false);
        LTCcargamax1.setVisible(false);
        LTCcapitão1.setVisible(false);
        requisitarLT.setVisible(false);
        requisitarC.setVisible(false);

        TelaAvisos.setText("Navio requisitado!");
    }


}

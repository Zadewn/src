import javafx.scene.image.ImageView;

public class EmbarcacaoFactory {
    public static ImageView criarEmbarcacao(String caminhoImagem, double x, double y) {
        ImageView navio = new ImageView(caminhoImagem);
        navio.setFitWidth(80);
        navio.setFitHeight(40);
        navio.setLayoutX(x);
        navio.setLayoutY(y);
        return navio;
    }
}

public class AbrirComportaInvalidaException extends Exception{
    public AbrirComportaInvalidaException(){
        super("ERRO! voce esta tentando abrir a comporta em situacao invalida");
    }
}
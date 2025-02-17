public class AbrirComportaInvalidaException extends Exception{
    public AbrirComportaInvalidaException(String e){
        super(e);
    }

    public AbrirComportaInvalidaException(){
        super("ERRO!!");
    }
}
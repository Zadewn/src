package CODIGAO;
class ComportaAbertaException extends Exception {
    public ComportaAbertaException(){
        super("ERRO!! Uma ou mais comportas abertas");
    }
}

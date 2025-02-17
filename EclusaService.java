public class EclusaService {
    private Eclusa eclusa;

    public EclusaService(Eclusa eclusa) {
        this.eclusa = eclusa;
    }

    public boolean alternarComportaRio() throws AbrirComportaInvalidaException {
        eclusa.alterarComportaRio();
        return eclusa.getComportaRio();
    }

    public boolean alternarComportaMar() throws AbrirComportaInvalidaException {
        eclusa.alterarComportaMar();
        return eclusa.getComportaMar();
    }
}

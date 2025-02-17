public class Main{

    public static void requisitarLanchaRio(Eclusa eclusa, float largura, float comprimento, int nPassageiros, float mediaPesoPassageiros, int ID, float cargaMax, String Nomecapitao){
        Lancha l = new Lancha(largura, comprimento, nPassageiros, mediaPesoPassageiros, ID, cargaMax, Nomecapitao, 'R');
        eclusa.setFilaRio(l);
    }

    public static void requisitarLanchaMar(Eclusa eclusa, float largura, float comprimento, int nPassageiros, float mediaPesoPassageiros, int ID, float cargaMax, String Nomecapitao){
        Lancha l = new Lancha(largura, comprimento, nPassageiros, mediaPesoPassageiros, ID, cargaMax, Nomecapitao, 'M');
        eclusa.setFilaMar(l);
    }

    public static void requisitarNavioTurismoRio(Eclusa eclusa, float largura, float comprimento, int nPassageiros, float mediaPesoPassageiros, int ID, float cargaMax, String Nomecapitao){
        NavioTurismo l = new NavioTurismo(largura, comprimento, nPassageiros, mediaPesoPassageiros, ID, cargaMax, Nomecapitao, 'R');
        eclusa.setFilaRio(l);
    }

    public static void requisitarNavioTurismoMar(Eclusa eclusa, float largura, float comprimento, int nPassageiros, float mediaPesoPassageiros, int ID, float cargaMax, String Nomecapitao){
        NavioTurismo l = new NavioTurismo(largura, comprimento, nPassageiros, mediaPesoPassageiros, ID, cargaMax, Nomecapitao, 'M');
        eclusa.setFilaMar(l);
    }

    public static boolean alternarComportaRio(Eclusa eclusa) throws AbrirComportaInvalidaException {
        eclusa.alterarComportaRio();
        return eclusa.getComportaRio();
    }

    public static boolean alternarComportaMar(Eclusa eclusa) throws AbrirComportaInvalidaException {
        eclusa.alterarComportaMar();
        return eclusa.getComportaMar();
    }

    


    public static void main(String[] args){
        /*Container c = new Container();
        Container c2 = new Container();
        NavioCargueiro n = new NavioCargueiro();

        c.setPeso(200);
        c.setEmpresa("Samsung");
        c2.setPeso(250);
        c2.setEmpresa("LG");
        n.setConteineres(c);
        n.setConteineres(c2);
        for(Object nn : n.getConteineres()){
            Container l = (Container) nn;
            System.out.println(l.getEmpresa());
        }*/

        Eclusa e = new Eclusa();
        e.setCapacidadeMAX(100);
        e.setCapacidadeMIN(10);
        e.setCapacidadeAtual(100);
        e.setQuantidadeCanos(1);
        e.setVazao(10);
        
        try {
            e.alterarComportaMar();
            e.alterarComportaMar();
            e.esvaziarEclusa(1);
        } catch (ComportaAbertaException | AbrirComportaInvalidaException o) {
            System.out.println(o.getMessage());
        }
        
        


    }
}
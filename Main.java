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

    public static void requisitarNavioCargueiroMar(Eclusa eclusa, float largura, float comprimento, int nPassageiros, float mediaPesoPassageiros, int nConteineres, float mediaPesoConteineres, int ID, float cargaMax, String nomecapitao, char sentido){
        NavioCargueiro l = new NavioCargueiro(largura, comprimento, nPassageiros, mediaPesoPassageiros, nConteineres, mediaPesoConteineres, ID, cargaMax, nomecapitao, 'M');
        eclusa.setFilaMar(l);
    }

    public static void requisitarNavioCargueiroRio(Eclusa eclusa, float largura, float comprimento, int nPassageiros, float mediaPesoPassageiros, int nConteineres, float mediaPesoConteineres, int ID, float cargaMax, String nomecapitao, char sentido){
        NavioCargueiro l = new NavioCargueiro(largura, comprimento, nPassageiros, mediaPesoPassageiros, nConteineres, mediaPesoConteineres, ID, cargaMax, nomecapitao, 'R');
        eclusa.setFilaRio(l);
    }

    public static boolean alternarComportaRio(Eclusa eclusa) throws AbrirComportaInvalidaException {
        eclusa.alterarComportaRio();
        return eclusa.getComportaRio();
    }

    public static boolean alternarComportaMar(Eclusa eclusa) throws AbrirComportaInvalidaException {
        eclusa.alterarComportaMar();
        return eclusa.getComportaMar();
    }

    public static String updatePorcentagem(int porcentagem){
        return "" + porcentagem +"%";
    }

    public static void secarEclusa(Eclusa eclusa, int canosAbertos){
        try {
            eclusa.esvaziarEclusa(canosAbertos);
        } catch (ComportaAbertaException e) {
        }
    }

    public static void encherEclusa(Eclusa eclusa, int canosAbertos){
        try {
            eclusa.encherEclusa(canosAbertos);
        } catch (ComportaAbertaException e) {

        }
    }

    public static void liberarMar(Eclusa eclusa){
        eclusa.encaixarNaviosMar();
    }

    public static void liberarRio(Eclusa eclusa){
        eclusa.encaixarNaviosRio();
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
            e.alterarComportaRio();
            e.esvaziarEclusa(1);
        } catch (ComportaAbertaException | AbrirComportaInvalidaException o) {
            System.out.println(o.getMessage());
        }
        
        


    }
}
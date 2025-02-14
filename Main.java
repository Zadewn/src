public class Main{
    public static void main(String[] args){
        Container c = new Container();
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
        }

    }
}
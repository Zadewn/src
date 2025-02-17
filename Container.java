
public class Container {

    private float peso;
    private String empresa;

    public float getPeso() {
        return peso;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setPeso(float peso) {
        if (peso > 0) {
            this.peso = peso;
        }
    }

    public void setEmpresa(String empresa) {
        if (empresa != null) {
            this.empresa = empresa;
        }
    }

    public Container() {
    }

    public Container(float peso) {
        setPeso(peso);
    }

}

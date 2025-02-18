package model;
public class Container {
    private float peso;

    public float getPeso() { return peso; }

    public void setPeso(float peso) { if (peso > 0) this.peso = peso; }

    public Container() {}

    public Container(float peso) {
        setPeso(peso);
    }
}

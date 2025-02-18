
public class Pessoa {

    private String nome;
    private float peso;

    public String getNome() { return nome; }
    public float getPeso() { return peso; }

    public void setNome(String nome) {
        if(nome != null){
            this.nome = nome.toUpperCase();
        }
    }

    public void setPeso(float peso) {
        if (peso > 0) {
            this.peso = peso;
        }
    }

    public Pessoa() {}


    public Pessoa(float peso){
        setPeso(peso);
    }

    public Pessoa(String nome, float peso) {
        setNome(nome);
        setPeso(peso);
    }
}

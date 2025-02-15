
public class Pessoa {

    private String nome;
    private String ocupacao;
    private String cpf;
    private float peso;
    private int telefone;

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getOcupacao() {
        return ocupacao;
    }

    public int getTelefone() {
        return telefone;
    }

    public float getPeso() {
        return peso;
    }

    public void setNome(String nome) {
        if(nome != null){
            this.nome = nome.toUpperCase();
        }
    }

    public void setCpf(String cpf) {
        if (validarCpf(cpf)) {
            this.cpf = cpf; 
        }else {
            this.cpf = null;
        }
    }

    public void setOcupaçao(String ocupacao) {
        if (ocupacao != null) {
            this.ocupacao = ocupacao;
        }
    }

    public void setTelefone(int telefone) {
        if (telefone > 0) {
            this.telefone = telefone;
        }
    }

    public void setPeso(float peso) {
        if (peso > 0) {
            this.peso = peso;
        }
    }

    public Pessoa() {
    }

    public Pessoa(String nome, String ocupacao, String cpf, int telefone, float peso) {
        setNome(nome);
        setOcupaçao(ocupacao);
        setTelefone(telefone);
        setCpf(cpf);
        setPeso(peso);
    }

    public boolean validarCpf(String cpf) {
        if (cpf == null || cpf.length() != 11) {
            return false;
        }

        int soma1 = 0, J = 0;
        for (int i = 0; i < 9; i++) {
            soma1 += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }

        int resto1 = soma1 % 11;
        if (resto1 < 2) {
            J = 0; 
        }else {
            J = 11 - resto1;
        }

        int soma2 = 0, K = 0;
        for (int i = 0; i < 9; i++) {
            soma2 += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }

        soma2 += J * 2;
        int resto2 = soma2 % 11;
        if (resto2 < 2) {
            K = 0; 
        }else {
            K = 11 - resto2;
        }

        return J == Character.getNumericValue(cpf.charAt(9)) && K == Character.getNumericValue(cpf.charAt(10));
    }
}

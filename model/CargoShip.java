package model;

public class CargoShip {
    private String nome;
    private double comprimento; // Em metros
    private double largura;     // Em metros
    private double capacidade;  // Toneladas ou contêineres, conforme sua necessidade
    private String portoOrigem;
    private String portoDestino;
    private double tarifa;      // Tarifa a ser cobrada para atravessar a eclusa

    public CargoShip(String nome, double comprimento, double largura, double capacidade,
                     String portoOrigem, String portoDestino, double tarifa) {
        this.nome = nome;
        this.comprimento = comprimento;
        this.largura = largura;
        this.capacidade = capacidade;
        this.portoOrigem = portoOrigem;
        this.portoDestino = portoDestino;
        this.tarifa = tarifa;
    }

    // Getters e setters
    public String getNome() {
        return nome;
    }

    public double getComprimento() {
        return comprimento;
    }

    public double getLargura() {
        return largura;
    }

    public double getCapacidade() {
        return capacidade;
    }

    public String getPortoOrigem() {
        return portoOrigem;
    }

    public String getPortoDestino() {
        return portoDestino;
    }

    public double getTarifa() {
        return tarifa;
    }

    @Override
    public String toString() {
        return String.format(
            "Navio: %s | Comp: %.2f | Larg: %.2f | Cap: %.2f | Origem: %s | Destino: %s | Tarifa: %.2f",
            nome, comprimento, largura, capacidade, portoOrigem, portoDestino, tarifa
        );
    }
}

public abstract class Embarcacao{
    private float largura;
    private float comprimento;
    private float cargaMaxima;
    private String portoOrigem;
    private String portoDestino;
    private String pais;
    private String codigoID;
    private Pessoa capitao;
    private char sentido; // R = indo do Rio pro mar, M = indo do Mar pro rio

    public float getLargura(){
        return largura;
    }

    public float getComprimento(){
        return comprimento;
    }

    public float getCargaMaxima(){
        return cargaMaxima;
    }

    public String getPortoOrigem(){
        return portoOrigem;
    }

    public String getPortoDestino(){
        return portoDestino;
    }

    public String getPais(){
        return pais;
    }

    public String getCodigoID(){
        return codigoID;
    }

    public Pessoa getCapitao(){
        return capitao;
    }

    public char getSentido(){
        return sentido;
    }

    public void setLargura(float largura){
        if(largura > 0){
            this.largura = largura;
        }
    }

    public void setComprimento(float comprimento){
        if(comprimento > 0){
            this.comprimento = comprimento;

        }
    }

    public void setCargaMaxima(float cargaMaxima){
        if(cargaMaxima >= 0){
            this.cargaMaxima = cargaMaxima;
        }
    }

    public void setPortoOrigem(String portoOrigem){
        if(portoOrigem != null){
            this.portoOrigem = portoOrigem;
        }
    }

    public void setPortoDestino(String portoDestino){
        if(portoDestino != null){
            this.portoDestino = portoDestino;
        }
    }

    public void setPais(String pais){
        if(pais != null){
            this.pais = pais;
        }
    }

    public void setCodigoID(String codigoID){
        if(codigoID != null){
            this.codigoID = codigoID;
        }
    }
    
    public void setCapitao(Pessoa pessoa){
        this.capitao = pessoa;
    }

    public void setSentido(char sentido){
        if(sentido == 'R' || sentido == 'M'){
            this.sentido = sentido;
        }
    }
}
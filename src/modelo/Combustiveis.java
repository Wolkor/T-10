package modelo;


import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Wolkor
 */
public class Combustiveis implements Serializable{
    private Integer codigo;
    private String dataDePrecos;
    private float valorGasolina;
    private float valorGasolinaAd;
    private float valorAlcool;
    private float valorDiesel;
    private Integer idPosto;

    public Integer getIdPosto() {
        return idPosto;
    }

    public void setIdPosto(Integer idPosto) {
        this.idPosto = idPosto;
    }

    public Combustiveis() {
    }
    
    public float getValorGasolina() {
        return valorGasolina;
    }

    public void setValorGasolina(float valorGasolina) {
        this.valorGasolina = valorGasolina;
    }

    public float getValorGasolinaAd() {
        return valorGasolinaAd;
    }

    public void setValorGasolinaAd(float valorGasolinaAd) {
        this.valorGasolinaAd = valorGasolinaAd;
    }

    public float getValorAlcool() {
        return valorAlcool;
    }

    public void setValorAlcool(float valorAlcool) {
        this.valorAlcool = valorAlcool;
    }

    public float getValorDiesel() {
        return valorDiesel;
    }

    public void setValorDiesel(float valorDiesel) {
        this.valorDiesel = valorDiesel;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDataDePrecos() {
        return dataDePrecos;
    }

    public void setDataDePrecos(String dataDePrecos) {
        this.dataDePrecos = dataDePrecos;
    }

    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Combustiveis other = (Combustiveis) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }   
}

package dao;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Carro implements Serializable {

    private final static long serialVersionUID = 6398603102759696550L;
    @SerializedName("marca")
    @Expose
    private String marca;
    @SerializedName("linea")
    @Expose
    private String linea;
    @SerializedName("modelo")
    @Expose
    private String modelo;
    @SerializedName("detalles")
    @Expose
    private String detalles;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("partes")
    @Expose
    private List<String> partes = null;

    /**
     * No args constructor for use in serialization
     */
    public Carro() {
    }

    /**
     * @param marca
     * @param detalles
     * @param partes
     * @param modelo
     * @param linea
     * @param url
     */
    public Carro(String marca, String linea, String modelo, String detalles, String url, List<String> partes) {
        super();
        this.marca = marca;
        this.linea = linea;
        this.modelo = modelo;
        this.detalles = detalles;
        this.url = url;
        this.partes = partes;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getPartes() {
        return partes;
    }

    public void setPartes(List<String> partes) {
        this.partes = partes;
    }

//    @Override
//    public String toString() {
//        return new ToStringBuilder(this).append("marca", marca).append("linea", linea).append("modelo", modelo).append("detalles", detalles).append("url", url).append("partes", partes).toString();
//    }

}
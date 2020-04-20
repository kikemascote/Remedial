package modelo;

import javax.persistence.*;

@Entity
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    String marca, linea, modelo, detalle, parte1, parte2, parte3, parte4;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getParte1() {
        return parte1;
    }

    public void setParte1(String parte1) {
        this.parte1 = parte1;
    }

    public String getParte2() {
        return parte2;
    }

    public void setParte2(String parte2) {
        this.parte2 = parte2;
    }

    public String getParte3() {
        return parte3;
    }

    public void setParte3(String parte3) {
        this.parte3 = parte3;
    }

    public String getParte4() {
        return parte4;
    }

    public void setParte4(String parte4) {
        this.parte4 = parte4;
    }
}

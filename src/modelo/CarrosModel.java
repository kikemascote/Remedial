package modelo;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class CarrosModel {

    /*FileInputStream serviceAccount =
            new FileInputStream("c:\\\\users\\kike\\downloads\\remedial-progra-firebase-adminsdk-v7e0p-08b263cf73.json");

    FirebaseOptions options = new FirebaseOptions.Builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .setDatabaseUrl("https://remedial-progra.firebaseio.com")
            .build();*/


    String  marca,
            linea,
            modelo,
            descripcion,
            url;
    List<PartesModel> partes;

    /*@Override
    public String toString() {
        return "CarrosModel{" +
                "serviceAccount=" + serviceAccount +
                ", options=" + options +
                ", marca='" + marca + '\'' +
                ", linea='" + linea + '\'' +
                ", modelo='" + modelo + '\'' +
                ", parte1='" + parte1 + '\'' +
                ", parte2='" + parte2 + '\'' +
                ", parte3='" + parte3 + '\'' +
                ", parte4='" + parte4 + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", url='" + url + '\'' +
                '}';
    }*/
/*
    public CarrosModel(FileInputStream serviceAccount, FirebaseOptions options, String marca, String linea, String modelo, String parte1, String parte2, String parte3, String parte4, String descripcion, String url) throws IOException {
        this.serviceAccount = serviceAccount;
        this.options = options;
        this.marca = marca;
        this.linea = linea;
        this.modelo = modelo;
        this.parte1 = parte1;
        this.parte2 = parte2;
        this.parte3 = parte3;
        this.parte4 = parte4;
        this.descripcion = descripcion;
        this.url = url;
    }
*/

//    public FileInputStream getServiceAccount() {
//        return serviceAccount;
//    }

//    public void setServiceAccount(FileInputStream serviceAccount) {
//        this.serviceAccount = serviceAccount;
//    }

//    public FirebaseOptions getOptions() {
//        return options;
//    }

//    public void setOptions(FirebaseOptions options) {
//        this.options = options;
//    }

    public CarrosModel(String marca, String linea, String modelo, List<PartesModel> partes, String descripcion, String url) {
        this.marca = marca;
        this.linea = linea;
        this.modelo = modelo;
        this.partes = partes;
        this.descripcion = descripcion;
        this.url = url;
    }

    public List<PartesModel> getPartes() {
        return partes;
    }

    public void setPartes(List<PartesModel> partes) {
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

//    public CarrosModel() throws IOException {
//        FirebaseApp.initializeApp(options);
//
//
//    }


}

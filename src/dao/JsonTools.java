package dao;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonWriter;
import modelo.UserModel;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class JsonTools {
    static final String USER_DAO = "https://remedial-progra.firebaseio.com/usuarios.json";
    static final String AUTOS_DAO = "https://remedial-progra.firebaseio.com/autos.json";
    private static final String API_KEY = "AIzaSyCzEbhKQdDUiYtM0L_gQjjo9p0QnEsXWhQ";

    public List<UserModel> jsonUserReader() throws IOException {
        try (InputStream inputStream = new URL(USER_DAO).openStream();
             Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {

            Gson gson = new Gson();
            return gson.fromJson(reader, new TypeToken<List<UserModel>>() {
            }.getType());
        }
    }

    public void jsonAutoWriter(String marca, String linea, String modelo, String p1, String p2, String p3, String p4, String descr)
            throws IOException {
        String fileName = "src/resources/cars.json";
        String url = "";
        Path path = Paths.get(fileName);
        switch (marca.toUpperCase()) {
            case "FORD":
                url = "https://firebasestorage.googleapis.com/v0/b/remedial-progra.appspot.com/o/ford-logo.png?alt=media&token=cc1cede4-397b-451f-a3b4-efbbe7f7c352";
                break;
            case "CHEVROLET":
                url = "https://firebasestorage.googleapis.com/v0/b/remedial-progra.appspot.com/o/chevrolet-logo.png?alt=media&token=308e243b-a145-4cf8-a251-8698573fd440";
                break;
            case "SUBARU":
                url = "https://firebasestorage.googleapis.com/v0/b/remedial-progra.appspot.com/o/subaru-logo.png?alt=media&token=d23f4a9e-d6e8-404f-9fa5-f993c103db5f";
                break;
            default:
                url = "no logo";
        }

        try (JsonWriter writer = new JsonWriter(Files.newBufferedWriter(path,
                StandardCharsets.UTF_8))) {

            writer.beginObject();
            writer.name("marca").value(marca.toUpperCase());
            writer.name("linea").value(linea.toUpperCase());
            writer.name("modelo").value(modelo);
            writer.name("descripcion").value(descr);
            writer.name("url").value(url);

          //  writer.name("partes");
          //  writer.beginArray();
            writer.name("parte1").value(p1);
            writer.name("parte2").value(p2);
            writer.name("parte3").value(p3);
            writer.name("parte4").value(p4);
          //  writer.endArray();

            writer.endObject();
        }

        System.out.println("Data written to file");
    }

    /*public List<CarrosModel> jsonAutoReader()
            throws IOException {
        String fileName = "src/resources/cars.json";
        Path path = Paths.get(fileName);
        List<CarrosModel> lista = null;

        try (Reader reader = Files.newBufferedReader(path,
                StandardCharsets.UTF_8)) {

            JsonElement tree = JsonParser.parseReader(reader);
            Gson gson =new Gson();
            lista = gson.fromJson(reader, new TypeToken<List<CarrosModel>>(){}.getType());

           */
    /* JsonArray array = tree.getAsJsonArray();

            //bloque de prueba
            for (JsonElement element : array) {

                if (element.isJsonObject()) {

                    JsonObject car = element.getAsJsonObject();

                    System.out.println("********************");
                    System.out.println(car.get("marca").getAsString());
                    System.out.println(car.get("linea").getAsString());
                    System.out.println(car.get("modelo").getAsInt());

                    JsonArray cols = car.getAsJsonArray("partes");

                    cols.forEach(col -> {
                        System.out.println(col);
                    });
                }
            }
            //fin bloque de prueba*/
    /*

            lista.forEach(System.out::println);
            return lista;

        }

    }*/
    public JsonArray jsonAutoReader() throws IOException {
        try (InputStream inputStream = new URL(AUTOS_DAO).openStream();
             Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {

            JsonParser parser = new JsonParser();
            JsonElement tree = parser.parse(reader);

            JsonArray array = tree.getAsJsonArray();

            return array;
            //Gson gson = new Gson();

            //return gson.fromJson(array., new TypeToken<List<CarrosModel>>() {
            //}.getType());
        }
    }

}

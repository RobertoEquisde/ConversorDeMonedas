import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;

public class LecturaJson {
    public Moneda leerMoneda(String baseCode){
        try{
            FileReader reader = new FileReader(baseCode + ".json");
            return new Gson().fromJson(reader,Moneda.class);
        }catch (IOException e){
            throw new RuntimeException("No se pudo leer el archivo"+ baseCode +".json",e);
        }
    }
}

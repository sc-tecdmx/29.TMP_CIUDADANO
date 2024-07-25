package mx.gob.tecdmx.directorio_ciudadano.utils;

import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Pattern;

import com.google.gson.Gson;

public class MetodosUtils {
	
	public String objectToJson(DTOResponse objeto) {
		Gson gson = new Gson();
		String json = gson.toJson(objeto);
		return json;
	}
	
	public Date formatDate(String fecha) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = formatter.parse(fecha);
            return date;
        } catch (ParseException e) {
            System.out.println("Error parsing the date: " + e.getMessage());
            // Handle the error as necessary
        }
        return null;
	}
	
	public String formatDate(Date fecha) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaUTC = formatter.format(fecha);
        fechaUTC = fechaUTC.replaceAll(":", "");
        return fechaUTC;
	}
	
	public String getrandomNumber() {
		Random random = new Random();
	    int randomNumber = random.nextInt(99) + 1;
	    String formattedNumber = String.format("%02d", randomNumber);
	    return formattedNumber;
	}
	
	public static String quitarAcentos(String texto) {
        // Normalizar el texto
        String textoNormalizado = Normalizer.normalize(texto, Normalizer.Form.NFD);

        // Eliminar los caracteres diacríticos usando una expresión regular
        Pattern patron = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return patron.matcher(textoNormalizado).replaceAll("");
    }
	
	public String createRandomUserName(String nombre, String apellido) {
		String nombreUsuario = 
				quitarAcentos(nombre.toLowerCase())+"."+
				quitarAcentos(apellido.toLowerCase())+"."+
				getrandomNumber();
		
		return nombreUsuario;
	}
	
	

}

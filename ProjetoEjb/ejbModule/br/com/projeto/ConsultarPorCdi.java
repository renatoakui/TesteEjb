package br.com.projeto;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



public class ConsultarPorCdi {

	private static final Object NULL = null;


	public String displayBean() {
		String aux = "Hello i am using cdi";
		criarJson();
		JSONWrite();
		JSONReader();
		return aux;
	}

	public void JSONWrite() {
		JSONObject jsonObject = new JSONObject();

		FileWriter writeFile = null;

		// Armazena dados em um Objeto JSON
		jsonObject.put("nome", "Allan1");
		jsonObject.put("sobrenome", "Romanato");
		jsonObject.put("pais", "Brasil");
		jsonObject.put("estado", "SP");

		try {
			writeFile = new FileWriter("C:\\Renato\\arquivo\\saida.json");
			// Escreve no arquivo conteudo do Objeto JSON
			writeFile.write(jsonObject.toString());
			writeFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Imprimne na Tela o Objeto JSON para vizualização
		System.out.println(jsonObject);

	}

	public void JSONReader() {

		JSONObject jsonObject;
		// Cria o parse de tratamento
		JSONParser parser = new JSONParser();
		// Variaveis que irao armazenar os dados do arquivo JSON
		String nome;
		String sobrenome;
		String estado;
		String pais;

		try {
			// Salva no objeto JSONObject o que o parse tratou do arquivo
//			parser.parse(new FileReader("C:\\Renato\\arquivo\\saida.json"));
			jsonObject = (JSONObject) parser.parse(new FileReader("C:\\Renato\\arquivo\\saida.json"));

			// Salva nas variaveis os dados retirados do arquivo
			nome = (String) jsonObject.get("nome");
			sobrenome = (String) jsonObject.get("sobrenome");
			estado = (String) jsonObject.get("estado");
			pais = (String) jsonObject.get("pais");

			System.out.printf("Nome: %s\nSobrenome: %s\nEstado: %s\nPais: %s\n", nome, sobrenome, estado, pais);
		}
		// Trata as exceptions que podem ser lançadas no decorrer do processo
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (org.json.simple.parser.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void criarJson() {

		Map<String, Object> tom = new HashMap<String, Object>();

		tom.put("name", "Tom");
		tom.put("birthday", "1940-02-10");
		tom.put("age", 76);
		tom.put("married", false);

		tom.put("car", NULL);
		tom.put("favorite_foods", new String[] { "cookie", "fish", "chips" });

		Map<String, Object> passport = new HashMap<String, Object>();
		passport.put("id", 100001);
		passport.put("nationality", "American");
		tom.put("passport", passport);

		// Create JSON object from Java Map
		JSONObject tomJsonObj = new JSONObject(tom);

		boolean prettyPrint = true;
		if (prettyPrint) {
			// With 4 indent spaces
			System.out.println(tomJsonObj.toString());

			System.out.println("");
			System.out.println();
		} else {
			System.out.println(tomJsonObj.toString());
		}

	}

}

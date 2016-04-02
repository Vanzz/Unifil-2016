package edu.unifil.javaconnection.misc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonSimpleExample {
     public static void main(String[] args) {

	JSONParser parser = new JSONParser();

	try {

		Object obj = parser.parse(new FileReader("config/config.json"));

		JSONObject jsonObject = (JSONObject) obj;

		String username = (String) jsonObject.get("username");
		System.out.println(username);

		String password = (String) jsonObject.get("password");
		System.out.println(password);
                
                String url = (String) jsonObject.get("url");
		System.out.println(url);

		String database = (String) jsonObject.get("database");
		System.out.println(database);
                
                String port = (String) jsonObject.get("port");
		System.out.println(port);
//"jdbc:mysql://url:porta/database, username, password"
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} catch (ParseException e) {
		e.printStackTrace();
	}

     }

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unifil.javaconnection.misc;

import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


/**
 *
 * @author mhadaniya
 */
public class ReadJSONConfig {
    
    public String[] getConfig() throws Exception{
        JSONParser parser = new JSONParser();
        String[] configuracoes = new String[3];

        Object obj = parser.parse(new FileReader("config/config.json"));

        JSONObject jsonObject = (JSONObject) obj;

        configuracoes[0] = (String) jsonObject.get("password");
        configuracoes[1] = (String) jsonObject.get("username");        
        configuracoes[2] = "jdbc:mysql://" + 
                            (String) jsonObject.get("url") + ":" +
                            (String) jsonObject.get("port") + "/" +
                            (String) jsonObject.get("database");

        return configuracoes;
    }
}

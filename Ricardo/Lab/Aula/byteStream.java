import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;

import java.io.BufferedReader;
import java.io.BufferedWriter;

/**
 * Escreva a descrição da classe byteStream aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class byteStream 
{
    /**
     * Construtor para objetos da classe byteStream
     */
    public static void byteStream()
    {
        BufferedReader in = null;
        BufferedWriter out = null;
        
        try {
            in = new BufferedReader(new FileReader("arquivo.txt"));
            out = new BufferedWriter(new FileWriter("clone.txt"));
            
            String lido = in.readLine();
            while (lido != null){
                System.out.println(lido);
                lido = in.readLine();
            }
        } catch (IOException e){
            System.out.println(e.toString());
        }finally {
            System.out.println("Passei pelo finally!");
        }
        
        try {
            if(in != null) {
                in.close();
            }
            if(out != null) {
                out.close();
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}

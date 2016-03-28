//import java.jesus.mesalva;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException; 

/**
 * Write a description of class Calculadora here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Calculadora
{
    public static int calcular(String nomeArq) {
        BufferedReader in = null;
        BufferedWriter out = null;
        int guardamem = 0;
        int acumulador = 0;
        int resultado = 0;
        try {
            in = new BufferedReader(new FileReader(nomeArq));
            int x,y;

            String lido = in.readLine();
            System.out.println("lidoprimeiro ->"+lido);            
            while (lido != null){
                String[] dados = lido.split(" ");
                switch (dados[0]) {
                    case "sub":
                        acumulador -= Integer.parseInt(dados[1]);
                        System.out.println("sub -> "+acumulador);
                        resultado = acumulador;
                        break;
                    case "soma":
                        acumulador += Integer.parseInt(dados[1]);
                        System.out.println("soma -> "+acumulador);
                        resultado = acumulador;                        
                        break;
                    case "somamem":
                        guardamem += acumulador;
                        System.out.println("somamem -> "+guardamem);    
                        resultado = guardamem;
                        break;
                    case "submem":
                        guardamem -= acumulador;
                        System.out.println("submem -> "+guardamem);
                        resultado = guardamem;                    
                        break;
                    case "guardamem":
                        guardamem = acumulador;
                        System.out.println("guardamem -> "+guardamem);
                        acumulador = 0;
                        resultado = guardamem;                        
                        break;
                    default:
                        break;
                }
                lido = in.readLine();
                System.out.println("lido ->"+lido);
            }
        } catch (IOException e){
            System.out.println(e.toString());
        }finally {

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

        return resultado;
    }
}

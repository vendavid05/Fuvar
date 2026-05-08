
package Main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Fuvarok {

        static List<Fuvar> fuvarok = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        
        Path path = Path.of("fuvarok_100.csv");
        
        String egySor = Files.readString(path);
        
        System.out.println("egySor= " + egySor);
        
        List<String> sorok = Files.readAllLines(path);
        for(int i = 0; i < sorok.size();i++){
            String[] s = sorok.get(i).split(";");
                
            String rsz = s[0];
            int ido = Integer.parseInt(s[1]);
            double osszeg = Integer.parseInt(s[2]);
            String mod = s[3];
            Fuvar fuvar = new Fuvar (rsz,ido,osszeg,mod);
            fuvarok.add(fuvar);
        }
        
    }
    
    private static void osszErtek(){
        final int N = fuvarok.size();
        int i = 0;
        double osszErtek= 0;
        
        while(i < N ){
            osszErtek += fuvarok.get(i).getOsszeg();
        i++;
        }
        System.out.println(osszErtek);
    }
}

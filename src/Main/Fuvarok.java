
package Main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Fuvarok {

        static List<Fuvar> fuvarok = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        
        Path path = Path.of("fuvarok_100.csv");
        
        String egySor = Files.readString(path);
        
        System.out.println("egySor= " + egySor);
        
        List<String> sorok = Files.readAllLines(path);
        for(int i = 1; i < sorok.size();i++){
            String[] s = sorok.get(i).split(";");
                
            String rsz = s[0];
            int ido = Integer.parseInt(s[1]);
            double osszeg = Double.parseDouble(s[2]);
            String mod = s[3];
            Fuvar fuvar = new Fuvar (rsz,ido,osszeg,mod);
            fuvarok.add(fuvar);
        }
        osszesErtek();
        LegdragabbFuvarRendszama();
        legolcsobbFuvar();
        kartyasFizetesek();
        mindenFizetesMeghatarozott();
        hanyDarabAutoARendszerbe();
        hanyDarabFizetesiMod();
    }
    
    private static void osszesErtek(){
        System.out.println("Első feladat:");
        final int N = fuvarok.size();
        int i = 1;
        double osszErtek= 0;
        
        while(i < N ){
            osszErtek += fuvarok.get(i).getOsszeg();
        i++;
        }
        System.out.println("a fuvarok osszes erteke:" + osszErtek);
        
    }
    
    private static void LegdragabbFuvarRendszama(){
        System.out.println("Második feladat:");
        final int N = fuvarok.size();
        Fuvar legdragabb = fuvarok.get(0);
        for(int i = 1; i < N; i++){
            if(fuvarok.get(i).getOsszeg()< legdragabb.getOsszeg()){
                legdragabb=fuvarok.get(i);
            }
            
            
        }
        System.out.println("a legdrágább fuvaros rendszáma:" + legdragabb.getRendszam());
    }
    private static void legolcsobbFuvar(){
        System.out.println("Harmadik feladat:");
        final int N = fuvarok.size();
        Fuvar legolcsobb = fuvarok.get(0);
        for(int i = 1; i < N; i++){
            if(legolcsobb.getOsszeg() > fuvarok.get(i).getOsszeg()){
            legolcsobb = fuvarok.get(i);   
        }
    }
    
        System.out.println("a legolcsobb fuvar forintba: "+ legolcsobb.getOsszeg()*360+ "forint" );
    }
    private static void kartyasFizetesek(){
        System.out.println("negyedik feladat:");
        int kartyasFizetes = 0;
        final int N = fuvarok.size();
        for(int i = 1; i < N; i++){
            if(fuvarok.get(i).getFizetesiMod().equals("Kártya")){
                kartyasFizetes += 1;
            }
        }
        System.out.println("a kártyás fizetések száma:" + kartyasFizetes);
    }
    private static void mindenFizetesMeghatarozott(){
        System.out.println("ötödik feladat:");
        
        final int N = fuvarok.size();
        for(int i = 0; N>i;i++){
            if(fuvarok.get(i).getFizetesiMod().equals("-")){
                System.out.println("Nem minden fizetési mód meghatározott");
                break;
            
            }else{
                System.out.println("minden fizetési mód meghatározott");
            }
        }
    }
    private static void hanyDarabAutoARendszerbe(){
        System.out.println("hatodik feladat: ");
        HashSet<String> Autok = new HashSet<>();
        
        for (Fuvar fuvar : fuvarok) {
            Autok.add(fuvar.getRendszam());
        }
        System.out.println("Egyedi Autok száma:" + Autok.size());
    }
     private static void hanyDarabFizetesiMod(){
        System.out.println("Hetedik feladat:");
        HashSet<String> Fizetesek = new HashSet<>();

        for (int i = 0; i < fuvarok.size(); i++) {
            Fizetesek.add(fuvarok.get(i).getFizetesiMod());
        }
         System.out.println("Fizetesi módok száma:"+ Fizetesek.size());
    }
    
}
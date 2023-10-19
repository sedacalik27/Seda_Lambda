package Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambda02 {


    public static void main(String[] args) {

        List<String> meyve = new ArrayList<>(Arrays.asList("elma","portakal","uzum","cilek","greyfurt","nar",
                "mandalina","armut","elma","keciboynuzu","elma"));

        ilkHarfeVeyac(meyve);//elma cilek elma elma
        System.out.println("\n********");

        basinaVeSonunaYildiz(meyve);//*elma* *portakal* *uzum* *cilek* *greyfurt* *nar* *mandalina* *armut* *elma* *keciboynuzu* *elma*
        System.out.println("\n********");

        icindeeHarfiOlanlar(meyve);//elma cilek greyfurt elma keciboynuzu elma
        System.out.println("\n********");

        lHarfiniSil(meyve);//ema portaka uzum ciek greyfurt nar mandaina armut ema keciboynuzu ema
        System.out.println("\n********");

        karakterSayisinaGoreKucBuylambdaEx(meyve);//nar elma uzum elma elma cilek armut portakal greyfurt mandalina keciboynuzu
        System.out.println("\n********");

        karakterSayisinaGoreBuyKucLambdaEx(meyve);//keciboynuzu mandalina portakal greyfurt cilek armut elma uzum elma elma nar
        System.out.println("\n********");

        karakterSayisinaGoreBuyKucMethodRef(meyve);//keciboynuzu mandalina portakal greyfurt cilek armut elma uzum elma elma nar
        System.out.println("\n********");







    }

    // SORU1 : List elemanlarının ilk harfi 'e' veya 'c' olanlari,
    // Method References ile aralarında bosluk bırakarak yazdıralım

    public static void ilkHarfeVeyac(List<String> meyve){
        meyve.stream().filter(t->t.startsWith("e")|| t.startsWith("c")).forEach(Utils::yazdir);
    }


    // SORU2 : List elemanlarının hepsinin basina ve sonuna yildiz ekleyerek yazdiralim

    public static void basinaVeSonunaYildiz(List<String> meyve){
        meyve.stream().map(t->"*" +t +"*").forEach(Utils::yazdir);
    }


    // SORU3 : List elemanlarının icinde 'e' harfi olanları yazdırın

    public static void icindeeHarfiOlanlar(List<String> meyve){

        meyve.stream().filter(t->t.contains("e")).forEach(Utils::yazdir);

    }


    // SORU4 : List elemanlarındaki 'l' harflerini silip yazdırınız

    public static void lHarfiniSil(List<String> meyve){
        meyve.stream().map(t->t.replace("l","")).forEach(Utils::yazdir);
    }
    // SORU5 : List elemanlarini, Lambda Expression kullanarak
    // karakter sayisina göre kucukten buyuge dogru sıralayarak yazdırınız

    public static void karakterSayisinaGoreKucBuylambdaEx(List<String> meyve){
        meyve.stream().sorted(Comparator.comparing(t->t.length())).forEach(Utils::yazdir);
        //comparator comparing demek neye göre sıralayalım onu buluyoz
    }


    // SORU5.1 : List elemanlarini, Lambda Expression kullanarak
    // karakter sayisina göre buyuge kucuge dogru sıralayarak yazdırınız

    public static void karakterSayisinaGoreBuyKucLambdaEx(List<String > meyve){

        meyve.stream().sorted(Comparator.comparing(t->t.toString().length()).reversed()).forEach(Utils::yazdir);
        //burda to string kullanmamızın sebebi java length kırmızı yaptı çünkü ya hiç karakter gelmezse bana diye
    }

    // SORU6 : List elemanlarini, Method References kullanarak
    // karakter sayisina göre buyukten kucuge dogru sıralayarak yazdırınız

    public static void karakterSayisinaGoreBuyKucMethodRef(List<String> meyve){
        meyve.stream().sorted(Comparator.comparing(String::length).reversed()).forEach(Utils::yazdir);
    }


}

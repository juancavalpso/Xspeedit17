package com.hello.koding;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        return "hello";
    }

    /**
     * Ejemplo : http://localhost:8080/test/163841689525773
     *
     * @param n
     * @return
     */
    @RequestMapping("/test/{n}")
    public String test(@PathVariable long n){

        /* Separamos cadena de manera recursiva */
        String[] arr = separa(n, "").split("") ;
        /* convertimos la cadena a int */
        int[] numeros = new int[arr.length];
        for (int i=0; i< arr.length; i++){
            numeros[i]=Integer.valueOf(arr[i]);
        }

        String total = embalajeSumaColinActuel(numeros,0,numeros.length-1, 0, "");

        return total;
    }

    /**
     * Chaîne d'articles emballés : 163841689525773
     * Robot actuel
     * Ex: 10 cartons utilisés
     *
     * @param a
     * @param actual
     * @param fin
     * @param suma
     * @param tot
     * @return
     */
    protected String embalajeSumaColinActuel(int[] a,int actual, int fin, int suma, String tot){
        if(actual<=fin) {
            if(suma+a[actual]<=10){
                suma += a[actual];
                tot  += a[actual];
            }else{
                tot = tot + "/";
                tot += a[actual];
                suma = a[actual];
            }
            return embalajeSumaColinActuel(a, actual + 1, fin, suma, tot);
        }
        return tot;
    }

    /**
     *
     * @param a
     * @param actual
     * @param fin
     * @param suma
     * @param tot
     * @return
     */
    protected String embalajeSumaColinOptimise(int[] a,int actual, int fin, int suma, String tot){
        if(actual<=fin) {
            if(suma+a[actual]==10){
                suma += a[actual];
                tot  += a[actual];
            }else{
                tot = tot + "/";
                tot += a[actual];
                suma = a[actual];
            }
            return embalajeSumaColinOptimise(a, actual + 1, fin, suma, tot);
        }
        return tot;
    }

    private int[] vector;

    public void leerVector(int pos){
        if (pos == vector.length-1) {
            System.out.println("Elemento en posición "+pos + " es "+vector[pos]);
        } else {
            System.out.println("Elemento en posición "+pos + " es "+vector[pos]);
            leerVector(pos+1);
        }
    }

    /**
     *
     * @param n
     * @param r
     * @return
     */
    protected String separa(long n, String r){
        if( n < 10 )
            return r;
        else if ( n/10 >= 1000 && r.equals(""))
            return separa(n, ""+n%10);
        else
            return separa(n/10, ""+(((n/10))%10) + r );
    }

}
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

        //double i = sumOfArray(numeros,numeros.length-1);
        String total = sumOfArray(numeros,0,numeros.length-1, 0, "");

        return total;
    }


    public String sumOfArray(int[] a,int actual, int fin, int suma, String tot) {
        if (actual < fin) {
            if (suma <= 10) {
                suma = a[actual] + a[actual + 1];
                if(suma<=10){
                    tot = tot + a[actual];
                    return sumOfArray(a, actual + 1, fin, suma, tot);
                }else {
                    tot = tot + a[actual]+"/";
                    return sumOfArray(a, actual + 1, fin, suma, tot);
                }
            } else {
                if(a[actual]+ a[actual + 1] >= 10)
                    tot = tot + a[actual]+"/";
                else{
                    tot = tot + "/";
                }



                return sumOfArray(a, actual + 1, fin, 0, tot);
            }
        }

        tot = tot + a[actual];
        return tot;
    }


    public String sumOfArray2(int[] a,int actual, int fin, int suma, String tot) {
        if(actual<fin) {
            suma = a[actual] + a[actual + 1];
            tot = tot + a[actual];
            if (suma <= 10)
                return sumOfArray2(a, actual + 1, fin, suma, tot);
            else {
                tot = tot + "/";
                return sumOfArray2(a, actual + 1, fin, 0, tot);
            }
        }
        tot = tot + a[actual];
        return tot;
    }

    protected static String separa(long n, String r){
        if( n < 10 )
            return r;
        else if ( n/10 >= 1000 && r.equals(""))
            return separa(n, ""+n%10);
        else
            return separa(n/10, ""+(((n/10))%10) + r );
    }

    protected static long sumaDigitos(long num){
        if(num==0){
            return 0;
        } else {



            return sumaDigitos(num/10) + num%10;
        }
    }
}
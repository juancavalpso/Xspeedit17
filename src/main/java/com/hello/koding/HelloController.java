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
    public int[] test(@PathVariable long n){

        /* Separamos cadena de manera recursiva */
        String[] arr = separa(n, "").split("") ;
        /* convertimos la cadena a int */
        int[] numeros = new int[arr.length];
        for (int i=0; i< arr.length; i++){
            numeros[i]=Integer.valueOf(arr[i]);
        }

        double i = sumOfArray(numeros,numeros.length-1);

        return numeros;
    }

    public double sumOfArray(int[] a, int n) {
        if (n == 0)
            return a[n];
        else
            return a[n] + sumOfArray(a, n-1);
    }

    private static String separa(long n, String r){
        if( n < 10 )
            return r;
        else if ( n/10 >= 1000 && r.equals(""))
            return separa(n, ""+n%10);
        else
            return separa(n/10, ""+(((n/10))%10) + r );
    }


}
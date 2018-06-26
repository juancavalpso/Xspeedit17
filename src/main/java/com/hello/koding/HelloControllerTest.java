package com.hello.koding;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HelloControllerTest {

    private HelloController helloController;

    @Before
    public void init() {
        helloController = new HelloController();
    }


    @Test
    public void embalaje_test(){
        Long articles = 163841689525773L;
        /* Separamos cadena de manera recursiva */
        String[] arr = helloController.separa(articles, "").split("") ;
        /* convertimos la cadena a int */
        int[] numeros = new int[arr.length];
        for (int i=0; i< arr.length; i++){
            numeros[i]=Integer.valueOf(arr[i]);
        }

        String resultado = helloController.embalajeSumaColinActuel(numeros,0,numeros.length-1, 0, "");

        Assert.assertEquals("163/8/41/6/8/9/52/5/7/73",resultado);
    }


}

package com.hello.koding;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HelloControllerTest {

    private HelloController helloController;

    @Before
    public void init() {
        helloController = new HelloController();
    }

    private int[] getArticles() {

        Long articles = 163841689525773L;

        /* Separamos cadena de manera recursiva */
        String[] arr = helloController.separa(articles, "").split("") ;

        /* convertimos la cadena a int */
        int[] numeros = new int[arr.length];
        for (int i=0; i< arr.length; i++){
            numeros[i]=Integer.valueOf(arr[i]);
        }
        return numeros;
    }

    @Test
    public void embalaje_test(){

        int[] numeros = getArticles();

        String resultado = helloController.embalajeSumaColinActuel(numeros,0, 0, "");

        Assert.assertEquals("163/8/41/6/8/9/52/5/7/73",resultado);
    }


    @Test
    public void embalaje_test_optimo(){

        Long articles = 163841689525773L;

        /* Separamos cadena de manera recursiva */
        String[] arr = helloController.separa(articles, "").split("") ;
        ArrayList<Integer> listArticles = new ArrayList<Integer>();
        for (int i=0; i< arr.length; i++){
            listArticles.add(Integer.valueOf(arr[i]));
        }

        String resultado = helloController.embalajeSumaColinOptimise(listArticles,0,0,"");


    }


}

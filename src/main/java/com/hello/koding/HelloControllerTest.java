package com.hello.koding;


import org.jboss.arquillian.core.api.annotation.Inject;
import org.jboss.arquillian.test.spi.enricher.resource.ResourceProvider;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class HelloControllerTest {

@ResourceProvider.ClassInjection
    private HelloController helloController;


    @Test
    public void test01(){

        // Chaîne d'articles en entrée
        Long articles = 163841689525773L;

        // Chaîne d'articles emballés
        String resultado = new HelloController().test(articles);

        // Robot Actuel
        Assert.assertEquals("163/8/41/6/8/9/52/5/7/73",resultado);


    }

}

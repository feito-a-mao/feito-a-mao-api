package br.com.feitoamaoapi.application;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import br.com.feitoamaoapi.FeitoAMaoApiApplication;

public class ApplicationTest {


    @Test
    public void testMain() {
        FeitoAMaoApiApplication app = new FeitoAMaoApiApplication();
        Assert.assertNotNull(app);
    }



}
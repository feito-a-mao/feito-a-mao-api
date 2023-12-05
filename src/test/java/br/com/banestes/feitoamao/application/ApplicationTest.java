package br.com.banestes.feitoamao.application;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import br.com.banestes.feitoamaoapi.FeitoAMaoApiApplication;

public class ApplicationTest {


    @Test
    public void testMain() {
        FeitoAMaoApiApplication app = new FeitoAMaoApiApplication();
        Assert.assertNotNull(app);
    }



}
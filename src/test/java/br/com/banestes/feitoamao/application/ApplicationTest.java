package br.com.banestes.feitoamao.application;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import br.com.banestes.feitoamaoapi.FeitoAmaoApiApplication;

public class ApplicationTest {


    @Test
    public void testMain() {
        FeitoAmaoApiApplication app = new FeitoAmaoApiApplication();
        Assert.assertNotNull(app);
    }



}
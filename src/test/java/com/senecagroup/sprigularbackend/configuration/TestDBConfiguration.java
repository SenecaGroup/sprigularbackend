package com.senecagroup.sprigularbackend.configuration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDBConfiguration {

    @Autowired
    ApplicationContext c;

    @Test
    public void dataSource() {
        assertNotNull(c.getBean(DataSource.class));
    }

}

package com.senecagroup.sprigularbackend.dev;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

/**
 * Created by sm123tt@gmail.com on 2018-09-08
 * Project: sprigularbackend
 * Github : http://github.com/Siwoo-Kim
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestFixtureFactory {

    @Autowired
    FixtureFactory fixtureFactory;

    @Test
    public void testFixtureModels() {
        assertNotNull(fixtureFactory.fixtureModels());
        fixtureFactory.fixtureModels().forEach(System.out::println);
    }
}

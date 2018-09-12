package com.senecagroup.sprigularbackend.domain;

import org.junit.Test;

/**
 * Created by sm123tt@gmail.com on 2018-09-12
 * Project: sprigularbackend
 * Github : http://github.com/Siwoo-Kim
 */

public class TestImage {

    @Test
    public void testGetImgPath() {
        Image image = new Image();
        image.setName("test");
        image.setImageType(Image.ImageType.JPEG);
        System.out.println(image.getImgPath());
    }
}

package com.senecagroup.sprigularbackend.resources;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by sm123tt@gmail.com on 2018-09-12
 * Project: sprigularbackend
 * Github : http://github.com/Siwoo-Kim
 */

public class WebResourceUtils {

    @Value("${frontend.path.img}")
    String ImagePath;


}

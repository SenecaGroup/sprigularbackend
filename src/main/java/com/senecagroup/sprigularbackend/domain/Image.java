package com.senecagroup.sprigularbackend.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.lang.ref.PhantomReference;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by sm123tt@gmail.com on 2018-09-12
 * Project: sprigularbackend
 * Github : http://github.com/Siwoo-Kim
 */
@Entity
@Getter @Setter @ToString
public class Image {
    private static final Path IMG_PATH = Paths.get("./src/resources/static/image/static/image/");

    public enum ImageType {
        SVG(".svg"), PNG(".png"), JPG(".jpg"), JPEG(".jpeg");
        String value;

        ImageType(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    private ImageType imageType;

    public String getImgPath() {
        return IMG_PATH + name +  imageType.getValue();
    }

}

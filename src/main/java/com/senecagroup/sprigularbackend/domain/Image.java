package com.senecagroup.sprigularbackend.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by sm123tt@gmail.com on 2018-09-12
 * Project: sprigularbackend
 * Github : http://github.com/Siwoo-Kim
 */
@Entity
@Getter @Setter @ToString
@DiscriminatorValue("IMG")
public class Image extends Paragraph {

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

    @NotNull
    private String location;

    @Transient
    private ImageType imageType;

}

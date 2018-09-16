package com.senecagroup.sprigularbackend.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by sm123tt@gmail.com on 2018-09-16
 * Project: sprigularbackend
 * Github : http://github.com/Siwoo-Kim
 */

@Entity
@DiscriminatorValue("CODE")
public class Code extends Paragraph {


}

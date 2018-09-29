package com.senecagroup.sprigularbackend.learning;


import org.springframework.data.jpa.repository.Query;

import java.io.*;
import java.util.Scanner;

/**
 * Created by bobsang89@gmail.com on 2018-09-29
 * Project: sprigularbackend
 * Github : http://github.com/SangJun-GitHub
 */
public class FileReader {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

        BufferedReader dump = new BufferedReader(new InputStreamReader(new FileInputStream("./dump.txt"), "UTF-8"));
        Scanner scan = new Scanner(dump);
        while (scan.hasNextLine()) {
            StringBuilder sb = new StringBuilder(scan.nextLine());
            System.out.println(sb);
        }
    }
}


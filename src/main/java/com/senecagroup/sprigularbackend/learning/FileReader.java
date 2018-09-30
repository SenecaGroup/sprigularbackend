package com.senecagroup.sprigularbackend.learning;

import java.io.*;
import java.util.Scanner;

/**
 * Created by bobsang89@gmail.com on 2018-09-29
 * Project: sprigularbackend
 * Github : http://github.com/SangJun-GitHub
 */
public class FileReader {


    public static void main(String[] args) throws IOException {
        BufferedReader dump = new BufferedReader(new InputStreamReader(new FileInputStream("./dump.txt"), "UTF-8"));
        Scanner scan = new Scanner(dump);
        StringBuilder sb = new StringBuilder();
        while (scan.hasNextLine()) {
            sb.append(scan.nextLine());
        }
        System.out.println(sb);
    }
}




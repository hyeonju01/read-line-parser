package com.line;

import com.line.domain.Patient;
import com.line.parser.Parser;

import javax.sound.sampled.Line;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LineReader<T> {

    Parser<T> parser;
    boolean isRemoveColumnName = true;

    public LineReader(Parser<T> parser) {
        this.parser = parser;
    }

    public LineReader(Parser<T> parser, boolean isRemoveColumnName) {
        this.parser = parser;
        this.isRemoveColumnName = isRemoveColumnName;
    }

    List<T> readLines(String filename) throws IOException {
        List<T> result = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String str;
        if (isRemoveColumnName){
            br.readLine();
        }
        while ((str = br.readLine()) != null){
            result.add(parser.parse(str));
        }
        return result;
    }


    //createAFile
    public void createANewFile(String filename) throws IOException {
        File file = new File(filename);
        file.createNewFile();
        System.out.println("파일 생성 되었나?: " + file.exists());
    }

    //write code



}
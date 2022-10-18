package com.line;

import com.line.parser.Parser;

import java.io.*;
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

    public void writeLines(List<String> lines, String filename){
        File file = new File(filename);
        try{
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(file), "utf-8"));
            for (String str : lines){
                bw.write(str);
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //createAFile
    public void createANewFile(String filename) throws IOException {
        File file = new File(filename);
        file.createNewFile();
        System.out.println("파일 생성 되었나?: " + file.exists());
    }

    //write code




}
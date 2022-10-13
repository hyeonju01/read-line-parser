package com.line.parser;

import com.line.domain.Hospital;

public class HospitalParser implements Parser<Hospital> {

    private String getSubdivision(String name) {

        String[] subdivisions = {"소아과", "피부과", "성형외과", "정형외과", "산부인과", "관절", "안과", "가정의학과", "비뇨기과", "치과"};

        for (String subdivision : subdivisions) { //for-each문 사용
            if (name.contains(subdivision)) {
                return subdivision;
            }
        }
        return ""; //subdivisions 내에 분과 명이 없을 경우 빈 문자열 리턴.
    }

    private String replaceAllQuot(String str){
        return str.replaceAll("\"", "");
    }

    @Override
    public Hospital parse(String str) {
        str = replaceAllQuot(str);
        String[] splitted = str.split(",");
        String name = splitted[10]; //추가
        String subdivision = getSubdivision(name); //추가

        //subdivision은 파싱 로직에 넣어보도록 한다.
        return new Hospital(splitted[0], splitted[1], splitted[2], Integer.parseInt(splitted[6]), name, subdivision);
    }
}
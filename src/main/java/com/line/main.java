package com.line;

import com.line.domain.Hospital;
import com.line.parser.HospitalParser;


import javax.sound.sampled.Line;
import java.io.IOException;
import java.util.List;

public class main {
    public static void main(String[] args) throws IOException {
        LineReader<Hospital> hospitalLineReader = new LineReader<>(new HospitalParser());
        String filename= "/Users/hyeonju/Downloads/seoul_hospitals_infos.csv";
        List<Hospital> hospitals = hospitalLineReader.readLines(filename);

        System.out.println(hospitals.size());

        for(Hospital hospital : hospitals) {
            //System.out.println(hospital.getId());
            System.out.printf("%s,%s,%s,%s,%d,%s,%s\n",
                    hospital.getId(), hospital.getAddress(), hospital.getDistrict(),
                    hospital.getCategory(),hospital.getEmergencyRoom(),hospital.getName(),
                    hospital.getSubdivision()); //반드시 개행 문자 추가..^^
        }


    }
}

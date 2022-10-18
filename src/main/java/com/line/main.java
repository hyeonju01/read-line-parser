package com.line;

import com.line.domain.Hospital;
import com.line.parser.HospitalParser;


import javax.sound.sampled.Line;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) throws IOException {
        LineReader<Hospital> hospitalLineReader = new LineReader<>(new HospitalParser());
        String filename= "/Users/hyeonju/Downloads/seoul_hospitals_infos.csv";
        List<Hospital> hospitals = hospitalLineReader.readLines(filename);

        List<String> sqlStatements = new ArrayList<>();

        for(Hospital hospital : hospitals) {
            sqlStatements.add(hospital.getSqlInsertQuery());
        }

        String sqlFilename =  "seoul_hospital_insert.sql";
        hospitalLineReader.createANewFile(sqlFilename);
        hospitalLineReader.writeLines(sqlStatements, sqlFilename);

    }
}

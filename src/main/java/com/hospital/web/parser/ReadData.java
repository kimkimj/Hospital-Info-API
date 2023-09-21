package com.hospital.web.parser;

import com.hospital.web.domain.entity.Hospital;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ReadData {
    public List<Hospital> readLine(String filename) throws IOException {

        // txt file을 읽어온다
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "utf-8"));

        List<Hospital> hospitals = new ArrayList<>();

        // 파일을 첫행인 스키마를 입력받아 제거한다
        br.readLine();

        // parser를 가져온다
        HospitalParser hospitalParser = new HospitalParser();

        String str;

        // 데이터를 한줄씩 읽어 HospitalParser로 보내고, HP가 데이터를 처리해 반환해 준다
        while ((str = br.readLine()) != null) {
            try {
                Hospital hospital = hospitalParser.parse(str);
                hospitals.add(hospital);
            } catch (Exception e) {
                System.out.println(str.substring(0, 10) + "는 데이터 오류가 있습니다");
            }
        }
        return hospitals;
    }
}

package com.hospital.web.parser;

import com.hospital.web.domain.entity.Hospital;

public class HospitalParser {
    public Hospital parse(String str) {
        // 한줄씩 tab으로 구분해 나눈다
        String[] row = str.split("\t");

        //개방 서비스명 (의원 혹은 병원)
        String openServiceName = row[1];

        //영업상태 구분 (1: 영업/정상  || 2: 휴업 || 3: 폐업 || 4: 취소/말소/만료/정지/중지)
        Integer businessStatusCode = Integer.parseInt(row[7]);

        //소재지 전화
        String phoneNumber = row[15];

        //도로명 주소
        String roadNameAddress = row[19].replaceAll("\"", "");

        //사업장명
        String hospitalName = row[21];

        String businessTypeName = row[25];

        //병상 수
        Integer totalNumberOfBeds = 0;

        //입원실 수
        Integer patientRoomCount = 0;

        //진료과목
        String medicalDepartment = null;


        if (row.length >= 30) {
            if (!row[30].equals(""))
                patientRoomCount = Integer.parseInt(row[30]);
        }
        if (row.length >= 31) {
            if (!row[31].equals(""))
                totalNumberOfBeds = Integer.parseInt(row[31]);
        }

        if (row.length >= 34) {
            if (!row[34].equals("")) {
                medicalDepartment = row[34].replaceAll("\"", "");
            }
        }

        //가져온 값들을 Hospital 객체에 넣는다
        Hospital hospital = new Hospital(
                 roadNameAddress, hospitalName, phoneNumber, patientRoomCount,
                 totalNumberOfBeds, businessTypeName, businessStatusCode,
                 medicalDepartment);

        return hospital;
    }
}

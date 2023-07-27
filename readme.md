# 전국 병/의원 정보 사이트

## 개발 환경 및 배포 주소 
Java 11 · Spring Boot 2.7.5 · Spring Security · Jdbc · JPA · MySQL 8.0 · AWS EC2 · Docker
배포 주소: 

## 데이터 출처
https://www.localdata.go.kr/devcenter/dataDown.do?menuNo=20001

## Endpoints
병원 전체 목록 조회  
GET /list

병원 단건 조회
GET /{hospitalId}

주소로 병원 검색
GET /search 

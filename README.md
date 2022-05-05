# Vue.js, Spring Boot,PostgreSql, ToastUiGrid 를 이용한 게시판 리스트 출력 및 입력 검색 구현하기

![녹화_2022_04_07_14_23_10_960](https://user-images.githubusercontent.com/90013740/162126455-c273579f-714f-4731-aae4-17d616994301.gif)



구현하면서 어려웠던점 : table로 출력하는게 아닌 Gird로 출력시 검색 작업 완료 후에 백에서 넘어오는 데이터가 리스트에 반영이 되지않았음.Vue를 이용하면서 created , mounted 등 개념 자체가 많이 부족해 값 전환이 이루어 지지않음 .


문제 해결 : grid 를 이용해 데이터를 불러오는 시기 (created/mounted) 와 그 데이터 Dom 에 직접 접근해 어떻게 동작을할지 많은 공부가되었음

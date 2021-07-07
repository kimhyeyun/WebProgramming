
# 2차 프로젝트

## TO-DO LIST 구현

### 📋 웹 프론트엔드 기술 요구사항

- 총 2개의 화면이 존재
  - 할 일 목록 화면 (리스트)
  - 할 일 등록 화면 (쓰기)
- CSS는 기획서와 동일한 수준으로 만들어야 함
- 따라서 HTML 엘리먼트간의 배치와 간격은 일정하고 반듯해야함
- 글자의 크기는 일정한 수준을 유지
- CSS는 외부 라이브러리(부트스트랩)을 사용하지 않음
- jQuery를 사용하지 않고, querySelector, addEventListener, innerHTML을 사용해서 DOM, EVENT 처리
- Ajax는 XMLHTTPRequest를 사용

### 🛠 웹 백엔드 기술 요구사항

- maven 프로젝트
- 제공된 테이블 생성 SQL을 이용해서 테이블 생성
- TodoDto 클래스와 TodoDao 클래스를 주어진 스펙에 맞게 작성
- 메인화면을 보여주기 위한 MainServlet과 main.jsp를 작성
- MainServlet은 TodoDao를 이용해 결과를 조회해서 main.jsp에 전달
- 새로운 todo 등록 버튼을 클릭하면 해당 요청을 서블릿이 받아서 jsp로 포워딩하여 할 일 등록 화면을 보여줌
- 할일등록폼에서 값을 입력하고 제출 버튼을 누르면 post 방식으로 요청
- 해당 요청을 서블릿이 받아서 처리하게하고, 요청에 대한 모든 일이 끝나면 메인화면으로 리다이렉트
- 메인화면에서 todo 상태변경 버튼 (->)을 클릭하여 오청을 보낼 때, Todo의 id와 상태값을 전달하여 다음 상태로 상태를 나타내는 컬럼값을 변경하고 응답결과로 "success"를 보냄

![tododao_tododto](https://user-images.githubusercontent.com/50236501/124779750-fdaf6080-df7c-11eb-8c4b-b455b504a64b.png)


### TODO Database
```
TABLE todo(
  id BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  title VARCHAR(255) NOT NULL,
  name VARCHAR(100) NOT NULL,
  sequence INT(1) NOT NULL.
  type VARCHAR(20) DEFUALT 'TODO',
  regdate DATETIME DEFAULT NOW(),
  PRIMARY KEY(id)
);
```

### Main 화면
![무제](https://user-images.githubusercontent.com/50236501/124780345-7b736c00-df7d-11eb-98bf-743ffc486328.jpg)

### Form 화면
![무제](https://user-images.githubusercontent.com/50236501/124780478-9940d100-df7d-11eb-88e5-8cdf800c68bf.jpg)

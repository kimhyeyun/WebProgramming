# REST API
## API 란?
```
API는 Application Programming Interface의 약자   
"API는 응용프로그램에서 사용할 수 있도록, 운영 체제나 프로그래밍 언어가 제공하는 기능을 제어할 수 있게 만든 인터페이스르 뜻함"   
```

## REST API 란?
```
REST는 Representational State Tranfer의 약자   
REST API란 REST 형식의 API   
핵심 컨텐츠 및 기능을 외부 사이트에서 활용할 수 있도록 제공되는 인터페이스
예로, 네이버에서 블로그에 글을 저장하거나, 글목록을 읽어 갈 수 있도록 외부에 기능을 제공하는 것   
    우체국에서 우편번호를 조회 할 수 있는 기능을 제거하는 것
    구글에서 구글 지도를 사용할 수 있도록 제공하는 것
```

## 이것은 REST가 아니다
### REST는 다음과 같은 제약조건을 반드시 지켜야함
- client - server
- stateless
- cache
- uniform interface
- layered system
- code-on-demand (optional)

### REST API는 어렵기 때문에, 보통은 Web API (혹은 HTTP API)를 사용

# WEB API 
### Web API 디자인 가이드
- URI는 정보을 자원을 표현해야함
- 자원에 대한 행위는 HTTP Method (GET,POST,PUT,DELETE)로 표현함

### Web API
![2_11_2_webapi](https://user-images.githubusercontent.com/50236501/124456333-87b4c900-ddc5-11eb-9b0f-46bb98c1ff52.PNG)

### 상태 코드 
- 성공
![2_11_1_1](https://user-images.githubusercontent.com/50236501/124456473-b337b380-ddc5-11eb-93e5-482c5c5ec563.PNG)
- 클라이언트로 인한 오류
![2_11_1_2](https://user-images.githubusercontent.com/50236501/124456477-b468e080-ddc5-11eb-8e9f-963ecaa6a6a3.PNG)
- 서버로 인한 오류
![2_11_1_3](https://user-images.githubusercontent.com/50236501/124456479-b59a0d80-ddc5-11eb-9991-1e48b30ca627.PNG)

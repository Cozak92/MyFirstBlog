## My Blog
---

![](https://media.vlpt.us/images/roo333/post/cf501a24-8125-4835-a1bd-1e18af5e3f6f/20210811_172135.png)

ec2-3-35-166-186.ap-northeast-2.compute.amazonaws.com:4646 👈 블로그 주소!

[Backlog & Loadmap & Issue 구글 스프레드 시트](https://docs.google.com/spreadsheets/d/1zdZ0QFOl1-4NFmqmgHcSMnfp3Ejysx8wxDMNdS_j23k/edit#gid=0)



---

### 👨🏻‍🏫 주요 기능 👩🏻‍🏫

1. 회원가입 기능
- form post 방식이 아닌 Jquey와 Ajax을 이용해 통신


2. 로그인 기능
- 스프링 시큐리티를 이용해 회원과 비회원 접근가능 주소 분리
- 스프링 시큐리티에 remember-me 기능을 이용 로그인 상태 유지 가능
- 로그인 / 비로그인에 따라 메뉴 화면 구성 변경

3. 글 목록 

- JSTL을 이용해 글 불러오기
- 페이징 기능을 이용한 페이징처리

4. 글 상세보기
- 회원만 접근 가능 (삭제,수정 버튼)
- 로그인한 유저이여야하고 글을 작성한 유저에게만 버튼 보이기

5. 회원 정보 수정

- 회원이 정보를 수정했을때 재로그인 없이 세션값 변경을 통해 정보 수정

6. 카카로 로그인

- Oauth2 없이 직접 기능을 구현

7. 배포

- Docker 와 AWS EC2를 이용해 배포


### 🤹‍♂ Tech Stack
---

#### IDE
- Spring tool suite 4

#### Database
- Mysql 5.7


#### FrontEnd
- HTML
- CSS
- Jquery
- Bootstrap 4
- JSTL
- Summernote

#### Backend
- SpringBoot 2.5.3
- Spring Security
- JPA
- Lombok

#### CD
- AWS EC2
- Docker

#### Language
- Java
- Javascript




### 📁 File tree
![](https://images.velog.io/images/roo333/post/14027819-92f5-451f-8b24-176dd5bb067d/20210811_160104.png)


### 💼 API 명세
---
#### BoardApiController

@PostMapping("/api/board") - 글 등록

@PostMapping("/api/board/{boardId}/reply") - 댓글 등록

@DeleteMapping("/api/board/{id}") -글 삭제

@PutMapping("/api/board/{id}") - 글 수정

@DeleteMapping("/api/board/{boardId}/reply/{replyId}") - 댓글 삭제


#### UserApiController

@PostMapping("/auth/joinProc") - 회원가입

@PutMapping("/user") - 회원 수정


#### BoardController

@GetMapping("/board/{id}") - 글 상세보기

@GetMapping("/board/wirteForm") - 글 작성 화면

@GetMapping("/board/{id}/updateForm") - 글 수정 화면

#### UserController

@GetMapping("/auth/joinForm") - 회원 가입 화면

@GetMapping("/auth/loginForm") - 로그인 화면

@GetMapping("/user/updateForm") - 회원 수정 화면

@GetMapping("/auth/kakao/callback") - 카카오 로그인 콜백처리

### ERD
---
![](https://images.velog.io/images/roo333/post/97126fa5-6897-46bb-837e-6200301cb388/20210810_151447.png)

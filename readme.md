## My Blog
---

![](https://media.vlpt.us/images/roo333/post/cf501a24-8125-4835-a1bd-1e18af5e3f6f/20210811_172135.png)

ec2-3-35-166-186.ap-northeast-2.compute.amazonaws.com:4646 ๐ ๋ธ๋ก๊ทธ ์ฃผ์!

[Backlog & Loadmap & Issue ๊ตฌ๊ธ ์คํ๋ ๋ ์ํธ](https://docs.google.com/spreadsheets/d/1zdZ0QFOl1-4NFmqmgHcSMnfp3Ejysx8wxDMNdS_j23k/edit#gid=0)



---

### ๐จ๐ปโ๐ซ ์ฃผ์ ๊ธฐ๋ฅ ๐ฉ๐ปโ๐ซ

1. ํ์๊ฐ์ ๊ธฐ๋ฅ
- form post ๋ฐฉ์์ด ์๋ Jquey์ Ajax์ ์ด์ฉํด ํต์ 


2. ๋ก๊ทธ์ธ ๊ธฐ๋ฅ
- ์คํ๋ง ์ํ๋ฆฌํฐ๋ฅผ ์ด์ฉํด ํ์๊ณผ ๋นํ์ ์ ๊ทผ๊ฐ๋ฅ ์ฃผ์ ๋ถ๋ฆฌ
- ์คํ๋ง ์ํ๋ฆฌํฐ์ remember-me ๊ธฐ๋ฅ์ ์ด์ฉ ๋ก๊ทธ์ธ ์ํ ์ ์ง ๊ฐ๋ฅ
- ๋ก๊ทธ์ธ / ๋น๋ก๊ทธ์ธ์ ๋ฐ๋ผ ๋ฉ๋ด ํ๋ฉด ๊ตฌ์ฑ ๋ณ๊ฒฝ

3. ๊ธ ๋ชฉ๋ก 

- JSTL์ ์ด์ฉํด ๊ธ ๋ถ๋ฌ์ค๊ธฐ
- ํ์ด์ง ๊ธฐ๋ฅ์ ์ด์ฉํ ํ์ด์ง์ฒ๋ฆฌ

4. ๊ธ ์์ธ๋ณด๊ธฐ
- ํ์๋ง ์ ๊ทผ ๊ฐ๋ฅ (์ญ์ ,์์  ๋ฒํผ)
- ๋ก๊ทธ์ธํ ์ ์ ์ด์ฌ์ผํ๊ณ  ๊ธ์ ์์ฑํ ์ ์ ์๊ฒ๋ง ๋ฒํผ ๋ณด์ด๊ธฐ

5. ํ์ ์ ๋ณด ์์ 

- ํ์์ด ์ ๋ณด๋ฅผ ์์ ํ์๋ ์ฌ๋ก๊ทธ์ธ ์์ด ์ธ์๊ฐ ๋ณ๊ฒฝ์ ํตํด ์ ๋ณด ์์ 

6. ์นด์นด๋ก ๋ก๊ทธ์ธ

- Oauth2 ์์ด ์ง์  ๊ธฐ๋ฅ์ ๊ตฌํ

7. ๋ฐฐํฌ

- Docker ์ AWS EC2๋ฅผ ์ด์ฉํด ๋ฐฐํฌ


### ๐คนโโ Tech Stack
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




### ๐ File tree
![](https://images.velog.io/images/roo333/post/14027819-92f5-451f-8b24-176dd5bb067d/20210811_160104.png)


### ๐ผ API ๋ช์ธ
---
#### BoardApiController

@PostMapping("/api/board") - ๊ธ ๋ฑ๋ก

@PostMapping("/api/board/{boardId}/reply") - ๋๊ธ ๋ฑ๋ก

@DeleteMapping("/api/board/{id}") -๊ธ ์ญ์ 

@PutMapping("/api/board/{id}") - ๊ธ ์์ 

@DeleteMapping("/api/board/{boardId}/reply/{replyId}") - ๋๊ธ ์ญ์ 


#### UserApiController

@PostMapping("/auth/joinProc") - ํ์๊ฐ์

@PutMapping("/user") - ํ์ ์์ 


#### BoardController

@GetMapping("/board/{id}") - ๊ธ ์์ธ๋ณด๊ธฐ

@GetMapping("/board/wirteForm") - ๊ธ ์์ฑ ํ๋ฉด

@GetMapping("/board/{id}/updateForm") - ๊ธ ์์  ํ๋ฉด

#### UserController

@GetMapping("/auth/joinForm") - ํ์ ๊ฐ์ ํ๋ฉด

@GetMapping("/auth/loginForm") - ๋ก๊ทธ์ธ ํ๋ฉด

@GetMapping("/user/updateForm") - ํ์ ์์  ํ๋ฉด

@GetMapping("/auth/kakao/callback") - ์นด์นด์ค ๋ก๊ทธ์ธ ์ฝ๋ฐฑ์ฒ๋ฆฌ

### ERD
---
![](https://images.velog.io/images/roo333/post/97126fa5-6897-46bb-837e-6200301cb388/20210810_151447.png)

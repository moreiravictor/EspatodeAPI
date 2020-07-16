# EspatodeAPI
EspatodeAPI is a REST API built to manage the Espatodea blog, which intends to spread sustainability and ways to be better when it comes to this.
 ---
 Now it is up on heroku: https://espatodeapi.herokuapp.com
 <br/>
### endpoints
1.posts:
  - POST: /post
  - GET: /post
  - GET: /post/title?title={title}
  - GET: /post/{post_id}
  - GET: /post/category/{category_id}
  - PATCH: /post/{post_id}
  - DELETE: /post/{post_id}
  
<br/>2.comments:
  - POST: /comment
  - GET: /comment/post/{post_id}
  - DELETE: /comment/{post_id}
  
<br/>3.login:
  - GET: /admin?username={username}?password?={password}
  ---
### built with
  - [Java](https://www.java.com/pt_BR)
  - [Spring Boot](https://spring.io/)
---
### contributions
Please, fork it and contribute at any time. Just make a PR or open issues.

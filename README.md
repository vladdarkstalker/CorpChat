# WebChat
A chat implemented for communication on a local network. It is a training project to raise your skills.

Basic functionality: registration, authorization and the ability to exchange text messages over a local network between users.

After registering in the system and logging in to the account, a chat is created. All other users on the network are connected to this chat. If someone has already been online, then you will connect to an already created chat.

This project uses Spring, PostgreSQL and Java technologies.

Technologies used: Java, PostgreSQL, Spring Framework.

## Quick overview

### Registration
At the moment, there are no strict requirements for the stored data.

![[register.gif]]

### Login
When logging in, we search for the user by mail and check the password.

![[login.gif]]

### Logout
When logging out, the user is redirected to the login page.

![[logout.gif]]

### Chatting
Currently, only text messaging is available, adding other formats is not being considered yet. Also, the chat history is not available to new users at the moment.

![[chatting.gif]]

## Sources
These tutorials helped me create this project and understand the basis for developing such applications:
1) [Spring Boot 3 + Spring Security 6 + Thymeleaf - Registration and Login Example (knowledgefactory.net)](https://www.knowledgefactory.net/2023/10/spring-boot-3-spring-security-6-thymeleaf-registration-and-login-example.html)
2) [Create a simple Chat application with Spring Boot and Websocket | o7planning.org](https://o7planning.org/10719/create-a-simple-chat-application-with-spring-boot-and-websocket)
3) [Spring Framework Documentation :: Spring Framework](https://docs.spring.io/spring-framework/reference/index.html)
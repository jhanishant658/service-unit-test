\# 🧪 Service Layer Unit Testing with Spring Boot, JUnit \& Mockito



This project focuses on writing isolated service-layer unit tests using Spring Boot, JUnit 5, and Mockito.  

Repository dependencies are mocked to validate business logic without involving any database.



---



\## 🚀 Features



\- Product service with add and get functionality  

\- Service-layer unit testing using Mockito  

\- Repository layer mocked (no database)  

\- Validation and exception handling  

\- Easily extendable test suite  



---



\## 🛠 Tech Stack



\- Java  

\- Spring Boot  

\- JUnit 5  

\- Mockito  

\- Maven  



---



\## 📂 Project Structure



src

├── main

│ ├── Entities

│ ├── Repositories

│ └── Services

└── test

└── ServiceTesting

---



\## ✅ Current Test Coverage



\- addProduct() – success case  

\- addProduct() – invalid product data  

\- getProduct() – success case  

\- getProduct() – product not found case  



(More test cases will be added.)



---



\## ▶️ How to Run Tests



From project root:

&nbsp;  mvn test



---



\## 📚 Learning Goals



\- Writing unit tests with JUnit 5  

\- Mocking dependencies using Mockito  

\- Using @Mock and @InjectMocks  

\- Validating behavior with verify()  

\- Testing exceptions with assertThrows()  

\- Understanding service-layer isolation  



---



\## 💡 Note



This project is intentionally kept database-free to focus purely on unit testing concepts.



---



\## 🙌 Author



Nishant Jha

Aspiring Software Developer



---



⭐ Feel free to star the repository if you find it helpful.




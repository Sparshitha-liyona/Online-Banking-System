# 🏦 Online Banking System

A RESTful Online Banking System built with **Spring Boot**, **Spring Data JPA**, and **PostgreSQL**. It supports user registration, authentication, account management, and banking transactions like deposit, withdrawal, and fund transfer.

---

## 🚀 Features

- **User Registration & Login** – Register users with auto-generated bank accounts
- **Deposit** – Add funds to an account
- **Withdrawal** – Withdraw funds with balance validation
- **Fund Transfer** – Transfer money between two accounts
- **Transaction History** – Fetch all transactions for a given account
- **Admin Panel** – View all users, accounts, and transactions
- **Exception Handling** – Custom exceptions for insufficient balance, invalid credentials, and resource not found
- **Input Validation** – Request validation using Jakarta Bean Validation

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Framework | Spring Boot 4.0.5 |
| Language | Java 17 |
| ORM | Spring Data JPA |
| Database | PostgreSQL |
| Validation | Spring Boot Starter Validation |
| Boilerplate Reduction | Lombok |
| Build Tool | Maven |
| API Type | REST API |

---

## 📁 Project Structure

```
Online-Banking-System/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/jsp/bank/
│       │       ├── controller/         # REST Controllers
│       │       │   ├── AdminController.java
│       │       │   ├── AuthController.java
│       │       │   └── TransactionController.java
│       │       ├── service/            # Business Logic
│       │       │   ├── AdminService.java
│       │       │   ├── AuthService.java
│       │       │   └── TransactionService.java
│       │       ├── dao/                # Repository Interfaces
│       │       ├── dto/                # Request/Response DTOs
│       │       ├── entity/             # JPA Entities (User, Account, Transaction)
│       │       ├── exception/          # Custom Exceptions
│       │       └── util/               # Utility classes (ApiResponse, AccountUtil)
│       └── resources/
│           └── application.properties
├── pom.xml
└── README.md
```

---

## 📡 API Endpoints

### Auth (`/auth/api`)
| Method | Endpoint | Description |
|---|---|---|
| POST | `/auth/api/register` | Register a new user (auto-creates a savings account) |
| POST | `/auth/api/login` | Login with email and password |

### Transactions (`/transaction/api`)
| Method | Endpoint | Description |
|---|---|---|
| POST | `/transaction/api/deposit` | Deposit amount into an account |
| POST | `/transaction/api/withdraw` | Withdraw amount from an account |
| POST | `/transaction/api/transfer` | Transfer amount between two accounts |
| GET | `/transaction/api/history/{accountNumber}` | Fetch transaction history |

### Admin (`/admin/api`)
| Method | Endpoint | Description |
|---|---|---|
| GET | `/admin/api/users` | Fetch all registered users |
| GET | `/admin/api/accounts` | Fetch all bank accounts |
| GET | `/admin/api/transactions` | Fetch all transactions |

---

## 🔄 Core Business Logic

### Registration
- Creates a `User` and automatically generates a **Savings Account** with account number via `AccountUtil`
- Initial balance is set to `0`

### Deposit & Withdrawal
- Validates account existence before processing
- Withdrawal checks if requested amount exceeds available balance → throws `InsufficientBalanceException`
- Updates balance and records the transaction with status `SUCCESS`

### Fund Transfer
- Validates both sender and receiver accounts
- Checks sender has sufficient balance
- Deducts from sender, credits to receiver, and saves the transaction

---

## ⚙️ Prerequisites

- Java 17+
- Maven 3.x
- PostgreSQL

---

## 🔧 Setup & Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/Sparshitha-liyona/Online-Banking-System.git
   cd Online-Banking-System
   ```

2. **Create the PostgreSQL database**
   ```sql
   CREATE DATABASE banking_db;
   ```

3. **Configure database credentials** in `src/main/resources/application.properties`
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/banking_db
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```

4. **Build and run**
   ```bash
   mvn spring-boot:run
   ```

5. **Access the API**
   ```
   http://localhost:8080
   ```

---

## 📦 Key Dependencies

| Dependency | Purpose |
|---|---|
| `spring-boot-starter-webmvc` | REST API support |
| `spring-boot-starter-data-jpa` | Database ORM |
| `spring-boot-starter-validation` | Input validation |
| `postgresql` | PostgreSQL JDBC driver |
| `lombok` | Reduces boilerplate code |
| `spring-boot-devtools` | Hot reload during development |

---

## 👤 Author

**Sparshitha Liyona**  
GitHub - https://github.com/Sparshitha-liyona

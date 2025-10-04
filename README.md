💳 ATM UI & Bank Management System

A Java-based desktop application built with Swing, AWT, and MySQL for managing ATM transactions and basic banking operations.

🚀 Overview

The ATM UI and Bank Management System is a desktop-based application designed to simulate real-world ATM operations and bank management features. Built using Java (Swing & AWT) for the front-end interface and MySQL for database management, this project provides a complete environment for user transactions such as deposits, withdrawals, balance checks, and more.

It is an ideal project for understanding Java GUI, event handling, and JDBC database connectivity.

🧩 Features

✅ User authentication (Login & PIN verification) ✅ Deposit and Withdraw functionality ✅ Balance inquiry ✅ Mini statement view ✅ Secure and interactive ATM user interface ✅ Admin/Bank Management tools for user record management ✅ MySQL database integration with JDBC

🏗️ Tech Stack

Frontend: Java Swing, AWT Backend: Java Database: MySQL IDE Used: NetBeans Build Tool: Apache Ant

⚙️ Installation & Setup

Clone the repository

Configure the database

Install MySQL and create a new database (e.g., bankmanagement).

Import the provided SQL script (bankmanagement.sql) to set up tables.

Update your JDBC connection URL, username, and password in the Java source file (typically in Conn.java or similar).

Example:

Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagement", "root", "yourpassword");

Run the project
Open the project in NetBeans or any Java IDE.

Build and run the main class (e.g., Main.java or Login.java).

🖥️ Project Structure ATM-Bank-Management-System/ │ ├── src/ │ ├── bank/management/system/ │ │ ├── Login.java │ │ ├── Signup.java │ │ ├── Deposit.java │ │ ├── Withdraw.java │ │ ├── BalanceEnquiry.java │ │ ├── MiniStatement.java │ │ ├── Conn.java │ │ └── Main.java │ ├── database/ │ └── bankmanagement.sql │ ├── README.md └── build.xml

🧠 Learning Highlights

Java Swing GUI design

AWT-based layout management

Event handling and listeners in Java

JDBC connectivity with MySQL

Modular and object-oriented programming principles

🤝 Contributing

Contributions, issues, and feature requests are welcome! Feel free to fork this repository and submit a pull request.

📜 License

This project is licensed under the MIT License – see the LICENSE file for details.

👨‍💻 Author

Kartik Sharma 📧 kartiksharmalib7@gmail.com 🌐 www.linkedin.com/in/cu23220073

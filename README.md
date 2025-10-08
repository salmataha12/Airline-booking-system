# ✈️ Airline Booking System (Java / NetBeans)

A **Java-based Airline Booking System** built using **NetBeans** and **JDK 22**.  
This desktop application allows admins and passengers to manage flights, bookings, and seats through an intuitive GUI.  
It uses **Jackson** for JSON data handling and follows **Object-Oriented Programming (OOP)** principles.

---

## Features

### 👤 Passenger
- Register and log in  
- View available flights  
- Book and cancel tickets  
- View ticket information  
- Update personal details  

### 🧑‍💼 Admin
- Add, edit, and delete flights  
- Manage seats and schedules  
- View bookings and user data  
- Generate basic reports  

---

## ⚙️ Tech Stack

| Component | Technology |
|------------|-------------|
| Language | Java (JDK 22) |
| IDE | NetBeans |
| UI | Java Swing |
| JSON Handling | Jackson (core, databind, annotations) |
| Build Tool | Ant |
| Storage | File-based (JSON files) |

---


---

## Installation & Setup

### 1️⃣ Prerequisites
- Install **JDK 22** or later  
- Install **NetBeans IDE** (or IntelliJ IDEA)

---

### 2️⃣ Clone the Repository
```bash
git clone https://github.com/<your-username>/Airline-booking-system.git
cd Airline-booking-system
```

Add Libraries

All dependencies are in the jar_files/ folder:

- jackson-core-2.17.0.jar
- jackson-databind-2.17.0.jar
- jackson-annotations-2.17.0.jar
- byte-buddy-1.14.9.jar

In NetBeans:
- Right-click project → Properties → Libraries → Add JAR/Folder → select all from jar_files → OK
= Then Clean and Build (Shift + F11).

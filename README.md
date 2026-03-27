![Java](https://img.shields.io/badge/Java-25.0.2-blue)

# 🧃 Vending Machine (OOP Workshop Project)

## 📌 Overview

This project is a console-based **Vending Machine application** developed as part of an Object-Oriented Programming (OOP) workshop.

The application simulates a real vending machine where users can:

* View available products
* Insert coins
* Purchase products
* Receive change

The system is built using core OOP principles such as **inheritance, polymorphism, abstraction, and encapsulation**.

---
## 📘 Workshop Instructions

👉 [View workshop instructions](OOP2_Workshop.md)

---

## 🎯 Objectives

The main goal of this project was to:

* Apply Object-Oriented Programming concepts
* Work with an interface and class structure based on a UML diagram
* Implement business logic for a vending machine
* Build a console-based user interface
* Validate user input (coins and product selection)
* Prepare the project for testing and deployment (JAR file)

---

## 🧱 Project Structure

### 🔹 Core Components

#### `IVendingMachine` (Interface)

Defines the main functionality of the vending machine:

* Insert coins
* Check balance
* Purchase products
* Return change
* Retrieve product list

---

#### `VendingMachineImpl`

Implements the vending machine logic:

* Validates accepted coins (1, 2, 5, 10, 20, 50)
* Tracks user balance
* Handles product purchases
* Updates stock after purchase
* Returns change and resets balance

---

#### `Product` (Abstract Class)

Base class for all products:

* id
* name
* price
* quantity

Includes an abstract method:

* `getDescription()`

---

#### Product Types (Inheritance)


Each product type now includes unique fields to better demonstrate inheritance and polymorphism:

#### Beverage
- `carbonated`
- `containsSugar`
- `containsCaffeine`

#### Snack
- `calories`
- `containsNuts`
- `containsGluten`

#### Fruit
- `hasPeel`

These fields allow each subclass to provide a more detailed and type‑specific implementation of `getDescription()`, including its unique attributes (e.g., sugar/caffeine for beverages, allergens for snacks, peel for fruit).

---

#### `ProductCatalog`

Provides a predefined list of products available in the vending machine.

---

#### `ConsoleUI`

Handles console-based user interaction:

* Displays options
* Processes user input
* Communicates with the vending machine logic

---

#### `Main`

Entry point of the application:

* Initializes products
* Starts the console UI

---

## ⚙️ Functionality

### 💰 Coin Handling

* Accepted coins: **1, 2, 5, 10, 20, 50**
* Invalid coins are rejected
* Balance increases when valid coins are inserted

---

### 🛒 Product Purchase

* User selects a product by ID
* Purchase succeeds only if:

  * Sufficient balance
  * Product is in stock
* Stock is reduced after purchase
* Balance is updated

---

### 🔄 Return Change

* User can request remaining balance
* Balance resets to 0 after returning change

---

## 🧪 Testing

JUnit tests cover core functionality, including:

* Insert valid coin
* Reject invalid coin
* Successful purchase
* Purchase with insufficient balance
* Purchase when out of stock
* Return change resets balance
* Retrieve product list

---

## ⚡ Quick Start

Clone the repository:

```
git clone https://github.com/KristyH89/Workshop8-OOP2-VendingMachine.git
``` 
---

## ▶️ How to Run the Application

### Option 1 — Run in IDE

Run the `Main` class.

---

### Option 2 — Run as JAR

1. Build the project in IntelliJ:

   ```
   Build → Build Artifacts → Build
   ```

2. Navigate to the JAR location:

   ```
   out/artifacts/Workshop8_OOP2_VendingMachine_jar
   ```

3. Run the application:

   ```
   java -jar Workshop8-OOP2-VendingMachine.jar
   ```

---

## 💡 OOP Principles Used

### 🔹 Encapsulation

* Private fields with getters/setters in `Product`

### 🔹 Inheritance

* `Snack`, `Beverage`, and `Fruit` extend `Product`

### 🔹 Polymorphism

* Different implementations of `getDescription()`

### 🔹 Abstraction

* `Product` is abstract
* `IVendingMachine` defines behavior without implementation


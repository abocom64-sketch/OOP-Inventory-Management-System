# 📦 Smart Inventory Management System

A **Java-based console application** that demonstrates core **Object-Oriented Programming (OOP)** principles through a complete inventory management solution. The system supports **Store Manager** and **Staff** roles, manages grocery and electronics inventory, processes sales, provides low-stock alerts, and records all transactions in a log file.

---

## 🚀 Features

### 👤 Role-Based Access

#### Store Manager
- Add grocery items
- Add electronics items
- View inventory
- Process sales
- Check low-stock items
- View transaction logs
- Logout

#### Staff
- View inventory
- Check low-stock items
- Logout

---

### 📦 Item Management

- Add **Grocery Items** with expiry dates.
- Add **Electronics Items** with warranty periods.
- Display inventory with category-specific information.

---

### 💰 Sales Processing

- Sell items using **Item ID** and **Quantity**.
- Validates stock availability.
- Automatically updates inventory.
- Records every sale in the transaction log.
- Uses custom exceptions for invalid operations.

---

### ⚠️ Low-Stock Alert

- Identifies items with stock below the threshold (default: **5**).
- Recommends restocking low inventory.

---

### 📝 Transaction Logging

Every inventory addition and sale is automatically recorded in:

```text
inventory_logs.txt
```

Each log contains:
- Timestamp
- Action performed
- Item name
- Quantity

---

### 💡 OOP Principles Demonstrated

- ✅ Encapsulation
- ✅ Inheritance
- ✅ Abstraction
- ✅ Polymorphism
- ✅ Interfaces
- ✅ Exception Handling

---

# 📂 Project Structure

```text
SmartInventoryManagementSystem/
│
├── Item.java
├── GroceryItem.java
├── ElectronicsItem.java
├── InventoryOperations.java
├── InventoryManager.java
├── User.java
├── StoreManager.java
├── Staff.java
├── FileHandler.java
├── InventoryException.java
├── InventoryMain.java
└── inventory_logs.txt   (generated automatically)
```

---

# 📖 Class Descriptions

| Class | Description |
|--------|-------------|
| **Item** *(Abstract)* | Base class containing item ID, name, quantity, and price. Declares `displayDetails()`. |
| **GroceryItem** | Extends `Item`; adds expiry date and overrides `displayDetails()`. |
| **ElectronicsItem** | Extends `Item`; adds warranty period and overrides `displayDetails()`. |
| **InventoryOperations** *(Interface)* | Declares inventory-related operations. |
| **InventoryManager** | Implements inventory operations using an `ArrayList<Item>`. Handles inventory logic and logging. |
| **User** *(Abstract)* | Base class for users with login information and abstract `displayUserDetails()`. |
| **StoreManager** | Extends `User`; provides full inventory management privileges. |
| **Staff** | Extends `User`; provides limited read-only functionality. |
| **FileHandler** | Utility class that writes timestamped transaction logs to a file. |
| **InventoryException** | Custom exception used for inventory-related business rules. |
| **InventoryMain** | Main driver class containing menus, input handling, and program execution. |

---

# 🏗 OOP Concepts Applied

## 🔒 Encapsulation
- Private data members.
- Access through getters and setters.

## 👨‍👩‍👧 Inheritance
- `GroceryItem` → `Item`
- `ElectronicsItem` → `Item`
- `StoreManager` → `User`
- `Staff` → `User`

## 🎯 Abstraction
- `Item` and `User` are abstract classes.
- Define common behavior for subclasses.

## 🔄 Polymorphism
- `displayDetails()` overridden by different item types.
- `displayUserDetails()` overridden by different user roles.
- `InventoryManager` interacts with objects through `Item` references.

## 📄 Interface
`InventoryOperations` defines the contract for inventory management methods.

Implemented methods:
- `addItem()`
- `sellItem()`
- `showAllItems()`
- `checkLowStock()`

## ⚠️ Exception Handling
- Custom `InventoryException`
- Handles:
  - Invalid item ID
  - Insufficient stock
- Uses `InputMismatchException` for invalid user input.

---

# 🛠 How to Run

### 1. Compile the project

```bash
javac *.java
```

### 2. Run the application

```bash
java InventoryMain
```

---

# 🔐 Login Credentials

## Store Manager

| Field | Value |
|-------|-------|
| Username | `Admin_Su` |
| Password | `admin123` |

---

## Staff

| Field | Value |
|-------|-------|
| Username | `Staff_User` |
| Password | `staff123` |

> **Note:** The application currently uses role selection and automatically logs users in. Username and password are hardcoded for demonstration purposes.

---

# 📋 Sample Workflow

1. Launch the application.
2. Welcome screen appears.
3. Select a role:
   - `1` → Store Manager
   - `2` → Staff
   - `3` → Exit
4. Manager can:
   - Add Grocery Item
   - Add Electronics Item
   - View Inventory
   - Process Sales
   - Check Low Stock
   - View Transaction Logs
   - Logout
5. Staff can:
   - View Inventory
   - Check Low Stock
   - Logout
6. Every inventory update is automatically written to `inventory_logs.txt`.

---

# 📄 Transaction Log Example

```text
================ INVENTORY LOG ================

Date     : 2026-07-24 14:32:15
Action   : ADD
Item     : Milk
Quantity : 20

===============================================
```

---

# 📈 Future Enhancements

- 🔐 Secure user authentication with password hashing.
- 🗄 Database integration using JDBC and MySQL.
- 🖥 Java Swing or JavaFX graphical user interface.
- 📊 Inventory reports and analytics dashboard.
- 🔍 Search and filter inventory items.
- 📦 Import/export inventory data (CSV/Excel).
- 👥 Multiple staff accounts with role management.

---

# 👨‍💻 Authors

**Group 8 – Smart Inventory Management System**

Developed as an academic project to demonstrate Java Object-Oriented Programming concepts and inventory management.

---

# 📚 Technologies Used

- Java
- Object-Oriented Programming (OOP)
- Java Collections (`ArrayList`)
- File I/O
- Exception Handling

---

# 📄 License

This project is intended for **educational purposes**.

You are welcome to use, modify, and distribute this project for learning and academic use.

# Demonstration of our application:
- https://youtu.be/OGG1c2QuMTQ
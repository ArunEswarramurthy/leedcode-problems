# Chapter 1: Classes and Objects

## Table of Contents
1. [Real-Life Meaning](#real-life-meaning)
2. [Why and Where Used](#why-and-where-used)
3. [Syntax and Detailed Explanation](#syntax-and-detailed-explanation)
4. [Simple Example Program](#simple-example-program)
5. [Advanced Example Program](#advanced-example-program)
6. [Interview Questions with Answers](#interview-questions-with-answers)
7. [Problem-Solving Approach](#problem-solving-approach)
8. [Practice Questions](#practice-questions)

---

## Real-Life Meaning

### What is a Class?
A **class** is like a **blueprint** or **template** for creating objects. Think of it as:
- **Architectural blueprint** for a house
- **Recipe** for making a cake
- **Car design** from which actual cars are manufactured

### What is an Object?
An **object** is an **instance** of a class - the actual thing created from the blueprint:
- **Actual house** built from the blueprint
- **Actual cake** made from the recipe
- **Actual car** manufactured from the design

### Real-Life Example
- **Class**: "Student" (concept/blueprint)
- **Objects**: "John", "Sarah", "Mike" (actual students)
- **Attributes**: name, age, grade, rollNumber
- **Behaviors**: study(), attendClass(), takeExam()

---

## Why and Where Used

### Why Use Classes and Objects?

1. **Code Organization**: Group related data and functions together
2. **Reusability**: Create multiple objects from one class
3. **Modularity**: Break complex programs into manageable pieces
4. **Data Hiding**: Protect data using encapsulation
5. **Real-World Modeling**: Represent real entities in code

### Where Used?

- **Game Development**: Player, Enemy, Weapon classes
- **Banking Systems**: Account, Customer, Transaction classes
- **E-commerce**: Product, Cart, Order classes
- **Social Media**: User, Post, Comment classes
- **School Management**: Student, Teacher, Course classes

---

## Syntax and Detailed Explanation

### Basic Class Syntax

```cpp
class ClassName {
    // Access Specifier
    private:
        // Data members (attributes/properties)
        dataType memberVariable1;
        dataType memberVariable2;
    
    public:
        // Member functions (methods/behaviors)
        returnType functionName(parameters) {
            // function body
        }
};
```

### Access Specifiers

| Specifier | Access Level |
|-----------|-------------|
| `private` | Accessible only within the class |
| `public` | Accessible from anywhere |
| `protected` | Accessible in class and derived classes |

### Creating Objects

```cpp
// Syntax
ClassName objectName;

// Examples
Student student1;           // Object on stack
Student* student2 = new Student();  // Object on heap
```

### Accessing Members

```cpp
// Using dot operator (.)
objectName.memberFunction();
objectName.publicVariable;

// Using arrow operator (->)
pointerToObject->memberFunction();
pointerToObject->publicVariable;
```

---

## Simple Example Program

### Example 1: Student Class

```cpp
#include <iostream>
#include <string>
using namespace std;

class Student {
private:
    string name;
    int age;
    int rollNumber;
    
public:
    // Function to set student details
    void setDetails(string n, int a, int r) {
        name = n;
        age = a;
        rollNumber = r;
    }
    
    // Function to display student details
    void display() {
        cout << "Name: " << name << endl;
        cout << "Age: " << age << endl;
        cout << "Roll Number: " << rollNumber << endl;
    }
    
    // Function to check if student is adult
    bool isAdult() {
        return age >= 18;
    }
};

int main() {
    // Creating object
    Student student1;
    
    // Setting details
    student1.setDetails("John Doe", 20, 101);
    
    // Displaying details
    student1.display();
    
    // Checking if adult
    if (student1.isAdult()) {
        cout << "Student is an adult." << endl;
    } else {
        cout << "Student is a minor." << endl;
    }
    
    return 0;
}
```

**Output:**
```
Name: John Doe
Age: 20
Roll Number: 101
Student is an adult.
```

### Example 2: Rectangle Class

```cpp
#include <iostream>
using namespace std;

class Rectangle {
private:
    double length;
    double width;
    
public:
    void setDimensions(double l, double w) {
        length = l;
        width = w;
    }
    
    double calculateArea() {
        return length * width;
    }
    
    double calculatePerimeter() {
        return 2 * (length + width);
    }
    
    void display() {
        cout << "Length: " << length << endl;
        cout << "Width: " << width << endl;
        cout << "Area: " << calculateArea() << endl;
        cout << "Perimeter: " << calculatePerimeter() << endl;
    }
};

int main() {
    Rectangle rect1, rect2;
    
    rect1.setDimensions(5.0, 3.0);
    rect2.setDimensions(7.5, 4.2);
    
    cout << "Rectangle 1:" << endl;
    rect1.display();
    
    cout << "\nRectangle 2:" << endl;
    rect2.display();
    
    return 0;
}
```

---

## Advanced Example Program

### Example: Bank Account Management System

```cpp
#include <iostream>
#include <string>
#include <vector>
using namespace std;

class BankAccount {
private:
    string accountNumber;
    string accountHolderName;
    double balance;
    vector<string> transactionHistory;
    
    // Private helper function
    void addTransaction(string transaction) {
        transactionHistory.push_back(transaction);
    }
    
public:
    // Initialize account
    void createAccount(string accNum, string name, double initialBalance) {
        accountNumber = accNum;
        accountHolderName = name;
        balance = initialBalance;
        addTransaction("Account created with balance: $" + to_string(initialBalance));
    }
    
    // Deposit money
    bool deposit(double amount) {
        if (amount <= 0) {
            cout << "Invalid deposit amount!" << endl;
            return false;
        }
        balance += amount;
        addTransaction("Deposited: $" + to_string(amount));
        cout << "Successfully deposited $" << amount << endl;
        return true;
    }
    
    // Withdraw money
    bool withdraw(double amount) {
        if (amount <= 0) {
            cout << "Invalid withdrawal amount!" << endl;
            return false;
        }
        if (amount > balance) {
            cout << "Insufficient balance!" << endl;
            return false;
        }
        balance -= amount;
        addTransaction("Withdrawn: $" + to_string(amount));
        cout << "Successfully withdrawn $" << amount << endl;
        return true;
    }
    
    // Transfer money to another account
    bool transfer(BankAccount &recipient, double amount) {
        if (amount <= 0) {
            cout << "Invalid transfer amount!" << endl;
            return false;
        }
        if (amount > balance) {
            cout << "Insufficient balance for transfer!" << endl;
            return false;
        }
        
        balance -= amount;
        recipient.balance += amount;
        
        addTransaction("Transferred: $" + to_string(amount) + " to " + recipient.accountNumber);
        recipient.addTransaction("Received: $" + to_string(amount) + " from " + accountNumber);
        
        cout << "Successfully transferred $" << amount << endl;
        return true;
    }
    
    // Get current balance
    double getBalance() const {
        return balance;
    }
    
    // Display account details
    void displayAccountInfo() const {
        cout << "\n========== Account Information ==========" << endl;
        cout << "Account Number: " << accountNumber << endl;
        cout << "Account Holder: " << accountHolderName << endl;
        cout << "Current Balance: $" << balance << endl;
        cout << "=========================================" << endl;
    }
    
    // Display transaction history
    void displayTransactionHistory() const {
        cout << "\n===== Transaction History =====" << endl;
        if (transactionHistory.empty()) {
            cout << "No transactions yet." << endl;
        } else {
            for (size_t i = 0; i < transactionHistory.size(); i++) {
                cout << i + 1 << ". " << transactionHistory[i] << endl;
            }
        }
        cout << "===============================" << endl;
    }
    
    // Calculate interest (assuming 5% annual interest)
    void applyInterest(double rate = 0.05) {
        double interest = balance * rate;
        balance += interest;
        addTransaction("Interest applied: $" + to_string(interest));
        cout << "Interest of $" << interest << " applied." << endl;
    }
};

int main() {
    // Create bank accounts
    BankAccount account1, account2;
    
    account1.createAccount("ACC001", "Alice Johnson", 1000.0);
    account2.createAccount("ACC002", "Bob Smith", 500.0);
    
    // Display initial account info
    account1.displayAccountInfo();
    account2.displayAccountInfo();
    
    // Perform transactions
    cout << "\n--- Performing Transactions ---" << endl;
    account1.deposit(500.0);
    account1.withdraw(200.0);
    account1.transfer(account2, 300.0);
    
    // Apply interest
    cout << "\n--- Applying Interest ---" << endl;
    account1.applyInterest();
    account2.applyInterest();
    
    // Display updated account info
    account1.displayAccountInfo();
    account2.displayAccountInfo();
    
    // Display transaction history
    account1.displayTransactionHistory();
    account2.displayTransactionHistory();
    
    return 0;
}
```

**Output:**
```
Account created with balance: $1000.000000
Account created with balance: $500.000000

========== Account Information ==========
Account Number: ACC001
Account Holder: Alice Johnson
Current Balance: $1000
=========================================

========== Account Information ==========
Account Number: ACC002
Account Holder: Bob Smith
Current Balance: $500
=========================================

--- Performing Transactions ---
Successfully deposited $500
Successfully withdrawn $200
Successfully transferred $300

--- Applying Interest ---
Interest of $50 applied.
Interest of $30 applied.

========== Account Information ==========
Account Number: ACC001
Account Holder: Alice Johnson
Current Balance: $1050
=========================================

========== Account Information ==========
Account Number: ACC002
Account Holder: Bob Smith
Current Balance: $830
=========================================

===== Transaction History =====
1. Account created with balance: $1000.000000
2. Deposited: $500.000000
3. Withdrawn: $200.000000
4. Transferred: $300.000000 to ACC002
5. Interest applied: $50.000000
===============================

===== Transaction History =====
1. Account created with balance: $500.000000
2. Received: $300.000000 from ACC001
3. Interest applied: $30.000000
===============================
```

---

## Interview Questions with Answers

### Q1: What is the difference between a class and an object?

**Answer:**
- **Class**: A blueprint or template that defines the structure and behavior
- **Object**: An instance of a class, the actual entity created from the blueprint

**Example:**
```cpp
class Car { };      // Class (blueprint)
Car myCar;          // Object (instance)
```

### Q2: What are access specifiers? Explain each.

**Answer:**
- **private**: Members accessible only within the class
- **public**: Members accessible from anywhere
- **protected**: Members accessible in the class and derived classes

```cpp
class Example {
private:
    int privateVar;      // Only accessible within class
public:
    int publicVar;       // Accessible everywhere
protected:
    int protectedVar;    // Accessible in class and derived classes
};
```

### Q3: What is the default access specifier in a class?

**Answer:** `private` is the default access specifier in a class.

```cpp
class MyClass {
    int x;  // This is private by default
};
```

### Q4: Can we have multiple objects of the same class?

**Answer:** Yes, we can create multiple objects from the same class. Each object has its own copy of data members.

```cpp
class Student {
    string name;
public:
    void setName(string n) { name = n; }
};

int main() {
    Student s1, s2, s3;  // Three different objects
    s1.setName("Alice");
    s2.setName("Bob");
    s3.setName("Charlie");
}
```

### Q5: What is the difference between struct and class in C++?

**Answer:**
- **struct**: Default access is `public`
- **class**: Default access is `private`

```cpp
struct MyStruct {
    int x;  // public by default
};

class MyClass {
    int x;  // private by default
};
```

### Q6: What is the size of an empty class?

**Answer:** The size of an empty class is typically 1 byte to ensure that each object has a unique address.

```cpp
class Empty { };
cout << sizeof(Empty);  // Output: 1
```

### Q7: Can we access private members of a class from outside?

**Answer:** No, private members cannot be accessed directly from outside the class. We need public getter/setter methods.

```cpp
class Example {
private:
    int value;
public:
    void setValue(int v) { value = v; }  // Setter
    int getValue() { return value; }      // Getter
};
```

### Q8: What is the 'this' pointer?

**Answer:** `this` is a pointer that holds the address of the current object. It's implicitly available in all non-static member functions.

```cpp
class Example {
    int x;
public:
    void setX(int x) {
        this->x = x;  // Distinguishes member variable from parameter
    }
};
```

### Q9: What is data hiding/encapsulation?

**Answer:** Encapsulation is wrapping data and methods together and restricting direct access to data using access specifiers.

```cpp
class BankAccount {
private:
    double balance;  // Hidden from outside
public:
    void deposit(double amount) {  // Controlled access
        if (amount > 0) balance += amount;
    }
};
```

### Q10: Can member functions be defined outside the class?

**Answer:** Yes, using the scope resolution operator (::).

```cpp
class MyClass {
public:
    void display();  // Declaration
};

void MyClass::display() {  // Definition outside class
    cout << "Hello!" << endl;
}
```

---

## Problem-Solving Approach

### Step-by-Step Approach to Design Classes

#### Step 1: Identify Entities
- What real-world objects are involved?
- Example: Student, Book, Car, Account

#### Step 2: Identify Attributes (Data Members)
- What properties does the entity have?
- Example for Student: name, age, rollNumber, grade

#### Step 3: Identify Behaviors (Member Functions)
- What actions can the entity perform?
- Example for Student: study(), attendClass(), takeExam()

#### Step 4: Determine Access Levels
- Which data should be private?
- Which functions should be public?

#### Step 5: Implement the Class
- Write the class definition
- Implement member functions
- Add validation and error handling

#### Step 6: Test with Objects
- Create objects
- Test all functionalities
- Handle edge cases

### Design Pattern Example

```cpp
// Step 1: Identify Entity - Library Book
// Step 2: Attributes - title, author, ISBN, isAvailable
// Step 3: Behaviors - borrowBook(), returnBook(), displayInfo()
// Step 4: Private data, public methods
// Step 5 & 6: Implementation

class Book {
private:
    string title;
    string author;
    string ISBN;
    bool isAvailable;
    
public:
    void setDetails(string t, string a, string isbn) {
        title = t;
        author = a;
        ISBN = isbn;
        isAvailable = true;
    }
    
    bool borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        }
        return false;
    }
    
    void returnBook() {
        isAvailable = true;
    }
    
    void displayInfo() {
        cout << "Title: " << title << endl;
        cout << "Author: " << author << endl;
        cout << "ISBN: " << ISBN << endl;
        cout << "Status: " << (isAvailable ? "Available" : "Borrowed") << endl;
    }
};
```

---

## Practice Questions

### Question 1: Basic Class Implementation
**Problem:** Create a `Circle` class with a private data member `radius`. Implement public methods to:
- Set the radius
- Calculate area (π × r²)
- Calculate circumference (2 × π × r)
- Display circle information

**Test Cases:**
```
Input: radius = 5
Output: 
Area: 78.5
Circumference: 31.4

Input: radius = 7.5
Output:
Area: 176.625
Circumference: 47.1
```

**Solution:**
```cpp
#include <iostream>
#include <cmath>
using namespace std;

class Circle {
private:
    double radius;
    const double PI = 3.14;
    
public:
    void setRadius(double r) {
        if (r > 0) {
            radius = r;
        } else {
            cout << "Invalid radius!" << endl;
        }
    }
    
    double calculateArea() {
        return PI * radius * radius;
    }
    
    double calculateCircumference() {
        return 2 * PI * radius;
    }
    
    void display() {
        cout << "Radius: " << radius << endl;
        cout << "Area: " << calculateArea() << endl;
        cout << "Circumference: " << calculateCircumference() << endl;
    }
};

int main() {
    Circle c1;
    c1.setRadius(5);
    c1.display();
    
    return 0;
}
```

---

### Question 2: Employee Management
**Problem:** Create an `Employee` class with:
- Private members: name, employeeID, salary
- Public methods: 
  - setDetails()
  - displayDetails()
  - calculateAnnualSalary()
  - applyRaise(percentage)

**Test Cases:**
```
Input: 
Name: "John", ID: 101, Salary: 50000
Apply 10% raise

Output:
Name: John
Employee ID: 101
Monthly Salary: 50000
Annual Salary: 600000
After 10% raise: 55000
```

**Solution:**
```cpp
#include <iostream>
#include <string>
using namespace std;

class Employee {
private:
    string name;
    int employeeID;
    double salary;
    
public:
    void setDetails(string n, int id, double sal) {
        name = n;
        employeeID = id;
        salary = sal;
    }
    
    void displayDetails() {
        cout << "Name: " << name << endl;
        cout << "Employee ID: " << employeeID << endl;
        cout << "Monthly Salary: $" << salary << endl;
    }
    
    double calculateAnnualSalary() {
        return salary * 12;
    }
    
    void applyRaise(double percentage) {
        salary += salary * (percentage / 100.0);
        cout << "Raise applied! New salary: $" << salary << endl;
    }
};

int main() {
    Employee emp1;
    emp1.setDetails("John", 101, 50000);
    emp1.displayDetails();
    cout << "Annual Salary: $" << emp1.calculateAnnualSalary() << endl;
    emp1.applyRaise(10);
    
    return 0;
}
```

---

### Question 3: Shopping Cart System
**Problem:** Create a `Product` class and a `ShoppingCart` class:

**Product Class:**
- Private: productID, name, price, quantity
- Public: setDetails(), displayProduct(), getTotalPrice()

**ShoppingCart Class:**
- Store multiple products (use array or vector)
- Methods: addProduct(), removeProduct(), calculateTotal(), displayCart()

**Test Cases:**
```
Input:
Product 1: ID=1, Name="Laptop", Price=1000, Qty=1
Product 2: ID=2, Name="Mouse", Price=25, Qty=2

Output:
Cart Total: $1050
```

**Solution:**
```cpp
#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Product {
private:
    int productID;
    string name;
    double price;
    int quantity;
    
public:
    void setDetails(int id, string n, double p, int q) {
        productID = id;
        name = n;
        price = p;
        quantity = q;
    }
    
    void displayProduct() {
        cout << "ID: " << productID << " | " << name 
             << " | Price: $" << price 
             << " | Qty: " << quantity 
             << " | Total: $" << getTotalPrice() << endl;
    }
    
    double getTotalPrice() {
        return price * quantity;
    }
    
    int getID() {
        return productID;
    }
};

class ShoppingCart {
private:
    vector<Product> products;
    
public:
    void addProduct(Product p) {
        products.push_back(p);
        cout << "Product added to cart!" << endl;
    }
    
    void removeProduct(int productID) {
        for (size_t i = 0; i < products.size(); i++) {
            if (products[i].getID() == productID) {
                products.erase(products.begin() + i);
                cout << "Product removed from cart!" << endl;
                return;
            }
        }
        cout << "Product not found!" << endl;
    }
    
    double calculateTotal() {
        double total = 0;
        for (size_t i = 0; i < products.size(); i++) {
            total += products[i].getTotalPrice();
        }
        return total;
    }
    
    void displayCart() {
        cout << "\n===== Shopping Cart =====" << endl;
        if (products.empty()) {
            cout << "Cart is empty!" << endl;
        } else {
            for (size_t i = 0; i < products.size(); i++) {
                products[i].displayProduct();
            }
            cout << "-------------------------" << endl;
            cout << "Total: $" << calculateTotal() << endl;
        }
        cout << "=========================" << endl;
    }
};

int main() {
    ShoppingCart cart;
    
    Product p1, p2, p3;
    p1.setDetails(1, "Laptop", 1000, 1);
    p2.setDetails(2, "Mouse", 25, 2);
    p3.setDetails(3, "Keyboard", 75, 1);
    
    cart.addProduct(p1);
    cart.addProduct(p2);
    cart.addProduct(p3);
    
    cart.displayCart();
    
    cart.removeProduct(2);
    cart.displayCart();
    
    return 0;
}
```

---

### Question 4: Temperature Converter
**Problem:** Create a `Temperature` class that:
- Stores temperature in Celsius
- Converts to Fahrenheit: F = (C × 9/5) + 32
- Converts to Kelvin: K = C + 273.15
- Compares two temperatures

**Test Cases:**
```
Input: celsius = 25
Output:
Celsius: 25°C
Fahrenheit: 77°F
Kelvin: 298.15K
```

**Solution:**
```cpp
#include <iostream>
using namespace std;

class Temperature {
private:
    double celsius;
    
public:
    void setCelsius(double c) {
        celsius = c;
    }
    
    double getCelsius() {
        return celsius;
    }
    
    double toFahrenheit() {
        return (celsius * 9.0 / 5.0) + 32;
    }
    
    double toKelvin() {
        return celsius + 273.15;
    }
    
    void display() {
        cout << "Celsius: " << celsius << "°C" << endl;
        cout << "Fahrenheit: " << toFahrenheit() << "°F" << endl;
        cout << "Kelvin: " << toKelvin() << "K" << endl;
    }
    
    bool isGreaterThan(Temperature other) {
        return celsius > other.celsius;
    }
};

int main() {
    Temperature t1, t2;
    
    t1.setCelsius(25);
    t2.setCelsius(30);
    
    cout << "Temperature 1:" << endl;
    t1.display();
    
    cout << "\nTemperature 2:" << endl;
    t2.display();
    
    if (t2.isGreaterThan(t1)) {
        cout << "\nTemperature 2 is greater than Temperature 1" << endl;
    }
    
    return 0;
}
```

---

### Question 5: Library Management System
**Problem:** Create a complete library system with:
- `Book` class: title, author, ISBN, availability status
- `Member` class: memberID, name, borrowed books list
- Methods to borrow, return, and search books

**Test Cases:**
```
Input:
Book: "C++ Programming", "Bjarne Stroustrup", "ISBN123"
Member: ID=1, Name="Alice"
Action: Borrow book

Output:
Book borrowed successfully!
Member Alice has 1 book(s).
```

**Solution:**
```cpp
#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Book {
private:
    string title;
    string author;
    string ISBN;
    bool isAvailable;
    
public:
    void setDetails(string t, string a, string isbn) {
        title = t;
        author = a;
        ISBN = isbn;
        isAvailable = true;
    }
    
    string getISBN() {
        return ISBN;
    }
    
    string getTitle() {
        return title;
    }
    
    bool checkAvailability() {
        return isAvailable;
    }
    
    bool borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        }
        return false;
    }
    
    void returnBook() {
        isAvailable = true;
    }
    
    void displayInfo() {
        cout << "Title: " << title << endl;
        cout << "Author: " << author << endl;
        cout << "ISBN: " << ISBN << endl;
        cout << "Status: " << (isAvailable ? "Available" : "Borrowed") << endl;
    }
};

class Member {
private:
    int memberID;
    string name;
    vector<string> borrowedBooks;  // Store ISBNs
    
public:
    void setDetails(int id, string n) {
        memberID = id;
        name = n;
    }
    
    string getName() {
        return name;
    }
    
    bool borrowBook(Book &book) {
        if (book.borrowBook()) {
            borrowedBooks.push_back(book.getISBN());
            cout << "Book borrowed successfully!" << endl;
            return true;
        } else {
            cout << "Book is not available!" << endl;
            return false;
        }
    }
    
    void returnBook(Book &book) {
        string isbn = book.getISBN();
        for (size_t i = 0; i < borrowedBooks.size(); i++) {
            if (borrowedBooks[i] == isbn) {
                borrowedBooks.erase(borrowedBooks.begin() + i);
                book.returnBook();
                cout << "Book returned successfully!" << endl;
                return;
            }
        }
        cout << "This book was not borrowed by this member!" << endl;
    }
    
    void displayInfo() {
        cout << "\nMember ID: " << memberID << endl;
        cout << "Name: " << name << endl;
        cout << "Books Borrowed: " << borrowedBooks.size() << endl;
    }
};

int main() {
    Book book1, book2;
    book1.setDetails("C++ Programming", "Bjarne Stroustrup", "ISBN123");
    book2.setDetails("Data Structures", "Mark Allen Weiss", "ISBN456");
    
    Member member1;
    member1.setDetails(1, "Alice");
    
    cout << "=== Initial Book Status ===" << endl;
    book1.displayInfo();
    
    cout << "\n=== Borrowing Book ===" << endl;
    member1.borrowBook(book1);
    member1.displayInfo();
    
    cout << "\n=== Book Status After Borrowing ===" << endl;
    book1.displayInfo();
    
    cout << "\n=== Returning Book ===" << endl;
    member1.returnBook(book1);
    member1.displayInfo();
    
    cout << "\n=== Book Status After Returning ===" << endl;
    book1.displayInfo();
    
    return 0;
}
```

---

## Summary

**Key Takeaways:**
1. ✅ Class is a blueprint; Object is an instance
2. ✅ Use access specifiers to control data access
3. ✅ Encapsulation protects data integrity
4. ✅ Member functions provide controlled access to data
5. ✅ Multiple objects can be created from one class
6. ✅ Each object has its own copy of data members

**Next Topic:** Constructors and Types of Constructors

---

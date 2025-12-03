# Complete Object-Oriented Programming (OOP) Guide
## From Basic to Advanced Level

---

## Table of Contents
1. [Class & Object](#1-class--object)
2. [Constructor & Types](#2-constructor--types)
3. [Destructor / Finalizers](#3-destructor--finalizers)
4. [Encapsulation](#4-encapsulation)
5. [Data Hiding](#5-data-hiding)
6. [Abstraction](#6-abstraction)
7. [Inheritance](#7-inheritance)
8. [Polymorphism](#8-polymorphism)
9. [Method Overloading & Overriding](#9-method-overloading--overriding)
10. [super & this Keywords](#10-super--this-keywords)
11. [Static vs Non-static](#11-static-vs-non-static)
12. [Final Keyword](#12-final-keyword)
13. [Access Modifiers](#13-access-modifiers)
14. [Interfaces & Abstract Classes](#14-interfaces--abstract-classes)
15. [Packages and Modules](#15-packages-and-modules)
16. [Object Class Methods](#16-object-class-methods)
17. [Composition vs Aggregation](#17-composition-vs-aggregation)
18. [Association](#18-association)
19. [Cohesion & Coupling](#19-cohesion--coupling)
20. [SOLID Principles](#20-solid-principles)

---

## 1. Class & Object

### Real-Life Meaning
A **Class** is a blueprint or template (like a car design blueprint).  
An **Object** is an actual instance created from that blueprint (like a real car manufactured from the design).

**Example**: "Car" is a class. "My Tesla Model 3" is an object.

### Why & Where Used
- **Reusability**: Write once, create multiple objects
- **Organization**: Group related data and behavior
- **Real-world modeling**: Represent entities like User, Product, Order
- **Used in**: Every OOP application - web apps, games, enterprise software

### Syntax & Explanation

**C++ Syntax:**
```cpp
class ClassName {
    // Data members (attributes)
    // Member functions (methods)
};
```

**Java Syntax:**
```java
class ClassName {
    // Fields (attributes)
    // Methods
}
```

### Simple Example

```cpp
#include <iostream>
#include <string>
using namespace std;

class Car {
public:
    string brand;
    string model;
    int year;
    
    void displayInfo() {
        cout << year << " " << brand << " " << model << endl;
    }
};

int main() {
    // Creating objects
    Car car1;
    car1.brand = "Tesla";
    car1.model = "Model 3";
    car1.year = 2023;
    
    Car car2;
    car2.brand = "BMW";
    car2.model = "X5";
    car2.year = 2022;
    
    car1.displayInfo();  // Output: 2023 Tesla Model 3
    car2.displayInfo();  // Output: 2022 BMW X5
    
    return 0;
}
```

### Advanced Example

```cpp
#include <iostream>
#include <string>
#include <vector>
using namespace std;

class BankAccount {
private:
    string accountNumber;
    string holderName;
    double balance;
    vector<string> transactionHistory;
    
public:
    BankAccount(string accNum, string name, double initialBalance) {
        accountNumber = accNum;
        holderName = name;
        balance = initialBalance;
        transactionHistory.push_back("Account opened with balance: $" + to_string(initialBalance));
    }
    
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.push_back("Deposited: $" + to_string(amount));
            cout << "Deposited: $" << amount << endl;
        }
    }
    
    bool withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.push_back("Withdrawn: $" + to_string(amount));
            cout << "Withdrawn: $" << amount << endl;
            return true;
        }
        cout << "Insufficient funds!" << endl;
        return false;
    }
    
    void displayBalance() {
        cout << "Account: " << accountNumber << " | Balance: $" << balance << endl;
    }
    
    void showTransactionHistory() {
        cout << "\n--- Transaction History for " << holderName << " ---" << endl;
        for (const string& transaction : transactionHistory) {
            cout << transaction << endl;
        }
    }
};

int main() {
    BankAccount acc1("ACC001", "John Doe", 1000.0);
    BankAccount acc2("ACC002", "Jane Smith", 500.0);
    
    acc1.deposit(500);
    acc1.withdraw(200);
    acc1.displayBalance();
    acc1.showTransactionHistory();
    
    cout << "\n";
    
    acc2.deposit(1000);
    acc2.withdraw(2000);  // Will fail
    acc2.displayBalance();
    
    return 0;
}
```

### Interview Questions & Answers

**Q1: What is the difference between a class and an object?**  
**A:** A class is a blueprint/template that defines properties and behaviors. An object is an instance of a class that occupies memory and has actual values.

**Q2: Can we have a class without any objects?**  
**A:** Yes, a class can exist without objects. It's just a definition. Objects are created when needed.

**Q3: How many objects can be created from a single class?**  
**A:** Unlimited objects can be created from a single class (limited only by available memory).

**Q4: What happens in memory when an object is created?**  
**A:** Memory is allocated on the heap (for dynamic) or stack (for static). The object's data members get memory, and the constructor is called.

**Q5: Can a class be a member of another class?**  
**A:** Yes, this is called composition. A class can have objects of other classes as its members.

### Problem-Solving Approach

1. **Identify entities** in the problem (nouns → classes)
2. **Identify attributes** (what properties does the entity have?)
3. **Identify behaviors** (what actions can it perform?)
4. **Define relationships** between classes
5. **Implement and test** with objects

### Practice Questions

**Q1: Student Management System**  
Create a `Student` class with name, roll number, and marks in 3 subjects. Include methods to calculate total and average marks.

**Test Cases:**
- Student("Alice", 101, 85, 90, 88) → Total: 263, Average: 87.67
- Student("Bob", 102, 70, 75, 80) → Total: 225, Average: 75.0

**Q2: Rectangle Class**  
Create a `Rectangle` class with length and width. Include methods for area, perimeter, and check if it's a square.

**Test Cases:**
- Rectangle(5, 5) → Area: 25, Perimeter: 20, IsSquare: true
- Rectangle(4, 6) → Area: 24, Perimeter: 20, IsSquare: false

**Q3: Book Library**  
Create a `Book` class with title, author, ISBN, and availability status. Include methods to borrow and return books.

**Test Cases:**
- Book("1984", "George Orwell", "123456") → Available: true
- After borrow() → Available: false
- After return() → Available: true

---

## 2. Constructor & Types

### Real-Life Meaning
A constructor is like an **initialization ceremony** when something is created. When a baby is born, it gets a name, birth date, etc. Similarly, when an object is created, the constructor initializes it.

### Why & Where Used
- **Automatic initialization**: No need to manually set values after creation
- **Ensure valid state**: Object is always in a valid state from creation
- **Resource allocation**: Allocate memory, open files, establish connections
- **Used in**: Every object creation in OOP

### Types of Constructors

1. **Default Constructor** - No parameters
2. **Parameterized Constructor** - Takes parameters
3. **Copy Constructor** - Creates object from another object
4. **Move Constructor** - Transfers resources (C++11+)

### Syntax & Explanation

```cpp
class ClassName {
public:
    // Default Constructor
    ClassName() {
        // Initialization code
    }
    
    // Parameterized Constructor
    ClassName(parameters) {
        // Initialization with parameters
    }
    
    // Copy Constructor
    ClassName(const ClassName& obj) {
        // Copy data from obj
    }
};
```

### Simple Example

```cpp
#include <iostream>
#include <string>
using namespace std;

class Person {
public:
    string name;
    int age;
    
    // Default Constructor
    Person() {
        name = "Unknown";
        age = 0;
        cout << "Default constructor called" << endl;
    }
    
    // Parameterized Constructor
    Person(string n, int a) {
        name = n;
        age = a;
        cout << "Parameterized constructor called" << endl;
    }
    
    // Copy Constructor
    Person(const Person& p) {
        name = p.name;
        age = p.age;
        cout << "Copy constructor called" << endl;
    }
    
    void display() {
        cout << "Name: " << name << ", Age: " << age << endl;
    }
};

int main() {
    Person p1;                    // Default constructor
    Person p2("Alice", 25);       // Parameterized constructor
    Person p3 = p2;               // Copy constructor
    
    p1.display();
    p2.display();
    p3.display();
    
    return 0;
}
```

### Advanced Example

```cpp
#include <iostream>
#include <string>
#include <cstring>
using namespace std;

class SmartString {
private:
    char* data;
    int length;
    
public:
    // Default Constructor
    SmartString() : data(nullptr), length(0) {
        cout << "Default constructor" << endl;
    }
    
    // Parameterized Constructor
    SmartString(const char* str) {
        length = strlen(str);
        data = new char[length + 1];
        strcpy(data, str);
        cout << "Parameterized constructor for: " << data << endl;
    }
    
    // Copy Constructor (Deep Copy)
    SmartString(const SmartString& other) {
        length = other.length;
        data = new char[length + 1];
        strcpy(data, other.data);
        cout << "Copy constructor (deep copy) for: " << data << endl;
    }
    
    // Move Constructor (C++11)
    SmartString(SmartString&& other) noexcept {
        data = other.data;
        length = other.length;
        other.data = nullptr;
        other.length = 0;
        cout << "Move constructor" << endl;
    }
    
    // Destructor
    ~SmartString() {
        if (data != nullptr) {
            cout << "Destructor called for: " << data << endl;
            delete[] data;
        }
    }
    
    void display() {
        if (data != nullptr) {
            cout << "String: " << data << ", Length: " << length << endl;
        } else {
            cout << "Empty string" << endl;
        }
    }
};

int main() {
    SmartString s1;                          // Default
    SmartString s2("Hello World");           // Parameterized
    SmartString s3 = s2;                     // Copy
    SmartString s4 = SmartString("Temp");    // Move (temporary object)
    
    s1.display();
    s2.display();
    s3.display();
    s4.display();
    
    return 0;
}
```

### Interview Questions & Answers

**Q1: What is a constructor?**  
**A:** A special member function with the same name as the class, automatically called when an object is created. It initializes the object.

**Q2: Can a constructor return a value?**  
**A:** No, constructors don't have a return type, not even void. They implicitly return the object being created.

**Q3: What is constructor overloading?**  
**A:** Having multiple constructors with different parameter lists in the same class.

**Q4: What is the difference between copy constructor and assignment operator?**  
**A:** Copy constructor creates a new object from an existing one. Assignment operator assigns values to an already existing object.

**Q5: What is a shallow copy vs deep copy?**  
**A:** Shallow copy copies pointer values (both point to same memory). Deep copy creates new memory and copies actual data.

**Q6: Can constructors be private?**  
**A:** Yes, used in Singleton pattern to prevent object creation from outside the class.

**Q7: What is constructor chaining?**  
**A:** Calling one constructor from another constructor using initialization lists or this() in Java.

### Problem-Solving Approach

1. **Identify initialization needs** - What data must be set when object is created?
2. **Choose constructor type** - Default, parameterized, or both?
3. **Handle resources** - Do you need deep copy for pointers/dynamic memory?
4. **Validate inputs** - Check parameters in parameterized constructors
5. **Use initialization lists** - More efficient than assignment in constructor body

### Practice Questions

**Q1: Employee Class with Multiple Constructors**  
Create an `Employee` class with default, parameterized (name, id, salary), and copy constructors.

**Test Cases:**
- Employee() → Name: "Unknown", ID: 0, Salary: 0.0
- Employee("John", 101, 50000) → Name: "John", ID: 101, Salary: 50000.0
- Copy from existing employee → All values copied

**Q2: Dynamic Array Class**  
Create a class that manages a dynamic integer array. Implement default, parameterized (size), and copy constructor with deep copy.

**Test Cases:**
- DynamicArray(5) → Array of size 5
- Copy constructor → Creates independent copy
- Modifying copy doesn't affect original

**Q3: Date Class**  
Create a `Date` class with day, month, year. Implement constructors with validation (e.g., month 1-12, day 1-31).

**Test Cases:**
- Date(15, 8, 2023) → Valid date
- Date(32, 13, 2023) → Should handle invalid input
- Date() → Current date or default (1, 1, 2000)

---

## 3. Destructor / Finalizers

### Real-Life Meaning
A destructor is like a **cleanup crew** that comes after an event ends. When a concert ends, the crew cleans up, turns off lights, locks doors. Similarly, a destructor cleans up when an object is destroyed.

### Why & Where Used
- **Resource cleanup**: Free memory, close files, release network connections
- **Prevent memory leaks**: Deallocate dynamically allocated memory
- **Release locks**: Release database connections, mutex locks
- **Used in**: Classes managing resources (files, memory, connections)

### Syntax & Explanation

**C++ Destructor:**
```cpp
class ClassName {
public:
    ~ClassName() {  // Destructor (same name with ~)
        // Cleanup code
    }
};
```

**Java Finalizer (deprecated, use try-with-resources):**
```java
protected void finalize() throws Throwable {
    // Cleanup code
    super.finalize();
}
```

### Simple Example

```cpp
#include <iostream>
using namespace std;

class Counter {
private:
    int id;
    static int objectCount;
    
public:
    Counter(int i) {
        id = i;
        objectCount++;
        cout << "Constructor: Object " << id << " created. Total objects: " << objectCount << endl;
    }
    
    ~Counter() {
        objectCount--;
        cout << "Destructor: Object " << id << " destroyed. Remaining objects: " << objectCount << endl;
    }
    
    static int getCount() {
        return objectCount;
    }
};

int Counter::objectCount = 0;

int main() {
    cout << "Creating objects..." << endl;
    Counter c1(1);
    Counter c2(2);
    {
        Counter c3(3);  // Block scope
        cout << "Inside block. Total: " << Counter::getCount() << endl;
    }  // c3 destroyed here
    
    cout << "Outside block. Total: " << Counter::getCount() << endl;
    
    return 0;  // c1 and c2 destroyed here
}
```

### Advanced Example

```cpp
#include <iostream>
#include <fstream>
#include <string>
using namespace std;

class FileHandler {
private:
    string filename;
    fstream file;
    bool isOpen;
    
public:
    FileHandler(const string& fname) : filename(fname), isOpen(false) {
        cout << "Constructor: FileHandler created for " << filename << endl;
    }
    
    bool openFile(ios::openmode mode) {
        file.open(filename, mode);
        isOpen = file.is_open();
        if (isOpen) {
            cout << "File opened: " << filename << endl;
        } else {
            cout << "Failed to open: " << filename << endl;
        }
        return isOpen;
    }
    
    void writeData(const string& data) {
        if (isOpen) {
            file << data << endl;
            cout << "Data written to file" << endl;
        }
    }
    
    void readData() {
        if (isOpen) {
            string line;
            cout << "Reading from file:" << endl;
            while (getline(file, line)) {
                cout << line << endl;
            }
        }
    }
    
    ~FileHandler() {
        if (isOpen && file.is_open()) {
            file.close();
            cout << "Destructor: File closed: " << filename << endl;
        }
        cout << "Destructor: FileHandler destroyed for " << filename << endl;
    }
};

class DatabaseConnection {
private:
    string connectionString;
    bool connected;
    
public:
    DatabaseConnection(const string& connStr) : connectionString(connStr), connected(false) {
        cout << "Constructor: Attempting to connect to database..." << endl;
        // Simulate connection
        connected = true;
        cout << "Connected to: " << connectionString << endl;
    }
    
    void executeQuery(const string& query) {
        if (connected) {
            cout << "Executing query: " << query << endl;
        }
    }
    
    ~DatabaseConnection() {
        if (connected) {
            cout << "Destructor: Closing database connection..." << endl;
            connected = false;
            cout << "Database connection closed" << endl;
        }
    }
};

int main() {
    cout << "=== File Handler Example ===" << endl;
    {
        FileHandler fh("test.txt");
        fh.openFile(ios::out);
        fh.writeData("Hello, World!");
        fh.writeData("Destructor will close this file automatically");
    }  // FileHandler destructor called here
    
    cout << "\n=== Database Connection Example ===" << endl;
    {
        DatabaseConnection db("localhost:3306/mydb");
        db.executeQuery("SELECT * FROM users");
    }  // DatabaseConnection destructor called here
    
    cout << "\nProgram ending..." << endl;
    return 0;
}
```

### Interview Questions & Answers

**Q1: What is a destructor?**  
**A:** A special member function called automatically when an object is destroyed. It has the same name as the class with a tilde (~) prefix.

**Q2: Can a destructor be overloaded?**  
**A:** No, a class can have only one destructor. It takes no parameters and has no return type.

**Q3: When is a destructor called?**  
**A:** When an object goes out of scope, is explicitly deleted (delete keyword), or when the program terminates.

**Q4: Can a destructor be virtual?**  
**A:** Yes, and it should be virtual in base classes to ensure proper cleanup in inheritance hierarchies.

**Q5: What is the order of destructor calls in inheritance?**  
**A:** Destructors are called in reverse order of constructors: derived class destructor first, then base class destructor.

**Q6: Can you call a destructor explicitly?**  
**A:** Yes, but it's rarely needed. Syntax: `obj.~ClassName();` Used mainly with placement new.

**Q7: What's the difference between destructor and finalizer?**  
**A:** Destructor (C++) is deterministic and called immediately. Finalizer (Java) is non-deterministic, called by garbage collector.

### Problem-Solving Approach

1. **Identify resources** - What needs cleanup? (memory, files, connections)
2. **Implement destructor** - Free all allocated resources
3. **Follow RAII** - Resource Acquisition Is Initialization principle
4. **Make virtual** - If class is meant to be inherited
5. **Test cleanup** - Verify no memory leaks using tools (valgrind, sanitizers)

### Practice Questions

**Q1: Dynamic Memory Management**  
Create a class that allocates an array dynamically in constructor and deallocates in destructor. Track memory allocation/deallocation.

**Test Cases:**
- Create object with array size 100
- Verify memory is allocated
- Object goes out of scope
- Verify memory is deallocated (no leaks)

**Q2: Resource Manager**  
Create a class managing multiple resources (file + network connection). Ensure both are properly closed in destructor.

**Test Cases:**
- Open file and connection
- Perform operations
- Object destroyed
- Verify both resources are released

**Q3: Object Counter**  
Create a class with static counter tracking total objects. Increment in constructor, decrement in destructor.

**Test Cases:**
- Create 5 objects → Counter: 5
- 2 objects go out of scope → Counter: 3
- All destroyed → Counter: 0

---

## 4. Encapsulation

### Real-Life Meaning
Encapsulation is like a **capsule medicine** - the medicine (data) is wrapped inside a protective coating (class). You don't need to know what's inside; you just take it. Similarly, encapsulation wraps data and methods together, hiding internal details.

Another example: A **TV remote** - you press buttons (public interface) without knowing the internal circuitry (private implementation).

### Why & Where Used
- **Data protection**: Prevent unauthorized access and modification
- **Controlled access**: Provide getters/setters with validation
- **Flexibility**: Change internal implementation without affecting external code
- **Maintainability**: Easier to modify and debug
- **Used in**: Banking systems, user authentication, API design

### Syntax & Explanation

```cpp
class ClassName {
private:
    // Private data members (hidden from outside)
    int privateData;
    
public:
    // Public methods (interface to interact)
    void setData(int value) {
        // Validation logic
        privateData = value;
    }
    
    int getData() {
        return privateData;
    }
};
```

### Simple Example

```cpp
#include <iostream>
#include <string>
using namespace std;

class BankAccount {
private:
    string accountNumber;
    double balance;
    
public:
    BankAccount(string accNum, double initialBalance) {
        accountNumber = accNum;
        balance = initialBalance;
    }
    
    // Getter
    double getBalance() {
        return balance;
    }
    
    // Setter with validation
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            cout << "Deposited: $" << amount << endl;
        } else {
            cout << "Invalid deposit amount!" << endl;
        }
    }
    
    bool withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            cout << "Withdrawn: $" << amount << endl;
            return true;
        }
        cout << "Invalid withdrawal!" << endl;
        return false;
    }
};

int main() {
    BankAccount account("ACC123", 1000.0);
    
    // Can't access balance directly: account.balance = 5000; // ERROR
    
    // Must use public methods
    cout << "Initial Balance: $" << account.getBalance() << endl;
    account.deposit(500);
    account.withdraw(200);
    cout << "Final Balance: $" << account.getBalance() << endl;
    
    // Validation prevents invalid operations
    account.deposit(-100);   // Rejected
    account.withdraw(2000);  // Rejected
    
    return 0;
}
```

### Advanced Example

```cpp
#include <iostream>
#include <string>
#include <regex>
using namespace std;

class User {
private:
    string username;
    string email;
    string password;  // Encrypted in real applications
    int age;
    bool isActive;
    
    // Private helper method
    bool isValidEmail(const string& email) {
        regex emailPattern(R"([a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,})");
        return regex_match(email, emailPattern);
    }
    
    bool isValidPassword(const string& pwd) {
        // At least 8 characters, 1 uppercase, 1 lowercase, 1 digit
        if (pwd.length() < 8) return false;
        bool hasUpper = false, hasLower = false, hasDigit = false;
        for (char c : pwd) {
            if (isupper(c)) hasUpper = true;
            if (islower(c)) hasLower = true;
            if (isdigit(c)) hasDigit = true;
        }
        return hasUpper && hasLower && hasDigit;
    }
    
public:
    User(string uname, string mail, string pwd, int userAge) {
        username = uname;
        setEmail(mail);
        setPassword(pwd);
        setAge(userAge);
        isActive = true;
    }
    
    // Getters
    string getUsername() const { return username; }
    string getEmail() const { return email; }
    int getAge() const { return age; }
    bool getActiveStatus() const { return isActive; }
    
    // Setters with validation
    bool setEmail(const string& newEmail) {
        if (isValidEmail(newEmail)) {
            email = newEmail;
            cout << "Email updated successfully" << endl;
            return true;
        }
        cout << "Invalid email format!" << endl;
        return false;
    }
    
    bool setPassword(const string& newPassword) {
        if (isValidPassword(newPassword)) {
            password = newPassword;  // Should be encrypted
            cout << "Password updated successfully" << endl;
            return true;
        }
        cout << "Password must be 8+ chars with uppercase, lowercase, and digit!" << endl;
        return false;
    }
    
    bool setAge(int newAge) {
        if (newAge >= 13 && newAge <= 120) {
            age = newAge;
            return true;
        }
        cout << "Age must be between 13 and 120!" << endl;
        return false;
    }
    
    void deactivateAccount() {
        isActive = false;
        cout << "Account deactivated" << endl;
    }
    
    void activateAccount() {
        isActive = true;
        cout << "Account activated" << endl;
    }
    
    void displayInfo() {
        cout << "\n--- User Info ---" << endl;
        cout << "Username: " << username << endl;
        cout << "Email: " << email << endl;
        cout << "Age: " << age << endl;
        cout << "Status: " << (isActive ? "Active" : "Inactive") << endl;
    }
};

int main() {
    User user1("john_doe", "john@example.com", "SecurePass123", 25);
    user1.displayInfo();
    
    // Try invalid operations
    user1.setEmail("invalid-email");      // Rejected
    user1.setPassword("weak");            // Rejected
    user1.setAge(10);                     // Rejected
    
    // Valid operations
    user1.setEmail("john.doe@newmail.com");
    user1.setPassword("NewSecure456");
    user1.setAge(26);
    
    user1.displayInfo();
    
    return 0;
}
```

### Interview Questions & Answers

**Q1: What is encapsulation?**  
**A:** Encapsulation is bundling data (variables) and methods that operate on that data within a single unit (class), and restricting direct access to some components.

**Q2: How is encapsulation different from abstraction?**  
**A:** Encapsulation is about data hiding and bundling. Abstraction is about hiding complexity and showing only essential features.

**Q3: What are the benefits of encapsulation?**  
**A:** Data protection, controlled access, flexibility to change implementation, better maintainability, and modularity.

**Q4: How do you achieve encapsulation in C++?**  
**A:** Use private/protected access modifiers for data members and provide public getter/setter methods.

**Q5: Can we have a class without encapsulation?**  
**A:** Yes, if all members are public. But it's bad practice as it exposes internal implementation.

**Q6: What is the role of getters and setters?**  
**A:** Getters provide controlled read access. Setters provide controlled write access with validation logic.

### Problem-Solving Approach

1. **Identify sensitive data** - What should be hidden?
2. **Make data private** - Use private access modifier
3. **Create public interface** - Provide necessary getters/setters
4. **Add validation** - Validate inputs in setters
5. **Document interface** - Clear documentation for public methods

### Practice Questions

**Q1: Temperature Class**  
Create a `Temperature` class that stores temperature in Celsius (private). Provide methods to get/set in Celsius, Fahrenheit, and Kelvin with validation.

**Test Cases:**
- setCelsius(25) → Valid
- setCelsius(-300) → Invalid (below absolute zero)
- getFahrenheit() → Returns 77
- setFahrenheit(32) → Sets Celsius to 0

**Q2: Product Class**  
Create a `Product` class with private fields: name, price, quantity. Implement validation: price > 0, quantity >= 0, name not empty.

**Test Cases:**
- Product("Laptop", 999.99, 10) → Valid
- setPrice(-50) → Rejected
- setQuantity(-5) → Rejected
- updateStock(5) → Adds to quantity

**Q3: Date Class with Validation**  
Create a `Date` class with private day, month, year. Validate dates (consider leap years).

**Test Cases:**
- Date(29, 2, 2024) → Valid (leap year)
- Date(29, 2, 2023) → Invalid
- Date(31, 4, 2023) → Invalid (April has 30 days)
- setMonth(13) → Rejected

---

## 5. Data Hiding

### Real-Life Meaning
Data hiding is like keeping your **password private**. You don't share it with anyone; you only use it when needed. Similarly, data hiding restricts access to class members to prevent misuse.

Another example: **ATM machine** - you can't access the cash directly; you must use the interface (card, PIN, buttons).

### Why & Where Used
- **Security**: Protect sensitive information
- **Integrity**: Prevent invalid state changes
- **Reduce complexity**: Hide implementation details
- **Prevent accidental modification**: Users can't break internal state
- **Used in**: Security systems, financial applications, frameworks

### Syntax & Explanation

Data hiding is achieved using **access modifiers**:
- `private`: Accessible only within the class
- `protected`: Accessible within class and derived classes
- `public`: Accessible from anywhere

```cpp
class ClassName {
private:
    int hiddenData;  // Hidden from outside
    
protected:
    int protectedData;  // Hidden from outside, visible to derived classes
    
public:
    void accessData() {
        // Can access hiddenData here
    }
};
```

### Simple Example

```cpp
#include <iostream>
#include <string>
using namespace std;

class CreditCard {
private:
    string cardNumber;      // Hidden - sensitive data
    string cvv;             // Hidden - sensitive data
    string pin;             // Hidden - sensitive data
    double balance;         // Hidden
    
public:
    CreditCard(string number, string cardCVV, string cardPIN, double initialBalance) {
        cardNumber = number;
        cvv = cardCVV;
        pin = cardPIN;
        balance = initialBalance;
    }
    
    // Public interface - doesn't expose sensitive data
    bool makePayment(double amount, string enteredPIN) {
        if (enteredPIN != pin) {
            cout << "Invalid PIN!" << endl;
            return false;
        }
        
        if (amount > balance) {
            cout << "Insufficient balance!" << endl;
            return false;
        }
        
        balance -= amount;
        cout << "Payment of $" << amount << " successful" << endl;
        return true;
    }
    
    // Shows masked card number
    string getMaskedCardNumber() {
        return "****-****-****-" + cardNumber.substr(cardNumber.length() - 4);
    }
    
    double getBalance(string enteredPIN) {
        if (enteredPIN == pin) {
            return balance;
        }
        cout << "Invalid PIN!" << endl;
        return -1;
    }
};

int main() {
    CreditCard card("1234567890123456", "123", "9876", 5000.0);
    
    // Cannot access: card.cardNumber, card.cvv, card.pin, card.balance
    // This is data hiding in action!
    
    cout << "Card: " << card.getMaskedCardNumber() << endl;
    
    card.makePayment(100, "9876");   // Correct PIN
    card.makePayment(200, "0000");   // Wrong PIN
    
    cout << "Balance: $" << card.getBalance("9876") << endl;
    
    return 0;
}
```

### Advanced Example

```cpp
#include <iostream>
#include <string>
#include <vector>
#include <ctime>
using namespace std;

class SecureVault {
private:
    struct AccessLog {
        string timestamp;
        string action;
        bool success;
    };
    
    string masterPassword;
    vector<string> secrets;
    vector<AccessLog> accessLogs;
    int failedAttempts;
    bool isLocked;
    
    // Private helper methods
    string getCurrentTimestamp() {
        time_t now = time(0);
        char* dt = ctime(&now);
        string timestamp(dt);
        timestamp.pop_back();  // Remove newline
        return timestamp;
    }
    
    void logAccess(string action, bool success) {
        AccessLog log;
        log.timestamp = getCurrentTimestamp();
        log.action = action;
        log.success = success;
        accessLogs.push_back(log);
    }
    
    void lockVault() {
        isLocked = true;
        cout << "⚠️ VAULT LOCKED due to multiple failed attempts!" << endl;
        logAccess("Vault locked", true);
    }
    
public:
    SecureVault(string password) {
        masterPassword = password;
        failedAttempts = 0;
        isLocked = false;
        logAccess("Vault created", true);
    }
    
    bool authenticate(string password) {
        if (isLocked) {
            cout << "Vault is locked! Contact administrator." << endl;
            return false;
        }
        
        if (password == masterPassword) {
            failedAttempts = 0;
            logAccess("Authentication successful", true);
            return true;
        } else {
            failedAttempts++;
            logAccess("Authentication failed", false);
            
            if (failedAttempts >= 3) {
                lockVault();
            } else {
                cout << "Wrong password! Attempts remaining: " << (3 - failedAttempts) << endl;
            }
            return false;
        }
    }
    
    bool addSecret(string password, string secret) {
        if (!authenticate(password)) return false;
        
        secrets.push_back(secret);
        cout << "Secret added successfully" << endl;
        logAccess("Secret added", true);
        return true;
    }
    
    void viewSecrets(string password) {
        if (!authenticate(password)) return;
        
        cout << "\n=== Vault Secrets ===" << endl;
        for (size_t i = 0; i < secrets.size(); i++) {
            cout << (i + 1) << ". " << secrets[i] << endl;
        }
        logAccess("Secrets viewed", true);
    }
    
    void viewAccessLogs(string password) {
        if (!authenticate(password)) return;
        
        cout << "\n=== Access Logs ===" << endl;
        for (const auto& log : accessLogs) {
            cout << "[" << log.timestamp << "] " << log.action 
                 << " - " << (log.success ? "SUCCESS" : "FAILED") << endl;
        }
    }
    
    bool changePassword(string oldPassword, string newPassword) {
        if (!authenticate(oldPassword)) return false;
        
        masterPassword = newPassword;
        cout << "Password changed successfully" << endl;
        logAccess("Password changed", true);
        return true;
    }
};

int main() {
    SecureVault vault("MySecurePass123");
    
    // Correct password
    vault.addSecret("MySecurePass123", "Secret Document 1");
    vault.addSecret("MySecurePass123", "API Key: abc123xyz");
    vault.viewSecrets("MySecurePass123");
    
    cout << "\n--- Attempting wrong passwords ---" << endl;
    vault.viewSecrets("wrong1");
    vault.viewSecrets("wrong2");
    vault.viewSecrets("wrong3");  // This will lock the vault
    
    // Vault is now locked
    vault.viewSecrets("MySecurePass123");  // Won't work even with correct password
    
    cout << "\n--- Creating new vault ---" << endl;
    SecureVault vault2("NewPassword456");
    vault2.addSecret("NewPassword456", "Another secret");
    vault2.changePassword("NewPassword456", "UpdatedPass789");
    vault2.viewSecrets("UpdatedPass789");
    vault2.viewAccessLogs("UpdatedPass789");
    
    return 0;
}
```

### Interview Questions & Answers

**Q1: What is data hiding?**  
**A:** Data hiding is restricting access to class members (data) from outside the class using access modifiers, exposing only necessary interfaces.

**Q2: How is data hiding different from encapsulation?**  
**A:** Data hiding is a subset of encapsulation. Encapsulation bundles data and methods; data hiding specifically restricts access to data.

**Q3: Why is data hiding important?**  
**A:** It ensures data integrity, prevents unauthorized access, reduces coupling, and makes code more maintainable and secure.

**Q4: Can we achieve data hiding without encapsulation?**  
**A:** No, data hiding is achieved through encapsulation using access modifiers.

**Q5: What happens if we make all members public?**  
**A:** No data hiding occurs. Anyone can modify data directly, leading to potential bugs, security issues, and tight coupling.

**Q6: How does data hiding improve security?**  
**A:** Sensitive data (passwords, keys) can't be accessed directly. Access is controlled through validated public methods.

### Problem-Solving Approach

1. **Identify sensitive data** - What should be hidden?
2. **Make it private** - Use private access modifier
3. **Create controlled access** - Public methods with validation
4. **Add authentication** - Verify user before allowing access
5. **Log access attempts** - Track who accessed what and when

### Practice Questions

**Q1: Secure Login System**  
Create a `LoginSystem` class that hides username and password. Provide login method with attempt limiting (3 attempts).

**Test Cases:**
- login("admin", "correct") → Success
- login("admin", "wrong") 3 times → Account locked
- After lock, even correct password fails

**Q2: Salary Management**  
Create an `Employee` class where salary is hidden. Only HR role can view/modify salary.

**Test Cases:**
- Employee("John", 50000)
- getSalary("HR") → Returns 50000
- getSalary("Manager") → Access denied
- setSalary(60000, "HR") → Success
- setSalary(60000, "Employee") → Access denied

**Q3: Medical Records**  
Create a `MedicalRecord` class hiding patient data. Access requires both patient ID and doctor authorization code.

**Test Cases:**
- viewRecord(patientID, doctorCode) → Shows data if both valid
- viewRecord(patientID, wrongCode) → Access denied
- Track all access attempts with timestamps

---

*[Continuing with remaining concepts... Due to length, I'll create this as a comprehensive document. Would you like me to continue with the remaining concepts (6-20)?]*

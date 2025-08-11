# Market Product Management System & Custom Data Structures in Java

## Overview

This repository contains two interrelated Java projects developed as part of an academic exercise in software engineering and data structures. The first component, **Market Product Management**, implements a graphical supermarket management system using Java's built-in Collections Framework and Swing for the user interface. The second component, **Own Implementation Data Structures & Algorithms**, comprises custom-built data structures and algorithms implemented from first principles, subsequently integrated into the market management system to replace or supplement Java's standard library structures.

The dual structure of this project demonstrates proficiency in both high-level Java development using established frameworks and low-level algorithmic and data structure design, with explicit attention to algorithmic complexity and computational efficiency.

---

## 1. Market Product Management – Java Framework

**Purpose:**  
To design and implement a supermarket product management system capable of performing product registration, retrieval, searching, sorting, and display operations within a graphical interface.

**Technologies & Libraries:**  
- **Java Collections Framework** (`ArrayList`, `HashMap`)
- **Swing** for GUI components and event handling
- **Java SE** for core programming constructs

**Core Functionalities:**
- **Product Management:** Add, edit, and remove products with attributes such as name, category, price, and quantity.
- **Search Functionality:** Implemented using both built-in and custom algorithms for product lookup by name or category.
- **Sorting Mechanisms:** Products can be sorted by price, quantity, or alphabetical order using custom comparators and algorithmic logic.
- **Graphical Interface:** Swing-based UI for interactive product management, ensuring ease of use for non-technical users.
- **MVC-style Architecture:** Separation between the product model (`Product.java`), management logic (`MarketManager.java`), and user interface (`SupermarketGUI.java`).

**Representative File Descriptions:**
- `Product.java` – Defines the data model for supermarket products, including getters, setters, and comparison methods.
- `MarketManager.java` – Central controller managing product operations and acting as a bridge between the data model and the GUI.
- `SupermarketGUI.java` – Swing-based interface with menus, search fields, and action listeners.
- `Activities.java` – Implements core operational methods, including custom search and sort algorithms.
- `TestMarketSystem.java` – Entry point for launching the application.

---

## 2. Own Implementation Data Structures & Algorithms

**Purpose:**  
To implement fundamental data structures from scratch in Java and apply them in a practical system, allowing for a deeper understanding of algorithmic efficiency and memory management.

**Implemented Structures:**
- `CustomArrayList.java` – A dynamic array implementation mimicking Java’s `ArrayList`, including capacity management and element manipulation.
- `CustomHashMap.java` – A key–value storage structure implementing basic hashing and collision resolution mechanisms.

**Algorithmic Components:**
- **Search Algorithms:** Linear search for unsorted collections; binary search for sorted lists.
- **Sorting Algorithms:** Selection sort, insertion sort, and other iterative comparison-based approaches.
- **Big O Analysis:** Each algorithm is documented and evaluated for time and space complexity, allowing comparison to Java’s built-in equivalents.

**Pedagogical Value:**
This section reinforces theoretical knowledge from data structures and algorithms coursework by translating abstract concepts into functional Java code. The integration with the supermarket management system serves as a case study in replacing high-level library calls with custom implementations, observing changes in performance and maintainability.

---

## 3. System Architecture

The system adheres to an **MVC (Model–View–Controller)** pattern:
- **Model:** `Product` and data storage classes (`CustomArrayList`, `CustomHashMap`).
- **View:** `SupermarketGUI` for user interaction.
- **Controller:** `MarketManager` and `Activities`, orchestrating operations between model and view.

---

## 4. Academic Relevance

This project fulfills multiple academic learning objectives:
1. **Application of Object-Oriented Principles:** Encapsulation, abstraction, inheritance, and polymorphism.
2. **Algorithmic Thinking:** Custom design of algorithms with explicit complexity analysis.
3. **Software Engineering Practices:** Modular code design, separation of concerns, and user interface integration.
4. **Bridging Theory and Practice:** Applying foundational computer science concepts in a real-world inspired scenario.

---

## 5. How to Run

1. Compile all `.java` files in both project folders.
2. Ensure the classpath includes both the **Market Product Management** and **Own Implementation Data Structures** packages.
3. Run the `TestMarketSystem` class to launch the GUI.

---

## 6. Conclusion

By combining the use of Java’s Collections Framework with self-implemented data structures and algorithms, this project demonstrates a comprehensive understanding of both high-level software development and low-level algorithmic design. It serves as both a functional supermarket management application and a pedagogical tool for exploring the trade-offs between library-based and custom-coded solutions.

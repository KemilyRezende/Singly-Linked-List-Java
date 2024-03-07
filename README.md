# Description:

This project provides a comprehensive explanation and implementation of a Singly Linked List in Java. It covers the core concepts, functionalities, and code examples.

## Data Structures

A data structure is a method of organizing and sorting data in a computer, allowing for efficient access and utilization. It also refers to the logical or mathematical representation of the data and its implementation in programs.

Data structures can be categorized as:
- Linear: Elements are arranged sequentially, with each element pointing to the next or previous one (e.g., arrays, linked lists).
- Non-linear: Elements are not arranged in a specific order and typically use connections to navigate (e.g., trees, graphs).


## Singly Linked List:

A Singly Linked List is a linear data structure where each element (called a Link) holds data and a reference to the next Link in the sequence. This creates a chain-like structure where elements are only accessible by traversing from the beginning (`head`) towards the end (`tail`).

### Class Structures:

- Link:
  - `record`: Stores the data held by the Link (can be of various data types).
  - `next`: A reference to the next Link in the list (can be null for the last Link).
- List:
  - `head`: The first Link in the list.
  - `tail`: The last Link in the list.

### Functionalities:

- **Insertion**: Adds a new Link to the list:
  - **At the beginning (empty list)**: Sets `head.record` with the data, sets `next` to null, and updates `tail` to refer to `head`. Essentially, this makes `head` the only element in the list, and both `head` and `tail` point to it.
  - **At the end**: 
    - **If it's the second item**: Sets `tail.record` with the data, sets `next` to null, and updates `head.next` to refer to `tail`. This creates a second element with `tail` referring to it, and `head.next` points to tail.
    - **Else**: Creates a new Link, sets its `record` with the data, sets `next` to null, updates the `tail.next` to refer to the new Link, and finally updates `tail` to the new Link itself. In this case, the new Link is appended to the existing list, and `tail` is updated to refer to the newly added element.
- **Deletion**: Removes a Link from the List:
  - **Head Link**: Updates `head` to reference the second Link (`head.next`).
  - Since in a Singly Linked List, the Links doesn't have a `previous` refference, a `helper` Link is created, initialized as `head` and then `helper.next.record` is checked to find the `record` to delete:
    - **Tail Link**: Updates `helper.next` to null and `tail` to refer to `helper`. This removes the last element and updates `tail` to refer to the new last element (previously the second-to-last).
    - **Other Links**: Creates a Link set as `helper.next`, sets `helper.next` to the new Link's `next` (skipping it), and then sets the new Link to null. This removes the target Link and updates the surrounding Links to maintain the list structure.
- **Search**: Searches for a record in the list and prints its position when found. The list is traversed in search of the `record`, incrementing a counter along the way. Once found, a message is printed, indicating both its presence and the position (with the head considered as position 0).

## Code

This data structure is implemented in Java using three files:
1. Link.java
  - Defines the `Link class, which acts as the building block of the list.
  - To simplify usage and since users won't directly access individual Links, all attributes are declared public.
  - These attributes are: 
    - `record`: Stores the data held by the Link. While the provided implementation uses an integer as an example, the record attribute can actually hold any data type, including primitive data types or custom classes.
    - `next`: A reference to the next Link in the list. Since Java doesn't work directly with pointers at the programming level, the `Link` class is considered "self-referential" as it contains a reference to itself.
2. List.java
  - Defines the `List` class, which manages the Singly Linked List.
  - The attributes `head` and `tail`, which are of type Link, are kept private for better encapsulation.
  - The class provides several public methods to manipulate the list, including: 
    - **initialize**: Creates an empty list by setting both `head` and `tail` to null.
    - **insert**: Implements the insertion functionality explained previously.
    - **delete**: Implements the deletion functionality explained previously.
    - **size**: Returns the size of the list (an integer value). The entire list is traversed, incrementing a counter, and the function returns an integer value indicating the total number of elements stored.
    - **search**: Implements the search functionality explained previously.
    - **print**: Prints all the records stored in the list. The entire list is traversed, and the value stored in each Link's `record` attribute is printed.
    - **clean**: Cleans the entire linked list by erasing all its elements.
    - **erase**: Recursively erases all the elements in the list.
3. Main.java
  - Defines the Main class, which serves as an example showcasing how to use the List class and its functionalities.

## Developing Environment

The development environment utilized for this application was Visual Studio Code, leveraging the Java Extension Pack. This pack offers comprehensive language support, a dedicated Java debugger, and Visual Studio IntelliCode, among other tools.

#### Compilation

1. Open a terminal in Visual Studio Code.
2. Ensure you have Java installed and configured in your environment.
3. Execute the following commands:

```
javac Link.java List.java Main.java
java Main
```
Ensure you have the necessary Java dependencies installed and configured in your environment before executing these commands.

## References

1. GeeksForGeeks. What is data structures?. Retrieved from: https://www.geeksforgeeks.org/data-structure-meaning/. Accessed 03-03-24.
2. Lafore, R. (1998). Data Structures & Algorithms in Java. Sams. 

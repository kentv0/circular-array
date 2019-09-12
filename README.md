Circular Array
======
Description
------
The project details can be viewed in the document [here](https://github.com/kentv0/circular-array/blob/master/prompt.pdf).

Get Started
------
### 1. Clone repository
```
    $ git clone https://github.com/kentv0/circular-array.git
```
### 2. Compile package
```
    $ cd circular-array
    $ javac data_structures/*
```
### 3. Run test driver 1
```
    $ java data_structures.Driver1
```
```
    Expected output:
    1
    2 1
    3 2 1
    4 3 2 1
    5 4 3 2 1
    6 5 4 3 2 1
    7 6 5 4 3 2 1
    8 7 6 5 4 3 2 1
    9 8 7 6 5 4 3 2 1
    10 9 8 7 6 5 4 3 2 1
    9 8 7 6 5 4 3 2 1
    8 7 6 5 4 3 2 1
    7 6 5 4 3 2 1
    6 5 4 3 2 1
    5 4 3 2 1
    4 3 2 1
    3 2 1
    2 1
    1



    addFirst(-1)

    Size: 1
    Order: -1

    ====================================

    list.find(-1): -1

    ====================================

    list.peekLast(): -1

    ====================================

    list.clear()

    Size: 0
    Order:

    ====================================

    addLast(-1)

    Size: 1
    Order: -1

    ====================================

    list.peekFirst(): -1

    ====================================

    list.clear()

    Size: 0
    Order:

    ====================================

    addFirst(1)
    addFirst(2)
    addFirst(3)
    addFirst(4)
    addFirst(5)
    addFirst(6)
    addFirst(7)
    addFirst(8)
    addFirst(9)
    addFirst(10)

    Size: 10
    Order: 10 9 8 7 6 5 4 3 2 1

    ====================================

    list.find(1): 1
    list.find(2): 2
    list.find(3): 3
    list.find(4): 4
    list.find(5): 5
    list.find(6): 6
    list.find(7): 7
    list.find(8): 8
    list.find(9): 9
    list.find(10): 10

    ====================================

    list.contains(1): true
    list.contains(2): true
    list.contains(3): true
    list.contains(4): true
    list.contains(5): true
    list.contains(6): true
    list.contains(7): true
    list.contains(8): true
    list.contains(9): true
    list.contains(10): true
```
### 4. Run test driver 2
```
    $ java data_structures.Driver2
```
```
    Expected output:
    ====================================

    list.addLast(1)

    Pointer:     F  R
    Index:      [0][1][2][3][4][5][6]
    Value:          1
    Size: 1
    Order: 1

    ====================================

    list.addLast(2)

    Pointer:     F     R
    Index:      [0][1][2][3][4][5][6]
    Value:          1  2
    Size: 2
    Order: 1 2

    ====================================

    list.addFirst(3)

    Pointer:              R     F
    Index:      [0][1][2][3][4][5][6]
    Value:       3  1  2
    Size: 3
    Order: 3 1 2

    ====================================

    list.addFirst(4)

    Pointer:              R  F
    Index:      [0][1][2][3][4][5][6]
    Value:       3  1  2        4
    Size: 4
    Order: 4 3 1 2

    ====================================

    list.addFirst(5)

    Pointer:              RF
    Index:      [0][1][2][3][4][5][6]
    Value:       3  1  2     5  4
    Size: 5
    Order: 5 4 3 1 2

    ====================================


    list.removeFirst(): 5

    Pointer:              R  F
    Index:      [0][1][2][3][4][5][6]
    Value:       3  1  2        4
    Size: 4
    Order: 4 3 1 2

    NOTE: Technically the value of 5 is
    still at index 4, but the iterator
    skips over it and iterates from
    index 5 and onwards.

    ====================================

     4 3 1 2
    list.remove(3)
     4 1 2

    Does the list contain 3? false
    list.peekFirst(): 4
    list.peekLast(): 2
    list.size(): 3
```
### 5. Clean
```
    $ rm -rf data_structures/*.class
```
### 6. Debug
* Ignore the following output during compile
    ```
    Note: Some input files use unchecked or unsafe operations.
    Note: Recompile with -Xlint:unchecked for details.
    ```

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
    Testing addFirst(1):      1
    Testing addFirst(2):      2 1
    Testing addFirst(3):      3 2 1
    Testing addFirst(4):      4 3 2 1
    Testing addFirst(5):      5 4 3 2 1
    Testing addFirst(6):      6 5 4 3 2 1
    Testing addFirst(7):      7 6 5 4 3 2 1
    Testing addFirst(8):      8 7 6 5 4 3 2 1
    Testing addFirst(9):      9 8 7 6 5 4 3 2 1
    Testing addFirst(10):      10 9 8 7 6 5 4 3 2 1
    Testing removeFirst():    9 8 7 6 5 4 3 2 1
    Testing removeFirst():    8 7 6 5 4 3 2 1
    Testing removeFirst():    7 6 5 4 3 2 1
    Testing removeFirst():    6 5 4 3 2 1
    Testing removeFirst():    5 4 3 2 1
    Testing removeFirst():    4 3 2 1
    Testing removeFirst():    3 2 1
    Testing removeFirst():    2 1
    Testing removeFirst():    1
    Testing removeFirst():

    Testing isEmpty()...passed!

    Testing size() expected to be empty...Passed!

    Testing addFirst() and removeLast() on 7 integer 1000 times...passed!

    Testing addFirst(-1)...passed!

    Testing size(). Returned 1...Passed!

    Testing find(-1). Returned -1...Passed!

    Testing peekLast(). Returned -1...Passed!

    Testing clear()...passed!

    Testing addLast(-1)...passed!

    Testing peekFirst()...Returned -1 passed!

    Testing clear()...passed!

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

    find(1): 1 found!
    find(2): 2 found!
    find(3): 3 found!
    find(4): 4 found!
    find(5): 5 found!
    find(6): 6 found!
    find(7): 7 found!
    find(8): 8 found!
    find(9): 9 found!
    find(10): 10 found!

    ====================================

    contains(1): true
    contains(2): true
    contains(3): true
    contains(4): true
    contains(5): true
    contains(6): true
    contains(7): true
    contains(8): true
    contains(9): true
    contains(10): true
```
### 4. Run test driver 2
```
    $ java data_structures.Driver2
```
```
    Expected output:
    ====================================

    addLast(1)

    Pointer:     F  R
    Index:      [0][1][2][3][4][5][6]
    Value:          1
    Size: 1
    Order: 1

    ====================================

    addLast(2)

    Pointer:     F     R
    Index:      [0][1][2][3][4][5][6]
    Value:          1  2
    Size: 2
    Order: 1 2

    ====================================

    addFirst(3)

    Pointer:              R     F
    Index:      [0][1][2][3][4][5][6]
    Value:       3  1  2
    Size: 3
    Order: 3 1 2

    ====================================

    addFirst(4)

    Pointer:              R  F
    Index:      [0][1][2][3][4][5][6]
    Value:       3  1  2        4
    Size: 4
    Order: 4 3 1 2

    ====================================

    addFirst(5)

    Pointer:              RF
    Index:      [0][1][2][3][4][5][6]
    Value:       3  1  2     5  4
    Size: 5
    Order: 5 4 3 1 2

    ====================================


    removeFirst(): 5

    Pointer:              R  F
    Index:      [0][1][2][3][4][5][6]
    Value:       3  1  2        4
    Size: 4
    Order: 4 3 1 2

    NOTE: Technically the value of 5 is
    still at index 4, but the iterator
    skips over it and iterates from
    index 5 and onwards as a form of deletion.

    ====================================

     4 3 1 2
    remove(3)
     4 1 2

    Does the list contain 3? false
    peekFirst(): 4
    peekLast(): 2
    size(): 3
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

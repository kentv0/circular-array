import data_structures.ArrayLinearList;

/**
 * The Driver1 test driver Class for {@link ArrayLinearList.class}.
 *
 * @version     0.1.0 01 Sep 2015
 * @author      Alan Riggins
 */
public class Driver1 {
/* Test driver class to test the methods of the ArrayLinearList Class. */

    private ArrayLinearList<Integer> list;
    
    /**
     * Set maximum size to 10 for the list.
     */
    public Driver1() {
        list = new ArrayLinearList<Integer>(10);
    }

    /**
     * Run a test for each method in {@link ArrayLinearList.class}.
     *
     * @return the expected output
     * @throws RuntimeException if the test failed
     */
    private void runTests() {

        /* Add 10 integer to the beginning of the list */
        for(int i = 1; i <= 10; i++) {
            list.addFirst(i);
            System.out.print("Testing addFirst(" + i + "):      ");

            for(Integer j : list) {
                System.out.print(j + " ");
            }
            System.out.print("\n");
        }

        /* Remove 10 integer from the beginning of the list */
        for(int i = 1; i <= 10; i++) {
            if(list.removeFirst() == null) {
                throw new RuntimeException("ERROR with removeFirst");
            }
            System.out.print("Testing removeFirst():    ");

            for(Integer j : list) {
                System.out.print(j + " ");
            }
            System.out.print("\n");
        }

        /* Test isEmpty() */
        System.out.print("\nTesting isEmpty()...");
        if(!list.isEmpty()) {
            throw new RuntimeException("ERROR in inEmpty");
        } else {
            System.out.println("passed!");
        }

        /* Test size() */
        System.out.print("\nTesting size() expected to be empty...");
        if(list.size() != 0) {
            throw new RuntimeException("ERROR in size");
        } else {
            System.out.println("Passed!");
        }

        /* Test addFirst() and removeLast() for large size list */
        System.out.print("\nTesting addFirst() and removeLast() on 7 integer"
                + " 1000 times...");
        for(int i = 1; i <= 1000; i++) {

            for(int j = 1; j <= 7; j++) {
                list.addFirst(j);
            }

            for(int j = 1; j <= 7; j++) {
                list.removeLast();
            }
        }
        System.out.println("passed!");

        /* Test addFirst(-1) */
        System.out.print("\nTesting addFirst(-1)...");
        list.addFirst(-1);
        System.out.println("passed!");

        /* Test size() */
        System.out.println("\nTesting size(). Returned " + list.size()
                + "...Passed!");
        System.out.println("\nTesting find(-1). Returned " + list.find(-1)
                + "...Passed!");

        /* Test peekLast() */
        if(list.peekLast() != -1) {
            throw new RuntimeException("ERROR in peekLast");
        }
        System.out.println("\nTesting peekLast(). Returned " + list.peekLast()
                + "...Passed!");

        /* Test clear() */
        System.out.print("\nTesting clear()...");
        list.clear();
        System.out.println("passed!");

        /* Test addLast() */
        System.out.print("\nTesting addLast(-1)...");
        list.addLast(-1);
        System.out.println("passed!");

        /* Test peekFirst() */
        System.out.print("\nTesting peekFirst()...");
        if(list.peekFirst() != -1) {
            throw new RuntimeException("ERROR in peekLast");
        }
        System.out.print("Returned " + list.peekFirst() + " passed!\n");

        /* Test clear() */
        System.out.print("\nTesting clear()...");
        list.clear();
        System.out.println("passed!");

        /* Test addFirst() */
        System.out.println("\n====================================");
        for(int i = 1; i <= 10; i++) {
            System.out.print("\naddFirst(" + i + ")");
            list.addFirst(i);
        }
        System.out.print("\n\nSize: " + list.size());
        System.out.print("\nOrder: ");

        for(Integer j: list) {
            System.out.print(j + " ");
        }
        System.out.println("\n\n====================================");

        /* Test find() */
        for(int i = 1; i <= 10; i++) {
            System.out.print("\nfind(" + i + "): ");

            if(list.find(i) != i) {
                throw new RuntimeException("ERROR in find");
            }
            System.out.print(list.find(i) + " found!");
        }
        System.out.println("\n\n====================================");

        /* Test contains() */
        for(int i = 1; i <= 10; i++) {
            System.out.print("\ncontains(" + i + "): ");

            if(!list.contains(i)) {
                throw new RuntimeException("ERROR in contains");
            }
            System.out.print(list.contains(i));
        }
    }
        
    public static void main(String [] args) {
        Driver1 driver1 = new Driver1();
        driver1.runTests();
    }
}

import data_structures.ArrayLinearList;

/**
 * The Driver2 test driver Class for {@link ArrayLinearList.class}.
 *
 * @version     0.1.0 01 Sep 2015
 * @author      Alan Riggins
 */
public class Driver2 {
/* Test driver class to test the methods of the ArrayLinearList Class. */

    public static void main(String[] args) {

        /* Test addLast(1) */
        ArrayLinearList<Integer> list = new ArrayLinearList(6);
        System.out.println("====================================");
        System.out.println("\naddLast(1)");
        list.addLast(1);
        System.out.print("\nPointer:     F  R");
        System.out.print("\nIndex:      [0][1][2][3][4][5][6]");
        System.out.print("\nValue:          1");
        System.out.print("\nSize: " + list.size());
        System.out.print("\nOrder: ");

        /* Test addLast(2) */
        for(Integer i: list) {
            System.out.print(i + " ");
        }
        System.out.println("\n\n====================================");
        System.out.println("\naddLast(2)");
        list.addLast(2);
        System.out.print("\nPointer:     F     R");
        System.out.print("\nIndex:      [0][1][2][3][4][5][6]");
        System.out.print("\nValue:          1  2");
        System.out.print("\nSize: " + list.size());
        System.out.print("\nOrder: ");

        /* Test addFirst(3) */
        for(Integer i: list) {
            System.out.print(i + " ");
        }
        System.out.println("\n\n====================================");
        System.out.println("\naddFirst(3)");
        list.addFirst(3);
        System.out.print("\nPointer:              R     F");
        System.out.print("\nIndex:      [0][1][2][3][4][5][6]");
        System.out.print("\nValue:       3  1  2");
        System.out.print("\nSize: " + list.size());
        System.out.print("\nOrder: ");

        /* Test addFirst(4) */
        for(Integer i: list) {
            System.out.print(i + " ");
        }
        System.out.println("\n\n====================================");
        System.out.println("\naddFirst(4)");
        list.addFirst(4);
        System.out.print("\nPointer:              R  F");
        System.out.print("\nIndex:      [0][1][2][3][4][5][6]");
        System.out.print("\nValue:       3  1  2        4");
        System.out.print("\nSize: " + list.size());
        System.out.print("\nOrder: ");

        /* Test addFirst(5) */
        for(Integer i: list) {
            System.out.print(i + " ");
        }
        System.out.println("\n\n====================================");
        System.out.println("\naddFirst(5)");
        list.addFirst(5);
        System.out.print("\nPointer:              RF");
        System.out.print("\nIndex:      [0][1][2][3][4][5][6]");
        System.out.print("\nValue:       3  1  2     5  4");
        System.out.print("\nSize: " + list.size());
        System.out.print("\nOrder: ");

        /* Test removeFirst() */
        for(Integer i: list) {
            System.out.print(i + " ");
        }
        System.out.println("\n\n====================================\n");
        System.out.println("\nremoveFirst(): " + list.removeFirst());
        System.out.print("\nPointer:              R  F");
        System.out.print("\nIndex:      [0][1][2][3][4][5][6]");
        System.out.print("\nValue:       3  1  2        4");
        System.out.print("\nSize: " + list.size());
        System.out.print("\nOrder: ");
        for(Integer i: list) {
            System.out.print(i + " ");
        }
        System.out.print("\n\nNOTE: Technically the value of 5 is\nstill at " +
                "index 4, but the iterator\nskips over it and iterates " +
                "from\nindex 5 and onwards as a form of deletion.");
        System.out.println("\n\n====================================\n");

        /* Test remove(3) */
        for(Integer i: list) {
            System.out.print(" " + i);
        }
        list.remove(3);
        System.out.println("\nremove(3)");
        for(Integer i: list) {
            System.out.print(" " + i);
        }

        /* Test contains(3) */
        System.out.println("\n\nDoes the list contain 3? " + list.contains(3));

        /* Test peekFirst() */
        System.out.println("peekFirst(): " + list.peekFirst());

        /* Test peekLast() */
        System.out.println("peekLast(): " + list.peekLast());

        /* Test size() */
        System.out.println("size(): " + list.size());
    }
}

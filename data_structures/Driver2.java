package data_structures;

public class Driver2 {
    public static void main(String[] args) {
        ArrayLinearList<Integer> list = new ArrayLinearList(6);
        System.out.println("====================================");
        System.out.println("\nlist.addLast(1)");
        list.addLast(1);
        System.out.print("\nPointer:     F  R");
        System.out.print("\nIndex:      [0][1][2][3][4][5][6]");
        System.out.print("\nValue:          1");
        System.out.print("\nSize: " + list.size());
        System.out.print("\nOrder: ");
        for(Integer i: list){ System.out.print(i + " "); }
        System.out.println("\n\n====================================");
        System.out.println("\nlist.addLast(2)");
        list.addLast(2);
        System.out.print("\nPointer:     F     R");
        System.out.print("\nIndex:      [0][1][2][3][4][5][6]");
        System.out.print("\nValue:          1  2");
        System.out.print("\nSize: " + list.size());
        System.out.print("\nOrder: ");
        for(Integer i: list){ System.out.print(i + " "); }
        System.out.println("\n\n====================================");
        System.out.println("\nlist.addFirst(3)");
        list.addFirst(3);
        System.out.print("\nPointer:              R     F");
        System.out.print("\nIndex:      [0][1][2][3][4][5][6]");
        System.out.print("\nValue:       3  1  2");
        System.out.print("\nSize: " + list.size());
        System.out.print("\nOrder: ");
        for(Integer i: list){ System.out.print(i + " "); }
        System.out.println("\n\n====================================");
        System.out.println("\nlist.addFirst(4)");
        list.addFirst(4);
        System.out.print("\nPointer:              R  F");
        System.out.print("\nIndex:      [0][1][2][3][4][5][6]");
        System.out.print("\nValue:       3  1  2        4");
        System.out.print("\nSize: " + list.size());
        System.out.print("\nOrder: ");
        for(Integer i: list){ System.out.print(i + " "); }
        System.out.println("\n\n====================================");
        System.out.println("\nlist.addFirst(5)");
        list.addFirst(5);
        System.out.print("\nPointer:              RF");
        System.out.print("\nIndex:      [0][1][2][3][4][5][6]");
        System.out.print("\nValue:       3  1  2     5  4");
        System.out.print("\nSize: " + list.size());
        System.out.print("\nOrder: ");
        for(Integer i: list){ System.out.print(i + " "); }
        System.out.println("\n\n====================================\n");
        System.out.println("\nlist.removeFirst(): " + list.removeFirst());
        System.out.print("\nPointer:              R  F");
        System.out.print("\nIndex:      [0][1][2][3][4][5][6]");
        System.out.print("\nValue:       3  1  2        4");
        System.out.print("\nSize: " + list.size());
        System.out.print("\nOrder: ");
        for(Integer i: list){ System.out.print(i + " "); }
        System.out.print("\n\nNOTE: Technically the value of 5 is\nstill at " +
                "index 4, but the iterator\nskips over it and iterates " +
                "from\nindex 5 and onwards.");
        System.out.println("\n\n====================================\n");
        for(Integer i: list){ System.out.print(" " + i); }
        list.remove(3);
        System.out.println("\nlist.remove(3)");
        for(Integer i: list){ System.out.print(" " + i); }
        System.out.println("\n\nDoes the list contain 3? " + list.contains(3));
        System.out.println("list.peekFirst(): " + list.peekFirst());
        System.out.println("list.peekLast(): " + list.peekLast());
        System.out.println("list.size(): " + list.size());
    }
}

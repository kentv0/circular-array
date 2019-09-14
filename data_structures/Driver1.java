/* Kent Vo */

package data_structures;

public class Driver1 {
    private ArrayLinearList<Integer> list;
    
    public Driver1() {
        list = new ArrayLinearList<Integer>(10);
        runTests();
    }
        
    private void runTests() {

        for(int i = 1; i <= 10; i++) {
            list.addFirst(i);

            for(Integer j : list){ System.out.print(j + " "); }
            System.out.print("\n");
        }

        for(int i = 1; i <= 10; i++) {
            if(list.removeFirst() == null)
                throw new RuntimeException("ERROR with removeFirst");

            for(Integer j : list){ System.out.print(j + " "); }
            System.out.print("\n");
        }

        if(!list.isEmpty())
            throw new RuntimeException("ERROR in inEmpty");  

        if(list.size() != 0)
            throw new RuntimeException("ERROR in size");

        System.out.print("\n");
        for(int i = 1; i <= 1000; i++) {

            for(int j = 1; j <= 7; j++) { list.addFirst(j); }

            for(int j = 1; j <= 7; j++) { list.removeLast(); }
        }
        System.out.print("\naddFirst(-1)\n");
        list.addFirst(-1);
        System.out.print("\nSize: " + list.size());
        System.out.print("\nOrder: ");

        for(Integer j: list){ System.out.print(j + " "); }
        System.out.println("\n\n====================================");
        System.out.print("\nlist.find(-1): ");
        System.out.print(list.find(-1));
        System.out.println("\n\n====================================");
        if(list.peekLast() != -1)
            throw new RuntimeException("ERROR in peekLast");
        System.out.print("\nlist.peekLast(): " + list.peekLast());
        System.out.println("\n\n====================================");
        System.out.println("\nlist.clear()");
        list.clear();
        System.out.print("\nSize: " + list.size());
        System.out.print("\nOrder: ");

        for(Integer j: list){ System.out.print(j + " "); }
        System.out.println("\n\n====================================");
        System.out.print("\naddLast(-1)\n");
        list.addLast(-1);
        System.out.print("\nSize: " + list.size());
        System.out.print("\nOrder: ");

        for(Integer j: list){ System.out.print(j + " "); }
        System.out.println("\n\n====================================");
        if(list.peekFirst() != -1)   
            throw new RuntimeException("ERROR in peekLast");
        System.out.print("\nlist.peekFirst(): " + list.peekFirst());
        System.out.println("\n\n====================================");
        System.out.println("\nlist.clear()");
        list.clear();
        System.out.print("\nSize: " + list.size());
        System.out.print("\nOrder: ");

        for(Integer j: list){ System.out.print(j + " "); }
        System.out.println("\n\n====================================");

        for(int i = 1; i <= 10; i++) {
            System.out.print("\naddFirst(" + i + ")");
            list.addFirst(i);
        }
        System.out.print("\n\nSize: " + list.size());
        System.out.print("\nOrder: ");

        for(Integer j: list){ System.out.print(j + " "); }
        System.out.println("\n\n====================================");

        for(int i = 1; i <= 10; i++) {
            System.out.print("\nlist.find(" + i + "): ");
            if(list.find(i) != i)
                throw new RuntimeException("ERROR in find");
            System.out.print(list.find(i));
        }
        System.out.println("\n\n====================================");

        for(int i = 1; i <= 10; i++) {
            System.out.print("\nlist.contains(" + i + "): ");
            if(!list.contains(i))
                throw new RuntimeException("ERROR in contains");
            System.out.print(list.contains(i));
        }
    }
        
    public static void main(String [] args) {
        new Driver1();
    }
}

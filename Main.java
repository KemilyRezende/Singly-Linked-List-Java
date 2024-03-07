import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        /*
         * Variable declarations:
         */
        int op = 0;
        int record;
        Scanner scan = new Scanner(System.in);

        /*
         * Initialize Linked List:
         */
        List list = new List();
        list.initialize();
        System.out.println("Linked List:");

        /*
         * Menu loop:
         */
        while(op != 7){
            /*
             * Display menu options:
             */
            System.out.println("Menu:");
            System.out.println("1 - Insert");
            System.out.println("2 - Delete");
            System.out.println("3 - Size");
            System.out.println("4 - Search");
            System.out.println("5 - Print Itens");
            System.out.println("6 - Clean List");
            System.out.println("7 - Exit");
            /*
             * Get user input for menu option:
             */
            op = scan.nextInt();
            /*
             * Switch statement to handle user choice:
             */
            switch (op) {
                case 1:
                /*
                 * Inserting operation:
                 */
                    System.out.println("Insert:");
                    System.out.println("Type your new record");
                    record = scan.nextInt();
                    list.insert(record);
                    break;
                case 2:
                /*
                 * Deleting operation:
                 */
                    System.out.println("Delete:");
                    System.out.println("Type the record you want to delete:");
                    record = scan.nextInt();
                    list.delete(record);
                    break;
                case 3:
                /*
                 * Size operation:
                 */
                    System.out.println("Size:");
                    int size = list.size();
                    System.out.println("List size = " + size);
                    break;
                case 4:
                /*
                 * Search operation:
                 */
                    System.out.println("Search:");
                    System.out.println("Type the record you want to search:");
                    record = scan.nextInt();
                    list.search(record);
                    break;
                case 5:
                /*
                 * Printing operation:
                 */
                    System.out.println("Print Itens:");
                    list.print();
                    break;
                case 6:
                /*
                 * Cleaning operation:
                 */
                    System.out.println("Cleaning...");
                    list.clean();
                    System.out.println("Cleaned list.");
                    break;
                case 7:
                /*
                 * Exit operation:
                 */
                    System.out.println("Exit:");
                    System.out.println("Exiting program...");
                    break;
                default:
                /*
                 * Invalid command:
                 */
                    System.out.println("Comand not found!");
                    break;
            }
        }
        /*
         * Close scanner
         */
        scan.close();
    }
}
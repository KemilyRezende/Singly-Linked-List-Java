public class List {
     /*
     * Represents a Simply Linked List with attributes `head` and `tail`.
     */
    private Link head;
    private Link tail;

    public void initialize(){
        /*
         * Initializes the list by setting both head and tail to null.
         */
        this.head = null;
        this.tail = null;
    }

    public void insert(int record) {
        /*
         * Inserts a new record into the list.
         */
        if (this.head == null) {
            /*
             * If the list is empty, the new record becomes the head.
             * Initializes the head as a new Link and stores the record.
             * Sets the tail as the head, indicating a single record in the list.
             */
            this.head = new Link();
            this.head.record = record;
            this.head.next = null;
            /*
             * Since it was the first record stored, the tail is set
             * as the head, indicating a single record in the list.
             */
            this.tail = this.head;
            System.out.println("Inserted!");
        } else if (this.tail == this.head) {
            /*
             * If there's only one record, the process done with the head is repeated with the tail.
             */
            this.tail = new Link();
            this.tail.record = record;
            this.tail.next = null;
            /*
             * Since the tail received a record, the attribute `next` of
             * head will be set as tail.
             */
            this.head.next = this.tail;
            System.out.println("Inserted!");
        } else {
            /*
             * When two or more records have been stored in the list, two 
             * temporary Link type objects are created. One (`helper`) is set as the tail,
             * and the other (`newTail`) will store the record. 
             */
            Link helper;
            Link newTail = new Link();
            helper = this.tail;
            newTail.record = record;
            newTail.next = null;
            /*
             * The attribute `next` of helper will be set as newTail 
             * and then, the tail is set as newTail.
            */
            helper.next = newTail;
            this.tail = newTail;
            System.out.println("Inserted!");
        }
    }    

    public void delete(int record) {
        /*
         * Deletes a record stored in the list.
         */
        if (this.head.record == record) {
            /*
             * If the record is stored in the head, it will be set as
             * the object stored at attribute `next`.
             */
            this.head = this.head.next;
            System.out.println("Item deleted!");
        } else {
            /*
             * If the record isn't stored in the head, it'll be searched in
             * the other links.
             */
            Link helper = this.head;
            /*
             * This boolean type variable is used to print an advice if
             * the record hasn't been found in the List.
             */
            boolean verify = true;
            while (helper.next != null) {
                /*
                 * Since it is a Simply Linked List, the Link doesn't have 
                 * an attribute representing its previous, so, it's 
                 * necessary to check the next Link `record`.
                 */
                if (helper.next.record == record) {
                    /*
                     * If the record is stored in the tail, it will 
                     * be set as the previous Link, and then the 
                     * attribute `next` of the new tail will be set as 
                     * null.
                     */
                    if (helper.next == this.tail) {
                        this.tail = helper;
                        this.tail.next = null;
                        System.out.println("Item deleted!");
                        verify = false;
                        break;
                    }
                    /*
                     * When the record isn't stored in the tail, it's
                     * necessary to set the previous Link as the 'next' 
                     * attribute of the Link that stores the record. 
                     * The Link 'helperNext' is used just for explicitly 
                     * cleaning the deleted link, although the garbage 
                     * collector could handle it, it's a good practice 
                     * especially when intending to study more complex 
                     * structures such as Circular List or Trees, since 
                     * in those cases it is necessary.
                     */
                    else {
                        Link helperNext = helper.next;
                        helper.next = helperNext.next;
                        helperNext = null;
                        System.out.println("Item deleted!");
                        verify = false;
                        break;
                    }
                }
                helper = helper.next;
            }
            if (verify) System.out.println("Record not found!");
        }
        /*
         * Since in this structure the record is an int type variable
         * and is allowed to store the same value in different Links,
         * it is important to say that only the first one will be deleted.
         */
    }
    
    public int size() {
        /*
         * Calculates the size of the list by traversing it and counting the links.
         * A Link type object is used to traverse the list, starting from the head.
         * The count of links is then returned as the size of the list.
         */
        Link helper = this.head;
        int size = 0;
        if (this.head == null) 
            System.out.println("Empty List");
        else {
            /*
             * When `helper` is null, it means that all the links were counted.
             * Each iteration increments the size and moves to the next link.
             */
            while (helper != null) {
                size++;
                helper = helper.next;
            }
        }
        return size;
    }    

    public void search(int record) {
        /*
         * Searches for a record stored in the list and informs its position.
         * It traverses the list until finding the record while increasing a
         * counter variable. When found, it prints a message with the position.
         */
        Link helper = this.head;
        int position = 0;
        boolean verify = true;
        while (helper != null) {
            if (helper.record == record) {
                System.out.println("Record found! Position: " + position);
                verify = false;
                break;
            }
            position++;
            helper = helper.next;
        }
        /*
         * If it wasn't found, print a message.
         */
        if (verify) System.out.println("Record not found!");
    }    

    public void print() {
        /*
         * Prints all the records stored in the list.
         * If the head is null, prints a message informing "Empty List".
         */
        if (this.head == null) 
            System.out.println("Empty list.");
        else {
            System.out.println("Printing...");
            Link helper = this.head;
            while (helper != null) {
                System.out.println(helper.record);
                helper = helper.next;
            }
        }
    }  
    public void clean(){
        /*
        * Cleans the entire linked list by erasing all its elements.
        * The `head` is set to null, and the `tail` is also set to null.
        */
        this.head = erase(this.head);
        this.tail = null;
    }  
    public Link erase(Link current){
        /*
        * Recursively erases all the items in the linked list starting from the given link (`current`).
        * If the current link is not null, create a new link (`helper`) that refers to `current.next`.
        * Then, set `currentLink` to null and call the `erase` function with `helper` as the parameter.
        * Finally, return null when the end of the list is reached.
        */
        if (current!= null){
            Link helper = current.next;
            current = null;
            return erase(helper);
        }
        return null;
    }
}

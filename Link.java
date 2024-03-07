/**
 * The `Link` class represents a link in a linked list.
 * Each Link contains a piece of data (`record`) and a reference
 * to the next node (`next`) in the sequence.
 */
public class Link {
    /* 
    * Represents the data stored in the Link, it can be any 
    * type of data that the linked list is intended to store.
    */
    public int record; 

    /*
     * Represents a reference to the next Link. Since Link is an
     * self-referenced class, 'next' is an attribute of the same class,
     * allowing the creation of the linked structure.
     */
    public Link next;
}

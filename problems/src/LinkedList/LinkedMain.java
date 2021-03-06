package LinkedList;

/**
 * Created by achaurasia on 7/11/16.
 */
public class LinkedMain {
    private static node head = null, head1 = null;
    private static linkedFunc linkFunc = null, linkFunc1 = null;
    public static void main(String args[]) {
        linkFunc = new linkedFunc();
        head = linkFunc.append(head, 10);
        head = linkFunc.insert(head, 4);
        head = linkFunc.insert(head, 2);
        head = linkFunc.append(head, 8);
        head = linkFunc.insertAt(head, 1, 3);
        head = linkFunc.insertAt(head, 3, 3);
        head = linkFunc.insertAt(head, 7, 3);
        head = linkFunc.insertAt(head, 11, 3);
        linkFunc.printList(head);
        head = linkFunc.swap(head, 8, 4);
        System.out.println("Iterative size is " + linkFunc.size(head));
        System.out.println("Recursive size is " + linkFunc.recurSize(head));
        System.out.println("Iterative search is " + linkFunc.iterSearch(head, 22));
        System.out.println("Recursive search is " + linkFunc.recurSearch(head, 8));
        System.out.println("Nth node is  = " + linkFunc.getNthNode(head, 2).data);
        //head = linkFunc.reverseListiter(head);
        linkFunc.reverseListRecur(head);
        head = linkFunc.head;
        linkFunc.printList(head);
        linkFunc1 = new linkedFunc();
        linkFunc1.append(head1, 4);
        linkFunc1.append(head1, 5);
        linkFunc1.append(head1, 6);
        linkFunc1.append(head1, 6);
        linkFunc1.append(head1, 5);
        linkFunc1.append(head1, 4);
        boolean result = linkFunc1.ispalindrome(head1);
        System.out.println("result = " + result);
        /*head = linkFunc.deleteAt(head, 0);
        linkFunc.printList(head);
        head = linkFunc.delete(head, 8);
        linkFunc.printList(head);
        */
    }
}

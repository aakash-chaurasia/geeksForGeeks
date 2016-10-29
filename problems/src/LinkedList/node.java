package LinkedList;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by achaurasia on 7/13/16.
 */
public class node {
    Object data;
    node next;
    public node(Object data, node next)
    {
        this.data = data;
        this.next = next;
    }

    public node()
    {
        this.data = "";
        this.next = null;
    }
}

class linkedFunc {

    public node head;

    public void printList(node head)
    {
        System.out.println("\nList started\n");
        while(head != null)
        {
            System.out.println("\t"+head.data);
            head = head.next;
        }
        System.out.println("\nList Ended\n");
    }

    public node insert(node head, Object o)
    {
        node temp = new node(o, head);
        head = temp;
        return head;
    }

    public node append(node head, Object o)
    {
        node temp = head;
        if(temp == null)
        {
            head = new node(o, null);
        }
        else
        {
            while (temp.next != null)
            {
                temp = temp.next;
            }
            temp.next = new node(o, null);
        }
        return head;
    }

    public node insertAt(node head, Object o, int index)
    {
        node itr = head;
        node temp = new node(o, null);
        if( size(head) > index) {
            if(index == 0)
            {
                temp.next =  head;
                head = temp;
            } else {
                while (index-- > 1)
                    itr = itr.next;
                temp.next = itr.next;
                itr.next = temp;
            }
        } else {
            System.out.println("index is greater than size");
        }
        return head;
    }

    public int size(node head)
    {
        int size = 0;
        while(head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    public node delete(node head, Object o)
    {
        node temp = head;
        if(head != null)
        {
            if(head.data.equals(o))
            {
                node t1 = head;
                head = head.next;
                t1.next = null;
            } else {
                node prev = temp;
                while(temp != null)
                {
                    if(temp.data.equals(o))
                    {
                        prev.next = temp.next;
                        temp.next = null;
                    }
                    prev = temp;
                    temp = temp.next;
                }
            }
        }
        return head;
    }

    public node deleteAt(node head, int index)
    {
        node temp = head;
        node prev = temp;
        if( size(head) > index) {
            if(index == 0)
            {
                head = temp.next;
                temp.next = null;
            } else {
                while (index-- > 0){
                    prev = temp;
                    temp = temp.next;
                }
                prev.next = temp.next;
                temp.next = null;
            }
        } else {
            System.out.println("index is greater than size");
        }
        return head;
    }

    public int recurSize(node head)
    {
        if(head == null)
            return 0;
        return recurSize(head.next) + 1;
    }

    public boolean iterSearch(node head, Object o)
    {
        while(head != null)
        {
            if(head.data.equals(o))
            {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public boolean recurSearch(node head, Object o)
    {
        if(head == null) {
            return false;
        } else if(head.data.equals(o)) {
            return true;
        } else {
            return recurSearch(head.next, o);
        }
    }

    public node swap(node head, Object x, Object y)
    {
        node tempx = head, tempy = head, prevx = head, prevy = head;
        if(head == null)
            return head;
        if(x.equals(y))
        {
            return head;
        }
        if(head.data.equals(x)) {
            while(tempy != null && !tempy.data.equals(y))
            {
                prevy = tempy;
                tempy = tempy.next;
            }
            if(tempy != null)
            {
                node temp = tempy.next;
                tempy.next = head.next;
                prevy.next = head;
                head.next = temp;
                head = tempy;
            }
            return head;
        } else if(head.data.equals(y)) {
            while(tempx != null && !tempx.data.equals(x))
            {
                prevx = tempx;
                tempx = tempx.next;
            }
            if(tempx != null)
            {
                node temp = tempx.next;
                tempx.next = head.next;
                prevx.next = head;
                head.next = temp;
                head = tempx;
            }
            return head;
        } else {

            while(tempx != null && !tempx.data.equals(x))
            {
                prevx = tempx;
                tempx = tempx.next;
            }

            while(tempy != null && !tempy.data.equals(y))
            {
                prevy = tempy;
                tempy = tempy.next;
            }

            if(tempx != null && tempy != null)
            {
                node temp = tempx.next;
                tempx.next = tempy.next;
                prevx.next = tempy;
                tempy.next = temp;
                prevy.next = tempx;
            }
            return head;
        }

    }

    public node getNthNode(node head, int index) {
        node temp = head;
        while(temp != null && index-- >= 0) {
            temp = temp.next;
        }
        if(temp != null) {
            return temp;
        }
        System.out.println("Node doesn't exits");
        return temp;
    }

    public node reverseListiter(node head) {
        node prev = null;
        node curr = head;
        node next = null;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public node reverseListRecur(node curr) {
        if(curr.next == null) {
            head = curr;
            return head;
        }

        node next = reverseListRecur(curr.next);
        next.next = curr;
        curr.next = null;
        return curr;
    }
    node temphead = null;
    public boolean ispalindrome(node curr) {
        if(temphead ==  null) {
            temphead = curr;
        }
        if(curr == null) {
            return true;
        }
        boolean isp = ispalindrome(curr.next);
        if(isp && curr.data == temphead.data) {
            temphead = temphead.next;
            return true;
        } else {
            return false;
        }
    }

}

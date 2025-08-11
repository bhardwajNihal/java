package linkedList.Questions;

import linkedList.SinglyLL;
// import linkedList.SinglyLL.Node;

public class mergeSortedLL extends SinglyLL {

    public static void mergeSortedLLfn(SinglyLL list1, SinglyLL list2) {

        SinglyLL ansList = new SinglyLL();
        Node temp1 = list1.head;
        Node temp2 = list2.head;

        while (temp1 != null && temp2 != null) {

            if (temp1.value < temp2.value) {
                ansList.insertAtTail(temp1.value);
                temp1 = temp1.next;
            } else {
                ansList.insertAtTail(temp2.value);
                temp2 = temp2.next;
            }
        }

        // now case of 1 list emptied
        while (temp1 != null) {
            ansList.insertAtTail(temp1.value);
            temp1 = temp1.next;
        }   
        while (temp2 != null) {
            ansList.insertAtTail(temp2.value);
            temp2 = temp2.next;
        }

        ansList.displayLL();
    }

    public static void main(String[] args) {

        SinglyLL l1 = new SinglyLL();
        SinglyLL l2 = new SinglyLL();

        l1.insertAtTail(8);
        l2.insertAtTail(2);
        l2.insertAtTail(2);
        l2.insertAtTail(3);
        l2.insertAtTail(4);
        l2.insertAtTail(10);

        l1.displayLL();
        l2.displayLL();

        mergeSortedLLfn(l1, l2);

    }
}
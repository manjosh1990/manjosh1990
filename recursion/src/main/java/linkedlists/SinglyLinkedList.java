/*
 * Copyright (C) 2022 Manjosh Ramesh. - All Rights Reserved
 *
 */

package linkedlists;

import java.util.List;

public class SinglyLinkedList {
    private ListNode head;


    //Simple Node
    private static class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void printNodes() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " ->");
            current = current.next;
        }
        System.out.println("null");
    }

    //count the length of the linkedList
    public int length() {
        int count = 0;
        ListNode current = head;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    //insert a new node at the begining of the linkedList
    public void insertAtBegning(int value) {
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }

    // insert a new node to the linkedList
    public void add(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void insertAt(int value, int index) {
        ListNode node = new ListNode(value);
        if (index == 0) {
            node.next = head;
            head = node;
        } else {
            ListNode prev = null;
            ListNode current = head;
            int count = 0;
            while (count < index) {
                if (current == null) {
                    throw new IllegalArgumentException("Index out of bound");
                }
                prev = current;
                current = current.next;
                count++;
            }
            prev.next = node;
            node.next = current;
        }
    }

    public ListNode deleteFirst() {
        if (head == null) return null;
        ListNode temp = head;
        this.head = head.next;
        temp.next = null;
        return temp;
    }

    public ListNode deleteLast() {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode prev = null;
        ListNode current = head;
        while (current.next != null) {
            prev = current;
            current = current.next;
        }
        prev.next = null;
        return current;
    }

    public ListNode deleteAt(int index) {
        if (head == null) return null;
        ListNode prev = null;
        ListNode current = head;
        int count = 0;
        while (count < index) {
            if (current == null) throw new IllegalArgumentException("Index out of bounds");
            prev = current;
            current = current.next;
            count++;
        }
        if (prev == null) {
            head = current.next;
            current.next = null;
            return current;
        }
        prev.next = current.next;
        current.next = null;
        return current;
    }

    public ListNode getNthNodeFromEnd(int n) {
        if (head == null) return null;
        if (n < 0) throw new IllegalArgumentException("Invalid value of n :" + n);
        ListNode ref = head;
        ListNode main = head;
        int count = 0;
        while (count < n) {
            if (ref == null) throw new IndexOutOfBoundsException("Invalid value of n :" + n);
            ref = ref.next;
            count++;
        }
        while (ref != null) {
            main = main.next;
            ref = ref.next;
        }
        return main;
    }

    public ListNode getMiddleElement(){
        if(head == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.head = new ListNode(10);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(8);
        ListNode fourth = new ListNode(11);

        //connect
        list.head.next = second;
        second.next = third;
        third.next = fourth;

        list.printNodes();
        System.out.println(list.length());
        list.insertAtBegning(5);
        list.printNodes();

        list.add(15);
        list.printNodes();
        list.insertAt(16,5);
        list.printNodes();
        list.deleteFirst();
        list.deleteLast();
        list.printNodes();

       // list.deleteAt(4);
        list.printNodes();
        System.out.println(list.getNthNodeFromEnd(2).data);

        System.out.println(list.getMiddleElement().data);
    }
}

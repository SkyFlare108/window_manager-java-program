package com.company;

import javax.swing.*;

public class ListPanel {

    private ListNode front;

    public ListPanel(){
        front = null;
    }

    public void add(JPanel i) {
        if(front == null) {
            front = new ListNode(i);
        }
        else{
            ListNode current = front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new ListNode(i);
        }

    }

    public void addToFront(JPanel panel) {
        front = new ListNode(panel, front);
    }

    public void add(int index, JPanel i){
        if (index == 0){
            front = new ListNode(i, front);
        }
        ListNode current = front;
        for (int x = 0; x < index - 1; x++) {
            current = current.next;
        }
        current.next = new ListNode(i, current.next);
    }

    public JPanel get(int index) {
        if (front == null) {
            return null;
        }
        ListNode current = front;
        while (index >= 1) {
            current = current.next;
            index--;
        }
        if (current == null) {
            return null;
        }
        return current.data;
    }

    public JPanel remove(int index) {
        if (index == 0) {
            front = front.next;
            return front.data;
        }
        var current = front;
        while (index > 1) {
            current = current.next;
            index--;
        }
        var temp = current.next;
        current.next = current.next.next;
        return temp.data;
    }

    public int indexOf(JPanel i) {
        int index = 0;
        ListNode current = front;
        while (current != null) {
            if (current.data == i) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    public int size(){
        int size = 0;
        ListNode current = front;
        while(current != null){
            current = current.next;
            size++;
        }
        return size;
    }

}
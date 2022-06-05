package com.company;

import javax.swing.*;

public class ListNode {
    JPanel data;
    ListNode next;

    public ListNode(JPanel data) {
        this.data = data;
        this.next = null;
    }
    public ListNode(JPanel data, ListNode next) {
        this.data = data;
        this.next = next;
    }
}
package com.company;
import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setContentPane(new MyJPanel(frame));
        frame.setVisible(true);
    }
}
class MyJPanel extends JPanel {
    ListPanel list = new ListPanel();
    Random generate = new Random();
    JFrame frame;

    public MyJPanel(JFrame frame) {
        this.frame = frame;
        System.out.println("How many tabs do you want to open?");
        Scanner sc = new Scanner(System.in);
        int answer = sc.nextInt();
        for (int i = 0; i < answer; i++) {
            JPanel panel = new JPanel();
            panel.setPreferredSize(new Dimension(200, 200));
            panel.setBackground(new Color(generate.nextInt(255),
                    generate.nextInt(255), generate.nextInt(255)));
            panel.add(new JLabel("Tab" + (i + 1)));
            add(panel);
            list.add(panel);
        }
        System.out.println("There are: " + list.size() + "windows displayed");
        new Mouse(list, frame, getComponents());
        setVisible(true);
    }
}
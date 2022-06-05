package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
public class Mouse implements MouseListener, MouseMotionListener {
    private int X, Y;
    private final ListPanel listPanel;
    private final JFrame frame;

    public Mouse(ListPanel list, JFrame frame, Component... pns) {
        for (Component panel : pns) {
            panel.addMouseListener(this);
            panel.addMouseMotionListener(this);
        }
        listPanel = list;
        this.frame = frame;
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        bringToFront((JPanel) event.getComponent());
    }

    public void bringToFront(JPanel panel) {
        listPanel.addToFront(listPanel.remove(listPanel.indexOf(panel)));
        repaint();
    }

    public void repaint() {
        frame.getContentPane().removeAll();
        frame.getContentPane().repaint();
        int index;
        JPanel current = listPanel.get(0);
        while (current != null) {
            index = listPanel.indexOf(current);
            frame.getContentPane().add(current);
            current = listPanel.get(index + 1);
        }
    }

    @Override
    public void mousePressed(MouseEvent event) {
        X = event.getX();
        Y = event.getY();
    }

    @Override
    public void mouseDragged(MouseEvent event) {
        event.getComponent().setLocation((event.getX()
                + event.getComponent().getX()) - X, (event.getY() + event.getComponent().getY()) - Y);
        frame.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}
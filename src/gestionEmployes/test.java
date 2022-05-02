package gestionEmployes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class test {
    public static void main(String args[]) {
        JFrame frame = new JFrame("Technologies");
        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel panel1, panel2, panel3, panel4, panel5;
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Web development");
        JMenu menu1 = new JMenu("Frontend");
        JMenu menu2 = new JMenu("Backend");
        JMenuItem i1 = new JMenuItem("Html");
        JMenuItem i2 = new JMenuItem("Css");
        JMenuItem i3 = new JMenuItem("JavaScript");
        JMenuItem i4 = new JMenuItem("PHP");
        JMenuItem i5 = new JMenuItem("MySQL");
        menu1.add(i1);
        menu1.add(i2);
        menu1.add(i3);
        menu2.add(i4);
        menu2.add(i5);
        menu.add(menu1);
        menu.add(menu2);
        menuBar.add(menu);
        panel1 = new JPanel();
        panel1.setBackground(Color.GREEN);
        panel2 = new JPanel();
        panel2.setBackground(Color.YELLOW);
        panel3 = new JPanel();
        panel3.setBackground(Color.BLUE);
        panel4 = new JPanel();
        panel4.setBackground(Color.RED);
        panel5 = new JPanel();
        panel5.setBackground(Color.BLACK);

        i1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane.removeAll();
                tabbedPane.repaint();
                tabbedPane.addTab("Html", panel1);
            }
        });
        i2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane.removeAll();
                tabbedPane.repaint();
                tabbedPane.addTab("Css", panel2);
            }
        });
        i3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane.removeAll();
                tabbedPane.repaint();
                tabbedPane.addTab("JavaScript", panel3);
            }
        });
        i4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane.removeAll();
                tabbedPane.repaint();
                tabbedPane.addTab("PHP", panel4);
            }
        });
        i5.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane.removeAll();
                tabbedPane.repaint();
                tabbedPane.addTab("MySQL", panel5);
            }
        });

        frame.add(tabbedPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,500);
        frame.setLocation(250, 100);
        frame.setVisible(true);
        frame.setJMenuBar(menuBar);
    }
}

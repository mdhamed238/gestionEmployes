package gestionEmployes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gestionEmployes.*;

public class MainForm extends JFrame {

    JLabel lblTitle;

    JMenuBar menuBar;
    JMenu menuDepartement, menuEmploye;
    JMenuItem menuItemProfile, menuItemLogout, menuItemExit, menuItemEmploye, menuItemChercherEmployer;

    JTabbedPane mainPane;



    public MainForm() {
        super("Gestion des employes");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(180,40,1020,640);

        menuBar = new JMenuBar();
        menuBar.setOpaque(true);
        menuBar.setBackground(new Color(69, 104, 152));
        menuBar.setPreferredSize(new Dimension(menuBar.getWidth(), 40));

        menuDepartement = new JMenu("Departement");
        menuItemProfile = new JMenuItem("Profile du departement");
        menuItemLogout = new JMenuItem("Logout");
        menuItemExit = new JMenuItem("Exit");
        menuDepartement.add(menuItemProfile);
        menuDepartement.add(menuItemLogout);
        menuDepartement.addSeparator();
        menuDepartement.add(menuItemExit);
        menuEmploye = new JMenu("Employe");
        menuItemEmploye = new JMenuItem("Employe");
        menuItemChercherEmployer = new JMenuItem("Chercher Employé");
        menuEmploye.add(menuItemEmploye);
        menuEmploye.add(menuItemChercherEmployer);

        menuBar.add(menuDepartement);
        menuBar.add(menuEmploye);

        setJMenuBar(menuBar);

        mainPane = new JTabbedPane();
        mainPane.setBounds(50, 20, 1020, 600);
        mainPane.setFont(new Font("Tahoma", Font.BOLD, 13));


        lblTitle = new JLabel("Gestion des employes");
        lblTitle.setForeground(Color.DARK_GRAY);
        lblTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 42));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setVerticalAlignment(SwingConstants.CENTER);
        mainPane.add(lblTitle);

        getContentPane().add(mainPane);

        menuItemEmploye.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPane.removeAll();
                mainPane.repaint();
                EmployeForm empForm = new EmployeForm();
                mainPane.add("Employe", empForm);
            }
        });

        menuItemChercherEmployer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPane.removeAll();
                mainPane.repaint();
                EmployeForm empForm = new EmployeForm(true);
                mainPane.add("Chercher employé", empForm);
            }
        });

        menuItemExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        menuItemLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginForm loginForm = new LoginForm();
            }
        });

        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainForm();
    }
}

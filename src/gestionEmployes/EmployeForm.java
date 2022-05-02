package gestionEmployes;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class EmployeForm extends JFrame {

    JPanel panelSearch, panelSaisie, paneltab, panelbtn;
    JTable  table;
    DefaultTableModel model;


    JLabel lab1, lab2, lab3, lab4, lab5, lab6, lab7, lab8;
    JTextField searchField, id, nom, prenom, date, lieu, NNI, tel, salaire;
    JComboBox searchCombo;

    JButton searchButton, b1, b2, b3, b4, b5;



    public EmployeForm(){
        initComponents();
        table_update(null);
    }

    public void initComponents() {
        setTitle("Gestion des employes");
        // setUndecorated(true);
        setBounds(180,40,1000,640);



        searchCombo = new JComboBox(new Object[] {
                "chercher par nom",
                "chercher par prenom",
                "chercher par Id",
                "chercher par NNI"
        });
        searchCombo.setPreferredSize(new Dimension(180, 25));


        searchField = new JTextField(30);
        searchButton = new JButton("search");
        searchButton.setPreferredSize(new Dimension(120,25));

        panelSearch = new JPanel();
        panelSearch.setBounds(350,20,400,30);
        panelSearch.setLayout(new GridLayout(1, 3, 10, 10));
        panelSearch.add(searchCombo);
        panelSearch.add(searchField);
        panelSearch.add(searchButton);
        add(panelSearch);

        lab1 = new JLabel("ID");
        id = new JTextField(10);

        lab2 = new JLabel("Nom");
        nom = new JTextField(10);

        lab3 = new JLabel("Prenom");
        prenom = new JTextField(10);

        lab4 = new JLabel("Date de Naissance");
        date = new JTextField(10);

        lab5 = new JLabel("Lieu de Naissance");
        lieu =new JTextField(10);

        lab6 = new JLabel("NNI");
        NNI = new JTextField(10);

        lab7 = new JLabel("Tel");
        tel = new JTextField(13);

        lab8 = new JLabel("Salaire");
        salaire = new JTextField(10);


        panelSaisie = new JPanel();
        panelSaisie.setBounds(5,90,360,420);
        panelSaisie.setBorder(new LineBorder(Color.BLUE,2));
        panelSaisie.setLayout(new GridLayout(8,2, 10, 20));

        panelSaisie.add(lab1);
        panelSaisie.add(id);
        id.setBorder(new LineBorder(Color.LIGHT_GRAY));

        panelSaisie.add(lab2);
        panelSaisie.add(nom);
        nom.setBorder(new LineBorder(Color.LIGHT_GRAY));

        panelSaisie.add(lab3);
        panelSaisie.add(prenom);
        prenom.setBorder(new LineBorder(Color.LIGHT_GRAY));

        panelSaisie.add(lab4);
        panelSaisie.add(date);
        date.setBorder(new LineBorder(Color.LIGHT_GRAY));

        panelSaisie.add(lab5);
        panelSaisie.add(lieu);
        lieu.setBorder(new LineBorder(Color.LIGHT_GRAY));

        panelSaisie.add(lab6);
        panelSaisie.add(NNI);
        NNI.setBorder(new LineBorder(Color.LIGHT_GRAY));

        panelSaisie.add(lab7);
        panelSaisie.add(tel);
        tel.setBorder(new LineBorder(Color.LIGHT_GRAY));

        panelSaisie.add(lab8);
        panelSaisie.add(salaire);
        salaire.setBorder(new LineBorder(Color.LIGHT_GRAY));

        add(panelSaisie);


        paneltab = new JPanel();
        paneltab.setBounds(370, 90, 605, 420);
        paneltab.setBorder(new LineBorder(Color.BLUE, 2));


        String[] columnNames = {"ID", "Nom", "Prenom", "Date_Naissance",  "Lieu_Naissance", "NNI", "Tel", "Salaire"};
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        table.getTableHeader().setPreferredSize(new Dimension(table.getTableHeader().getWidth(), 30));
        table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 12));
        table.setRowHeight(30);
        JScrollPane scroll = new JScrollPane(table);


        paneltab.setLayout(new FlowLayout(FlowLayout.LEFT,1,1));
        paneltab.add(table.getTableHeader(), BorderLayout.NORTH);
        paneltab.add(table);
        add(paneltab);

        b1 = new JButton("Ajouter");
        b1.setPreferredSize(new Dimension(180,63));
        b1.setBackground(Color.WHITE);
        b1.setBorder(new LineBorder(Color.WHITE));
        b2 = new JButton("Modifier");
        b2.setPreferredSize(new Dimension(180,63));
        b2.setBackground(Color.WHITE);
        b2.setBorder(new LineBorder(Color.WHITE));
        b3 = new JButton("Suprimer");
        b3.setPreferredSize(new Dimension(180,63));
        b3.setBackground(Color.WHITE);
        b3.setBorder(new LineBorder(Color.WHITE));
        b4 = new JButton("Vider");
        b4.setPreferredSize(new Dimension(180,63));
        b4.setBackground(Color.WHITE);
        b4.setBorder(new LineBorder(Color.WHITE));
        b5 = new JButton("Fermer");
        b5.setPreferredSize(new Dimension(180,63));
        b5.setBackground(Color.WHITE);
        b5.setBorder(new LineBorder(Color.WHITE));
        panelbtn = new JPanel();
        panelbtn.setLayout(new FlowLayout(FlowLayout.CENTER,10,7));

        panelbtn.setBounds(5,515,970,80);
        panelbtn.setBorder(new LineBorder(Color.BLUE,2));
        panelbtn.add(b1);
        panelbtn.add(b2);
        panelbtn.add(b3);
        panelbtn.add(b4);
        panelbtn.add(b5);
        add(panelbtn);



        table.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                int index = table.getSelectedRow();
                if(index != -1) {
                    id.setText(table.getModel().getValueAt(index, 0).toString());
                    nom.setText(table.getModel().getValueAt(index, 1).toString());
                    prenom.setText(table.getModel().getValueAt(index, 2).toString());
                    date.setText(table.getModel().getValueAt(index, 3).toString());
                    lieu.setText(table.getModel().getValueAt(index, 4).toString());
                    NNI.setText(table.getModel().getValueAt(index, 5).toString());
                    tel.setText(table.getModel().getValueAt(index, 6).toString());
                    salaire.setText(table.getModel().getValueAt(index, 7).toString());
                }
            }
        });


        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = searchField.getText();
                String filter = searchCombo.getSelectedItem().toString();

                switch (filter) {
                    case "chercher par nom":
                        table_update(db.selectByFirstName(str));
                        break;
                    case "chercher par prenom":
                        table_update(db.selectByLastName(str));
                        break;
                    case "chercher par Id":
                        table_update(db.selectById(Integer.parseInt(str)));
                        break;
                    case "chercher par NNI":
                        table_update(db.selectByNNI(str));
                        break;
                }
            }
        });

        // button => ajouter
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] fields = new Object[] {nom.getText(), prenom.getText(), date.getText(), lieu.getText(), NNI.getText(), tel.getText(), salaire.getText()};

                boolean valid = true;
                for(Object field : fields) {
                    if(field == "") {
                        valid = false;
                    }
                }
                if(valid) {
                    db.insertRow(
                            nom.getText(),
                            prenom.getText(),
                            date.getText(),
                            lieu.getText(),
                            NNI.getText(),
                            tel.getText(),
                            Integer.parseInt(salaire.getText())
                    );
                    resetFields();
                    table_update(null);
                }
            }
        });
        // button => modifier
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = table.getSelectedRow();
                Object[] fields = new Object[] {nom.getText(), prenom.getText(), date.getText(), lieu.getText(), NNI.getText(), tel.getText(), salaire.getText()};

                boolean valid = true;
                for(Object field : fields) {
                    if(field == "") {
                        valid = false;
                    }
                }
                if(index != -1) {
                    if(valid) {
                        db.updateRow(
                                Integer.parseInt(id.getText()),
                                nom.getText(),
                                prenom.getText(),
                                date.getText(),
                                lieu.getText(),
                                NNI.getText(),
                                tel.getText(),
                                Integer.parseInt(salaire.getText())
                        );
                        resetFields();
                        table_update(null);
                    }
                } else {
                    JOptionPane.showMessageDialog(paneltab.getParent(), "You have to select a row", "Alert!", JOptionPane.WARNING_MESSAGE);
                }
            }

        });
        // button => supprimer
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int index = table.getSelectedRow();
                    if(index != -1) {
                        int output = JOptionPane.showConfirmDialog(paneltab.getParent(), "Are you sure you want to delete this row?", "Alert!", JOptionPane.WARNING_MESSAGE);
                        if(output == JOptionPane.YES_OPTION) {
                            int id = Integer.parseInt(table.getModel().getValueAt(index, 0).toString());
                            db.deleteRow(id);
                        }
                    } else {
                        JOptionPane.showMessageDialog(paneltab.getParent(), "You have to select a row", "Alert!", JOptionPane.WARNING_MESSAGE);
                    }
                } catch(ArrayIndexOutOfBoundsException event) {
                    event.printStackTrace();
                }
                resetFields();
                table_update(null);
            }
        });
        // button => vider
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetFields();
            }
        });
        // button fermer
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });


        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    public void table_update(ResultSet result) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        ResultSet rs;
        if(result != null) {
            rs = result;
        } else {
            rs = db.selectAll();
        }

        try {
            Object[] data;
            while (rs.next()) {
                data = new Object[] {
                        rs.getObject(1),
                        rs.getObject(2),
                        rs.getObject(3),
                        rs.getObject(4),
                        rs.getObject(5),
                        rs.getObject(6),
                        rs.getObject(7),
                        rs.getObject(8),
                };
                model.addRow(data);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void resetFields() {
        id.setText("");
        nom.setText("");
        prenom.setText("");
        date.setText("");
        lieu.setText("");
        NNI.setText("");
        tel.setText("");
        salaire.setText("");
    }

}

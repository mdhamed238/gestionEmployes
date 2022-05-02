package gestionEmployes;

import java.sql.*;

public class db {
    static final String db_url = "jdbc:mysql://localhost:3306/gestion_employes";
    static final String user = "root";
    static final String password = "";

    public static ResultSet selectAll() {
        try {
            // open connection
            Connection conn = DriverManager.getConnection(db_url, user, password);
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM employes";
            ResultSet rs = stmt.executeQuery(query);

            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ResultSet selectByFirstName(String str) {
        try {
            // open connection
            Connection conn = DriverManager.getConnection(db_url, user, password);
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM employes WHERE nom LIKE '" + str + "%'";
            ResultSet rs = stmt.executeQuery(query);

            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ResultSet selectByLastName(String str) {
        try {
            // open connection
            Connection conn = DriverManager.getConnection(db_url, user, password);
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM employes WHERE prenom LIKE '" + str + "%'";
            ResultSet rs = stmt.executeQuery(query);

            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static ResultSet selectById(int id) {
        try {
            // open connection
            Connection conn = DriverManager.getConnection(db_url, user, password);
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM employes WHERE id = " + id ;
            ResultSet rs = stmt.executeQuery(query);

            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ResultSet selectByNNI(String str) {
        try {
            // open connection
            Connection conn = DriverManager.getConnection(db_url, user, password);
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM employes WHERE NNI LIKE '" + str + "%'";
            ResultSet rs = stmt.executeQuery(query);

            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static void insertRow(String nom, String prenom, String date_naissance, String lieu_naissance, String NNI, String tel, int salaire) {
        try {
            // open connection
            Connection conn = DriverManager.getConnection(db_url, user, password);
            String query = "INSERT INTO employes (`nom`, `prenom`, `date_naissance`, `lieu_naissance`, `NNI`, `tel`, `salaire`) " +
                    " VALUES (?, ?, ?, ?, ?, ?, ?);";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, nom);
            stmt.setString(2, prenom);
            stmt.setString(3, date_naissance);
            stmt.setString(4, lieu_naissance);
            stmt.setString(5, NNI);
            stmt.setString(6, tel);
            stmt.setInt(7, salaire);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateRow(int id, String nom, String prenom, String date_naissance, String lieu_naissance, String NNI, String tel, int salaire) {
        try {
            // open connection
            Connection conn = DriverManager.getConnection(db_url, user, password);
            String query = "UPDATE employes SET nom = ? , prenom = ?, date_naissance = ? "
                    + ", lieu_naissance = ?, NNI = ?, tel = ?, salaire = ? WHERE id = ?;";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, nom);
            stmt.setString(2, prenom);
            stmt.setString(3, date_naissance);
            stmt.setString(4, lieu_naissance);
            stmt.setString(5, NNI);
            stmt.setString(6, tel);
            stmt.setInt(7, salaire);
            stmt.setInt(8, id);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteRow(int id) {
        try {
            Connection conn = DriverManager.getConnection(db_url, user, password);
            String query = "DELETE FROM employes WHERE id = ?;";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static boolean loginUser(String Username, String Password) {
        try {
            Connection conn = DriverManager.getConnection(db_url, user, password);
            String query = "SELECT password FROM employes WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, Username);
            ResultSet rs = stmt.executeQuery();

            Object[] userData = new Object[1];
            while (rs.next()) {
                userData[0] = rs.getObject("password");
            }
            if(userData[0] == Password) return true;
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


}
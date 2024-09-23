package DAO.Dao_Implementation;

import DAO.Dao_Interface.ComponentDAOInterface;
import Utilitaire.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ComponentDAO implements ComponentDAOInterface {

    @Override
    public void addMaterial(String name, double VATRate, double unitCost, double quantity, double transportCost, double qualityCoefficient, int projectId) throws SQLException {
        String sql = "INSERT INTO Material (name, componentType, VATRate, unitCost, quantity, transportCost, qualityCoefficient, projectId) VALUES (?, 'MATERIAL', ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setDouble(2, VATRate);
            stmt.setDouble(3, unitCost);
            stmt.setDouble(4, quantity);
            stmt.setDouble(5, transportCost);
            stmt.setDouble(6, qualityCoefficient);
            stmt.setInt(7, projectId);
            stmt.executeUpdate();
        }
    }

    @Override
    public void addLabor(String name, double VATRate, double hourlyRate, double hoursWorked, double workerProductivity, int projectId) throws SQLException {
        String sql = "INSERT INTO Labor (name, componentType, VATRate, hourlyRate, hoursWorked, workerProductivity, projectId) VALUES (?, 'LABOR', ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setDouble(2, VATRate);
            stmt.setDouble(3, hourlyRate);
            stmt.setDouble(4, hoursWorked);
            stmt.setDouble(5, workerProductivity);
            stmt.setInt(6, projectId);
            stmt.executeUpdate();
        }
    }
}
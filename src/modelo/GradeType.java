package modelo;

import db.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GradeType {
    private int id;
    private String name;
    private double weight;

    public GradeType(int id, String name, double weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public static void insertGradeType(GradeType gradeType) {
        Connection con = connection.getConnection();
        String sql =

                "INSERT INTO gradetype (id, name, weight) VALUES (?, ?, ?)";

        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, gradeType.getId());
            statement.setString(2, gradeType.getName());
            statement.setDouble(3, gradeType.getWeight());
            statement.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

    }
    public static List<GradeType> getAllGradeTypes() {
        Connection con = connection.getConnection();
        List<GradeType> gradeTypes = new ArrayList<>();

        String sql = "SELECT * FROM gradetype";

        try (PreparedStatement statement = con.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                GradeType gradeType = new GradeType(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("weight")
                );

                gradeTypes.add(gradeType);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return gradeTypes;
    }


}

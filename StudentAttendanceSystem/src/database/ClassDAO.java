package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClassDAO {
    /**
     * Thêm một lớp học mới
     */
    public boolean addClass(String className, int teacherId) {
        String query = "INSERT INTO classes (class_name, teacher_id) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, className);
            stmt.setInt(2, teacherId);
            stmt.executeUpdate();
            return true;
        } catch (Exception e) { // Bắt ngoại lệ tổng quát
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Lấy danh sách tất cả các lớp học
     */
    public List<String> getAllClasses() {
        List<String> classes = new ArrayList<>();
        String query = "SELECT class_name FROM classes";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                classes.add(rs.getString("class_name"));
            }
        } catch (Exception e) { // Bắt ngoại lệ tổng quát
            e.printStackTrace();
        }
        return classes;
    }
}

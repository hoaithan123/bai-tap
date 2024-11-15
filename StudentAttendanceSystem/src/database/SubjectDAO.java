package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAO {

    /**
     * Thêm một môn học mới
     */
    public boolean addSubject(String subjectName, int classId) {
        String query = "INSERT INTO subjects (subject_name, class_id) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, subjectName);
            stmt.setInt(2, classId);
            stmt.executeUpdate();
            return true;
        } catch (Exception e) { // Bắt ngoại lệ tổng quát
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Lấy danh sách các môn học theo lớp
     */
    public List<String> getSubjectsByClass(int classId) {
        List<String> subjects = new ArrayList<>();
        String query = "SELECT subject_name FROM subjects WHERE class_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, classId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                subjects.add(rs.getString("subject_name"));
            }
        } catch (Exception e) { // Bắt ngoại lệ tổng quát
            e.printStackTrace();
        }
        return subjects;
    }
}

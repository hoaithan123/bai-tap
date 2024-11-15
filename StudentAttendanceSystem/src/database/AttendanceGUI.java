package database;

import javax.swing.*;

public class AttendanceGUI extends JFrame {
    private JTextField studentCodeField, classIdField, subjectIdField;
    private AttendanceDAO attendanceDAO = new AttendanceDAO();

    public AttendanceGUI() {
        setTitle("Điểm danh");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Mã sinh viên:"));
        studentCodeField = new JTextField(10);
        panel.add(studentCodeField);

        panel.add(new JLabel("Mã lớp:"));
        classIdField = new JTextField(5);
        panel.add(classIdField);

        panel.add(new JLabel("Mã môn học:"));
        subjectIdField = new JTextField(5);
        panel.add(subjectIdField);

        JButton markButton = new JButton("Điểm danh");
        markButton.addActionListener(e -> markAttendance());
        panel.add(markButton);

        add(panel);
        setVisible(true);
    }

    private void markAttendance() {
        String studentCode = studentCodeField.getText();
        int classId = Integer.parseInt(classIdField.getText());
        int subjectId = Integer.parseInt(subjectIdField.getText());
        attendanceDAO.markAttendance(studentCode, classId, subjectId, "Present");
        JOptionPane.showMessageDialog(this, "Điểm danh thành công!");
    }
}

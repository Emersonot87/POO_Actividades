import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.List;

public class InterfaceForms extends JFrame {

    private JTextField nameField;
    private JTextField numberField;

    public InterfaceForms() {
        setTitle("");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(430, 210);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel(null);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(50, 30, 60, 25);
        panel.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(120, 30, 255, 25);
        panel.add(nameField);

        JLabel numberLabel = new JLabel("Number");
        numberLabel.setBounds(50, 75, 60, 25);
        panel.add(numberLabel);

        numberField = new JTextField();
        numberField.setBounds(120, 75, 255, 25);
        panel.add(numberField);

        JButton createBtn = new JButton("Create");
        createBtn.setBounds(30, 120, 80, 25);
        panel.add(createBtn);

        JButton readBtn = new JButton("Read");
        readBtn.setBounds(120, 120, 80, 25);
        panel.add(readBtn);

        JButton updateBtn = new JButton("Update");
        updateBtn.setBounds(210, 120, 80, 25);
        panel.add(updateBtn);

        JButton deleteBtn = new JButton("Delete");
        deleteBtn.setBounds(300, 120, 80, 25);
        panel.add(deleteBtn);

        JButton clearBtn = new JButton("Clear");
        clearBtn.setBounds(155, 158, 80, 25);
        panel.add(clearBtn);

        JButton exitBtn = new JButton("Exit");
        exitBtn.setBounds(245, 158, 80, 25);
        panel.add(exitBtn);

        add(panel);

        createBtn.addActionListener(e -> onCreate());
        readBtn.addActionListener(e -> onRead());
        updateBtn.addActionListener(e -> onUpdate());
        deleteBtn.addActionListener(e -> onDelete());
        clearBtn.addActionListener(e -> clearFields());
        exitBtn.addActionListener(e -> System.exit(0));
    }

    private void onCreate() {
        if (!fieldsAreFilled()) return;
        String msg = AddFriend.addFriend(nameField.getText().trim(), numberField.getText().trim());
        JOptionPane.showMessageDialog(this, msg);
    }

    private void onRead() {
        String name = nameField.getText().trim();
        List<String[]> contacts = DisplayFriends.displayFriends(name);
        if (contacts.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Contact not found.");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (String[] c : contacts) {
            sb.append("Name: ").append(c[0]).append("  |  Number: ").append(c[1]).append("\n");
        }
        if (!name.isEmpty() && contacts.size() == 1) {
            numberField.setText(contacts.get(0)[1]);
        }
        JOptionPane.showMessageDialog(this, sb.toString(), "Contacts", JOptionPane.INFORMATION_MESSAGE);
    }

    private void onUpdate() {
        if (!fieldsAreFilled()) return;
        String msg = UpdateFriend.updateFriend(nameField.getText().trim(), numberField.getText().trim());
        JOptionPane.showMessageDialog(this, msg);
    }

    private void onDelete() {
        String name = nameField.getText().trim();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a Name.");
            return;
        }
        String msg = DeleteFriend.deleteFriend(name);
        JOptionPane.showMessageDialog(this, msg);
    }

    private boolean fieldsAreFilled() {
        if (nameField.getText().trim().isEmpty() || numberField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both Name and Number.");
            return false;
        }
        return true;
    }

    private void clearFields() {
        nameField.setText("");
        numberField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InterfaceForms().setVisible(true));
    }
}

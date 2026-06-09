import javax.swing.*;
import java.awt.event.*;
import java.util.List;

public class InterfaceForms extends JFrame implements ActionListener {

    JTextField nameField;
    JTextField numberField;
    JButton createBtn;
    JButton readBtn;
    JButton updateBtn;
    JButton deleteBtn;
    JButton clearBtn;
    JButton exitBtn;

    public InterfaceForms() {
        setTitle("Contact Manager");
        setSize(430, 240);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(50, 30, 60, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(120, 30, 255, 25);
        add(nameField);

        JLabel numberLabel = new JLabel("Number");
        numberLabel.setBounds(50, 75, 60, 25);
        add(numberLabel);

        numberField = new JTextField();
        numberField.setBounds(120, 75, 255, 25);
        add(numberField);

        createBtn = new JButton("Create");
        createBtn.setBounds(30, 120, 80, 25);
        add(createBtn);

        readBtn = new JButton("Read");
        readBtn.setBounds(120, 120, 80, 25);
        add(readBtn);

        updateBtn = new JButton("Update");
        updateBtn.setBounds(210, 120, 80, 25);
        add(updateBtn);

        deleteBtn = new JButton("Delete");
        deleteBtn.setBounds(300, 120, 80, 25);
        add(deleteBtn);

        clearBtn = new JButton("Clear");
        clearBtn.setBounds(155, 158, 80, 25);
        add(clearBtn);

        exitBtn = new JButton("Exit");
        exitBtn.setBounds(245, 158, 80, 25);
        add(exitBtn);

        createBtn.addActionListener(this);
        readBtn.addActionListener(this);
        updateBtn.addActionListener(this);
        deleteBtn.addActionListener(this);
        clearBtn.addActionListener(this);
        exitBtn.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String name = nameField.getText();
        String number = numberField.getText();

        if (e.getSource() == createBtn) {
            if (name.equals("") || number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter both Name and Number.");
                return;
            }
            AddFriend.addFriend(name, number);

        } else if (e.getSource() == readBtn) {
            List<String[]> contacts = DisplayFriends.displayFriends(name);
            if (contacts.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Contact not exists in the data.");
                return;
            }
            String result = "";
            for (String[] c : contacts) {
                result += "Name: " + c[0] + "  |  Number: " + c[1] + "\n";
            }
            JOptionPane.showMessageDialog(null, result, "Contacts", JOptionPane.INFORMATION_MESSAGE);

            if (contacts.size() == 1) {
                numberField.setText(contacts.get(0)[1]);
            }

        } else if (e.getSource() == updateBtn) {
            if (name.equals("") || number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter both Name and Number.");
                return;
            }
            UpdateFriend.updateFriend(name, number);

        } else if (e.getSource() == deleteBtn) {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter a Name.");
                return;
            }
            DeleteFriend.deleteFriend(name);

        } else if (e.getSource() == clearBtn) {
            nameField.setText("");
            numberField.setText("");

        } else if (e.getSource() == exitBtn) {
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        new InterfaceForms();
    }
}
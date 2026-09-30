import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BankManagementSystem extends JFrame implements ActionListener {

    JTextField nameField, accountField, amountField;
    JPasswordField pinField;
    JButton createBtn, depositBtn, withdrawBtn, balanceBtn;

    String name = "";
    String accountNumber = "";
    String pin = "";
    double balance = 0;

    BankManagementSystem() {

        setTitle("Bank Management System");
        setSize(450, 450);
        setLayout(new GridLayout(7, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Account Number:"));
        accountField = new JTextField();
        add(accountField);

        add(new JLabel("PIN:"));
        pinField = new JPasswordField();
        add(pinField);

        add(new JLabel("Amount:"));
        amountField = new JTextField();
        add(amountField);

        createBtn = new JButton("Create Account");
        depositBtn = new JButton("Deposit");
        withdrawBtn = new JButton("Withdraw");
        balanceBtn = new JButton("Check Balance");

        add(createBtn);
        add(depositBtn);
        add(withdrawBtn);
        add(balanceBtn);

        createBtn.addActionListener(this);
        depositBtn.addActionListener(this);
        withdrawBtn.addActionListener(this);
        balanceBtn.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == createBtn) {

            name = nameField.getText();
            accountNumber = accountField.getText();
            pin = new String(pinField.getPassword());

            if (name.isEmpty() || accountNumber.isEmpty() || pin.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Please enter all details.");
            } else {
                JOptionPane.showMessageDialog(this,
                        "Account created successfully!");
            }
        }

        else if (e.getSource() == depositBtn) {

            try {
                double amount = Double.parseDouble(amountField.getText());

                if (amount > 0) {
                    balance += amount;

                    JOptionPane.showMessageDialog(this,
                            "Amount deposited successfully!\nBalance: ₹"
                                    + String.format("%.2f", balance));
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Enter a valid amount.");
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Please enter a valid number.");
            }
        }

        else if (e.getSource() == withdrawBtn) {

            try {
                double amount = Double.parseDouble(amountField.getText());

                if (amount <= 0) {
                    JOptionPane.showMessageDialog(this,
                            "Enter a valid amount.");
                }
                else if (amount > balance) {
                    JOptionPane.showMessageDialog(this,
                            "Insufficient balance.");
                }
                else {
                    balance -= amount;

                    JOptionPane.showMessageDialog(this,
                            "Amount withdrawn successfully!\nBalance: ₹"
                                    + String.format("%.2f", balance));
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Please enter a valid number.");
            }
        }

        else if (e.getSource() == balanceBtn) {

            JOptionPane.showMessageDialog(this,
                    "Account Holder: " + name +
                    "\nAccount Number: " + accountNumber +
                    "\nCurrent Balance: ₹" +
                    String.format("%.2f", balance));
        }
    }

    public static void main(String[] args) {
        new BankManagementSystem();
    }
}
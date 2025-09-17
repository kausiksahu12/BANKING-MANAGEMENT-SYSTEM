package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.awt.print.PrinterException;

public class mini extends JFrame implements ActionListener {

    String pin;
    JButton exitBtn, printBtn;
    JTextPane statementPane;  // To hold transaction history

    mini(String pin) {
        this.pin = pin;
        getContentPane().setBackground(new Color(255, 204, 204));
        setSize(500, 600);
        setLocation(100, 50);
        setLayout(new BorderLayout());

        // ====== Title ======
        JLabel title = new JLabel("MINI STATEMENT OLNINE", JLabel.CENTER);
        title.setFont(new Font("System", Font.BOLD, 18));
        add(title, BorderLayout.NORTH);

        // ====== Statement Area (Scrollable) ======
        statementPane = new JTextPane();
        statementPane.setContentType("text/html");  // So we can show HTML formatting
        statementPane.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(statementPane);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane, BorderLayout.CENTER);

        // ====== Buttons ======
        JPanel btnPanel = new JPanel();
        exitBtn = new JButton("Exit");
        printBtn = new JButton("Print / Save PDF");

        exitBtn.setBackground(Color.BLACK);
        exitBtn.setForeground(Color.WHITE);
        printBtn.setBackground(new Color(0, 102, 204));
        printBtn.setForeground(Color.WHITE);

        exitBtn.addActionListener(this);
        printBtn.addActionListener(this);

        btnPanel.add(printBtn);
        btnPanel.add(exitBtn);
        add(btnPanel, BorderLayout.SOUTH);

        // ====== Fetch Data ======
        loadStatement();

        setVisible(true);
    }

    private void loadStatement() {
        try {
            Con c = new Con();

            // Card number fetch
            ResultSet rs1 = c.statement.executeQuery("select * from login where pin = '" + pin + "'");
            String cardNo = "";
            if (rs1.next()) {
                cardNo = rs1.getString("card_number");
                cardNo = cardNo.substring(0, 4) + "XXXXXXXX" + cardNo.substring(12);
            }

            // Transactions
            ResultSet rs2 = c.statement.executeQuery("select * from bank where pin = '" + pin + "'");
            int balance = 0;
            StringBuilder sb = new StringBuilder();
            sb.append("<html><h3>Card Number: " + cardNo + "</h3><br>");
            sb.append("<table border='1' cellspacing='0' cellpadding='5'>");
            sb.append("<tr><th>Date</th><th>Type</th><th>Amount</th></tr>");

            while (rs2.next()) {
                String date = rs2.getString("date");
                String type = rs2.getString("type");
                String amount = rs2.getString("amount");

                sb.append("<tr><td>" + date + "</td><td>" + type + "</td><td>" + amount + "</td></tr>");

                if (type.equals("Deposit")) {
                    balance += Integer.parseInt(amount);
                } else {
                    balance -= Integer.parseInt(amount);
                }
            }
            sb.append("</table>");
            sb.append("<br><h3>Total Balance: Rs " + balance + "</h3></html>");

            statementPane.setText(sb.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exitBtn) {
            setVisible(false);
        } else if (e.getSource() == printBtn) {
            try {
                // Opens Print Dialog → choose "Microsoft Print to PDF"
                boolean done = statementPane.print();
                if (done) {
                    JOptionPane.showMessageDialog(this, "Statement saved/printed successfully!");
                }
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new mini(""); // test with a valid pin
    }
}

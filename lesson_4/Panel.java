package lesson_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Panel extends JFrame implements ActionListener {
    static JTextArea jta;
    static JTextField jtf;
    static JButton jbn;
    public Panel(){
        setTitle("Сетевой чат");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setBounds(300, 300, 300, 500);
        setResizable(false);
        JPanel chatPanel = new JPanel();
        chatPanel.setLayout(new BorderLayout());
        add(chatPanel, BorderLayout.CENTER);
        jta = new JTextArea();
        jta.setEditable(false);
        jta.setLineWrap(true);
        JScrollPane jsp = new JScrollPane(jta);
        chatPanel.add(jsp, BorderLayout.CENTER);

        JPanel messagePanel = new JPanel();
        messagePanel.setLayout(new BorderLayout());
        add(messagePanel, BorderLayout.SOUTH);
        jtf = new JTextField();
        jbn = new JButton("Отправить");

        jtf.addActionListener(this);
        jbn.addActionListener(this);

        messagePanel.add(jtf, BorderLayout.CENTER);
        messagePanel.add(jbn, BorderLayout.EAST);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!jtf.getText().equals("")) {
            jta.append(jtf.getText() + "\n");
            jtf.setText(null);
        }
    }
}
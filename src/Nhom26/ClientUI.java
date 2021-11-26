package Nhom26;

import javax.swing.*;

public class ClientUI extends JFrame{
    private JPanel MainPanel;
    private JPanel LeftPanel;
    private JPanel RightPanel;

    public ClientUI(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(MainPanel);
        this.pack();
    }

    public static void main(String[] args) {
        JFrame frame = new ClientUI("Compiler and Formater");
        frame.setVisible(true);
    }

}

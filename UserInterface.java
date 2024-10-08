import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterface {
    public void CreateAndShowGUI(Main_File mainFile){
        JFrame frame= new JFrame("Banking System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,300);
        frame.setVisible(true);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        JLabel accName = new JLabel("Account Holder Name");
        JTextField name = new JTextField();
        name.setMaximumSize(new Dimension(Integer.MAX_VALUE,30));

        JLabel accNumber = new JLabel("Account Number");
        JTextField number = new JTextField();
        number.setMaximumSize(new Dimension(Integer.MAX_VALUE,30));

        JLabel initialDeposit = new JLabel("Initial Deposit");
        JTextField deposit = new JTextField();
        deposit.setMaximumSize(new Dimension(Integer.MAX_VALUE,30));



        JButton sumbmitBtn = new JButton("Create account");


        panel.add(accName);
        panel.add(name);
        panel.add(Box.createRigidArea(new Dimension(0,10)));

        panel.add(accNumber);
        panel.add(number);
        panel.add(Box.createRigidArea(new Dimension(0,10)));

        panel.add(initialDeposit);
        panel.add(deposit);
        panel.add(Box.createRigidArea(new Dimension(0,10)));

        panel.add(sumbmitBtn);

        frame.add(panel,BorderLayout.CENTER);

        sumbmitBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String Name = name.getText();
                String Number = number.getText();
                String Deposit = deposit.getText();

                JOptionPane.showMessageDialog(frame, "Account Created:"+Name+"\nAccount Number:"+Number+"\nInitial Deposit:"+Deposit);
                mainFile.handleAccountCreation( Name, Number, Deposit,  frame);
            }
        });

    }
}

package ASimulatorSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.ResultSet;

public class FastCash extends JFrame implements ActionListener {
    JButton deposit,withdrawl,ministatement,pinchange,fastcash,balanceenquiry,exit;

    String pinnumber;
    FastCash(String pinnumber){
        this.pinnumber=pinnumber;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text=new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(165,190,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        deposit=new JButton("RS 100");
        deposit.setBounds(160,315,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl=new JButton("RS 500");
        withdrawl.setBounds(360,315,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastcash=new JButton("RS 100");
        fastcash.setBounds(160,348,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        ministatement=new JButton("RS 2000");
        ministatement.setBounds(360,348,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange=new JButton("RS 5000");
        pinchange.setBounds(160,382,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceenquiry=new JButton("RS 10000");
        balanceenquiry.setBounds(360,382,150,30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);

        exit=new JButton("Back");
        exit.setBounds(360,415,150,30);
        exit.addActionListener(this);
        image.add(exit);




        setSize(900,900);
        setLocation(300,0);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==exit){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);


        }else {
            String amount=((JButton)ae.getSource()).getText().substring(3);
            Conn c=new Conn();
            try {
                ResultSet rs=c.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
int balance=0;
while (rs.next()){
if (rs.getString("type").equals("Deposit")){
    balance+=Integer.parseInt(rs.getString("amount"));
}else {
    balance-=Integer.parseInt(rs.getString("amount"));
}


}
if (ae.getSource()!=exit && balance< Integer.parseInt(amount)){
    JOptionPane.showMessageDialog(null,"Insufficient Balance");
return;
}
                Date date=new Date();
String query="insert into bank values('"+pinnumber+"','"+date+"','withdrawl','"+amount+"')";
        c.s.executeUpdate(query);
JOptionPane.showMessageDialog(null,"Rs"+amount+ "Debited successfully");
           setVisible(false);
           new Transactions(pinnumber).setVisible(true);
            }catch (Exception e){
                System.out.println(e);
            }
        }

    }

    public static void main(String[] args) {
        new FastCash("");
    }
}


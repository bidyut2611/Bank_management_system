package ASimulatorSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener {
JRadioButton r1,r2,r3,r4;
JCheckBox c1,c2,c3,c4,c5,c6,c7;
JButton submit,cancel;
String formno;
    SignupThree( String formno){
        this.formno=formno;
        setLayout(null);

        JLabel l1=new JLabel("PAGE 3: ACCOUNT DETAILS");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280,30,400,40);
        add(l1);

        JLabel type=new JLabel(" ACCOUNT TYPE");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100,80,200,30);
        add(type);

r1=new JRadioButton("SAVING ACCOUNT");
r1.setFont(new Font("Raleway", Font.BOLD, 16));
r1.setBackground(Color.WHITE);
r1.setBounds(100,130,200,20);
add(r1);

        r2=new JRadioButton("FIXED DEPOSIT ACCOUNT");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350,130,300,20);
        add(r2);

        r3=new JRadioButton("CURRENT ACCOUNT");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100,190,200,20);
        add(r3);

        r4=new JRadioButton("RECCURING DEPOSIT ACCOUNT");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350,190,300,20);
        add(r4);
        ButtonGroup groupaccount=new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);


        JLabel card=new JLabel(" CARD NUMBER");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100,250,200,30);
        add(card);

        JLabel number=new JLabel("XXXX-XXXX-XXXX-4184");
       number.setFont(new Font("Raleway", Font.BOLD, 22));
        number.setBounds(330,250,300,30);
        add(number);
        JLabel carddetail=new JLabel("YOUR 16 DIGIT CARD NUMBER");
        carddetail.setFont(new Font("Raleway", Font.BOLD, 12));
        carddetail.setBounds(100,290,500,20);
        add(carddetail);

        JLabel pin=new JLabel(" PIN :");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100,320,200,30);
        add(pin);

        JLabel pnumber=new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pnumber.setBounds(330,320,300,30);
        add(pnumber);
        JLabel pindetail=new JLabel("YOUR 4 DIGIT PASSWORD");
        pindetail.setFont(new Font("Raleway", Font.BOLD, 12));
        pindetail.setBounds(100,360,400,20);
        add(pindetail);


        JLabel services=new JLabel(" SERVICES REQUIRED :");
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        services.setBounds(100,400,300,30);
        add(services);

c1=new JCheckBox("ATM CARD");
c1.setBackground(Color.white);
c1.setFont(new Font("Raleway", Font.BOLD, 16));
c1.setBounds(100,440,200,30);
add(c1);

        c2=new JCheckBox("INTERNET BANKING");
        c2.setBackground(Color.white);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(350,440,200,30);
        add(c2);
        c3=new JCheckBox("MOBILE BANKING");
        c3.setBackground(Color.white);
        c3.setFont(new Font("Raleway", Font.BOLD, 15));
        c3.setBounds(100,480,200,30);
        add(c3);
        c4=new JCheckBox("EMAIL & SMS ALERT");
        c4.setBackground(Color.white);
        c4.setFont(new Font("Raleway", Font.BOLD, 15));
        c4.setBounds(350,480,200,30);
        add(c4);
        c5=new JCheckBox("CHEQUE BOOK");
        c5.setBackground(Color.white);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(100,530,200,30);
        add(c5);
        c6=new JCheckBox("E-STATEMENT");
        c6.setBackground(Color.white);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(350,530,200,30);
        add(c6);
        c7=new JCheckBox("I HEREBY DECLARES THAT THE ABOVE ENTERED DETAILS ARE CORRECT TO THE BEST OF MY KNOWLEDGE ");
        c7.setBackground(Color.white);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBounds(100,580,680,30);
        add(c7);

        submit=new JButton("submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
submit.setBounds(250,640,100,30);
submit.addActionListener(this);
add(submit);

        cancel=new JButton("cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(420,640,100,30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.white);

        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
if (ae.getSource()== submit){
   String accountType=null;
   if (r1.isSelected()){
       accountType="Saving Account";
   }else if(r2.isSelected()){
       accountType="Fixed Deposit Account";
   }else if(r3.isSelected()){
       accountType = "Current Account";
   }else if(r4.isSelected()){
       accountType = "Recurring Deposit Account";
   }

    Random random = new Random();
    String   cardnumber ="" + Math.abs ((random.nextLong() % 90000000L) + 5040936000000000L);


    String   pinnumber ="" + Math.abs ((random.nextLong() % 9000L) + 1000L);

    String facility = "";
    if(c1.isSelected()){
        facility = facility + " ATM Card";
    }
   if(c2.isSelected()){
        facility = facility + " Internet Banking";
    }
    if(c3.isSelected()){
        facility = facility + " Mobile Banking";
    }
    if(c4.isSelected()){
        facility = facility + " EMAIL & Sms Alerts";
    }
    if(c5.isSelected()){
        facility = facility + " Cheque Book";
    }
     if(c6.isSelected()){
        facility = facility + " E-Statement";
    }
try{

if (accountType.equals("")){
    JOptionPane.showMessageDialog(null,"Account type is required");
}else {
    Conn conn=new Conn();
String query1= " insert into signupthree values( '"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
    String query2 = "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
conn.s.executeUpdate(query1);
    conn.s.executeUpdate(query2);
JOptionPane.showMessageDialog(null," Card Number "+cardnumber+"\n Pin:" +pinnumber);
setVisible(false);
new Deposit(pinnumber).setVisible(true);


    }


}catch (Exception e){
    System.out.println(e);
}

}else if(ae.getSource()==cancel){
setVisible(false);
new Login().setVisible(true);


}
    }

    public static void main(String[] args) {

        new SignupThree("");
    }
}

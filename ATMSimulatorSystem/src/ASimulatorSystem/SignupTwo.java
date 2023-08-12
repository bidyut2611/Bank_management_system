package ASimulatorSystem;

import javax.swing.*;
import java.awt.*;

import java.awt.event.*;
public class SignupTwo extends JFrame implements ActionListener {

    JTextField pan,aadhar;
    JButton next;
    JRadioButton syes,sno,eyes,eno;

    JComboBox religion,category,occupation,education,income;
    String formno;

    SignupTwo(String formno){
        this.formno=formno;
        setLayout(null);

setTitle("NEW ACCOUNT APPLICATION FORM- PAGE2");


        JLabel additionalDetails=new JLabel("PAGE 2:ADDITIONAL DETAILS");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);

        JLabel name=new JLabel("RELIGION:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100,140,200,30);
        add(name);
        String valReligion[]={"Hindu","Muslim","Sikh","Christian","other"};
         religion =new JComboBox<>(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.white);
        add(religion);


        JLabel fname=new JLabel("CATEGORY:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100,190,200,30);
        add(fname);
        String valCategory[]={"General","OBC","SC","ST","Other"};
        category=new JComboBox(valCategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.white);
        add(category);


        JLabel dob=new JLabel("INCOME:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100,240,200,30);
        add(dob);

        String incomeCategory[]={"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};
        income=new JComboBox(incomeCategory);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.white);
        add(income);


        JLabel gender=new JLabel("EDUCATIONAL");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100,290,200,30);
        add(gender);




        JLabel email=new JLabel("QUALIFICATION:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100,315,200,30);
        add(email);
        String educationValues[]={"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
         education=new JComboBox(educationValues);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.white);
        add(education);



        JLabel marital=new JLabel("OCCUPATION:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100,390,200,30);
        add(marital);

        String occupationValues[]={"Salaried","Self-Employmed","Business","Student","Retired","Others"};
        occupation=new JComboBox(occupationValues);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.white);
        add(occupation);



        JLabel address=new JLabel("PAN NUMBER");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100,440,200,30);
        add(address);
        pan=new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300,440,400,30);
        add(pan);


        JLabel city=new JLabel("AADHAR NUMBER:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100,490,200,30);
        add(city);
        aadhar=new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhar.setBounds(300,490,400,30);
        add(aadhar);

        JLabel state=new JLabel("SENIOR CITIZEN:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100,540,200,30);
        add(state);
        syes= new JRadioButton("YES");
        syes.setBounds(300,540,100,30);
        syes.setFont(new Font("Raleway", Font.BOLD, 14));
        syes.setBackground(Color.WHITE);
        add(syes);
        sno= new JRadioButton("NO");
        sno.setBounds(450,540,140,30);
        sno.setFont(new Font("Raleway", Font.BOLD, 14));
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(syes);
        maritalgroup.add(sno);



        JLabel pincode=new JLabel("EXISTING ACCOUNT:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100,590,200,30);
        add(pincode);

        eyes= new JRadioButton("YES");
        eyes.setBounds(300,590,100,30);
        eyes.setFont(new Font("Raleway", Font.BOLD, 14));
        eyes.setBackground(Color.WHITE);
        add(eyes);
        eno= new JRadioButton("NO");
        eno.setBounds(450,590,140,30);
        eno.setFont(new Font("Raleway", Font.BOLD, 14));
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup emaritalgroup = new ButtonGroup();
        emaritalgroup.add(eyes);
        emaritalgroup.add(eno);


        next=new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.white);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);


    }
    public void actionPerformed(ActionEvent ae){

        String sreligion=(String) religion.getSelectedItem();
        String scategory=(String) category.getSelectedItem();
        String sincome=(String) income.getSelectedItem();
        String seducation=(String) education.getSelectedItem();
        String soccupation=(String) occupation.getSelectedItem();
        String seniorcitizen=null;
        String gender=null;
        if(eyes.isSelected()){
            seniorcitizen = "YES";
        }else if(eno.isSelected()){
            seniorcitizen = "NO";
        }

        String existingaccount= null;
        if(eyes.isSelected()){
            existingaccount = "Yes";
        }else if(eno.isSelected()){
            existingaccount= "NO";
        }

        String span = pan.getText();
        String saadhar = aadhar.getText();


        try{
                Conn c = new Conn();
                String query = "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
                c.s.executeUpdate(query);

setVisible(false);
new SignupThree(formno).setVisible(true);

        }catch(Exception e){
            System.out.println(e);
        }


    }

    public static void main(String args[]){
        new SignupTwo("");



    }
}

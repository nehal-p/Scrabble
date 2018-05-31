package Scrabble;

import javax.swing.*;
import java.awt.event.*;

public class ModifyMember extends JFrame implements ActionListener
{
    private Database d;
    private Member m;
    private JButton mod;
    private JTextField name, contact;
    private JLabel enterName,con;
    private String newName, newCon;
    private int s;

    public ModifyMember(Member m, int s, Database d)
    {
        this.d=d;
        this.m=m;
        this.s=s;
        setVisible(true);
        setSize(800,400);
        setTitle("Modifying Member");
        setLayout(null);
        /*
        s=1 is the condition if the name has to be modified
        s=2 is the condition if the contact has to be modified
         */
        if(s==1)
        {
            mod = new JButton("Modify name of "+m.getName());
            enterName = new JLabel("Enter new name");
            name = new JTextField(20);

            mod.setBounds(300,250,200,25);
            enterName.setBounds(200,100,150,25);
            name.setBounds(450,100,150,25);

            add(mod);
            add(enterName);
            add(name);

            mod.addActionListener(this);
        }
        else if(s==2)
        {
            mod = new JButton("Modify contact of "+m.getName());
            con = new JLabel("Enter new contact");
            contact = new JTextField(20);

            mod.setBounds(300,250,200,25);
            con.setBounds(200,100,150,25);
            contact.setBounds(450,100,150,25);

            add(mod);
            add(con);
            add(contact);

            mod.addActionListener(this);
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        /*
        Makes sure an input is given
        database is updated with the change
        the window is closed after the update
         */
        if(e.getSource()==mod && s==1)
        {
            newName = name.getText();

            if(newName.length()==0)
                new InputError("Please enter new Name", "Error");
            else
            {
                d.update(m,newName,s);
                dispose();
            }
        }
        else if(e.getSource()==mod && s==2)
        {
            newCon = contact.getText();

            if(newCon.length()==0)
                new InputError("Please enter new Contact", "Error");
            else
            {
                d.update(m,newCon,s);
                dispose();
            }
        }
    }
}

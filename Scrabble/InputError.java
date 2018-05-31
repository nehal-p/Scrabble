package Scrabble;

import javax.swing.*;
import java.awt.*;

public class InputError extends JFrame
{
    /*
    Opens a small window for errors or confirmation
     */
    private JLabel jl;
    public InputError(String s, String title)
    {
        setVisible(true);
        setSize(300,100);
        setTitle(title);
        jl= new JLabel(s);
        add(jl);
        setLayout(new FlowLayout());
    }
}

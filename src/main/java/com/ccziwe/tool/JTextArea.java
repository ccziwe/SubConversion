package com.ccziwe.tool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class JTextArea extends Component implements ActionListener {
    JFrame jf;
    JPanel jpanel;
    JButton jb1, jb2, jb3, update;
    javax.swing.JTextArea jta = null;
    JScrollPane jscrollPane;
    JTextField textField = new JTextField();

    public JTextArea() throws IOException {


        jf = new JFrame("vmess更新");
        Container contentPane = jf.getContentPane();
        contentPane.setLayout(new BorderLayout());


        jta = new javax.swing.JTextArea(10, 15);
        jta.setTabSize(4);
        jta.setFont(new Font("标楷体", Font.BOLD, 16));
        jta.setLineWrap(true);
        jta.setWrapStyleWord(true);
        jta.setBackground(Color.pink);

        jscrollPane = new JScrollPane(jta);
        jpanel = new JPanel();
        jpanel.setLayout(new GridLayout(1, 3));


        jta.setEditable(false);


        update = new JButton("更新vmess");

        jpanel.add(textField);
        jpanel.add(update);

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    updateVmess();
                } catch (UnsupportedEncodingException unsupportedEncodingException) {
                    unsupportedEncodingException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        contentPane.add(jscrollPane, BorderLayout.CENTER);
        contentPane.add(jpanel, BorderLayout.SOUTH);


        jf.setSize(400, 300);
        jf.setLocation(400, 200);
        jf.setVisible(true);

        jf.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jb1) {
            jta.copy();
        } else if (e.getSource() == jb2) {
            jta.paste();
        } else if (e.getSource() == jb3) {
            jta.cut();
        }
    }


    public void updateVmess() throws IOException {
        String str = textField.getText();
        String jiemi = DESUtil.decrypt("key986800401ccziwe", str);
        ArrayList<VmessBaen> list = SubConversion.parsingVmess(jiemi);
       // System.out.println(jiemi);
        StringBuffer sb = new StringBuffer();
        for (VmessBaen tmp : list) {
            sb.append(tmp.getSourceVmess());
        }
        jta.setText(String.valueOf(sb));
    }

    public static void main(String[] args) throws IOException {
        new JTextArea();
    }


}

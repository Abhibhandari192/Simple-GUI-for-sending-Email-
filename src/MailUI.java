import java.awt.Button;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class MailUI extends JFrame implements ActionListener{
	
	JTextField to_field,sub_field;
	JTextArea body_field;
	JButton bt_words,bt_letter,reset;
	JLabel to,subject,body,status;
	static Sendmail sn;
	
	byte count=0;
	public MailUI() {
		
		JFrame jf=new JFrame();
		jf.setTitle("Simple Mailer");
		
		to=new JLabel("To:");
		to.setBounds(5, 5, 20, 20);
		to_field=new JTextField();
		to_field.setBounds(5,25,275,30);
		
		subject=new JLabel("Subject:");
		subject.setBounds(5, 60, 80, 20);
		sub_field=new JTextField();
		sub_field.setBounds(5,80,275,30);
		
		body=new JLabel("Body:");
		body.setBounds(5, 120, 75, 20);
		body_field=new JTextArea();
		body_field.setBounds(5,140,275,100);
	
		
		reset=new JButton("Send email");
		reset.setBounds(20, 270, 230, 40);
		reset.addActionListener(this);
		
		status=new JLabel();
		status.setBounds(5, 320, 120, 20);
		
		jf.add(to);
		jf.add(to_field);
		
		jf.add(subject);
		jf.add(sub_field);
		
		jf.add(body);
		jf.add(body_field);
		
		
		jf.add(reset);
		
		jf.add(status);
		
		jf.setSize(300,380);
		jf.setLayout(null);
		jf.setVisible(true);
		
			
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==reset)
		{			
			status.setText(sn.sendmails(to_field.getText().toString(), sub_field.getText().toString(), body_field.getText().toString()));
		}
	}
	
	public static void main(String a[])
	{
		MailUI mail=new MailUI();
		sn=new Sendmail();
		
	}
	
}
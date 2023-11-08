import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class EBill {

	private JFrame frmEbillManagament;
	private JTextField txtid;
	private JTextField txtname;
	private JTextField txtunit;
	private JLabel txtprint;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EBill window = new EBill();
					window.frmEbillManagament.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EBill() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEbillManagament = new JFrame();
		frmEbillManagament.setTitle("EBill Managament");
		frmEbillManagament.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		frmEbillManagament.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ELECTRICITY  BILL MANAGEMENT");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(22, 32, 271, 30);
		frmEbillManagament.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(66, 73, 293, 241);
		frmEbillManagament.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel cid = new JLabel("Customer Id");
		cid.setBounds(10, 30, 83, 28);
		panel.add(cid);
		
		JLabel cname = new JLabel("Customer Name");
		cname.setBounds(10, 80, 83, 28);
		panel.add(cname);
		
		JLabel cunit = new JLabel(" Unit");
		cunit.setBounds(10, 126, 83, 28);
		panel.add(cunit);
		
		txtid = new JTextField();
		txtid.setBounds(115, 34, 168, 20);
		panel.add(txtid);
		txtid.setColumns(10);
		
		txtname = new JTextField();
		txtname.setColumns(10);
		txtname.setBounds(115, 84, 168, 20);
		panel.add(txtname);
		
		txtunit = new JTextField();
		txtunit.setColumns(10);
		txtunit.setBounds(115, 130, 168, 20);
		panel.add(txtunit);
		
		JButton btncal = new JButton("Calculate");
		btncal.addActionListener(new ActionListener() {
			int total,charges,count;
			
			public void print() {
				  String cid,cname;
				
				   cid=txtid.getText();
				   cname=txtname.getText();
				   String cunit=txtunit.getText();
				   
				   txtprint.setText(txtprint.getText()+ "\n");
				   txtprint.setText(txtprint.getText()+ "Electricity Billing System"+"\n");
				   txtprint.setText(txtprint.getText()+ "\n");
				   txtprint.setText(txtprint.getText()+ "Customer ID"+ cid+"\n");
				   txtprint.setText(txtprint.getText()+ "Unit"+ cunit+"\n");
				   txtprint.setText(txtprint.getText()+ "Amount"+ total +"\n");

				   
				   
				   
			}
			public void actionPerformed(ActionEvent e) {
				
				count=Integer.parseInt(txtunit.getText());
				if(count<500) {
					charges=1;
				}
				else if(count>=500 && count<700) {
					charges=2;
				}
				else if(count>=700) {
					charges=3;
				}
				total=charges*count;
				print();
				
			}
		});
		btncal.setBounds(26, 178, 89, 37);
		panel.add(btncal);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(166, 178, 89, 37);
		panel.add(btnClear);
		
		JButton btnprint = new JButton("Print");
		btnprint.setBounds(531, 332, 100, 30);
		frmEbillManagament.getContentPane().add(btnprint);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(389, 73, 364, 241);
		frmEbillManagament.getContentPane().add(textArea);
		frmEbillManagament.setBounds(100, 100, 794, 432);
		frmEbillManagament.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

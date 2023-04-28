package vn.viettuts.qlsv.view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import vn.viettuts.qlsv.dao.CustomerFunc;
import vn.viettuts.qlsv.entity.Customer;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.UIManager;

public class TinhTienView extends JFrame {

	private JPanel contentPane;
	private JTable table;

	private String [] columnNames = new String [] {
            "STT","Mã Khách Hàng","Mã Sản Phẩm", "Tên Sản Phẩm","Số Lượng", "Giá Bán"};
	private Object data = new Object [][] {};
	private JTextField tfTongTien;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerFunc customerDao = new CustomerFunc();
					SearchView frame = new SearchView();
					frame.setVisible(true);
					frame.showListcustomers(customerDao.getlistCustomers());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void showThongKe(int total) {
    	tfTongTien.setText(Integer.toString(total));
    }
	public TinhTienView() {
		setBounds(100, 100, 567, 434);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane mainPanel = new JScrollPane();
		mainPanel.setBounds(10, 71, 531, 241);
		contentPane.add(mainPanel);
		
		
		table = new JTable();
        table.setModel(new DefaultTableModel((Object[][]) data, columnNames));
        mainPanel.setViewportView(table);
        mainPanel.setPreferredSize(new Dimension (480, 300));
        
        JLabel lblNewLabel = new JLabel("Hóa Đơn Thanh Toán");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel.setBounds(193, 11, 220, 37);
        contentPane.add(lblNewLabel);
        
        tfTongTien = new JTextField();
        tfTongTien.setBackground(new Color(245, 255, 250));
        tfTongTien.setBounds(395, 325, 96, 27);
        contentPane.add(tfTongTien);
        tfTongTien.setColumns(10);
        
        lblNewLabel_1 = new JLabel("Tổng Tiền:");
        lblNewLabel_1.setIcon(new ImageIcon(TinhTienView.class.getResource("/Images/Dollar.png")));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(276, 323, 109, 27);
        contentPane.add(lblNewLabel_1);
        
        lblNewLabel_2 = new JLabel("VND");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_2.setBounds(501, 323, 40, 27);
        contentPane.add(lblNewLabel_2);
        
        JLabel lblNewLabel_1_1 = new JLabel("Cảm ơn quý khách - Hẹn gặp lại!");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_1_1.setBounds(163, 361, 250, 27);
        contentPane.add(lblNewLabel_1_1);
	}
	public void showListcustomers(List<Customer> list) {
       	int size = list.size();
        Object [][] customers = new Object[size][6];
        for (int i = 0; i < size; i++) {
        	customers[i][0] = i+1 + ")";
        	customers[i][1] = list.get(i).getMaKH();
            customers[i][2] = list.get(i).getMaSP();
            customers[i][3] = list.get(i).getTenSP();
            customers[i][4] = list.get(i).getSoLuong();
            customers[i][5] = list.get(i).getGiaBan();
        }
        table.setModel(new DefaultTableModel(customers, columnNames));
    }
}

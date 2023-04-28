package vn.viettuts.qlsv.view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import vn.viettuts.qlsv.dao.CustomerFunc;
import vn.viettuts.qlsv.entity.Customer;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;

public class SearchView extends JFrame {

	private JPanel contentPane;
	private JTable table;

	private String [] columnNames = new String [] {
			"Mã Khách Hàng","Mã Sản Phẩm", "Tên Sản Phẩm", "Số Lượng", "Giá Bán"};
	private Object data = new Object [][] {};

	public SearchView() {
		setTitle("TIM KIEM THEO MA  KHACH HANG");
		setAlwaysOnTop(true);
		setBounds(100, 100, 500, 299);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane mainPanel = new JScrollPane();
		mainPanel.setBounds(10, 10, 466, 241);
		contentPane.add(mainPanel);
		
		
		table = new JTable();
        table.setModel(new DefaultTableModel((Object[][]) data, columnNames));
        mainPanel.setViewportView(table);
        mainPanel.setPreferredSize(new Dimension (480, 300));
	}
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

	public void showListcustomers(List<Customer> list) {
       	int size = list.size();
        Object [][] customers = new Object[size][5];
        for (int i = 0; i < size; i++) {
        	customers[i][0] = list.get(i).getMaKH();
            customers[i][1] = list.get(i).getMaSP();
            customers[i][2] = list.get(i).getTenSP();
            customers[i][3] = list.get(i).getSoLuong();
            customers[i][4] = list.get(i).getGiaBan();
        }
        table.setModel(new DefaultTableModel(customers, columnNames));
    }

}

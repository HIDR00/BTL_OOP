package vn.viettuts.qlsv.view;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import vn.viettuts.qlsv.dao.CustomerFunc;
import vn.viettuts.qlsv.entity.Customer;


import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.Color;

public class CartView extends JFrame {

	private JButton addcustomerBtn;
    private JButton editcustomerBtn;
    private JButton deletecustomerBtn;
    private JButton clearBtn;
    private JButton btTinhTien;
    private JButton btaddKH;
    private JButton btSearchTenSP;
    private JButton btSearch;
	private JPanel contentPane;
	private JTextField maKHField;
	private JTextField maSPField;
	private JTextField TenSPField;
	private JTextField GiaBanField;
	private JTextField tfSearch;
	private JTextField tfTinhTien;
	private JTable table;
	// định nghĩa các cột của bảng customer
    private String [] columnNames = new String [] {
            "Mã Khách Hàng","Mã Sản Phẩm", "Tên Sản Phẩm", "Số Lượng", "Giá Bán"};
    // định nghĩa dữ liệu mặc định của bẳng customer là rỗng
    private Object data = new Object [][] {};
    private JTextField tfTongSP;
    private JTextField tfTongKH;
    private JButton btnNewButton;
    private JTextField textField;
    private JLabel lblNewLabel_1;
    private JTextField SoLuongField;
    private JLabel lblTmKimM;
    private JTextField tfSearchTenSP;
    private JButton btSortMaSP;
    private JButton btSortSoLuong;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CartView frame = new CartView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
	public CartView() {
		setTitle("QUẢN LÍ BÁN HÀNG SIÊU THỊ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1078, 644);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 248, 255));
		panel.setBounds(0, 10, 1055, 597);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(230, 230, 250));
		panel_1.setBounds(10, 10, 416, 577);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã Khách Hàng:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 16, 113, 32);
		panel_1.add(lblNewLabel);
		
		maKHField = new JTextField();
		maKHField.setBackground(new Color(245, 255, 250));
		maKHField.setBounds(133, 18, 273, 32);
		panel_1.add(maKHField);
		maKHField.setColumns(10);
		maKHField.setEditable(false);
		
		JLabel lblMaSanPham = new JLabel("Mã Sản Phẩm:");
		lblMaSanPham.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMaSanPham.setBounds(10, 72, 113, 32);
		panel_1.add(lblMaSanPham);
		
		maSPField = new JTextField();
		maSPField.setBackground(new Color(245, 255, 250));
		maSPField.setColumns(10);
		maSPField.setBounds(131, 72, 275, 32);
		panel_1.add(maSPField);
		
		TenSPField = new JTextField();
		TenSPField.setBackground(new Color(245, 255, 250));
		TenSPField.setColumns(10);
		TenSPField.setBounds(131, 126, 275, 32);
		panel_1.add(TenSPField);
		
		GiaBanField = new JTextField();
		GiaBanField.setBackground(new Color(245, 255, 250));
		GiaBanField.setColumns(10);
		GiaBanField.setBounds(131, 235, 275, 32);
		panel_1.add(GiaBanField);
		
		JLabel lblTenSanPham = new JLabel("Tên Sản Phẩm:");
		lblTenSanPham.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenSanPham.setBounds(10, 126, 113, 32);
		panel_1.add(lblTenSanPham);
		
		JLabel lblGiaBan = new JLabel("Giá Bán:");
		lblGiaBan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGiaBan.setBounds(10, 233, 113, 32);
		panel_1.add(lblGiaBan);
		
		addcustomerBtn = new JButton("Add");
		addcustomerBtn.setIcon(new ImageIcon(CartView.class.getResource("/Images/Add.png")));
		addcustomerBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		addcustomerBtn.setBounds(10, 276, 90, 35);
		panel_1.add(addcustomerBtn);
		
		editcustomerBtn = new JButton("Edit");
		editcustomerBtn.setIcon(new ImageIcon(CartView.class.getResource("/Images/Edit.png")));
		editcustomerBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		editcustomerBtn.setBounds(105, 278, 90, 35);
		panel_1.add(editcustomerBtn);
		
		deletecustomerBtn = new JButton("Delete");
		deletecustomerBtn.setIcon(new ImageIcon(CartView.class.getResource("/Images/Delete.png")));
		deletecustomerBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		deletecustomerBtn.setBounds(202, 278, 100, 35);
		panel_1.add(deletecustomerBtn);
		
		clearBtn = new JButton("Clear");
		clearBtn.setIcon(new ImageIcon(CartView.class.getResource("/Images/Close.png")));
		clearBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		clearBtn.setBounds(306, 278, 100, 35);
		panel_1.add(clearBtn);
		
		JLabel lblTimKiem = new JLabel("Tìm Kiếm Mã KH:");
		lblTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTimKiem.setBounds(10, 378, 129, 27);
		panel_1.add(lblTimKiem);
		
		tfSearch = new JTextField();
		tfSearch.setBackground(new Color(245, 255, 250));
		tfSearch.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tfSearch.setColumns(10);
		tfSearch.setBounds(165, 379, 206, 27);
		panel_1.add(tfSearch);
		
		btSearch  = new JButton("Tìm kiếm theo mã KH");
		btSearch.setIcon(new ImageIcon(CartView.class.getResource("/Images/Search.png")));
		btSearch.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		btSearch.setBounds(89, 415, 213, 25);
		panel_1.add(btSearch);
		
		btTinhTien = new JButton("Tính tiền cho khách");
		btTinhTien.setIcon(new ImageIcon(CartView.class.getResource("/Images/Dollar.png")));
		btTinhTien.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btTinhTien.setBounds(10, 523, 190, 27);
		panel_1.add(btTinhTien);
		
		tfTinhTien = new JTextField();
		tfTinhTien.setBackground(new Color(245, 255, 250));
		tfTinhTien.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tfTinhTien.setBounds(227, 523, 179, 27);
		panel_1.add(tfTinhTien);
		tfTinhTien.setColumns(10);
		
		JLabel lblSoLuong = new JLabel("Số Lượng:");
		lblSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSoLuong.setBounds(10, 178, 113, 32);
		panel_1.add(lblSoLuong);
		
		SoLuongField = new JTextField();
		SoLuongField.setBackground(new Color(245, 255, 250));
		SoLuongField.setColumns(10);
		SoLuongField.setBounds(131, 180, 275, 32);
		panel_1.add(SoLuongField);
		
		lblTmKimM = new JLabel("Tìm Kiếm Tên SP:");
		lblTmKimM.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTmKimM.setBounds(10, 450, 129, 27);
		panel_1.add(lblTmKimM);
		
		tfSearchTenSP = new JTextField();
		tfSearchTenSP.setBackground(new Color(245, 255, 250));
		tfSearchTenSP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tfSearchTenSP.setColumns(10);
		tfSearchTenSP.setBounds(165, 451, 206, 27);
		panel_1.add(tfSearchTenSP);
		
		btSearchTenSP = new JButton("Tìm kiếm theo tên SP");
		btSearchTenSP.setIcon(new ImageIcon(CartView.class.getResource("/Images/Search.png")));
		btSearchTenSP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btSearchTenSP.setBounds(89, 488, 213, 25);
		panel_1.add(btSearchTenSP);
		
		btaddKH = new JButton("Thêm 1 khách hàng");
		btaddKH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btaddKH.setBounds(105, 338, 196, 21);
		panel_1.add(btaddKH);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(436, 10, 609, 577);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane listPanel = new JScrollPane();
		listPanel.setBounds(10, 10, 589, 346);
		panel_2.add(listPanel);
		
		table = new JTable();
        table.setModel(new DefaultTableModel((Object[][]) data, columnNames));
        listPanel.setViewportView(table);
        listPanel.setPreferredSize(new Dimension (480, 300));
        
        tfTongSP = new JTextField();
        tfTongSP.setBackground(new Color(245, 255, 250));
        tfTongSP.setFont(new Font("Tahoma", Font.PLAIN, 13));
        tfTongSP.setBounds(503, 366, 96, 27);
        panel_2.add(tfTongSP);
        tfTongSP.setColumns(10);
        
        tfTongKH = new JTextField();
        tfTongKH.setBackground(new Color(245, 255, 250));
        tfTongKH.setFont(new Font("Tahoma", Font.PLAIN, 13));
        tfTongKH.setBounds(183, 370, 96, 27);
        panel_2.add(tfTongKH);
        tfTongKH.setColumns(10);
        
        lblNewLabel_1 = new JLabel("Tổng số khách hàng:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1.setBounds(20, 369, 165, 27);
        panel_2.add(lblNewLabel_1);
        
        JLabel lblNewLabel_1_1 = new JLabel("Tổng số sản phẩm:");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_1.setBounds(355, 367, 150, 27);
        panel_2.add(lblNewLabel_1_1);
        
        btSortMaSP = new JButton("Sort Mã Sản Phẩm");
        btSortMaSP.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btSortMaSP.setBounds(81, 445, 160, 27);
        panel_2.add(btSortMaSP);
        
        btSortSoLuong = new JButton("Sort Số Lượng");
        btSortSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btSortSoLuong.setBounds(407, 445, 160, 27);
        panel_2.add(btSortSoLuong);
	}
	public void fillCustomerFromSelectedRow() {
        int row = table.getSelectedRow();
        System.out.println(row);
        if (row >= 0) {
            maKHField.setText(table.getModel().getValueAt(row, 0).toString());
            maSPField.setText(table.getModel().getValueAt(row, 1).toString());
            TenSPField.setText(table.getModel().getValueAt(row, 2).toString());
            SoLuongField.setText(table.getModel().getValueAt(row,3).toString());
            GiaBanField.setText(table.getModel().getValueAt(row, 4).toString());
            // enable Edit and Delete buttons
            editcustomerBtn.setEnabled(true);
            deletecustomerBtn.setEnabled(true);
            // disable Add button
            addcustomerBtn.setEnabled(false);
        }
    }
	public void clearCustomerInfo() {
    	maKHField.setText("");
        maSPField.setText("");
        TenSPField.setText("");
        SoLuongField.setText("");
        GiaBanField.setText("");
        // disable Edit and Delete buttons
        editcustomerBtn.setEnabled(false);
        deletecustomerBtn.setEnabled(false);
        // enable Add button
        addcustomerBtn.setEnabled(true);
    }
	public void showcustomer(Customer customer) {
    	maKHField.setText(""+customer.getMaKH());
        maSPField.setText(customer.getMaSP());
        TenSPField.setText(customer.getTenSP());
        SoLuongField.setText("" + customer.getSoLuong());
        GiaBanField.setText("" + customer.getGiaBan());
        // enable Edit and Delete buttons
        editcustomerBtn.setEnabled(true);
        deletecustomerBtn.setEnabled(true);
        // disable Add button
        addcustomerBtn.setEnabled(false);
    }
	public void showThongKe(int total) {
    	tfTongKH.setText(Integer.toString(total));
    }
	public void showThongKeSP(int total) {
    	tfTongSP.setText(Integer.toString(total));
    }
	
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
	public Customer getcustomerInfo() {
        // validate customer
        if (!validateTenSP() || !validatemaSP()) {
            return null;
        }
        try {
            Customer customer = new Customer();
            if (maKHField.getText() != null && !"".equals(maKHField.getText())) {
                customer.setMaKH(Integer.parseInt(maKHField.getText().trim()));
            }
            customer.setMaSP(maSPField.getText().trim());
            customer.setTenSP(TenSPField.getText().trim());
            customer.setSoLuong(Integer.parseInt(SoLuongField.getText()));
            customer.setGiaBan(Integer.parseInt(GiaBanField.getText()));
            return customer;
        } catch (Exception e) {
            showMessage(e.getMessage());
        }
        return null;
    }
	private boolean validateTenSP() {
        String name = TenSPField.getText();
        if (name == null || "".equals(name.trim())) {
            TenSPField.requestFocus();
            showMessage("Tên sản phẩm không được trống.");
            return false;
        }
        return true;
    }
	private boolean validatemaSP() {
        String maSP = maSPField.getText();
        if (maSP == null || "".equals(maSP.trim())) {
            maSPField.requestFocus();
            showMessage("Mã sản phẩm không được trống.");
            return false;
        }
        return true;
    
}
	
	public int getCustomermaKH() {
		return Integer.parseInt(tfSearch.getText());
		}
	public String getTenSP() {
		return tfSearchTenSP.getText().trim();
		}
	public int getCustomerTfTinhTien() {
		return Integer.parseInt(tfTinhTien.getText());
		}
	public void actionPerformed(ActionEvent e) {
    }
    
    public void valueChanged(ListSelectionEvent e) {
    }
    public void addSearchcustomerListener(ActionListener listener) {
    	
    	btSearch.addActionListener(listener);
    }
    public void addAddcustomerListener(ActionListener listener) {
        addcustomerBtn.addActionListener(listener);
    }
    
    public void addEditcustomerListener(ActionListener listener) {
        editcustomerBtn.addActionListener(listener);
    }
    
    public void addDeletecustomerListener(ActionListener listener) {
        deletecustomerBtn.addActionListener(listener);
    }
    
    public void addClearListener(ActionListener listener) {
        clearBtn.addActionListener(listener);
    }
    public void addSearchMaSPListener(ActionListener listener) {
        btSearchTenSP.addActionListener(listener);
    }
    public void addTinhTienListener(ActionListener listener) {
    	btTinhTien.addActionListener(listener);
   }
    public void addSortSLListener(ActionListener listener) {
        btSortSoLuong.addActionListener(listener);
    }
    
    public void addSortMaSPListener(ActionListener listener) {
        btSortMaSP.addActionListener(listener);
    }
    public void addaddKHListener(ActionListener listener) {
        btaddKH.addActionListener(listener);
    }
    
    public void addListcustomerSelectionListener(ListSelectionListener listener) {
        table.getSelectionModel().addListSelectionListener(listener);
    }
}

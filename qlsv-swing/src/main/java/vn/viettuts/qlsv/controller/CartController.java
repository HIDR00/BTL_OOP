package vn.viettuts.qlsv.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import vn.viettuts.qlsv.controller.CartController.AddCustomerListener;
import vn.viettuts.qlsv.controller.CartController.ClearStudentListener;
import vn.viettuts.qlsv.controller.CartController.DeletecustomerListener;
import vn.viettuts.qlsv.controller.CartController.EditcustomerListener;

import vn.viettuts.qlsv.dao.CustomerFunc;
import vn.viettuts.qlsv.entity.Customer;
import vn.viettuts.qlsv.view.CartView;
import vn.viettuts.qlsv.view.SearchView;
import vn.viettuts.qlsv.view.TinhTienView;
import vn.viettuts.qlsv.view.SearchMaSPView;

public class CartController {
	private CartView view;
	private CustomerFunc customerDao;
	
	public CartController(CartView view) {
        this.view = view;
        customerDao = new CustomerFunc();
        view.addAddcustomerListener(new AddCustomerListener());
        view.addEditcustomerListener(new EditcustomerListener());
        view.addDeletecustomerListener(new DeletecustomerListener());
        view.addClearListener(new ClearStudentListener());
        view.addListcustomerSelectionListener(new ListCustomerSelectionListener());
        view.addSearchcustomerListener(new SearchCustomerListener());
        view.addSearchMaSPListener(new SearchTenSPListener());
        view.addTinhTienListener(new ThongKeListener());
        view.addSortMaSPListener(new SortMaSPListener());
        view.addSortSLListener(new SortSLListener());
        view.addaddKHListener(new AddaddmaListener());
        thongKe();
        thongKeSP();
    }

	
	public void thongKe() {
		int tong = customerDao.getDistinctCustomerNumber();
    	view.showThongKe(tong);  
	}
	public void thongKeSP() {
		int tong = customerDao.getDistinctCustomerSPNumber();
    	view.showThongKeSP(tong);  
	}
	public void showStudentView() {
        List<Customer> customerList = this.customerDao.getlistCustomers();
        view.setVisible(true);
        view.showListcustomers(customerList);
    }
	
	class AddaddmaListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	customerDao.maKH();
        	view.showMessage("Đã thêm khách hàng, mời nhập thông tin");
        }
    }
	class AddCustomerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Customer customer = view.getcustomerInfo();
            if (customer != null) {
                customerDao.add(customer);		
                view.showcustomer(customer);
                view.showListcustomers(customerDao.getlistCustomers());
                view.showMessage("Thêm thành công!");
                thongKe();
                thongKeSP();
            }
        }
    }
	
	
	class EditcustomerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Customer customer = view.getcustomerInfo();
            if (customer != null) {
                customerDao.edit(customer);
                view.showcustomer(customer);
                view.showListcustomers(customerDao.getlistCustomers());
                view.showMessage("Cập nhật thành công!");
                thongKe();
                thongKeSP();
            }
        }
    }
	
	
	class DeletecustomerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	Customer customer = view.getcustomerInfo();
            if (customer != null) {
                customerDao.delete(customer);
                view.clearCustomerInfo();
                view.showListcustomers(customerDao.getlistCustomers());
                view.showMessage("Xóa thành công!");
                thongKe();
                thongKeSP();
            }
        }
    }
	class SearchCustomerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	int MaKH = view.getCustomermaKH();
            List<Customer> customerList = customerDao.getCustomerMaKH(MaKH);


                     
           
            if (customerList.size() > 0) {
            	SearchView s = new SearchView();
            	s.setVisible(true);
            	s.showListcustomers(customerList);
            } else {
                view.showMessage("Không tìm thấy ma khach hang: " + MaKH);
            }
        }
    }
	class SearchTenSPListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	String TenSP = view.getTenSP();
            List<Customer> customerList = customerDao.getTenSP(TenSP);            
            if (customerList.size() > 0) {
            	SearchMaSPView s = new SearchMaSPView();
            	s.setVisible(true);
            	s.showListcustomers(customerList);
            } else {
                view.showMessage("Không tìm thấy ma san pham: " + TenSP);
            }
        }
    }
	class ThongKeListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	int MaKH = view.getCustomerTfTinhTien();
            List<Customer> customerList = customerDao.getCustomerMaKH(MaKH);
            int tong = 0;
            for(Customer customer : customerList) {
            	tong+= customer.getGiaBan() * customer.getSoLuong();
            }
			
        	TinhTienView tt = new TinhTienView();
        	tt.setVisible(true);
        	tt.showListcustomers(customerList);
        	tt.showThongKe(tong);         
           
            if (customerList != null) {
                view.showMessage("Tinh Tien thành công!");
            } else {
                view.showMessage("Không tìm thấy ma khach hang: " + MaKH);
            }
        }
    }
	
	class SortSLListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	customerDao.sortCustomerSL();
            view.showListcustomers(customerDao.getlistCustomers());
        
        }
    }
	class SortMaSPListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            customerDao.sortMaSP();
            view.showListcustomers(customerDao.getlistCustomers());
        }
    }
	class ClearStudentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.clearCustomerInfo();
            thongKe();
            thongKeSP();
        }
    }
	class ListCustomerSelectionListener implements ListSelectionListener {
      public void valueChanged(ListSelectionEvent e) {
          view.fillCustomerFromSelectedRow();
      }
  }
}

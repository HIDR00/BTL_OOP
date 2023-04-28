package vn.viettuts.qlsv.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import vn.viettuts.qlsv.entity.Customer;
import vn.viettuts.qlsv.entity.Customer;
import vn.viettuts.qlsv.controller.CartController;

import vn.viettuts.qlsv.entity.CustomerXML;
import vn.viettuts.qlsv.utils.FileUtils;


public class CustomerFunc {
	private static final String STUDENT_FILE_NAME = "customer.xml";
    private List<Customer> listCustomers;
    
    
    
    public CustomerFunc() {
        this.listCustomers = readlistCustomers();
        if (listCustomers == null) {
            listCustomers = new ArrayList<Customer>();
        }
    }

    
    
    public void writeListCostumers(List<Customer> customer) {
        CustomerXML customerXML = new CustomerXML();
        customerXML.setStudent(customer);
        FileUtils.writeXMLtoFile(STUDENT_FILE_NAME, customerXML);
    }

    /**
     * Đọc các đối tượng Customer từ file Customer.xml
     * 
     * @return list Customer
     */
    public List<Customer> readlistCustomers() {
        List<Customer> list = new ArrayList<Customer>();
        CustomerXML customerXML = (CustomerXML) FileUtils.readXMLFile(
        STUDENT_FILE_NAME, CustomerXML.class);
        if (customerXML != null) {
            list = customerXML.getStudent();
        }
        return list;
    }
    
    public static void main(String[] args)
    {
    	CustomerFunc customerDao = new CustomerFunc();
    }

    /**
     * thêm Customer vào listCustomers và lưu listCustomers vào file
     * 
     * @param Customer
     */
    public int getLastMaKH() {
    	Customer customer;
    	customer =  listCustomers.get(listCustomers.size()-1);
    	return customer.getMaKH();
    }
    public int count = 0;
    public void getLastMaKH1() {
    	count = getLastMaKH(); 
    }
    public void maKH() {
    	this.count+=1;
    }
    public void add(Customer customer) {
    	if(count == 0) {
    		getLastMaKH1();
    	}
    	int maKH = this.count;
    	customer.setMaKH(maKH);
        listCustomers.add(customer);	
        writeListCostumers(listCustomers);
    }

    /**
     * cập nhật Customer vào listCustomers và lưu listCustomers vào file
     * 
     * @param Customer
     */
    public void edit(Customer customer) {
        int size = listCustomers.size();
        for (int i = 0; i < size; i++) {
            if (listCustomers.get(i).getMaSP().equals(customer.getMaSP()) & listCustomers.get(i).getMaKH() == customer.getMaKH()) {
            	listCustomers.get(i).setMaKH(customer.getMaKH());
                listCustomers.get(i).setTenSP(customer.getTenSP());
                listCustomers.get(i).setSoLuong(customer.getSoLuong());
                listCustomers.get(i).setGiaBan(customer.getGiaBan());
                writeListCostumers(listCustomers);
                break;
            }
        }
    }
    
    /**
     * xóa Customer từ listCustomers và lưu listCustomers vào file
     * 
     * @param Customer
     */
    public boolean delete(Customer customer) {
        boolean isFound = false;
        int size = listCustomers.size();
        for (int i = 0; i < size; i++) {
            if (listCustomers.get(i).getMaSP().equals(customer.getMaSP()) & listCustomers.get(i).getMaKH() == customer.getMaKH()) {
                customer = listCustomers.get(i);
                isFound = true;
                break;
            }
        }
        if (isFound) {
            listCustomers.remove(customer);
            writeListCostumers(listCustomers);
            return true;
        }
        return false;
    }
    public List<Customer> getCustomerMaKH(int maKH) {
    	List<Customer> customerList = new ArrayList<>(); 
    	for ( Customer customer : listCustomers) {
    		if (customer.getMaKH() == maKH) {
    			customerList.add(customer);	
    		}
    	}
    	return customerList;
    }
    public List<Customer> getTenSP(String TenSP) {
    	List<Customer> customerList = new ArrayList<>(); 
    	for ( Customer customer : listCustomers) {
    		if (customer.getTenSP().toLowerCase().contains(TenSP.toLowerCase())) {
    			customerList.add(customer);	
    		}
    	}
    	return customerList;
    }
    public List<Customer> getCustomerTfTinhTien(int maKH) {
    	List<Customer> customerList = new ArrayList<>(); 
    	for ( Customer customer : listCustomers) {
    		if (customer.getMaKH() == maKH) {
    			customerList.add(customer);	
    		}
    	}
    	return customerList;
    }

    public int getDistinctCustomerNumber() {
        int count = 0;
        Customer[] distinctCustomers = new Customer[listCustomers.size()];
        for (int i = 0; i < listCustomers.size(); i++) {
            boolean isDistinct = true;
            Customer customer = listCustomers.get(i);
            for (int j = 0; j < count; j++) {
                if (customer.getMaKH() == distinctCustomers[j].getMaKH()) {
                    isDistinct = false;
                    break;
                }
            }
            if (isDistinct) {
                distinctCustomers[count++] = customer;
            }
        }
        return count;
    }
    public int getDistinctCustomerSPNumber() {
        int count = 0;
        for (int i = 0; i < listCustomers.size(); i++) {
            Customer customer = listCustomers.get(i);
            count+= customer.getSoLuong();
        }
        return count;
    }
    /**
     * sắp xếp danh sách Customer theo name theo tứ tự tăng dần
     */
    public void sortMaSP() {
        Collections.sort(listCustomers, new Comparator<Customer>() {
            public int compare(Customer Customer1, Customer Customer2) {
                return Customer1.getMaSP().compareTo(Customer2.getMaSP());
            }
        });
    }
//
//    /**
//     * sắp xếp danh sách Customer theo GPA theo tứ tự tăng dần
//     */
    public void sortCustomerSL() {
        Collections.sort(listCustomers, new Comparator<Customer>() {
            public int compare(Customer Customer1, Customer Customer2) {
                if (Customer1.getSoLuong() > Customer2.getSoLuong()) {
                    return 1;
                }
                return -1;
            }
        });
    }
    
    public List<Customer> getlistCustomers() {
        return listCustomers;
    }

    public void setlistCustomers(List<Customer> listCustomers) {
        this.listCustomers = listCustomers;
    }
}

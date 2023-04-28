package vn.viettuts.qlsv.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class Customer implements Serializable {
	    private static final long serialVersionUID = 1L;
	    private int maKH;
	    private String maSP;
	    private String tenSP;
	    private int giaBan;
	    private int soLuong;
	    /* điểm trung bình của sinh viên */

		public Customer() {
	    }

	    public Customer(int maKH,String maSP, String tenSP, int giaBan) {
	        super();
	        this.maKH = maKH;
	        this.maSP = maSP;
	        this.tenSP = tenSP;
	        this.giaBan = giaBan;
	    }
	    public int getMaKH() {
			return maKH;
		}

		public void setMaKH(int maKH) {
			this.maKH = maKH;
		}

		public String getMaSP() {
			return maSP;
		}

		public void setMaSP(String maSP) {
			this.maSP = maSP;
		}

		public String getTenSP() {
			return tenSP;
		}

		public void setTenSP(String tenSP) {
			this.tenSP = tenSP;
		}

		public int getGiaBan() {
			return giaBan;
		}

		public void setGiaBan(int giaBan) {
			this.giaBan = giaBan;
		}
		public int getSoLuong() {
			return soLuong;
		}

		public void setSoLuong(int soLuong) {
			this.soLuong = soLuong;
		}
	}


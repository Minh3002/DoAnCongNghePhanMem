package BUS;

import java.util.Vector;

import DAO.NguoiDungDAO;
import DTO.NguoiDung;

public class NguoiDungBUS {
	public NguoiDung getUser(String ID) {
		NguoiDungDAO ndDAO = new NguoiDungDAO();
		return ndDAO.getUser(ID);
	}
	public Vector<NguoiDung> getAllUserOfGroup(String ID) {
		NguoiDungDAO ndDAO = new NguoiDungDAO();
		return ndDAO.getAllUserOfGroup(ID);
	}
	public NguoiDung getNguoiĐungangNhap(String userName, String Password)
	{
		NguoiDungDAO ndDAO = new NguoiDungDAO();
		return ndDAO.getNguoiĐungangNhap(userName, Password);
	}
}

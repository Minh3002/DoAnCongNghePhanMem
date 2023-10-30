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
	public NguoiDung getNguoiDungDangNhap(String userName, String Password)
	{
		NguoiDungDAO ndDAO = new NguoiDungDAO();
		return ndDAO.getNguoiĐungangNhap(userName, Password);
	}
	
	NguoiDungDAO nd = new NguoiDungDAO();

    public Vector<NguoiDung> getAllUser(){
        return nd.getAllUser();
    }

    public Vector<NguoiDung> selectUserPer(String quyen){
        return nd.selectUserPer(quyen);
    }

    public Vector<String> getQuyen(){
        return nd.getQuyen();
    }

    public Vector<String> getQuyenEdit(){
        return nd.getQuyenEdit();
    }

    public boolean deleAcc(String id){
        return nd.deleAcc(id);
    }

    public NguoiDung getSelectUser(String id){
        return nd.getSelectUser(id);
    }

    public boolean editAcc(String id, String acc){
        if (acc.matches("[a-z0-9_-]{4,10}$")){
            return nd.editAcc(id, acc);
        }
        else{
            return false;
        }
    }

    public boolean editName(String id, String acc){
        if (acc.matches("[a-zỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđ' A-ZZỲỌÁẦẢẤỜỄÀẠẰỆẾÝỘẬỐŨỨĨÕÚỮỊỖÌỀỂẨỚẶÒÙỒỢÃỤỦÍỸẮẪỰỈỎỪỶỞÓÉỬỴẲẸÈẼỔẴẺỠƠÔƯĂÊÂĐ']{2,50}$")){
            return nd.editName(id, acc);
        }
        else{
            return false;
        }
    }

    public boolean editPass(String id, String acc){
        if (acc.matches("^(?=.*[A-Za-z].*)(?=.*[0-9].*)[A-Za-z0-9]{10,32}$")){
            return nd.editPass(id, acc);
        }
        else{
            return false;
        }
    }

    public boolean editMail(String id, String acc){      
        if (acc.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")){
            return nd.editMail(id, acc);
        }
        else{
            return false;
        }
    }
}

package DAO;

import DTO.TKDiemDTO;

import java.sql.*;
import java.util.Vector;

public class SinhVienDAO {

    private Connection con;
    private String id;

    public boolean openConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbUrl = "jdbc:sqlserver://localhost:1433;DatabaseName=qltn;encrypt=false";
            String username = "sa";
            String password= "123456";
            con = DriverManager.getConnection(dbUrl, username, password);
            return true;
        }
        catch (Exception ex) {
            System.out.println(ex);
            return false;
            }
        }

    public void closeConnection() {
        try {
            if (con!=null)
            con.close();
        }
        catch (SQLException ex) {
            System.out.println(ex); }
    }

    public Vector<TKDiemDTO> tkDiem(String id){
        this.id = id;
        Vector<TKDiemDTO> arr = new Vector<TKDiemDTO>();
        if (openConnection()) {
            try {
                String sql = "SELECT AVG(D.DiemSo) as 'DTB', CD.TenChuyenDe, SUM(D.SoCauDung) as 'QuesR', SUM(D.SoCauSai) as 'QuesW', SUM(D.SoCauBo) as 'QuesP', COUNT(D.DeThi) as 'SoBai' FROM DIEM D JOIN NGUOIDUNG ND ON D.NguoiDung = ND.IdUsser JOIN DETHI DT ON D.DeThi = DT.IdDeThi JOIN CHUYENDE CD ON DT.ChuyenDe = CD.IdChuyenDe WHERE ND.IdUsser = ? and DT.Active = 1 and ND.Active = 1  GROUP BY CD.IdChuyenDe, CD.TenChuyenDe";
                PreparedStatement pr = con.prepareStatement(sql);
                pr.setString(1, id);
                ResultSet rs = pr.executeQuery();
                while(rs.next()){
                    TKDiemDTO tk = new TKDiemDTO();
                    tk.setDtb(rs.getFloat("DTB"));
                    tk.setChuyenDe(rs.getString("TenChuyenDe"));
                    tk.setQuesR(rs.getInt("QuesR"));
                    tk.setQuesW(rs.getInt("QuesW"));
                    tk.setQuesP(rs.getInt("QuesP"));
                    tk.setSoBai(rs.getInt("SoBai"));
                    //tk.setThoiGianLam(rs.getLong("ThoiGianLam"));
                    arr.add(tk);
                }
            }
            catch (SQLException ex) {
                System.out.println(ex);
            }
            finally {
                closeConnection();
            }
        }
        return arr;
    }
    public double getDTB(){
        double dtb = 0;
        if (openConnection()) {
            try {
                String sql = "select AVG(DiemSo) as 'dtb' from DIEM D where D.NguoiDung = ?";
                PreparedStatement pr = con.prepareStatement(sql);
                pr.setString(1, id);
                ResultSet rs = pr.executeQuery();
                while(rs.next()){
                    dtb = rs.getDouble("dtb");
                }
            }
            catch (SQLException ex) {
                System.out.println(ex);
            }
            finally {
                closeConnection();
            }
        }
        return dtb;
    }

    ResultSet rst;
    PreparedStatement prt;
    public Vector<TKDiemDTO> tkDiemFT(String dateFr, String dateTo){
        Vector<TKDiemDTO> arr = new Vector<TKDiemDTO>();
        if (openConnection()) {
            try {
                String sql = "";
                if (dateFr=="" && dateTo!=""){
                    sql = "select AVG(D.DiemSo) as 'DTB', CD.TenChuyenDe, SUM(D.SoCauDung) as 'QuesR', SUM(D.SoCauSai) as 'QuesW', SUM(D.SoCauBo) as 'QuesP', COUNT(D.DeThi) as 'SoBai' from DIEM D JOIN NGUOIDUNG ND ON D.NguoiDung = ND.IdUsser JOIN DETHI DT ON D.DeThi = DT.IdDeThi JOIN CHUYENDE CD ON DT.ChuyenDe = CD.IdChuyenDe where D.NguoiDung = ?  and D.NgayLam BETWEEN (select top 1 D2.NgayLam from DIEM D2 order by D2.NgayLam ASC) AND ? GROUP BY CD.IdChuyenDe, CD.TenChuyenDe";
                    prt = con.prepareStatement(sql);
                    prt.setString(1, id);
                    prt.setString(2, dateTo);
                }
                else if (dateFr!="" && dateTo==""){
                    sql = "select AVG(D.DiemSo) as 'DTB', CD.TenChuyenDe, SUM(D.SoCauDung) as 'QuesR', SUM(D.SoCauSai) as 'QuesW', SUM(D.SoCauBo) as 'QuesP', COUNT(D.DeThi) as 'SoBai' from DIEM D JOIN NGUOIDUNG ND ON D.NguoiDung = ND.IdUsser JOIN DETHI DT ON D.DeThi = DT.IdDeThi JOIN CHUYENDE CD ON DT.ChuyenDe = CD.IdChuyenDe where D.NguoiDung = ?  and D.NgayLam BETWEEN ? AND GETDATE() GROUP BY CD.IdChuyenDe, CD.TenChuyenDe";
                    prt = con.prepareStatement(sql);
                    prt.setString(1, id);
                    prt.setString(2, dateFr);
                }
                else if (dateFr=="" && dateTo==""){
                    return arr = tkDiem(id);
                }
                else if (dateFr!="" && dateTo!=""){
                    sql = "select AVG(D.DiemSo) as 'DTB', CD.TenChuyenDe, SUM(D.SoCauDung) as 'QuesR', SUM(D.SoCauSai) as 'QuesW', SUM(D.SoCauBo) as 'QuesP', COUNT(D.DeThi) as 'SoBai' from DIEM D JOIN NGUOIDUNG ND ON D.NguoiDung = ND.IdUsser JOIN DETHI DT ON D.DeThi = DT.IdDeThi JOIN CHUYENDE CD ON DT.ChuyenDe = CD.IdChuyenDe where D.NguoiDung = ?  and D.NgayLam BETWEEN ? AND ? GROUP BY CD.IdChuyenDe, CD.TenChuyenDe";
                    prt = con.prepareStatement(sql);
                    prt.setString(1, id);
                    prt.setString(2, dateFr);
                    prt.setString(3, dateTo);
                }
                rst = prt.executeQuery();
                while(rst.next()){
                    TKDiemDTO tk = new TKDiemDTO();
                    tk.setDtb(rst.getFloat("DTB"));
                    tk.setChuyenDe(rst.getString("TenChuyenDe"));
                    tk.setQuesR(rst.getInt("QuesR"));
                    tk.setQuesW(rst.getInt("QuesW"));
                    tk.setQuesP(rst.getInt("QuesP"));
                    tk.setSoBai(rst.getInt("SoBai"));
                    //tk.setThoiGianLam(rst.getLong("ThoiGianLam"));
                    arr.add(tk);
                }
            }
            catch (SQLException ex) {
                System.out.println(ex);
            }
            finally {
                closeConnection();
            }
        }
        return arr;
    }

    public double getDTBFT(String dateFr, String dateTo){
        double dtb = 0;
        if (openConnection()) {
            try {
                String sql = "";
                if (dateFr=="" && dateTo!=""){
                    sql = "select AVG(DiemSo) as 'dtb' from DIEM D where D.NguoiDung = ? and D.NgayLam BETWEEN (select top 1 D2.NgayLam from DIEM D2 order by D2.NgayLam ASC) AND ?";
                    prt = con.prepareStatement(sql);
                    prt.setString(1, id);
                    prt.setString(2, dateTo);
                }
                else if (dateFr!="" && dateTo==""){
                    sql = "select AVG(DiemSo) as 'dtb' from DIEM D where D.NguoiDung = ? and D.NgayLam BETWEEN ? AND GETDATE()";
                    prt = con.prepareStatement(sql);
                    prt.setString(1, id);
                    prt.setString(2, dateFr);
                }
                else if (dateFr=="" && dateTo==""){
                    return dtb = getDTB();
                }
                else if (dateFr!="" && dateTo!=""){
                    sql = "select AVG(DiemSo) as 'dtb' from DIEM D where D.NguoiDung = ? and D.NgayLam BETWEEN ? AND ?";
                    prt = con.prepareStatement(sql);
                    prt.setString(1, id);
                    prt.setString(2, dateFr);
                    prt.setString(3, dateTo);
                }
                rst = prt.executeQuery();
                while(rst.next()){
                    dtb = rst.getDouble("dtb");
                }
            }
            catch (SQLException ex) {
                System.out.println(ex);
            }
            finally {
                closeConnection();
            }
        }
        return dtb;
    }
    
    public long getAvgTime(){
        long ttb = 0;
        if (openConnection()) {
            try {
                String sql = "select AVG(D.ThoiGianLam) as 'ThoiGianLam' from DIEM D where D.NguoiDung = ?";
                PreparedStatement pr = con.prepareStatement(sql);
                pr.setString(1, id);
                ResultSet rs = pr.executeQuery();
                while(rs.next()){
                    ttb += rs.getLong("ThoiGianLam");
                }
            }
            catch (SQLException ex) {
                System.out.println(ex);
            }
            finally {
                closeConnection();
            }
        }
        return ttb/1000;
    }

    public long getAvgTimeFT(String dateFr, String dateTo){
        long ttb = 0;
        if (openConnection()) {
            try {
                String sql = "";
                if (dateFr=="" && dateTo!=""){
                    sql = "select AVG(D.ThoiGianLam) as 'ThoiGianLam' from DIEM D where D.NguoiDung = ? and D.NgayLam BETWEEN (select top 1 D2.NgayLam from DIEM D2 order by D2.NgayLam ASC) AND ?";
                    prt = con.prepareStatement(sql);
                    prt.setString(1, id);
                    prt.setString(2, dateTo);
                }
                else if (dateFr!="" && dateTo==""){
                    sql = "select AVG(D.ThoiGianLam) as 'ThoiGianLam' from DIEM D where D.NguoiDung = ? and D.NgayLam BETWEEN ? AND GETDATE()";
                    prt = con.prepareStatement(sql);
                    prt.setString(1, id);
                    prt.setString(2, dateFr);
                }
                else if (dateFr=="" && dateTo==""){
                    return ttb = getAvgTime();
                }
                else if (dateFr!="" && dateTo!=""){
                    sql = "select AVG(D.ThoiGianLam) as 'ThoiGianLam' from DIEM D where D.NguoiDung = ? and D.NgayLam BETWEEN ? AND ?";
                    prt = con.prepareStatement(sql);
                    prt.setString(1, id);
                    prt.setString(2, dateFr);
                    prt.setString(3, dateTo);
                }
                rst = prt.executeQuery();
                while (rst.next()){
                    ttb += rst.getLong("ThoiGianLam");
                }
            }
            catch (SQLException ex) {
                System.out.println(ex);
            }
            finally {
                closeConnection();
            }
        }
        return ttb/1000;
    }
}

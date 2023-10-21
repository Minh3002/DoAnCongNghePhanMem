package DAO;

import java.sql.*;
import java.util.Vector;

import DTO.NguoiDung;

public class NguoiDungDAO {
    private Connection con;

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

    public Vector<NguoiDung> getAllUser(){
        Vector<NguoiDung> arr = new Vector<NguoiDung>();
        if (openConnection()) {
            try {
                String sql = "Select * from NGUOIDUNG ND join PHANQUYEN PQ ON ND.Quyen = PQ.MaPhanQuyen where ND.Active=1 ORDER BY NgayTao DESC";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    NguoiDung nd = new NguoiDung();
                    nd.setMaUser(rs.getString("IdUsser"));
                    nd.setHoTen(rs.getString("HoTen"));
                    nd.setEmail(rs.getString("Gmail"));
                    nd.setNgayTao(rs.getDate("NgayTao"));
                    nd.setMaGV(rs.getString("MaGiaoVien"));
                    nd.setMaHS(rs.getString("MaHocSinh"));
                    nd.setUserName(rs.getString("TaiKhoan"));
                    nd.setMatKhau(rs.getString("MatKhau"));
                    nd.setQuyen(rs.getString("TenPhanQuyen"));
                    arr.add(nd);
                    
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

    public Vector<String> getQuyen(){
        Vector<String> quyen = new Vector<>();
        quyen.add("Tất Cả");
        if (openConnection()) {
            try {
                String sql = "Select * from PHANQUYEN";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    quyen.add(rs.getString("TenPhanQuyen"));                  
                }
            }
            catch (SQLException ex) {
                System.out.println(ex);
            }
            finally {
                closeConnection();
            }
        }
        return quyen;
    }
    public Vector<String> getQuyenEdit(){
        Vector<String> quyen = new Vector<>();
        if (openConnection()) {
            try {
                String sql = "Select * from PHANQUYEN";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    quyen.add(rs.getString("TenPhanQuyen"));                  
                }
            }
            catch (SQLException ex) {
                System.out.println(ex);
            }
            finally {
                closeConnection();
            }
        }
        return quyen;
    }

    public boolean deleAcc(String id){
        if (openConnection()) {
            try {
                String sql = "SET NOCOUNT ON UPDATE NGUOIDUNG set Active=0 where IdUsser=?";
                PreparedStatement pr = con.prepareStatement(sql);
                pr.setString(1, id);
                pr.executeUpdate();
            }
            catch (SQLException ex) {
                System.out.println(ex);
                return false;
            }
            finally {
                closeConnection();
            }
        }
        return true;
    }

    public boolean editName(String id, String acc){
        if (openConnection()) {
            try {
                String sql = "SET NOCOUNT ON UPDATE NGUOIDUNG set HoTen=? where IdUsser=?";
                PreparedStatement pr = con.prepareStatement(sql);
                pr.setString(1, acc);
                pr.setString(2,id);
                pr.executeUpdate();
            }
            catch (SQLException ex) {
                System.out.println(ex);
                return false;
            }
            finally {
                closeConnection();
            }
        }
        return true;
    }

    public boolean editAcc(String id, String acc){
        if (openConnection()) {
            try {
                String sql = "SET NOCOUNT ON UPDATE NGUOIDUNG set TaiKhoan=? where IdUsser=?";
                PreparedStatement pr = con.prepareStatement(sql);
                pr.setString(1, acc);
                pr.setString(2,id);
                pr.executeUpdate();
            }
            catch (SQLException ex) {
                System.out.println(ex);
                return false;
            }
            finally {
                closeConnection();
            }
        }
        return true;
    }

    public boolean editPass(String id, String acc){
        if (openConnection()) {
            try {
                String sql = "SET NOCOUNT ON UPDATE NGUOIDUNG set MatKhau=? where IdUsser=?";
                PreparedStatement pr = con.prepareStatement(sql);
                pr.setString(1, acc);
                pr.setString(2,id);
                pr.executeUpdate();
            }
            catch (SQLException ex) {
                System.out.println(ex);
                return false;
            }
            finally {
                closeConnection();
            }
        }
        return true;
    }
    
    public boolean editMail(String id, String acc){
        if (openConnection()) {
            try {
                String sql = "SET NOCOUNT ON UPDATE NGUOIDUNG set Gmail=? where IdUsser=?";
                PreparedStatement pr = con.prepareStatement(sql);
                pr.setString(1, acc);
                pr.setString(2,id);
                pr.executeUpdate();
            }
            catch (SQLException ex) {
                System.out.println(ex);
                return false;
            }
            finally {
                closeConnection();
            }
        }
        return true;
    }

    public NguoiDung getSelectUser(String id){
        NguoiDung nd = new NguoiDung();
        if (openConnection()) {
            try {
                String sql = "Select * from NGUOIDUNG ND join PHANQUYEN PQ on ND.Quyen = PQ.MaPhanQuyen where IdUsser=? and Active=1";
                PreparedStatement pr = con.prepareStatement(sql);
                pr.setString(1, id);
                ResultSet rs = pr.executeQuery();
                while(rs.next()){
                    nd.setMaUser(rs.getString("IdUsser"));
                    nd.setHoTen(rs.getString("HoTen"));
                    nd.setEmail(rs.getString("Gmail"));
                    nd.setNgayTao(rs.getDate("NgayTao"));
                    nd.setMaGV(rs.getString("MaGiaoVien"));
                    nd.setMaHS(rs.getString("MaHocSinh"));
                    nd.setUserName(rs.getString("TaiKhoan"));
                    nd.setMatKhau(rs.getString("MatKhau"));
                    nd.setQuyen(rs.getString("TenPhanQuyen"));
                }
            }
            catch (SQLException ex) {
                System.out.println(ex);
            }
            finally {
                closeConnection();
            }
        }
        return nd;
    }

    public Vector<NguoiDung> selectUserPer(String quyen){
        Vector<NguoiDung> arr = new Vector<>();
        if (openConnection()) {
            try {
                String sql = "Select * from PHANQUYEN PQ join NGUOIDUNG ND on PQ.MaPhanQuyen = ND.Quyen where ND.Active=1 and PQ.MaPhanQuyen IN (Select PQ1.MaPhanQuyen from PHANQUYEN PQ1 where PQ1.TenPhanQuyen = ?)";
                PreparedStatement pr = con.prepareStatement(sql);
                pr.setString(1, quyen);
                ResultSet rs = pr.executeQuery();
                while(rs.next()){
                    NguoiDung nd = new NguoiDung();
                    nd.setMaUser(rs.getString("IdUsser"));
                    nd.setHoTen(rs.getString("HoTen"));
                    nd.setEmail(rs.getString("Gmail"));
                    nd.setNgayTao(rs.getDate("NgayTao"));
                    nd.setMaGV(rs.getString("MaGiaoVien"));
                    nd.setMaHS(rs.getString("MaHocSinh"));
                    nd.setUserName(rs.getString("TaiKhoan"));
                    nd.setMatKhau(rs.getString("MatKhau"));
                    nd.setQuyen(rs.getString("TenPhanQuyen"));
                    arr.add(nd);                
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

    public Date firstCreaDate(){
        Date date = null;
        if (openConnection()) {
            try {
                String sql = "Select TOP 1 NgayTao from NGUOIDUNG where Active = 1 ORDER BY NgayTao ASC";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    date = rs.getDate("NgayTao");
                }
            }
            catch (SQLException ex) {
                System.out.println(ex);
            }
            finally {
                closeConnection();
            }
        }
        return date;
    }

}

package BUS;

import DTO.TKDiemDTO;

import java.util.Vector;

import DAO.SinhVienDAO;

public class SinhVienBUS {

    SinhVienDAO sv = new SinhVienDAO();

    public Vector<TKDiemDTO> tkDiem(String id){
        return sv.tkDiem(id);
    }

    public int QuesR(Vector<TKDiemDTO> arrTK){
        int count = 0;
        for (TKDiemDTO x : arrTK) {
            count += x.getQuesR();
        }
        return count;
    }

    public int QuesW(Vector<TKDiemDTO> arrTK){
        int count = 0;
        for (TKDiemDTO x : arrTK) {
            count += x.getQuesW();
        }
        return count;
    }

    public int QuesP(Vector<TKDiemDTO> arrTK){
        int count = 0;
        for (TKDiemDTO x : arrTK) {
            count += x.getQuesP();
        }
        return count;
    }

    public int SoBai(Vector<TKDiemDTO> arrTK){
        int count = 0;
        for (TKDiemDTO x : arrTK) {
            count += x.getSoBai();
        }
        return count;
    }

    public double DTB(){
        return sv.getDTB();
    }

    public String avgTime(){
        long hour=0,min=0,sec=0;
        long time = sv.getAvgTime();
        String minr="", secr="";
        hour = time/60/60;
        min = (time - (hour*60*60))/60;
        sec = (time - (hour*60*60)) - min*60;
        if (min < 10){
            minr = "0" + String.valueOf(min);
        }
        else {
            minr = String.valueOf(min);
        }
        if (sec < 10){
            secr = "0" + String.valueOf(sec);
        }
        else {
            secr = String.valueOf(sec);
        }
        return String.valueOf(hour)+":"+minr+":"+secr;
    }

    public String avgTimeFT(String dateFr, String dateTo){
        long hour=0,min=0,sec=0;
        long time = sv.getAvgTimeFT(dateFr,dateTo);
        String minr="", secr="";
        hour = time/60/60;
        min = (time - (hour*60*60))/60;
        sec = (time - (hour*60*60)) - min*60;
        if (min < 10){
            minr = "0" + String.valueOf(min);
        }
        else {
            minr = String.valueOf(min);
        }
        if (sec < 10){
            secr = "0" + String.valueOf(sec);
        }
        else {
            secr = String.valueOf(sec);
        }
        return String.valueOf(hour)+":"+minr+":"+secr;
    }

    public Vector<TKDiemDTO> tkDiemFT(String dateFr, String dateTo){
        return sv.tkDiemFT(dateFr,dateTo);
    }

    public double DTBFT(String dateFr, String dateTo){
        return sv.getDTBFT(dateFr,dateTo);
    }
}

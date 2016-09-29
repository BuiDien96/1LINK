package Controller;

import Model.SinhVienModel;
import Entity.Sinhvien;

import java.util.ArrayList;

/**
 * Created by dell on 9/26/2016.
 */
public class SinhVienController {
    public SinhVienModel sinhVienModel;
    public Sinhvien sv;
    public SinhVienController(){
        sinhVienModel = new SinhVienModel();
        sv= new Sinhvien();
    }
    public void NhapSVBanPhim(){
        sinhVienModel.NhapSVBanPhim( );
    }

    public void NhapvaoFile(){
        sinhVienModel.NhapvaoFile();
    }

    public ArrayList<Sinhvien> TimKiemTong(double tong){
        return sinhVienModel.TimKiemTong(tong);
    }

    public ArrayList<Sinhvien> timKiemHoTen(String hoten){
        return sinhVienModel.timKiemHoTen(hoten);
    }

    public ArrayList<Sinhvien> timKiemSBD(String sbd){
        return sinhVienModel.timKiemSBD(sbd);
    }

    public ArrayList<Sinhvien> timKiemCacDiemMon(double diem, int n){
        return sinhVienModel.timKiemCacDiemMon(diem,n);
    }

    public ArrayList<Sinhvien> SapXepSBD(){
        return sinhVienModel.SapXepSBD();
    }

    public ArrayList<Sinhvien> SapXepDiem(){
        return sinhVienModel.SapXepDiem();
    }

    public void suaSinhVien(){
        sinhVienModel.suaSinhVien();
    }

    public void xoaSinhVien(){
        sinhVienModel.xoaSinhVien();
    }

    public void ThongKe(){
        sinhVienModel.ThongKe();
    }

    public boolean Write(String fileName)throws Exception{
        return  sinhVienModel.Write(fileName);
    }

    public  ArrayList<Sinhvien> read(String fileName){
        return  sinhVienModel.read(fileName);
    }




}

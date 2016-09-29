package View;

import Controller.SinhVienController;
import Entity.Sinhvien;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by dell on 9/26/2016.
 */
public class Menu {
    SinhVienController sinhVienController= new SinhVienController();
    Scanner input= new Scanner(System.in);

    public static void chonMon(){
        System.out.println("Moi ban chon mon can tim diem: ");
        System.out.print("1. Mon Toan");
        System.out.print("2. Mon Ly");
        System.out.print("3. Mon Hoa");
    }

    public  static  void TimKiem(){
        System.out.println("Moi ban chon cach tim kiem: ");
        System.out.println("1.Tim kiem sinh vien theo tong so diem.");
        System.out.println("2.Tim kiem sinh vien theo so bao danh.");
        System.out.println("3.Tim kiem sinh vien theo ho ten.");
        System.out.println("4.Tim kiem sinh vien theo diem tung mon.");
        System.out.println("5.Thoat.");
    }

    public  static void MoDau(){
        System.out.println("QUAN LY SINH VIEN");
        System.out.println("1.Nhap sinh vien.");
        System.out.println("2.Tim kiem sinh vien va truy xuat thong tin vua tim kiem ra file");
        System.out.println("3.Them, xoa, chinh sua");
        System.out.println("4.Sap xep.");
        System.out.println("5.Thong ke.");
        System.out.println("6.Thoat chuong trinh.");
    }

    public  static void ThemXoa(){
        System.out.println("Moi ban chon them, chinh sua hoac xoa.");
        System.out.println("1.Them sinh vien.");
        System.out.println("2.Chinh sua sinh vien.");
        System.out.println("3.Xoa sinh vien.");
        System.out.println("4.Thoat");
    }

    public  static  void SapXep(){
        System.out.println("Moi ban chon cach sap xep.");
        System.out.println("1.Sap xep theo SBD");
        System.out.println("2.Sap xep theo tong diem.");
        System.out.println("3.Thoat");
    }

    public  static boolean KiemTraTen(String s){
        if (s.matches("[a-z A-Z]"))//ho ten chi chua cac chu cai a-z va A-Z theo dinh dang
            return true;
        else
            return  false;
    }

    public  static boolean KiemTraMaSV(String s){
        if (s.matches("[A-Z]"))
            return  true;
        else  return  false;
    }

    public static  void NhapFile(){
        System.out.println("Moi ban chon cach nhap:");
        System.out.println("1.Nhap tu ban phim.");
        System.out.println("2.Nhap vao file.");
        System.out.println("3.Thoat");
    }

    public void Option1(){
        int chon;
        do {
            NhapFile();
            chon= input.nextInt();
            switch (chon){
                case 1:{
                    sinhVienController.NhapSVBanPhim();
                    break;
                }
                case 2:{
                    sinhVienController.NhapvaoFile();

                    break;
                }
                case 3:{
                    break;
                }
            }
        }while (chon!=3);
    }

    public void Option2(){
        int chon;
        do {
            TimKiem();
            chon=input.nextInt();
            switch (chon){
                case 1:{
                    int tong;
                    System.out.println("Moi ban nhap tong can tim: ");
                    tong=input.nextInt();
                    ArrayList<Sinhvien> listDiem= sinhVienController.TimKiemTong(tong);
                    for (int i = 0; i < listDiem.size(); i++) {
                        listDiem.get(i).Xuat();
                    }
                    System.out.println("Ban co muon truy xuat thong tin tim kiem duoc ra file ko?\n 1. Co\n 2. Khong");
                    int chon1;
                    chon1=input.nextInt();
                    if (chon1==1) {
                        String fileName;
                        System.out.print("Nhap ten file:");
                        input.nextLine();
                        fileName = input.nextLine();
                        try {
                            sinhVienController.Write(fileName);
                        } catch (Exception ex) {
                            System.out.println(ex.toString());
                        }

                        /*listDiem= sinhVienController.read(fileName);
                        for (int i = 0; i < listDiem.size(); i++) {
                            listDiem.get(i).Xuat();
                        }*/
                    }
                    break;
                }
                case 2:{
                    String sbd;
                    System.out.println("Moi ban nhap tong can tim: ");
                    sbd=input.nextLine();
                    ArrayList<Sinhvien> listDiem= sinhVienController.timKiemSBD(sbd);
                    for (int i = 0; i < listDiem.size(); i++) {
                        listDiem.get(i).Xuat();
                    }
                    System.out.println("Ban co muon truy xuat thong tin tim kiem duoc ra file ko?\n 1. Co\n 2. Khong");
                    int chon1;
                    chon1=input.nextInt();
                    if (chon1==1) {
                        String fileName;
                        System.out.print("Nhap ten file:");
                        fileName = input.nextLine();
                        try {
                            sinhVienController.Write(fileName);
                        } catch (Exception ex) {
                            System.out.println(ex.toString());
                        }
                    }
                    break;
                }
                case 3:{
                    String hoten;
                    System.out.println("Moi ban nhap tong can tim: ");
                    hoten=input.nextLine();
                    ArrayList<Sinhvien> listDiem= sinhVienController.timKiemHoTen(hoten);
                    for (int i = 0; i < listDiem.size(); i++) {
                        listDiem.get(i).Xuat();
                    }
                    System.out.println("Ban co muon truy xuat thong tin tim kiem duoc ra file ko?\n 1. Co\n 2. Khong");
                    int chon1;
                    chon1=input.nextInt();
                    if (chon1==1) {
                        String fileName;
                        System.out.print("Nhap ten file:");
                        fileName = input.nextLine();
                        try {
                            sinhVienController.Write(fileName);
                        } catch (Exception ex) {
                            System.out.println(ex.toString());
                        }
                    }
                    break;
                }
                case 4:{
                    int mon;
                    double diemMon;
                    Menu.chonMon();
                    mon=input.nextInt();
                    System.out.println("Moi ban nhap diem: ");
                    diemMon= input.nextDouble();
                    ArrayList<Sinhvien> listDiemMon= sinhVienController.timKiemCacDiemMon(diemMon, mon);

                    switch (mon){
                        case 1:
                            for (int i = 0; i < listDiemMon.size(); i++) {
                                listDiemMon.get(i).Xuat();
                            }
                            break;
                        case  2:
                            for (int i = 0; i <listDiemMon.size() ; i++) {
                                listDiemMon.get(i).Xuat();
                            }
                            break;
                        case 3:
                            for (int i = 0; i < listDiemMon.size(); i++){
                                listDiemMon.get(i).Xuat();
                            }
                            break;
                    }
                    System.out.println("Ban co muon muon trich xuat thong tin tim kiem duoc ra file khong?");
                    System.out.println("1. Co.");
                    System.out.println("2. Khong.");
                    int choice4;
                    choice4=input.nextInt();
                    if (choice4==1){
                        String fileName;
                        fileName= input.nextLine();
                        try {
                            sinhVienController.Write(fileName);
                        }
                        catch (Exception e){
                            System.out.println(e.toString());
                        }
                    }
                    break;
                }
                case 5:{
                    break;
                }
                default:{
                    System.out.println("ban nhap sai, nhap lai: ");
                    break;
                }
            }
        }while (chon !=5 );

    }

    public void Option3(){
        int chon;
        do {
            ThemXoa();
            chon=input.nextInt();
            switch (chon){
                case 1:{
                    sinhVienController.NhapSVBanPhim();
                    break;
                }
                case 2:{
                    sinhVienController.suaSinhVien();
                    break;
                }
                case 3:{
                    sinhVienController.xoaSinhVien();
                    break;
                }
                case 4:
                    break;
            }
        }while (chon !=4 );
    }

    public void Option4(){
        int chon;
        do {
            SapXep();
            chon=input.nextInt();
            switch (chon){
                case 1:{
                    ArrayList<Sinhvien> listSBD= sinhVienController.SapXepSBD();
                    for (int i = 0; i < listSBD.size(); i++) {
                        listSBD.get(i).Xuat();
                    }
                    break;
                }
                case 2:{
                    ArrayList<Sinhvien> listDiem= sinhVienController.SapXepDiem();
                    for (int i = 0; i < listDiem.size(); i++) {
                        listDiem.get(i).Xuat();
                    }
                    break;
                }
                case 3:
                    break;
            }
        }while (chon !=3 );
    }

    public void Option5(){
        sinhVienController.ThongKe();
    }



}

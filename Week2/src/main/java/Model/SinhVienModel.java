package Model;

import Entity.Sinhvien;

import java.io.*;
import java.util.*;


/**
 * Created by dell on 9/26/2016.
 */
public class SinhVienModel {
    ArrayList<Sinhvien> listSV;
    Scanner input= new Scanner(System.in);
    public SinhVienModel(){
        listSV =new ArrayList<Sinhvien>();
    }

    public void NhapSVBanPhim( ){
        int n;
        System.out.print("Nhap so sinh vien can nhap vao: ");
        n= input.nextInt();
        for (int i = 0; i < n ; i++) {
            System.out.println("Sinh vien thu: "+(i+1));
            Sinhvien sv= new Sinhvien();
            sv.Nhap();
            listSV.add(sv);
        }

        for (int i = 0; i < listSV.size(); i++) {
            listSV.get(i).Xuat();
        }
    }

    public void NhapvaoFile(){
        int n;
        System.out.println("Nhap so sinh vien: ");
        n=input.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Sinh vien thu: "+(i+1));
            Sinhvien sv= new Sinhvien();
            sv.Nhap();
            listSV.add(sv);
        }
        String fileName;
        System.out.println("Nhap ten file: ");
        input.nextLine();
        fileName=input.nextLine();
        try {
            Write(fileName);
        }catch (Exception ex){
            System.out.println(ex.toString());
        }
        listSV= read(fileName);
        for (int i = 0; i < listSV.size(); i++) {
            listSV.get(i).Xuat();
        }
    }

    public ArrayList<Sinhvien> TimKiemTong(double tong){
        ArrayList<Sinhvien> listKq= new ArrayList<Sinhvien>();
        for (int i = 0; i <listSV.size() ; i++) {
            double sum= listSV.get(i).getDiemToan()+listSV.get(i).getDiemLy()+listSV.get(i).getDiemHoa();
            if (sum== tong){
                listKq.add(listSV.get(i));
            }
        }
        return listKq;
    }

    public  ArrayList<Sinhvien> timKiemHoTen(String hoten){
        ArrayList<Sinhvien> listKq= new ArrayList<Sinhvien>();
        for (int i = 0; i < listSV.size(); i++) {
            if (hoten.equalsIgnoreCase(listSV.get(i).getHoTen()))
                listKq.add(listSV.get(i));
        }
        return listKq;
    }

    public ArrayList<Sinhvien> timKiemSBD(String sbd){
        ArrayList<Sinhvien> listKq= new ArrayList<Sinhvien>();
        for (int i = 0; i < listSV.size(); i++) {
            if (sbd.equalsIgnoreCase(listSV.get(i).getSbd()))
                listKq.add(listSV.get(i));
        }
        return listKq;
    }

    public ArrayList<Sinhvien> timKiemCacDiemMon(double diem, int n){
        ArrayList<Sinhvien> listKq= new ArrayList<Sinhvien>();
        for (int i = 0; i < listSV.size(); i++) {
            switch (n){
                case 1:{
                    if (diem==listSV.get(i).getDiemToan())
                        listKq.add(listSV.get(i));
                    break;
                }
                case 2:{
                    if (diem==listSV.get(i).getDiemLy())
                        listKq.add(listSV.get(i));
                    break;
                }
                case 3:{
                    if (diem==listSV.get(i).getDiemHoa())
                        listKq.add(listSV.get(i));
                    break;
                }
            }
        }
        return listKq;
    }

    public ArrayList<Sinhvien> SapXepSBD(){
        Collections.sort(listSV, new Comparator<Sinhvien>() {
            public int compare(Sinhvien o1, Sinhvien o2) {
                return (o1.getSbd().compareTo(o2.getSbd()));
            }
        });
        return  listSV;
    }

    public ArrayList<Sinhvien> SapXepDiem(){
        Collections.sort(listSV, new Comparator<Sinhvien>() {
            public int compare(Sinhvien o1, Sinhvien o2) {
                if ((o1.getDiemToan()+o1.getDiemLy()+o1.getDiemHoa())>(o2.getDiemToan()+o2.getDiemLy()+o2.getDiemHoa()))
                return 1;
                else {
                    if ((o1.getDiemToan()+o1.getDiemLy()+o1.getDiemHoa())==(o2.getDiemToan()+o2.getDiemLy()+o2.getDiemHoa()))
                        return 0;
                    else return -1;
                }
            }
        });
        return listSV;
    }

    public boolean Write(String fileName)throws Exception{
        try {
            File file1= new File(fileName);
            FileOutputStream f= new FileOutputStream(file1);//tao file f tro den file
            ObjectOutputStream oStream= new ObjectOutputStream(f);//doc theo Object vao file f
            oStream.writeObject(listSV);//ghi listSV theo kieu Object vao file
            oStream.flush();
        } catch (Exception e){
            throw e;
        }
        return  true;
    }

    public ArrayList<Sinhvien> read(String fileName) {
        ArrayList<Sinhvien> listSV= null;
        try {
            File file= new File(fileName);
            FileInputStream f= new FileInputStream(file);//tao file f tro den file
            ObjectInputStream inStream= new ObjectInputStream(f);
            listSV= (ArrayList<Sinhvien>) inStream.readObject();
        }
        catch (ClassNotFoundException e){
            System.out.println("Class not found!");
        }
        catch (Exception e){
            System.out.println("Error Read File!");
        }
        return  listSV;
    }

    public  void suaSinhVien(){
        String sbd;
        System.out.print("Nhap sbd sinh vien can chinh sua: ");
        sbd=input.nextLine();
        for (int i = 0; i < listSV.size(); i++) {
            if (sbd.equalsIgnoreCase(listSV.get(i).getSbd())){
                Sinhvien sv= new Sinhvien();
                sv.Nhap();
            }
        }

        for (int i = 0; i < listSV.size(); i++) {
            listSV.get(i).Xuat();
        }
    }

    public void xoaSinhVien(){
        String sbd;
        System.out.print("nhap so bao danh sinh vien can xoa: ");
        input.nextLine();
        sbd= input.nextLine();
        for (int i = 0; i < listSV.size(); i++) {
            if (sbd.equalsIgnoreCase(listSV.get(i).getSbd())){
                listSV.remove(listSV.get(i));
            }
        }

        for (int i = 0; i < listSV.size(); i++) {
            listSV.get(i).Xuat();
        }
    }

    public void ThongKe(){
        int a=0, b=0,c=0,d=0;
        System.out.println("Thong Ke Sinh Vien");
        int n=listSV.size();
        System.out.println("Tong So sinh vien la: " +n);
        for (int i = 0; i < listSV.size(); i++) {
            if (listSV.get(i).getDiemToan()+listSV.get(i).getDiemLy()+listSV.get(i).getDiemHoa() < 15){
                a++;
            }
            if ( (listSV.get(i).getDiemToan()+listSV.get(i).getDiemLy()+listSV.get(i).getDiemHoa()) >= 15
                    && (listSV.get(i).getDiemToan()+listSV.get(i).getDiemLy()+listSV.get(i).getDiemHoa())<20){
                b++;
            }
            if ( (listSV.get(i).getDiemToan()+listSV.get(i).getDiemLy()+listSV.get(i).getDiemHoa()) >=20 &&
                    (listSV.get(i).getDiemToan()+listSV.get(i).getDiemLy()+listSV.get(i).getDiemHoa()) < 25){
                c++;
            }
            if ((listSV.get(i).getDiemToan()+listSV.get(i).getDiemLy()+listSV.get(i).getDiemHoa()) >= 25){
                d++;
            }
        }
        System.out.println("Tong so sinh vien co tong diem nho hon 15: "+a);
        System.out.println("Tong so sinh vien co tong diem tu 15 den 20: "+b);
        System.out.println("Tong so sinh vien co tong diem tu 20 den 25: "+c);
        System.out.println("Tong so sinh vien co tong diem lon hon 25: "+d);
    }


















}

package Entity;

import java.io.Serializable;
import java.util.Scanner;

/**
 * Created by dell on 9/26/2016.
 */
public class Sinhvien implements Serializable{
    private String hoTen;
    private  String sbd;
    private String diaChi;
    private boolean gioiTinh;
    private double diemToan;
    private double diemLy;
    private double diemHoa;

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSbd() {
        return sbd;
    }

    public void setSbd(String sbd) {
        this.sbd = sbd;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public double getDiemToan() {
        return diemToan;
    }

    public void setDiemToan(double diemToan) {
        this.diemToan = diemToan;
    }

    public double getDiemLy() {
        return diemLy;
    }

    public void setDiemLy(double diemLy) {
        this.diemLy = diemLy;
    }

    public double getDiemHoa() {
        return diemHoa;
    }

    public void setDiemHoa(double diemHoa) {
        this.diemHoa = diemHoa;
    }

    public  void Nhap(){
        Scanner input= new Scanner(System.in);
        System.out.print("Nhap ten sinh vien: ");
        setHoTen(input.nextLine());
        hoTen= chuanHoa(hoTen);

        System.out.print("Nhap so bao danh: ");
        setSbd(input.nextLine());
        sbd= chuanHoa(sbd);

        System.out.print("Nhap dia chi: ");
        setDiaChi(input.nextLine());
        diaChi= chuanHoa(diaChi);

        System.out.println("Chon gioi tinh sinh vien:\n 0: Nam  \n 1:Nu");

        int gt;
        do {
            System.out.print("Moi ban chon: ");
            gt=input.nextInt();
            if (gt != 0 && gt !=1){
                System.out.print("Moi ban chon lai.");
            }
            else
                setGioiTinh(gt== 0 ? true :false );

        }while (gt != 0 && gt !=1);
        do {
            System.out.print("Nhap diem mon toan: ");
            diemToan= input.nextDouble();
        }while (diemToan < 0 || diemToan >10);

        do {
            System.out.print("Nhap diem mon ly: ");
            diemLy=input.nextDouble();
        }while (diemLy < 0 || diemLy > 10);

        do {
            System.out.print("Nhap diem mon hoa: ");
            diemHoa=input.nextDouble();
        }while ( diemHoa < 0 || diemHoa >10);
    }

    public static String chuanHoa(String str){
        str= str.trim();//xoa khoang trang dau va khoang trang cuoi
        str= str.replaceAll("\\s+", " ");//cat bo cac khoang trang thua o giua cau
        String temp[]= str.split(" ");//tach xau thanh cac mang tu
        str="";
        for (int i=0; i < temp.length; i++){
            str+= String.valueOf(temp[i].charAt(0)).toUpperCase()+temp[i].substring(1);//viet hoc ky tu dau tien o moi tu
                                                                                       // va noi cac ky tu con lai
            if ( i < temp.length-1 ){
                str += " ";
            }
        }
        return  str;
    }

    public  void Xuat(){
        /*System.out.println("Ho ten\t\t SBD\t\t Dia chi\t\t GT\t\t Toan\t\t Ly\t\t Hoa");
        System.out.println(getHoTen()+"\t\t|"+getSbd()+"\t\t|"+getSbd()+"\t\t|"+getDiaChi()
                +"\t\t|"+(isGioiTinh()?"Nam":"Nu")+"\t\t|"+getDiemToan()+"\t\t|"+getDiemLy()+"\t\t"
        +getDiemHoa());*/
        System.out.println("Ho ten: "+getHoTen());
        System.out.println("So Bao danh: "+getSbd());
        System.out.println("Dia chi: "+getSbd());
        System.out.println("Gioi tinh: "+(isGioiTinh()? "Nam": "Nu"));
        System.out.println("Mon toan: "+getDiemToan());
        System.out.println("Mon ly: "+getDiemLy());
        System.out.println("Mon hoa: "+getDiemHoa());
    }

}

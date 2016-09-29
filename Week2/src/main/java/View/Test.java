package View;

import java.util.Scanner;

/**
 * Created by dell on 9/27/2016.
 */
public class Test {
    public static void main(String[] args){
        Menu menu= new Menu();
        Scanner input= new Scanner(System.in);
        int chon;
        do {
            menu.MoDau();
            chon= input.nextInt();
            switch (chon){
                case 1:{
                    menu.Option1();
                    break;
                }
                case 2:{
                    menu.Option2();
                    break;
                }
                case 3:{
                    menu.Option3();
                    break;
                }
                case 4:{
                    menu.Option4();
                    break;
                }
                case 5:{
                    menu.Option5();
                    break;
                }
                case 6:
                    break;
                default:{
                    System.out.println("Nhap sai, moi nhap lai.");
                    break;
                }
            }
        }while (chon !=6 );
    }
}

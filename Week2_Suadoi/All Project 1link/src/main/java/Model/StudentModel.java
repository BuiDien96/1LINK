package Model;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by dell on 10/2/2016.
 */
public class StudentModel {

    ArrayList<Student> listStudent;

    public StudentModel(){
        listStudent = new ArrayList<Student>();
    }
/***
 * tim kiem sbd
 * Tim kiem tong diem
 * tim kiem ho ten
 * tim kiem diem thanh phan
 */
    public ArrayList<Student> seachID(String id){
       ArrayList<Student> listResult= new ArrayList<Student>();
       for (int i=0; i< listStudent.size(); i++) {
           if (id.equalsIgnoreCase(listStudent.get(i).getId())){
               listResult.add(listStudent.get(i));
           }
       }
       return listResult;
    }

    public ArrayList<Student> seachName(String name){
        ArrayList<Student> listResult= new ArrayList<Student>();
        for (Student stu: listStudent) {
            if (name.equalsIgnoreCase(stu.getName())){
                listResult.add(stu);
            }
        }
        return listResult;
    }

    public ArrayList<Student> seachSumScore(double sum){
        ArrayList<Student> listResult= new ArrayList<Student>();
        for (Student stu: listStudent) {
            if (sum==(stu.getScore1()+stu.getScore2()+stu.getScore3())){
                listResult.add(stu);
            }
        }
        return  listResult;
    }

    public ArrayList<Student> seachScoreBySubject(double score, int choice){
        ArrayList<Student> listResult= new ArrayList<Student>();
        for (Student stu: listStudent) {
            switch (choice){
                case 1:{//tim theo diem score1
                    if (score==stu.getScore1()){
                        listResult.add(stu);
                    }
                    break;
                }
                case 2:{//tim theo diem score2
                    if (score== stu.getScore2()){
                        listResult.add(stu);
                    }
                    break;
                }
                case 3:{//tim theo diem score3
                    if (score==stu.getScore3()){
                        listResult.add(stu);
                    }
                    break;
                }
            }
        }
        return listResult;
    }

/**
 * Sap xep theo sbd
 * Sap xep theo tong diem
 * Sap xep theo Anphabe
 */

     public ArrayList<Student> Sort(int choice){
         switch (choice){
             case 1:{//sap xep theo sbd
                 Collections.sort(listStudent, new Comparator<Student>() {
                     public int compare(Student o1, Student o2) {
                         return (o1.getId().compareTo(o2.getId()));
                     }
                 });
                 break;
             }
             case 2:{//Sap xep theo tong diem tang dan
                 Collections.sort(listStudent, new Comparator<Student>() {
                     public int compare(Student o1, Student o2) {
                         if ((o1.getScore1()+o1.getScore2()+o1.getScore3()
                                 > (o2.getScore1()+o2.getScore2()+o2.getScore3())))
                         return 1;
                         else {
                             if ((o1.getScore1()+o1.getScore2()+o1.getScore3()
                                     == (o2.getScore1()+o2.getScore2()+o2.getScore3())))
                                 return 0;
                             else return -1;
                         }
                     }
                 });
             }
             case 3:{//sap xep theo anphabe
                 Collections.sort(listStudent, new Comparator<Student>() {
                     public int compare(Student o1, Student o2) {
                         return (o1.reverseName().compareTo(o2.reverseName()));
                     }
                 });
                 break;
             }
         }
         return listStudent;
     }

    /**
     * Thong ke
     */

    public void  Statistic(){
        int[] statistic= new int[]{0,0,0,0};
        System.out.println("Sum Student: "+listStudent.size());
        for (Student stu: listStudent) {
            if (stu.getScore1()+stu.getScore2()+stu.getScore3() < 15){
                statistic[0]++;
            }
            if (stu.getScore1()+stu.getScore2()+stu.getScore3() >= 15 &&
                    stu.getScore1()+stu.getScore2()+stu.getScore3() < 20){
                statistic[1]++;
            }
            if (stu.getScore1()+stu.getScore2()+stu.getScore3() >= 20 &&
                    stu.getScore1()+stu.getScore2()+stu.getScore3() < 25){
                statistic[2]++;
            }
            if (stu.getScore1()+stu.getScore2()+stu.getScore3() >=25){
                statistic[3]++;
            }
        }
        System.out.println(" Score less 15: "+ statistic[0]+" student.");
        System.out.println(" Score from 15 to 20: "+ statistic[1]+ " student");
        System.out.println(" Score from 20 to 25: "+statistic[2]+" student.");
        System.out.println(" Score bigger 25: "+statistic[3]+" student.");

    }

/**
 *Doc ra file
  */

   public boolean WriteFile(ArrayList<Student> listStudent,String fileName) throws Exception{
       try {
           File file= new File(fileName);
           FileOutputStream f= new FileOutputStream(file);
           ObjectOutputStream oStream= new ObjectOutputStream(f);
           oStream.writeObject(listStudent);
           oStream.flush();
       }catch (Exception e){
           throw e;
       }
       return true;
   }

    /**
     * ghi vao file
     */


    public ArrayList<Student> ReadFile(String fileName) throws Exception{
        //ArrayList<Student> listSt= null;
        try {
            File file= new File(fileName);
            //FileInputStream f= new FileInputStream(file);//tao file f tro den file
            ObjectInputStream inStream= new ObjectInputStream(new FileInputStream(file));
            //listStudent= new ArrayList<Student>();
            listStudent = (ArrayList<Student>)inStream.readObject();
            inStream.close();
        }

        catch (Exception e){
            throw e;
        }
        return  listStudent;

    }

    public ArrayList<Student> editStudent(String id){
        for (int i = 0; i < listStudent.size(); i++) {
            if (id.equalsIgnoreCase(listStudent.get(i).getId())){
                Student student= new Student();
                student.input();
            }
        }
        return  listStudent;
    }

    public ArrayList<Student> deleteStudent(String id){
        for (int i = 0; i < listStudent.size(); i++) {
            if (id.equalsIgnoreCase(listStudent.get(i).getId())){
                listStudent.remove(listStudent.get(i));
            }
        }
        return listStudent;
    }






}

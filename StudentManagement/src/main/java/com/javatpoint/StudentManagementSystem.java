package com.javatpoint;

import com.javatpoint.model.Student;

import java.util.*;

public class StudentManagementSystem {
    private HashMap<Integer, Student> studentsData ;
    public StudentManagementSystem(){
        studentsData = new HashMap<>();
    }

    //Add Students
    public void addStudents(String name, Integer roll, Character grade, Float gpa){
        Student student = new Student(name,roll,grade,gpa);

        studentsData.put(roll,student);
    }

    //Update Students
    public void updateStudentData(Integer roll, Float studentGPA, Character studentGRADE){
        Student student = studentsData.get(roll);
        if (student!=null){
            student.setGpa(studentGPA);
            student.setGrade(studentGRADE);
            System.out.println("Successfully Updated Student Data "+student);
        }else {
            System.out.println("No Student Found, Create New Student.");
        }
    }
    //Search Students
    public void searchStudent(Integer roll){
        Student stud = studentsData.get(roll);
//        System.out.println(stud);
        if(stud != null){
            System.out.println(stud);
        }
    }

    public List<Student> searchByGrades(char grade){
        List<Student> studentsWithGrades = new ArrayList<>();
        for (Student student : studentsData.values()){
            if (student.getGrade()==grade){
                studentsWithGrades.add(student);
            }
        }
        return studentsWithGrades;
    }

    //Delete Function
    public void deleteStudent(Integer roll){
        if (studentsData.containsKey(roll)){
            studentsData.remove(roll);
            System.out.println("Student "+roll+ " deleted successfully.");
        }
    }

    public List<Student> printAboveGpa(float gpa){
        System.out.println("Students having "+gpa+" gpa and more");
        List<Student> aboveGpa = new ArrayList<>();
        for (Student student:studentsData.values()){
            if (student.getGpa()>=gpa){
                aboveGpa.add(student);
            }

        }
        Collections.sort(aboveGpa,Comparator.comparingDouble(Student::getGpa));
        return aboveGpa;
    }

    public List<Student> printBelowGpa(float gpa){
        System.out.println("Students having "+gpa+" gpa and less");
        List<Student> belowGpa = new ArrayList<>();
        for (Student student:studentsData.values()){
            if (student.getGpa()<gpa){
                belowGpa.add(student);
            }
        }
        Collections.sort(belowGpa,Comparator.comparingDouble(Student::getGpa));
        return belowGpa;
    }

    public void printAllStudent(){
        System.out.println("All Student Information: ");
        for (Student student:studentsData.values()){
            System.out.println("Name: "+student.getName()+", Roll: "+student.getRoll()+", Grade: "+student.getGrade()+", GPA: "+student.getGpa());
        }
    }


    public static void main(String[] args) {
        StudentManagementSystem s1 = new StudentManagementSystem();

        //Adding new student
        s1.addStudents("Jay",43,'A',8.2f);
        s1.addStudents("Dev",32,'C',7.8f);
        s1.addStudents("Khement",33,'B',8.2f);
        s1.addStudents("Akash",45,'A',6.8f);

        //Search by student id(roll-number)
//        s1.searchStudent(32);

        System.out.println();

       //Update Students Data
//        s1.updateStudentData(43,8.4F,'A');

        System.out.println();

        //Delete Students Data
//        s1.deleteStudent(32);

        System.out.println();

        //PrintAll Students Info
        s1.printAllStudent();

        System.out.println();

        //above gpa
        List<Student> studentsAboveGpa = s1.printAboveGpa(7.0f);
        for (Student student:studentsAboveGpa){
            System.out.println("Name: "+student.getName()+", Roll: "+student.getRoll()+", GPA: "+student.getGpa());
        }

        System.out.println();

        //bellow gpa
        List<Student> studentsBelowGpa = s1.printBelowGpa(9.0f);
        for (Student student:studentsBelowGpa){
            System.out.println("Name: "+student.getName()+", Roll: "+student.getRoll()+", GPA: "+student.getGpa());
        }

        System.out.println();

        //search by grades
        char grade = 'A';
        List<Student> studentsGrades = s1.searchByGrades(grade);
        System.out.println("Student's with garde "+grade+": ");
        for (Student student:studentsGrades){
            System.out.println("Name: "+student.getName()+", Roll: "+student.getRoll()+", GPA: "+student.getGpa());
        }
    }


}
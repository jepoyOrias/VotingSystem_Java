/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

/**
 *
 * @author acer
 */
public class Student {
    private static String IdNumber;
    private static String lastname;
    private static String firstname;
    private static String yearAndSection;
    private static String course;
    private static String gender;
    private static String status;
    private static String position;
    
    
    public static String getPosition() {
        return position;
    }

    public static void setPosition(String position) {
        Student.position = position;
    }
 
    public static String getIdNumber() {
        return IdNumber;
    }

    public static void setIdNumber(String IdNumber) {
        Student.IdNumber = IdNumber;
    }

    public static String getLastname() {
        return lastname;
    }

    public static void setLastname(String lastname) {
        Student.lastname = lastname;
    }

    public static String getFirstname() {
        return firstname;
    }

    public static void setFirstname(String firstname) {
        Student.firstname = firstname;
    }

    public static String getYearAndSection() {
        return yearAndSection;
    }

    public static void setYearAndSection(String yearAndSection) {
        Student.yearAndSection = yearAndSection;
    }

    public static String getCourse() {
        return course;
    }

    public static void setCourse(String course) {
        Student.course = course;
    }

    public static String getGender() {
        return gender;
    }

    public static void setGender(String gender) {
        Student.gender = gender;
    }

    public static String getStatus() {
        return status;
    }

    public static void setStatus(String status) {
        Student.status = status;
    } 
}

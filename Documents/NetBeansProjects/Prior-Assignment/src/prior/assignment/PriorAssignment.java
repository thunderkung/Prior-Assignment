/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prior.assignment;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class PriorAssignment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        LocalDate startEventDate = LocalDate.of(2564, 6, 1);
        LocalDate endEventDate = LocalDate.of(2564, 8, 31);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/M/d");
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d MMMM uuuu");

        while (true) {

            System.out.print("เพศ: ");
            String sex = scan.next();
            System.out.print("ปีเกิด/เดือน/วัน: ");
            String dateOfBirth = scan.next();

            LocalDate DoB = LocalDate.parse(dateOfBirth, dateFormat);
            String strDate = DoB.format(formatters);
            System.out.println(strDate + " || " + Period.between(DoB, startEventDate).getYears() + " || " + Period.between(DoB, startEventDate).getMonths());
            //System.out.println("age " + Period.between(DoB, startEventDate));
            vacine_Event(DoB);

        }

//        LocalDate date1 = LocalDate.of(2017, 1, 13);    
//        System.out.println(date1.isLeapYear());    
//        LocalDate date2 = LocalDate.of(2016, 9, 23);    
//        System.out.println(date2.isLeapYear());   
    }

    public static void vacine_Event(LocalDate DoB) {

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/M/d");
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d MMMM uuuu");

        LocalDate startEventDate = LocalDate.of(2564, 6, 1);
        LocalDate endEventDate = LocalDate.of(2564, 8, 31);

        String startDate = startEventDate.format(formatters);
        String endDate = endEventDate.format(formatters);

        if (Period.between(DoB, startEventDate).getYears() == 0 && (DoB.getMonthValue() + 6 <= 8 || DoB.getMonthValue() == 12)) {
            // age 6M in vacine event
            String aged = DoB.plusMonths(6).format(formatters);
            System.out.println("เข้ารับบริการได้ตั้งแต่วันที่ " + aged + " - " + endDate);
        } else if ((Period.between(DoB, endEventDate).getYears() >= 1 && Period.between(DoB, endEventDate).getYears() <= 2) && (DoB.getMonthValue() >= 6 || DoB.getMonthValue() <= 8)) {
            System.out.println("เข้ารับบริการได้ตั้งแต่วันที่ " + startDate + " - " + DoB.plusYears(2).format(formatters));

        } else if (Period.between(DoB, startEventDate).getYears() <= 2 && Period.between(DoB, startEventDate).getMonths() >= 6) {

            System.out.println("เข้ารับบริการได้ตั้งแต่วันที่ " + startDate + " - " + endDate);

        } else if (Period.between(DoB, startEventDate).getYears() >= 65) {
            // age > 65Y before vacine event
            System.out.println("เข้ารับบริการได้ตั้งแต่วันที่ " + startDate + " - " + endDate);
        } else if (Period.between(DoB, endEventDate).getYears() >= 65) {
            // age 65Y in vacine event
            String aged = DoB.plusYears(65).format(formatters);
            System.out.println("เข้ารับบริการได้ตั้งแต่วันที่ " + aged + " - " + endDate);
        } else if (Period.between(DoB, endEventDate).getYears() <= 65) {
            // age 65Y after vacine event
            String aged = DoB.plusYears(65).format(formatters);
            System.out.println("ไม่สามารถเข้ารับบริการได้ เนื่องจากอายุจะครบ 65 ปี วันที่ " + aged);
        } else if (Period.between(DoB, startEventDate).getYears() > 2 && Period.between(DoB, startEventDate).getYears() < 64) {
            String aged = DoB.plusYears(65).format(formatters);
            System.out.println("ไม่อยู่ในช่วงอายุที่สามารรภเข้าฉีดวัคซีนได้");
        } else if (Period.between(DoB, startEventDate).getYears() == 0 && Period.between(DoB, startEventDate).getMonths() >= 0) {
            // age 6M in vacine event
            String aged = DoB.plusMonths(65).format(formatters);
            System.out.println("เข้ารับบริการได้ตั้งแต่วันที่ " + aged + "-" + endDate);
        }
    }
}

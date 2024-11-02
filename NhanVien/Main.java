package OOP_End.NhanVien;

import java.time.LocalDate;
import java.time.Period;

public class Main {
    public static void main(String[] args) {
        LocalDate birthDate = LocalDate.of(2005, 2, 14); // Ngày sinh
        LocalDate currentDate = LocalDate.now(); // Ngày hiện tại

        // Tính khoảng cách giữa ngày sinh và ngày hiện tại
        Period age = Period.between(birthDate, currentDate);

        System.out.println("Tuổi hiện tại: " + age.getYears());
    }
}
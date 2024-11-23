import java.time.LocalDate;
import java.util.Scanner;
import java.time.Period;
public class Main {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.print("Введите ФИО: ");
        Scanner scanner =  new Scanner(System.in);
        String line = scanner.nextLine();
        String[]bio = line.split(" ");
        String name = bio[1];
        String surname = bio[0];
        String middle_name = bio[2];
        String initials = surname + " " + name.charAt(0) + "." + middle_name.charAt(0) + ".";
        System.out.print("Введите дату рождения(d.m.y): ");
        line = scanner.nextLine();
        bio = line.split("\\.");
        LocalDate date_of_birth = LocalDate.of(Integer.parseInt(bio[2]),Integer.parseInt(bio[1]),Integer.parseInt(bio[0]));
        int age = Period.between(date_of_birth, today).getYears();
        System.out.println("Инициалы: " + initials);
        if(middle_name.endsWith("ич")){
            System.out.println("Пол: М");
        }
        else if(middle_name.endsWith("а")){
            System.out.println("Пол: Ж");
        }
        else{
            System.out.println("Пол: ОПРЕДЕЛИТЬ_НЕ_УДАЛОСЬ");
        }
        if((age % 10 == 1)&&(age%100!=11)){
            System.out.println("Возраст: "+age+" год");
        }
        else if(((age % 10 >= 2) && (age % 10 <= 4)) && !((age % 100 >= 12) && (age % 100 <= 14))){
            System.out.println("Возраст: " + age + " года");
        }
        else{
            System.out.println("Возраст: " + age + " лет");
        }
    }
}
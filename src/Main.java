import java.time.LocalDate;
import java.util.Scanner;
import java.time.Period;
import java.time.format.DateTimeParseException;
public class Main {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        Scanner scanner =  new Scanner(System.in);
        try{
            System.out.print("Введите ФИО: ");
            String line = scanner.nextLine();
            String[]bio = line.split(" ");
            if(bio.length!=3){
                throw new IllegalArgumentException("ФИО должно состоять из трех частей");
            }
            for(int i =0;i<3;++i){
                for(int j =0;j<bio[i].length();++j){
                    if(!Character.isLetter(bio[i].charAt(j))){
                        throw new IllegalArgumentException("ФИО дожно содердать только буквы");
                    }
                }
            }
            String name = bio[1];
            String surname = bio[0];
            String middle_name = bio[2];
            String initials = surname + " " + name.charAt(0) + "." + middle_name.charAt(0) + ".";
            System.out.print("Введите дату рождения(d.m.y): ");
            line = scanner.nextLine();
            bio = line.split("\\.");
            if((bio.length!=3) || (Integer.valueOf(bio[0]) >31)||(Integer.valueOf(bio[0])<1) ||(Integer.valueOf(bio[1])<1)
                    ||(Integer.valueOf(bio[1])>12)||(bio[2].length() != 4)){
                throw new IllegalArgumentException("Неправильный формат даты рождения");
            }
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
        catch(NumberFormatException e){
            System.out.println("Ошибка: Неверный формат числовых данных. Убедитесь, что дата рождения введена корректно.");
        }
        catch(DateTimeParseException e){
            System.out.println("Ошибка: Неверная дата. Убедитесь, что дата рождения введена в формате д.м.гггг.");
        }
        catch(IllegalArgumentException e){
            System.out.println("Ошибка: "+ e.getMessage());
        }
    }
}
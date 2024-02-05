package exam1;
import java.math.BigDecimal;
import java.util.Scanner;
public class FinancialCalculator {
    private static final BigDecimal[] arr = new BigDecimal[30];
    public static void  main(String[] args){
        String[] arr = new String[31];
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("---------------------------------------------------------------------");
            System.out.println("|Добро пожаловать в меню. Выберите цифру необходимого пункта\t\t|");
            System.out.println("|1. Введите рассходы в определенный день. \t\t\t\t\t\t\t|");
            System.out.println("|2. Вывести все траты в течение месяца. \t\t\t\t\t\t\t|");
            System.out.println("|3. Самая большая трата в течение месяца. \t\t\t\t\t\t\t|");
            System.out.println("|4. Конвертировать ваши расходы за месяц в евро, долларах и юанях.  |");
            System.out.println("|0. Выйти из меню\t\t\t\t\t\t\t\t\t\t\t\t\t|");
            System.out.println("---------------------------------------------------------------------");
            System.out.print("Введите номер: ");
            int menu = sc.nextInt();
            switch (menu){
                case 1:
                    DayMoney();
                    break;
                case 2:
                    DayMonth();
                    break;
                case 3:
                    MostDaySpent();
                    break;
                case 4:
                    DEY();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Чето не то");
                    return;
            }
        }

    }
    private static void DayMoney() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите день: ");
        int day = sc.nextInt();
        System.out.print("Введите расходы: ");
        BigDecimal Amount = sc.nextBigDecimal();

        if (arr[day] != null) {
            System.out.print("Этот день уже записан. Перезаписать? (1 – да, 0 – нет): ");
            int Answ = sc.nextInt();
            if (Answ == 1) {
                arr[day] = Amount;
            }
        } else {
            arr[day] = Amount;
        }


    }
    private static void DayMonth(){
        System.out.println("Список расходов за месяц: ");
        for(int i = 1;i < arr.length;i++){
            if(arr[i] != null){
                System.out.println("Расходы за " + i + " день = " + arr[i]);
            }
        }
    }
    private static void MostDaySpent(){
        BigDecimal MaxNum = BigDecimal.ZERO;
        int MaxDay = -1;

        for(int j = 1; j < arr.length;j++){
            if(arr[j] != null && arr[j].compareTo(MaxNum) > 0){
                MaxDay = j;
                MaxNum = arr[j];

            }

        }
        System.out.println("Самые большие расходы за месяц");
        System.out.println("День: " + MaxDay + "\nКол-во денег: " + MaxNum );

    }
    private static void DEY(){
        BigDecimal MaxSpend = BigDecimal.ZERO;
        BigDecimal SpendDay = BigDecimal.ZERO;
        for(int k = 0;k < arr.length;k++){
            if(arr[k] != null){
                MaxSpend = SpendDay.add(arr[k]);
            }
        }
        System.out.println("Все затраты за месяц, в данных валютах");
        System.out.println("В €: " + MaxSpend.multiply(new BigDecimal("0.012")) + " EUR");
        System.out.println("В $: " + MaxSpend.multiply(new BigDecimal("0.014")) + " USD");
        System.out.println("В ¥: " + MaxSpend.multiply(new BigDecimal("0.089")) + " CNY");
    }
}
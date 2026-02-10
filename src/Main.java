import java.util.Scanner;

class Main {

    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }

    public static int taxEarnings(int earnings) {
        int tax = earnings * 6 / 100;
        return tax;
    }

    public static void main(String[] args) {
        int earnings = 0;    // доходы
        int spendings = 0;   // расходы
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n" + "Выберите операцию и введите её номер, либо введите end:\n" +
                    "1. Добавить новый доход\n" + "2. Добавить новый расход\n" + "3. Выбрать систему налогообложения");
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }
            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    String moneyStr = scanner.nextLine();
                    int moneyEarnings = Integer.parseInt(moneyStr);
                    earnings += moneyEarnings;
                    break;
                case 2:
                    System.out.println("Введите сумму расхода:");
                    String moneyStr2 = scanner.nextLine();
                    int moneySpendings = Integer.parseInt(moneyStr2);
                    spendings += moneySpendings;
                    break;
                case 3:
                    int tax1 = taxEarningsMinusSpendings(earnings, spendings);
                    int tax2 = taxEarnings(earnings);
                    int dif = tax1 - tax2;
                    if (dif > 0) {
                        System.out.println("Мы советуем вам УСН доходы\n" + "Ваш налог составит: " + tax2 + " руб\n" +
                                "Налог на другой системе: " + tax1 + " рублей\n" + "Экономия: " + dif + " руб");
                    } else if (dif < 0) {
                        System.out.println("Мы советуем вам УСН доходы минус расходы\n" + "Ваш налог составит: " + tax1 + " рублей\n" +
                                "Налог на другой системе: " + tax2 + " руб\n" + "Экономия: " + Math.abs(dif) + " руб");
                    } else {
                        System.out.println("Ваш налог в обеих системах составит: " + tax1 + " руб\n" + "Можете выбрать любую систему налогообложения");
                    }
                    break;
                default:
                    System.out.println("Такой операции нет");
            }
        }
    }
}
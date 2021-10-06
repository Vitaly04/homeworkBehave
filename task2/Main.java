package task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Frog frog = new Frog();
        int steps = 0;
        List<FrogCommand> commands = new ArrayList<>();
        int curCommand = -1;

        while (true) {
            System.out.println("Введите код команды");
            String input = scanner.next();
            //считываем ввод и конструируем комманду, если
            //пользователь не хотел выйти
            if ("0".equals(input)) break;
            if ("<<".equals(input)) {
                if (curCommand < 0) {
                    System.out.println("Нечего отменять!");
                } else {
                    commands.get(curCommand).undo();
                    commands.remove(curCommand);
                    curCommand--;
                }
            } else if (">>".equals(input)) {
                if (curCommand < 0) {
                    System.out.println("Нечего повторить!");
                } else {
                    FrogCommand cmd = new FrogCommands().jumpCommand(frog, steps);
                    curCommand++;
                    commands.add(cmd);
                    cmd.doit();
                }
            } else {
                if (curCommand != commands.size() - 1) {
                    commands.remove(curCommand);
                }
                steps = Integer.parseInt(input);
                FrogCommand cmd = new FrogCommands().jumpCommand(frog, steps);
                curCommand++;
                commands.add(cmd);
                cmd.doit();
            }
            char frogChar = 'f';
            char field = '-';
            char[] arrayChars = new char[11];
            for (int i = 0; i < arrayChars.length; i++) {
                arrayChars[i] = field;
                arrayChars[frog.position] = frogChar;
            }
            System.out.println(Arrays.toString(arrayChars));
        }
    }
}

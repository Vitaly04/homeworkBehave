package task2;

public class FrogCommands {

    public static FrogCommand jumpCommand(Frog frog, int steps) {

        return new FrogCommand() {
            @Override
            public boolean doit() {
                frog.jump(steps);
                return false;
            }

            @Override
            public boolean undo() {
                frog.jump(-steps);
                return false;
            }
        };
    }
}

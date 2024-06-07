package commands;

public class QuitCommand implements Command {
    @Override
    public void execute(String[] args) {
        System.out.println("Exiting editor.");
        System.exit(0);
    }
}

package Presentation;

import Function.LoginSampleException;
import static Presentation.HTMLGenerator.AddPlayerClass;
import static Presentation.HTMLGenerator.AddPlayerRaceAndGender;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
//        commands.put("login", new Login());
//        commands.put("register", new Register());
//        commands.put("Backdoor", new Backdoor());
    }

    static Command from(HttpServletRequest request) {
        String commandName = request.getParameter("command");
        if (commands == null) {
            initCommands();
            commands.put("NewPlayer", new NewPlayer());
            commands.put("addPlayerRaceAndGender", new AddPlayerRaceAndGender());
            commands.put("addPlayerClass", new AddPlayerClass());
            commands.put("addPlayer", new AddPlayer());
            commands.put("AllPlayers", new AllPlayers());
        }
        return commands.getOrDefault(commandName, new UnknownCommand());
    }

    abstract String execute(HttpServletRequest request, HttpServletResponse response)
            throws LoginSampleException;

}

package by.epam.training.controller.controller;

import by.epam.training.bean.Request;
import by.epam.training.bean.Response;
import by.epam.training.controller.command.Command;

/**
 * Created by Алексей on 19.10.2016.
 */
public class Controller {
    private final CommandProvider provider = new CommandProvider();

    public Response doAction(Request request) {
        String commandName = request.getCommandName();

        Command command = provider.getCommand(commandName);

        Response response = command.execute(request);//!!!!! тут выполняется запрос!

        return response;

    }
}

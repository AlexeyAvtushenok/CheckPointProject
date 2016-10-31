package by.epam.training.controller.controller;

import by.epam.training.controller.command.Command;
import by.epam.training.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Алексей on 19.10.2016.
 */
class CommandProvider {
    private Map<String, Command> commands = new HashMap<String, Command>();

    CommandProvider() {
        commands.put("ADD_NEW_GOODS", new AddGoods());// и когда вы научитесь именовать константные строки?
        commands.put("DELETE_GOODS", new DeleteGoods());
        commands.put("RETURN_BY_CATEGORY", new ShowByCategoryGoods());
        commands.put("SHOW_INFORMATION", new ShowInformation());
        commands.put("SHOW_ALL", new ShowAll());
    }


    public Command getCommand(String commandName){
        Command command;
        command = commands.get(commandName);
        return command;
    }

}

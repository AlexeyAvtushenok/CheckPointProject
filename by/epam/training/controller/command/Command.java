package by.epam.training.controller.command;

import by.epam.training.bean.Request;
import by.epam.training.bean.Response;

/**
 * Created by Алексей on 19.10.2016.
 */
public interface Command {
    Response execute(Request request);
}

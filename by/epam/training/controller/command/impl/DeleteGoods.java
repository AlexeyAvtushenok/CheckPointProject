package by.epam.training.controller.command.impl;

import by.epam.training.bean.AddRequest;
import by.epam.training.bean.DeleteRequest;
import by.epam.training.bean.Request;
import by.epam.training.bean.Response;
import by.epam.training.controller.command.Command;
import by.epam.training.service.EditGoodsService;
import by.epam.training.service.ServiceFactory;
import by.epam.training.service.exception.ServiceException;
import org.apache.log4j.Logger;

/**
 * Created by Алексей on 19.10.2016.
 */
public class DeleteGoods implements Command{
    private final static Logger logger = Logger.getRootLogger();
    @Override
    public Response execute(Request request) {
        DeleteRequest deleteRequest = null;
        if(request instanceof DeleteRequest)
        {
            deleteRequest = (DeleteRequest) request;
        }
        int id = deleteRequest.getDeleteId();


        ServiceFactory factory = ServiceFactory.getInstance();
        EditGoodsService service = factory.getEditGoodsService();
        Response response= new Response();

        try {
            service.deleteGoods(id);
            response.setErrorStatus(false);
            response.setSimpleMessage("Goods was deleted");
        } catch (ServiceException e) {
            response.setErrorStatus(true);
            response.setErrorMessage("Goods wasn't deleted");
            logger.error(response.getErrorMessage());
        }
        return response;
    }
}

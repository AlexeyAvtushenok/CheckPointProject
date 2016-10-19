package by.epam.training.controller.command.impl;

import by.epam.training.bean.AddRequest;
import by.epam.training.bean.Request;
import by.epam.training.bean.Response;
import by.epam.training.bean.entity.Goods;
import by.epam.training.controller.command.Command;
import by.epam.training.service.EditGoodsService;
import by.epam.training.service.ServiceFactory;
import by.epam.training.service.exception.ServiceException;
import org.apache.log4j.Logger;

/**
 * Created by Алексей on 19.10.2016.
 */
public class AddGoods implements Command{


    private final static Logger logger = Logger.getRootLogger();
    @Override
    public Response execute(Request request) {
        AddRequest addRequest = null;
        if(request instanceof AddRequest)
        {
            addRequest = (AddRequest) request;
        }
        int id = addRequest.getAddID();
        String category = addRequest.getAddCategory();
        String name = addRequest.getAddName();
        double cost = addRequest.getAddCost();

        ServiceFactory factory = ServiceFactory.getInstance();
        EditGoodsService service = factory.getEditGoodsService();
        Response response= new Response();

        try {
            service.addGoods(id, category, name,cost);
            response.setErrorStatus(false);
            response.setSimpleMessage("Goods was added");
        } catch (ServiceException e) {
            response.setErrorStatus(true);
            response.setErrorMessage("Goods wasn't added");
            logger.error(response.getErrorMessage());
        }
        return response;
    }
}

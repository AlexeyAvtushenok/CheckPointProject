package by.epam.training.controller.command.impl;

import by.epam.training.bean.Request;
import by.epam.training.bean.Response;
import by.epam.training.bean.ShowByCategoryRequest;
import by.epam.training.bean.entity.Goods;
import by.epam.training.controller.command.Command;
import by.epam.training.service.SearchGoodsService;
import by.epam.training.service.ServiceFactory;
import by.epam.training.service.exception.ServiceException;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by Алексей on 19.10.2016.
 */
public class ShowAll implements Command {
    private final static Logger logger = Logger.getRootLogger();
    @Override
    public Response execute(Request request) {

            Request showReq = null;


            ServiceFactory factory = ServiceFactory.getInstance();
            SearchGoodsService service = factory.getSearchGoodsService();
            Response response= new Response();

            try {
                List<Goods> list = service.returnGoods();
                response.setGoods(list);
                response.setErrorStatus(false);
                response.setSimpleMessage("Goods");
            } catch (ServiceException e) {
                response.setErrorStatus(true);
                response.setErrorMessage("Goods wasn't find");
                logger.error(response.getErrorMessage());
            }
            return response;
        }
}

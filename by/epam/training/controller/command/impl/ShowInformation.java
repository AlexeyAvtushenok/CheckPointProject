package by.epam.training.controller.command.impl;

import by.epam.training.bean.*;
import by.epam.training.bean.entity.CostComparator;
import by.epam.training.bean.entity.Goods;
import by.epam.training.controller.command.Command;
import by.epam.training.service.SearchGoodsService;
import by.epam.training.service.ServiceFactory;
import by.epam.training.service.exception.ServiceException;
import org.apache.log4j.Logger;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by Алексей on 19.10.2016.
 */
public class ShowInformation implements Command {
    private final static Logger logger = Logger.getRootLogger();
    @Override
    public Response execute(Request request) {
        ShowInformationReqest reqest = null;

        if(request instanceof ShowInformationReqest)
        {
            reqest = (ShowInformationReqest) request;
        }
        ServiceFactory factory = ServiceFactory.getInstance();
        SearchGoodsService service = factory.getSearchGoodsService();
        Response response= new Response();
        String category = reqest.getCategory();
        try {
            List<Goods> list = service.returnGoods(category);
            CostComparator costComparator = new CostComparator();
            list.sort(costComparator);

            List<Goods> list3 = new ArrayList<>();
            list3.add(list.get(0));
            list3.add(list.get(list.size()-1));
            response.setGoods(list3);
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


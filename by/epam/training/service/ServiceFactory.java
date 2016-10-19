package by.epam.training.service;

import by.epam.training.service.impl.EditGoods;
import by.epam.training.service.impl.SearchGoods;

/**
 * Created by Алексей on 19.10.2016.
 */
public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private EditGoodsService editGoodsService = new EditGoods();

    private SearchGoodsService searchGoodsService = new SearchGoods();

    private ServiceFactory(){}


    public static ServiceFactory getInstance(){
        return instance;
    }

    public EditGoodsService getEditGoodsService(){
        return editGoodsService;
    }

    public SearchGoodsService getSearchGoodsService(){
        return searchGoodsService;
    }

}

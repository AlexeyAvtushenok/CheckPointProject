package by.epam.training.service;

import by.epam.training.bean.entity.Goods;
import by.epam.training.service.exception.ServiceException;

/**
 * Created by Алексей on 19.10.2016.
 */
public interface EditGoodsService {
    void addGoods(int id, String category, String name, double cost) throws ServiceException;

    void deleteGoods(int id) throws ServiceException;
}

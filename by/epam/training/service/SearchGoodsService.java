package by.epam.training.service;

import by.epam.training.bean.entity.Goods;
import by.epam.training.service.exception.ServiceException;

import java.util.List;

/**
 * Created by Алексей on 19.10.2016.
 */
public interface SearchGoodsService {
    List<Goods> returnGoods(String category) throws ServiceException;
    List<Goods> returnGoods() throws ServiceException;
}

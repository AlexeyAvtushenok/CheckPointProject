package by.epam.training.bean;

import by.epam.training.bean.entity.Goods;

import java.util.List;

/**
 * Created by Алексей on 19.10.2016.
 */
public class Response {
    private boolean errorStatus;
    private String errorMessage;
    private String simpleMessage;
    private List<Goods> goods;

    public boolean isErrorStatus() {
        return errorStatus;
    }

    public void setErrorStatus(boolean errorStatus) {
        this.errorStatus = errorStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getSimpleMessage() {
        return simpleMessage;
    }

    public void setSimpleMessage(String simpleMessage) {
        this.simpleMessage = simpleMessage;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> notes) {
        this.goods = notes;
    }
}

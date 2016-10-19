package by.epam.training.bean;

import by.epam.training.bean.Request;

/**
 * Created by Алексей on 19.10.2016.
 */
public class ShowByCategoryRequest extends Request {
    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

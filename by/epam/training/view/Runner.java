package by.epam.training.view;

import by.epam.training.bean.*;
import by.epam.training.bean.entity.Goods;
import by.epam.training.controller.command.impl.ShowInformation;
import by.epam.training.controller.controller.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Алексей on 19.10.2016.
 */
public class Runner {
    public static void main(String[] args) {
        final String add = "ADD_NEW_GOODS";
        final String del = "DELETE_GOODS";
        final String showComman = "RETURN_BY_CATEGORY" ;
        final String showInf = "SHOW_INFORMATION";
        final String showAll = "SHOW_ALL";
        Controller controller = new Controller();

        AddRequest request = new AddRequest();
        request.setCommandName(add);
        request.setAddID(13);
        request.setAddCategory("pump");
        request.setAddName("mp325");
        request.setAddCost(3);

        Response response = controller.doAction(request);

        if (!response.isErrorStatus()) {
            System.out.println(response.getSimpleMessage());
        } else {
            System.out.println(response.getErrorMessage());
        }


        DeleteRequest delrequest = new DeleteRequest();
        delrequest.setCommandName(del);
        delrequest.setDeleteId(13);
        Response delresponse = controller.doAction(delrequest);

        if (!delresponse.isErrorStatus()) {
            System.out.println(delresponse.getSimpleMessage());
        } else {
            System.out.println(delresponse.getErrorMessage());
        }

        ShowByCategoryRequest show = new ShowByCategoryRequest();
        show.setCommandName(showComman);
        show.setCategory("bicycle");
        Response showResp = controller.doAction(show);
        List<Goods> list;
        list = showResp.getGoods();
        if (!showResp.isErrorStatus()) {
            System.out.println(showResp.getSimpleMessage());
        } else {
            System.out.println(showResp.getErrorMessage());
        }

        for (Goods goods: list) {
            System.out.println(goods);

        }

        ShowInformationReqest showInformationReqest = new ShowInformationReqest();
        showInformationReqest.setCommandName(showInf);
        showInformationReqest.setCategory("bicycle");
        Response showInfResp = controller.doAction(showInformationReqest);
        List <Goods> minMaxList = showInfResp.getGoods();
        if (!showInfResp.isErrorStatus()) {
            System.out.println(showInfResp.getSimpleMessage());
        } else {
            System.out.println(showInfResp.getErrorMessage());
        }
        System.out.println("Min cost: " + minMaxList.get(0).getCost());
        System.out.println("Max cost: " + minMaxList.get(1).getCost());


        Request showall = new Request();
        showall.setCommandName(showAll);
        Response showAllResp = controller.doAction(showall);
        List<Goods> wholeList = showAllResp.getGoods();
        if (!showAllResp.isErrorStatus()) {
            System.out.println(showAllResp.getSimpleMessage());
        } else {
            System.out.println(showAllResp.getErrorMessage());
        }

        for (Goods goods: wholeList) {
            System.out.println(goods);
        }
    }
}


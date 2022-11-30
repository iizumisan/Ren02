package model;

import java.util.List;

import domain.Kakikomi;

public class FindCommentLogic {
    public List<Kakikomi> executeFindComment() {
        FindCommentDAO fcdao = new FindCommentDAO();
        List<Kakikomi> list = fcdao.findcomment();
        return list;
    }

}

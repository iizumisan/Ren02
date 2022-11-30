package model;

import domain.Kakikomi;

public class AddCommentLogic {
    public void executeAddComment(Kakikomi bo) {
        AddCommentDAO acdao = new AddCommentDAO(bo);

    }
}
package mx.edu.utng.orders.model;



public class Replies {
    private  String replyId;
    private String replyContent;
    private String replyDate;


    public Replies(String replyId,String replyContent,String replyDate) {
        this.replyId = replyId;
        this.replyContent = replyContent;
        this.replyDate = replyDate;


    }


    public Replies(){
        this("","","");
    }

    public String getReplyId() {
        return replyId;
    }

    public void setReplyId(String replyId) {
        this.replyId = replyId;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public String getReplyDate() {
        return replyDate;
    }

    public void setReplyDate(String replyDate) {
        this.replyDate = replyDate;
    }

    @Override
    public String toString() {
        return "Replies{" +
                "replyId='" + replyId + '\'' +
                ", replyContent='" + replyContent + '\'' +
                ", replyDate='" + replyDate + '\'' +
                '}';
    }
}

public class Post
{
    private int postOrder;       
    private String post;
    private String userName;
    private String webSite;

    public Post( int postOrder, String post, String userName, String webSite)
    {
        this.postOrder = postOrder;
        this.userName = userName;  
        this.post = post;
        this.webSite = webSite;
    }

    public String getUserName()
    {
        return userName;
    }

    public String getPostInfo()
    {
        return postOrder + "," + post + "," + userName + "," + webSite;
    }
    
    public int getPostOrder()
    {
        return postOrder;
    }
   
    
     public String getPost()
    {
        return post;
    }
    public String getWebSite()
    {
        return webSite;
    }
}

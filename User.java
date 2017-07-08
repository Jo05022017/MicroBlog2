public class User
{
    private String avatar;
    private String userName;
    private String name;
    private String emailAdr;

    public User(String avatar, String userName, String name, String emailAdr)
    {
        this.avatar = avatar;
        this.userName = userName;
        this.name = name;
        this.emailAdr = emailAdr;
    }

    public String getUserInfo()
    {
        return userName + "," + name + "," + emailAdr + "," + avatar;
        
    }

    public String getUserName()
    {
        return userName;
    }

    public String getAvatar()
    {
        return avatar;
    }

    public void setAvatar(String avatar)
    {
        this.avatar = avatar;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return emailAdr;
    }

    public void setEmail(String emailAdr)
    {
        this.emailAdr = emailAdr;
    }
}

    
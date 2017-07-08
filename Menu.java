import java.util.Scanner;
import java.util.ArrayList;
public class Menu
{
    //Create a simple menu system for this program
    static Scanner Keyboard = new Scanner(System.in);
    public static void main(String[] args)
    {
        int postOrder =1;
        String user = null;
        ArrayList<User> Users = new ArrayList<User>();
        ArrayList<Post>listPosts= new ArrayList<Post>();
        int option = 0;

        while(true)
        {
            System.out.println("Welcome to Micro Blog");
            System.out.println("Menu");
            System.out.println("1. Create a new user ");
            System.out.println("2. Become an existing user ");
            System.out.println("3. Create a post as the current user ");
            System.out.println("4. Print all posts ");
            System.out.println("5. Print all users ");
            System.out.println("6. Exit ");

            if (user != null&&!user.isEmpty())
            {
                System.out.println("You are currently user " + user + ".  What would you like to do? ");
            }
            System.out.print (" > ");

            while(!Keyboard.hasNextInt()||((option = Keyboard.nextInt())<1))
            {
                System.out.print("Please enter a number between 1 and 6.");
                Keyboard.nextLine();
            }
            Keyboard.nextLine();
            System.out.println(" ");

            first:

            if (option == 1)
            {
                System.out.println("Name: ");
                String newName = Keyboard.nextLine();
                System.out.println("Email Address: ");
                String newEmail = Keyboard.nextLine();              
                String newUserName ="";
                while(newUserName == "")
                {
                    String holdUserName = "";
                    System.out.println("Username: ");
                    holdUserName = Keyboard.nextLine();
                    boolean ckus = false;
                    for (User ckusid : Users)
                    {

                        if (ckusid.getUserName().equalsIgnoreCase(holdUserName))
                        {
                            ckus = true;
                        }
                    }
                    if (ckus) {
                        System.out.println("Username " + holdUserName + " already exists.  Choose a different username.");							
                    } else  {
                        holdUserName = holdUserName.replace(" ", "");
                        if (holdUserName.isEmpty()) {
                            System.out.println("Username cannot be empty.");
                        } else {
                            newUserName = holdUserName;
                        }

                    }
                }
                System.out.println("Avatar : ");
                String newAvatar = Keyboard.nextLine();
                Users.add(new User(newAvatar, newUserName, newName,newEmail));
                System.out.println(" ");
            }
            else if (option == 2) {            	

                if (Users == null || Users.isEmpty()) {
                    System.out.println("You must create a least one user.");            	    	
                } else {
                    System.out.println("Current User(s):  ");            
                    for(User list : Users)
                    {
                        System.out.println(list.getUserName() + " ");
                    }
                    System.out.print("Select the user: ");
                    String destUserName = Keyboard.nextLine();
                    Boolean userFound = false;
                    for(User list : Users)
                    {
                        if(list.getUserName().equalsIgnoreCase(destUserName))
                        {
                            user = list.getUserName();
                            userFound =true;
                        }
                    }

                    if(!userFound)
                    {
                        System.out.println("Not a valid user.  Please add the user or try again.");
                    } 
                    System.out.println(" ");
                }

            } else if (option ==3) {

                if (user == null)
                {

                    System.out.println("You must first '1. Create a User' and then '2. Become an Existing User' before you create a post.");
                    break first;
                }

                String userLastPost = null;
                int lastPostOrder= 0 ;
                String lastPost = "";
                String lastWebSite = "";

                for (Post currentPost : listPosts)
                    if (currentPost.getUserName().equalsIgnoreCase(user))
                    {
                        userLastPost = currentPost.getPostInfo();
                        lastPostOrder = currentPost.getPostOrder();
                        lastPost = currentPost.getPost();
                        lastWebSite = currentPost.getWebSite();
                    }
                if (userLastPost != null)
                {

                    System.out.println("Welcome back, " + user + ".  Here's your last post:  ");						
                    System.out.println("Post Order:  " + lastPostOrder);
                    System.out.println("Post Info:  " + lastPost);
                    System.out.println("Website Info:  " + lastWebSite);
                    System.out.println(" ");
                    System.out.println("What is on your mind?");
                } else {
                    System.out.println("You are currently user " + user + ". What is on your mind?");						
                }

                String createPost = Keyboard.nextLine();
                System.out.println("Web address: ");
                String createLink = Keyboard.nextLine();

                Post singlePost = new Post(postOrder, createPost, user, createLink);
                listPosts.add(singlePost);                   

                System.out.println("");
                postOrder++;
            }

            else if (option ==4) {
                if (listPosts !=null && !listPosts.isEmpty()) {
                    for (Post list : listPosts)
                    {

                        System.out.println("Post Order:  " + list.getPostOrder());
                        System.out.println("Post Info:  " + list.getPost());
                        System.out.println("Website Info:  " + list.getWebSite());
                        System.out.println(" ");
                    }
                } else {
                    System.out.println("You currently have no posts to print.");
                    System.out.println(" ");						
                }

            } else if (option == 5) {
                if (Users !=null && !Users.isEmpty()) {					
                    for (User list : Users)
                    {

                        System.out.println("User:  " + list.getUserName());
                        System.out.println("Name:  " + list.getName());
                        System.out.println("Email:  " + list.getEmail());
                        System.out.println("Avatar:  " + list.getAvatar());
                        System.out.println(" ");
                    }
                } else {
                    System.out.println("You currently have no users to print.");
                    System.out.println(" ");						
                }

            } else if (option == 6) {
                break;
            } else {
                System.out.println("Please enter a number between 1 and 6.");
            }
        }

    }
}



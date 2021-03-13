
package sistema;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

class Tweet{
    private int idTw;
    private String username;
    private String msg;
    private TreeSet <String> likes;
    
    public Tweet(int id, String username, String msg){
        this.idTw=id;
        this.username=username;
        this.msg=msg;
        this.likes = new TreeSet<>();
    }
    
    public void like(String username){
        likes.add(username);
    }
    
    public int getIdTw(){
        return idTw;
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getMsg(){
    
        return msg;
    
    }
    
    public String toString(){
        String saida="";
        saida+= idTw + " " + username + " " + msg + " " + likes;
        return saida;
    }
}

class User{
    private String username;
    private Map <String, User> followers;
    private Map <String, User> following;
    private Map <Integer, Tweet> timeline;
    private int unreadCount;
    
    public User(String username){
        this.following = new TreeMap<>();
        this.followers = new TreeMap<>();
        this.timeline = new TreeMap<>();
        this.username = username;
        this.unreadCount=0;
    }
  
    public void follow(User user){
        if(following.containsKey(user.getUsername())){
            throw new RuntimeException("Você já segue essa pessoa");
        }
        following.put(user.getUsername(), this);
        user.followers.put(this.getUsername(), this);
    }   
    
    public void unfollow(User user){
        if(!following.containsKey(user.getUsername())){
            throw new RuntimeException("Você não segue essa pessoa");
        }else{
            following.remove(user.getUsername());
            user.followers.remove(this.getUsername());
        }
    }
    
    public void sendTweet(Tweet tweet){
        for(User user : followers.values()){
            user.getUsername();
            user.timeline.put(tweet.getIdTw(), tweet);
            user.unreadCount+=1;
        }
    }
  
    public Tweet getTweet(int idTw){
        Tweet tweet=timeline.get(idTw);
        tweet.like(getUsername());
        return tweet;
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getTimeline(){
        String saida="";
        Map <Integer, Tweet> timeline2 = new TreeMap<>();
        for(int i=timeline.size() - this.unreadCount; i < timeline.size(); i++){
            timeline2.put(i, timeline.get(i));   
        }
        if(this.unreadCount==0){
            throw new RuntimeException("Não há novos tweets");
        }
        unreadCount = 0;
        return saida += "\n" + timeline2 + "\n";
    }
    
    public String toString(){
        String saida="";
            saida+= getUsername() + "\n" + "Seguidores: " + followers.keySet();
            saida+="\n" + "Seguidos: " + following.keySet();
        return saida;
    }   
}

public class Sistema {
    private Map <String, User> users;
    private Map <Integer, Tweet> tweets;
    private int nextTwId;
    
    public Sistema(){
        this.users = new TreeMap<>();
        this.tweets = new TreeMap<>();
    }
    
    public void sendTweet(String username, String msg){
        if(!users.containsKey(username)){
            throw new RuntimeException("Usuário não existe p/ fazer um tweet");
        }
        Tweet tweet = new Tweet(nextTwId, username, msg);
        tweets.put(nextTwId, tweet);
        User user = getUser(username);
        user.sendTweet(tweet);
        nextTwId=nextTwId+1;
    }
    
    /**
     *
     * @param username 
     */
    public void addUser(String username){
        User user = new User(username);
        if(!users.containsKey(username)){
            users.put(username, user);
        }
    }
   
    /**
     *
     * @param username
     * @return
     */
    public User getUser(String username){
        User user = users.get(username);
        if(user == null){
            throw new RuntimeException("Usuário não existe");
        }    
        return user;
    }
    
    public String toString(){
        String saida="";
        for(User user : users.values()){
            saida += user + "\n";
        }
        return saida;    
    }
    
    public static void main(String[] args) {
    
    Scanner scanner = new Scanner(System.in);
    Sistema sistema = new Sistema();
    while(true){
        String line = scanner.nextLine();
        System.out.println("$" + line);
        String ui[] = line.split(" ");
        try {
            if (ui[0].equals("finalizar"))
                break;
            else if (ui[0].equals("addUser")) {
                sistema.addUser(ui[1]);
            }else if (ui[0].equals("show")) {
                System.out.print(sistema);
            }else if (ui[0].equals("follow")) {
                User one = sistema.getUser(ui[1]);
                User two = sistema.getUser(ui[2]);
                one.follow(two);
            }else if (ui[0].equals("twittar")) {
                String username = ui[1];
                String msg = "";
                for(int i = 2; i < ui.length; i++)
                    msg += ui[i] + " ";
                sistema.sendTweet(username, msg);
            }else if (ui[0].equals("timeline")){
                User user = sistema.getUser(ui[1]);
                System.out.print(user.getTimeline());
            }else if (ui[0].equals("like")) {
                User user = sistema.getUser(ui[1]);
                Tweet tw = user.getTweet(Integer.parseInt(ui[2]));
                tw.like(ui[1]);
            }else if (ui[0].equals("unfollow")) {
                User user = sistema.getUser(ui[1]);
                User user2 = sistema.getUser(ui[2]);
                user.unfollow(user2);
            }else{
                System.out.println("fail: comando invalido");
            }
        }catch(RuntimeException rt){
            System.out.println(rt.getMessage());
        }
    }
    scanner.close();
  }
}
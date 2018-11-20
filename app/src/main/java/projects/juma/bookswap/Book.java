package projects.juma.bookswap;

/**
 * Created by TOSHIBA on 7/30/2016.
 */
public class Book {
    public String title, author, synopsis, coverUrl, owner, phoneNumber;

    public Book(){}
    public Book(String title, String author, String synopsis,String owner, String coverUrl,String phoneNumber){
        this.title = title;
        this.author = author;
        this.owner = owner;
        this.synopsis = synopsis;
        this.coverUrl = coverUrl;
        this.phoneNumber = phoneNumber;

    }
    public String getCoverUrl(){
        return coverUrl;
    }
    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author){
        this.author = author;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
    public String getOwner(){
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

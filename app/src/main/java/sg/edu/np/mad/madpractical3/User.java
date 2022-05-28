package sg.edu.np.mad.madpractical3;

public class User {
    String Name;
    String Description;
    Integer Id;
    Boolean Followed;

    public User(String name, String description, Integer id, Boolean followed){
        this.Name = name;
        this.Description = description;
        this.Id = id;
        this.Followed = followed;
    }
}

import java.nio.file.Path;
import java.util.Dictionary;

public class Contact {
    String names;
    String surnames;
    int number;
    int extension;
    Path profilePicture;
    State state;

    private Contact(String names, String surnames, int extension, int number, Path picture){
        this.names = names;
        this.surnames = surnames;
        this.number = number;
        this.extension = extension;
        this.profilePicture = picture;
        this.state = State.NORMAL;
    }
    private Contact(String names, String surnames, int extension, int number){
        this(names, surnames, extension, number, Path.of("./resources/default_pic"));
    }

    public static class Builder {
        private String names = "";
        private String surnames = "";
        private int number = 0;
        private int extension = 0;
        private String picture = "";

        public Builder setName(String names){
            this.names = names;
            return this;
        }
        public Builder setSurname(String surnames){
            this.surnames = surnames;
            return this;
        }public Builder setNumber(int phoneNumber){
            this.number = phoneNumber;
            return this;
        }public Builder setExtension(int extension){
            this.extension = extension;
            return this;
        }public Builder setProfilePicture(String picturePath){
            this.picture = picturePath;
            return this;
        }

        public Contact build(){
            return new Contact(this.names, this.surnames, this.extension, this.number, Path.of(this.picture));
        }
    }

    /**
     * Defines if the contact should be handled differently
     */
    public enum State {
        NORMAL,
        FAVORITE,
        BLOCKED
    }

}

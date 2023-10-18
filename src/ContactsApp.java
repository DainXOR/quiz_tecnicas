import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class ContactsApp {
    private static Hashtable<Integer, Contact> contactTable;

    public static void main(String[] args) throws IOException {

        System.out.println("Contacts\n");


        Scanner scanner = new Scanner(System.in);
        System.out.print("File: ");
        String fileName = scanner.nextLine();

        FileMan.setFile(Path.of(fileName));
        String data = FileMan.readFile();

        System.out.println("Contacts");
        System.out.println(data);
        List<String> contacts = formatData(data, ",", ";");
        showContacts(contacts);


    }

    public static List<String> formatData(String data, String separator, String end){
        List<String> formattedData = new ArrayList<>(List.of(data.split(end)));
        formattedData.remove(0);
        return formattedData;
    }

    public static void showContacts(List<String> data){
        for (String contact : data) {
            System.out.println(contact);
        }
    }
}
package interfejsUzytkownikaModul.repository.exceptions;
import interfejsUzytkownikaModul.repository.ShowMyMessage;

public class MyExceptions extends Exception{
    ShowMyMessage showMyMessage = new ShowMyMessage();

    public MyExceptions () {}

    public MyExceptions (String message, String title) {
       showMyMessage.warningMessage(message,title);
        //super (message);
    }


}

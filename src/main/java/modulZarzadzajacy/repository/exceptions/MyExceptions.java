package modulZarzadzajacy.repository.exceptions;
import modulZarzadzajacy.repository.ShowMyMessage;

public class MyExceptions extends Exception{
    ShowMyMessage showMyMessage = new ShowMyMessage();

    public MyExceptions () {}

    public MyExceptions (String message, String title) {
       showMyMessage.warningMessage(message,title);
        //super (message);
    }


}

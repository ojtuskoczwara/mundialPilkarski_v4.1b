package koczwara.mundialv1.MVC.Tools.exceptions;
import koczwara.mundialv1.MVC.Tools.ShowMyMessage;

public class MyExceptions extends Exception{
    ShowMyMessage showMyMessage = new ShowMyMessage();

    public MyExceptions () {}

    public MyExceptions (String message, String title) {
       showMyMessage.warningMessage(message,title);
        //super (message);
    }


}

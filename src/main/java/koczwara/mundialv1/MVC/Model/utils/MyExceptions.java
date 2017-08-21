package koczwara.mundialv1.MVC.Model.utils;
import koczwara.mundialv1.MVC.Model.utils.ShowMyMessage;

public class MyExceptions extends Exception{
    ShowMyMessage showMyMessage = new ShowMyMessage();

    public MyExceptions () {}

    public MyExceptions (String message, String title) {
       showMyMessage.warningMessage(message,title);
        //super (message);
    }


}

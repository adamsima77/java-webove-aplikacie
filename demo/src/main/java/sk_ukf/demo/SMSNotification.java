package sk_ukf.demo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("smsNotification")
public class SMSNotification implements NotificationService {

    private final MessageFormatter messageFormatter;
    public SMSNotification(@Qualifier("plain_text") MessageFormatter messageFormatter) {
        this.messageFormatter = messageFormatter;
    }
    @Override
    public String send(String message) {
        return "Posielam SMS notifikáciu: " + messageFormatter.format(message);
    }
}
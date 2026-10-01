package sk_ukf.demo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("pushNotification")
public class PushNotification implements NotificationService {

    private final MessageFormatter messageFormatter;
    public PushNotification(@Qualifier("upper_case") MessageFormatter messageFormatter) {
        this.messageFormatter = messageFormatter;
    }

    @Override
    public String send(String message) {
        return "Posielam push notifikáciu: " + messageFormatter.format(message);
    }
}
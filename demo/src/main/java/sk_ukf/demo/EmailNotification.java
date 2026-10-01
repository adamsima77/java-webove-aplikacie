package sk_ukf.demo;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Qualifier;

@Component("emailNotification")
public class EmailNotification implements NotificationService {

    private final MessageFormatter messageFormatter;

    public EmailNotification(@Qualifier("html") MessageFormatter messageFormatter) {
        this.messageFormatter = messageFormatter;
    }

    @Override
    public String send(String message) {
        String formattedMessage = messageFormatter.format(message);
        return "Posielam notifikáciu e-mailom: " + formattedMessage;
    }
}
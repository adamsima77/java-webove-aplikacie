package sk_ukf.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MojController {

    private NotificationService myService;
    private NotificationService smsNotification;
    private NotificationService pushNotification;

    @Autowired
    public MojController(@Qualifier("emailNotification") NotificationService myService,
                         @Qualifier("smsNotification") NotificationService smsNotification,
                         @Qualifier("pushNotification") NotificationService pushNotification) {
        this.myService = myService;
        this.smsNotification = smsNotification;
        this.pushNotification = pushNotification;
    }

    @GetMapping("/notify")
    public String sendNotification() {
        return myService.send("Používateľ sa prihlásil.");
    }

    @GetMapping("/send-push")
    public String sendPushNotification() {
        return pushNotification.send("Používateľ sa prihlásil.");
    }

    @GetMapping("/send-sms")
    public String sendSmsNotification() {
        return smsNotification.send("Používateľ sa prihlásil.");
    }
}
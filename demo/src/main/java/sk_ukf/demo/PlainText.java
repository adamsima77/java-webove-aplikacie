package sk_ukf.demo;

import org.springframework.stereotype.Component;

@Component("plain_text")
public class PlainText implements MessageFormatter {
    @Override
    public String format(String message) {
        return message;
    }
}
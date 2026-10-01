package sk_ukf.demo;

import org.springframework.stereotype.Component;

@Component("upper_case")
public class UpperCase implements MessageFormatter {
    @Override
    public String format(String message) {
        return message.toUpperCase();
    }
}
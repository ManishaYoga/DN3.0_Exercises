public class DecoratorPatternTest {
    public static void main(String[] args) {
        Notifier notifier = new EmailNotifier();
        Notifier smsNotifier = new SMSNotifierDecorator(notifier);
        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);

        String message = "Hello, this is a test notification!";

        // Send notification via Email only
        notifier.send(message);

        // Send notification via Email and SMS
        smsNotifier.send(message);

        // Send notification via Email, SMS, and Slack
        slackNotifier.send(message);
    }
}

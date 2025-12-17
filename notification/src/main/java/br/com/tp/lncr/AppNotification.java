package br.com.tp.lncr;

import br.com.tp.lncr.core.adapters.notification.NotificationControllerImpl;
import br.com.tp.lncr.core.adapters.notification.NotificationMapper;
import br.com.tp.lncr.core.interfaces.notification.NotificationController;
import br.com.tp.lncr.core.interfaces.notification.NotificationDatabase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "br.com.tp.lncr")
public class AppNotification {

    public static void main(String[] args) {
        SpringApplication.run(AppNotification.class, args);
    }

    @Bean
    public NotificationController notificationController(NotificationDatabase notificationDatabase) {
        return new NotificationControllerImpl(notificationDatabase);
    }

    @Bean
    public NotificationMapper notificationMapper() {
        return new NotificationMapper();
    }
}


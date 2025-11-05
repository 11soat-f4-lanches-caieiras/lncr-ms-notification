package br.com.tp.lncr.notification.apis;

import br.com.tp.lncr.commons.model.ResponseListModel;
import br.com.tp.lncr.commons.model.ResponseModel;
import br.com.tp.lncr.core.dtos.notification.NotificationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface NotificationRestController {

    ResponseEntity<ResponseModel<NotificationDTO>> createNotification(@RequestBody NotificationDTO notificationDTO);

    ResponseEntity<ResponseListModel<NotificationDTO>> getNotificationByType(@PathVariable(name = "notificationType") String notificationType);

    ResponseEntity<ResponseListModel<String>> getNotificationByType();
}

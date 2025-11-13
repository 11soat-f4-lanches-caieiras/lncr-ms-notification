package br.com.tp.lncr.notification.apis;

import br.com.tp.lncr.commons.model.ResponseListModel;
import br.com.tp.lncr.commons.model.ResponseModel;
import br.com.tp.lncr.commons.utils.ResponseEntityModelUtil;
import br.com.tp.lncr.notification.datasources.postgres.JpaNotificationRepositoryImpl;
import br.com.tp.lncr.core.dtos.notification.NotificationDTO;
import br.com.tp.lncr.core.interfaces.notification.NotificationController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationRestControllerImpl implements NotificationRestController {

    private final NotificationController notificationController;
    private final JpaNotificationRepositoryImpl jpaNotificationRepository;

    public NotificationRestControllerImpl(NotificationController notificationController,
                                          JpaNotificationRepositoryImpl jpaNotificationRepository) {
        this.notificationController = notificationController;
        this.jpaNotificationRepository = jpaNotificationRepository;
    }

    @Override
    @PostMapping
    public ResponseEntity<ResponseModel<NotificationDTO>> createNotification(NotificationDTO notificationDTO) {
        this.notificationController.createNotification(notificationDTO);
        return ResponseEntityModelUtil.accepted(null);
    }

    @Override
    @GetMapping("/{notificationType}")
    public ResponseEntity<ResponseListModel<NotificationDTO>> getNotificationByType(@PathVariable(name = "notificationType") String notificationType) {
        List<NotificationDTO> notificationList = this.notificationController.getNotificationByType(notificationType);
        return ResponseEntityModelUtil.listOK(notificationList);
    }

    @Override
    @GetMapping
    public ResponseEntity<ResponseListModel<String>> getNotificationByType() {
        List<String> notificationTypeList = this.notificationController.getNotificationTypeList();
        return ResponseEntityModelUtil.listOK(notificationTypeList);
    }
}

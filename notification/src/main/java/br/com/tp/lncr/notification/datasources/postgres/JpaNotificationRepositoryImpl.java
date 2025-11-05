package br.com.tp.lncr.notification.datasources.postgres;

import br.com.tp.lncr.core.dtos.notification.NotificationDTO;
import br.com.tp.lncr.core.interfaces.notification.NotificationDatabase;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JpaNotificationRepositoryImpl implements NotificationDatabase {

    private final JpaNotificationsRepository jpaNotificationsRepository;
    private final JpaNotificationMapper jpaNotificationMapper;

    public JpaNotificationRepositoryImpl(JpaNotificationsRepository jpaNotificationsRepository,
                                         JpaNotificationMapper jpaNotificationMapper) {
        this.jpaNotificationsRepository = jpaNotificationsRepository;
        this.jpaNotificationMapper = jpaNotificationMapper;
    }

    @Override
    public void save(NotificationDTO notificationDTO) {
        jpaNotificationsRepository.save(jpaNotificationMapper.notificationDtoToJpa(notificationDTO));
    }

    @Override
    public List<String> findNotificationTypeList() {

        return this.jpaNotificationsRepository.findNotificationTypeList();
    }

    @Override
    public List<NotificationDTO> findByNotificationType(String artefactType) {
        List<JpaNotificationEntity> list = jpaNotificationsRepository.findByNotificationType(artefactType).
                stream().toList();
        return list.stream().map(jpaNotificationMapper::jpaNotificationToDTO).toList();
    }
}

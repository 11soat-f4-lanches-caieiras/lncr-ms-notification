package br.com.tp.lncr.notification.bdd;

import br.com.tp.lncr.core.exceptions.NotificationException;
import br.com.tp.lncr.core.model.ResponseMetadata;
import br.com.tp.lncr.notification.handlers.NotificationInboundHandler;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

public class NotificationInboundHandlerSteps {

    private NotificationInboundHandler handler;
    private NotificationException exception;
    private ResponseEntity<Object> response;

    @Before
    public void setUp() {
        handler = new NotificationInboundHandler();
    }

    @Dado("que ocorreu uma NotificationException com mensagem {string} e código {int}")
    public void queOcorreuUmaNotificationExceptionComMensagemECodigo(String mensagem, Integer codigo) {
        exception = new NotificationException(mensagem, codigo);
        assertNotNull(exception);
        assertEquals(mensagem, exception.getMessage());
        assertEquals(codigo, exception.getCode());
    }

    @Quando("o handler processar a exceção")
    public void oHandlerProcessarAExcecao() {
        response = handler.handlerNotificationException(exception);
        assertNotNull(response);
    }

    @Então("deve retornar uma resposta HTTP com status {int}")
    public void deveRetornarUmaRespostaHTTPComStatus(Integer expectedStatus) {
        assertNotNull(response);
        assertEquals(expectedStatus, response.getStatusCode().value());
    }

    @Então("a mensagem de erro deve ser {string}")
    public void aMensagemDeErroDeveSer(String expectedMessage) {
        assertNotNull(response);
        assertNotNull(response.getBody());
        ResponseMetadata metadata = assertInstanceOf(ResponseMetadata.class, response.getBody(), "Response body deve ser do tipo ResponseMetadata");
        assertNotNull(metadata.getMessage(), "Mensagem não deve ser nula");
        assertEquals(expectedMessage, metadata.getMessage(), "A mensagem deve corresponder ao esperado");
    }
}


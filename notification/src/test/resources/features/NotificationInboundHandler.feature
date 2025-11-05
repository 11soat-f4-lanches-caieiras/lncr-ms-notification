#language: pt

Funcionalidade: Handler de Exceções de Notificação
  Como sistema de tratamento de exceções
  Eu quero capturar e tratar exceções de notificação
  Para que erros sejam retornados adequadamente aos clientes da API

  Cenário: Tratar NotificationException com código 404
    Dado que ocorreu uma NotificationException com mensagem "Notificação não encontrada" e código 404
    Quando o handler processar a exceção
    Então deve retornar uma resposta HTTP com status 404
    E a mensagem de erro deve ser "Notificação não encontrada"

  Cenário: Tratar NotificationException com código 400
    Dado que ocorreu uma NotificationException com mensagem "Dados inválidos" e código 400
    Quando o handler processar a exceção
    Então deve retornar uma resposta HTTP com status 400
    E a mensagem de erro deve ser "Dados inválidos"

  Cenário: Tratar NotificationException com código 500
    Dado que ocorreu uma NotificationException com mensagem "Erro interno ao processar notificação" e código 500
    Quando o handler processar a exceção
    Então deve retornar uma resposta HTTP com status 500
    E a mensagem de erro deve ser "Erro interno ao processar notificação"


# lncr-ms-notification

## Descrição

Microserviço responsável pelo gerenciamento de **Notificações** no sistema Lanches Caieiras. Este serviço implementa as funcionalidades relacionadas ao envio e controle de notificações para clientes e sistemas internos, incluindo notificações de status de pedidos, confirmações de pagamento, e atualizações de preparo.

## Funcionalidades

### Endpoints Disponíveis (`/notifications`)

| Método | Path | Descrição |
|--------|------|-----------|
| `POST` | `/notifications` | Criar nova notificação |
| `GET` | `/notifications/type/{notificationType}` | Buscar notificações por tipo |
| `GET` | `/notifications/type` | Listar todos os tipos de notificação |

## Tecnologias Utilizadas

- Java 21
- Spring Boot 3.4.5
- PostgreSQL
- Maven
- Cucumber (BDD)
- JUnit 5

## Sonar Quality Gate

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=11soat-f4-lanches-caieiras_lncr-ms-notification&metric=alert_status&token=a6aedd53393cd440f5f564c42dd92d1242df28f4)](https://sonarcloud.io/summary/new_code?id=11soat-f4-lanches-caieiras_lncr-ms-notification)

Acesse o dashboard completo: [SonarCloud - lncr-ms-notification](https://sonarcloud.io/project/overview?id=11soat-f4-lanches-caieiras_lncr-ms-notification)

## Dependências

- **lncr-core** (versão 3.0) - Biblioteca com regras de negócio e entidades de domínio
- **lncr-commons** (versão 1.0) - Biblioteca comum compartilhada com configurações e utilitários

## Guia de Download e Execução

### Pré-requisitos

- **Java 21** instalado
- **Maven 3.8+** instalado
- **PostgreSQL 13+** em execução
- **Git** instalado

### Configuração do Banco de Dados

```sql
-- Criar database
CREATE DATABASE lncr_notification;

-- Criar usuário (opcional)
CREATE USER lncr_user WITH PASSWORD 'your_password';
GRANT ALL PRIVILEGES ON DATABASE lncr_notification TO lncr_user;
```

### Variáveis de Ambiente

Crie um arquivo `.env` ou configure as seguintes variáveis de ambiente:

```bash
# Configuração do Servidor
SERVER_PORT=8080

# PostgreSQL
POSTGRES_URL=jdbc:postgresql://localhost:5432/lncr_notification
POSTGRES_USER=lncr_user
POSTGRES_PASSWORD=your_password
```

### Download e Instalação

```bash
# Clone o repositório
git clone https://github.com/11soat-f4-lanches-caieiras/lncr-ms-notification.git

# Entre no diretório do projeto
cd lncr-ms-notification/notification

# Configure o GitHub Packages (necessário para dependências lncr-core e lncr-commons)
# Crie o arquivo ~/.m2/settings.xml com suas credenciais do GitHub

# Compile o projeto
mvn clean install

# Execute a aplicação
mvn spring-boot:run
```

### Executando com Docker

```bash
# Build da imagem
docker build -t lncr-ms-notification:latest .

# Execute o container
docker run -p 8080:8080 \
  -e POSTGRES_URL=jdbc:postgresql://host.docker.internal:5432/lncr_notification \
  -e POSTGRES_USER=lncr_user \
  -e POSTGRES_PASSWORD=your_password \
  lncr-ms-notification:latest
```

### Executando os Testes

```bash
# Executar todos os testes
mvn test

# Executar testes com cobertura
mvn test -Pcoverage

# Executar apenas testes BDD
mvn test -Dcucumber.filter.tags="@bdd"
```

### Verificando a Aplicação

Após iniciar a aplicação, acesse:

- **Health Check**: http://localhost:8080/actuator/health
- **API Base**: http://localhost:8080/notifications

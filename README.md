# 🌿 SmartNature API

### 📡 Sistema de Monitoramento Ambiental com Sensores IoT

---

## 👨‍💻 Integrantes
- **Leonardo Bianchi** – RM558576  
- **Angello Turano da Costa** – RM556511  
- **Cauã Sanches de Santana** – RM558317  

---

## 📘 Sobre o Projeto

O **SmartNature** é uma API RESTful desenvolvida em **Java com Spring Boot** que visa detectar e reagir automaticamente a potenciais focos de queimadas através da integração com sensores IoT.

### 🔥 Funcionalidade Principal:
Sempre que sensores registrarem condições ambientais críticas — como temperatura elevada, umidade baixa ou presença de fumaça — a API:
- Gera automaticamente um alerta.
- Armazena os dados no banco de dados.
- Notifica os usuários próximos.
- Registra tudo em logs de auditoria.
- Garante segurança com autenticação **JWT**.

---

## 🧱 Tecnologias e Bibliotecas Utilizadas

| Camada         | Tecnologia / Biblioteca                                                                 |
|----------------|------------------------------------------------------------------------------------------|
| Linguagem      | Java 17                                                                                 |
| Framework      | Spring Boot 3.1.5                                                                        |
| Banco de Dados | Oracle (produção) / H2 (testes locais)                                                  |
| ORM            | Spring Data JPA                                                                          |
| Segurança      | Spring Security + JWT (`io.jsonwebtoken`)                                               |
| Validação      | Bean Validation (`jakarta.validation`)                                                  |
| Documentação   | Swagger UI / OpenAPI (`springdoc-openapi`)                                              |
| Testes         | JUnit + Spring Boot Test                                                                |
| Build Tool     | Maven (`pom.xml`) ou Gradle (`build.gradle`)                                            |

---

## 🚀 Como Executar o Projeto Localmente

### 1. Pré-requisitos
- Java 17 ou superior
- Maven ou Gradle
- IDE (IntelliJ, Eclipse, VS Code)
- Oracle DB (opcional, usa H2 por padrão)

### 2. Clonar o Repositório
```bash
git clone https://github.com/leonardobianchii/SmartNature_APIRest.git
```

### 3. Executar com H2 (modo dev)
```bash
./mvnw spring-boot:run
```
ou com Gradle:
```bash
./gradlew bootRun
```

> A aplicação estará disponível em: `http://localhost:8080`

---

## 🧪 Testar Endpoints (Swagger + JWT)

### 🔐 Autenticação:
- Enviar `POST` para `/auth/login` com:
```json
{
  "usuario": "admin",
  "senha": "123"
}
```
- Copie o token JWT gerado
- No Swagger UI, clique em `Authorize` e cole o token com prefixo `Bearer`

### 📘 Acessar Swagger:
[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

---

## 📂 Estrutura de Pastas

```bash
src/
├── config/            # Configurações do Swagger e segurança
├── controller/        # Endpoints REST
├── dto/               # Data Transfer Objects com validações
├── exception/         # Tratamento global de erros
├── mapper/            # Conversão DTO ↔ Model
├── model/             # Entidades JPA (banco de dados)
├── repository/        # Acesso ao banco (Spring Data JPA)
├── security/          # Filtros e JWT
├── service/           # Lógica de negócio
└── SmartnatureApplication.java
```

---

## 📦 Entregáveis Atendidos

✔ API REST com boas práticas em arquitetura  
✔ Mapeamento de entidades relacionais com JPA  
✔ Persistência com Spring Data e Oracle  
✔ Bean Validation em DTOs  
✔ Paginação, ordenação e filtros nos endpoints  
✔ Swagger com documentação detalhada e botão "Authorize"  
✔ Autenticação com JWT funcionando  
✔ Suporte a testes locais com banco H2  

---

## 📄 Licença
Este projeto está licenciado sob a licença **Apache 2.0**.  
Consulte o arquivo [LICENSE](https://www.apache.org/licenses/LICENSE-2.0.html) para mais informações.

---

## 📬 Contato
Dúvidas ou sugestões?  
Entre em contato com a equipe pelo e-mail: **rm558576@fiap.com.br**

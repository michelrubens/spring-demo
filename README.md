# Spring Demo Project

Este projeto é uma demonstração simples e prática das capacidades do ecossistema **Spring Boot**, ilustrando como configurar serviços, controladores REST e injeção de dependências de forma eficiente.

## O que está sendo feito

O projeto implementa uma API REST básica que:

1.  **Expõe Endpoints**: Através do `HelloWorldController`, permitindo requisições GET e POST.
2.  **Lógica de Negócio**: Utiliza a camada de serviço (`HelloWorldService`) para processar mensagens de saudação.
3.  **Configuração de Beans**: Demonstra o uso de classes de configuração para definir beans gerenciados pelo Spring.
4.  **Modelo de Dados**: Define uma entidade `User` para manipulação de dados em requisições POST.

## Anotações do Spring Utilizadas

O Spring utiliza anotações para reduzir a configuração XML e gerenciar o ciclo de vida dos componentes:

- **Core & Configuração**:
  - `@SpringBootApplication`: Marca a classe principal que inicia a aplicação.
  - `@Configuration`: Indica que a classe contém métodos de definição de beans.
  - `@Bean`: Define um bean gerenciado pelo Spring IoC container.
  - `@Service`: Especialização de `@Component` para a camada de serviço/negócio.
  - `@Autowired`: Realiza a injeção automática de dependências (ex: injetando o serviço no controller).

- **Web (REST)**:
  - `@RestController`: Combina `@Controller` e `@ResponseBody`, facilitando a criação de APIs REST.
  - `@RequestMapping`: Define o caminho base (path) para o controller.
  - `@GetMapping` / `@PostMapping`: Mapeia requisições HTTP específicas para métodos.
  - `@PathVariable`: Vincula variáveis da URL aos parâmetros do método.
  - `@RequestParam`: Extrai parâmetros de consulta (query params) da URL.
  - `@RequestBody`: Indica que o parâmetro do método deve ser vinculado ao corpo da requisição HTTP (usado para o objeto `User`).

## Anotações do Lombok Utilizadas

Para manter o código limpo e evitar código repetitivo (boilerplate), foram utilizadas as seguintes anotações do **Lombok** na classe `User`:

- `@Getter`: Gera automaticamente os métodos _getters_ para todos os campos.
- `@Setter`: Gera automaticamente os métodos _setters_ para todos os campos.
- `@AllArgsConstructor`: Gera um construtor que aceita todos os campos da classe como argumentos.

## Exemplos de Uso

### 1. Testar GET

```bash
curl -X GET http://localhost:8080/hello-world
```

### 2. Testar POST (com Body)

Para testar o endpoint POST, você deve enviar um JSON no corpo da requisição condizente com a classe `User`:

```bash
curl -X POST http://localhost:8080/hello-world/123?filter=ativo \
     -H "Content-Type: application/json" \
     -d '{"name": "Michel Rubens"}'
```

**Resposta esperada:**
`Hello world Michel Rubens 123 ativo`

## Como Executar

Como este é um projeto Spring Boot padrão, você pode executá-lo usando:

```bash
./mvnw spring-boot:run
```

# API de Entregas — Testes Automatizados com Cucumber + REST Assured

Projeto de estudo (FIAP) de **testes automatizados de API** em Java, usando **BDD** com Cucumber,
REST Assured e Gson sobre uma API REST Spring Boot.

---

## Índice

- [Como rodar](#como-rodar)
- [1. O quadro geral](#1-o-quadro-geral-existem-dois-projetos-dentro-do-projeto)
- [2. BDD e Cucumber](#2-bdd-e-cucumber-por-que-existe-um-arquivo-em-português)
- [3. As 4 camadas e por que elas existem](#3-as-4-camadas-e-por-que-elas-existem)
- [4. Arquivo por arquivo](#4-arquivo-por-arquivo)
- [5. O fluxo completo](#5-o-fluxo-completo-do-início-ao-fim)
- [6. As dependências do pom.xml](#6-as-dependências-do-pomxml-e-o-papel-de-cada-uma)
- [7. Limitações e próximos passos](#7-limitações-deste-setup-e-próximos-passos)

---

## Como rodar

Os testes exigem **dois passos, nesta ordem**, porque eles fazem requisições HTTP reais
contra a API rodando em `http://localhost:8080`.

### 1. Suba a API

**Opção A — direto pelo Maven:**

```bash
./mvnw spring-boot:run
```

**Opção B — via Docker:**

```bash
# construir a imagem
docker build -t api-entregas-image .

# listar as imagens
docker images

# executar o container na porta 8080
docker run -d --name my-app-entregas -p 8080:8080 api-entregas-image

# verificar se está rodando
docker ps
```

Confirme que a API respondeu:

```bash
curl http://localhost:8080/entregas/health
```

| Recurso | URL |
| --- | --- |
| Health check | http://localhost:8080/entregas/health |
| Documentação (Swagger) | http://localhost:8080/swagger-ui/index.html |
| Console do banco H2 | http://localhost:8080/h2 |

### 2. Rode os testes

```bash
./mvnw test
```

> Se a API não estiver no ar, **todos os testes falham** com `Connection refused`.
> Isso não é um bug do código — é a natureza de um teste de API caixa-preta.

---

## 1. O quadro geral: existem dois projetos dentro do projeto

```
src/main/java/br/com/fiap/entregas/   ← a API (o "sistema sob teste")
src/test/java/                        ← os testes automatizados
```

O ponto mais importante: **os testes não "chamam o código Java da API"**. Eles fazem
requisições HTTP de verdade para `http://localhost:8080`, como se fossem o Postman/Insomnia
automatizado.

Isso se chama **teste de API / teste caixa-preta (black box)**. Os testes não sabem nada
sobre `EntregaController`, `EntregaService` ou banco de dados — só sabem:
*"mando esse JSON nesse endereço, espero esse status code de volta"*.

---

## 2. BDD e Cucumber: por que existe um arquivo em português?

O projeto usa **BDD (Behavior Driven Development)**. A ideia: o teste é descrito em linguagem
natural, para que uma pessoa não-técnica (analista de negócio, PO, cliente) consiga ler e
validar se o comportamento esperado está correto.

O **Cucumber** é a ferramenta que lê esse texto em português e o conecta a métodos Java.
A linguagem desse texto se chama **Gherkin**.

---

## 3. As 4 camadas e por que elas existem

Cada pasta tem uma responsabilidade única:

```
src/test/resources/features/CadastroEntregas.feature   ← O QUE testar (português, Gherkin)
                    ↓ Cucumber faz o "match" por texto
src/test/java/steps/CadastroEntregasSteps.java         ← A PONTE texto → Java
                    ↓ chama
src/test/java/services/CadastoEntregasService.java     ← COMO falar HTTP com a API
                    ↓ usa
src/test/java/model/EntregaModel.java                  ← O FORMATO dos dados (vira JSON)

src/test/java/runner/RunCucumberTest.java              ← O GATILHO que roda tudo
```

O motivo dessa separação (padrão chamado **Service Object**) é o mesmo de qualquer separação
em camadas: quando a URL do endpoint mudar, você mexe em **um** arquivo. Quando o texto do
cenário mudar, você mexe em outro. Quando tiver 50 cenários de entrega, todos reaproveitam o
mesmo `CadastoEntregasService`.

---

## 4. Arquivo por arquivo

### 4.1 `CadastroEntregas.feature` — a especificação

```gherkin
#language: pt
```

Diz ao Cucumber: *"as palavras-chave deste arquivo estão em português"*. Sem essa linha ele
espera `Given/When/Then` e não entende `Dado/Quando/Entao`. Precisa ser a **primeira linha**.

```gherkin
Funcionalidade: Cadastro de entregas
  Como usuario da api
  Quero cadastrar uma nova entrega
  Para que o registro seja salvo corretamente
```

`Funcionalidade` agrupa cenários relacionados. As três linhas seguintes são **puro comentário**
— o Cucumber as ignora completamente. É o formato clássico de user story
(*Como... Quero... Para que...*), que existe só para documentar a intenção de negócio.

```gherkin
  Cenario: Cadastro de entregas bem-sucedido
```

Um `Cenario` = um teste. Cada `Cenario:` do arquivo é executado separadamente.

Os três passos seguem a estrutura **Dado / Quando / Então** (Given/When/Then) — o padrão
universal de teste: **preparar → agir → verificar** (também chamado *Arrange, Act, Assert*).

```gherkin
    Dado que eu tenha os seguintes dados de entrega:
      | campo          | valor        |
      | numeroPedido   | 1            |
      | nomeEntregador | Ana Silva    |
      | statusEntrega  | EM_SEPARACAO |
      | dataEntrega    | 2024-08-22   |
```

**Dado** = pré-condição, o estado inicial. A tabela com `|` é uma **Data Table** do Gherkin.
Repare que ela tem cabeçalho `campo`/`valor` — isso importa para entender o código Java depois:
o Cucumber transforma essa tabela numa `List<Map<String,String>>` de 4 elementos:

```java
[ {campo:"numeroPedido",   valor:"1"},
  {campo:"nomeEntregador", valor:"Ana Silva"},
  {campo:"statusEntrega",  valor:"EM_SEPARACAO"},
  {campo:"dataEntrega",    valor:"2024-08-22"} ]
```

Os valores não foram escolhidos ao acaso: `EM_SEPARACAO` é um dos valores do enum
`StatusEntrega` da API (os outros são `EM_TRANSPORTE` e `ENTREGUE`), e `2024-08-22` está no
formato ISO que o Spring converte automaticamente para `LocalDate`.

```gherkin
    Quando eu enviar a requisicao para o endpoint "/entregas" de cadastro de entregas
```

**Quando** = a ação que está sendo testada. O `"/entregas"` entre aspas não é decoração:
é um **parâmetro** que será extraído do texto e passado para o método Java.

```gherkin
    Entao status code da resposta deve ser 201
```

**Então** = a asserção, a verificação. `201 Created` é o status HTTP que o
`EntregaController.criar()` retorna quando o cadastro dá certo
(`ResponseEntity.status(HttpStatus.CREATED)`). Se a API devolver 400 (validação) ou 500,
o teste falha aqui.

### 4.2 `CadastroEntregasSteps.java` — a ponte

```java
public class CadastroEntregasSteps {
    CadastoEntregasService cadastoEntregasService = new CadastoEntregasService();
```

Um campo de instância. Detalhe crucial do Cucumber: ele cria **uma instância nova desta classe
a cada cenário**. Por isso o `service` (e o `EntregaModel` dentro dele) começa limpo em cada
teste, sem sujeira do cenário anterior.

```java
    @Dado("que eu tenha os seguintes dados de entrega:")
    public void queEuTenhaOsSeguintesDadosDeEntrega(List<Map<String, String>> rows) {
```

**Aqui está a mágica do Cucumber.** A anotação `@Dado` contém exatamente o mesmo texto do
`.feature` (sem a palavra `Dado`). É por esse texto — string pura — que o Cucumber liga o passo
em português ao método Java. Se você mudar uma vírgula no `.feature` e não mudar aqui, o
Cucumber reporta *"Undefined step"*.

O nome do método (`queEuTenhaOsSeguintes...`) é irrelevante para o Cucumber — é só uma convenção
gerada automaticamente pela IDE. O que vale é a anotação.

O parâmetro `List<Map<String,String>>` é o tipo que o Cucumber usa para entregar a Data Table.

```java
        for (Map<String, String> columns : rows) {
            cadastoEntregasService.setFieldsDelivery(columns.get("campo"), columns.get("valor"));
        }
```

Percorre as 4 linhas e, para cada uma, manda o service preencher aquele campo.
Ex.: primeira volta → `setFieldsDelivery("numeroPedido", "1")`.

```java
    @Quando("eu enviar a requisicao para o endpoint {string} de cadastro de entregas")
    public void euEnviarARequisicaoParaOEndpointDeCadastroDeEntregas(String endpoint) {
        cadastoEntregasService.createDelivery(endpoint);
    }
```

O `{string}` é um **Cucumber Expression**: um curinga que captura o que estiver entre aspas no
`.feature` e entrega como parâmetro do método. Por isso `endpoint` chega valendo `/entregas`.

Isso torna o step **reutilizável**: outro cenário poderia escrever
`...para o endpoint "/entregas/v2"...` e o mesmo método Java atenderia.

```java
    @Entao("status code da resposta deve ser {int}")
    public void statusCodeDaRespostaDeveSer(int statusCode) {
        Assert.assertEquals(statusCode, cadastoEntregasService.response.statusCode());
    }
```

`{int}` captura o `201` já convertido para inteiro.

`assertEquals` é **a asserção** — o coração de qualquer teste. A convenção do JUnit é
`assertEquals(esperado, obtido)`, e aqui está na ordem certa: `201` é o esperado (veio do
`.feature`), `response.statusCode()` é o que a API realmente devolveu. Se forem diferentes,
lança exceção e o teste fica vermelho.

> Note que este step **não** menciona "entrega" — ele serve para qualquer cenário de qualquer
> feature que precise conferir status code. Reuso.

### 4.3 `CadastoEntregasService.java` — a camada HTTP

```java
    EntregaModel entregaModel = new EntregaModel();
    Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    public Response response;
    String baseUrl = "http://localhost:8080";
```

- `entregaModel` — o "carrinho" que vai sendo preenchido campo a campo pelos steps.
- `gson` — o conversor **objeto Java → JSON**. O `excludeFieldsWithoutExposeAnnotation()` liga
  um modo restritivo: **só entram no JSON os campos marcados com `@Expose`**.
- `response` — é `public` de propósito: o step `@Entao` precisa lê-lo de fora para fazer a
  asserção. Guardar a resposta como estado da classe é o que permite separar "agir" (`@Quando`)
  de "verificar" (`@Entao`) em métodos diferentes.
- `baseUrl` — está fixo em localhost porque é um projeto de estudo. Em projeto real isso viria
  de um arquivo de configuração ou variável de ambiente, para poder apontar para
  dev/homologação/produção.

```java
    public void setFieldsDelivery(String field, String value) {
        switch (field) {
            case "numeroPedido" -> entregaModel.setNumeroPedido(Integer.parseInt(value));
            case "nomeEntregador" -> entregaModel.setNomeEntregador(value);
            ...
            default -> throw new IllegalStateException("Unexpected field: " + field);
        }
    }
```

Traduz a dupla texto→texto vinda da tabela para o setter tipado correto. Repare no
`Integer.parseInt(value)`: tudo que vem do Gherkin é `String`, então `"1"` precisa virar `int`.

O `default` que lança exceção é uma boa prática: se alguém escrever `numeroPedidoo` na tabela do
`.feature`, o teste **estoura com mensagem clara** em vez de silenciosamente mandar um JSON
incompleto e deixar você meia hora se perguntando por que deu 400.

```java
    public void createDelivery(String endpoint) {
        String url = baseUrl + endpoint;
        String body = gson.toJson(entregaModel);
        response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(body)
                .when()
                .post(url)
                .then()
                .extract()
                .response();
    }
```

Isso é o **REST Assured**, uma biblioteca para testar APIs REST. A sintaxe encadeada
`given().when().then()` foi desenhada de propósito para imitar o Gherkin:

| REST Assured | Significado |
| --- | --- |
| `given()` | monte a requisição... |
| `.contentType(JSON)` | header `Content-Type: application/json` — "estou **enviando** JSON" |
| `.accept(JSON)` | header `Accept: application/json` — "quero **receber** JSON" |
| `.body(body)` | o corpo da requisição (nosso JSON) |
| `.when().post(url)` | ...e então **dispare** um POST |
| `.then()` | a partir daqui, trabalhe com a resposta |
| `.extract().response()` | me devolva o objeto `Response` inteiro em vez de validar aqui |

O `.extract().response()` é uma escolha de design importante: o REST Assured permitiria validar
tudo aqui mesmo (`.then().statusCode(201)`). Mas então a asserção estaria escondida no service,
e não no step `@Entao`. Extraindo a resposta, a **verificação fica onde o Gherkin diz que ela
deve estar** — mantendo a coerência entre o texto em português e o código.

### 4.4 `EntregaModel.java` — o formato do JSON

```java
@Data
public class EntregaModel {
    @Expose(serialize = false)
    private int numeroEntrega;
    @Expose private int numeroPedido;
    @Expose private String nomeEntregador;
    @Expose private String statusEntrega;
    @Expose private String dataEntrega;
}
```

- `@Data` é do **Lombok**: gera automaticamente getters, setters, `toString`, `equals`/`hashCode`
  em tempo de compilação. É por isso que `setNumeroPedido()` existe mesmo sem estar escrito no
  arquivo.
- `@Expose` (Gson) + `excludeFieldsWithoutExposeAnnotation()` no service = **controle fino sobre
  o JSON gerado**.
- `@Expose(serialize = false)` no `numeroEntrega` é o detalhe mais interessante do arquivo:
  esse campo é o **ID gerado pelo banco** (`@GeneratedValue` na entidade `Entrega`). Ao criar uma
  entrega, quem define o ID é o servidor, não o cliente — então ele fica de fora do JSON enviado.
  Mas o campo continua existindo na classe para **receber** o valor de volta na resposta, ou ser
  usado num futuro cenário de GET/PUT.

O JSON que efetivamente sai é:

```json
{"numeroPedido":1,"nomeEntregador":"Ana Silva","statusEntrega":"EM_SEPARACAO","dataEntrega":"2024-08-22"}
```

Compare com o `EntregaDto` da API: os nomes batem exatamente. E repare como os tipos "afrouxam"
no teste — `statusEntrega` é `String` aqui e `enum StatusEntrega` lá; `dataEntrega` é `String`
aqui e `LocalDate` lá. **Isso é proposital.** O teste é caixa-preta: ele manda texto, como um
cliente HTTP real faria, e é responsabilidade do Spring converter. Se você usasse os tipos da
API no teste, estaria assumindo que a conversão funciona em vez de testá-la.

### 4.5 `RunCucumberTest.java` — o gatilho

Um arquivo sem nenhum código no corpo, só anotações. Ele existe porque o Cucumber, sozinho, não
é executado pelo Maven — quem executa testes é o JUnit. Esta classe é o adaptador entre os dois.

```java
@Suite                                    // JUnit 5: "esta classe é uma suíte de testes"
@IncludeEngines("cucumber")               // use o motor do Cucumber, não o do JUnit puro
@SelectClasspathResource("features")      // procure os .feature em src/test/resources/features
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "steps")   // as anotações @Dado/@Quando/@Entao estão no pacote "steps"
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty") // formato do relatório no console
public class RunCucumberTest { }
```

O **"glue"** é o conceito-chave: é onde o Cucumber procura os métodos anotados. Se você criar
`steps/ConsultaEntregasSteps.java`, ele acha sozinho (mesmo pacote). Se criar
`outropacote/XSteps.java`, o Cucumber não acha e reporta "Undefined step".

E o nome da classe termina em **`Test`** de propósito: é a convenção que o plugin Surefire do
Maven usa para descobrir o que executar com `mvn test`.

---

## 5. O fluxo completo, do início ao fim

```
mvn test
   │
   ├─→ Surefire acha RunCucumberTest (nome termina em "Test")
   │      │
   │      └─→ Motor Cucumber lê src/test/resources/features/*.feature
   │             │
   │             ├─ Cenário "Cadastro de entregas bem-sucedido"
   │             │  cria UMA instância de CadastroEntregasSteps
   │             │
   │             ├─ Passo 1: casa o texto com @Dado → 4x setFieldsDelivery()
   │             │           EntregaModel fica preenchido
   │             │
   │             ├─ Passo 2: casa com @Quando, captura "/entregas"
   │             │           Gson: objeto → JSON
   │             │           REST Assured: POST http://localhost:8080/entregas
   │             │                  │
   │             │                  ▼  (rede)
   │             │           ┌──────────────────────────────┐
   │             │           │ API Spring Boot rodando      │
   │             │           │ EntregaController.criar()    │
   │             │           │  → @Valid valida o DTO       │
   │             │           │  → EntregaService salva      │
   │             │           │  → H2 grava a linha          │
   │             │           │  → devolve 201 + JSON        │
   │             │           └──────────────────────────────┘
   │             │                  │
   │             │           guarda em this.response
   │             │
   │             └─ Passo 3: casa com @Entao, captura 201
   │                         assertEquals(201, response.statusCode())
   │                         ✅ verde  |  ❌ vermelho
```

---

## 6. As dependências do `pom.xml` e o papel de cada uma

Todas com `<scope>test</scope>` — ou seja, existem só para os testes e **não vão para o `.jar`
de produção**. O app entregue não carrega o peso do Cucumber.

| Dependência | Para quê |
| --- | --- |
| `cucumber-java` | as anotações `@Dado`, `@Quando`, `@Entao` |
| `cucumber-junit-platform-engine` | o "motor" que permite o JUnit 5 rodar Cucumber |
| `junit-platform-suite` | as anotações `@Suite`, `@IncludeEngines` do runner |
| `junit` (JUnit **4**) | só por causa do `org.junit.Assert` usado no step |
| `rest-assured` | o cliente HTTP fluente |
| `gson` | conversão objeto ↔ JSON |
| `spring-boot-starter-test` | vem do Spring, traz JUnit 5, Mockito, AssertJ |

O `cucumber-bom` no `<dependencyManagement>` é um **Bill of Materials**: um "catálogo" que
garante que todos os artefatos do Cucumber usem a mesma versão (`7.18.1`) sem repetir
`<version>` em cada um.

> **Detalhe que vale saber:** o projeto mistura JUnit 4 e JUnit 5. O runner usa JUnit 5
> (`@Suite`), mas o step importa `org.junit.Assert`, que é JUnit 4 — por isso foi preciso
> adicionar a dependência `junit` separada. Funciona, mas o idiomático hoje seria
> `import static org.junit.jupiter.api.Assertions.assertEquals;` (JUnit 5), que já vem no
> `spring-boot-starter-test` e dispensaria essa dependência extra.

---

## 7. Limitações deste setup e próximos passos

Simplificações aceitáveis num projeto de estudo, mas que vale conhecer:

1. **O teste depende de um servidor externo.** Se a API não estiver no ar, falha. Em projeto real
   usa-se `@SpringBootTest(webEnvironment = RANDOM_PORT)` para o próprio teste subir a aplicação,
   ou Testcontainers.
2. **`EntregasApplicationTests` está com tudo comentado** — era o teste de integração padrão do
   Spring Boot, desativado para não atrapalhar a aula.
3. **O cenário só verifica o status code**, não o conteúdo da resposta. Um próximo passo natural
   seria assertar que o `numeroEntrega` voltou preenchido e que os dados batem.
4. **Só existe o caminho feliz.** Testes de verdade cobrem também os erros: nome com mais de 25
   caracteres, `numeroPedido` nulo, status inválido — tudo isso deve retornar 400, e o
   `EntregaDto` já tem as validações prontas. Adicionar esses cenários é o melhor exercício agora,
   porque reaproveitaria **100% do código já escrito**: basta um `Cenario:` novo no `.feature`.
5. **`ddl-auto=create-drop`** no `application.properties` recria o banco a cada start da
   aplicação, então os testes não acumulam lixo entre reinícios — mas acumulam entre execuções
   de teste com o app no ar.
6. **Typo no nome do arquivo:** `CadastoEntregasService` está sem o "r" de "Cadastro". Não quebra
   nada, mas vale corrigir ao evoluir o projeto.

---

## Estrutura do projeto

```
src/
├── main/java/br/com/fiap/entregas/
│   ├── controller/EntregaController.java      # endpoints REST
│   ├── service/EntregaService.java            # regras de negócio
│   ├── repository/EntregaRepository.java      # acesso ao banco (JPA)
│   ├── model/Entrega.java                     # entidade da tabela tbl_entregas
│   ├── model/StatusEntrega.java               # enum: EM_SEPARACAO, EM_TRANSPORTE, ENTREGUE
│   ├── dto/                                   # objetos de entrada/saída da API
│   ├── exception/                             # exceções de domínio
│   └── config/GlobalExceptionHandler.java     # tratamento centralizado de erros
│
└── test/
    ├── java/
    │   ├── runner/RunCucumberTest.java        # gatilho: liga JUnit 5 ao Cucumber
    │   ├── steps/CadastroEntregasSteps.java   # ponte Gherkin → Java
    │   ├── services/CadastoEntregasService.java # camada HTTP (REST Assured)
    │   └── model/EntregaModel.java            # payload JSON dos testes
    └── resources/features/
        └── CadastroEntregas.feature           # cenários em português (Gherkin)
```

---

## Resumo em uma frase

Um teste de API caixa-preta usando BDD, onde um arquivo em português (`.feature`) descreve o
comportamento esperado, uma classe de steps traduz esse texto para Java, um service encapsula a
comunicação HTTP com o REST Assured, e um model define o JSON enviado — tudo disparado por uma
classe runner vazia que só existe para ligar o Cucumber ao JUnit.

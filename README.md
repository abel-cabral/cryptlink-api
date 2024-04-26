# Sobre o Projeto

Este projeto consiste em uma API para encurtar links, fornecendo um backend que pode ser integrado a páginas web estáticas. A API permite aos usuários encurtarem URLs, gerando IDs que podem ser combinados com as URLs originais para criar links encurtados.

Existem duas operações principais nesta API:

### Criptografar

Na operação de criptografar, os usuários enviam um objeto JSON contendo a URL original, uma senha opcional, uma configuração para exclusão automática e um número de exibições permitidas. O backend retorna um objeto JSON contendo o ID gerado, a URL criptografada, e informações sobre a exclusão automática e o número de exibições.

Exemplo de objeto de entrada:
```json
{
    "url": "https://www.youtube.com/watch?v=Dnk_bl9ln6s&list=RDDhIxpJHOeEo&index=4",
    "senha": "123443211",
    "auto_delete": true,
    "numero_exibicao": 2
}
```

Exemplo de objeto de saída:
```
{
    "id": "JZhSwh",
    "url": "TW7CXPzaXMe7XhwArrrIUAPpVtveKgExK51zvnPI6B9iBew2itVy3pNVPD1AgnZzZOtt/0nFFyT7Pym2tb7hBlCp3UibiC10rRvhl+PkQxM=",
    "auto_delete": false,
    "numero_exibicao": 2
}
```

### Descriptografar
Na operação de descriptografar, os usuários enviam um objeto JSON contendo o ID do link encurtado e a senha utilizada para criptografar. O backend retorna a URL original correspondente, permitindo que o frontend redirecione o usuário.

Exemplo de objeto de entrada:
```
{
    "link_publico": "uupoqy",
    "senha": "123443211"
}
```

Exemplo de objeto de saída:
```
{
    "url": "https://www.youtube.com/watch?v=Dnk_bl9ln6s&list=RDDhIxpJHOeEo&index=4"
}
```
Os links encurtados podem ser configurados para permitir um número limitado de exibições, após o qual serão automaticamente excluídos do banco de dados. Alternativamente, o link pode ser configurado como permanente, desativando a exclusão automática.

A ideia central da API é proporcionar uma forma de encurtar links que force os usuários a fornecer uma senha, garantindo que apenas aqueles que possuem a senha possam acessar a URL original. O banco de dados não armazena a senha nem a URL original, apenas o hash criptografado, que só é recuperado se a senha correspondente for fornecida.


Essa seção detalhada fornece uma visão clara do propósito e funcionamento do projeto.

# Executando Localmente

Este projeto utiliza o Quarkus, um framework Java Supersônico Subatômico.

### Executando o aplicativo em modo de desenvolvimento

Você pode executar o seu aplicativo em modo de desenvolvimento, que permite codificação ao vivo, usando:

```shell script
./mvnw compile quarkus:dev ou quarkus dev
```
OBSERVAÇÃO: O Quarkus agora vem com uma interface de desenvolvimento (Dev UI), disponível apenas em modo de desenvolvimento em http://localhost:8080/q/dev/.

###Empacotando e executando o aplicativo
O aplicativo pode ser empacotado usando:

```
    ./mvnw package
```

Ele produz o arquivo quarkus-run.jar no diretório target/quarkus-app/. Este não é um über-jar, pois as dependências são copiadas para o diretório target/quarkus-app/lib/.

O aplicativo agora pode ser executado usando java -jar target/quarkus-app/quarkus-run.jar.
Se desejar construir um über-jar, execute o seguinte comando:

```
./mvnw package -Dquarkus.package.type=uber-jar
```
O aplicativo, empacotado como um über-jar, agora pode ser executado usando java -jar target/*-runner.jar.

###Criando um executável nativo
Você pode criar um executável nativo usando:

```
./mvnw package -Dnative
```

Ou, se não tiver o GraalVM instalado, pode executar a compilação do executável nativo em um contêiner usando:

```
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

Você pode então executar seu executável nativo com: ./target/code-with-quarkus-1.0.0-SNAPSHOT-runner
Para saber mais sobre a criação de executáveis nativos, consulte https://quarkus.io/guides/maven-tooling.

## Guias Relacionados
REST (guia): Uma implementação REST de Jakarta utilizando processamento em tempo de compilação e Vert.x. Esta extensão não é compatível com a extensão quarkus-resteasy, ou qualquer uma das extensões que dependem dela.
Cliente MongoDB (guia): Conecte-se ao MongoDB de forma imperativa ou reativa.
REST Jackson (guia): Suporte à serialização Jackson para RESTEasy Reactive. Esta extensão não é compatível com a extensão quarkus-resteasy, ou qualquer uma das extensões que dependem dela.

### Código Fornecido
#### REST
Inicie facilmente seus Serviços Web REST

[Seção do guia relacionada...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)


Este README.md fornecerá uma visão geral clara do projeto, incluindo instruções sobre como executá-lo e links úteis para informações adicionais.


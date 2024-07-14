# Microserviço de Autenticação de Login - `bffecommerce`

## Visão Geral

- Objetivo: Este repositório contém o bffecommerce para uma aplicação de e-commerce. O serviço
  permite que clientes se cadastrem e façam login na plataforma, adicionem produtos ao carrinho e finalizem a compra.

- Arquitetura: O projeto foi desenvolvido em Java com Spring Boot, seguindo o padrão de arquitetura limpa. A aplicação
  é dividida em camadas de aplicação, domínio e infraestrutura.

- Segurança: A segurança da aplicação é garantida por meio de tokens JWT (JSON Web Token), que são gerados e validados

- Banco de Dados: Para facilitar o desenvolvimento e testes, a aplicação utiliza o banco de dados H2, que é um banco de
  dados em memória.

- Dependências: O projeto utiliza o Gradle como gerenciador de dependências e build.

## Arquitetura

![arquitetura](./docs/images/desenho-solucao.drawio.png)

## Estrutura do Projeto

A estrutura do projeto está organizada em diferentes pacotes, cada um com responsabilidades específicas para manter o
código modular e fácil de manter.

| Pacote            | Descrição                | Responsabilidades                                                                                                          |
|-------------------|--------------------------|----------------------------------------------------------------------------------------------------------------------------|
| `/application`    | Camada de Aplicação      | Contém os serviços e controladores responsáveis pelo processamento das solicitações e pela lógica de negócio.              |
| `/domain`         | Camada de Domínio        | Define as entidades do domínio, repositórios e regras de negócio que regem o comportamento do sistema.                     |
| `/infrastructure` | Camada de Infraestrutura | Gerencia a comunicação com sistemas externos, como bancos de dados e serviços externos, e configurações de infraestrutura. |

- Requisitos: Para executar o projeto, é necessário ter o JDK 17 ou superior e o Gradle 6.8 ou superior instalados na
  máquina e executar todos os microserviços necessários.

## Instruções de Uso

### Configuração Inicial

1. Clone o repositório do projeto:
    ```bash
    git clone https://github.com/emerlopes/bff-ecommerce
    ```

2. Navegue até o diretório do projeto:
    ```bash
    cd bff-ecommerce
    ```

3. Execute o `docker-compose` para iniciar os serviços:

- Certifique-se de que o Docker está instalado e em execução na sua máquina.
- Abra um terminal e navegue até o diretório do projeto onde o arquivo `docker-compose.yml` está localizado.
- Execute o comando abaixo para baixar as imagens necessárias:
    ```bash
    docker-compose -f misc/docker-compose.yml pull
    ```
- Ainda no terminal, execute o seguinte comando para iniciar os serviços em segundo plano:
    ```bash
    docker-compose -f misc/docker-compose.yml up -d
    ```

## Repositórios Relacionados

1. [Microserviço de Autenticação de Login - `customerauthentication`](https://github.com/emerlopes/customerauthentication)
2. [Microserviço de Catálogo de Produtos - `productcatalog`](https://github.com/emerlopes/itemmanagement)
3. [Microserviço de Pagamento - `payments`](https://github.com/emerlopes/payments)
4. [Microserviço de Carrinho de Compras - `shoppingcart`](https://github.com/emerlopes/shoppingcart)
5. [Microserviço de Pedidos - `orders`](https://github.com/emerlopes/shoppingcart)

- Exemplo de Requisição: Para facilitar a chamada das requisições, a collection da API pode ser encontrada no diretório
  `/collection`.

## Endpoints

Os detalhes dos endpoints da API, incluindo descrições, parâmetros de entrada e exemplos de resposta, estão disponíveis em [`swagger-ui`](http://localhost:8080/swagger-ui/index.html#/), após a execução do projeto.


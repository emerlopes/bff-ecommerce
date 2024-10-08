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

- Requisitos: Para executar o projeto, é necessário ter o JDK 17 ou superior e o Gradle 6.8 ou superior instalados na
  máquina e executar todos os microserviços necessários.

## Estrutura do Projeto

A estrutura do projeto está organizada em diferentes pacotes, cada um com responsabilidades específicas para manter o
código modular e fácil de manter.

| Pacote            | Descrição                | Responsabilidades                                                                                                          |
|-------------------|--------------------------|----------------------------------------------------------------------------------------------------------------------------|
| `/application`    | Camada de Aplicação      | Contém os serviços e controladores responsáveis pelo processamento das solicitações e pela lógica de negócio.              |
| `/domain`         | Camada de Domínio        | Define as entidades do domínio, repositórios e regras de negócio que regem o comportamento do sistema.                     |
| `/infrastructure` | Camada de Infraestrutura | Gerencia a comunicação com sistemas externos, como bancos de dados e serviços externos, e configurações de infraestrutura. |
| `/repository`     | Camada de Repositório    | Responsável por acessar o banco de dados e realizar operações de leitura e gravação.                                       |

## Arquitetura

![arquitetura](misc/images/desenho-solucao.drawio.png)

## Sobre o Projeto

O projeto `bffecommerce` é um serviço de backend for frontend (BFF) que atua como intermediário entre o cliente e os
demais microserviços.

O BFFecommerce é responsável por:

- Autenticar usuários e gerar tokens JWT para autorização.
- Validar tokens JWT e autorizar solicitações.
- Gerenciar o carrinho de compras dos usuários.
- Finalizar pedidos e processar pagamentos.

O BFFecommerce se comunica com os seguintes microserviços:

- `customerauthentication`: Microserviço de autenticação de usuários.
- `itemmanagement`: Microserviço de catálogo de produtos.
- `shoppingcart`: Microserviço de carrinho de compras.
- `payments`: Microserviço de pagamentos.

### Sobre o Microserviço de autenticação de usuários

O microserviço de autenticação de usuários é responsável por gerenciar a autenticação e autorização de usuários na
plataforma.

O serviço oferece as seguintes funcionalidades:

- Cadastro de novos usuários.
- Login de usuários existentes.
- Geração de tokens JWT para autorização de solicitações.
- Validação de tokens JWT e autorização de solicitações.

As permissões de acesso dos usuários são definidas com base em seus papéis (roles), que podem ser `ROLE_GUEST`, para os
usuários não autenticados, `ROLE_USER`, para os usuários autenticados e `ROLE_ADMIN`, para os administradores.

### Sobre o Microserviço de catálogo de produtos

O microserviço de catálogo de produtos é responsável por gerenciar o catálogo de produtos da plataforma.

O serviço oferece as seguintes funcionalidades:

- Listagem de todos os produtos disponíveis.
- Busca de produtos por ID.
- Adição de novos produtos ao catálogo.
- Atualização de produtos existentes.

Segurança:
O acesso aos endpoints para cadastrar e atualizar produtos é restrito aos usuários autenticados com a
permissão `ROLE_ADMIN`.

Para acessar esses endpoints, é necessário incluir o token JWT no cabeçalho da solicitação. Ele é gerado pelo
microserviço de autenticação.

Os endpoints para listar e buscar produtos estão disponíveis para todos os usuários, mesmo os não autenticados.

### Sobre o Microserviço de carrinho de compras

O microserviço de carrinho de compras é responsável por gerenciar o carrinho de compras dos usuários.

O serviço oferece as seguintes funcionalidades:

- Adição de produtos ao carrinho.
- Remoção de produtos do carrinho.
- Listagem de todos os produtos no carrinho.

Segurança: O acesso aos endpoints para adicionar e remover produtos do carrinho é restrito aos usuários autenticados.
Para acessar esses endpoints, é necessário incluir o token JWT no cabeçalho da solicitação. Ele é gerado pelo
microserviço de autenticação.

### Sobre o Microserviço de pagamentos

O microserviço de pagamentos é responsável por processar os pagamentos dos pedidos dos usuários.

O serviço oferece as seguintes funcionalidades:

- Processamento de pagamentos.

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
- Abra um terminal e navegue até o diretório do projeto.
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

- Exemplo de Requisição: Para facilitar a chamada das requisições, a collection da API pode ser encontrada no diretório
  `misc/collection`.

## Endpoints

Os detalhes dos endpoints da API, incluindo descrições, parâmetros de entrada e exemplos de resposta, estão disponíveis
em [`swagger-ui`](http://localhost:8080/swagger-ui/index.html#/), após a execução do projeto.


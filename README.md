# Feito à Mão - Plataforma para Artesãos

## Descrição
Feito à Mão é uma plataforma dedicada a artesãos, onde podem listar e vender seus produtos exclusivos. Esta aplicação fornece uma maneira fácil e eficaz para conectar artesãos a potenciais compradores.

## Funcionalidades Principais
- Cadastro de artesãos e produtos.
- Listagem de produtos para venda.
- Avaliação e comentários dos produtos.
- Gerenciamento de perfil para cada artesão.

## Pré-requisitos
- Java 8
- PostgreSQL
- Maven

## Configuração do Banco de Dados
- Certifique-se de ter um servidor PostgreSQL em execução.
- Crie um banco de dados chamado `FEITO_A_MAO`.
- Configure as credenciais nos arquivos `application.yml` e `flyway.properties`  ou por meio de variáveis de ambiente.

## Configuração do Projeto
1. Compile o projeto: `mvn clean install`

## Execução da Aplicação
Execute o seguinte comando no diretório do projeto:
```bash
java -jar target/feito-a-mao.jar

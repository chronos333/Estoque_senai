# Sistema de Gerenciamento de Estoque e Ativos Patrimoniais

## Descrição
Projeto desenvolvido para gerenciar o estoque e os ativos patrimoniais de uma unidade escolar do SENAI-SP.  
O sistema permite controlar materiais, categorias, movimentações de entrada e saída, ativos patrimoniais e acesso de funcionários por NIF.

## Tecnologias Utilizadas
- Java 17
- Spring Boot
- Spring Data JPA
- Thymeleaf
- HTML
- CSS
- Banco de Dados Relacional
- Maven

## Funcionalidades Básicas
- Cadastro de funcionário autorizado
- Login com NIF e senha
- Cadastro de categorias
- Cadastro de materiais
- Registro de entrada e saída de estoque
- Cadastro de ativos patrimoniais
- Visualização de inventário

## Requisitos Funcionais Básicos
- **RF01:** O sistema deve permitir o cadastro de funcionários autorizados.
- **RF02:** O sistema deve permitir login com NIF e senha.
- **RF03:** O sistema deve permitir cadastrar categorias de materiais.
- **RF04:** O sistema deve permitir cadastrar materiais no estoque.
- **RF05:** O sistema deve permitir registrar entradas de materiais.
- **RF06:** O sistema deve permitir registrar saídas de materiais.
- **RF07:** O sistema deve permitir cadastrar ativos patrimoniais.
- **RF08:** O sistema deve permitir visualizar os dados cadastrados.

## Requisitos Não Funcionais Básicos
- **RNF01:** O sistema deve ter interface simples e fácil de usar.
- **RNF02:** O sistema deve armazenar os dados em banco de dados relacional.
- **RNF03:** O sistema deve restringir o acesso interno apenas a usuários logados.
- **RNF04:** O sistema deve ser organizado em camadas (controller, service, repository e model).
- **RNF05:** O sistema deve seguir a identidade visual do SENAI-SP.
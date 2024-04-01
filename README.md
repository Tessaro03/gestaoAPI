# Gestão API

A **Gestão API** é uma solução completa para gerenciamento de lojas, desenvolvida em Java com o framework Spring. Esta API oferece recursos avançados para administrar funcionários, categorias e produtos em uma loja, utilizando um banco de dados MySQL e JWT para autenticação.

## Funcionalidades Principais

1. **Gestão de Funcionários:** Permite o cadastro e gerenciamento de funcionários, distinguindo entre Lojistas e Logística, com permissões específicas para cada tipo de usuário.

2. **Gestão de Categorias:** Possibilita a criação e manutenção de categorias para os produtos da loja, organizando-os de forma eficiente.

3. **Gestão de Produtos:** Permite a criação, visualização, atualização e exclusão de produtos, com regras de negócio específicas para cada tipo de funcionário.

## Recursos Destacados

- **Autenticação JWT:** Utiliza JWT para autenticar usuários e garantir a segurança das operações na API.
  
- **Controle de Acesso:** Implementa regras de acesso para garantir que apenas usuários autorizados possam realizar operações específicas na API.

- **Operações CRUD:** Oferece operações CRUD completas para funcionários, categorias e produtos, garantindo flexibilidade na manipulação dos dados.

## Arquitetura e Tecnologias Utilizadas

A API foi desenvolvida seguindo as melhores práticas de arquitetura de software, utilizando o padrão MVC (Model-View-Controller) do Spring. Além disso, integra o Spring Security para controle de acesso e o Spring Data JPA para acesso ao banco de dados.

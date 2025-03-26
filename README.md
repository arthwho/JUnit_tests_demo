# 1. Introdução
Este documento descreve o modelo de processo para o desenvolvimento do sistema de gerenciamento de vacinas, incluindo atividades, responsáveis e cronograma de execução.
Essa implementação parcial do sistema usa o padrão Singleton para garantir que haja apenas um catálogo de vacinas em toda a aplicação. Ele permite adicionar, listar e remover vacinas de maneira simples e eficiente.

O projeto segue o padrão MVC (Model-View-Controller), separando as responsabilidades em diferentes camadas:
1. **Model (Modelo)** – Contém a lógica de negócio:
- Vacina.java
- CatalogoVacinas.java

2. **View (Visão)** – Interface gráfica:
- GerenciadorVacinasGUI.java

3. **Testes** – Verificam se o sistema funciona corretamente:
- CatalogoVacinasTest.java

---

# 2. Modelo de Processo

## 2.1. Metodologia Utilizada
A metodologia adotada para o desenvolvimento será baseada no modelo incremental, permitindo evolução contínua do sistema e entregas em ciclos curtos.

## 2.2. Atividades e Responsáveis
| Atividade | Descrição | Responsável | Prazo |
|-----------|-------------|-------------|--------|
| Levantamento de Requisitos | Identificação dos requisitos funcionais e não-funcionais | Analista de Requisitos | 1 semana |
| Especificação de Requisitos | Criação do documento de requisitos detalhado | Analista de Requisitos | 1 semana |
| Projeto Arquitetural | Definição da arquitetura, incluindo diagramas UML | Arquiteto de Software | 1 semana |
| Implementação Inicial | Desenvolvimento do sistema com funcionalidades básicas | Desenvolvedor | 2 semanas |
| Testes Unitários | Desenvolvimento e execução de testes automatizados | Engenheiro de Testes | 1 semana |
| Revisão e Ajustes | Correção de falhas e melhorias no sistema | Equipe de Desenvolvimento | 1 semana |
| Entrega e Documentação | Finalização do sistema e entrega com documentação | Gerente de Projeto | 1 semana |

Tempo total estimado: **8 semanas**

---

# 3. Especificação de Requisitos

## 3.1. Requisitos Funcionais
1. O sistema deve permitir a adição de vacinas ao catálogo.
2. O sistema deve listar as vacinas cadastradas.
3. O sistema deve permitir a remoção de vacinas do catálogo.
4. O sistema deve ter uma interface gráfica intuitiva.

## 3.2. Requisitos Não-Funcionais
1. O sistema deve ser desenvolvido em Java.
2. O sistema deve utilizar o padrão de projeto Singleton para o gerenciamento de vacinas.
3. O tempo de resposta das operações não deve ultrapassar 2 segundos.
4. O sistema deve ser compatível com Windows e Linux.

---

# 4. Detalhamento dos Requisitos Funcionais

## 4.1. Histórias de Usuário

**História 1:** Como usuário, quero adicionar vacinas ao sistema informando nome, data de fabricação e data de validade, para manter um registro organizado.

**História 2:** Como usuário, quero visualizar todas as vacinas registradas, para saber quais estão disponíveis.

**História 3:** Como usuário, quero remover vacinas do sistema, para manter a lista sempre atualizada.

## 4.2. Cenários de Teste

| ID | Cenário | Entrada | Resultado Esperado |
|----|---------|---------|-------------------|
| CT-01 | Adicionar vacina válida | Nome: "Vacina A", Fabricação: "01/01/2024", Validade: "01/01/2025" | Vacina adicionada com sucesso |
| CT-02 | Listar vacinas cadastradas | - | Exibir lista com vacinas |
| CT-03 | Remover vacina existente | Nome: "Vacina A" | Vacina removida com sucesso |
| CT-04 | Remover vacina inexistente | Nome: "Vacina X" | Mensagem de erro |

**testAdicionarVacina:** Testa se uma vacina pode ser adicionada corretamente ao catálogo.
- Cria um novo catálogo de vacinas.
- Adiciona uma vacina ao catálogo.
- Verifica se o número de vacinas no catálogo é 1.
- Se o número de vacinas for 1, o teste passa; caso contrário, falha.

**testRemoverVacina:** Testa se a remoção de uma vacina do catálogo funciona corretamente.
- Cria um novo catálogo de vacinas.
- Adiciona uma vacina chamada "Vacina B".
- Remove a vacina do catálogo.
- Verifica se o número de vacinas no catálogo é 0.
- Se o catálogo estiver vazio, o teste passa; caso contrário, falha.

**testListarVacinas:** Testa se a listagem de vacinas retorna a quantidade correta de vacinas no catálogo.
- Cria um novo catálogo de vacinas.
- Adiciona duas vacinas ("Vacina C" e "Vacina D").
- Verifica se o número de vacinas no catálogo é 2.
- Se o catálogo contiver exatamente duas vacinas, o teste passa; caso contrário, falha.

**testRemoverVacinaInexistente:** Testa se o sistema lida corretamente com a remoção de uma vacina que não existe.
- Cria um novo catálogo de vacinas.
- Tenta remover uma vacina chamada "Vacina X" (que nunca foi adicionada).
- Verifica se o número de vacinas no catálogo continua 0.
- Se nada for removido e o catálogo permanecer vazio, o teste passa; caso contrário, falha.

# 5. Projeto Arquitetural

## 5.1. Diagrama de Classes
O diagrama de classes representará as entidades do sistema e seus relacionamentos, incluindo as classes `Vacina`, `CatalogoVacinas` e `GerenciadorVacinasGUI`.

## 5.2. Diagrama de Componentes
Este diagrama mostrará os principais componentes do sistema e suas interações, incluindo o módulo de interface gráfica, o catálogo de vacinas e o banco de dados.

## 5.3. Diagrama de Sequência
O diagrama de sequência ilustrará o fluxo de mensagens entre os objetos durante as operações de adicionar, listar e remover vacinas.
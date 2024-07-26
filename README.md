# TesteInfo4

Este projeto permite que os usuários cadastrem tarefas.
Teremos duas telas principais: uma para adicionar ou alterar tarefas e outra para listar todas as tarefas cadastradas podendo deleta-las.

Campos de entrada: Nome da tarefa, descrição da tarefa

## Tecnologias Utilizadas

* **Frontend:** React/JavaScript
* **Backend:** Java, Node.js
* **Banco de dados:** Postgresql

## Endpoints

* GET /api/items/{id} - Retorna o item com o id especificado
* PUT /api/items/atualizar/{id} - Atualiza o item com o id especificado
* DELETE /api/items/deletar/{id} - Deleta o item com o id especificado
* GET /api/items/listar - Lista todos os items salvos no banco de dados
* POST /api/items/salvar - Adiciona uma nova tarefa

### Instruções de Uso:

* Execute a aplicação.
* Acesse a tela de cadastro e preencha os campos.
* Visualize as tarefas cadastradas na tela de listagem.
* Atualize ou delete na tela de listagem

* Tela de Listagem de Tarefas
  * Descrição:
    * Essa tela exibe todas as tarefas cadastradas na aplicação.
  * Funcionalidades:
    * Lista todas as tarefas com informações relevantes (nome, descrição)
    * Permite alterar e deletar as tarefas
* Tela de Cadastro
  *  Descrição:
      *  Essa tela permite a criaçao de novas tarefas
  *  Funcionalidades
      * Campos para inserção de nome e descrição
      * Botão para salvar a nova tarefa e exibir na tela de listagem (incluindo a data e hora de criaçao da tarefa)

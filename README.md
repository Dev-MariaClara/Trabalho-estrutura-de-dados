# RPG Arena — Plataforma de RPG e Matchmaking

## Descrição
O RPG Arena é uma aplicação desenvolvida em Java para gerenciamento de personagens, matchmaking e inventários de um ambiente de RPG.

O projeto utiliza três estruturas de dados implementadas manualmente: Árvore Binária de Busca, Fila e Pilha.

## Estruturas de Dados

### 1. Árvore Binária de Busca — ArvorePersonagens
Responsável pelo cadastro e gerenciamento dos personagens.

Funcionalidades:
- Inserção de personagens.
- Busca por ID.
- Busca por nível.
- Remoção de personagens.
- Percursos em ordem, pré-ordem e pós-ordem.

### 2. Fila — FilaMatchmaking
Responsável pela organização dos personagens aguardando partidas.

Funcionalidades:
- Adicionar jogadores à fila.
- Buscar jogadores.
- Remover jogadores.
- Listar a fila.
- Formar partidas.

A estrutura segue a regra FIFO (First In, First Out).

### 3. Pilha — PilhaInventario
Responsável pelo gerenciamento dos inventários dos personagens.

Funcionalidades:
- Adicionar itens.
- Buscar itens.
- Remover itens.
- Listar inventários individuais.

A estrutura segue a regra LIFO (Last In, First Out).

## Tecnologias utilizadas
- Java
- Programação Orientada a Objetos
- Estruturas de Dados

## Integrantes
- Arthur Gabriel — Árvore Binária de Busca
- Maria Clara — Fila de Matchmaking
- Beatriz — Pilha de Inventário

## Como executar
1. Baixe os arquivos do projeto.
2. Abra a pasta no ambiente de desenvolvimento Java.
3. Compile os arquivos.
4. Execute a classe Main.

Comandos pelo terminal:

`javac *.java`

`java Main`

## Disciplina
Estrutura de Dados — 2026.2

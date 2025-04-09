# **Erank - Rede Social Competitiva para Jogadores de FPS**

**Erank** é uma aplicação web desenvolvida com **Spring Boot**, criada para conectar jogadores de **First Person Shooter (FPS)** em uma plataforma social e competitiva. A proposta do Erank é promover o reconhecimento da performance individual e coletiva através de rankings, votos da comunidade e torneios criados pelos próprios jogadores.

---

## 🎯 Objetivo

Criar um espaço onde jogadores de FPS possam:

- Exibir suas **conquistas** e estatísticas;
- **Avaliar e ser avaliados** por outros membros da comunidade;
- Participar de **times e temporadas competitivas**;
- Construir uma reputação dentro da plataforma com base em mérito e comportamento.

---

## 🚀 Funcionalidades

### 🧑‍💼 1. Perfis de Jogadores
- Perfil personalizado com nickname, jogo favorito, conquistas e estatísticas.
- Ranking individual visível para toda a comunidade.

### 📈 2. Ranking e Avaliação
- Sistema de ranqueamento baseado em:
  - Conquistas registradas;
  - Votos de outros usuários;
  - Participações em temporadas.

- Avaliação entre jogadores com base em critérios como:
  - Habilidade técnica;
  - Espírito esportivo;
  - Trabalho em equipe.

### 👥 3. Criação de Times
- Usuários podem criar ou ingressar em times.
- Times possuem rankings próprios e estatísticas coletivas.
- Cada time pode ter descrição, logo e rede social.

### 🏆 4. Temporadas (Campeonatos)
- Qualquer usuário pode criar uma temporada (campeonato).
- Temporadas com regras personalizadas e sistema de ranqueamento próprio.
- Histórico de desempenho por temporada.

---

## 🛠️ Tecnologias Utilizadas

- **Java 17 / Spring Boot** – Backend moderno e escalável.
- **MySQL** – Banco de dados relacional.
- **Spring Security** – Controle de acesso e autenticação.
- **JPA (Hibernate)** – ORM para persistência de dados.
- **REST API** – Comunicação entre backend e futuras aplicações cliente.

---

## 📅 Planejamento Futuro

- Desenvolvimento do **frontend (Vue.js)** e versão **mobile (Android)**;
- Sistema de **chat em tempo real** entre jogadores e equipes;
- Integrações com **Steam, Discord, Twitch**, entre outras plataformas;
- Implementação de **badges e conquistas visuais**;
- Análise de performance via integração com APIs dos jogos.

---

## 🧪 Ambiente de Desenvolvimento

> **Este projeto é desenvolvido exclusivamente por membros internos da equipe Erank. Não estamos aceitando contribuições externas neste momento.**

Caso você faça parte da equipe de desenvolvimento:

- Todos os commits **devem seguir o padrão de nomenclatura acordado internamente**, baseado em [Conventional Commits](https://www.conventionalcommits.org/pt-br/v1.0.0/).
- Commits fora do padrão **serão excluídos sem aviso prévio**.
- A responsabilidade por seguir o padrão de commit é inteiramente do desenvolvedor.

### ✅ Exemplo de commit válido:
**Estrutura:** (tipo): descrição do que foi feito.

#### 🔖 Tipos mais comuns:
- feat: nova funcionalidade

- fix: correção de bug

- docs: mudanças na documentação

- refactor: refatoração de código

- test: criação ou modificação de testes

- chore: tarefas de build, configurações, scripts auxiliares etc.

```bash
feat: adiciona endpoint para criação de perfil.



# 🎮 HueHue Br! Duel Game (Projeto MC 322 - Tarefa 5)

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)
![Unicamp](https://img.shields.io/badge/Unicamp-IC-red?style=for-the-badge)

Este projeto foi desenvolvido como parte das avaliações da disciplina **MC322 - Programação Orientada a Objetos** na **Universidade Estadual de Campinas (UNICAMP)**.

O jogo é um *roguelike deckbuilder* inspirado em **Slay the Spire**, focado em aplicar conceitos de Engenharia de Software, como persistência de dados, testes automatizados e design partterns (Observer). Nele, o jogador controla Silvio Santos utilizando um baralho de "gambiarras" para derrotar inimigos cotidianos (boletos e faturas) em batalhas por turnos.

## 1. Estrutura do Projeto
O projeto adota a estrutura padrão do **Gradle** para Java, com separação clara de responsabilidades:

```text
.
├─ src/
│  ├─ main/java/
│  │  ├─ App.java               # Classe Principal e inicialização do Mapa
│  │  ├─ jogo/
│  │  │  ├─ Batalha.java         # Lógica de combate individual
│  │  │  ├─ GameManager.java     # Orquestrador de turnos utilizando Observer
|  |  |  ├─ Arte.java            # Artes dos personagens e ASCII           
|  |  |  ├─ Terminal.java        # Funções de limpar e pausar o terminal
|  |  |  ├─ EstadoJogo.java      # Lógica de salvamento do estado do jogo
│  │  │  ├─ GerenciadorJogo.java # Lógica de serialização/desserialização JSON
│  │  │  ├─ EstadoJogo.java      # DTO para persistência
│  │  │  └─ NoMapa.java          # Estrutura de dados (Árvore) para navegação
│  │  ├─ cartas/                 # Implementações do Baralho e tipos de Cartas
│  │  ├─ entidades/              # Heróis e Inimigos (Silvio, Boleto)
│  │  └─ padroes/                # Interfaces Publisher/Subscriber
│  └─ test/java                  # Testes automatizados (JUnit 5)
├─ build.gradle                  # Configurações de dependências (Gson, JaCoCo, JUnit)
└─ README.md
```
## 2. Como Executar o Jogo
Na raiz do repositório, utilize o wrapper do Gradle para compilar e executar o projeto:
```bash
./gradlew clean build
./gradlew run
```
*Nota: O Gradle fará o download e resolverá automaticamente a biblioteca Gson necessária para a persistência*

## 3. Testes Automatizados e Cobertura
O projeto possui testes unitários para garantir os requisitos de qualidade do software. Para gerar os testes e gerar o relatório de cobertura (JaCoCo):
```bash
./gradlew test
./gradlew jacocoTestReport
```
O relatório HTML está disponível em: *build/reports/jacoco/test/html/index.html*.

## 4. Mecânicas e Funcionalidades
- **Navegação(Árvore):** Avance por nós como Guarujá, Acre e Taubaté. A posição e os caminhos disponíveis são gerenciados dinamicamente.
- **Combate e Turnos:** Gerencia 12 Horas de Sono (energia) por turno para jogar as cartas de ataque, defesa ou efeitos.
- **Persistência de Estado (JSON):** Salve o progresso a qualquer momento ("0 - Salvar e Sair"). Os dados (vida, mapa, carta na mão) são gravados em *save.json* e recarregados automaticamente na próxima sessão.

## 5. Tecnologias Utilizadas
* Linguagem: Java
* Ferramente de Build: Gradle
* Testes: JUnit 5
* Cobertura de Código: JaCoCo
* Persistência: Google Gson

## 6. Autoria
Projeto desenvolvido por:
* **Guilherme Arthur Arruda de Figueiredo, RA 174618**
* **Vitor Ribeiro Lima, RA 198079**


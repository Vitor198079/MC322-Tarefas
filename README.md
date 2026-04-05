# 🎮 HueHue Br! Duel Game (Tarefa 4)

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)
![Unicamp](https://img.shields.io/badge/Unicamp-IC-red?style=for-the-badge)

Se o **Boleto Vencido** era um problema, agora ele está documentado, compilado e gerenciado com rigor profissional. Bem-vindo à quarta iteração do **HueHue Br!**, onde a gambiarra brasileira encontrou a engenharia de software de elite. 

Nesta fase, abandonamos a compilação manual e abraçamos o **Gradle**, documentamos com **Javadoc** e expandimos o arsenal de sobrevivência do brasileiro com novas mecânicas de sono e exaustão.

---

## 🏗️ O que mudou na Tarefa 4? (Engenharia de Software)

### 1. Adeus, `javac` manual! (Build Automation) 🛠️
O projeto agora é totalmente automatizado via **Gradle**. A estrutura foi refatorada para o padrão de mercado (`src/main/java`), garantindo que o build seja reproduzível em qualquer máquina sem configurar caminhos manualmente.

### 2. Documentação (Javadoc) 📚
Não precisa mais adivinhar o que um método faz. Utilizamos o **Javadoc** para documentar a lógica de jogo, os parâmetros de cada carta e o comportamento dos efeitos. 
* Gere o HTML e veja a arquitetura de forma clara e profissional.

### 3. Expansão do Baralho de Sobrevivência 🃏
Implementamos 5 novas cartas que utilizam os sistemas de herança e polimorfismo para interagir com o estado do jogador:
* **☕ Café Expresso:** Gera acúmulos de Cafeína para proteção futura.
* **😰 Gatilho Mental:** Aplica Ansiedade no inimigo (dano passivo por pressão psicológica).
* **🐦 Hate no Twitter:** Carta híbrida que causa dano direto e aplica debuffs.
* **😏 Dar um Migué:** A estratégia defensiva essencial para ganhar fôlego.
* **💥 Lapada Seca:** Ataque de alto impacto que consome uma quantidade generosa de sono.

---

## ✨ Interface e Experiência (Desafio Extra)

Para deixar a "baderna" visualmente interessante e fácil de entender, implementamos:
* **Cores ANSI:** Vida em **Azul**, Perrengues em **Vermelho**, Escudo em **Verde** e as sagradas Horas de Sono em **Ciano**.
* **Ritmo de Jogo:** Pausas estratégicas (`Terminal.pausar`) para que o jogador sinta o peso das ações.
* **Limpeza de Tela:** O console é limpo entre turnos, evitando aquele "textão" infinito e mantendo o foco no combate atual.

---

## 🕹️ Guia de Sobrevivência

### 1. Gestão de Recursos (Horas de Sono)
Você começa cada turno com **Horas de Sono**. Cada carta custa um pouco desse recurso. Se o sono acabar, você fica "virado" e vulnerável.

### 2. O Ciclo do Baralho
Cartas usadas vão para o descarte e são reembaralhadas quando o monte de compra esvazia. É a economia circular da sobrevivência.

### 3. Sistema de Efeitos (Observer Pattern)
* **Cafeína:** Converte disposição em escudo no início do turno.
* **Ansiedade:** O inimigo (ou você) sofre as consequências do estresse no final do turno.

---

## 🚀 Como Rodar (Via Gradle)

Esqueça os scripts complexos. Agora basta usar o Wrapper do Gradle:

**Compilar o projeto:**
```bash
./gradlew build
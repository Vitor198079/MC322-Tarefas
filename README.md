# 🎮 HueHue Br! Duel Game - Edição "Sobrevivendo ao Semestre" (Tarefa 3)

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Unicamp](https://img.shields.io/badge/Unicamp-IC-red?style=for-the-badge)

Seja bem-vindo ao **HueHue Br! Duel Game**, um simulador de "perrengues" brasileiros onde o seu maior inimigo não é um dragão, mas sim o **Boleto Vencido**. Inspirado na mecânica de *Slay the Spire*, aqui você luta para manter sua sanidade (e sua vida) usando o que o brasileiro tem de melhor: a gambiarra e o café.

---

## 📖 O que mudou na Tarefa 3?

Se na tarefa anterior aprendemos a organizar a "bagunça" com herança, agora o jogo ganhou **alma**. Implementamos o padrão de projeto **Observer**, o que significa que o mundo ao seu redor agora reage às suas ações. 

Agora não é só bater e defender. Você pode ficar ansioso, pode tomar um café pra aguentar o tranco, e os inimigos... bem, eles aprenderam a jogar sujo.

---

## 🏗️ Por baixo do capô (Arquitetura)

Para os avaliadores de plantão, o projeto utiliza o padrão **Observer** para gerenciar os efeitos de status:

* **O Maestro (`GameManager`):** Ele é o nosso *Publisher*. Ele dita o ritmo da "baderna", avisando a todos os interessados quando um turno começa ou termina.
* **Os Espectadores (`Efeito`):** São os *Subscribers*. Eles ficam de olho no `GameManager`. Quando ouvem "Ei, o turno do Silvio Santos acabou!", o efeito de Ansiedade acorda e causa dano.

![Diagrama UML](images/image.png)
*(Hierarquia atualizada: Entidade, Carta, Efeitos e a infraestrutura de Assinatura/Notificação)*

---

## 🕹️ Guia de Sobrevivência (Jogabilidade)

O combate está mais tático do que nunca. Aqui está como você joga:

### 1. Gestão de Recursos (Horas de Sono)
Você começa cada turno com **Horas de Sono**. Cada "gambiarra" (carta) que você usa custa um pouco desse recurso precioso. Se gastar tudo, você fica "virado" e não consegue mais agir.

### 2. O Ciclo do Baralho
* **Compra:** Você puxa cartas do seu monte.
* **Descarte:** Cartas usadas ou que sobraram na mão vão para o lixo no fim do turno.
* **Reciclagem:** Se o monte de compra acabar, a gente embaralha o lixo e começa de novo. Nada se perde, tudo se transforma em gambiarra.

### 3. Sistema de Efeitos (A grande novidade!)
* **☕ Cafeína (Buff):** Se você usar a **Carta Cafeína**, ganha escudo extra no início de cada turno. É o famoso "migué" preventivo.
* **😰 Ansiedade (Debuff):** Algumas cartas (ou ataques do Boleto) causam Ansiedade. Isso tira vida direto no fim do turno. Cuidado: os acúmulos são perigosos!

### 4. Múltiplos Perrengues
Diferente da tarefa anterior, agora você pode enfrentar uma **Fatura de Cartão** e um **Boleto Vencido** ao mesmo tempo. Você precisará escolher bem qual alvo atacar primeiro para não ser "contratado pelo Vasco".

---

## 🚀 Como colocar a baderna pra rodar?

1.  **Compilação:**
    ```bash
    javac -d bin $(find src -name "*.java")
    ```
2.  **Execução:**
    ```bash
    java -cp bin App
    ```

---


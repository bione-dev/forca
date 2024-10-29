

### Explicação do Código

O código implementa um jogo da forca em Java, onde o usuário deve adivinhar uma palavra selecionada aleatoriamente, com base em dicas. O jogo é dividido em duas classes: `Forca` e `Palavra`. A seguir está uma descrição detalhada de cada parte do código:

1. **Classe `Forca`**:
   - **Pacote**: A classe está no pacote `com.exemplo.forca`, organizando o código em um namespace apropriado.
   - **Atributos**:
     - `palavras`: Uma lista que armazena instâncias da classe `Palavra`, contendo palavras e suas respectivas dicas.
     - `palavraSelecionada`: A palavra escolhida aleatoriamente para o jogo.
     - `dica`: A dica correspondente à palavra selecionada.
     - `tentativa`: Um `StringBuilder` que mantém o progresso do jogador, mostrando letras adivinhadas e sublinhados para as letras ainda não adivinhadas.
     - `tentativasRestantes`: Um contador que armazena o número de tentativas restantes do jogador.

   - **Construtor `Forca`**:
     ```java
     public Forca() {
         // Adicionando palavras e dicas
         palavras.add(new Palavra("java", "Uma linguagem de programação"));
         ...
         escolherPalavraAleatoria();
     }
     ```
     O construtor inicializa a lista de palavras e suas dicas, e chama o método `escolherPalavraAleatoria` para selecionar uma palavra aleatoriamente para o jogo.

   - **Método `escolherPalavraAleatoria`**:
     ```java
     private void escolherPalavraAleatoria() {
         Random random = new Random();
         Palavra palavra = palavras.get(random.nextInt(palavras.size()));
         ...
     }
     ```
     Este método utiliza a classe `Random` para escolher uma palavra aleatória da lista e inicializa as variáveis correspondentes, incluindo a palavra a ser adivinhada, a dica e o número de tentativas restantes.

   - **Método `jogar`**:
     ```java
     public void jogar() {
         Scanner scanner = new Scanner(System.in);
         ...
         while (tentativasRestantes > 0 && tentativa.toString().contains("_")) {
             ...
         }
         scanner.close();
     }
     ```
     Este método gerencia o fluxo do jogo, solicitando ao usuário que adivinhe letras e atualizando o estado do jogo com base nas tentativas do jogador. O loop continua até que o jogador adivinhe a palavra ou esgote suas tentativas.

   - **Método `verificarTentativa`**:
     ```java
     private boolean verificarTentativa(char letra) {
         boolean encontrado = false;
         ...
         return encontrado;
     }
     ```
     Este método verifica se a letra digitada pelo jogador está presente na palavra selecionada. Se a letra for encontrada, ela é adicionada ao progresso do jogador.

   - **Método `main`**:
     ```java
     public static void main(String[] args) {
         Forca jogo = new Forca();
         jogo.jogar();
     }
     ```
     O ponto de entrada do programa que cria uma instância do jogo da forca e inicia a jogabilidade.

2. **Classe `Palavra`**:
   - **Atributos**:
     - `palavra`: A palavra que deve ser adivinhada.
     - `dica`: A dica correspondente à palavra.
   
   - **Construtor**:
     ```java
     public Palavra(String palavra, String dica) {
         this.palavra = palavra;
         this.dica = dica;
     }
     ```
     O construtor inicializa os atributos `palavra` e `dica`.

   - **Métodos Getters**:
     ```java
     public String getPalavra() {
         return palavra;
     }
     public String getDica() {
         return dica;
     }
     ```
     Métodos para acessar os atributos da classe `Palavra`.

### Modelo de README para GitHub

```markdown
# Jogo da Forca em Java

Este projeto é uma implementação do clássico jogo da forca em Java, onde o jogador deve adivinhar uma palavra selecionada aleatoriamente a partir de uma lista de palavras, com base em dicas fornecidas.

## Funcionalidades

- Palavras e dicas pré-definidas.
- O jogador tem 6 tentativas para adivinhar a palavra.
- Feedback sobre tentativas incorretas e progresso na adivinhação.

## Como Executar

1. **Clone o Repositório**:
   ```bash
   git clone https://github.com/SEU_USUARIO/SEU_REPOSITORIO.git
   ```

2. **Compile e Execute o Programa**:
   Navegue até o diretório do repositório e compile o programa:
   ```bash
   javac -d . Forca.java Palavra.java
   ```
   Depois, execute o programa:
   ```bash
   java com.exemplo.forca.Forca
   ```

## Estrutura do Código

O código é dividido em duas classes principais:

- **Forca**: Contém a lógica do jogo, gerencia o fluxo de tentativas e mantém o estado do jogo.
- **Palavra**: Representa uma palavra que o jogador deve adivinhar, incluindo sua dica correspondente.

## Exemplo de Uso

Ao iniciar o programa, o jogador verá uma dica e um número de tentativas restantes:

```
Bem-vindo ao Jogo da Forca!
Dica: Uma linguagem de programação
Palavra: _____
Tentativas restantes: 6
Digite uma letra:
```

O jogador insere letras e tenta adivinhar a palavra. O jogo continua até que o jogador adivinhe a palavra ou esgote suas tentativas.

```
Parabéns! Você adivinhou a palavra: java
```
```

---

Sinta-se à vontade para ajustar ou personalizar conforme necessário!

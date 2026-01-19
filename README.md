![Java](https://img.shields.io/badge/Language-Java-orange?style=for-the-badge&logo=java)
![Algorithm](https://img.shields.io/badge/Algorithm-Flood%20Fill-blue?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Completed-success?style=for-the-badge)


## Sobre o Projeto

O Projeto é uma ferramenta de linha de comando (CLI) capaz de processar imagens binárias (formato PBM ASCII) para identificar, contar e classificar objetos.

O sistema simula um cenário de controle de qualidade industrial (ex: fábrica de arruelas), onde é necessário distinguir automaticamente peças **com furos** (aprovadas) de peças **sólidas/defeituosas** (sem furos).

### Funcionalidades

*  **Leitura de PBM:** Suporte nativo ao formato PBM P1 (ASCII).
*  **Padding Automático:** Adição de bordas de segurança para evitar erros de índice (*ArrayIndexOutOfBounds*).
*  **Algoritmo Flood Fill:** Implementação robusta baseada em **Pilha (Stack)** para evitar estouro de memória (StackOverflow) em imagens grandes.
*  **Detecção de Topologia:** Distingue furos reais (fechados) de concavidades (aberturas externas).
*  **Relatório de Performance:** Exibe o tempo de carregamento e processamento em milissegundos.

---

## Estrutura do Projeto

O código segue os princípios de *Clean Code*, separado em classes com responsabilidades únicas:

```text
processamento-de-imagens-ufs/
├── src/
│   └── inspector/
│       ├── Program.java          # Ponto de entrada (Main)
│       ├── BinaryImage.java      # Estrutura de dados (Matriz + Padding)
│       ├── PbmImageLoader.java   # Parser de arquivos PBM
│       ├── ObjectInspector.java  # Lógica Core (Flood Fill e Detecção)
│       └── InspectionResult.java # Record para transporte de dados
├── samples/
│   ├── teste.pbm                 # Arquivo de teste complexo (Letras)
│   ├── simples.pbm               # Teste básico
│   └── varios.pbm                # Múltiplos objetos
└── bin/                          # Arquivos compilados (.class)

```

---

## Como Executar

### Pré-requisitos

* Java JDK 17 ou superior.

### 1. Compilar o Projeto

Abra o terminal na raiz do projeto e execute:

```bash
mkdir -p bin
javac -d bin src/inspector/*.java

```

### 2. Rodar a Inspeção

Execute o programa passando o caminho da imagem PBM como argumento:

```bash
java -cp bin inspector.Program samples/teste.pbm

```

---

## Exemplo de Saída

Ao processar o arquivo `samples/teste.pbm` (que contém as formas das letras A, B e C), o resultado esperado é:

```text
=== SISTEMA DE INSPEÇÃO GENERICSTUFF ===
Arquivo alvo: samples/teste.pbm
Imagem carregada (16x12) em 31 ms.
Iniciando análise de objetos...

Total: 3 | Com Furos: 2 | Sem Furos: 1
Tempo de processamento: 1 ms

```

* **A:** Detectado como *Com Furo*.
* **B:** Detectado como *Com Furo* (múltiplos furos contam como 1 objeto furado).
* **C:** Detectado como *Sem Furo* (a abertura conecta ao fundo externo).

---

## Detalhes Técnicos da Implementação

1. **Padding:** A matriz é criada com dimensões `(H+2, W+2)`. Isso permite que o algoritmo visite as bordas da imagem original sem precisar de `if` complexos para checar limites.
2. **Flood Fill Iterativo:** Em vez de recursão (que falha em imagens grandes), utilizamos uma `Deque<Point>` para controlar a visitação dos pixels.
3. **Lógica de 3 Passos:**
* **Passo 1:** Inundar o fundo externo (partindo de `0,0`) com valor `2`.
* **Passo 2:** Encontrar objetos (valor `1`).
* **Passo 3:** Percorrer o objeto. Se ele tocar em algum vizinho `0` (fundo intocado), significa que existe um buraco interno protegido do fundo externo.



---

## Grupo:
* **Allex Lemos** 
* **Débora Diana** 
* **Guilherme Araujo** 
* **Miguel Lucas** 

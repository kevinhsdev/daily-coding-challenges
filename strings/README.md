# 🔐 1024 — Encryption

![Beecrowd](https://img.shields.io/badge/Beecrowd-1024-blue?style=for-the-badge)
![Linguagem](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Status](https://img.shields.io/badge/Status-Accepted-success?style=for-the-badge)

## 📋 Enunciado

Construir um programa de criptografia simples, capaz de enviar mensagens codificadas sem que alguém consiga lê-las. O processo é dividido em duas partes:

1. **Deslocamento:** cada letra maiúscula ou minúscula deve ser deslocada **3 posições à direita** na tabela ASCII — `a` vira `d`, `y` vira `|`, e assim por diante. Caracteres que não são letras permanecem inalterados.
2. **Inversão e ajuste:** a linha deve ser **invertida**. Depois de invertida, todos os caracteres **da metade (truncada) em diante** devem ser deslocados **1 posição à esquerda** na tabela ASCII — `b` vira `a`, `a` vira `` ` ``.

> Exemplo: se o resultado da primeira parte for `tesla`, as letras `sla` são deslocadas. Se for `t#$A`, apenas `$A` são deslocados.

## 📥 Input

A entrada contém vários casos de teste. A primeira linha de cada caso contém um inteiro **N** (1 ≤ N ≤ 1 × 10⁴), indicando o número de linhas a criptografar. As **N** linhas seguintes contêm **M** caracteres cada (1 ≤ M ≤ 1 × 10³).

## 📤 Output

Para cada entrada, apresentar a mensagem criptografada.

## 🧪 Exemplos

| Entrada | Saída |
| --- | --- |
| `4`<br>`Texto #3`<br>`abcABC1`<br>`vxpdylY .ph`<br>`vv.xwfxo.fd` | `3# rvzgV`<br>`1FECedc`<br>`ks. \n{frzx`<br>`gi.r{hyz-xx` |

## 💡 Lógica utilizada

```text
Passo a passo com a entrada "Texto #3":

1) Deslocar letras em +3 na ASCII
   T e x t o   # 3
   W h { w r   # 3      ->  "Wh{wr #3"

2) Inverter a linha
   "Wh{wr #3"  ->  "3# rw{hW"

3) Do índice length/2 (truncado) em diante, deslocar -1 na ASCII
   comprimento = 8  ->  metade = 4
   "3# r" + "w{hW"  ->  "3# r" + "vzgV"

Resultado: "3# rvzgV"
```

```java
// 1) apenas letras a-z / A-Z sofrem o deslocamento
if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) chars[i] += 3;

// 2) inversão in-place com dois ponteiros
for (int i = 0, j = chars.length - 1; i < j; i++, j--) { /* swap */ }

// 3) segunda metade (truncada) recua 1 posição
for (int i = chars.length / 2; i < chars.length; i++) chars[i] -= 1;
```

**Pontos de atenção:**

- O deslocamento é puramente **ASCII**, sem "dar a volta" no alfabeto: `y + 3` resulta em `|`, não em `b`.
- A metade é **truncada** (divisão inteira), então em `1FEDfed` (7 caracteres) o corte acontece no índice 3.
- Com até 10⁷ caracteres no total, a leitura usa `BufferedReader` e a saída é acumulada em um `StringBuilder` para evitar *Time Limit Exceeded*.
- Trabalhar com `char[]` evita criar várias `String` intermediárias a cada linha.

## ▶️ Como executar

```bash
javac Main.java
java Main < input.txt
```

## 🔗 Fonte

[beecrowd | 1024 — Encryption](https://www.beecrowd.com.br/judge/pt/problems/view/1024)
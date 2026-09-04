# 📅 1020 - Age in Days
 
![Beecrowd](https://img.shields.io/badge/Beecrowd-1020-blue)
![Status](https://img.shields.io/badge/status-Accepted-brightgreen)
 
## 📋 Enunciado
 
Read an integer value corresponding to a person's age (in days) and print it in years, months and days, followed by its respective message "ano(s)", "mes(es)", "dia(s)".
 
Note: only to facilitate the calculation, consider the whole year with 365 days and 30 days every month. In the cases of test there will never be a situation that allows 12 months and some days, like 360, 363 or 364.
 
## 📥 Input
 
O arquivo de entrada contém 1 valor inteiro.
 
## 📤 Output
 
Imprimir a saída conforme exemplo fornecido.
 
## 🧪 Exemplos
 
| Input | Output |
|-------|--------|
| 400 | 1 ano(s)<br>1 mes(es)<br>5 dia(s) |
| 800 | 2 ano(s)<br>2 mes(es)<br>10 dia(s) |
| 30 | 0 ano(s)<br>1 mes(es)<br>0 dia(s) |
 
## 💡 Lógica utilizada
 
Divide-se o total de dias por 365 para obter os anos. O resto dessa divisão é usado para calcular os meses (dividindo por 30) e, por fim, o resto dos meses são os dias restantes.
 
```
anos = dias / 365
meses = (dias % 365) / 30
dias_restantes = (dias % 365) % 30
```
 
## 🔗 Fonte
 
```
beecrowd.com.br/judge/pt/problems/view/1020
```
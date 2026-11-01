# TDD – Cadastro de Produtos (Java)

Atividade de Testes de Software (SENAI – Técnico em Desenvolvimento de Sistemas): classe `Produto`
desenvolvida com TDD (Red → Green → Refactor), Java 17 + Maven + JUnit 5.

## Regras
- Nome não pode ser `null`, vazio ou só com espaços → `IllegalArgumentException("Nome inválido")`.
- Preço deve ser maior que zero e não pode ser `NaN` → `IllegalArgumentException("Preço inválido")`.

## Executar os testes
Requer JDK 17+ e Maven 3.9+.

```bash
mvn test
```

## Estrutura
```
pom.xml
src/main/java/br/com/exemplo/tdd/Produto.java
src/test/java/br/com/exemplo/tdd/ProdutoTest.java
```

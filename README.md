# java-core-practice

Учебный репозиторий фазы 1 (октябрь–ноябрь 2026): задачи на Java Core с тестами, линтером и CI.
Стек: Java 21, Gradle (Kotlin DSL), JUnit 5, AssertJ, Checkstyle, GitHub Actions.

## Как запускать
```bash
./gradlew test        # тесты
./gradlew check       # тесты + Checkstyle
```

## Если сборка не видит JDK 21
`JAVA_HOME` должен указывать на corretto-21 (см. `weeks/week-01.md`), либо в IntelliJ: Settings → Build Tools → Gradle → Gradle JVM = 21.

## Задачи
Пакеты по неделям: `dev.andrej.javacore.weekNN`. Каждая задача — класс + тест.

### Неделя 1
1. `SecondLargest.find(int[] nums)` — второй по величине **среди различных** значений, один проход, O(n), без коллекций.
   Тесты уже написаны (`SecondLargestTest`) — это спецификация. Запусти их, увидь красное, сделай зелёным.
2. `BankAccount` — баланс в `BigDecimal`; методы `deposit`, `withdraw`, `getBalance`;
   `InsufficientFundsException extends RuntimeException` с полями `requested` и `available`;
   отрицательная или нулевая сумма → `IllegalArgumentException`. Тесты пишешь сам, **до** реализации.
3. `Point` в двух вариантах: класс с `equals` без `hashCode` (Checkstyle это запретит — отключи правило точечно
   аннотацией `@SuppressWarnings("checkstyle:EqualsHashCode")` и объясни в комментарии, зачем) и `record Point`.
   Тест: два равных объекта в `HashSet` → какой `size()`? Ответ своими словами — в `notes/interview-qa.md`.

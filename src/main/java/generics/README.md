# Java-Generics

Wild card (?) vs Type (T)

1. Wild card (?) Type cannot be used inside function again, unlike <T>

[wildcard.java](function/WildCard.java){target="_blank"}
<a href="function/WildCard.java" target="_blank" rel="noopener"><span>Example Text</span> </a>.
```java
public static void shout(List<?> shout) {
        System.out.println(shout + "!!!");
    }
```
```java
public static <T> void shout(T shout) {
        T passing = shout;
        System.out.println(passing + "!!!");
    }
```
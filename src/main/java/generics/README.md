# Java-Generics

Wild card (?) vs Type (T)

1. Wild card (?) Type cannot be used inside function again, unlike <T>

[wildcard]Java-Advance/src/main/java/generics/function/WildCard.java
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
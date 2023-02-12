# Java-Generics

Wild card (?) vs Type (T)

1. Wild card (?) Type cannot be used inside function again, unlike Type <T>

[Unbounded ObjectGeneric.java](classes/unbounded_generics/ObjectGeneric.java) </br>
[Unbounded ListGeneric.java](classes/unbounded_generics/ListGeneric.java) </br>
[Bounded ListGenerics.java](classes/bounded_generics/Main.java) </br>
[Unbounded and bounded wildcard.java](function/WildCardMethod.java) </br>

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
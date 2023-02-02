package enum_with_values;

import lombok.Getter;

@Getter
public enum Element {

    H("Hydrogen"), HE("Helium"), NE("Neon");
    public final String label;

    Element(String label) {
        this.label = label;
    }
}

package br.com.serviceportfolio.domain.enums;

public enum StatusCarteiraEnum {

    ATIVA('A'),
    INATIVA('I');

    private final Character value;

    StatusCarteiraEnum(Character value) {
        this.value = value;
    }

    public Character getValue() {
        return value;
    }

    public static StatusCarteiraEnum find(final Character value) {
        for (StatusCarteiraEnum type : StatusCarteiraEnum.values())
            if (type.getValue() == value)
                return type;

        return null;
    }

}

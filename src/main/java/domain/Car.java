package domain;

import java.util.Objects;

public class Car {
    private static final int MIN_NAME_LENGTH = 0;
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private int position = 0;

    public Car(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(final String name) {
        if (Objects.isNull(name) || isValidLength(name)) {
            throw new IllegalArgumentException(String.format("부적절한 이름입니다.: %s", name));
        }
    }

    private boolean isValidLength(final String name) {
        return name.trim().length() <= MIN_NAME_LENGTH || name.trim().length() > MAX_NAME_LENGTH;
    }
}

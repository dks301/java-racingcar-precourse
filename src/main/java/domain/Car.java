package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        if (name == null) {
            throw new IllegalArgumentException("자동차 이름은 null이면 안됩니다.");
        }
        if (name.trim().length() <= 0 || name.trim().length() > 5) {
            throw new IllegalArgumentException("자동차 이름이 1~5글자여야 합니다.");
        }
        this.name = name;
    }

    // 추가 기능 구현
}

package domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    @DisplayName("이름을 가진 자동차가 정상적으로 생성되는지 확인")
    @Test
    void constructorTest() {
        assertThat(new Car("asdf"))
            .isEqualToComparingFieldByField(new Car("asdf"));
    }

    @DisplayName("자동차 이름이 공백인지 확인")
    @Test
    void constructorTest2() {
        assertThatThrownBy(() -> new Car(" "))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("자동차 이름이 1~5글자여야 합니다.");
    }

    @DisplayName("자동차 이름이 1~5글자인지 확인")
    @Test
    void constructorTest3() {
        assertThatThrownBy(() -> new Car("asdfgh"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("자동차 이름이 1~5글자여야 합니다.");
    }

    @DisplayName("자동차 이름이 null이 아닌지 확인")
    @Test
    void constructorTest4() {
        assertThatThrownBy(() -> new Car(null))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("자동차 이름은 null이면 안됩니다.");
    }
}

package baseball.validation;

import java.util.Arrays;

import baseball.property.BaseballGameProperty;

/**
 * @author 민경수
 * @description number range validator
 * @since 2023.10.23
 **********************************************************************************************************************/
public class NumberRangeValidator implements NumberValidator{

  private BaseballGameProperty baseballGameProperty;

  public NumberRangeValidator(BaseballGameProperty baseballGameProperty) {
    this.baseballGameProperty = baseballGameProperty;
  }

  @Override
  public void validate(int[] number) {
    int num = Integer.parseInt(Arrays.stream(number).mapToObj(String::valueOf).reduce("", (a, b) -> a + b));
    if (num <= baseballGameProperty.minimumRange() || num >= baseballGameProperty.maximumRange()) {
      throw new IllegalArgumentException("숫자 범위를 벗어났습니다.");
    }
  }

}
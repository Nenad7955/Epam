package epam;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum change {

    waterChecked("Water: condition changed to true"),
    windChecked("Wind: condition changed to true"),
    selenChecked("metal: value changed to Selen"),
    yellowChecked("Colors: value changed to Yellow"),
    waterUnchecked("Wind: condition changed to false"),
    windUnchecked("Wind: condition changed to true");

    String value;
}

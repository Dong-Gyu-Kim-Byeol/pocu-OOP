package academy.pocu.comp2500.assignment4;

import academy.pocu.comp2500.assignment4.registry.Registry;

public class App {
    public App(Registry registry) {
        // Register like this
        // registry.registerDrawPixelCommandCreator("Foo");
        // OR
        // registry.registerDrawPixelCommandCreator("Foo", "bar");

        registry.registerDrawPixelCommandCreator("DrawPixelCommand"); // : 한 픽셀에 문자 하나를 그리는 커맨드를 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerIncreasePixelCommandCreator("IncreasePixelCommand"); // : 한 픽셀에 있는 문자 값을 1만큼 증가시키는 커맨드를 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerDecreasePixelCommandCreator("DecreasePixelCommand"); // : 한 픽셀에 있는 문자 값을 1만큼 감소시키는 커맨드를 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerToUppercaseCommandCreator("ToUpperCommand"); // : 한 픽셀에 있는 문자를 대문자로 변경하는 커맨드를 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerToLowercaseCommandCreator("ToLowerCommand"); // : 한 픽셀에 있는 문자를 소문자로 변경하는 커맨드를 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerFillHorizontalLineCommandCreator("FillHorizontalLineCommand"); // : 한 행을 같은 문자로 채우는 커맨드를 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerFillVerticalLineCommandCreator("FillVerticalLineCommand"); // : 한 열을 같은 문자로 채우는 커맨드를 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerClearCommandCreator("ClearCommand"); // : 캔버스를 지우는 커맨드를 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
    }
}

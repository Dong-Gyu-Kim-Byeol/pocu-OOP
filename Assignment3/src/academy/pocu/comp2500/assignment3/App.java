package academy.pocu.comp2500.assignment3;

import academy.pocu.comp2500.assignment3.registry.Registry;

public class App {
    public App(Registry registry) {
        // Register like this
        // registry.registerMarineCreator("Foo");
        // OR
        // registry.registerMarineCreator("Foo", "bar");


        registry.registerMarineCreator("Marine"); // : 해병 유닛을 만드는 생성자나 메서드를 등록합니다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerTankCreator("Tank"); // : 전차 유닛을 만드는 생성자나 메서드를 등록합니다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerWraithCreator("Wraith"); // : 망령을 만드는 생성자나 메서드를 등록합니다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerTurretCreator("Turret"); // : 미사일 포탑을 만드는 생성자나 메서드를 등록합니다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerMineCreator("Mine"); // : 지뢰를 만드는 생성자나 메서드를 등록합니다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerSmartMineCreator("SmartMine"); // : 스마트 지뢰를 만드는 생성자나 메서드를 등록합니다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerDestroyerCreator("Destroyer"); // : 파괴자를 만드는 생성자나 메서드를 등록합니다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
    }
}

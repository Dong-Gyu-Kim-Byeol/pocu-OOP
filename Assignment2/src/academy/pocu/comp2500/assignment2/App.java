package academy.pocu.comp2500.assignment2;

import academy.pocu.comp2500.assignment2.registry.Registry;

public class App {
    public App(Registry registry) {
        // register your classes or methods here

//        registry.registerRedStampCreator(); // : 빨강 잉크 스탬프를 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
//        registry.registerBlueStampCreator(); // :파랑 잉크 스탬프를 만드는 생성자나 메서드를 등록한다. 2 개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
//        registry.registerGreenStampCreator(); // :녹색 잉크 스탬프를 만드는 생성자나 메서드를 등록한다. 2 개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
//
//        registry.registerWallCalendarCreator(); // :벽걸이 달력을 만드는 생성자나 메서드를 등록한다. 2 개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
//        registry.registerMagnetCalendarCreator(); // :자석 달력을 만드는 생성자나 메서드를 등록한다. 2 개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
//        registry.registerDeskCalendarCreator(); // :탁상 달력을 만드는 생성자나 메서드를 등록한다. 2 개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
//
//        registry.registerLandscapeBannerCreator(); // :가로 방향 배너를 만드는 생성자나 메서드를 등록한다. 2 개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
//        registry.registerPortraitBannerCreator(); // :세로 방향 배너를 만드는 생성자나 메서드를 등록한다. 2 개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
//
//        registry.registerGlossBannerCreator(); // :반사 배너를 만드는 생성자나 메서드를 등록한다. 2 개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
//        registry.registerScrimBannerCreator(); // :스크림 배너를 만드는 생성자나 메서드를 등록한다. 2 개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
//        registry.registerMeshBannerCreator(); // :메쉬 배너를 만드는 생성자나 메서드를 등록한다. 2 개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
//
//        registry.registerLandscapeBusinessCardCreator(); // :가로 방향 명함을 만드는 생성자나 메서드를 등록한다. 2 개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
//        registry.registerPortraitBusinessCardCreator(); // :세로 방향 명함을 만드는 생성자나 메서드를 등록한다. 2 개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
//
//        registry.registerIvoryBusinessCardCreator(); // :아이보리 종이에 찍는 명함을 만드는 생성자나 메서드를 등록한다. 2 개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
//        registry.registerGrayBusinessCardCreator(); // :회색 종이에 찍는 명함을 만드는 생성자나 메서드를 등록한다. 2 개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
//        registry.registerWhiteBusinessCardCreator(); // :흰색 종이에 찍는 명함을 만드는 생성자나 메서드를 등록한다. 2 개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
//
//        registry.registerLaidBusinessCardCreator(); // :레이드지 인쇄용지에 찍는 명함을 만드는 생성자나 메서드를 등록한다. 2 개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
//        registry.registerLinenBusinessCardCreator(); // :린넨커버 인쇄용지에 찍는 명함을 만드는 생성자나 메서드를 등록한다. 2 개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
//        registry.registerSmoothBusinessCardCreator(); // :스노우지 인쇄용지에 찍는 명함을 만드는 생성자나 메서드를 등록한다. 2 개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
//
//        registry.registerSingleSidedBusinessCardCreator(); // :단면 명함을 만드는 생성자나 메서드를 등록한다. 2 개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
//        registry.registerDoubleSidedBusinessCardCreator(); // :양면 명함을 만드는 생성자나 메서드를 등록한다. 2 개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
//
//        registry.registerCartCreator(); // :장바구니를 만드는 생성자를 등록한다.
//        registry.registerProductAdder(); // :장바구니에 상품을 추가하는 메서드를 등록한다.
//        registry.registerProductRemover(); // :장바구니에서 상품을 제거하는 메서드를 등록한다.
//        registry.registerTotalPriceGetter(); // :장바구니에서 총액을 구해오는 메서드를 등록한다.
//
//        // 문구, 사진
//        registry.registerLandscapeBannerTextApertureAdder(); // :가로 방향 배너에 문구를 추가하는 메서드를 등록한다.
//        registry.registerLandscapeBannerImageApertureAdder(); // :가로 방향 배너에 사진을 추가하는 메서드를 등록한다.
//
//        registry.registerPortraitBannerTextApertureAdder(); // :세로 방향 배너에 문구를 추가하는 메서드를 등록한다.
//        registry.registerPortraitBannerImageApertureAdder(); // :세로 방향 배너에 사진을 추가하는 메서드를 등록한다.
//
//        registry.registerGlossBannerTextApertureAdder(); // :반사 배너에 문구를 추가하는 메서드를 등록한다.
//        registry.registerGlossBannerImageApertureAdder(); // :반사 배너에 사진을 추가하는 메서드를 등록한다.
//
//        registry.registerScrimBannerTextApertureAdder(); // :스크림 배너에 문구를 추가하는 메서드를 등록한다.
//        registry.registerScrimBannerImageApertureAdder(); // :스크림 배너에 사진을 추가하는 메서드를 등록한다.
//
//        registry.registerMeshBannerTextApertureAdder(); // :메쉬 배너에 문구를 추가하는 메서드를 등록한다.
//        registry.registerMeshBannerImageApertureAdder(); // :메쉬 배너에 사진을 추가하는 메서드를 등록한다.
//
//        registry.registerLandscapeBusinessCardTextApertureAdder(); // :가로 방향 명함에 문구를 추가하는 메서드를 등록한다.
//        registry.registerLandscapeBusinessCardImageApertureAdder(); // :가로 방향 명함에 사진을 추가하는 메서드를 등록한다.
//
//        registry.registerPortraitBusinessCardTextApertureAdder(); // :세로 방향 명함에 문구를 추가하는 메서드를 등록한다.
//        registry.registerPortraitBusinessCardImageApertureAdder(); // :세로 방향 명함에 사진을 추가하는 메서드를 등록한다.
//
//        registry.registerIvoryBusinessCardTextApertureAdder(); // :아이보리 종이에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
//        registry.registerIvoryBusinessCardImageApertureAdder(); // :아이보리 종이에 찍는 명함에 사진을 추가하는 메서드를 등록한다.
//
//        registry.registerGrayBusinessCardTextApertureAdder(); // :회색 종이에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
//        registry.registerGrayBusinessCardImageApertureAdder(); // :회색 종이에 찍는 명함에 사진을 추가하는 메서드를 등록한다.
//
//        registry.registerWhiteBusinessCardTextApertureAdder(); // :흰색 종이에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
//        registry.registerWhiteBusinessCardImageApertureAdder(); // :흰색 종이에 찍는 명함에 사진을 추가하는 메서드를 등록한다.
//
//        registry.registerLaidBusinessCardTextApertureAdder(); // :레이드지 인쇄용지에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
//        registry.registerLaidBusinessCardImageApertureAdder(); // :레이드지 인쇄용지에 찍는 명함에 사진을 추가하는 메서드를 등록한다.
//
//        registry.registerLinenBusinessCardTextApertureAdder(); // :린넨커버 인쇄용지에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
//        registry.registerLinenBusinessCardImageApertureAdder(); // :린넨커버 인쇄용지에 찍는 명함에 사진을 추가하는 메서드를 등록한다.
//
//        registry.registerSmoothBusinessCardTextApertureAdder(); // :스노우지 인쇄용지에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
//        registry.registerSmoothBusinessCardImageApertureAdder(); // :스노우지 인쇄용지에 찍는 명함에 사진을 추가하는 메서드를 등록한다.
//
//        registry.registerSingleSidedBusinessCardTextApertureAdder(); // :단면 명함에 문구를 추가하는 메서드를 등록한다.
//        registry.registerSingleSidedBusinessCardImageApertureAdder(); // :단면 명함에 사진을 추가하는 메서드를 등록한다.
//
//        registry.registerDoubleSidedBusinessCardTextApertureAdder(); // :양면 명함에 문구를 추가하는 메서드를 등록한다.
//        registry.registerDoubleSidedBusinessCardImageApertureAdder(); // :양면 명함에 사진을 추가하는 메서드를 등록한다.
    }
}

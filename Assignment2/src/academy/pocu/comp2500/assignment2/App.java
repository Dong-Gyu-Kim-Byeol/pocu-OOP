package academy.pocu.comp2500.assignment2;

import academy.pocu.comp2500.assignment2.registry.Registry;

public class App {
    public App(Registry registry) {
        // register your classes or methods here

        registry.registerRedStampCreator("Stamp"); // : 빨강 잉크 스탬프를 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerBlueStampCreator("Stamp"); // :파랑 잉크 스탬프를 만드는 생성자나 메서드를 등록한다. 2 개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerGreenStampCreator("Stamp"); // :녹색 잉크 스탬프를 만드는 생성자나 메서드를 등록한다. 2 개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.

        registry.registerWallCalendarCreator("Calendar"); // :벽걸이 달력을 만드는 생성자나 메서드를 등록한다. 2 개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerMagnetCalendarCreator("Calendar"); // :자석 달력을 만드는 생성자나 메서드를 등록한다. 2 개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerDeskCalendarCreator("Calendar"); // :탁상 달력을 만드는 생성자나 메서드를 등록한다. 2 개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.

        registry.registerLandscapeBannerCreator("Banner"); // :가로 방향 배너를 만드는 생성자나 메서드를 등록한다. 2 개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerPortraitBannerCreator("Banner"); // :세로 방향 배너를 만드는 생성자나 메서드를 등록한다. 2 개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.

        registry.registerGlossBannerCreator("Banner"); // :반사 배너를 만드는 생성자나 메서드를 등록한다. 2 개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerScrimBannerCreator("Banner"); // :스크림 배너를 만드는 생성자나 메서드를 등록한다. 2 개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerMeshBannerCreator("Banner"); // :메쉬 배너를 만드는 생성자나 메서드를 등록한다. 2 개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.

        registry.registerLandscapeBusinessCardCreator("BusinessCard"); // :가로 방향 명함을 만드는 생성자나 메서드를 등록한다. 2 개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerPortraitBusinessCardCreator("BusinessCard"); // :세로 방향 명함을 만드는 생성자나 메서드를 등록한다. 2 개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.

        registry.registerIvoryBusinessCardCreator("BusinessCard"); // :아이보리 종이에 찍는 명함을 만드는 생성자나 메서드를 등록한다. 2 개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerGrayBusinessCardCreator("BusinessCard"); // :회색 종이에 찍는 명함을 만드는 생성자나 메서드를 등록한다. 2 개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerWhiteBusinessCardCreator("BusinessCard"); // :흰색 종이에 찍는 명함을 만드는 생성자나 메서드를 등록한다. 2 개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.

        registry.registerLaidBusinessCardCreator("BusinessCard"); // :레이드지 인쇄용지에 찍는 명함을 만드는 생성자나 메서드를 등록한다. 2 개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerLinenBusinessCardCreator("BusinessCard"); // :린넨커버 인쇄용지에 찍는 명함을 만드는 생성자나 메서드를 등록한다. 2 개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerSmoothBusinessCardCreator("BusinessCard"); // :스노우지 인쇄용지에 찍는 명함을 만드는 생성자나 메서드를 등록한다. 2 개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.

        registry.registerSingleSidedBusinessCardCreator("BusinessCard"); // :단면 명함을 만드는 생성자나 메서드를 등록한다. 2 개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerDoubleSidedBusinessCardCreator("BusinessCard"); // :양면 명함을 만드는 생성자나 메서드를 등록한다. 2 개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.

        // 장바구니
        registry.registerCartCreator("ShoppingCart"); // :장바구니를 만드는 생성자를 등록한다.
        registry.registerProductAdder("ShoppingCart", "addShipment"); // :장바구니에 상품을 추가하는 메서드를 등록한다.
        registry.registerProductRemover("ShoppingCart", "removeShipment"); // :장바구니에서 상품을 제거하는 메서드를 등록한다.
        registry.registerTotalPriceGetter("ShoppingCart", "getTotalPrice"); // :장바구니에서 총액을 구해오는 메서드를 등록한다.

        // 문구, 사진
        registry.registerLandscapeBannerTextApertureAdder("ProductCanAddTextAndImage", "setText"); // :가로 방향 배너에 문구를 추가하는 메서드를 등록한다.
        registry.registerLandscapeBannerImageApertureAdder("ProductCanAddTextAndImage", "setImage"); // :가로 방향 배너에 사진을 추가하는 메서드를 등록한다.

        registry.registerPortraitBannerTextApertureAdder("ProductCanAddTextAndImage", "setText"); // :세로 방향 배너에 문구를 추가하는 메서드를 등록한다.
        registry.registerPortraitBannerImageApertureAdder("ProductCanAddTextAndImage", "setImage"); // :세로 방향 배너에 사진을 추가하는 메서드를 등록한다.

        registry.registerGlossBannerTextApertureAdder("ProductCanAddTextAndImage", "setText"); // :반사 배너에 문구를 추가하는 메서드를 등록한다.
        registry.registerGlossBannerImageApertureAdder("ProductCanAddTextAndImage", "setImage"); // :반사 배너에 사진을 추가하는 메서드를 등록한다.

        registry.registerScrimBannerTextApertureAdder("ProductCanAddTextAndImage", "setText"); // :스크림 배너에 문구를 추가하는 메서드를 등록한다.
        registry.registerScrimBannerImageApertureAdder("ProductCanAddTextAndImage", "setImage"); // :스크림 배너에 사진을 추가하는 메서드를 등록한다.

        registry.registerMeshBannerTextApertureAdder("ProductCanAddTextAndImage", "setText"); // :메쉬 배너에 문구를 추가하는 메서드를 등록한다.
        registry.registerMeshBannerImageApertureAdder("ProductCanAddTextAndImage", "setImage"); // :메쉬 배너에 사진을 추가하는 메서드를 등록한다.

        registry.registerLandscapeBusinessCardTextApertureAdder("ProductCanAddTextAndImage", "setText"); // :가로 방향 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerLandscapeBusinessCardImageApertureAdder("ProductCanAddTextAndImage", "setImage"); // :가로 방향 명함에 사진을 추가하는 메서드를 등록한다.

        registry.registerPortraitBusinessCardTextApertureAdder("ProductCanAddTextAndImage", "setText"); // :세로 방향 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerPortraitBusinessCardImageApertureAdder("ProductCanAddTextAndImage", "setImage"); // :세로 방향 명함에 사진을 추가하는 메서드를 등록한다.

        registry.registerIvoryBusinessCardTextApertureAdder("ProductCanAddTextAndImage", "setText"); // :아이보리 종이에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerIvoryBusinessCardImageApertureAdder("ProductCanAddTextAndImage", "setImage"); // :아이보리 종이에 찍는 명함에 사진을 추가하는 메서드를 등록한다.

        registry.registerGrayBusinessCardTextApertureAdder("ProductCanAddTextAndImage", "setText"); // :회색 종이에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerGrayBusinessCardImageApertureAdder("ProductCanAddTextAndImage", "setImage"); // :회색 종이에 찍는 명함에 사진을 추가하는 메서드를 등록한다.

        registry.registerWhiteBusinessCardTextApertureAdder("ProductCanAddTextAndImage", "setText"); // :흰색 종이에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerWhiteBusinessCardImageApertureAdder("ProductCanAddTextAndImage", "setImage"); // :흰색 종이에 찍는 명함에 사진을 추가하는 메서드를 등록한다.

        registry.registerLaidBusinessCardTextApertureAdder("ProductCanAddTextAndImage", "setText"); // :레이드지 인쇄용지에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerLaidBusinessCardImageApertureAdder("ProductCanAddTextAndImage", "setImage"); // :레이드지 인쇄용지에 찍는 명함에 사진을 추가하는 메서드를 등록한다.

        registry.registerLinenBusinessCardTextApertureAdder("ProductCanAddTextAndImage", "setText"); // :린넨커버 인쇄용지에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerLinenBusinessCardImageApertureAdder("ProductCanAddTextAndImage", "setImage"); // :린넨커버 인쇄용지에 찍는 명함에 사진을 추가하는 메서드를 등록한다.

        registry.registerSmoothBusinessCardTextApertureAdder("ProductCanAddTextAndImage", "setText"); // :스노우지 인쇄용지에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerSmoothBusinessCardImageApertureAdder("ProductCanAddTextAndImage", "setImage"); // :스노우지 인쇄용지에 찍는 명함에 사진을 추가하는 메서드를 등록한다.

        registry.registerSingleSidedBusinessCardTextApertureAdder("ProductCanAddTextAndImage", "setText"); // :단면 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerSingleSidedBusinessCardImageApertureAdder("ProductCanAddTextAndImage", "setImage"); // :단면 명함에 사진을 추가하는 메서드를 등록한다.

        registry.registerDoubleSidedBusinessCardTextApertureAdder("ProductCanAddTextAndImage", "setText"); // :양면 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerDoubleSidedBusinessCardImageApertureAdder("ProductCanAddTextAndImage", "setImage"); // :양면 명함에 사진을 추가하는 메서드를 등록한다.
    }
}

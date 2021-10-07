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
        registry.registerProductAdder("ShoppingCart", "addProduct"); // :장바구니에 상품을 추가하는 메서드를 등록한다.
        registry.registerProductRemover("ShoppingCart", "removeProduct"); // :장바구니에서 상품을 제거하는 메서드를 등록한다.
        registry.registerTotalPriceGetter("ShoppingCart", "getTotalPrice"); // :장바구니에서 총액을 구해오는 메서드를 등록한다.

        // 문구, 사진
        final String ADD_CLASS = "ProductCanAddApertures";
        final String ADD_TEXT = "addAperture";
        final String ADD_IMAGE = "addAperture";
        registry.registerLandscapeBannerTextApertureAdder(ADD_CLASS, ADD_TEXT); // :가로 방향 배너에 문구를 추가하는 메서드를 등록한다.
        registry.registerLandscapeBannerImageApertureAdder(ADD_CLASS, ADD_IMAGE); // :가로 방향 배너에 사진을 추가하는 메서드를 등록한다.

        registry.registerPortraitBannerTextApertureAdder(ADD_CLASS, ADD_TEXT); // :세로 방향 배너에 문구를 추가하는 메서드를 등록한다.
        registry.registerPortraitBannerImageApertureAdder(ADD_CLASS, ADD_IMAGE); // :세로 방향 배너에 사진을 추가하는 메서드를 등록한다.

        registry.registerGlossBannerTextApertureAdder(ADD_CLASS, ADD_TEXT); // :반사 배너에 문구를 추가하는 메서드를 등록한다.
        registry.registerGlossBannerImageApertureAdder(ADD_CLASS, ADD_IMAGE); // :반사 배너에 사진을 추가하는 메서드를 등록한다.

        registry.registerScrimBannerTextApertureAdder(ADD_CLASS, ADD_TEXT); // :스크림 배너에 문구를 추가하는 메서드를 등록한다.
        registry.registerScrimBannerImageApertureAdder(ADD_CLASS, ADD_IMAGE); // :스크림 배너에 사진을 추가하는 메서드를 등록한다.

        registry.registerMeshBannerTextApertureAdder(ADD_CLASS, ADD_TEXT); // :메쉬 배너에 문구를 추가하는 메서드를 등록한다.
        registry.registerMeshBannerImageApertureAdder(ADD_CLASS, ADD_IMAGE); // :메쉬 배너에 사진을 추가하는 메서드를 등록한다.

        registry.registerLandscapeBusinessCardTextApertureAdder(ADD_CLASS, ADD_TEXT); // :가로 방향 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerLandscapeBusinessCardImageApertureAdder(ADD_CLASS, ADD_IMAGE); // :가로 방향 명함에 사진을 추가하는 메서드를 등록한다.

        registry.registerPortraitBusinessCardTextApertureAdder(ADD_CLASS, ADD_TEXT); // :세로 방향 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerPortraitBusinessCardImageApertureAdder(ADD_CLASS, ADD_IMAGE); // :세로 방향 명함에 사진을 추가하는 메서드를 등록한다.

        registry.registerIvoryBusinessCardTextApertureAdder(ADD_CLASS, ADD_TEXT); // :아이보리 종이에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerIvoryBusinessCardImageApertureAdder(ADD_CLASS, ADD_IMAGE); // :아이보리 종이에 찍는 명함에 사진을 추가하는 메서드를 등록한다.

        registry.registerGrayBusinessCardTextApertureAdder(ADD_CLASS, ADD_TEXT); // :회색 종이에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerGrayBusinessCardImageApertureAdder(ADD_CLASS, ADD_IMAGE); // :회색 종이에 찍는 명함에 사진을 추가하는 메서드를 등록한다.

        registry.registerWhiteBusinessCardTextApertureAdder(ADD_CLASS, ADD_TEXT); // :흰색 종이에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerWhiteBusinessCardImageApertureAdder(ADD_CLASS, ADD_IMAGE); // :흰색 종이에 찍는 명함에 사진을 추가하는 메서드를 등록한다.

        registry.registerLaidBusinessCardTextApertureAdder(ADD_CLASS, ADD_TEXT); // :레이드지 인쇄용지에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerLaidBusinessCardImageApertureAdder(ADD_CLASS, ADD_IMAGE); // :레이드지 인쇄용지에 찍는 명함에 사진을 추가하는 메서드를 등록한다.

        registry.registerLinenBusinessCardTextApertureAdder(ADD_CLASS, ADD_TEXT); // :린넨커버 인쇄용지에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerLinenBusinessCardImageApertureAdder(ADD_CLASS, ADD_IMAGE); // :린넨커버 인쇄용지에 찍는 명함에 사진을 추가하는 메서드를 등록한다.

        registry.registerSmoothBusinessCardTextApertureAdder(ADD_CLASS, ADD_TEXT); // :스노우지 인쇄용지에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerSmoothBusinessCardImageApertureAdder(ADD_CLASS, ADD_IMAGE); // :스노우지 인쇄용지에 찍는 명함에 사진을 추가하는 메서드를 등록한다.

        registry.registerSingleSidedBusinessCardTextApertureAdder(ADD_CLASS, ADD_TEXT); // :단면 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerSingleSidedBusinessCardImageApertureAdder(ADD_CLASS, ADD_IMAGE); // :단면 명함에 사진을 추가하는 메서드를 등록한다.

        registry.registerDoubleSidedBusinessCardTextApertureAdder(ADD_CLASS, ADD_TEXT); // :양면 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerDoubleSidedBusinessCardImageApertureAdder(ADD_CLASS, ADD_IMAGE); // :양면 명함에 사진을 추가하는 메서드를 등록한다.
    }
}

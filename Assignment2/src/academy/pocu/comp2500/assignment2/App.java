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
        final String ADD_TEXT = "addTextAperture";
        final String ADD_IMAGE = "addImageAperture";
        registry.registerLandscapeBannerTextApertureAdder("ProductCanAddTextAndImage", ADD_TEXT); // :가로 방향 배너에 문구를 추가하는 메서드를 등록한다.
        registry.registerLandscapeBannerImageApertureAdder("ProductCanAddTextAndImage", ADD_IMAGE); // :가로 방향 배너에 사진을 추가하는 메서드를 등록한다.

        registry.registerPortraitBannerTextApertureAdder("ProductCanAddTextAndImage", ADD_TEXT); // :세로 방향 배너에 문구를 추가하는 메서드를 등록한다.
        registry.registerPortraitBannerImageApertureAdder("ProductCanAddTextAndImage", ADD_IMAGE); // :세로 방향 배너에 사진을 추가하는 메서드를 등록한다.

        registry.registerGlossBannerTextApertureAdder("ProductCanAddTextAndImage", ADD_TEXT); // :반사 배너에 문구를 추가하는 메서드를 등록한다.
        registry.registerGlossBannerImageApertureAdder("ProductCanAddTextAndImage", ADD_IMAGE); // :반사 배너에 사진을 추가하는 메서드를 등록한다.

        registry.registerScrimBannerTextApertureAdder("ProductCanAddTextAndImage", ADD_TEXT); // :스크림 배너에 문구를 추가하는 메서드를 등록한다.
        registry.registerScrimBannerImageApertureAdder("ProductCanAddTextAndImage", ADD_IMAGE); // :스크림 배너에 사진을 추가하는 메서드를 등록한다.

        registry.registerMeshBannerTextApertureAdder("ProductCanAddTextAndImage", ADD_TEXT); // :메쉬 배너에 문구를 추가하는 메서드를 등록한다.
        registry.registerMeshBannerImageApertureAdder("ProductCanAddTextAndImage", ADD_IMAGE); // :메쉬 배너에 사진을 추가하는 메서드를 등록한다.

        registry.registerLandscapeBusinessCardTextApertureAdder("ProductCanAddTextAndImage", ADD_TEXT); // :가로 방향 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerLandscapeBusinessCardImageApertureAdder("ProductCanAddTextAndImage", ADD_IMAGE); // :가로 방향 명함에 사진을 추가하는 메서드를 등록한다.

        registry.registerPortraitBusinessCardTextApertureAdder("ProductCanAddTextAndImage", ADD_TEXT); // :세로 방향 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerPortraitBusinessCardImageApertureAdder("ProductCanAddTextAndImage", ADD_IMAGE); // :세로 방향 명함에 사진을 추가하는 메서드를 등록한다.

        registry.registerIvoryBusinessCardTextApertureAdder("ProductCanAddTextAndImage", ADD_TEXT); // :아이보리 종이에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerIvoryBusinessCardImageApertureAdder("ProductCanAddTextAndImage", ADD_IMAGE); // :아이보리 종이에 찍는 명함에 사진을 추가하는 메서드를 등록한다.

        registry.registerGrayBusinessCardTextApertureAdder("ProductCanAddTextAndImage", ADD_TEXT); // :회색 종이에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerGrayBusinessCardImageApertureAdder("ProductCanAddTextAndImage", ADD_IMAGE); // :회색 종이에 찍는 명함에 사진을 추가하는 메서드를 등록한다.

        registry.registerWhiteBusinessCardTextApertureAdder("ProductCanAddTextAndImage", ADD_TEXT); // :흰색 종이에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerWhiteBusinessCardImageApertureAdder("ProductCanAddTextAndImage", ADD_IMAGE); // :흰색 종이에 찍는 명함에 사진을 추가하는 메서드를 등록한다.

        registry.registerLaidBusinessCardTextApertureAdder("ProductCanAddTextAndImage", ADD_TEXT); // :레이드지 인쇄용지에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerLaidBusinessCardImageApertureAdder("ProductCanAddTextAndImage", ADD_IMAGE); // :레이드지 인쇄용지에 찍는 명함에 사진을 추가하는 메서드를 등록한다.

        registry.registerLinenBusinessCardTextApertureAdder("ProductCanAddTextAndImage", ADD_TEXT); // :린넨커버 인쇄용지에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerLinenBusinessCardImageApertureAdder("ProductCanAddTextAndImage", ADD_IMAGE); // :린넨커버 인쇄용지에 찍는 명함에 사진을 추가하는 메서드를 등록한다.

        registry.registerSmoothBusinessCardTextApertureAdder("ProductCanAddTextAndImage", ADD_TEXT); // :스노우지 인쇄용지에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerSmoothBusinessCardImageApertureAdder("ProductCanAddTextAndImage", ADD_IMAGE); // :스노우지 인쇄용지에 찍는 명함에 사진을 추가하는 메서드를 등록한다.

        registry.registerSingleSidedBusinessCardTextApertureAdder("ProductCanAddTextAndImage", ADD_TEXT); // :단면 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerSingleSidedBusinessCardImageApertureAdder("ProductCanAddTextAndImage", ADD_IMAGE); // :단면 명함에 사진을 추가하는 메서드를 등록한다.

        registry.registerDoubleSidedBusinessCardTextApertureAdder("ProductCanAddTextAndImage", ADD_TEXT); // :양면 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerDoubleSidedBusinessCardImageApertureAdder("ProductCanAddTextAndImage", ADD_IMAGE); // :양면 명함에 사진을 추가하는 메서드를 등록한다.
    }
}

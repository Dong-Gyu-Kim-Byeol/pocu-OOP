package academy.pocu.comp2500.assignment2.app;

import academy.pocu.comp2500.assignment2.App;
import academy.pocu.comp2500.assignment2.Banner;
import academy.pocu.comp2500.assignment2.BusinessCard;
import academy.pocu.comp2500.assignment2.Calendar;
import academy.pocu.comp2500.assignment2.Color;
import academy.pocu.comp2500.assignment2.EApertureSide;
import academy.pocu.comp2500.assignment2.EBannerSize;
import academy.pocu.comp2500.assignment2.EBannerType;
import academy.pocu.comp2500.assignment2.EBusinessCardColor;
import academy.pocu.comp2500.assignment2.EBusinessCardSide;
import academy.pocu.comp2500.assignment2.EBusinessCardType;
import academy.pocu.comp2500.assignment2.ECalendarType;
import academy.pocu.comp2500.assignment2.EOrientation;
import academy.pocu.comp2500.assignment2.EShippingMethod;
import academy.pocu.comp2500.assignment2.EStampColor;
import academy.pocu.comp2500.assignment2.EStampSize;
import academy.pocu.comp2500.assignment2.ImageAperture;
import academy.pocu.comp2500.assignment2.ShoppingCart;
import academy.pocu.comp2500.assignment2.Stamp;
import academy.pocu.comp2500.assignment2.TextAperture;
import academy.pocu.comp2500.assignment2.registry.Registry;

public class Program {

    public static void main(String[] args) {
        // write your code here
        Registry registry = new Registry();
        App app = new App(registry);
        registry.validate();

        {
            final Stamp redStamp40x30 = new Stamp(EStampSize.MM_40_X_30, EStampColor.RED, "redStamp40x30");

            final ShoppingCart shoppingCart = new ShoppingCart();

            shoppingCart.addProduct(redStamp40x30);
            redStamp40x30.setShippingMethod(EShippingMethod.PICKUP);
            assert redStamp40x30.getShippingMethod() == EShippingMethod.PICKUP;
        }

        {
            Stamp stamp1 = new Stamp(EStampSize.MM_40_X_30, EStampColor.BLUE, "text1");
            assert stamp1.getColor().getRed() == 0;
            assert stamp1.getColor().getGreen() == 0;
            assert stamp1.getColor().getBlue() == 0xff;
            assert stamp1.getSize().getWidth() == 40;
            assert stamp1.getSize().getHeight() == 30;
            assert stamp1.getPrice() == 2300;
            assert stamp1.getText().equals("text1");
        }

        {
            // 하얀색 40 x 40 cm 벽걸이 달력 만들기
            Calendar calendar1 = new Calendar(ECalendarType.WALL);
            assert calendar1.getPrice() == 1000;
            assert calendar1.getCalendarType() == ECalendarType.WALL;
            assert calendar1.getSize().getWidth() == 400;
            assert calendar1.getSize().getHeight() == 400;
            assert calendar1.getColor().getRed() == 0xff;
            assert calendar1.getColor().getGreen() == 0xff;
            assert calendar1.getColor().getBlue() == 0xff;
        }

        {
            Banner bannerGloss1 = new Banner(EBannerType.GLOSS, EBannerSize.MM_1000_X_500, EOrientation.LANDSCAPE, new Color(0x00, 0x80, 0x08));

            bannerGloss1.addAperture(new ImageAperture(EApertureSide.FRONT, 0, 0, "imagePath1"));
            bannerGloss1.addAperture(new ImageAperture(EApertureSide.FRONT, 0, 0, "imagePath2"));
            bannerGloss1.addAperture(new ImageAperture(EApertureSide.FRONT, 300, 300, "imagePath3"));
            bannerGloss1.addAperture(new ImageAperture(EApertureSide.FRONT, 2000, 3000, "imagePath4")); // no
            bannerGloss1.addAperture(new ImageAperture(EApertureSide.BACK, 0, 0, "imagePath5")); // no
            bannerGloss1.addAperture(new ImageAperture(EApertureSide.BACK, 0, 0, "imagePath6")); // no
            bannerGloss1.addAperture(new ImageAperture(EApertureSide.BACK, 300, 300, "imagePath7")); // no
            bannerGloss1.addAperture(new ImageAperture(EApertureSide.BACK, 2000, 3000, "imagePath8")); // no
            bannerGloss1.addAperture(new ImageAperture(EApertureSide.FRONT_AND_BACK, 0, 0, "imagePath9")); // no
            bannerGloss1.addAperture(new ImageAperture(EApertureSide.FRONT_AND_BACK, 0, 0, "imagePath10")); // no
            bannerGloss1.addAperture(new ImageAperture(EApertureSide.FRONT_AND_BACK, 300, 300, "imagePath11")); // no
            bannerGloss1.addAperture(new ImageAperture(EApertureSide.FRONT_AND_BACK, 2000, 3000, "imagePath12")); // no

            bannerGloss1.addAperture(new TextAperture(EApertureSide.FRONT, 0, 0, "text1"));
            bannerGloss1.addAperture(new TextAperture(EApertureSide.FRONT, 0, 0, "text2"));
            bannerGloss1.addAperture(new TextAperture(EApertureSide.FRONT, 300, 300, "text3"));
            bannerGloss1.addAperture(new TextAperture(EApertureSide.FRONT, 2000, 3000, "text4")); // no
            bannerGloss1.addAperture(new TextAperture(EApertureSide.BACK, 0, 0, "text5")); // no
            bannerGloss1.addAperture(new TextAperture(EApertureSide.BACK, 0, 0, "text6")); // no
            bannerGloss1.addAperture(new TextAperture(EApertureSide.BACK, 300, 300, "text7")); // no
            bannerGloss1.addAperture(new TextAperture(EApertureSide.BACK, 2000, 3000, "text8")); // no
            bannerGloss1.addAperture(new TextAperture(EApertureSide.FRONT_AND_BACK, 0, 0, "text9")); // no
            bannerGloss1.addAperture(new TextAperture(EApertureSide.FRONT_AND_BACK, 0, 0, "text10")); // no
            bannerGloss1.addAperture(new TextAperture(EApertureSide.FRONT_AND_BACK, 300, 300, "text11")); // no
            bannerGloss1.addAperture(new TextAperture(EApertureSide.FRONT_AND_BACK, 2000, 3000, "text12")); // no

            assert bannerGloss1.getPrice() == 5030;
            assert bannerGloss1.getColor().getRed() == 0x00;
            assert bannerGloss1.getColor().getGreen() == 0x80;
            assert bannerGloss1.getColor().getBlue() == 0x08;
        }

        {
            BusinessCard businessCardSingle = new BusinessCard(EBusinessCardType.LINEN, EBusinessCardSide.SINGLE, EOrientation.LANDSCAPE, EBusinessCardColor.GRAY);
            assert businessCardSingle.getPrice() == 110;
            assert businessCardSingle.getSize().getWidth() == 90;
            assert businessCardSingle.getSize().getHeight() == 50;
            assert businessCardSingle.getColor().getRed() == 230;
            assert businessCardSingle.getColor().getGreen() == 230;
            assert businessCardSingle.getColor().getBlue() == 230;
            assert businessCardSingle.getSides() == EBusinessCardSide.SINGLE;

            businessCardSingle.addAperture(new ImageAperture(EApertureSide.FRONT, 0, 0, "imagePath1"));
            businessCardSingle.addAperture(new ImageAperture(EApertureSide.FRONT, 0, 0, "imagePath2"));
            businessCardSingle.addAperture(new ImageAperture(EApertureSide.FRONT, 300, 300, "imagePath3")); // no
            businessCardSingle.addAperture(new ImageAperture(EApertureSide.FRONT, 2000, 3000, "imagePath4")); // no
            businessCardSingle.addAperture(new ImageAperture(EApertureSide.BACK, 0, 0, "imagePath5")); // no
            businessCardSingle.addAperture(new ImageAperture(EApertureSide.BACK, 0, 0, "imagePath6")); // no
            businessCardSingle.addAperture(new ImageAperture(EApertureSide.BACK, 300, 300, "imagePath7")); // no
            businessCardSingle.addAperture(new ImageAperture(EApertureSide.BACK, 2000, 3000, "imagePath8")); // no
            businessCardSingle.addAperture(new ImageAperture(EApertureSide.FRONT_AND_BACK, 0, 0, "imagePath9")); // no
            businessCardSingle.addAperture(new ImageAperture(EApertureSide.FRONT_AND_BACK, 0, 0, "imagePath10")); // no
            businessCardSingle.addAperture(new ImageAperture(EApertureSide.FRONT_AND_BACK, 300, 300, "imagePath11")); // no
            businessCardSingle.addAperture(new ImageAperture(EApertureSide.FRONT_AND_BACK, 2000, 3000, "imagePath12")); // no

            businessCardSingle.addAperture(new TextAperture(EApertureSide.FRONT, 0, 0, "text1"));
            businessCardSingle.addAperture(new TextAperture(EApertureSide.FRONT, 0, 0, "text2"));
            businessCardSingle.addAperture(new TextAperture(EApertureSide.FRONT, 300, 300, "text3")); // no
            businessCardSingle.addAperture(new TextAperture(EApertureSide.FRONT, 2000, 3000, "text4")); // no
            businessCardSingle.addAperture(new TextAperture(EApertureSide.BACK, 0, 0, "text5")); // no
            businessCardSingle.addAperture(new TextAperture(EApertureSide.BACK, 0, 0, "text6")); // no
            businessCardSingle.addAperture(new TextAperture(EApertureSide.BACK, 300, 300, "text7")); // no
            businessCardSingle.addAperture(new TextAperture(EApertureSide.BACK, 2000, 3000, "text8")); // no
            businessCardSingle.addAperture(new TextAperture(EApertureSide.FRONT_AND_BACK, 0, 0, "text9")); // no
            businessCardSingle.addAperture(new TextAperture(EApertureSide.FRONT_AND_BACK, 0, 0, "text10")); // no
            businessCardSingle.addAperture(new TextAperture(EApertureSide.FRONT_AND_BACK, 300, 300, "text11")); // no
            businessCardSingle.addAperture(new TextAperture(EApertureSide.FRONT_AND_BACK, 2000, 3000, "text12")); // no

            assert businessCardSingle.getPrice() == 130;
        }

        {
            BusinessCard businessCardDouble = new BusinessCard(EBusinessCardType.LAID, EBusinessCardSide.DOUBLE, EOrientation.PORTRAIT, EBusinessCardColor.IVORY);
            assert businessCardDouble.getPrice() == 150;
            assert businessCardDouble.getSize().getWidth() == 90;
            assert businessCardDouble.getSize().getHeight() == 50;
            assert businessCardDouble.getColor().getRed() == 255;
            assert businessCardDouble.getColor().getGreen() == 255;
            assert businessCardDouble.getColor().getBlue() == 240;
            assert businessCardDouble.getSides() == EBusinessCardSide.DOUBLE;

            businessCardDouble.addAperture(new ImageAperture(EApertureSide.FRONT, 0, 0, "imagePath1"));
            businessCardDouble.addAperture(new ImageAperture(EApertureSide.FRONT, 0, 0, "imagePath2"));
            businessCardDouble.addAperture(new ImageAperture(EApertureSide.FRONT, 300, 300, "imagePath3")); // no
            businessCardDouble.addAperture(new ImageAperture(EApertureSide.FRONT, 2000, 3000, "imagePath4")); // no
            businessCardDouble.addAperture(new ImageAperture(EApertureSide.BACK, 0, 0, "imagePath5"));
            businessCardDouble.addAperture(new ImageAperture(EApertureSide.BACK, 0, 0, "imagePath6"));
            businessCardDouble.addAperture(new ImageAperture(EApertureSide.BACK, 300, 300, "imagePath7")); // no
            businessCardDouble.addAperture(new ImageAperture(EApertureSide.BACK, 2000, 3000, "imagePath8")); // no
            businessCardDouble.addAperture(new ImageAperture(EApertureSide.FRONT_AND_BACK, 0, 0, "imagePath9"));
            businessCardDouble.addAperture(new ImageAperture(EApertureSide.FRONT_AND_BACK, 0, 0, "imagePath10"));
            businessCardDouble.addAperture(new ImageAperture(EApertureSide.FRONT_AND_BACK, 300, 300, "imagePath11")); // no
            businessCardDouble.addAperture(new ImageAperture(EApertureSide.FRONT_AND_BACK, 2000, 3000, "imagePath12")); // no

            businessCardDouble.addAperture(new TextAperture(EApertureSide.FRONT, 0, 0, "text1"));
            businessCardDouble.addAperture(new TextAperture(EApertureSide.FRONT, 0, 0, "text2"));
            businessCardDouble.addAperture(new TextAperture(EApertureSide.FRONT, 300, 300, "text3")); // no
            businessCardDouble.addAperture(new TextAperture(EApertureSide.FRONT, 2000, 3000, "text4")); // no
            businessCardDouble.addAperture(new TextAperture(EApertureSide.BACK, 0, 0, "text5"));
            businessCardDouble.addAperture(new TextAperture(EApertureSide.BACK, 0, 0, "text6"));
            businessCardDouble.addAperture(new TextAperture(EApertureSide.BACK, 300, 300, "text7")); // no
            businessCardDouble.addAperture(new TextAperture(EApertureSide.BACK, 2000, 3000, "text8")); // no
            businessCardDouble.addAperture(new TextAperture(EApertureSide.FRONT_AND_BACK, 0, 0, "text9"));
            businessCardDouble.addAperture(new TextAperture(EApertureSide.FRONT_AND_BACK, 0, 0, "text10"));
            businessCardDouble.addAperture(new TextAperture(EApertureSide.FRONT_AND_BACK, 300, 300, "text11")); // no
            businessCardDouble.addAperture(new TextAperture(EApertureSide.FRONT_AND_BACK, 2000, 3000, "text12")); // no

            assert businessCardDouble.getPrice() == 150 + 12 * 5;
        }
    }

}

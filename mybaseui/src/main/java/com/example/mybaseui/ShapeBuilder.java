package com.example.mybaseui;

import java.io.File;

/*
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="rectangle">
    <solid android:color="#0f0" />
    <size
        android:width="200dp"
        android:height="200dp" />
    <corners
        android:bottomLeftRadius="5dp"
        android:bottomRightRadius="5dp"
        android:radius="10dp"
        android:topLeftRadius="5dp"
        android:topRightRadius="5dp" />
    <stroke
        android:width="1dp"
        android:color="#f00"
        android:dashWidth="30dp"
        android:dashGap="10dp" />
    <gradient
        android:angle="0"
        android:centerColor="#00f"
        android:centerX="0.5"
        android:centerY="0.5"
        android:endColor="#000"
        android:gradientRadius="90"
        android:startColor="fff"
        android:type="linear"
        android:useLevel="false" />
    <padding
        android:bottom="10dp"
        android:left="10dp"
        android:right="10dp"
        android:top="10dp" />
</shape>
*/
class ShapeBuilder extends BaseBuilder {

    private String[] mShapeTypeArray = new String[]{"rectangle", "oval", "line", "ring"};

    // name
    File mFilePath = new File("app/src/main/res/drawable/test.xml");
    // type
    String mShapeType = mShapeTypeArray[0];
    // solid
    String mShapeSolidColor = "#0f0";
    // size
    int mShapeSizeWidth = 20;
    int mShapeSizeHeight = 20;
    // corners
    int mCornerBottomLeft = 5;
    int mCornerBottomRight = 5;
    int mCorner = 5;
    int mCornerTopLeft = 5;
    int mCornerTopRight = 5;

    public static void main(String[] args) {
        ShapeBuilder shapeBuilder = new ShapeBuilder();
        System.out.println(shapeBuilder.mFilePath.getAbsolutePath());

        StringBuilder sb = new StringBuilder();
        sb.append(mXmlSpace).append("\n");
        sb.append("<shape ").append(mAndroidResSpace).append("\n");
        sb.append("\t").append("android:shape=").append("\"").append(shapeBuilder.mShapeType).append("\">").append("\n");
        // solid
        sb.append("\t").append("<solid android:color=").append("\"").append(shapeBuilder.mShapeSolidColor).append("\" />").append("\n");

        // size
        sb.append("\t").append("<size").append("\n");
        sb.append("\t\t").append("android:width=").append("\"").append(shapeBuilder.mShapeSizeWidth).append("dp\"").append("\n");
        sb.append("\t\t").append("android:height=").append("\"").append(shapeBuilder.mShapeSizeHeight).append("dp\" />").append("\n");

        //    <corners
        //        android:bottomLeftRadius="5dp"
        //        android:bottomRightRadius="5dp"
        //        android:radius="10dp"
        //        android:topLeftRadius="5dp"
        //        android:topRightRadius="5dp" />

        sb.append("\t").append("<corners").append("\n");
        sb.append("\t\t").append("android:bottomLeftRadius=").append("\"").append(shapeBuilder.mCornerBottomLeft).append("dp\"").append("\n");
        sb.append("\t\t").append("android:bottomRightRadius=").append("\"").append(shapeBuilder.mCornerBottomRight).append("dp\" />").append("\n");
        sb.append("\t\t").append("android:radius=").append("\"").append(shapeBuilder.mCorner).append("dp\" />").append("\n");
        sb.append("\t\t").append("android:topLeftRadius=").append("\"").append(shapeBuilder.mCornerTopLeft).append("dp\" />").append("\n");
        sb.append("\t\t").append("android:topRightRadius=").append("\"").append(shapeBuilder.mCornerTopRight).append("dp\" />").append("\n");

        sb.append("</shape>");
        System.out.println(sb.toString());
    }
}

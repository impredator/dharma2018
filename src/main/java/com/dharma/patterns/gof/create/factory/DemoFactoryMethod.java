package com.dharma.patterns.gof.create.factory;

interface ImageReader {
    DecodedImage getDecodeImage();
}

class GifReader implements ImageReader {
    private DecodedImage decodedImage;

    GifReader(String image) {
        this.decodedImage = new DecodedImage(image);
    }

    @Override
    public DecodedImage getDecodeImage() {
        return decodedImage;
    }
}

class JpegReader implements ImageReader {
    private DecodedImage decodedImage;

    JpegReader(String image) {
        decodedImage = new DecodedImage(image);
    }

    @Override
    public DecodedImage getDecodeImage() {
        return decodedImage;
    }
}

class PngReader implements ImageReader {
    private DecodedImage decodedImage;

    PngReader(String image) {
        decodedImage = new DecodedImage(image);
    }

    @Override
    public DecodedImage getDecodeImage() {
        return decodedImage;
    }
}

class DecodedImage {
    private String image;

    DecodedImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return image + ": is decoded";
    }
}

class DecodeFactory {
    public static DecodedImage decode(String image) {
        ImageReader reader = null;
        String format = image.substring(image.indexOf('.') + 1, (image.length()));

        switch (format) {
            case "gif":
                reader = new GifReader(image);
                break;
            case "jpeg":
                reader = new JpegReader(image);
                break;
            case "png":
                reader = new PngReader(image);
                break;
        }
        assert reader != null : "参数不正确（gif jpeg）";
        return reader.getDecodeImage();
    }
}

//参数格式：filename.[jepg | gif | png]
public class DemoFactoryMethod {

    public static void main(String[] args) {
        assert args.length > 0: "没有传递参数";
        DecodedImage decodedImage = DecodeFactory.decode(args[0]);
        System.out.println(decodedImage);
    }
}

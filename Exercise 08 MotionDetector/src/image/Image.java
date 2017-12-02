package image;

import java.util.ArrayList;
import java.util.List;

public class Image {

    List<Byte> bytes;

    public Image() {
        bytes = new ArrayList<>();
    }

    public void addBytes (byte [] bytes){
        for (byte b: bytes) {
            this.bytes.add(b);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Image image = (Image) o;

        return bytes.equals(image.bytes);
    }

    @Override
    public int hashCode() {
        return bytes.hashCode();
    }
}

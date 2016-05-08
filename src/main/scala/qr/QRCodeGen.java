package qr;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class QRCodeGen {
    public static byte[] gen(String msg) throws IOException {
        File file = QRCode.from(msg).to(ImageType.JPG).file();
        return Files.readAllBytes(file.toPath());
    }
}

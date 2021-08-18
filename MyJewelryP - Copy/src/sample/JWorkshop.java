package sample;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public abstract class JWorkshop {
    public abstract void subtraction(String choice , double sumResult);
    public abstract String total();
    public void openWebPage() throws URISyntaxException, IOException {

        Desktop d = Desktop.getDesktop();
        d.browse(new URI("https://goldprice.org/live-gold-price.html"));
    }
}




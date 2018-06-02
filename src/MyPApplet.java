import processing.core.PApplet;
import processing.core.PImage;

public class MyPApplet extends PApplet {
    private String URL = "http://1024x600.ru/947-3/1024x600_ru+-+Sun+over+sea.jpg";
    private PImage backgroundImg;

    public void setup() {
        size( 1024, 600 );
        backgroundImg = loadImage( URL, "jpg" );
    }

    public void draw() {
        backgroundImg.resize( 0, height );
        image( backgroundImg, 0, 0 );
        int[] color = sunColorSec( second() );
        fill( color[0], color[1], color[2] );
        ellipse( width / 2, height / 4, width / 5, height / 3 );
    }

    public int[] sunColorSec(float seconds) {
        int[] rgb = new int[3]; //array na 3 wartosci rgb
        float diffFrom30 = Math.abs( 30 - seconds ); //wartosc absolutna roznicy miedzy aktualnym czasem(pobieranym przez seconds()
        // a czasem odswiezania  czyli 30
        float ratio = diffFrom30 / 30;            //im blizej 30 tym slonce jasniejsze
        rgb[0] = (int) (255 * ratio);              //
        rgb[1] = (int) (255 * ratio);
        rgb[2] = 0;
        return rgb;   //zwraca array rgb metodzie sunColorSec
    }
}

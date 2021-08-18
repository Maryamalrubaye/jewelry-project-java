package sample;

public enum Wages {

        Handmade(4.3f),
        Laser(4.5f),
        Polish(2.5f),
        Professional(5f),
        Special(5.5f);
        float v;

        Wages() {
        }


        Wages(float vi) {
            v = vi;
        }

    }


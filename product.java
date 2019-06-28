package cn.edu.gdpt.iterpretsdreams;

import android.widget.Button;

public class product {
    private int idlogo;
    private String name;
    public product( int idlogo, String name) {
        super();
        this.idlogo = idlogo;
        this.name = name;
    }

    public int getIdlogo() {
        return idlogo;
    }

    public void setIdlogo(int idlogo) {
        this.idlogo = idlogo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

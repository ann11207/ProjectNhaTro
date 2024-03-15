package com.example.projectnhatro;

import android.widget.Button;

import java.io.Serializable;

public class  Product implements Serializable {





    private int resourceImage;
    private String name;

    public Product(int resourceImage, String name) {
        this.resourceImage = resourceImage;
        this.name = name;
    }

    public int getResourceImage() {
        return resourceImage;
    }

    public void setResourceImage(int resourceImage) {
        this.resourceImage = resourceImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

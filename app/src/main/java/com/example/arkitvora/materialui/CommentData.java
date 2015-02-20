package com.example.arkitvora.materialui;

/**
 * Created by kavyajain on 20/02/15.
 */
public class CommentData {
    String name;
    String text;
    int image;

    public CommentData(String name, String tweetbody, int image) {
        this.name = name;
        this.text = tweetbody;
        this.image = image;

}


    public String getName() {
        return name;
    }


    public String getText() {
        return text;
    }

    public int getimage() { return image;}
}

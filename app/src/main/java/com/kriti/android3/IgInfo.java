package com.kriti.android3;

public class IgInfo
{
    int images[] = {R.drawable.changmin, R.drawable.changmin_two, R.drawable.jungwon, R.drawable.juyeon,
    R.drawable.kun, R.drawable.meme, R.drawable.sunwoo, R.drawable.sunwoo_two, R.drawable.younghoon};

    boolean liked;
    int image;

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int i) {
        this.image = images[i];
    }
}

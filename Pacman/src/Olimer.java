/**
 * Created by sunjae_lee on 3/16/17.
 */
import java.awt.*;
public class Olimer extends Sprite {
    private boolean isDead;

    public Olimer() {
        super(500, 550, NORTH);
        setPic("Olimer.png", NORTH);
        //moves the height of the image.
        setSpeed(this.getBoundingRectangle().height);

    }


    //@Override some methods...
    @Override
    public void update() {
        if (!isDead)

            super.update();
        else {
            getDead();
            setDead(true);

        }
        if (getLoc().getX() == 0) {
            setLoc(new Point(500, 550));

        } else if (getLoc().getX() >= ProjectPanel.FRAMEWIDTH) {
            setLoc(new Point(500, 550));
        }
    }

    public void setDead(boolean d) {
        isDead = d;
    }

    public boolean getDead() {
        return isDead;
    }

    public int getX() {
        return getLoc().x;
    }

    public int getY() {
        return getLoc().y;
    }


}


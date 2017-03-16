/**
 * Created by sunjae_lee on 3/16/17.
 */
import java.awt.*;
public class Olimer extends Sprite {
    private boolean isDead;

    public Olimer() {
        super(500, 550, NORTH);
        setPic("OlimerLeft.png", NORTH);
        //moves the height of the image.
        setSpeed(this.getBoundingRectangle().height);

    }

    //@Override some methods...
    public void setDead(boolean d) {
        isDead = d;
    }

    public boolean getDead() {
        return isDead;
    }

    @Override
    public void update() {
        if (!isDead)

            super.update();
        else {
            getDead();
            setDead(true);

        }
        if (getLoc().getX() < 0) {
            setLoc(new Point(ProjectPanel.FRAMEWIDTH, getLoc().y));

        } else if (getLoc().getX() > ProjectPanel.FRAMEWIDTH) {
            setLoc(new Point(0, getLoc().y));
        }
        if (getLoc().getY() < 0) {
            setLoc(new Point(getLoc().x, ProjectPanel.FRAMEHEIGHT));

        } else if (getLoc().getY() > ProjectPanel.FRAMEHEIGHT) {
            setLoc(new Point(getLoc().x, ProjectPanel.FRAMEHEIGHT));
        }
    }

    public int getX() {
        return getLoc().x;
    }

    public int getY() {
        return getLoc().y;
    }

}



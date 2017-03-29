/**
 * Created by sunjae_lee on 3/16/17.
 */
import java.awt.*;
public class Olimer extends Sprite {
    private boolean isDead;
    private PacManGrid grid;

    public Olimer(PacManGrid grid) {
        super(100, 300, NORTH);
        setPic("AshLeft.png", NORTH);
        //moves the height of the image.
//        setSpeed(this.getBoundingRectangle().height);
        setSpeed(4);
        this.grid = grid;

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
        if (!isDead) {

            boolean move = true;
            int dx = (int) (Math.cos(Math.toRadians(getDir())) * getSpeed());
            int dy = -(int) (Math.sin(Math.toRadians(getDir())) * getSpeed());
            Point temp = new Point(getCenterPoint());
            temp.translate(dx, dy);

            for(Rectangle[] row: grid.getRects()){
                for(Rectangle rect: row){
                    if(rect != null && rect.contains(temp))
                        move = false;
                }
            }
//            if(temp is inside a wall...)
            if(move)
                super.update();
        }
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

//    @Override
//    public Rectangle getBoundingRectangle() {
//        Rectangle r = super.getBoundingRectangle();
//        r.setSize(r.width-2, r.height-2);
//        return r;
//    }



}



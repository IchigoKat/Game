/**
 * Created by sunjae_lee on 3/16/17.
 */
import java.awt.*;
public class Monster extends Sprite {
    private boolean isDead;

    public Monster(int x,int y){
        super(x,y,EAST);
        setPic("PikaLeft.png", NORTH);
    }

    public void setDead(boolean d) {
        isDead = d;
    }

    public boolean getDead() {
        return isDead;
    }
    @Override



    public void update() {
        if(!isDead){
//            if(getTarget().intersects(this) && getTarget() instanceof Zombie && !getTarget().equals(this)){
//                Point loc = getTarget().getLoc();
//                getWorld().removeSprite(getTarget());
//                Chaser zombie = new Zombie(loc.x, loc.y, getWorld());
//                getWorld().addSprite(zombie);
//                pickTarget();
//
//            }
//            if(getTarget() instanceof Zombie) {
//                setTarget(this);
//            }

            super.update();
        }
        if (getLoc().getX() + 130 <= 0)
            setLoc(new Point(ProjectPanel.FRAMEWIDTH, (int) getLoc().getY()));
        else if (getLoc().getX() - 130 >= ProjectPanel.FRAMEWIDTH)
            setLoc(new Point(0, (int) getLoc().getY()));


    }

}

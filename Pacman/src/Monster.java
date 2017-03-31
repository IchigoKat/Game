/**
 * Created by sunjae_lee on 3/16/17.
 */
import java.awt.*;
public class Monster extends Sprite {
    private boolean isDead;
    private Sprite target;
    private PacManGrid grid;

    public Monster(int x,int y, ProjectPanel panel,PacManGrid grid){
        super(x,y,EAST);
        setPic("PikaLeft.png",NORTH);
        target= panel.target();
        this.grid=grid;
        setSpeed(3);
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
            int d=this.getDirection(this.getLoc(),target.getLoc());
            setDir(d);
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
    public int getDirection(Point from, Point to){
        double dx = to.x - from.x;
        double dy = from.y - to.y;
        int deg =  (int)Math.toDegrees(Math.atan(dy/dx));
        if(to.x < from.x)
            deg += 180;
        return deg;
    }

}

/**
 * Created by sunjae_lee on 3/16/17.
 */
import java.awt.*;
public class Monster extends Sprite {
    private boolean isDead;
    private Sprite target;
    private PacManGrid grid;

    public Monster(int x,int y, ProjectPanel panel,PacManGrid grid){
        super(x,y,NORTH);
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
        if(getLoc().x > 255 && getLoc().x<435 && getLoc().y>270 && getLoc().y<345)
            setDir(NORTH);
        if (!isDead) {

            boolean move = true;
            int dxx = (int) (Math.cos(Math.toRadians(getDir())) * getSpeed());
            int dyy = -(int) (Math.sin(Math.toRadians(getDir())) * getSpeed());
            int dx = (this.getX() - target.getX()) * getSpeed();
            int dy = (this.getY() - target.getY()) * getSpeed();


//move =false?

            Point temp = new Point(getCenterPoint());

            temp.translate(dxx, 0);

            temp.translate(0, dyy);

            for (Rectangle[] row : grid.getRects()) {
                for (Rectangle rect : row) {
                    if (rect != null && rect.contains(temp))
                        move = false;
                }
            }


            if (move==false) {
                if (this.getDir() == Sprite.NORTH || this.getDir() == Sprite.SOUTH) {
                    if (dx > 0) {
                        setDir(Sprite.WEST);
                        setPic("PikaLeft.png", WEST);
                    }
                    else {

                        setDir(Sprite.EAST);
                        setPic("PikaRight.png", EAST);
                    }
                } else if (this.getDir() == Sprite.EAST || this.getDir() == Sprite.WEST) {
                    if (dy > 0) {
                        setDir(Sprite.NORTH);
                        setPic("PikaFront.png", NORTH);
                    }
                    else {

                        setDir(Sprite.SOUTH);
                        setPic("PikaFront.png", SOUTH);
                    }

                }
            }
//            if(temp is inside a wall...)
            if (move){
                if(target.getX()-5<this.getX() && target.getX()+5>this.getX() && Math.abs(target.getY()-this.getY())<=100){
                    if(dy>0){
                        setDir(Sprite.NORTH);
                        setPic("PikaFront.png", NORTH);

                    }else{
                        setDir(Sprite.SOUTH);
                        setPic("PikaFront.png", SOUTH);

                    }
                }
                if(target.getY()-3>this.getY() && target.getY()+3<this.getY() && Math.abs(target.getX()-this.getX())<=100){
                    if(dx>0){

                    setDir(Sprite.WEST);
                    setPic("PikaLeft.png", WEST);

                }else{
                    setDir(Sprite.EAST);
                    setPic("PikaRight.png", EAST);
                }
                }
                super.update();
            }


        } else {
            getDead();
            setDead(true);

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

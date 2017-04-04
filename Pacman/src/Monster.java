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

            boolean move = true;
            int dxx = (int) (Math.cos(Math.toRadians(getDir())) * getSpeed());
            int dyy = -(int) (Math.sin(Math.toRadians(getDir())) * getSpeed());
            int dx= (this.getX()-target.getX())*getSpeed();
            int dy= (this.getY()-target.getY())*getSpeed();
//move =false?
            if(dx<0){
                setDir(Sprite.EAST);
                setPic("PikaLeft.png",EAST);
                if(dy>0){
                    setDir(Sprite.NORTH);

                }
                if(dy<0){
                    setDir(Sprite.SOUTH);
                    setPic("PikaLeft.png",SOUTH);
                }
            }
            if(dx>0){
                setDir(Sprite.WEST);
                setPic("PikaLeft.png",WEST);

                if(dy>0){
                    setDir(Sprite.NORTH);
                    setPic("PikaLeft.png",NORTH);
                }
                if(dy<0){
                    setDir(Sprite.SOUTH);
                    setPic("PikaLeft.png",SOUTH);
                }
            }



            Point temp = new Point(getCenterPoint());
            temp.translate(dxx, 0);
            temp.translate(0,dyy);

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

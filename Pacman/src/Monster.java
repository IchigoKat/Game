/**
 * Created by sunjae_lee on 3/16/17.
 */
import java.awt.*;
public class Monster extends Sprite {

    public Monster(int x,int y){
        super(x,y,EAST);
    }

    @Override

    public void update() {
        if (getLoc().getX() + 130 <= 0)
            setLoc(new Point(ProjectPanel.FRAMEWIDTH, (int) getLoc().getY()));
        else if (getLoc().getX() - 130 >= ProjectPanel.FRAMEWIDTH)
            setLoc(new Point(0, (int) getLoc().getY()));

        super.update();
    }

}

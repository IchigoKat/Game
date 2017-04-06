/**
 * Created by sunjae_lee on 3/15/17.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class ProjectPanel extends JPanel {
    public static final int FRAMEWIDTH = 691, FRAMEHEIGHT = 670;
    private Timer timer;
    private boolean[] keys;
    private Ash ash;
    private ArrayList<Sprite> monster, poke;

    private PacManGrid gr;

    public ProjectPanel() {
        System.out.println();
        keys = new boolean[512];
        gr = new PacManGrid();
        ash = new Ash(gr);
        monster = new ArrayList<Sprite>();
        poke = new ArrayList<Sprite>();
            poke.add(new Pokeball(42, 28));
            poke.add(new Pokeball(303, 28));
            poke.add(new Pokeball(564, 28));
            poke.add(new Pokeball(825, 28));
        monster.add(new Monster(330,300,this,gr));

        timer = new Timer(40, new ActionListener() {



            public void actionPerformed(ActionEvent actionEvent) {

                //move the frog
                if (keys[KeyEvent.VK_UP]) {

                    ash.setPic("AshFront.png", Sprite.NORTH);

                    ash.setDir(Sprite.NORTH);
                    keys[KeyEvent.VK_UP] = false; //probably.
                }
                if (keys[KeyEvent.VK_LEFT]) {
                    ash.setPic("AshLeft.png", Sprite.WEST);
                    ash.setDir(Sprite.WEST);

                    keys[KeyEvent.VK_LEFT] = false;
                }
                if (keys[KeyEvent.VK_RIGHT]) {
                    ash.setPic("AshRight.png", Sprite.EAST);
                    ash.setDir(Sprite.EAST);


                    keys[KeyEvent.VK_RIGHT] = false;
                }
                if (keys[KeyEvent.VK_DOWN]) {

                    ash.setPic("AshFront.png", Sprite.SOUTH);

                    ash.setDir(Sprite.SOUTH);

                    keys[KeyEvent.VK_DOWN] = false;
                }
                ash.update();

                for (int i = 0; i < monster.size(); i++) {
                    monster.get(i).update();
//                    if (monster.get(i).intersects(Oli) == true ) {
//                        Oli.setDead(true);
//                    }
                }

        repaint();
            }
          //  repaint();
        });
        timer.start();



        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {

            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                keys[keyEvent.getKeyCode()] = true;
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                keys[keyEvent.getKeyCode()] = false;
            }
        });

    }
    public Sprite target(){
        return ash;
    }
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Color blue = new Color (193, 157, 85);
        g2.setPaint(blue);
        g2.fillRect(0,0,FRAMEWIDTH,FRAMEHEIGHT);
        for (Sprite p : poke) {
            p.draw(g2);
        }
        for(Sprite s: monster) {
            s.draw(g2);
        }
        ash.draw(g2);
        gr.dra(g2);
    }
    public static void main(String[] args) {
        int w = 420;
        int h = 550;
        JFrame window = new JFrame("");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(500, 0, w, h);

        ProjectPanel panel = new ProjectPanel();
        panel.setSize(FRAMEWIDTH,FRAMEHEIGHT);
        panel.setFocusable(true);
        panel.grabFocus();


        window.add(panel);
        window.setVisible(true);
        window.setResizable(false);
        window.setSize(FRAMEWIDTH, FRAMEHEIGHT);

    }
}
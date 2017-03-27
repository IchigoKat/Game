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
    private Olimer Oli;
    private ArrayList<Sprite> monster;

    private PacManGrid gr;

    public ProjectPanel() {
        keys = new boolean[512];
        Oli = new Olimer(gr);
        monster = new ArrayList<Sprite>();
        gr = new PacManGrid();

        timer = new Timer(40, new ActionListener() {



            public void actionPerformed(ActionEvent actionEvent) {

                //move the frog
                if (keys[KeyEvent.VK_UP]) {

                    Oli.setPic("OlimerLeft.png", Sprite.NORTH);

                    Oli.update();
                    Oli.setDir(Sprite.NORTH);
                    keys[KeyEvent.VK_UP] = false; //probably.
                }
                if (keys[KeyEvent.VK_LEFT]) {
                    Oli.setPic("OlimerLeft.png", Sprite.NORTH);
                    Oli.setDir(Sprite.WEST);
                    Oli.update();
                    Oli.setDir(Sprite.NORTH);
                    keys[KeyEvent.VK_LEFT] = false;
                }
                if (keys[KeyEvent.VK_RIGHT]) {
                    Oli.setPic("OlimerRight.png", Sprite.NORTH);
                    Oli.setDir(Sprite.EAST);
                    Oli.update();
                    Oli.setDir(Sprite.NORTH);
                    keys[KeyEvent.VK_RIGHT] = false;
                }
                if (keys[KeyEvent.VK_DOWN]) {

                    Oli.setPic("OlimerLeft.png", Sprite.NORTH);

                    Oli.setDir(Sprite.SOUTH);
                    Oli.update();
                    Oli.setDir(Sprite.NORTH);
                    keys[KeyEvent.VK_DOWN] = false;
                }

                for (int i = 0; i < monster.size(); i++) {
                    monster.get(i).update();
                    if (monster.get(i).intersects(Oli) == true ) {
                        Oli.setDead(true);
                    }
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
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Color blue = new Color (116, 193, 159);
        g2.setPaint(blue);
        g2.fillRect(0,0,FRAMEWIDTH,FRAMEHEIGHT);
        Oli.draw(g2);
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
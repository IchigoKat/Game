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
    public static final int FRAMEWIDTH = 420, FRAMEHEIGHT = 550;
    private Timer timer;
    private boolean[] keys;
    private Olimer Oli;
    private ArrayList<Sprite> monster;

    public ProjectPanel() {
        keys = new boolean[512];
        Oli = new Olimer();
        monster = new ArrayList<Sprite>();

        timer = new Timer(40, new ActionListener() {




            public void actionPerformed(ActionEvent actionEvent) {

                //move the frog
                if (keys[KeyEvent.VK_W]) {


                    keys[KeyEvent.VK_W] = false; //probably.
                }
                if (keys[KeyEvent.VK_A]) {
                    Oli.setPic("OlimerLeft.png", Sprite.NORTH);
                    keys[KeyEvent.VK_A] = false;
                }
                if (keys[KeyEvent.VK_D]) {
                    Oli.setPic("OlimerRight.png", Sprite.NORTH);
                    keys[KeyEvent.VK_D] = false;
                }
                if (keys[KeyEvent.VK_S]) {


                    keys[KeyEvent.VK_S] = false;
                }

                for (int i = 0; i < monster.size(); i++) {
                    monster.get(i).update();
                    if (monster.get(i).intersects(Oli) == true ) {
                        Oli.setDead(true);
                    }
                }


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
        Oli.draw(g2);
        g2.fillRect(0,0,FRAMEWIDTH,FRAMEHEIGHT);
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
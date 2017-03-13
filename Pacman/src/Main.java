/**
 * Created by sheryl_chin + Sunjae_Lee on 3/13/17.
 */
 import javax.swing.*;

        public class Main extends JFrame {

            public static void main(String[] args) {
                int w = 420;
                int h = 550;
                JFrame window = new JFrame("");
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                window.setBounds(500, 0, w, h); //(x, y, w, h)

                ProjectPanel panel = new ProjectPanel(w,h);
                panel.setFocusable(true);
                panel.grabFocus();
                window.add(panel);
                window.setVisible(true);


            }

        }
    }
}

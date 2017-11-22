
package townplan;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class Muen extends Panel{

    public enum State{
        init, running;
    }

    State state;
    Panel muens,muen1,muen2,toolp,toolh,tools,toolg,toolv;;
    
    
    Muen()
    {
        state = State.init;
        this.setBackground(Color.ORANGE);
        this.setLayout(new BorderLayout());
        muens = new Panel(new GridLayout(6,1));
        muen1 = new Panel(new BorderLayout());
        muen2 = new Panel(new BorderLayout());
        toolp = new Panel(new GridLayout(9,1));
        toolh = new Panel(new GridLayout(9,1));
        tools = new Panel(new GridLayout(9,1));
        toolg = new Panel(new GridLayout(9,1));
        toolv = new Panel(new GridLayout(9,1));
        toolp.setBackground(Color.white);
        tools.setBackground(Color.WHITE);
        toolv.setBackground(Color.WHITE);
        toolg.setBackground(Color.WHITE);
        toolh.setBackground(Color.white);
        this.add(muens, BorderLayout.EAST);
        this.add(muen1, BorderLayout.WEST);
        this.add(muen2, BorderLayout.CENTER);
        muen1.add(toolp, BorderLayout.EAST);
        muen1.add(toolh, BorderLayout.WEST);
        muen1.add(tools, BorderLayout.CENTER);
        muen2.add(toolg, BorderLayout.WEST);
        muen2.add(toolv, BorderLayout.CENTER);
        state = State.running;
    }

    void add(JButton b)
    {
        muens.add(b);
    }

    void addP(JButton b)
    {
        toolp.add(b);

    }

    void addH(JButton b)
    {
        toolh.add(b);

    }

    void addS(JButton b)
    {
        tools.add(b);

    }
    void addG(JButton b)
    {
        toolg.add(b);

    }
    void addV(JButton b)
    {
        toolv.add(b);

    }

}

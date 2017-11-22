
package townplan;
import java.awt.*;

//工具列
public class ToolBar extends Panel{

    public enum State{
        init, running;
    }

    State state;

    Panel tools;

    ToolBar()
    {
        state = State.init;
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(new GridLayout(1,9));
        //tools = new Panel(new GridLayout(1,9));
        //this.add(tools, BorderLayout.WEST);
        state = State.running;
    }

    void add(Button b)
    {
        //tools.add(b);
        this.add(b);
    }


}


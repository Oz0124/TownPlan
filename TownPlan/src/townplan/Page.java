
package townplan;

import java.awt.*;
import java.awt.event.*;


//頁面
public class Page extends Panel
{

    public enum State{
        actived,inactived,ready2creat,creating;
    }

    State state=State.actived;

    static int a=0;
    int s=10;
    int x1, y1, x2=-1 ,y2=-1;
    TownPlan parent;
    MyObject activeObject=null;
    Image back;
    public String filename;
    Point start, stop;
    MyObject temp;
    boolean line=false;
    

    Page(TownPlan op)
    {
        parent = op;
        Toolkit toolkit=Toolkit.getDefaultToolkit();
        //back=toolkit.getImage("background/green.jpg");
        this.setBackground(Color.GREEN);
        this.setLayout(null);
        update();
       
        this.addMouseListener( new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(activeObject!=null)
                {
                    activeObject.hide8Points();
                }
            }
            public void mousePressed(MouseEvent e)
            {
                if(Page.this.state == Page.State.ready2creat)
                {
                    start = new Point(e.getX(), e.getY());
                    Page.this.state = Page.State.creating;
                }
                System.out.println("mousePressed");
            }
            public void mouseReleased(MouseEvent e)
            {

                System.out.println("mouseReleased");
                if(Page.this.state == Page.State.creating)
                {
                    stop =  new Point(e.getX(), e.getY());
                    if((stop.x>start.x)&&(stop.y>start.y))
                    {
                        if((stop.x-start.x)<27)
                        {
                            stop.x=start.x+30;
                        }
                        if((stop.y-start.y)<27)
                        {
                            stop.y=start.y+30;
                        }
                    }
                    else if((stop.x<start.x)&&(stop.y<start.y))
                    {
                        if((start.x-stop.x)<27)
                        {
                            stop.x=start.x-30;
                        }
                        if((start.y-stop.y)<27)
                        {
                            stop.y=start.y-30;
                        }
                    }
                    else if((stop.x<start.x)&&(stop.y>start.y))
                    {
                        if((start.x-stop.x)<27)
                        {
                            stop.x=start.x-30;
                        }
                        if((stop.y-start.y)<27)
                        {
                            stop.y=start.y+30;
                        }
                    }
                    else if((stop.x>start.x)&&(stop.y<start.y))
                    {
                        if((stop.x-start.x)<27)
                        {
                            stop.x=start.x+30;
                        }
                        if((start.y-stop.y)<27)
                        {
                            stop.y=start.y-30;
                        }
                    }
                    temp = new MyObject(Page.this,parent.pic);
                    if((stop.x>start.x)&&(stop.y>start.y)){
                        temp.setLocation(start.x, start.y);
                        temp.setSize((stop.x-start.x),(stop.y-start.y));
                    }
                    else if((stop.x<start.x)&&(stop.y<start.y)){
                        temp.setLocation(stop.x, stop.y);
                        temp.setSize((start.x-stop.x),(start.y-stop.y));
                    }
                    else if((stop.x<start.x)&&(stop.y>start.y)){
                        temp.setLocation(stop.x, start.y);
                        temp.setSize((start.x-stop.x),(stop.y-start.y));
                    }
                    else if((stop.x>start.x)&&(stop.y<start.y)){
                        temp.setLocation(start.x, stop.y);
                        temp.setSize((stop.x-start.x),(start.y-stop.y));
                    }
                    
                    if((stop.x!=start.x)&&(stop.y!=start.y))
                    {
                        Page.this.add(temp);
                        temp.show8Points();
                        start.x=0;
                        start.y=0;
                        stop.x=0;
                        stop.y=0;
                        update();
                    }
                  
                    Page.this.state = Page.State.ready2creat;
                }
                
                
            }
        }
        );

        this.addMouseMotionListener(new MouseMotionAdapter()
        {
            public void mouseDragged(MouseEvent e)
            {
                if(Page.this.state == Page.State.creating)
                {
                    stop =  new Point(e.getX(), e.getY());
                    if((stop.x>start.x)&&(stop.y>start.y))
                    {
                        if((stop.x-start.x)<27)
                        {
                            stop.x=start.x+30;
                        }
                        if((stop.y-start.y)<27)
                        {
                            stop.y=start.y+30;
                        }
                    }
                    else if((stop.x<start.x)&&(stop.y<start.y))
                    {
                        if((start.x-stop.x)<27)
                        {
                            stop.x=start.x-30;
                        }
                        if((start.y-stop.y)<27)
                        {
                            stop.y=start.y-30;
                        }
                    }
                    else if((stop.x<start.x)&&(stop.y>start.y))
                    {
                        if((start.x-stop.x)<27)
                        {
                            stop.x=start.x-30;
                        }
                        if((stop.y-start.y)<27)
                        {
                            stop.y=start.y+30;
                        }
                    }
                    else if((stop.x>start.x)&&(stop.y<start.y))
                    {
                        if((stop.x-start.x)<27)
                        {
                            stop.x=start.x+30;
                        }
                        if((start.y-stop.y)<27)
                        {
                            stop.y=start.y-30;
                        }
                    }
                    update();

                    System.out.println("mouseDragged");
                }
             
            }

        }
        );



    }
    public void update()
    {
        repaint();
    }


    public void paint(Graphics g)
    {
        g.setColor(Color.red);
        if((Page.this.state == Page.State.creating)||(Page.this.state == Page.State.ready2creat)){
            if((stop.x>start.x)&&(stop.y>start.y)){
                g.drawRect(start.x, start.y,(stop.x-start.x),(stop.y-start.y));
            }
            else if((stop.x<start.x)&&(stop.y<start.y)){
                g.drawRect(stop.x, stop.y,(start.x-stop.x),(start.y-stop.y));
            }
            else if((stop.x<start.x)&&(stop.y>start.y)){
                g.drawRect(stop.x, start.y,(start.x-stop.x),(stop.y-start.y));
            }
            else if((stop.x>start.x)&&(stop.y<start.y)){
                g.drawRect(start.x, stop.y,(stop.x-start.x),(start.y-stop.y));
            }
           
        }
        g.drawImage(back, 0,0,parent.getWidth(),parent.getHeight(),this);
       
        if(line==true){
            for(int i=0;i<=parent.getHeight();i=i+30){
                g.setColor(Color.BLACK);
                g.drawLine(0,i,parent.getWidth(),i);
            }
            for(int j=0;j<=parent.getWidth();j=j+30){
                g.setColor(Color.BLACK);
                g.drawLine(j,0,j,parent.getHeight());
            }
        }
    }


}





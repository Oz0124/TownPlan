
package townplan;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;


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
    Image back,img;
    public String filename;
    Point start, stop;
    MyObject temp;
    boolean line=false;
    Vector<MyObject> myobjects;
    int pi,setx,sety;
    int c=0;
    Toolkit toolkit;

    Page(TownPlan op)
    {
        parent = op;
        toolkit=Toolkit.getDefaultToolkit();
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
                        Page.this.myobjects.add(temp);
                        temp.show8Points();
                        start.x=0;
                        start.y=0;
                        stop.x=0;
                        stop.y=0;
                        
                        c++;
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
        if(line==false)
        {
            for(int h=0;h<c;h++)
            {
                pi=myobjects.get(h).npic;
                setx=myobjects.get(h).setx;
                sety=myobjects.get(h).sety;
                if(pi==1)
                {
                    img=toolkit.getImage("image/1.gif");
                }
                else if(pi==2)
                {
                    img=toolkit.getImage("image/2.gif");
                }
                else if(pi==3)
                {
                    img=toolkit.getImage("image/3.gif");
                }
                else if(pi==4)
                {
                    img=toolkit.getImage("image/4.gif");
                }
                else if(pi==5)
                {
                    img=toolkit.getImage("image/5.gif");
                }
                else if(pi==6)
                {
                    img=toolkit.getImage("image/6.gif");
                }
                else if(pi==7)
                {
                    img=toolkit.getImage("image/7.gif");
                }
                else if(pi==8)
                {
                    img=toolkit.getImage("image/8.gif");
                }
                else if(pi==9)
                {
                    img=toolkit.getImage("image/9.gif");
                }
                else if(pi==10)
                {
                    img=toolkit.getImage("image/10.gif");
                }
                else if(pi==11)
                {
                    img=toolkit.getImage("image/11.gif");
                }
                else if(pi==12)
                {
                    img=toolkit.getImage("image/12.gif");
                }
                else if(pi == 13)
                {
                    img=toolkit.getImage("image/13.gif");
                }
                else if(pi==14)
                {
                    img=toolkit.getImage("image/14.gif");
                }
                else if(pi==15)
                {
                    img=toolkit.getImage("image/15.gif");
                }
                else if(pi==16)
                {
                    img=toolkit.getImage("image/16.gif");
                }
                else if(pi==17)
                {
                    img=toolkit.getImage("image/17.gif");
                }
                else if(pi==18)
                {
                    img=toolkit.getImage("image/18.gif");
                }
                else if(pi==19)
                {
                    img=toolkit.getImage("image/19.gif");
                }
                else if(pi==20)
                {
                    img=toolkit.getImage("image/20.gif");
                }
                else if(pi==21)
                {
                    img=toolkit.getImage("image/21.gif");
                }
                else if(pi==22)
                {
                    img=toolkit.getImage("image/22.gif");
                }
                else if(pi==23)
                {
                    img=toolkit.getImage("image/23.gif");
                }
                else if(pi==24)
                {
                    img=toolkit.getImage("image/24.gif");
                }
                else if(pi == 25)
                {
                    img=toolkit.getImage("image/25.gif");
                }
                else if(pi==26)
                {
                    img=toolkit.getImage("image/26.gif");
                }
                else if(pi==27)
                {
                    img=toolkit.getImage("image/27.gif");
                }
                else if(pi==28)
                {
                    img=toolkit.getImage("image/28.gif");
                }
                else if(pi==29)
                {
                    img=toolkit.getImage("image/29.gif");
                }
                else if(pi==30)
                {
                    img=toolkit.getImage("image/30.gif");
                }
                else if(pi==31)
                {
                    img=toolkit.getImage("image/31.gif");
                }
                else if(pi==32)
                {
                    img=toolkit.getImage("image/32.gif");
                }
                else if(pi == 33)
                {
                    img=toolkit.getImage("image/33.gif");
                }
                else if(pi==34)
                {
                    img=toolkit.getImage("image/34.gif");
                }
                else if(pi==35)
                {
                    img=toolkit.getImage("image/35.gif");
                }
                else if(pi==36)
                {
                    img=toolkit.getImage("image/36.gif");
                }
                else if(pi==37)
                {
                    img=toolkit.getImage("image/37.gif");
                }
                else if(pi==38)
                {
                    img=toolkit.getImage("image/38.gif");
                }
                else if(pi==39)
                {
                    img=parent.objectImage;
                }
                g.drawImage(img, setx,sety,myobjects.get(h).w,myobjects.get(h).h,this);
            }
        }
    }


}





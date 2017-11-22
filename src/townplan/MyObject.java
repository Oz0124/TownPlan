
package townplan;
import java.awt.*;
import java.awt.event.*;

public class MyObject extends Panel
{
    Page parent;

    Panel epE;
    Panel epW;
    Panel epN;
    Panel epS;
    Panel epNE;
    Panel epNW;
    Panel epSE;
    Panel epSW;
    int ox=(-1);
    int oy=(-1);
    int dx, dy;
    Graphics g;
    String sign=null;
    Image img;
    int npic;
    boolean canmove;
    int setx,sety;
    int w,h;


    public enum State
    {
     actived,inactived,moving,temp;
    }
    State state;

    void setOutline(boolean b)
    {
        if(b==true)
        {
            g = parent.getGraphics();
            parent.start.x=ox;
            parent.start.y= oy;
            parent.stop.x=ox+getWidth();
            parent.stop.y=oy+getHeight();
            setx=parent.start.x;
            sety=parent.start.y;
            w=parent.stop.x-parent.start.x;
            h=parent.stop.y-parent.start.y;
            parent.update();
            parent.setVisible(true);
        }
        else
        {
            parent.update();
        }
    }

    void updateOutline2(int nx, int ny)
    {
        if(sign.equals("SE"))
        {
            parent.start.x=ox;
            parent.start.y= oy;
            parent.stop.x=ox+dx+nx;
            parent.stop.y=oy+dy+ny;
            if(parent.stop.x-parent.start.x <= 27)
            {
                parent.stop.x=parent.start.x+30;
            }
            if(parent.stop.y-parent.start.y <= 27)
            {
                parent.stop.y=parent.start.y+30;
            }
        }
        else if(sign.equals("SW"))
        {
            parent.start.x=ox-(6-nx);
            parent.start.y=oy;
            parent.stop.x=ox+dx;
            parent.stop.y=oy+dy-(6-ny);
            if(parent.stop.x-parent.start.x <= 27)
            {
                parent.start.x=parent.stop.x-30;
            }
            if(parent.stop.y-parent.start.y <= 27)
            {
                parent.stop.y=parent.start.y+30;
            }
        }
        else if(sign.equals("NE"))
        {
            parent.start.x=ox;
            parent.start.y=oy-(6-ny);
            parent.stop.x=ox+dx+nx;
            parent.stop.y=oy+dy;
            if(parent.stop.x-parent.start.x <= 27)
            {
                parent.stop.x=parent.start.x+30;
            }
            if(parent.stop.y-parent.start.y <= 27)
            {
                parent.start.y=parent.stop.y-30;
            }
        }
        else if(sign.equals("NW"))
        {
            parent.start.x=ox-(6-nx);
            parent.start.y=oy-(6-ny);
            parent.stop.x=ox+dx;
            parent.stop.y=oy+dy;
            if(parent.stop.x-parent.start.x <= 27)
            {
                parent.start.x=parent.stop.x-30;
            }
            if(parent.stop.y-parent.start.y <= 27)
            {
                parent.start.y=parent.stop.y-30;
            }
        }
        else if(sign.equals("W"))
        {
            parent.start.x=ox-(6-nx);
            parent.start.y=oy;
            parent.stop.x=ox+dx;
            parent.stop.y=oy+dy;
            if(parent.stop.x-parent.start.x <= 27)
            {
                parent.start.x=parent.stop.x-30;
            }
        }
        else if(sign.equals("E"))
        {
            parent.start.x=ox;
            parent.start.y=oy;
            parent.stop.x=ox+dx+nx;
            parent.stop.y=oy+dy;
            if(parent.stop.x-parent.start.x <= 27)
            {
                parent.stop.x=parent.start.x+30;
            }
        }
        else if(sign.equals("S"))
        {
            parent.start.x=ox;
            parent.start.y=oy;
            parent.stop.x=ox+dx;
            parent.stop.y=oy+dy-(6-ny);
            if(parent.stop.y-parent.start.y <= 27)
            {
                parent.stop.y=parent.start.y+30;
            }
        }
        else if(sign.equals("N"))
        {
            parent.start.x=ox;
            parent.start.y=oy-(6-ny);
            parent.stop.x=ox+dx;
            parent.stop.y=oy+dy;
            if(parent.stop.y-parent.start.y <= 27)
            {
                parent.start.y=parent.stop.y-30;
            }
        }
        setx=parent.start.x;
        sety=parent.start.y;
        parent.update();
        parent.setVisible(true);
    }

    void updateOutline(int nx, int ny)
    {
        parent.start.x=nx-dx;
        parent.start.y= ny-dy;
        parent.stop.x=nx-dx+getWidth();
        parent.stop.y=ny-dy+getHeight();
        parent.update();
        parent.setVisible(true);
    }

    void show8Points()
    {
        //this.setBackground(Color.GREEN);
        epE.setVisible(false);
        epE.setLocation( this.getX() + this.getWidth() +1 ,
                         this.getY() + (this.getHeight()/2) - 3);
        epE.setVisible(true);
        epW.setVisible(false);
        epW.setLocation( this.getX() - 6 ,
                         this.getY() + (this.getHeight()/2) - 3);
        epW.setVisible(true);
        epN.setVisible(false);
        epN.setLocation( this.getX() + (this.getWidth()/2) - 3 ,
                         this.getY() - 6);
        epN.setVisible(true);
        epS.setVisible(false);
        epS.setLocation( this.getX() + (this.getWidth()/2) - 3 ,
                         this.getY() + this.getHeight());
        epS.setVisible(true);
        epNE.setVisible(false);
        epNE.setLocation( this.getX() + this.getWidth() +1 ,
                          this.getY() - 6);
        epNE.setVisible(true);
        epNW.setVisible(false);
        epNW.setLocation( this.getX() - 6 ,
                          this.getY() - 6);
        epNW.setVisible(true);
        epSE.setVisible(false);
        epSE.setLocation( this.getX() + this.getWidth() +1 ,
                          this.getY() + this.getHeight());
        epSE.setVisible(true);
        epSW.setVisible(false);
        epSW.setLocation( this.getX() - 6 ,
                         this.getY() + this.getHeight());
        epSW.setVisible(true);

        epE.setBackground(Color.black);
        epW.setBackground(Color.black);
        epN.setBackground(Color.black);
        epS.setBackground(Color.black);
        epNE.setBackground(Color.black);
        epNW.setBackground(Color.black);
        epSE.setBackground(Color.black);
        epSW.setBackground(Color.black);
        parent.start.x=0;
        parent.start.y=0;
        parent.stop.x=0;
        parent.stop.y=0;
        parent.activeObject=this;
        parent.update();
    }

    void hide8Points()
    {
       //this.setBackground(Color.blue);
       epE.setVisible(false);
       epW.setVisible(false);
       epN.setVisible(false);
       epS.setVisible(false);
       epNE.setVisible(false);
       epNW.setVisible(false);
       epSE.setVisible(false);
       epSW.setVisible(false);
       canmove=false;
    }

    public void paint(Graphics g)
    {
        Toolkit toolkit=Toolkit.getDefaultToolkit();
        if(npic==1)
        {
            img=toolkit.getImage("image/1.gif");
        }
        else if(npic==2)
        {
            img=toolkit.getImage("image/2.gif");
        }
        else if(npic==3)
        {
            img=toolkit.getImage("image/3.gif");
        }
        else if(npic==4)
        {
            img=toolkit.getImage("image/4.gif");
        }
        else if(npic==5)
        {
            img=toolkit.getImage("image/5.gif");
        }
        else if(npic==6)
        {
            img=toolkit.getImage("image/6.gif");
        }
        else if(npic==7)
        {
            img=toolkit.getImage("image/7.gif");
        }
        else if(npic==8)
        {
            img=toolkit.getImage("image/8.gif");
        }
        else if(npic==9)
        {
            img=toolkit.getImage("image/9.gif");
        }
        else if(npic==10)
        {
            img=toolkit.getImage("image/10.gif");
        }
        else if(npic==11)
        {
            img=toolkit.getImage("image/11.gif");
        }
        else if(npic==12)
        {
            img=toolkit.getImage("image/12.gif");
        }
        else if(npic == 13)
        {
            img=toolkit.getImage("image/13.gif");
        }
        else if(npic==14)
        {
            img=toolkit.getImage("image/14.gif");
        }
        else if(npic==15)
        {
            img=toolkit.getImage("image/15.gif");
        }
        else if(npic==16)
        {
            img=toolkit.getImage("image/16.gif");
        }
        else if(npic==17)
        {
            img=toolkit.getImage("image/17.gif");
        }
        else if(npic==18)
        {
            img=toolkit.getImage("image/18.gif");
        }
        else if(npic==19)
        {
            img=toolkit.getImage("image/19.gif");
        }
        else if(npic==20)
        {
            img=toolkit.getImage("image/20.gif");
        }
        else if(npic==21)
        {
            img=toolkit.getImage("image/21.gif");
        }
        else if(npic==22)
        {
            img=toolkit.getImage("image/22.gif");
        }
        else if(npic==23)
        {
            img=toolkit.getImage("image/23.gif");
        }
        else if(npic==24)
        {
            img=toolkit.getImage("image/24.gif");
        }
        else if(npic == 25)
        {
            img=toolkit.getImage("image/25.gif");
        }
        else if(npic==26)
        {
            img=toolkit.getImage("image/26.gif");
        }
        else if(npic==27)
        {
            img=toolkit.getImage("image/27.gif");
        }
        else if(npic==28)
        {
            img=toolkit.getImage("image/28.gif");
        }
        else if(npic==29)
        {
            img=toolkit.getImage("image/29.gif");
        }
        else if(npic==30)
        {
            img=toolkit.getImage("image/30.gif");
        }
        else if(npic==31)
        {
            img=toolkit.getImage("image/31.gif");
        }
        else if(npic==32)
        {
            img=toolkit.getImage("image/32.gif");
        }
        else if(npic == 33)
        {
            img=toolkit.getImage("image/33.gif");
        }
        else if(npic==34)
        {
            img=toolkit.getImage("image/34.gif");
        }
        else if(npic==35)
        {
            img=toolkit.getImage("image/35.gif");
        }
        else if(npic==36)
        {
            img=toolkit.getImage("image/36.gif");
        }
        else if(npic==37)
        {
            img=toolkit.getImage("image/37.gif");
        }
        else if(npic==38)
        {
            img=toolkit.getImage("image/38.gif");
        }
        else if(npic==39)
        {
            img=parent.parent.objectImage;
        }
        
        g.drawImage(img, 0,0, getWidth(),getHeight(),this);
    }

    MyObject(Page p,int pic)
    {
        //this.setBackground(Color.red);
        setx=this.getX();
        sety=this.getY();
        npic=pic;
        epE = new Panel();
        epW = new Panel();
        epN = new Panel();
        epS = new Panel();
        epNE = new Panel();
        epNW = new Panel();
        epSE = new Panel();
        epSW = new Panel();

        epE.setSize(6, 6);
        epW.setSize(6, 6);
        epN.setSize(6, 6);
        epS.setSize(6, 6);
        epNE.setSize(6, 6);
        epNW.setSize(6, 6);
        epSE.setSize(6, 6);
        epSW.setSize(6, 6);

        p.add(epE);
        p.add(epW);
        p.add(epN);
        p.add(epS);
        p.add(epNE);
        p.add(epNW);
        p.add(epSE);
        p.add(epSW);

        epSE.addMouseListener(new MouseAdapter()
        {
                public void mousePressed(MouseEvent e)
                {
                    MyObject.this.setVisible(false);
                    MyObject.this.hide8Points();

                    ox =  MyObject.this.getX();
                    oy =  MyObject.this.getY();
                    dx = MyObject.this.getWidth();
                    dy = MyObject.this.getHeight();
                    MyObject.this.setOutline(true);
                    sign="SE";
                }
                public void mouseReleased(MouseEvent e)
                {
                    MyObject.this.setLocation(parent.start.x, parent.start.y);
                    MyObject.this.setSize( parent.stop.x-parent.start.x  ,parent.stop.y-parent.start.y );
                    MyObject.this.setVisible(true);
                    MyObject.this.show8Points();
                    sign=null;
                }
        });

        epSE.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseDragged(MouseEvent e)
                {
                    updateOutline2(e.getX(), e.getY());
                }
            }
        );

        epSW.addMouseListener(new MouseAdapter()
        {
                public void mousePressed(MouseEvent e)
                {
                    MyObject.this.setVisible(false);
                    MyObject.this.hide8Points();

                    ox =  MyObject.this.getX();
                    oy =  MyObject.this.getY();
                    dx = MyObject.this.getWidth();
                    dy = MyObject.this.getHeight();
                    MyObject.this.setOutline(true);
                    sign="SW";
                }
                public void mouseReleased(MouseEvent e)
                {
                    MyObject.this.setLocation(parent.start.x, parent.start.y);
                    MyObject.this.setSize( parent.stop.x-parent.start.x  ,parent.stop.y-parent.start.y );
                    MyObject.this.setVisible(true);
                    MyObject.this.show8Points();
                    sign=null;
                }
        });

        epSW.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseDragged(MouseEvent e)
                {
                    updateOutline2(e.getX(), e.getY());
                }
            }
        );

        epNE.addMouseListener(new MouseAdapter()
        {
                public void mousePressed(MouseEvent e)
                {
                    MyObject.this.setVisible(false);
                    MyObject.this.hide8Points();

                    ox =  MyObject.this.getX();
                    oy =  MyObject.this.getY();
                    dx = MyObject.this.getWidth();
                    dy = MyObject.this.getHeight();
                    MyObject.this.setOutline(true);
                    sign="NE";

                }
                public void mouseReleased(MouseEvent e)
                {
                    MyObject.this.setLocation(parent.start.x, parent.start.y);
                    MyObject.this.setSize( parent.stop.x-parent.start.x  ,parent.stop.y-parent.start.y );
                    MyObject.this.setVisible(true);
                    MyObject.this.show8Points();
                    sign=null;
                }
        });

        epNE.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseDragged(MouseEvent e)
                {
                    updateOutline2(e.getX(), e.getY());
                }
            }
        );

        epNW.addMouseListener(new MouseAdapter()
        {
                public void mousePressed(MouseEvent e)
                {
                    MyObject.this.setVisible(false);
                    MyObject.this.hide8Points();

                    ox =  MyObject.this.getX();
                    oy =  MyObject.this.getY();
                    dx = MyObject.this.getWidth();
                    dy = MyObject.this.getHeight();
                    MyObject.this.setOutline(true);
                    sign="NW";
                }
                public void mouseReleased(MouseEvent e)
                {
                    MyObject.this.setLocation(parent.start.x, parent.start.y);
                    MyObject.this.setSize( parent.stop.x-parent.start.x  ,parent.stop.y-parent.start.y );
                    MyObject.this.setVisible(true);
                    MyObject.this.show8Points();
                    sign=null;
                }
        });

        epNW.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseDragged(MouseEvent e)
                {
                    updateOutline2(e.getX(), e.getY());
                }
            }
        );


        epE.addMouseListener(new MouseAdapter()
        {
                public void mousePressed(MouseEvent e)
                {
                    MyObject.this.setVisible(false);
                    MyObject.this.hide8Points();

                    ox =  MyObject.this.getX();
                    oy =  MyObject.this.getY();
                    dx = MyObject.this.getWidth();
                    dy = MyObject.this.getHeight();
                    MyObject.this.setOutline(true);
                    sign="E";

                }
                public void mouseReleased(MouseEvent e)
                {
                    MyObject.this.setLocation(parent.start.x, parent.start.y);
                    MyObject.this.setSize( parent.stop.x-parent.start.x  ,parent.stop.y-parent.start.y );
                    MyObject.this.setVisible(true);
                    MyObject.this.show8Points();
                    sign=null;
                }
        });

        epE.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseDragged(MouseEvent e)
                {
                    updateOutline2(e.getX(), e.getY());
                }
            }
        );

        epW.addMouseListener(new MouseAdapter()
        {
                public void mousePressed(MouseEvent e)
                {
                    MyObject.this.setVisible(false);
                    MyObject.this.hide8Points();

                    ox =  MyObject.this.getX();
                    oy =  MyObject.this.getY();
                    dx = MyObject.this.getWidth();
                    dy = MyObject.this.getHeight();
                    MyObject.this.setOutline(true);
                    sign="W";
                }
                public void mouseReleased(MouseEvent e)
                {
                    MyObject.this.setLocation(parent.start.x, parent.start.y);
                    MyObject.this.setSize( parent.stop.x-parent.start.x  ,parent.stop.y-parent.start.y );
                    MyObject.this.setVisible(true);
                    MyObject.this.show8Points();
                    sign=null;
                }
        });

        epW.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseDragged(MouseEvent e)
                {
                    updateOutline2(e.getX(), e.getY());
                }
            }
        );

        epN.addMouseListener(new MouseAdapter()
        {
                public void mousePressed(MouseEvent e)
                {
                    MyObject.this.setVisible(false);
                    MyObject.this.hide8Points();

                    ox =  MyObject.this.getX();
                    oy =  MyObject.this.getY();
                    dx = MyObject.this.getWidth();
                    dy = MyObject.this.getHeight();
                    MyObject.this.setOutline(true);
                    sign="N";

                }
                public void mouseReleased(MouseEvent e)
                {
                    MyObject.this.setLocation(parent.start.x, parent.start.y);
                    MyObject.this.setSize( parent.stop.x-parent.start.x  ,parent.stop.y-parent.start.y );
                    MyObject.this.setVisible(true);
                    MyObject.this.show8Points();
                    sign=null;
                }
        });

        epN.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseDragged(MouseEvent e)
                {
                    updateOutline2(e.getX(), e.getY());
                }
            }
        );

        epS.addMouseListener(new MouseAdapter()
        {
                public void mousePressed(MouseEvent e)
                {
                    MyObject.this.setVisible(false);
                    MyObject.this.hide8Points();

                    ox =  MyObject.this.getX();
                    oy =  MyObject.this.getY();
                    dx = MyObject.this.getWidth();
                    dy = MyObject.this.getHeight();
                    MyObject.this.setOutline(true);
                    sign="S";
                }
                public void mouseReleased(MouseEvent e)
                {
                    MyObject.this.setLocation(parent.start.x, parent.start.y);
                    MyObject.this.setSize( parent.stop.x-parent.start.x  ,parent.stop.y-parent.start.y );
                    MyObject.this.setVisible(true);
                    MyObject.this.show8Points();
                    sign=null;
                }
        });

        epS.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseDragged(MouseEvent e)
                {
                    updateOutline2(e.getX(), e.getY());

                }
            }
        );

        if((this != p.activeObject)&(p.activeObject!=null))
        {
            p.activeObject.state = State.inactived;
            p.activeObject.hide8Points();
        }

        state = State.actived;

        //show8Points();

        parent =p;

        this.addMouseMotionListener(new MouseMotionAdapter()
        {
                public void mouseDragged(MouseEvent e)
                {
                    if ((MyObject.this.state==MyObject.State.moving))
                    {
                        MyObject.this.updateOutline(e.getX(), e.getY());
                    }
                    else if(MyObject.this.state==MyObject.State.temp)
                    {
                        MyObject.this.state=MyObject.State.moving;
                        MyObject.this.setVisible(false);
                        
                        MyObject.this.hide8Points();
                        ox = MyObject.this.getX();
                        oy = MyObject.this.getY();

                        dx = e.getX() - MyObject.this.getX();
                        dy = e.getY() - MyObject.this.getY();
                        MyObject.this.setOutline(true);
                    }

                }
                
                public void mouseMoved(MouseEvent e)
                {
    
                    if(npic==1)
                    {
                       parent.parent.messageBar.setMessage("");
                    }
                    else if(npic==2)
                    {
                        parent.parent.messageBar.setMessage("");
                    }
                    else if(npic==3)
                    {
                        parent.parent.messageBar.setMessage("");
                    }
                    else if(npic==4)
                    {
                        parent.parent.messageBar.setMessage("");
                    }
                    else if(npic==5)
                    {
                        parent.parent.messageBar.setMessage("");
                    }
                    else if(npic==6)
                    {
                        parent.parent.messageBar.setMessage("");
                    }
                    else if(npic==7)
                    {
                        parent.parent.messageBar.setMessage("");
                    }
                    else if(npic==8)
                    {
                        parent.parent.messageBar.setMessage("");
                    }
                    else if(npic==9)
                    {
                        parent.parent.messageBar.setMessage("");
                    }
                    else if(npic==10)
                    {
                        parent.parent.messageBar.setMessage("");
                    }
                    else if(npic==11)
                    {
                        parent.parent.messageBar.setMessage("");
                    }
                    else if(npic==12)
                    {
                        parent.parent.messageBar.setMessage("");
                    }
                    else if(npic == 13)
                    {
                       parent.parent.messageBar.setMessage("");
                    }
                    else if(npic==14)
                    {
                        parent.parent.messageBar.setMessage("");
                    }
                    else if(npic==15)
                    {
                        parent.parent.messageBar.setMessage("");
                    }
                    else if(npic==16)
                    {
                        parent.parent.messageBar.setMessage("");
                    }
                    else if(npic==17)
                    {
                        parent.parent.messageBar.setMessage("");
                    }
                    else if(npic==18)
                    {
                        parent.parent.messageBar.setMessage("");
                    }
                    else if(npic==19)
                    {
                        parent.parent.messageBar.setMessage("");
                    }
                    else if(npic==20)
                    {
                        parent.parent.messageBar.setMessage("");
                    }
                    else if(npic==21)
                    {
                        parent.parent.messageBar.setMessage("");
                    }
                    else if(npic==22)
                    {
                        parent.parent.messageBar.setMessage("");
                    }
                    else if(npic==23)
                    {
                        parent.parent.messageBar.setMessage("");
                    }
                    else if(npic==24)
                    {
                        parent.parent.messageBar.setMessage("");
                    }
                    else if(npic == 25)
                    {
                       parent.parent.messageBar.setMessage("");
                    }
                    else if(npic==26)
                    {
                        parent.parent.messageBar.setMessage("");
                    }
                    else if(npic==27)
                    {
                        parent.parent.messageBar.setMessage("");
                    }
                    else if(npic==28)
                    {
                        parent.parent.messageBar.setMessage("");
                    }
                    else if(npic==29)
                    {
                        parent.parent.messageBar.setMessage("");
                    }
                    else if(npic==30)
                    {
                        parent.parent.messageBar.setMessage("");
                    }
                    else if(npic==31)
                    {
                        parent.parent.messageBar.setMessage("");
                    }
                    else if(npic==32)
                    {
                        parent.parent.messageBar.setMessage("");
                    }
                    else if(npic==33)
                    {
                        parent.parent.messageBar.setMessage("");
                    }
                    else if(npic == 34)
                    {
                       parent.parent.messageBar.setMessage("");
                    }
                    else if(npic==35)
                    {
                        parent.parent.messageBar.setMessage("");
                    }
                    else if(npic==36)
                    {
                        parent.parent.messageBar.setMessage("");
                    }
                    else if(npic==37)
                    {
                        parent.parent.messageBar.setMessage("");
                    }
                    else if(npic==38)
                    {
                        parent.parent.messageBar.setMessage("");
                    }
                    else if(npic==39)
                    {
                        parent.parent.messageBar.setMessage(parent.parent.inputValue);
                    }

                    
                }

        }
        );

        this.addMouseListener
        (
            new MouseAdapter()
            {

                public void mousePressed(MouseEvent e)
                {
                    if((MyObject.this != parent.activeObject)&&(MyObject.this.state==MyObject.State.inactived)&&(parent.parent.finBtn.isEnabled()))
                    {
                        parent.activeObject.state=State.inactived;
                        parent.activeObject.hide8Points();
                        state = State.temp;
                        //MyObject.this.show8Points();
                        //parent.activeObject = MyObject.this;

                    }
                    else if (MyObject.this.state==MyObject.State.actived)
                    {
                        MyObject.this.state=MyObject.State.moving;
                        MyObject.this.setVisible(false);
                        
                        MyObject.this.hide8Points();
                        ox = MyObject.this.getX();
                        oy = MyObject.this.getY();

                        dx = e.getX() - MyObject.this.getX();
                        dy = e.getY() - MyObject.this.getY();
                        MyObject.this.setOutline(true);
                    }
                }

                public void mouseReleased(MouseEvent e)
                {
                    if (MyObject.this.state==MyObject.State.moving)
                    {
                        MyObject.this.state=MyObject.State.actived;

                        MyObject.this.setLocation(e.getX()-dx, e.getY()-dy);

                        MyObject.this.show8Points();
                        MyObject.this.setVisible(true);
                        MyObject.this.state=MyObject.State.actived;
                        MyObject.this.show8Points();
                        parent.activeObject = MyObject.this;
                    }
                    else if(MyObject.this.state==MyObject.State.temp)
                    {
                        MyObject.this.state=MyObject.State.actived;
                        MyObject.this.show8Points();
                        parent.activeObject = MyObject.this;

                    }
                    parent.start.x=0;
                    parent.start.y=0;
                    parent.stop.x=0;
                    parent.stop.y=0;

                }
                public void mouseExited(MouseEvent e)
                {
                    parent.parent.messageBar.setMessage(" ");
                    
                }

            }
        );
        repaint();
        parent.activeObject = MyObject.this;
    }

}

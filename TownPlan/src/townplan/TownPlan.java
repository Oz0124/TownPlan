
package townplan;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import java.util.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;



public class TownPlan extends Frame {

    JButton prevPageBtn,nextPageBtn,delPageBtn,newPageBtn,openBtn,saveBtn,aboutBtn,copyBtn,clearBtn,enableBtn,finBtn;
    JButton pub,hou,sho,gov,ven,oth;
    JButton a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,aa,ab,ac,ad,ae,af,ag,ah,ai,aj,ak,al;
    ImageIcon a1,b1,c1,d1,e1,f1,g1,h1,i1,j1,k1,l1,m1,n1,o1,p1,q1,r1,s1,t1,u1,v1,w1,x1,y1,z1,aa1,ab1,ac1,ad1;
    ImageIcon ae1,af1,ag1,ah1,ai1,aj1,ak1,al1;
    ImageIcon ne,ope,pre,nex,del,abo,open,save,copy,clear,en;
    //頁面集合
    Vector<Page> pages;
    //現在頁面
    public Page activePage;
    //現在頁面數和總頁面數
    int curPageNum=1, totalPageNum=1;
    int pic;
    MyObject tempObject;
    ToolBar toolBar;
    MessageBar messageBar;
    Muen muen;
    Image originalImage,objectImage;
    String inputValue;
    boolean move;
    
    TownPlan()
    {
        pages = new Vector<Page>();
        
        this.setSize(1280,770);
        this.setTitle("Town Plan 城市規劃 V3.6+ test");

        this.addWindowListener( new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        }
        );
        this.setLayout(new BorderLayout());

        toolBar = new ToolBar();
        this.add(toolBar, BorderLayout.NORTH);
        muen = new Muen();
        muen.toolp.setVisible(false);
        muen.toolh.setVisible(false);
        muen.tools.setVisible(false);
        muen.toolg.setVisible(false);
        muen.toolv.setVisible(false);
      
        hou=new JButton("建築物");
        pub=new JButton("裝飾物");
        sho=new JButton("其他");
        gov=new JButton("居民");
        ven=new JButton("交通工具");
        oth=new JButton("自選圖片");
        pub.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                muen.toolp.setVisible(true);
                muen.toolh.setVisible(false);
                muen.tools.setVisible(false);
                muen.toolg.setVisible(false);
                muen.toolv.setVisible(false);
                TownPlan.this.setVisible(true);
            }
        });

        hou.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                muen.toolp.setVisible(false);
                muen.toolh.setVisible(true);
                muen.tools.setVisible(false);
                muen.toolg.setVisible(false);
                muen.toolv.setVisible(false);
                TownPlan.this.setVisible(true);
            }
        });

        sho.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                muen.toolp.setVisible(false);
                muen.toolh.setVisible(false);
                muen.tools.setVisible(true);
                muen.toolg.setVisible(false);
                muen.toolv.setVisible(false);
                TownPlan.this.setVisible(true);
            }
        });

        gov.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                muen.toolp.setVisible(false);
                muen.toolh.setVisible(false);
                muen.tools.setVisible(false);
                muen.toolv.setVisible(false);
                muen.toolg.setVisible(true);
                TownPlan.this.setVisible(true);
            }
        });

        ven.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                muen.toolp.setVisible(false);
                muen.toolh.setVisible(false);
                muen.tools.setVisible(false);
                muen.toolg.setVisible(false);
                muen.toolv.setVisible(true);
                TownPlan.this.setVisible(true);
            }
        });
        oth.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                JFileChooser s = new JFileChooser("image/");
                FileNameExtensionFilter filter = new FileNameExtensionFilter("gif & jpg Images", "gif", "jpg");
                s.setFileFilter(filter);
                s.showDialog(null, "選取檔案");

		try {
                    objectImage = ImageIO.read(s.getSelectedFile());
                } catch (Exception ee) {
                   return;
                }
                activePage.state = Page.State.ready2creat;
                TownPlan.this.pic=39;
                inputValue = JOptionPane.showInputDialog("請輸入圖片說明");
                muen.toolp.setVisible(false);
                muen.toolh.setVisible(false);
                muen.tools.setVisible(false);
                muen.toolg.setVisible(false);
                muen.toolv.setVisible(false);
                TownPlan.this.setVisible(true);
            }
        });


        
        muen.add(pub);
        muen.add(hou);
        muen.add(ven);
        muen.add(gov);
        muen.add(sho);
        muen.add(oth);
        pub.setBackground(Color.ORANGE);
        hou.setBackground(Color.ORANGE);
        ven.setBackground(Color.ORANGE);
        gov.setBackground(Color.ORANGE);
        sho.setBackground(Color.ORANGE);
        oth.setBackground(Color.ORANGE);

        this.add(muen, BorderLayout.EAST);
        a1=new ImageIcon("image/1.gif");
        b1=new ImageIcon("image/2.gif");
        c1=new ImageIcon("image/3.gif");
        d1=new ImageIcon("image/4.gif");
        e1=new ImageIcon("image/5.gif");
        f1=new ImageIcon("image/6.gif");
        g1=new ImageIcon("image/7.gif");
        h1=new ImageIcon("image/8.gif");
        i1=new ImageIcon("image/9.gif");
        j1=new ImageIcon("image/10.gif");
        k1=new ImageIcon("image/11.gif");
        l1=new ImageIcon("image/12.gif");
        m1=new ImageIcon("image/13.gif");
        n1=new ImageIcon("image/14.gif");
        o1=new ImageIcon("image/15.gif");
        p1=new ImageIcon("image/16.gif");
        q1=new ImageIcon("image/17.gif");
        r1=new ImageIcon("image/18.gif");
        s1=new ImageIcon("image/19.gif");
        t1=new ImageIcon("image/20.gif");
        u1=new ImageIcon("image/21.gif");
        v1=new ImageIcon("image/22.gif");
        w1=new ImageIcon("image/23.gif");
        x1=new ImageIcon("image/24.gif");
        y1=new ImageIcon("image/25.gif");
        z1=new ImageIcon("image/26.gif");
        aa1=new ImageIcon("image/27.gif");
        ab1=new ImageIcon("image/28.gif");
        ac1=new ImageIcon("image/29.gif");
        ad1=new ImageIcon("image/30.gif");
        ae1=new ImageIcon("image/31.gif");
        af1=new ImageIcon("image/32.gif");
        ag1=new ImageIcon("image/33.gif");
        ah1=new ImageIcon("image/34.gif");
        ai1=new ImageIcon("image/35.gif");
        aj1=new ImageIcon("image/36.gif");
        ak1=new ImageIcon("image/37.gif");
        al1=new ImageIcon("image/38.gif");
        a=new JButton(a1);
        b=new JButton(b1);
        c=new JButton(c1);
        d=new JButton(d1);
        e=new JButton(e1);
        f=new JButton(f1);
        g=new JButton(g1);
        h=new JButton(h1);
        i=new JButton(i1);
        j=new JButton(j1);
        k=new JButton(k1);
        l=new JButton(l1);
        m=new JButton(m1);
        n=new JButton(n1);
        o=new JButton(o1);
        p=new JButton(p1);
        q=new JButton(q1);
        r=new JButton(r1);
        s=new JButton(s1);
        t=new JButton(t1);
        u=new JButton(u1);
        v=new JButton(v1);
        w=new JButton(w1);
        x=new JButton(x1);
        y=new JButton(y1);
        z=new JButton(z1);
        aa=new JButton(aa1);
        ab=new JButton(ab1);
        ac=new JButton(ac1);
        ad=new JButton(ad1);
        ae=new JButton(ae1);
        af=new JButton(af1);
        ag=new JButton(ag1);
        ah=new JButton(ah1);
        ai=new JButton(ai1);
        aj=new JButton(aj1);
        ak=new JButton(ak1);
        al=new JButton(al1);

        a.setBackground(Color.PINK);
        b.setBackground(Color.pink);
        c.setBackground(Color.pink);
        d.setBackground(Color.pink);
        e.setBackground(Color.pink);
        f.setBackground(Color.pink);
        g.setBackground(Color.pink);
        h.setBackground(Color.pink);
        i.setBackground(Color.pink);
        j.setBackground(Color.pink);
        k.setBackground(Color.pink);
        l.setBackground(Color.pink);
        m.setBackground(Color.PINK);
        n.setBackground(Color.pink);
        o.setBackground(Color.pink);
        p.setBackground(Color.pink);
        q.setBackground(Color.pink);
        r.setBackground(Color.pink);
        s.setBackground(Color.pink);
        t.setBackground(Color.pink);
        u.setBackground(Color.pink);
        v.setBackground(Color.pink);
        w.setBackground(Color.pink);
        x.setBackground(Color.pink);
        y.setBackground(Color.PINK);
        z.setBackground(Color.pink);
        aa.setBackground(Color.pink);
        ab.setBackground(Color.pink);
        ac.setBackground(Color.pink);
        ad.setBackground(Color.pink);
        ae.setBackground(Color.pink);
        af.setBackground(Color.pink);
        ag.setBackground(Color.pink);
        ah.setBackground(Color.pink);
        ai.setBackground(Color.pink);
        aj.setBackground(Color.pink);
        ak.setBackground(Color.pink);
        al.setBackground(Color.pink);

        a.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(TownPlan.this.activePage.state == Page.State.actived)
                {
                    activePage.state = Page.State.ready2creat;
                    
                }
                
            }
            public void mousePressed(MouseEvent e)
            {
                TownPlan.this.pic=0;
            }
            public void mouseReleased(MouseEvent e)
            {
                TownPlan.this.pic=1;

            }
            public void mouseExited(MouseEvent e)
            {
                 messageBar.setMessage(" ");
            }
            
        });

        a.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent e)
                {
                    messageBar.setMessage("植物");
                }

            }
        );

        b.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(TownPlan.this.activePage.state == Page.State.actived)
                {
                    activePage.state = Page.State.ready2creat;
                    
                }
                
            }
            public void mousePressed(MouseEvent e)
            {
                TownPlan.this.pic=0;
            }
            public void mouseReleased(MouseEvent e)
            {
                TownPlan.this.pic=2;
            }
            public void mouseExited(MouseEvent e)
            {
                 messageBar.setMessage(" ");
            }
            
        });

        b.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent e)
                {
                    messageBar.setMessage("植物");
                }

            }
        );

        c.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(TownPlan.this.activePage.state == Page.State.actived)
                {
                    activePage.state = Page.State.ready2creat;
                   
                }
                
            }
            public void mousePressed(MouseEvent e)
            {
                TownPlan.this.pic=0;
            }
            public void mouseReleased(MouseEvent e)
            {
                TownPlan.this.pic=3;
            }
            public void mouseExited(MouseEvent e)
            {
                 messageBar.setMessage(" ");
            }
        });

        c.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent e)
                {
                    messageBar.setMessage("植物");
                }

            }
        );

        d.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(TownPlan.this.activePage.state == Page.State.actived)
                {
                    activePage.state = Page.State.ready2creat;

                }

            }
            public void mousePressed(MouseEvent e)
            {
                TownPlan.this.pic=0;
            }
            public void mouseReleased(MouseEvent e)
            {
                TownPlan.this.pic=4;

            }
            public void mouseExited(MouseEvent e)
            {
                 messageBar.setMessage(" ");
            }
        });

        d.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent e)
                {
                    messageBar.setMessage("植物");
                }

            }
        );

        e.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(TownPlan.this.activePage.state == Page.State.actived)
                {
                    activePage.state = Page.State.ready2creat;

                }

            }
            public void mousePressed(MouseEvent e)
            {
                TownPlan.this.pic=0;
            }
            public void mouseReleased(MouseEvent e)
            {
                TownPlan.this.pic=5;
            }
            public void mouseExited(MouseEvent e)
            {
                 messageBar.setMessage(" ");
            }

        });

        e.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent e)
                {
                    messageBar.setMessage("植物");
                }

            }
        );

        f.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(TownPlan.this.activePage.state == Page.State.actived)
                {
                    activePage.state = Page.State.ready2creat;

                }

            }
            public void mousePressed(MouseEvent e)
            {
                TownPlan.this.pic=0;
            }
            public void mouseReleased(MouseEvent e)
            {
                TownPlan.this.pic=6;
            }
            public void mouseExited(MouseEvent e)
            {
                 messageBar.setMessage(" ");
            }

        });

        f.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent e)
                {
                    messageBar.setMessage("植物");
                }

            }
        );

        g.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(TownPlan.this.activePage.state == Page.State.actived)
                {
                    activePage.state = Page.State.ready2creat;

                }

            }
            public void mousePressed(MouseEvent e)
            {
                TownPlan.this.pic=0;
            }
            public void mouseReleased(MouseEvent e)
            {
                TownPlan.this.pic=7;

            }
            public void mouseExited(MouseEvent e)
            {
                 messageBar.setMessage(" ");
            }

        });

        g.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent e)
                {
                    messageBar.setMessage("植物");
                }

            }
        );

        h.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(TownPlan.this.activePage.state == Page.State.actived)
                {
                    activePage.state = Page.State.ready2creat;

                }

            }
            public void mousePressed(MouseEvent e)
            {
                TownPlan.this.pic=0;
            }
            public void mouseReleased(MouseEvent e)
            {
                TownPlan.this.pic=8;
            }
            public void mouseExited(MouseEvent e)
            {
                 messageBar.setMessage(" ");
            }

        });

        h.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent e)
                {
                    messageBar.setMessage("植物");
                }

            }
        );

        i.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(TownPlan.this.activePage.state == Page.State.actived)
                {
                    activePage.state = Page.State.ready2creat;

                }

            }
            public void mousePressed(MouseEvent e)
            {
                TownPlan.this.pic=0;
            }
            public void mouseReleased(MouseEvent e)
            {
                TownPlan.this.pic=9;
            }
            public void mouseExited(MouseEvent e)
            {
                 messageBar.setMessage(" ");
            }

        });

        i.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent e)
                {
                    messageBar.setMessage("植物");
                }

            }
        );

        j.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(TownPlan.this.activePage.state == Page.State.actived)
                {
                    activePage.state = Page.State.ready2creat;

                }

            }
            public void mousePressed(MouseEvent e)
            {
                TownPlan.this.pic=0;
            }
            public void mouseReleased(MouseEvent e)
            {
                TownPlan.this.pic=10;

            }
            public void mouseExited(MouseEvent e)
            {
                 messageBar.setMessage(" ");
            }

        });

        j.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent e)
                {
                    messageBar.setMessage("建築物");
                }

            }
        );

        k.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(TownPlan.this.activePage.state == Page.State.actived)
                {
                    activePage.state = Page.State.ready2creat;

                }

            }
            public void mousePressed(MouseEvent e)
            {
                TownPlan.this.pic=0;
            }
            public void mouseReleased(MouseEvent e)
            {
                TownPlan.this.pic=11;

            }
            public void mouseExited(MouseEvent e)
            {
                 messageBar.setMessage(" ");
            }

        });

        k.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent e)
                {
                    messageBar.setMessage("建築物");
                }

            }
        );

        l.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(TownPlan.this.activePage.state == Page.State.actived)
                {
                    activePage.state = Page.State.ready2creat;

                }

            }
            public void mousePressed(MouseEvent e)
            {
                TownPlan.this.pic=0;
            }
            public void mouseReleased(MouseEvent e)
            {
                TownPlan.this.pic=12;

            }
            public void mouseExited(MouseEvent e)
            {
                 messageBar.setMessage(" ");
            }

        });

        l.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent e)
                {
                    messageBar.setMessage("建築物");
                }

            }
        );

        m.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(TownPlan.this.activePage.state == Page.State.actived)
                {
                    activePage.state = Page.State.ready2creat;

                }

            }
            public void mousePressed(MouseEvent e)
            {
                TownPlan.this.pic=0;
            }
            public void mouseReleased(MouseEvent e)
            {
                TownPlan.this.pic=13;

            }
            public void mouseExited(MouseEvent e)
            {
                 messageBar.setMessage(" ");
            }

        });

        m.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent e)
                {
                    messageBar.setMessage("建築物");
                }

            }
        );

        n.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(TownPlan.this.activePage.state == Page.State.actived)
                {
                    activePage.state = Page.State.ready2creat;

                }

            }
            public void mousePressed(MouseEvent e)
            {
                TownPlan.this.pic=0;
            }
            public void mouseReleased(MouseEvent e)
            {
                TownPlan.this.pic=14;
            }
            public void mouseExited(MouseEvent e)
            {
                 messageBar.setMessage(" ");
            }

        });

        n.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent e)
                {
                    messageBar.setMessage("建築物");
                }

            }
        );

        o.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(TownPlan.this.activePage.state == Page.State.actived)
                {
                    activePage.state = Page.State.ready2creat;

                }

            }
            public void mousePressed(MouseEvent e)
            {
                TownPlan.this.pic=0;
            }
            public void mouseReleased(MouseEvent e)
            {
                TownPlan.this.pic=15;
            }
            public void mouseExited(MouseEvent e)
            {
                 messageBar.setMessage(" ");
            }
        });

        o.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent e)
                {
                    messageBar.setMessage("建築物");
                }

            }
        );

        p.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(TownPlan.this.activePage.state == Page.State.actived)
                {
                    activePage.state = Page.State.ready2creat;

                }

            }
            public void mousePressed(MouseEvent e)
            {
                TownPlan.this.pic=0;
            }
            public void mouseReleased(MouseEvent e)
            {
                TownPlan.this.pic=16;

            }
            public void mouseExited(MouseEvent e)
            {
                 messageBar.setMessage(" ");
            }
        });

        p.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent e)
                {
                    messageBar.setMessage("建築物");
                }

            }
        );

        q.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(TownPlan.this.activePage.state == Page.State.actived)
                {
                    activePage.state = Page.State.ready2creat;

                }

            }
            public void mousePressed(MouseEvent e)
            {
                TownPlan.this.pic=0;
            }
            public void mouseReleased(MouseEvent e)
            {
                TownPlan.this.pic=17;
            }
            public void mouseExited(MouseEvent e)
            {
                 messageBar.setMessage(" ");
            }

        });

        q.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent e)
                {
                    messageBar.setMessage("建築物");
                }

            }
        );

        r.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(TownPlan.this.activePage.state == Page.State.actived)
                {
                    activePage.state = Page.State.ready2creat;

                }

            }
            public void mousePressed(MouseEvent e)
            {
                TownPlan.this.pic=0;
            }
            public void mouseReleased(MouseEvent e)
            {
                TownPlan.this.pic=18;
            }
            public void mouseExited(MouseEvent e)
            {
                 messageBar.setMessage(" ");
            }

        });

        r.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent e)
                {
                    messageBar.setMessage("建築物");
                }

            }
        );

        s.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(TownPlan.this.activePage.state == Page.State.actived)
                {
                    activePage.state = Page.State.ready2creat;

                }

            }
            public void mousePressed(MouseEvent e)
            {
                TownPlan.this.pic=0;
            }
            public void mouseReleased(MouseEvent e)
            {
                TownPlan.this.pic=19;

            }
            public void mouseExited(MouseEvent e)
            {
                 messageBar.setMessage(" ");
            }

        });

        s.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent e)
                {
                    messageBar.setMessage("交通工具");
                }

            }
        );

        t.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(TownPlan.this.activePage.state == Page.State.actived)
                {
                    activePage.state = Page.State.ready2creat;

                }

            }
            public void mousePressed(MouseEvent e)
            {
                TownPlan.this.pic=0;
            }
            public void mouseReleased(MouseEvent e)
            {
                TownPlan.this.pic=20;
            }
            public void mouseExited(MouseEvent e)
            {
                 messageBar.setMessage(" ");
            }

        });

        t.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent e)
                {
                    messageBar.setMessage("交通工具");
                }

            }
        );

        u.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(TownPlan.this.activePage.state == Page.State.actived)
                {
                    activePage.state = Page.State.ready2creat;

                }

            }
            public void mousePressed(MouseEvent e)
            {
                TownPlan.this.pic=0;
            }
            public void mouseReleased(MouseEvent e)
            {
                TownPlan.this.pic=21;
            }
            public void mouseExited(MouseEvent e)
            {
                 messageBar.setMessage(" ");
            }

        });

        u.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent e)
                {
                    messageBar.setMessage("交通工具");
                }

            }
        );

        v.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(TownPlan.this.activePage.state == Page.State.actived)
                {
                    activePage.state = Page.State.ready2creat;

                }

            }
            public void mousePressed(MouseEvent e)
            {
                TownPlan.this.pic=0;
            }
            public void mouseReleased(MouseEvent e)
            {
                TownPlan.this.pic=22;

            }
            public void mouseExited(MouseEvent e)
            {
                 messageBar.setMessage(" ");
            }

        });

        v.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent e)
                {
                    messageBar.setMessage("交通工具");
                }

            }
        );

        w.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(TownPlan.this.activePage.state == Page.State.actived)
                {
                    activePage.state = Page.State.ready2creat;

                }

            }
            public void mousePressed(MouseEvent e)
            {
                TownPlan.this.pic=0;
            }
            public void mouseReleased(MouseEvent e)
            {
                TownPlan.this.pic=23;

            }
            public void mouseExited(MouseEvent e)
            {
                 messageBar.setMessage(" ");
            }

        });

        w.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent e)
                {
                    messageBar.setMessage("交通工具");
                }

            }
        );

        x.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(TownPlan.this.activePage.state == Page.State.actived)
                {
                    activePage.state = Page.State.ready2creat;

                }

            }
            public void mousePressed(MouseEvent e)
            {
                TownPlan.this.pic=0;
            }
            public void mouseReleased(MouseEvent e)
            {
                TownPlan.this.pic=24;

            }
            public void mouseExited(MouseEvent e)
            {
                 messageBar.setMessage(" ");
            }

        });

        x.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent e)
                {
                    messageBar.setMessage("交通工具");
                }

            }
        );

        y.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(TownPlan.this.activePage.state == Page.State.actived)
                {
                    activePage.state = Page.State.ready2creat;

                }

            }
            public void mousePressed(MouseEvent e)
            {
                TownPlan.this.pic=0;
            }
            public void mouseReleased(MouseEvent e)
            {
                TownPlan.this.pic=25;

            }
            public void mouseExited(MouseEvent e)
            {
                 messageBar.setMessage(" ");
            }

        });

        y.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent e)
                {
                    messageBar.setMessage("交通工具");
                }

            }
        );

        z.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(TownPlan.this.activePage.state == Page.State.actived)
                {
                    activePage.state = Page.State.ready2creat;

                }

            }
            public void mousePressed(MouseEvent e)
            {
                TownPlan.this.pic=0;
            }
            public void mouseReleased(MouseEvent e)
            {
                TownPlan.this.pic=26;
            }
            public void mouseExited(MouseEvent e)
            {
                 messageBar.setMessage(" ");
            }

        });

        z.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent e)
                {
                    messageBar.setMessage("交通工具");
                }

            }
        );

        aa.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(TownPlan.this.activePage.state == Page.State.actived)
                {
                    activePage.state = Page.State.ready2creat;

                }

            }
            public void mousePressed(MouseEvent e)
            {
                TownPlan.this.pic=0;
            }
            public void mouseReleased(MouseEvent e)
            {
                TownPlan.this.pic=27;
            }
            public void mouseExited(MouseEvent e)
            {
                 messageBar.setMessage(" ");
            }
        });

        aa.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent e)
                {
                    messageBar.setMessage("交通工具");
                }

            }
        );

        ab.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(TownPlan.this.activePage.state == Page.State.actived)
                {
                    activePage.state = Page.State.ready2creat;

                }

            }
            public void mousePressed(MouseEvent e)
            {
                TownPlan.this.pic=0;
            }
            public void mouseReleased(MouseEvent e)
            {
                TownPlan.this.pic=28;

            }
            public void mouseExited(MouseEvent e)
            {
                 messageBar.setMessage(" ");
            }
        });

        ab.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent e)
                {
                    messageBar.setMessage("居民");
                }

            }
        );

        ac.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(TownPlan.this.activePage.state == Page.State.actived)
                {
                    activePage.state = Page.State.ready2creat;

                }

            }
            public void mousePressed(MouseEvent e)
            {
                TownPlan.this.pic=0;
            }
            public void mouseReleased(MouseEvent e)
            {
                TownPlan.this.pic=29;
            }
            public void mouseExited(MouseEvent e)
            {
                 messageBar.setMessage(" ");
            }

        });

        ac.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent e)
                {
                    messageBar.setMessage("居民");
                }

            }
        );

        ad.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(TownPlan.this.activePage.state == Page.State.actived)
                {
                    activePage.state = Page.State.ready2creat;

                }

            }
            public void mousePressed(MouseEvent e)
            {
                TownPlan.this.pic=0;
            }
            public void mouseReleased(MouseEvent e)
            {
                TownPlan.this.pic=30;
            }
            public void mouseExited(MouseEvent e)
            {
                 messageBar.setMessage(" ");
            }

        });

        ad.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent e)
                {
                    messageBar.setMessage("居民");
                }

            }
        );

        ae.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(TownPlan.this.activePage.state == Page.State.actived)
                {
                    activePage.state = Page.State.ready2creat;

                }

            }
            public void mousePressed(MouseEvent e)
            {
                TownPlan.this.pic=0;
            }
            public void mouseReleased(MouseEvent e)
            {
                TownPlan.this.pic=31;
            }
            public void mouseExited(MouseEvent e)
            {
                 messageBar.setMessage(" ");
            }

        });

        ae.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent e)
                {
                    messageBar.setMessage("居民");
                }

            }
        );

        af.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(TownPlan.this.activePage.state == Page.State.actived)
                {
                    activePage.state = Page.State.ready2creat;

                }

            }
            public void mousePressed(MouseEvent e)
            {
                TownPlan.this.pic=0;
            }
            public void mouseReleased(MouseEvent e)
            {
                TownPlan.this.pic=32;
            }
            public void mouseExited(MouseEvent e)
            {
                 messageBar.setMessage(" ");
            }

        });

        af.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent e)
                {
                    messageBar.setMessage("居民");
                }

            }
        );

        ag.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(TownPlan.this.activePage.state == Page.State.actived)
                {
                    activePage.state = Page.State.ready2creat;

                }

            }
            public void mousePressed(MouseEvent e)
            {
                TownPlan.this.pic=0;
            }
            public void mouseReleased(MouseEvent e)
            {
                TownPlan.this.pic=33;

            }
            public void mouseExited(MouseEvent e)
            {
                 messageBar.setMessage(" ");
            }

        });

        ag.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent e)
                {
                    messageBar.setMessage("居民");
                }

            }
        );

        ah.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(TownPlan.this.activePage.state == Page.State.actived)
                {
                    activePage.state = Page.State.ready2creat;

                }

            }
            public void mousePressed(MouseEvent e)
            {
                TownPlan.this.pic=0;
            }
            public void mouseReleased(MouseEvent e)
            {
                TownPlan.this.pic=34;
            }
            public void mouseExited(MouseEvent e)
            {
                 messageBar.setMessage(" ");
            }

        });

        ah.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent e)
                {
                    messageBar.setMessage("居民");
                }

            }
        );

        ai.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(TownPlan.this.activePage.state == Page.State.actived)
                {
                    activePage.state = Page.State.ready2creat;

                }

            }
            public void mousePressed(MouseEvent e)
            {
                TownPlan.this.pic=0;
            }
            public void mouseReleased(MouseEvent e)
            {
                TownPlan.this.pic=35;
            }
            public void mouseExited(MouseEvent e)
            {
                 messageBar.setMessage(" ");
            }

        });

        ai.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent e)
                {
                    messageBar.setMessage("居民");
                }

            }
        );

        aj.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(TownPlan.this.activePage.state == Page.State.actived)
                {
                    activePage.state = Page.State.ready2creat;

                }

            }
            public void mousePressed(MouseEvent e)
            {
                TownPlan.this.pic=0;
            }
            public void mouseReleased(MouseEvent e)
            {
                TownPlan.this.pic=36;

            }
            public void mouseExited(MouseEvent e)
            {
                 messageBar.setMessage(" ");
            }

        });

        aj.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent e)
                {
                    messageBar.setMessage("居民");
                }

            }
        );

        ak.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(TownPlan.this.activePage.state == Page.State.actived)
                {
                    activePage.state = Page.State.ready2creat;

                }

            }
            public void mousePressed(MouseEvent e)
            {
                TownPlan.this.pic=0;
            }
            public void mouseReleased(MouseEvent e)
            {
                TownPlan.this.pic=37;

            }
            public void mouseExited(MouseEvent e)
            {
                 messageBar.setMessage(" ");
            }

        });

        ak.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent e)
                {
                    messageBar.setMessage("商店");
                }

            }
        );

        al.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(TownPlan.this.activePage.state == Page.State.actived)
                {
                    activePage.state = Page.State.ready2creat;

                }

            }
            public void mousePressed(MouseEvent e)
            {
                TownPlan.this.pic=0;
            }
            public void mouseReleased(MouseEvent e)
            {
                TownPlan.this.pic=38;

            }
            public void mouseExited(MouseEvent e)
            {
                 messageBar.setMessage(" ");
            }

        });

        al.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent e)
                {
                    messageBar.setMessage("路");
                }

            }
        );



        muen.addP(a);
        muen.addP(b);
        muen.addP(c);
        muen.addP(d);
        muen.addP(e);
        muen.addP(f);

        muen.addP(g);
        muen.addP(h);
        muen.addP(i);
        muen.addH(j);
        muen.addH(k);
        muen.addH(l);

        muen.addH(m);
        muen.addH(n);
        muen.addH(o);
        muen.addH(p);
        muen.addH(q);
        muen.addH(r);

        muen.addV(s);
        muen.addV(t);
        muen.addV(u);
        muen.addV(v);
        muen.addV(w);
        muen.addV(x);



        muen.addV(y);
        muen.addV(z);
        muen.addV(aa);
        muen.addG(ab);
        muen.addG(ac);
        muen.addG(ad);

        muen.addG(ae);
        muen.addG(af);
        muen.addG(ag);
        muen.addG(ah);
        muen.addG(ai);
        muen.addG(aj);

        muen.addS(ak);
        muen.addS(al);




        muen.setVisible(false);

        open=new ImageIcon("icon/open.gif");
        openBtn = new JButton(open);
        openBtn.setText("開啟");
        openBtn.setBackground(Color.YELLOW);
        openBtn.addMouseListener( new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                JFileChooser s = new JFileChooser("background/");
                FileNameExtensionFilter filter = new FileNameExtensionFilter("gif & jpg Images", "jpg", "gif");
                s.setFileFilter(filter);
                s.showDialog(null, "選取檔案");
                
		try {
                    originalImage = ImageIO.read(s.getSelectedFile());
                } catch (Exception ee) {
                   return;
                }
                copyBtn.setEnabled(false);
                clearBtn.setEnabled(false);
                finBtn.setEnabled(false);
                enableBtn.setEnabled(true);
                activePage.back=originalImage;
                activePage.repaint();
                
                TownPlan.this.setVisible(true);
                
            }
            public void mouseExited(MouseEvent e)
            {
                 messageBar.setMessage(" ");
            }
        });
        
        openBtn.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent e)
                {
                    messageBar.setMessage("開啟舊檔");
                }

            }
        );
        toolBar.add(openBtn);
        en=new ImageIcon("icon/en.gif");
        enableBtn = new JButton(en);
        enableBtn.setText("建造");
        enableBtn.setBackground(Color.YELLOW);
        enableBtn.addMouseListener( new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                activePage.line=true;
                move=true;
                activePage.repaint();
                muen.setVisible(true);
                copyBtn.setEnabled(true);
                clearBtn.setEnabled(true);
                finBtn.setEnabled(true);
                enableBtn.setEnabled(false);
                TownPlan.this.activePage.state = Page.State.actived;
                TownPlan.this.setVisible(true);
               
            }
            public void mouseExited(MouseEvent e)
            {
                 messageBar.setMessage(" ");
            }
        });

        enableBtn.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent e)
                {
                    messageBar.setMessage("建造");
                }

            }
        );
        
        finBtn = new JButton();
        finBtn.setText("完成");
        finBtn.setBackground(Color.YELLOW);
        finBtn.addMouseListener( new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(activePage.activeObject!=null){
                    activePage.activeObject.hide8Points();
                    activePage.activeObject.state=MyObject.State.inactived;
                }
                move=false;
                muen.setVisible(false);
                copyBtn.setEnabled(false);
                clearBtn.setEnabled(false);
                finBtn.setEnabled(false);
                enableBtn.setEnabled(true);
                activePage.line=false;
                if(activePage.back==null){
                    Toolkit toolkit=Toolkit.getDefaultToolkit();
                    activePage.back=toolkit.getImage("background/green.jpg");
                }
                activePage.repaint();
                TownPlan.this.activePage.state = Page.State.inactived;
                TownPlan.this.setVisible(true);

            }
            public void mouseExited(MouseEvent e)
            {
                 messageBar.setMessage(" ");
            }
        });

        finBtn.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent e)
                {
                    messageBar.setMessage("完成");
                }

            }
        );
        finBtn.setEnabled(false);
        

        //making  BUG
        save=new ImageIcon("icon/save.gif");
        saveBtn = new JButton(save);
        saveBtn.setText("儲存");
        saveBtn.setBackground(Color.YELLOW);
        saveBtn.addMouseListener( new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                FileDialog fileDialog = new FileDialog( new Frame() , "請指定一個檔名", FileDialog.SAVE );
                fileDialog.show();
                if(fileDialog.getFile()==null) return;
                activePage.filename = fileDialog.getDirectory()+fileDialog.getFile();
                
                BufferedImage image = new BufferedImage(activePage.getWidth(), activePage.getHeight(), BufferedImage.TYPE_INT_RGB);
                Graphics g2 = image.createGraphics();
                activePage.paint(g2);
                g2.dispose();

                try{
                    int dotpos = activePage.filename.lastIndexOf('.');
                    ImageIO.write(image, activePage.filename.substring(dotpos + 1), new File(activePage.filename));
                }
		catch(IOException even) {
                    JOptionPane.showMessageDialog(null, even.toString(),"無法儲存圖檔", JOptionPane.ERROR_MESSAGE);
		}
                copyBtn.setEnabled(false);
                clearBtn.setEnabled(false);
                finBtn.setEnabled(false);
                enableBtn.setEnabled(true);
           
            }
            public void mouseExited(MouseEvent e)
            {
                 messageBar.setMessage(" ");
            }
        });
        saveBtn.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent e)
                {
                    messageBar.setMessage("儲存頁面");
                }

            }
        );

        toolBar.add(saveBtn);
        

        ne=new ImageIcon("icon/new.gif");
        newPageBtn = new JButton(ne);
        newPageBtn.setText("新增");
        newPageBtn.setBackground(Color.YELLOW);
        newPageBtn.addMouseListener( new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                //使"上一頁"按鈕有功能(因為有預設頁面，所以再按一次上一頁就可以有作用了)
                if(curPageNum ==1 )
                {
                    prevPageBtn.setEnabled(true);
                    delPageBtn.setEnabled(true);
                }
                //使"下一頁"按鈕有功能(只要現在頁面不是最後一頁)
                if(curPageNum !=totalPageNum)
                {
                    nextPageBtn.setEnabled(true);
                }
                
                delPageBtn.setEnabled(true);
                activePage.setVisible(false);
                copyBtn.setEnabled(true);
                clearBtn.setEnabled(true);
                enableBtn.setEnabled(true);
                Page p = new Page(TownPlan.this);
                activePage = p;

                pages.add( curPageNum ,p );
                TownPlan.this.add(activePage, BorderLayout.CENTER);
                //總頁面數+1
                totalPageNum++;
                //現在頁面+1
                curPageNum++;
                messageBar.showPageInfo(curPageNum,totalPageNum);
                //messageBar.setMessage("Object Painter is Running!");
                //視窗更新

                TownPlan.this.setVisible(true);
            }
            public void mouseExited(MouseEvent e)
            {
                 messageBar.setMessage(" ");
            }
            
        }
        );
        newPageBtn.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent e)
                {
                    messageBar.setMessage("開新頁面");
                }
                
            }
        );

        toolBar.add(newPageBtn);

        
        pre=new ImageIcon("icon/undo.gif");
        prevPageBtn = new JButton(pre);
        prevPageBtn.setText("上一頁");
        prevPageBtn.setBackground(Color.YELLOW);
        prevPageBtn.addMouseListener( new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                TownPlan.this.activePage.state = Page.State.inactived;
                //要有兩頁以上才有"上一頁"的功能
                if(curPageNum >=2)
                {
                    activePage.setVisible(false);

                    /*       去頁面集合 取出"上一頁"的頁面
                             cur  1   2   3   4
                           pages  0   1   2   3   (因程式從零開始)
                           所以如要取出"上一頁"  要減2                */
                    activePage = pages.get(curPageNum -2);
                    activePage.setVisible(true);
                    curPageNum--;
                    messageBar.showPageInfo(curPageNum, totalPageNum);
                    TownPlan.this.setVisible(true);

                }

                //如果現在頁面不只一頁
                if(totalPageNum>1)
                {
                    //預設刪除鍵、下一頁、上一頁功能全開
                    delPageBtn.setEnabled(true);
                    nextPageBtn.setEnabled(true);
                    prevPageBtn.setEnabled(true);
                    //現在在第一頁
                    if(curPageNum==1)
                    {   //"上一頁"鍵 關閉功能
                        prevPageBtn.setEnabled(false);
                    }
                    //現在在最後一頁
                    else if(curPageNum ==totalPageNum)
                    {   //"下一頁"  關閉功能
                        nextPageBtn.setEnabled(false);
                    }
                }
                
                delPageBtn.setEnabled(true);
                TownPlan.this.activePage.state = Page.State.actived;

            }
            public void mouseExited(MouseEvent e)
            {
                 messageBar.setMessage(" ");
            }
        }
        );
        prevPageBtn.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent e)
                {
                    messageBar.setMessage("上一頁");
                }

            }
        );

        prevPageBtn.setEnabled(false);
        toolBar.add(prevPageBtn);

        nex=new ImageIcon("icon/redo.gif");
        nextPageBtn = new JButton(nex);
        nextPageBtn.setText("下一頁");
        nextPageBtn.setBackground(Color.YELLOW);
        nextPageBtn.addMouseListener( new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                TownPlan.this.activePage.state = Page.State.inactived;
                //如果現在頁面不是最後一頁
                if(curPageNum !=totalPageNum)
                {
                    activePage.setVisible(false);

                    /*       去頁面集合 取出"下一頁"的頁面
                             cur  1   2   3   4
                           pages  0   1   2   3   (因程式從零開始)
                           所以如要取出"下一頁"   輸入curPageNum一樣的值       */
                    activePage = pages.get(curPageNum);
                    activePage.setVisible(true);
                    //現在頁面+1
                    curPageNum++;
                    messageBar.showPageInfo(curPageNum, totalPageNum);
                    //視窗更新
                    TownPlan.this.setVisible(true);

                }
                //如果現在頁面不只一頁
                if(totalPageNum>1)
                {
                    //預設刪除鍵、下一頁、上一頁功能全開
                    delPageBtn.setEnabled(true);
                    nextPageBtn.setEnabled(true);
                    prevPageBtn.setEnabled(true);
                    //現在在第一頁
                    if(curPageNum==1)
                    {   //"上一頁"鍵 關閉功能
                        prevPageBtn.setEnabled(false);
                    }
                    //現在在最後一頁
                    else if(curPageNum ==totalPageNum)
                    {   //"下一頁"  關閉功能
                        nextPageBtn.setEnabled(false);
                    }

                }
                
                delPageBtn.setEnabled(true);
                TownPlan.this.activePage.state = Page.State.actived;


            }
            public void mouseExited(MouseEvent e)
            {
                 messageBar.setMessage(" ");
            }
        }
        );
        nextPageBtn.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent e)
                {
                    messageBar.setMessage("下一頁");
                }

            }
        );

        nextPageBtn.setEnabled(false);
        toolBar.add(nextPageBtn);

        del=new ImageIcon("icon/delete.gif");
        delPageBtn = new JButton(del);
        delPageBtn.setText("刪除");
        delPageBtn.setBackground(Color.YELLOW);
        delPageBtn.addMouseListener( new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                //如果現在頁面不是最後一頁
                if(totalPageNum >1)
                {
                    activePage.setVisible(false);

                    pages.remove(curPageNum -1);
                    if(curPageNum==totalPageNum)
                    {
                        activePage = pages.get(curPageNum -2);
                        curPageNum--;
                    }else
                    {
                        activePage = pages.get(curPageNum-1);
                    }

                    activePage.setVisible(true);

                    //總頁面-1
                    totalPageNum--;
                    messageBar.showPageInfo(curPageNum, totalPageNum);
                    TownPlan.this.setVisible(true);

                }
                else
                {   //可以刪除預設頁
                    activePage.setVisible(false);
                    pages.remove(curPageNum -1);
                    curPageNum--;
                    totalPageNum--;
                    messageBar.showPageInfo(curPageNum, totalPageNum);
                    TownPlan.this.setVisible(true);
                }

                //如果現在頁面不只一頁
                if(totalPageNum>1)
                {
                    //預設刪除鍵、下一頁、上一頁功能全開
                    delPageBtn.setEnabled(true);
                    nextPageBtn.setEnabled(true);
                    prevPageBtn.setEnabled(true);
                    //現在在第一頁
                    if(curPageNum==1)
                    {   //"上一頁"鍵 關閉功能
                        prevPageBtn.setEnabled(false);
                    }
                    //現在在最後一頁
                    else if(curPageNum ==totalPageNum)
                    {   //"下一頁"  關閉功能
                        nextPageBtn.setEnabled(false);
                    }

                }
                //如果現在頁面只有一頁(預設頁)
                else if(totalPageNum==1)
                {   //"上一頁"鍵 "刪除"鍵 "下一頁"鍵 關閉功能
                    prevPageBtn.setEnabled(false);
                    nextPageBtn.setEnabled(false);
                    enableBtn.setEnabled(false);
                }
                else if(totalPageNum==0)
                {
                    delPageBtn.setEnabled(false);
                    copyBtn.setEnabled(false);
                    clearBtn.setEnabled(false);
                    enableBtn.setEnabled(false);
                    messageBar.setMessage("現在沒有頁面!! 請新增頁面");
                }

            }
            public void mouseExited(MouseEvent e)
            {
                if(totalPageNum!=0)
                {
                    messageBar.setMessage(" ");
                }
            }
        }
        );
        delPageBtn.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent e)
                {
                    if(totalPageNum!=0)
                    {
                        messageBar.setMessage("刪除此頁");
                    }
                    else{
                        messageBar.setMessage("現在沒有頁面!! 請新增頁面");
                    }
                }

            }
        );

        delPageBtn.setEnabled(true);
        toolBar.add(delPageBtn);

        copy=new ImageIcon("icon/copy.gif");
        copyBtn = new JButton(copy);
        copyBtn.setText("複製");
        copyBtn.setBackground(Color.YELLOW);
        copyBtn.addMouseListener( new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if((activePage.activeObject!=null)&&(move==true))
                {
                    activePage.s=activePage.s+30;
                    int w=activePage.activeObject.getWidth();
                    int h=activePage.activeObject.getHeight();
                    tempObject=new MyObject(activePage,activePage.activeObject.npic);
                    tempObject.setLocation(activePage.s,activePage.s);
                    tempObject.setSize(w,h);
                    tempObject.show8Points();
                    activePage.add(tempObject);
                }
                
            }
            public void mouseExited(MouseEvent e)
            {
                messageBar.setMessage(" ");

            }
        });
        copyBtn.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent e)
                {
                    messageBar.setMessage("複製建築物");
                }

            }
        );
        copyBtn.setEnabled(false);
        toolBar.add(copyBtn);

        clear=new ImageIcon("icon/tool6.gif");
        clearBtn = new JButton(clear);
        clearBtn.setText("清除");
        clearBtn.setBackground(Color.YELLOW);
        clearBtn.addMouseListener( new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if((activePage.activeObject!=null)&&(move==true))
                {
                    activePage.activeObject.hide8Points();
                    activePage.activeObject.setVisible(false);
                    activePage.remove(activePage.activeObject);
                }
                
            }
            public void mouseExited(MouseEvent e)
            {
                messageBar.setMessage(" ");

            }
        });
        clearBtn.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent e)
                {
                    messageBar.setMessage("拆除建築物");
                }

            }
        );

        clearBtn.setEnabled(false);
        toolBar.add(clearBtn);

        toolBar.add(enableBtn);
        toolBar.add(finBtn);

        abo=new ImageIcon("icon/rood.gif");
        aboutBtn = new JButton(abo);
        aboutBtn.setText("關於");
        aboutBtn.setBackground(Color.YELLOW);
        aboutBtn.addMouseListener( new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
               JOptionPane.showMessageDialog(null, "程式名稱：Town Plan\n製作群：第五團隊成員\n                  宏大、小夫、阿忠、\n                  香蕉、項羽\n\n版本：3.6+ test\n", "關於 城市規劃 V3.6+ test", 1, new ImageIcon("image/rood.gif"));
            }
            public void mouseExited(MouseEvent e)
            {
                messageBar.setMessage(" ");

            }
        });
        aboutBtn.addMouseMotionListener
        (
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent e)
                {
                    messageBar.setMessage("關於");
                }

            }
        );
        toolBar.add(aboutBtn);

        messageBar = new MessageBar();
        this.add(messageBar, BorderLayout.SOUTH);

        Page p = new Page(this);
        activePage = p;
        //activePage.state = Page.State.inactived;
        pages.add(p);
        this.add(activePage, BorderLayout.CENTER);
        //視窗更新
        this.setVisible(true);

    }

}




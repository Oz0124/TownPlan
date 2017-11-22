
package townplan;
import java.awt.*;


//訊息列
public class MessageBar extends Panel{

    //左邊文字空間(現在執行動作)
    private TextField tf;
    //右邊文字空間(現在頁面/總頁面數)
    private TextField pageInfo;

    MessageBar()
    {
        this.setLayout(new BorderLayout());
        tf=new TextField("TownPlan is Running!");
        tf.setBackground(Color.lightGray);
        tf.setEditable(false);
        this.add(tf,BorderLayout.CENTER);

        pageInfo=new TextField("1/1");
        pageInfo.setBackground(Color.lightGray);
        pageInfo.setEditable(false);
        this.add(pageInfo,BorderLayout.EAST);
    }

    //現在頁面與總頁面提示
    void showPageInfo(int c, int t)
    {
        pageInfo.setText("" + c + "/" + t);
    }

    //現在動作 提示
    void setMessage(String str)
    {
        if(str == null)
        {
            tf.setText("");
        }
        else
        {
            tf.setText(str);
        }
    }


}

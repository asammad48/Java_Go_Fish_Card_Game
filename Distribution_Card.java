
package cardsgame;


public class Distribution_Card {
    public static Player_Node Distribute_Card(Player_Node head,String card)
   {
       Player_Node Current;
       Player_Node temp;
       if(head==null)
       {
           head=new Player_Node();
           head.card=card;
           head.link=null;
       }
       else
       {
           Current=head;
           while(Current.link!=null)
           {
               Current=Current.link;
           }
           temp=new Player_Node();
           temp.card=card;
           temp.link=null;
           Current.link=temp;
       }
       return head;
   }
}

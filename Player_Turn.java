/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardsgame;

/**
 *
 * @author Abdul Sammad
 */
public class Player_Turn {
    public static Player_Node Player_Turn(Player_Node p)
    {
        Player_Node i=p,ipre=p;
        int counti=0;
        while(i!=null)
        {
            
            Player_Node j=p;
            while(j!=null)
            {
                if(j.link!=i.link)
                {
                    if(j.card.equals(i.card))
                    {
                        System.out.println("Total visit");
                        p=Delete_Node(i,ipre,p);
                        Player_Node jpre=p;
                        int new_iterate=0;
                        while(jpre.link!=j)
                        {
                            if(jpre.link==j)
                            {
                                break;
                            }
                            if(jpre==j)
                            {
                                break;
                            }
                           if(new_iterate!=0)
                           {
                               jpre=jpre.link;
                           }
                           new_iterate++;
                        }
                        p=Delete_Node(j,jpre,p);
                        i.link=null;
                        j.link=null;
                        break;
                        
                       
                    }
                }
                j=j.link;
            }
            if(counti!=0&&ipre.link!=null)
            {
                ipre=ipre.link;
            }
            counti++;
            i=i.link;
        }
        return p;
    }
    public static Player_Node Delete_Node(Player_Node del_node,Player_Node pre_node,Player_Node head)
    {
        if(del_node==head)
        {
            head=head.link;
        }
        else if(del_node.link==null)
        {
            pre_node.link=null;
        }
        else
        {
            pre_node.link=del_node.link;
        }
        return head;
    }
    public static Player_Node[] Search(String Card,Player_Node head,Player_Node Other_Node_Head)
    {
        int card_equal=0;
        Player_Node[] heads=new Player_Node[2];
        Player_Node i=head,ipre=head;
        int counti=0;
        while(i!=null)
        {
            if(i.card.equals(Card))
            {
                card_equal=1;
                head=Delete_Node(i,ipre,head);
                Other_Node_Head=new Distribution_Card().Distribute_Card(Other_Node_Head,Card);
               heads[0]=head;
               heads[1]=Other_Node_Head;
                break;
            }
            if(counti!=0)
            {
                ipre=ipre.link;
            }
            counti++;
            i=i.link;
        }
        if(card_equal==0)
        {   new CardsGame().deck_top--;
            System.out.println(new CardsGame().deck_top); 
             Other_Node_Head=new Distribution_Card().Distribute_Card(Other_Node_Head,new CardsGame().deck[new CardsGame().deck_top]);
              heads[0]=head;
               heads[1]=Other_Node_Head;
        }
        return heads;
    }
}

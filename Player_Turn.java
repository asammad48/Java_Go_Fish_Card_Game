package cardsgame;
public class Player_Turn {
    static int Cards_which_equal=0;
    public static Player_Node Player_Turn(Player_Node p)
    {   Cards_which_equal=0;
        int Player=1;
        if(p==new CardsGame().Computer_Head)
        {
            Player=0;
        }
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
                        Cards_which_equal=1;
                        //System.out.println("Total visit");
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
        if(Cards_which_equal==0)
        {
            if(new CardsGame().player_turn==1)
            {
                new CardsGame().player_turn=0;
            }
            else
            {
                new CardsGame().player_turn=1;
            }
        }
        if(Cards_which_equal==1)
        {
            if(Player==1)
            {
                new CardsGame().Player_Pair++;
            }
            else
            {
                new CardsGame().Computer_Pair++;
            }
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
        {   
            new CardsGame().deck_top--;
            if(new CardsGame().deck_top!=-1)
            {
              //System.out.println(new CardsGame().deck_top); 
            Other_Node_Head=new Distribution_Card().Distribute_Card(Other_Node_Head,new CardsGame().deck[new CardsGame().deck_top]);  
            }
            else
            {
                new CardsGame().deck_top++;
            }
            
            heads[0]=head;
            heads[1]=Other_Node_Head;
        }
        return heads;
    }
}

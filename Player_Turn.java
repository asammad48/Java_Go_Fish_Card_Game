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
    public Player_Node Player_Turn(Player_Node p)
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
                        p=Delete_Node(i,ipre,p);
                        Player_Node jpre=p;
                        int new_iterate=0;
                        while(jpre.link!=j)
                        {
                           if(new_iterate!=0)
                           {
                               jpre=jpre.link;
                           }
                           new_iterate++;
                        }
                        p=Delete_Node(j,jpre,p);
                        break;
                    }
                }
                j=j.link;
            }
            if(counti!=0)
            {
                ipre=ipre.link;
            }
            counti++;
            i=i.link;
        }
        return p;
    }
    public Player_Node Delete_Node(Player_Node del_node,Player_Node pre_node,Player_Node head)
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
}

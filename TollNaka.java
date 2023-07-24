import java.util.*;
public class Queue_App {
    Scanner sc=new Scanner(System.in);
    h0 nod0=new h0();
    h1 nod1=new h1();
    h2 nod2=new h2();
    Node Head0,Head1,Head2;
    class Node{
        String name;
        int data;
        Node next;
        Node(int data,String name){
            this.data=data;
            this.name=name;
        }
    }
    class h0{
        int cnt;
        Node front;
        Node rare;
    }
    class h1{
        int cnt;
        Node front;
        Node rare;
    }
    class h2{
        int cnt;
        Node front;
        Node rare;
    }
    public static void main(String[] args) {
        Queue_App List=new Queue_App();
        int P, op=0,ch,flag=1;
        System.out.println("*------------------------* TOLL NAKA *------------------------*\n                          Welcome");
        Scanner sc=new Scanner(System.in);
        do {
            System.out.print("Menu : \n0)Exit\n1.Vehicle Entering\n2.Vehicle Processing\n3.Next Processed Vehicle\n4.Last Processed vehicle\n5.Number of vehicles to be processed");
            System.out.print("\nEnter your choice : ");
            ch=sc.nextInt();
            switch(ch){
                case 0:{
                    flag=0;
                    break;
                }
                case 1: {
                    do {
                        int t = 0;
                        System.out.println("Vehicles Classifications : \n1.VIP\n2.Light vehicle\n3.Heavy Vehicle");
                        System.out.println("Enter vehicles Classification No. : ");
                        t = sc.nextInt();
                        System.out.println("Enter Name of Owner of Vehicle : ");
                        String name = sc.next();
                        System.out.println("Enter Number of Vehicle : ");
                        int data = sc.nextInt();
                        if (t == 1) {
                            List = List.CreateL0(List, data, name);
                        } else if (t == 2) {
                            List = List.CreateL1(List, data, name);
                        } else if (t == 3) {
                            List = List.CreateL2(List, data, name);
                        } else {
                            System.out.println("Enter proper choice ! ");
                        }
                        System.out.print("Is there another Vehicle coming forward ?\n1.Yes\n2.No\nEnter your choice : ");
                        P = sc.nextInt();
                    } while (P == 1);
                    break;
                }
                case 2:{
                    List.Dqueue(List);
                    break;
                }
                case 3:{
                    List.Front();
                    break;
                }
                case 4:{
                    List.Rare();
                    break;
                }
                case 5:{
                    List.cnt();
                    break;
                }

            }
            if(flag==0){
                op=0;
                break;
            }else{
                System.out.println("\ndo you want to continue Program?\n1.Yes\n2.No\nEnter your choice : ");
                op= sc.nextInt();}

        }while(op==1);
    }
    Queue_App CreateL0(Queue_App List,int data,String name){
        Node newnode = new Node(data,name);
        if(List.Head0==null){
            List.Head0=newnode;
            nod0.front=newnode;
            nod0.rare=newnode;
            nod0.cnt++;
        }else{
            Node last=List.Head0;
            while(last.next!=null){
                last=last.next;
            }
            last.next=newnode;
            nod0.rare=newnode;
            nod0.cnt++;
        }
        return List;
    }
    Queue_App CreateL1(Queue_App List,int data,String name){
        Node newnode = new Node(data,name);
        if(List.Head1==null){
            List.Head1=newnode;
            nod1.front=newnode;
            nod1.rare=newnode;
            nod1.cnt++;
        }else{
            Node last=List.Head1;
            while(last.next!=null){
                last=last.next;
            }
            last.next=newnode;
            nod1.rare=newnode;
            nod1.cnt++;
        }
        return List;
    }
    Queue_App CreateL2(Queue_App List,int data,String name){
        Node newnode = new Node(data,name);
        if(List.Head2==null){
            List.Head2=newnode;
            nod2.front=newnode;
            nod2.rare=newnode;
            nod2.cnt++;
        }else{
            Node last=List.Head2;
            while(last.next!=null){
                last=last.next;
            }
            last.next=newnode;
            nod2.rare=newnode;
            nod2.cnt++;
        }
        return List;
    }
    void Dqueue(Queue_App List){
        if(List.Head0==null)
        {
            if(List.Head1==null){
                if(List.Head2==null){
                    System.out.println("No Vehicle available to Process");
                }else{
                    System.out.println("Processed Vehicle : "+nod2.front.name+"\t\t"+nod2.front.data);
                    Head2=Head2.next;
                    nod2.front=Head2;
                    nod2.cnt--;
                }
            }else{
                System.out.println("Processed Vehicle : "+nod1.front.name+"\t\t"+nod1.front.data);
                Head1=Head1.next;
                nod1.front=Head1;
                nod1.cnt--;
            }
        }else{
            System.out.println("Processed Vehicle : "+nod0.front.name+"\t\t"+nod0.front.data);
            Head0=Head0.next;
            nod0.front=Head0;
            nod0.cnt--;
        }
    }
    void Front(){
        if(nod0.cnt==0){
            if(nod1.cnt==0){
                if(nod2.cnt==0){
                    System.out.println("No Vehicle available to Process");
                }else {
                    System.out.println("Vehicle to be processed : "+nod2.front.name+"\t\t"+nod2.front.data);
                }
            }else{
                System.out.println("Vehicle to be processed : "+nod1.front.name+"\t\t"+nod1.front.data);
            }
        }else{
            System.out.println("Vehicle to be processed : "+nod0.front.name+"\t\t"+nod0.front.data);
        }
    }
    void Rare(){
        if(nod2.cnt==0){
            if(nod1.cnt==0){
                if(nod0.cnt==0){
                    System.out.println("No Vehicle available");
                }else{
                    System.out.println("Last Vehicle to be processed : "+nod0.rare.name+"\t\t"+nod0.rare.data);
                }
            }else{
                System.out.println("Last Vehicle to be processed : "+nod1.rare.name+"\t\t"+nod1.rare.data);
            }
        }else{
            System.out.println("Last Vehicle to be processed : "+nod2.rare.name+"\t\t"+nod2.rare.data);
        }
    }
    void cnt(){
        int t=nod0.cnt+nod1.cnt+nod2.cnt;
        System.out.println("Number of vehicles to be processed : "+t);
    }
}
// OUTPUT :
//*------------------------* TOLL NAKA *------------------------*
//        Welcome
//        Menu :
//        0)Exit
//        1.Vehicle Entering
//        2.Vehicle Processing
//        3.Next Processed Vehicle
//        4.Last Processed vehicle
//        5.Number of vehicles to be processed
//        Enter your choice : 1
//        Vehicles Classifications :
//        1.VIP
//        2.Light vehicle
//        3.Heavy Vehicle
//        Enter vehicles Classification No. :
//        1
//        Enter Name of Owner of Vehicle :
//        Vaishnavi
//        Enter Number of Vehicle :
//        860
//        Is there another Vehicle coming forward ?
//        1.Yes
//        2.No
//        Enter your choice : 1
//        Vehicles Classifications :
//        1.VIP
//        2.Light vehicle
//        3.Heavy Vehicle
//        Enter vehicles Classification No. :
//        2
//        Enter Name of Owner of Vehicle :
//        Isha
//        Enter Number of Vehicle :
//        848
//        Is there another Vehicle coming forward ?
//        1.Yes
//        2.No
//        Enter your choice : 1
//        Vehicles Classifications :
//        1.VIP
//        2.Light vehicle
//        3.Heavy Vehicle
//        Enter vehicles Classification No. :
//        3
//        Enter Name of Owner of Vehicle :
//        Shriya
//        Enter Number of Vehicle :
//        138
//        Is there another Vehicle coming forward ?
//        1.Yes
//        2.No
//        Enter your choice : 2
//
//        do you want to continue Program?
//        1.Yes
//        2.No
//        Enter your choice :
//        1
//        Menu :
//        0)Exit
//        1.Vehicle Entering
//        2.Vehicle Processing
//        3.Next Processed Vehicle
//        4.Last Processed vehicle
//        5.Number of vehicles to be processed
//        Enter your choice : 2
//        Processed Vehicle : Vaishnavi		860
//
//        do you want to continue Program?
//        1.Yes
//        2.No
//        Enter your choice :
//        1
//        Menu :
//        0)Exit
//        1.Vehicle Entering
//        2.Vehicle Processing
//        3.Next Processed Vehicle
//        4.Last Processed vehicle
//        5.Number of vehicles to be processed
//        Enter your choice : 3
//        Vehicle to be processed : Isha		848
//
//        do you want to continue Program?
//        1.Yes
//        2.No
//        Enter your choice :
//        1
//        Menu :
//        0)Exit
//        1.Vehicle Entering
//        2.Vehicle Processing
//        3.Next Processed Vehicle
//        4.Last Processed vehicle
//        5.Number of vehicles to be processed
//        Enter your choice : 4
//        Last Vehicle to be processed : Shriya		138
//
//        do you want to continue Program?
//        1.Yes
//        2.No
//        Enter your choice :
//        1
//        Menu :
//        0)Exit
//        1.Vehicle Entering
//        2.Vehicle Processing
//        3.Next Processed Vehicle
//        4.Last Processed vehicle
//        5.Number of vehicles to be processed
//        Enter your choice : 5
//        Number of vehicles to be processed : 2
//
//        do you want to continue Program?
//        1.Yes
//        2.No
//        Enter your choice :
//        1
//        Menu :
//        0)Exit
//        1.Vehicle Entering
//        2.Vehicle Processing
//        3.Next Processed Vehicle
//        4.Last Processed vehicle
//        5.Number of vehicles to be processed
//        Enter your choice : 0
//
//        Process finished with exit code 0

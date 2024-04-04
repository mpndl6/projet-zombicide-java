package zombicide.actor;

import zombicide.action.LookAround;
import zombicide.actor.survivor.Survivor;
import zombicide.item.Item;
import zombicide.item.utility.Vial;
import zombicide.item.weapon.*;
import zombicide.map.cell.room.Armory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PNJ extends Actor{

    protected static final String PNJ = "PNJ";
    protected static final int PNJ_LF = 1;
    public static final boolean POSITIVE_RESPONSE =true;
    public static final boolean NEGATIVE_RESPONSE =false;
    protected Armory armory;
    protected List<Item> fabricateObject;
    protected static Random rand = new Random();
    protected static final int MAX_ITEMS =10;
    /**
     * Constrcut a PNJ
     */
    public PNJ() {
        super(PNJ, PNJ_LF);
        this.armory = new Armory();
        super.setCell(this.armory);
        this.fabricateObject = new ArrayList<>();
        this.fabricableObject();
    }

    /**
     *
     * @return
     */
    @Override
    public ActorType getTypeOfActor() {
        return null;
    }

    /**
     *
     */
    protected void fabricableObject(){
        List<Item> items = new ArrayList<>();
        items.add(new Carabine());
        items.add(new Vial());
        items.add(new Axe());
        items.add(new Chainsaw());
        items.add(new Crowbar());
        items.add(new Pistol());
        while (this.fabricateObject.size()!=MAX_ITEMS) {
            int randomIndex = rand.nextInt(items.size());
            Item i = items.get(randomIndex);
            fabricateObject.add(i); // Not on the cell it's just the possible object to create
        }
    }

    /**
     *
     */
    public Item fabricate(){
        int randomIndex = rand.nextInt(fabricateObject.size());
        Item item = fabricateObject.get(randomIndex);
        this.getCell().addItem(item);
        System.out.println("Let's find out what i can make.");
        for (int i = 0; i < 10; i++)
            System.out.print(".");
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("I made a "+item+" if you want it, just put it in you bag.");
        return item;
    }

    public void ameliorate(Weapon w){
        System.out.println("So you want me to ameliorate your weapon? I mean it can be necessary in here. Although you arme will be destroyed if you let them here.");
        //input, quelle arme?
        System.out.println("ok");
        if (!(w instanceof Weapon))
            System.out.println("Give me a weapon, dude.");
        else{
            //ameliorer les damage infligé
        }
    }

    /**
     *
     */
    public boolean welcome(Survivor s){
        System.out.println("Welcome welcome to the Armory.\n As you can see there's no items in this room. NOt yet. Do you want to check ?(Y/N)");
        boolean survivorResponse;
        boolean[] responses= new boolean[2];
        responses[0] = POSITIVE_RESPONSE;
        responses[1] = NEGATIVE_RESPONSE;
        int n = (int)(Math.random() * 1);
        survivorResponse = responses[n];
        if (survivorResponse) {
        System.out.println("OK. Do so.");
        try {
            s.makeAction(new LookAround(s), s);
        }
        catch (Exception e){
            System.out.println("Nah. Can't do this action it seems.");
        }
            System.out.println("You see. Nothing. But I can made some. It will cost you nothing. It's not about money you know. I get bored in here.");
        }
        else{
            System.out.println("OK. Glad for you trust.");
        }
        System.out.println("You see. Nothing. But I can made some. It will cost you nothing. It's not about money you know. I get bored in here.");
        System.out.println("I kill time buy creating enigmas. Do you want to play? If you win i'll make you something. (Y/N)");
        survivorResponse= responses[n];
            if(survivorResponse) {
                System.out.println("LETS PLAY ! I will make you something.");
                return true;
            }
          else {
              System.out.println("Shame man. Maybe another time. Farewell");
            }
        return false;
    }
}

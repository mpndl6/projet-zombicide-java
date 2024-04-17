package zombicide.actor;

import zombicide.action.actionSurvivor.Search;
import zombicide.actor.survivor.Survivor;
import zombicide.item.Item;
import zombicide.item.utility.Vial;
import zombicide.item.weapon.*;
import zombicide.map.cell.room.Armory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class PNJ extends Actor{

    protected static final String PNJ = "PNJ";
    protected static final int PNJ_LF = 1;
    public static final boolean POSITIVE_RESPONSE =true;
    public static final boolean NEGATIVE_RESPONSE =false;
    protected Armory armory;
    public static final int MAX_DAMAGE = 3;
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
      //  items.add(new Pistol());
        while (this.fabricateObject.size()!=MAX_ITEMS) {
            int randomIndex = rand.nextInt(items.size());
            Item i = items.get(randomIndex);
            fabricateObject.add(i); // Not on the cell it's just the possible object to create
        }
    }

    /**
     *
     * @param s
     * @return
     */
    public Weapon getRandomWeapon(Survivor s){
        Random rand = new Random();
        int backPackSize = s.getAllInBackpack().size();
        int n = (int) Math.round(Math.random() * backPackSize);
        List<Item> backPackOfSurvivor = s.getAllInBackpack();
        List<Weapon> weaponsOfSurvivor = new ArrayList<>();
        for (Item i : backPackOfSurvivor){
            if (i instanceof Weapon)
                weaponsOfSurvivor.add((Weapon)i);
        }
        return weaponsOfSurvivor.get(n);
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

    /**
     *
     * @param s
     */
    public void ameliorate(Survivor s){
        System.out.println("So you want me to ameliorate your weapon? I mean it can be necessary in here. Although you arme will be destroyed if you let one here.");
        System.out.println("Which one?");
        System.out.println("The damage can reach + "+MAX_DAMAGE+" damage supplementary.");
        Iterator<Item> it = s.getAllInBackpack().iterator();
        int n = generateRandomInt(MAX_DAMAGE);
        int i = 1;
        while(it.hasNext()){
            System.out.println(i+" - "+ it.next());
        }
        Weapon chosenWeapon = this.getRandomWeapon(s);
        chosenWeapon.increaseDamage(n);
        System.out.println("Your "+chosenWeapon+ " damages has increase of "+n+" damages.\n");
        System.out.println("Farewell");
    }

    /**
     *
     * @param m
     * @return
     */
    public int generateRandomInt(int m){
        return (int) Math.floor(Math.random() * m);
    }

    /**
     *
     */
    public static boolean generateRandomResponse(){
        boolean survivorResponse;
        int n = (int)(Math.random() * 1);
        boolean[] responses= new boolean[2];
        responses[0] = POSITIVE_RESPONSE;
        responses[1] = NEGATIVE_RESPONSE;
        survivorResponse = responses[n];
        if (survivorResponse)
            System.out.println("YES.");
        else{
            System.out.println("NO.");
        }
        return survivorResponse;
    }

    /**
     *
     */
    public boolean welcome(Survivor s){
        System.out.println("Welcome welcome to the Armory.\n As you can see there's no items in this room. NOt yet. Do you want to check ?(Y/N)");
        boolean survivorResponse = generateRandomResponse();
        if (survivorResponse) {
        System.out.println("OK. Do so.");
        try {
            s.makeAction(new Search(s), s);
        }
        catch (Exception e){
            System.out.println("Nah. Can't do this action it seems.");
        }
        }
        else{
            System.out.println("OK. Glad for you trust.");
        }
        System.out.println("But I can made some. It will cost you nothing. It's not about money you know. I get bored in here.");
        System.out.println("I kill time by creating enigmas. Do you want to play? If you win i'll make you something. (Y/N)");
        survivorResponse= generateRandomResponse();
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

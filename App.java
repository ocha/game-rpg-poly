class Character {
    private String name;

    public Character(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void move(){
        System.out.println(" is moving.");
    }
}

class Hero extends Character{
    private String direction;

    public Hero(String name){
        super(name);
    }
    public Hero(String name, String direction){
        super(name);
        this.direction = direction;
    }
    @Override
    public void move (){
        System.out.println(getName() + " is moving.");
    }
    
    public void move (String direction){
        System.out.println( getName() + " is moving " + direction + ".");
    }
}

class Enemy extends Character{
    protected int step;

    public Enemy (String name){
        super(name);
    }
    public Enemy(String name, int step){
        super(name);
        this.step = step;
    }

    @Override
    public void move(){
        System.out.println(getName() + " is moving.");
    }
    public void move (int step){
        if (step <2 ){
        System.out.println( getName() + " is moving " + step + "step.");
        }else {
            System.out.println( getName() + " is moving " + step + " steps.");
        }
    }
}

class Fighter extends Hero{

    public Fighter(String name){
        super(name);
    }
    @Override
    public void move(){
        System.out.println(getName() + " is moving.");
    }  
}

class Witch extends Enemy{

    public Witch(String name){
        super(name);
    }

    @Override
    public void move(){
        System.out.println( getName() + " is moving.");
    }  
}

public class App {
    public static void main(String[] args) {
        // Static polymorphism
        Hero hero = new Hero("vina","left");
        Enemy enemy = new Enemy("niluh", 7);
        hero.move("left"); 
        enemy.move(7);

        // Dynamic polymorphism - reference of Character to Hero, Enemy, Witch, and Fighter objects
        Character harryPotter = new Hero("Harry Potter");
        Character voldemort = new Enemy("Voldemort");
        Character dracoMalfoy = new Witch("Draco Malfoy");
        Character HermioneGranger = new Fighter("Hermione Granger");

        harryPotter.move();
        harryPotter.move();
        voldemort.move();
        dracoMalfoy.move();
        HermioneGranger.move();

        // Dynamic polymorphism - reference of Character to Witch object casted to Fighter object
        Character Author = new Witch("Author");
        Fighter fighter = (Fighter) Author;
        fighter.move();
    }
}


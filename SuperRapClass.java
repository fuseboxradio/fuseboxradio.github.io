// The Superclass = the class in Java that is being inherited from
class Rapper {
    void doesRap() {
        System.out.println("The rapper rhymes.");
    }
}

// Subclass 1 = the 1st class that is inheriting attributes and methods from the SuperClass
// This means that the Dmx class is going to print "The rapper rhymes." due to it calling the superclass method via super.doesRap along with it's own current line
class Dmx extends Rapper {
    void doesRap() {
        super.doesRap(); // Calls the superclass method
        System.out.println("The rapper DMX rhymes and barks.");
    }
}

// Subclass 2 = the 2nd class that is inheriting attributes and methods from the SuperClass
class Nas extends Rapper {
    void doesRap() {
        super.doesRap(); // Calls the superclass method
        System.out.println("The rapper Nas rhymes and talks about street disciples.");
    }
}

// Subclass 3  = the 3rd class that is inheriting attributes and methods from the SuperClass
class BigBoi extends Rapper {
    void doesRap() {
        super.doesRap(); // Call the superclass method
        System.out.println("The rapper Big Boi rhymes and likes the way you move.");
    }
}

// Subclass 4 = the 4th class that is inheriting attributes and methods from the SuperClass
class Doom extends Rapper {
    void doesRap() {
        super.doesRap(); // Call the superclass method
        System.out.println("The rapper DOOM rhymes and likes talking in all caps.");
    }
}

public class SuperRapClass {
    public static void main(String[] args) {
        Rapper rapper = new Rapper();
        Rapper dmx = new Dmx();
        Rapper nas = new Nas();
        Rapper bigboi = new BigBoi();
        Rapper doom = new Doom();

        rapper.doesRap(); // Calls the method from Rapper class
        dmx.doesRap();    // Calls the method from Dmx class and uses super to call the superclass method
        nas.doesRap();    // Calls the method from Nas class and uses super to call the superclass method
        bigboi.doesRap();    // Calls the method from BigBoi class and uses super to call the superclass method
        doom.doesRap();   // Calls the method from Doom class and uses super to call the superclass method
        
        // the classes listed in the public class SuperRapClass above are all going to be executed with their respective printed lines 
    }
}

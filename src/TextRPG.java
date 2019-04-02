import java.util.Random;
import java.util.Scanner;

public class TextRPG {
    public static void main(String[] args) {
        Scanner theScanner = new Scanner(System.in);
        Random rando = new Random();
        boolean battle1;
        //most booleans will determine whether you did something story related and will apply later.
        int quit = 0, race, input, count = 0, number, create = 1, count2 = 0, story = 1, special, weapon = 0, armor = 1, gold = 100, exp = 0;
        String name;
        int hardskills[] = {0, 0, 0, 0, 0, 0};
        //Strength, Dexterity, Constitution, Intelligence, Wisdom, Charisma
        int softskills[] = {10, 10, 1, 1, 1, 1, 1};
        //HP, MaxHP, Attack, Defense, Magic, Magic Defense, Speed
        String races[] = {"Dragonborn", "Dwarf", "Elf", "Gnome", "Half-Elf", "Halfling", "Half-orc", "Human", "Tiefling"};
        String classes[] = {"Generic", "Fighter", "Ranger", "Cleric", "Wizard", "Rogue", "Bard"};
        String weapon_name[] = {"Generic", "Iron Sword", "Wooden Bow", "Tome of Minor Belief", "Staff of Casting Power", "Iron Dagger"};
        String armor_name[] = {"Generic", "Iron Armor", "Cloak of The Forest", "Gard of Believer", "Robe of the Apprentice", "Leather Armor"};
        //Each class corresponds to a class best
        //Fighter-Strength, Rogue-Dexterity, Wizard-Intelligence, Bard-Charisma, Ranger-Constitution, Cleric-Wisdom
        //Bard is a secret class. Haven't decided how to implement.
        do {
            System.out.println("What is your name?");
            name = theScanner.next();
            //getting your name
            do {
                System.out.println("Choose a race");
                System.out.println("1. Dragonborn");
                System.out.println("2. Dwarf");
                System.out.println("3. Elf");
                System.out.println("4. Gnome");
                System.out.println("5. Half-Elf");
                System.out.println("6. Halfling");
                System.out.println("7. Half-orc");
                System.out.println("8. Human");
                System.out.println("9. Tiefling");
                race = theScanner.nextInt();
            }
            //getting your race, which might impact how certain people will talk to you
            while ((race != 1) && (race != 2) && (race != 3) && (race != 4) && (race != 5) && (race != 6) && (race != 7) && (race != 8) && (race != 9));
            for (int a = 0; a < 6; a++) {
                hardskills[a] = rando.nextInt(20) + 1;
                //randomizing stats
            }
            System.out.println("Your current stats are as follows:");
            System.out.println("Strength: " + hardskills[0]);
            System.out.println("Dexterity: " + hardskills[1]);
            System.out.println("Constitution: " + hardskills[2]);
            System.out.println("Intelligence: " + hardskills[3]);
            System.out.println("Wisdom: " + hardskills[4]);
            System.out.println("Charisma: " + hardskills[5]);
            //giving stats
            //then buffing according to race
            switch (race) {
                case (1): {
                    //Dragonborn
                    hardskills[0] = +2;
                    hardskills[5] = +1;
                    break;
                }
                case (2): {
                    //Dwarf
                    hardskills[2] = +2;
                    break;
                }
                case (3): {
                    //Elf
                    hardskills[1] = +2;
                    break;
                }
                case (4): {
                    //Gnome
                    hardskills[3] = +2;
                    break;
                }
                case (5): {
                    //Half-Elf
                    hardskills[5] = +2;
                    hardskills[1] = +1;
                    break;
                }
                case (6): {
                    //Halfling
                    hardskills[1] = +2;
                    hardskills[0] = +1;
                    break;
                }
                case (7): {
                    //Half-orc
                    hardskills[0] = +2;
                    hardskills[2] = +1;
                    break;
                }
                case (8): {
                    //Human
                    System.out.println("Choose the stat you want to decrease. All other stats will be increased by one, while this stat will be decreased by 3.");
                    System.out.println("1. Strength");
                    System.out.println("2. Dexterity");
                    System.out.println("3. Constitution");
                    System.out.println("4. Intelligence");
                    System.out.println("5. Wisdom");
                    System.out.println("6. Charisma");
                    input = theScanner.nextInt() - 1;
                    for (int a = 0; a < 6; a++) {
                        if (a != input) {
                            hardskills[a] += 1;
                        }
                    }
                    break;
                }
                case (9): {
                    //Tiefling
                    hardskills[5] = +2;
                    hardskills[3] = +1;
                    break;
                }
                default: {
                    //you get nothing lol.
                    break;
                }
            }
            //this loop will balance the stats, may fix up later
            for (int a = 0; a < 6; a++) {
                number = rando.nextInt(6);
                if (hardskills[a] > 20) {
                    hardskills[a] = 20;
                    count++;
                    if ((count >= 3) && (hardskills[number] == 20)) {
                        hardskills[number] = hardskills[number] - rando.nextInt(6);
                        count--;
                    }
                }
                if (hardskills[a] < 1) {
                    hardskills[a] = 1;
                    count2++;
                    if (count2 > 1) {
                        hardskills[a] += number;
                    }
                }
            }
            System.out.println("Your name is " + name);
            System.out.println("Your race is " + races[race - 1]);
            System.out.println("Your current stats are as follows:");
            System.out.println("Strength: " + hardskills[0]);
            System.out.println("Dexterity: " + hardskills[1]);
            System.out.println("Constitution: " + hardskills[2]);
            System.out.println("Intelligence: " + hardskills[3]);
            System.out.println("Wisdom: " + hardskills[4]);
            System.out.println("Charisma: " + hardskills[5]);

            System.out.println("Would you like to try again?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            create = theScanner.nextInt();
            //giving all the stats and race etc.
        }
        while (create == 1);
        do {
            do {
                //getting a class in the village
                if (story == 1) {
                    System.out.println("You wake up, only knowing your name, and what skills you posess. You know not your past. You are surronded by forest.");
                    System.out.println("You get up, seeing a path. You follow it, only knowing that you must find a town, and find a group to join in order to survive the night.");
                    System.out.println("You come upon a small town. It has some diverse buildings and people are walking around. There are 5 buildings that attract your attention, with groups that it appears you can join. Where do you go to join?");
                    System.out.println("There is a stone building with two swords crossed above it. You can hear the noise despite being far away, and there are warriors streaming between it and the tavern.");
                    System.out.println("There is a wooden building across the square, similar in size, but more nature-based. The building is covered in greenery, seeming to be melding into the forest. There are people tending to the greenery and shooting at targets at a nearby shooting range.");
                    System.out.println("There is a church, with the emblem of the god Echezarok. There is a light beaming from the top of the building, and there is a faint glow from inside.");
                    System.out.println("There is a large stone tower, with swirling symbols around the base and top. There is a guard at the front, who appears frail and wizened. The tower glows with a purple light.");
                    System.out.println("There is a guard lingering outside of the tavern, at a side doot. A man slinks casually by, nodding at the guard. Soon after, a merchant cries out that a man stole his purse of money, describing him to be like the man you saw enter the Tavern.");
                    System.out.println("1. Go to the building with the Fighters.");
                    System.out.println("2. Go to the building with Rangers.");
                    System.out.println("3. Go to the church.");
                    System.out.println("4. Go to the stone tower");
                    System.out.println("5. Go to the Tavern side-door");
                    special = theScanner.nextInt();

                    switch (special) {
                        case (1): {
                            System.out.println("You walk up to the building and start talking to a human man outside.");
                            System.out.println("With a hearty laugh, he introduces himself as Fenro Venturemoor, Guard of the Adventurer's League.");
                            System.out.println("He welcomes you inside, and you feel as if something has left your mind, while you feel settled, as if a great confusion has also left your mind.");
                            System.out.println("He outfits you with a sword, and some strong armor, then starts introducing you to people.");
                            weapon = 1;
                            armor = 1;
                            System.out.println("He explains that you will have to prove yourself in order to become a full member, but for now, you are welcome");
                            break;
                        }
                        case (2): {
                            System.out.println("You walk up to the building and start talking to a elven woman outside.");
                            System.out.println("She coldly regards you, then says she is Aayla Arborgar, Protecter of the Forest Guard.");
                            System.out.println("She leads you inside, giving a small tour of the public areas, and you feel as if something has left your mind, while you feel settled, as if a great confusion has also left your mind.");
                            System.out.println("She outfits you with a wooden bow, and what she calls a Cloak of the Forest, then starts introducing you to people.");
                            weapon = 2;
                            armor = 2;
                            System.out.println("He explains that you will have to prove yourself in order to become a full member, but for now, you are welcome");
                            break;
                        }
                        case (3): {
                            System.out.println("You walk up to the building and start talking to a human man outside.");
                            System.out.println("He introduces himself as Fenro, Guard of the Adventurer's League.");
                            System.out.println("He welcomes you inside, and you feel as if something has left your mind, while you feel settled, as if a great confusion has also left your mind.");
                            System.out.println("He outfits you with a sword, and some armor, then starts introducing you to people.");
                            weapon = 3;
                            armor = 3;
                            System.out.println("He explains that you will have to prove yourself in order to become a full member, but for now, you are welcome");
                            break;
                        }
                        case (4): {
                            System.out.println("You walk up to the building and start talking to a human man outside.");
                            System.out.println("He introduces himself as Fenro, Guard of the Adventurer's League.");
                            System.out.println("He welcomes you inside, and you feel as if something has left your mind, while you feel settled, as if a great confusion has also left your mind.");
                            System.out.println("He outfits you with a sword, and some armor, then starts introducing you to people.");
                            weapon = 4;
                            armor = 4;
                            System.out.println("He explains that you will have to prove yourself in order to become a full member, but for now, you are welcome");
                            break;
                        }
                        case (5): {
                            System.out.println("You walk up to the building and start talking to a human man outside.");
                            System.out.println("He introduces himself as Fenro, Guard of the Adventurer's League.");
                            System.out.println("He welcomes you inside, and you feel as if something has left your mind, while you feel settled, as if a great confusion has also left your mind.");
                            System.out.println("He outfits you with a sword, and some armor, then starts introducing you to people.");
                            weapon = 5;
                            armor = 5;
                            System.out.println("He explains that you will have to prove yourself in order to become a full member, but for now, you are welcome");
                            break;
                        }
                        default: {
                            break;
                        }
                    }
                    System.out.println("Suddenly, your conversation is interupted.");
                    System.out.println("You head outside to see what the commotion is, and upon doing so, you see hellhounds running in from the forest, while a devil flys in overhead, shooting bolts of magic, and from the main path, a group of people proclaiming they are the Basilisk cult starts attacking hte townsfolk");
                    switch (special) {
                        case (1): {
                            System.out.println("The Adventurer's League comes charging out of the HQ, and you follow, charging into battle");
                            System.out.println("You clash with a Basilisk cultist, in an attempt to prove your fighting prowess");
                            if(fight(hardskills, softskills, special, armor, weapon, 1) > 0)
                            {
                                System.out.println("You defeat the cultist with ease");
                                System.out.println("You find 10 gold pieces");
                                System.out.println("You gain 10 exp");
                                gold =+ 10;
                                exp =+ 10;
                            }
                            System.out.println("You see Fenro being taken away by the cultists. The league has defended the attack, but at the cost of Fenro.");
                            System.out.println("The guild tasks you with saving him, in order to prove yourself.");
                        }
                    }

                }
                System.out.println("You are in town. What do you do?");
            } while (1 == 1);
        }
        while (1 == 1);
    }

    public static int fight(int[] hardskills, int[] softskills, int special, int armor, int weapon, int battlenum)
    {
        int health = softskills[0];
        return health;
    }
}






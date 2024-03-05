package cosmiccards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CardLog {
    private static final HashMap<String, String> cards = new HashMap<>();
    private static Map<Integer, Double> cardAcquisitionPercentages;

    static {
        initializeCards();
    }

    private Card randomNonBossNonPartyCard;
    private Card randomPartyCard;
    private Card randomBossCard;


    private static void initializeCards() {
        logCommonCards();
        logUniqueCards();
        logBossCards();
        logPartyCards();
        logSpecialtyCards();
    }

    // Example method to get a card description
    public static String getCardDescription(String cardName) {
        return cards.getOrDefault(cardName, "Card not found");
    }

    public List<Card> searchByElement(String element) {
        List<Card> results = new ArrayList<>();
        for (Card card : getCards()) {
            if (card.getCardElement().equalsIgnoreCase(element)) {
                results.add(card);
            }
        }
        return results;
    }

    private Card[] getCards() {
        return new Card[0];
    }

    public List<Card> searchByAVCCID(String avccid) {
        List<Card> results = new ArrayList<>();
        for (Card card : getCards()) {
            if (card.getAVCCID().equalsIgnoreCase(avccid)) {
                results.add(card);
            }
        }
        return results;
    }

    public static void searchCardByName(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java CardLog <cardName>");
            return;
        }

        String cardName = args[0];
        String cardDescription = getCardDescription(cardName);
        System.out.println(cardDescription);
    }



    private static void logCommonCards() {
    String[][] commonCardsData = {
            {"Air Combat", "AVCCID:1239,Acquired:10%,Element:Wind"},
            {"Aqua King", "AVCCID:8331,Acquired:10%,Element:Water"},
            {"Arrow Shooter", "AVCCID:1347,Acquired:10%,Element:Wind"},
            {"Assassin Cock", "AVCCID:1725,Acquired:10%,Element:Wind"},
            {"Baby Dragon", "AVCCID:1932,Acquired:10%,Element:Thunder"},
            {"Basilisk", "AVCCID:2517,Acquired:10%,Element:No Element"},
            {"Beastie Dragon", "AVCCID:3615,Acquired:10%,Element:Wind"},
            {"Berserk Mouse", "AVCCID:3822,Acquired:10%,Element:Darkness"},
            {"Berserker", "AVCCID:4137,Acquired:10%,Element:Fire"},
            {"Bishop Dillie", "AVCCID:4812,Acquired:10%,Element:Fire"},
            {"Bowling", "AVCCID:2446,Acquired:10%,Element:No Element"},
            {"Canbria Dayfly", "AVCCID:3237,Acquired:10%,Element:Wind"},
            {"Cactus", "AVCCID:4515,Acquired:10%,Element:Earth"},
            {"Crafty Thief", "AVCCID:3462,Acquired:10%,Element:Darkness"},
            {"Crescent Bee", "AVCCID:6135,Acquired:10%,Element:Wind"},
            {"Crocodile", "AVCCID:6441,Acquired:10%,Element:Water"},
            {"Crystal Golem", "AVCCID:7361,Acquired:10%,Element:Light"},
            {"Cute Cat", "AVCCID:9621,Acquired:10%,Element:Thunder"},
            {"Dark Elf", "AVCCID:1761,Acquired:10%,Element:Darkness"},
            {"Deadly Spider", "AVCCID:5415,Acquired:10%,Element:Thunder"},
            {"Death Purger", "AVCCID:4632,Acquired:10%,Element:Darkness"},
            {"Dragon Soldier", "AVCCID:6325,Acquired:10%,Element:Earth"},
            {"Dragonfly", "AVCCID:7143,Acquired:10%,Element:Thunder"},
            {"Earth Shaker", "AVCCID:7272,Acquired:10%,Element:Earth"},
            {"Erupting Chick", "AVCCID:6711,Acquired:10%,Element:Wind"},
            {"Evil Spider", "AVCCID:3157,Acquired:10%,Element:Thunder"},
            {"Fairy", "AVCCID:5851,Acquired:10%,Element:Light"},
            {"Flying Rat", "AVCCID:2581,Acquired:10%,Element:Wind"},
            {"Fire Spirit", "AVCCID:7452,Acquired:10%,Element:Fire"},
            {"Flabby Troll", "AVCCID:5262,Acquired:10%,Element:Thunder"},
            {"Forest Runner", "AVCCID:2527,Acquired:10%,Element:Wind"},
            {"Fowl Fighter", "AVCCID:3345,Acquired:10%,Element:Fire"},
            {"Freeze Knight", "AVCCID:3328,Acquired:10%,Element:Water"},
            {"Frilled Lizard", "AVCCID:3635,Acquired:10%,Element:Wind"},
            {"Gargoyle", "AVCCID:2761,Acquired:10%,Element:Earth"},
            {"Ghost Knight", "AVCCID:7324,Acquired:25%,Element:Darkness"},
            {"Ginger", "AVCCID:7441,Acquired:10%,Element:No Element"},
            {"Glare", "AVCCID:2833,Acquired:10%,Element:Water"},
            {"Gnome", "AVCCID:3642,Acquired:10%,Element:Light"},
            {"Goblin", "AVCCID:7423,Acquired:10%,Element:Fire"},
            {"Guftas", "AVCCID:2544,Acquired:75%,Element:Darkness"},
            {"Guillotine", "AVCCID:3165,Acquired:10%,Element:Fire"},
            {"Harpy", "AVCCID:1367,Acquired:10%,Element:Light"},
            {"Hell Hound", "AVCCID:4245,Acquired:10%,Element:Wind"},
            {"Hellena Warden", "AVCCID:2536,Acquired:10%,Element:Fire"},
            {"Human Hunter", "AVCCID:5235,Acquired:10%,Element:Thunder"},
            {"Hyper Skeleton", "AVCCID:1438,Acquired:10%,Element:Darkness"},
            {"Icicle Ball", "AVCCID:8163,Acquired:10%,Element:Water"},
            {"Jelly", "AVCCID:3582,Acquired:10%,Element:Water"},
            {"Killer Bird", "AVCCID:4434,Acquired:10%,Element:Darkness"},
            {"Knight of Sandora", "AVCCID:5542,Acquired:10%,Element:Fire"},
            {"Land Skater", "AVCCID:4881,Acquired:10%,Element:Water"},
            {"Living Statue", "AVCCID:1718,Acquired:10%,Element:Earth"},
            {"Lizard Man", "AVCCID:5471,Acquired:10%,Element:Earth"},
            {"Loner Knight", "AVCCID:4725,Acquired:10%,Element:Darkness"},
            {"Mad Skull", "AVCCID:9134,Acquired:10%,Element:Thunder"},
            {"Mudman", "AVCCID:1843,Acquired:10%,Element:Earth"},
            {"Magician Bogey", "AVCCID:1547,Acquired:40%,Element:Darkness"},
            {"Magma Fish", "AVCCID:4463,Acquired:10%,Element:Fire"},
            {"Mammoth", "AVCCID:4491,Acquired:10%,Element:Earth"},
            {"Mandrake", "AVCCID:3627,Acquired:10%,Element:Water"},
            {"Man Eating Bud", "AVCCID:6243,Acquired:10%,Element:Darkness"},
            {"Manticore", "AVCCID:6721,Acquired:10%,Element:Fire"},
            {"Mantis", "AVCCID:4518,Acquired:10%,Element:Earth"},
            {"Maximum Volt", "AVCCID:5246,Acquired:10%,Element:Thunder"},
            {"Mega Sea Dragon", "AVCCID:5361,Acquired:10%,Element:Fire"},
            {"Mermaid", "AVCCID:1349,Acquired:10%,Element:Water"},
            {"Merman", "AVCCID:1961,Acquired:10%,Element:Water"},
            {"Metal Fang", "AVCCID:8353,Acquired:10%,Element:Thunder"},
            {"Minotaur", "AVCCID:6531,Acquired:10%,Element:Earth"},
            {"Mr Bone", "AVCCID:3392,Acquired:10%,Element:Darkness"},
            {"Mole", "AVCCID:9251,Acquired:10%,Element:Earth"},
            {"Moss Dresser", "AVCCID:2447,Acquired:10%,Element:Earth"},
            {"Mountain Ape", "AVCCID:2717,Acquired:10%,Element:No Element"},
            {"Myconido", "AVCCID:3444,Acquired:10%,Element:Earth"},
            {"Orc", "AVCCID:2276,Acquired:10%,Element:Thunder"},
            {"Piggy", "AVCCID:4614,Acquired:10%,Element:Earth"},
            {"Plague Rat", "AVCCID:5193,Acquired:10%,Element:Earth"},
            {"Pot Belly", "AVCCID:7363,Acquired:10%,Element:Thunder"},
            {"Professor", "AVCCID:6823,Acquired:10%,Element:Wind"},
            {"Psyche Druid", "AVCCID:5714,Acquired:10%,Element:Light"},
            {"Puck", "AVCCID:3382,Acquired:10%,Element:Light"},
            {"Red Hot", "AVCCID:8173,Acquired:10%,Element:Fire"},
            {"Roc", "AVCCID:7381,Acquired:10%,Element:Wind"},
            {"Rocky Turtle", "AVCCID:8443,Acquired:10%,Element:Earth"},
            {"Rodriguez", "AVCCID:7671,Acquired:75%,Element:Wind"},
            {"Roulette Face", "AVCCID:2863,Acquired:10%,Element:No Element"},
            {"Run Fast", "AVCCID:6237,Acquired:10%,Element:Thunder"},
            {"Salamander", "AVCCID:3691,Acquired:10%,Element:Fire"},
            {"Sandworm", "AVCCID:9117,Acquired:10%,Element:Earth"},
            {"Scissorhands", "AVCCID:2645,Acquired:10%,Element:Earth"},
            {"Scorpion", "AVCCID:5257,Acquired:10%,Element:Earth"},
            {"Screaming Bat", "AVCCID:7812,Acquired:10%,Element:Darkness"},
            {"Screw Shell", "AVCCID:6841,Acquired:10%,Element:Water"},
            {"Scud Shark", "AVCCID:7651,Acquired:10%,Element:Water"},
            {"Sea Dragon", "AVCCID:5732,Acquired:10%,Element:Fire"},
            {"Sea Piranha", "AVCCID:4743,Acquired:10%,Element:Water"},
            {"Senior Warden", "AVCCID:8741,Acquired:10%,Element:Fire"},
            {"Skeleton", "AVCCID:8316,Acquired:10%,Element:Darkness"},
            {"Sky Chaser", "AVCCID:1854,Acquired:10%,Element:Wind"},
            {"Slime", "AVCCID:7433,Acquired:10%,Element:Earth"},
            {"Slug", "AVCCID:6517,Acquired:10%,Element:No Element"},
            {"Specter", "AVCCID:9522,Acquired:10%,Element:Darkness"},
            {"Spider Urchin", "AVCCID:6219,Acquired:10%,Element:Thunder"},
            {"Spiky Beetle", "AVCCID:3924,Acquired:10%,Element:Thunder"},
            {"Spinning Head", "AVCCID:5815,Acquired:10%,Element:No Element"},
            {"Spring Hitter", "AVCCID:4546,Acquired:10%,Element:No Element"},
            {"Stern Fish", "AVCCID:5329,Acquired:10%,Element:Water"},
            {"Stinger", "AVCCID:5861,Acquired:10%,Element:Wind"},
            {"Strong Man", "AVCCID:6562,Acquired:10%,Element:No Element"},
            {"Succubus", "AVCCID:5761,Acquired:10%,Element:Light"},
            {"Swift Dragon", "AVCCID:6391,Acquired:10%,Element:Fire"},
            {"Terminator", "AVCCID:8164,Acquired:10%,Element:No Element"},
            {"Toad Stool", "AVCCID:6733,Acquired:10%,Element:Earth"},
            {"Trap Plant", "AVCCID:8191,Acquired:10%,Element:Water"},
            {"Trent", "AVCCID:2638,Acquired:10%,Element:Earth"},
            {"Triceratops", "AVCCID:7147,Acquired:10%,Element:Earth"},
            {"Tricky Bat", "AVCCID:4825,Acquired:10%,Element:Wind"},
            {"Ugly Balloon", "AVCCID:3475,Acquired:10%,Element:Wind"},
            {"Undead", "AVCCID:8272,Acquired:10%,Element:Darkness"},
            {"Unicorn", "AVCCID:2971,Acquired:10%,Element:Light"},
            {"Vampire Kiwi", "AVCCID:4871,Acquired:10%,Element:Darkness"},
            {"White Ape", "AVCCID:6581,Acquired:10%,Element:No Element"},
            {"Wildman", "AVCCID:9472,Acquired:10%,Element:Thunder"},
            {"Will-O-Wisp", "AVCCID:2881,Acquired:10%,Element:Fire"},
            {"Windy Weasel", "AVCCID:7417,Acquired:10%,Element:Wind"},
            {"Witch", "AVCCID:3628,Acquired:10%,Element:Light"},
            {"Wounded Bear", "AVCCID:5319,Acquired:10%,Element:No Element"},
            {"Wyvern", "AVCCID:8281,Acquired:10%,Element:Thunder"},
    };
    logCard(commonCardsData);}


private static void logUniqueCards() {
    String[][] uniqueCardsData = {
            {"Yellow Bird", "AVCCID:6789,Acquired:50%,Element:Earth"},
            {"Blue Bird", "AVCCID:7896,Acquired:50%,Element:Earth"},
            {"Red Bird", "AVCCID:8967,Acquired:50%,Element:Earth"},
            {"Rainbow Bird", "AVCCID:9678,Acquired:50%,Element:Earth"},
            {"Cursed Jar", "AVCCID:9876,Acquired:50%,Element:Earth"},
            {"Treasure Jar", "AVCCID:8769,Acquired:50%,Element:Earth"},
            {"Lucky Jar", "AVCCID:7698,Acquired:50%,Element:Earth"},
            {"00Parts", "AVCCID:6987,Acquired:50%,Element:Earth"},
    }:
    logCard(uniqueCardsData);}


private static void logBossCards(){
    String[][] bossCardsData = {
            {"Seles Commander", "AVCCID:1884,Acquired:40%,Element:Darkness"},
            {"Fruegel", "AVCCID:3567,Acquired:40%,Element:Earth"},
            {"Urobolus", "AVCCID:5247,Acquired:40%,Element:No Element"},
            {"Sandora Elite", "AVCCID:6735,Acquired:40%,Element:Darkness"},
            {"Marsh Commander", "AVCCID:8454,Acquired:40%,Element:Darkness"},
            {"Wounded Virage", "AVCCID:9255,Acquired:40%,Element:No Element"},
            {"Fire Bird", "AVCCID:8625,Acquired:40%,Element:Fire"},
            {"Greham", "AVCCID:8373,Acquired:40%,Element:Wind"},
            {"Feyrbrand", "AVCCID:6393,Acquired:40%,Element:Wind"},
            {"Drake the Bandit", "AVCCID:5583,Acquired:40%,Element:No Element"},
            {"Shirley", "AVCCID:4917,Acquired:40%,Element:Light"},
            {"Gorgaga", "AVCCID:2547,Acquired:40%,Element:Earth"},
            {"Serfius", "AVCCID:9651,Acquired:40%,Element:Fire"},
            {"Danton", "AVCCID:2748,Acquired:40%,Element:Earth"},
            {"Atlow", "AVCCID:8265,Acquired:40%,Element:Darkness"},
            {"Jiango", "AVCCID:9813,Acquired:40%,Element:Earth"},
            {"Emperor Doel", "AVCCID:7347,Acquired:40%,Element:Thunder"},
            {"Complete Virage", "AVCCID:6736,Acquired:40%,Element:No Element"},
            {"Mappi", "AVCCID:6782,Acquired:40%,Element:Darkness"},
            {"Gehrich", "AVCCID:8726,Acquired:40%,Element:Earth"},
            {"Ghost Commander", "AVCCID:5718,Acquired:40%,Element:Darkness"},
            {"Lenus", "AVCCID:8267,Acquired:40%,Element:Water"},
            {"Regole", "AVCCID:6548,Acquired:40%,Element:Water"},
            {"Kamuy", "AVCCID:9745,Acquired:40%,Element:No Element"},
            {"Scarred Super Virage", "AVCCID:8962,Acquired:40%,Element:No Element"},
            {"Grand Jewel", "AVCCID:9257,Acquired:40%,Element:Earth"},
            {"Divine Dragon", "AVCCID:9842,Acquired:40%,Element:No Element"},
            {"Windigo", "AVCCID:8933,Acquired:40%,Element:Water"},
            {"Polter Armor", "AVCCID:4658,Acquired:40%,Element:Darkness"},
            {"Lloyd", "AVCCID:3767,Acquired:40%,Element:No Element"},
            {"Kanzas", "AVCCID:3498,Acquired:40%,Element:Thunder"},
            {"Belzac", "AVCCID:8573,Acquired:40%,Element:Earth"},
            {"Damia", "AVCCID:6935,Acquired:40%,Element:Water"},
            {"Syuveil", "AVCCID:9259,Acquired:40%,Element:Wind"},
            {"Last Kraken", "AVCCID:7637,Acquired:40%,Element:Water"},
            {"Vector", "AVCCID:6818,Acquired:40%,Element:Darkness"},
            {"Selebus", "AVCCID:3796,Acquired:40%,Element:Darkness"},
            {"Kubila", "AVCCID:7882,Acquired:40%,Element:Darkness"},
            {"Faust", "AVCCID:9655,Acquired:40%,Element:No Element"},
            {"Divine Dragon Spirit", "AVCCID:5992,Acquired:40%,Element:No Element"},
            {"Regole Spirit", "AVCCID:8629,Acquired:40%,Element:Water"},
            {"Feyrbrand Spirit", "AVCCID:2986,Acquired:40%,Element:Wind"},
            {"Lavitz Spirit", "AVCCID:9286,Acquired:40%,Element:Wind"},
            {"Zackwell", "AVCCID:7387,Acquired:40%,Element:Darkness"},
            {"Imago", "AVCCID:8926,Acquired:40%,Element:No Element"},
            {"Death Rose", "AVCCID:8872,Acquired:40%,Element:No Element"},
            {"Claire", "AVCCID:8548,Acquired:40%,Element:Thunder"},
            {"Indora", "AVCCID:9952,Acquired:40%,Element:Earth"},
            {"Michael", "AVCCID:5947,Acquired:40%,Element:Darkness"},
            {"Dark Doel", "AVCCID:6748,Acquired:40%,Element:Thunder"},
            {"Archangel", "AVCCID:3895,Acquired:40%,Element:Light"},
            {"Comp. Super Virage", "AVCCID:8179,Acquired:40%,Element:No Element"},
            {"Zieg Feld", "AVCCID:6991,Acquired:40%,Element:Fire"},
            {"Melbu Frahma", "AVCCID:2878,Acquired:40%,Element:No Element"},
    };
    logCard(bossCardsData);}


private static void logPartyCards() {
    String[][] partyCardsData = {
            {"Albert", "AVCCID:7A75,Acquired:Obtained when he joins,Element:Wind"},
            {"Dart Feld", "AVCCID:A647,Acquired:Start with this card,Element:Fire"},
            {"Haschel", "AVCCID:5A66,Acquired:Obtained when he joins,Element:Thunder"},
            {"Kongol", "AVCCID:3AA4,Acquired:Obtained when he joins,Element:Earth"},
            {"Lavitz Slambert", "AVCCID:57A7,Acquired:Obtained when he joins,Element:Wind"},
            {"Meru", "AVCCID:A656,Acquired:Obtained when she joins,Element:Water"},
            {"Miranda", "AVCCID:457A,Acquired:Obtained when she joins,Element:Light"},
            {"Rose", "AVCCID:67A6,Acquired:Obtained when she joins,Element:Darkness"},
            {"Shana", "AVCCID:745A,Acquired:Obtained when she joins,Element:Light"},
    };
    logCard(partyCardsData);}


private static void logSpecialtyCards() {
    String[][] specialtyCardsData = {
            {"Black Monster", "AVCCID:9957,Acquired:Visit Neet after figuring out Rose’s secret.,Element:Darkness"},
            {"Charle Frahma", "AVCCID:7116,Acquired:???,Element:Light"},
            {"Commodore Puler", "AVCCID:4722,Acquired:Obtained the first time he asks if Dart would become a man of the sea.,Element:Water"},
            {"Coolon", "AVCCID:1653,Acquired:10%,Element:Wind"},
            {"Dabas", "AVCCID:7895,Acquired:Talk to the assistant after Dabas goes underground.,Element:No Element"},
            {"Dran", "AVCCID:5271,Acquired:Acquired after giving him spirits.,Element:Water"},
            {"Drippy", "AVCCID:7986,Acquired:Talk to him after defeating Regole.,Element:Water"},
            {"Fester", "AVCCID:5997,Acquired:Stare at the MTNS for 30 seconds.,Element:Darkness"},
            {"Guaraha", "AVCCID:8994,Acquired:Visit him in his room.,Element:Light"},
            {"Isha & Lowe", "AVCCID:7779,Acquired:After saving the remnants of Seles, trigger the cutscene with them.,Element:No Element"},
            {"Judge Nomos", "AVCCID:5897,Acquired:???,Element:Thunder"},
            {"Kaffi", "AVCCID:5325,Acquired:Return after defeating Lenus.,Element:Wind"},
            {"Kaiser", "AVCCID:7887,Acquired:Check the table where they were planning, after the Hoax battle.,Element:Earth"},
            {"Kayla", "AVCCID:8877,Acquired:???,Element:Water"},
            {"King Zior", "AVCCID:8263,Acquired:Talk to him with both Lisa and Emille’s cards.,Element:No Element"},
            {"Knight of Basil", "AVCCID:7247,Acquired:Talk to one of the Knights in the Castle of Bale.,Element:Wind"},
            {"Librarian Ute", "AVCCID:9975,Acquired:Search the artifacts in the library,Element:Thunder"},
            {"Sacred Sister Luanna", "AVCCID:6414,Acquired:Talk to her after the DD attacks the Castle.,Element:Light"},
            {"Martel", "AVCCID:8589,Acquired:Acquire exactly 50 cards, then talk to her.,Element:Fire"},
            {"Master Tasman", "AVCCID:9785,Acquired:Obtained after completing his tutorial.,Element:Thunder"},
            {"Merchant", "AVCCID:6832,Acquired:Talk to the very first merchant and make a purchase.,Element:No Element"},
            {"Midwife Gilda", "AVCCID:7977,Acquired:Return to Gilda with Albert in the party.,Element:No Element"},
            {"Minister Noish", "AVCCID:6315,Acquired:Return to Noish with Albert in the party.,Element:Wind"},
            {"Nello", "AVCCID:9116,Acquired:???,Element:Earth"},
            {"Pelpee", "AVCCID:5996,Acquired:Talk with Pelpee in both location, she’ll give the card at the bar.,Element:Fire"},
            {"Plos", "AVCCID:7314,Acquired:Talk to him after receiving help from Isha and Lowe.,Element:No Element"},
            {"Popo", "AVCCID:6787,Acquired:Return to him after defeating Emperor Doel.,Element:Wind"},
            {"Princess Emille", "AVCCID:9114,Acquired:Inspect the painting after the party.,Element:No Element"},
            {"Princess Lisa", "AVCCID:2715,Acquired:Talk to her with Nello’s card already acquired.,Element:No Element"},
            {"Princess Louvia", "AVCCID:6324,Acquired:Complete the ghost chest at least twice, then trigger cutscene.,Element:Light"},
            {"Queen Theresa", "AVCCID:1716,Acquired:???,Element:Light"},
            {"Resident Knight Harris", "AVCCID:9894,Acquired:Show him Kamuy’s card, make him feel bad.,Element:Earth"},
            {"Savan", "AVCCID:9786,Acquired:Acquired if the quiz is done perfectly.,Element:Thunder"},
            {"Spino", "AVCCID:8876,Acquired:Obtained after talking to them when they pass.,Element:No Element"},
            {"Ruff", "AVCCID:6788,Acquired:Obtained after talking to them when they pass.,Element:No Element"},
            {"Decal", "AVCCID:8678,Acquired:Obtained after talking to them when they pass.,Element:No Element"},
            {"Buckle", "AVCCID:8768,Acquired:Obtained after talking to them when they pass.,Element:No Element"},
            {"Lulu", "AVCCID:7886,Acquired:Obtained after talking to them when they pass.,Element:No Element"},
            {"Sacred Sister Setie", "AVCCID:4335,Acquired:Talk to her after the DD attacks the Castle.,Element:Light"},
            {"Sacred Sister Wink", "AVCCID:3138,Acquired:Talk to her after the DD attacks the Castle.,Element:Light"},
            {"Teo", "AVCCID:4525,Acquired:Find Teo in town after calming Kamuy.,Element:Wind"},
    };
    logCard(specialtyCardsData);}


    public static void logCard(String name) {
    if (cards.containsKey(name)) {
        String details = cards.get(name);
        System.out.println("Card logged: " + name + " - Details: " + details);
    } else {
        throw new IllegalArgumentException("Card not found in the journal.");
    }
}

    private static void checkUniqueIDs() {
     HashMap<String, Integer> idCounts = new HashMap<>();

        for (String details : cards.values()) {
            String id = details.split(",")[0];
         idCounts.put(id, idCounts.getOrDefault(id, 0) + 1);
    }

         for (String id : idCounts.keySet()) {
            if (idCounts.get(id) > 1) {throw new IllegalStateException("Duplicate ID detected: " + id);
            }
        }
    }

    public static Map<Integer, Double> getCardAcquisitionPercentages() {
        return cardAcquisitionPercentages;
    }

    public static void setCardAcquisitionPercentages(Map<Integer, Double> cardAcquisitionPercentages) {
        CardLog.cardAcquisitionPercentages = cardAcquisitionPercentages;
    }

    public Card getRandomNonBossNonPartyCard() {
        return randomNonBossNonPartyCard;
    }

    public void setRandomNonBossNonPartyCard(Card randomNonBossNonPartyCard) {
        this.randomNonBossNonPartyCard = randomNonBossNonPartyCard;
    }

    public Card getRandomPartyCard() {
        return randomPartyCard;
    }

    public void setRandomPartyCard(Card randomPartyCard) {
        this.randomPartyCard = randomPartyCard;
    }

    public Card getRandomBossCard() {
        return randomBossCard;
    }

    public void setRandomBossCard(Card randomBossCard) {
        this.randomBossCard = randomBossCard;
    }

    public List<Card> getWaterElementCards() {
    }

    public List<Card> getWindElementCards() {
    }

    public Card getRandomPlayerCard() {
    }

    public List<Card> getCardsWithRarity(List<Card> cards, String rarity) {
    }

    public List<Card> getThunderElementCards() {
    }

    public List<Card> getNoElementElementCards() {
    }

    public List<Card> getLightElementCards() {
    }

    public List<Card> getFireElementCards() {
    }

    public List<Card> getEarthElementCards() {
    }

    public List<Card> getDarknessElementCards() {
    }

    public List<String> getAllAVCCIDs() {
    }
}


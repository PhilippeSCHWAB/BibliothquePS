import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BibliothequePS {


    public static void main(String[] args) throws FileNotFoundException {
//Message d'acceuil
        System.out.println("BIENVENUE DANS LE PROGRAMME BIBLIOTEHQUE ");
        String monchoix = "0";

//Initilisation du tableau d'entrée des livres par saisie manuelle et saisie automatique
        String[] tab = new String[20];
        int i = 0;
        int j = 0; //Nbre de livre entrés
        String livre = " ";
        String menu = "P";

        //Boucle qui pose pose la question du livre a inserer jusqu'a la saisie de FIN
        do {
            System.out.println("Saisissez le nom d'un livre ou FIN pour terminer");
            //Récuperation de la valeur saisie au clavier puis alimentation du tableau TAB
            Scanner sc = new Scanner(System.in);
            livre = sc.nextLine();

            tab[i] = livre;

            i = i + 1;
            j = i - 1;
        }

        while (livre.compareTo("FIN") != 0);
        {
            for (i = 0; i < 10; i++) {

            }
        }

        //Alimentation automatique des livres a partir du fichier init.txt - PAS DANS L'EXERCICE MAIS PLUS PRATIQUE
        String nomDeFichier = "src/init.txt";
        int nbreDeligne = j;
//Lecture du fichier
        Scanner sc2 = new Scanner(new File(nomDeFichier));
        String ligne = null;
        int no = 0;

//boucle pour alimenter et completer le tableau en automatique
        for (no = 0; sc2.hasNextLine(); tab[no + nbreDeligne] = sc2.nextLine(), ++no)
            j = no + i;

        for (i = 0; i < j; i++)


            // boucle appel menu jusqu'a saisie de 5 (fin)
            do {

                //Appel de la procédure mMenu et recuperation du choix dans monchoix
                monchoix = mMenu("P");


                // Select case suivant valeur de monchoix
                switch (monchoix) {

// Affichage de la liste des fichiers
                    case "1": {
                        System.out.println("***********************");
                        System.out.println("1 - LISTE DES FICHIERS");
                        System.out.println("***********************");

                        for (i = 0; i < j; i++) {

                            System.out.println(tab[i]);
                            //
                        }


                        break;
                    }

// Ajout d'un livre
                    case "2": {
                        System.out.println("**********************");
                        System.out.println("2 - AJOUTER UN FICHIER");
                        System.out.println("**********************");
                        System.out.println("Saisissez le nom du nouveau livre");
// recup saisie clavier et alimentation tableau
                        Scanner sc = new Scanner(System.in);
                        livre = sc.nextLine();
                        tab[i] = livre;

                        i = i + 1;
                        j = i;


                        break;
                    }
                    //Suppression d'un livre
                    case "3": {
                        System.out.println("**********************");
                        System.out.println("3 - SUPPRIMER UN FICHIER");
                        System.out.println("**********************");

                        System.out.println("3 - Indiquer le TITRE du livre a supprimer de la liste");
                        //récup saisie clavier
                        Scanner sc = new Scanner(System.in);

                        livre = sc.nextLine();
                        String maValeur = livre;

                        int monIndice;
//recherche du livre et suppression du livre
                        for (int k = 0; k < tab.length; k++) {
                            if (maValeur.equals(tab[k])) {
                                monIndice = k;

                                tab[k] = "";
                            }
                        }


                        break;
                    }
                    // NON IMPLEMENTE
                    case "4": {
                        System.out.println("4 - Menu Bis");
                        mMenu("B");
                        menu = "B";
                        break;
                    }

                    // Liste les fichiers du tableau
                    case "41": {
                        System.out.println("************************");
                        System.out.println("4.1 - Liste des fichiers");
                        System.out.println("************************");
                        for (i = 0; i < j; i++) {
                            System.out.println(tab[i]);
                            //
                        }
//                        monchoix=mMenu("P");
//                       / menu="B";
                        break;
                    }

                    // Selection du livre
                    case "42": {
                        System.out.println("****************************************");
                        System.out.println("4.2 - Sélectionner un titre avec som nom");
                        System.out.println("****************************************");
                        //recupération saisie clavier
                        Scanner sc = new Scanner(System.in);
                        livre = sc.nextLine();
//affichage du titre selectionne
                        System.out.println("*******************************************************************");
                        System.out.println("Vous avez sélectionné le titre : " + livre);
                        System.out.println("*******************************************************************");
//                        monchoix=mMenu("P");
//                       / menu="B";
                        break;
                    }
                    case "43": {
                        System.out.println("*************************************************************");
                        System.out.println("4.3 - Statistique pour le livre " + livre);
                        System.out.println("*************************************************************");


//                        monchoix=mMenu("P");
//                       / menu="B";
                        break;
                    }
// Récuparation du nombre de ligne du fichier sélectionné
                    case "432": {
// localisation du repertoire et du nom de fichier
                        System.out.println("localisation " + "src/" + Localisation(livre));
                        String nomDuFichier = "src/" + Localisation(livre);//+"mots.txt";
                        // appel procédure NombreDemotss qui ramera le nombre de mots puis affichage a l'écran
                        System.out.println("*************************************************************");
                        System.out.println("4.3.2 - Le nombre de mots pour le livre " + livre + " est de : " + NombreDemotss(nomDuFichier));
                        System.out.println("*************************************************************");
//                        monchoix=mMenu("P");
//                       / menu="B";
                        break;
                    }
                    // Récuparation du nombre de mots du fichier sélectionné
                    case "431": {
// localisation du repertoire et du nom de fichier
                        String nomDuFichier2 = "src/" + Localisation(livre);//+"mots.txt";

                        // appel procédure NbreDeLigne qui ramera le nombre de ligne puis affichage a l'écran

                        System.out.println("*************************************************************");
                        System.out.println("4.3.1 - Le nombre de lignes pour le livre " + livre + " est de : " + NbreDeLigne(nomDuFichier2));
                        System.out.println("*************************************************************");
//                        monchoix=mMenu("P");
//                       / menu="B";
                        break;
                    }

                    case "433": {
// Récuparation des 50 plus grandes occurences de mots pour le fichier sélectionner  - NON FINALISE SEULES LES OCCURENCES DE TOUS LES MOTS SONT RAMENEES
//
                        String nomDuFichier = "src/" + Localisation(livre);//+"mots.txt";

                        System.out.println("*************************************************************");
                        System.out.println("4.3.3 - Les 50 mots les plus utilisés pour le livre " + livre + " est de : " + MotsPlusUtilises(nomDuFichier));
                        System.out.println("*************************************************************");

//                        monchoix=mMenu("P");
//                       / menu="B";
                        break;
                    }

//fin du programme
                    case "5": {
                        System.out.println("AU REVOIR !");
                        System.exit(1);
                    }

                }

            } while (monchoix != "5");

    }

    // }

    // Procédure qui compte les mots du fichier sélectionné
    public static int NbreDeMots(String nomDuFichier) throws FileNotFoundException {

     //ouverture du fichier selectionne
        Scanner sc = new Scanner(new File("nomDuFichier"));
        int nbreDeMots = 0;
        //compte les mots
        for (int i = 0; sc.hasNextLine(); ++i) {
            sc.nextLine();
            nbreDeMots = i;
        }
        sc.close();
        //renvoi le nombre de mots
        return nbreDeMots;
    }

    // Procédure qui compte les lignes du fichier sélectionné
    public static int NbreDeLigne(String nomDuFichier2) throws FileNotFoundException {

        //ouverture du fichier selectionne
        Scanner sc = new Scanner(new File(nomDuFichier2));
        //compte les lignes

        int nbreDeLigne = 0;
        for (int i = 0; sc.hasNextLine(); ++i) {
            sc.nextLine();
            nbreDeLigne = i;
        }
        sc.close();
        //renvoi le nombre de ligne
        return nbreDeLigne;
    }



    //définition de la localisation des fichiers suivant l'auteur
    public static String Localisation(String nomDuFichier) throws FileNotFoundException {

        String author = nomDuFichier.substring(0, 5);
        String Localisation = "";

        if (author.equals("Smith")) {
            Localisation = "Smith/" + nomDuFichier;
        } else if (author.equals("Spino")) {
            Localisation = "Spinoza/" + nomDuFichier;
        } else {
            Localisation = "ko";
        }
        //renvoi de la localisation des fichiers suivany l'auteur
        return Localisation;
    }


    //Adaptation de la procedure de jules pour mettre dans un ficher les mots les uns en dessous des autres
    public static int NombreDemotss(String NomdeFichier) throws FileNotFoundException {

        //Définition du patern pour recuperer les chaines de caracteres séparé par des espaces
        Pattern p = Pattern.compile("\\w+", Pattern.UNICODE_CHARACTER_CLASS);
//définition du fichier en entree et en sortie
        String monFichier = NomdeFichier;
        String monFichierOut = NomdeFichier + "out";


        int i = 0;
        int Nbredemotsss = 0;

        //ouverture du fichier
        try (Scanner sc = new Scanner(new File(monFichier));
          //ouverture du fichier pour ecriture
             PrintStream fileOut = new PrintStream(new FileOutputStream(monFichierOut))) {
            //boucle de lecture jusqu'a lafin du fichier
            for (i = 0; sc.hasNextLine(); ++i) {
                //pour chaque mots trouve ecriture dans le fichieren sortie
                for (Matcher m1 = p.matcher(sc.nextLine()); m1.find(); ) {
                    fileOut.println(m1.group());
                    //nombre de mot
                    ++Nbredemotsss;

                }

            }

        }
        //renvoi du nom de mots trouvé
        return Nbredemotsss;
    }



    //procedure pour compter les mots
    public static int MotsPlusUtilises(String NomdeFichier) throws FileNotFoundException {

//définiton du fichier en entree
        String monFichierOut = NomdeFichier + "out";


        int toto = 0;
        //création tableau map
        Map<String, Integer> table = new HashMap<>();

        //ouverture du fichier
        try (BufferedReader entree = new BufferedReader(new FileReader(monFichierOut))) {
            ;

            //boucle pour chaque mot dans le fichier
            for (String mot = entree.readLine(); mot != null; mot = entree
                    .readLine()) {
                //    System.out.println(mot);
                toto = toto + 1;
               //verifie la présence du fichier dans la table
                // Si présent la valeur d'occurence passe a +
                if (table.containsKey(mot)) {
                    table.put(mot, table.get(mot) + 1);
           //Si Absent insertion du mot dans la table

                } else {
                    table.put(mot, 1);
                    //liste des mots et leursoccurence - NON FINBALISE
                    System.out.println(mot + "" + table.get(mot) + 1);
                    System.out.println(toto);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        //TESTS DE LOCALISATION DES FICHIERS EN ENTREE ET EN SORTIE DIFFERENT SI LANCÉ A PARTIR DE idEAL OU A PARTIR DU TERMINAL
        //   String monFichierOut = "/home/bnp-renault-001/IdeaProjects/Bibliotheque/src/Smith/Smith-Richesse_des_Nations_4.txtout";
        PrintStream fileOut = new PrintStream(new FileOutputStream("OUESTTU.txt"));
        String motsReformat = "";

        Map<Integer, String> map1 = new HashMap<Integer, String>();

        for (Map.Entry<String, Integer> entry2 : table.entrySet()) {
            String mot = entry2.getKey();
            int nbOcc = entry2.getValue();
            fileOut.println(nbOcc + ",[" + mot + "]");
            System.out.println(nbOcc + ",\"" + mot + "\"");
            motsReformat = ",\"" + mot + "\"";
            map1.put(nbOcc, mot);

        }


        Set<Map.Entry<Integer, String>> es1 = map1.entrySet();
        Iterator<Map.Entry<Integer, String>> it = es1.iterator();
        while (it.hasNext()) {
            Map.Entry entry = it.next();

        }

        int NombreDemotsss = toto;


        return 1;
    }


    public static String mMenu(String menu) {


//Les instructions qui suivent affichent le menu
        String choiceMenu = "";
        if (menu == "P") {
            System.out.println("****************************************************");
            System.out.println("                      MENU                          ");
            System.out.println("Saisisser le chiffre de la fonction souhaitée");
            System.out.println("1 - Lister les livres");
            System.out.println("2 - Ajouter un livre");
            System.out.println("3 - Supprimer un livre");
            System.out.println("4 - Afficher des informations sur un livre");
            System.out.println("41 - Afficher la liste des livre");
            System.out.println("42 - Séléctionner un livre");
            System.out.println("43 - Statistique sur le livre sélectionné");
            System.out.println("431 - Nombre de ligne du livre sélectionné");
            System.out.println("432 - Nombre de mots du livre sélectionné ");
            System.out.println("433 - les 50 mots plus utilisés");

            System.out.println("5 - Quitter le programme");
            System.out.println("****************************************************");

            //Récupération de la saisie clavier
            Scanner sc2 = new Scanner(System.in);
            choiceMenu = sc2.nextLine();

//Choix du menu (P)rincipal ou (B)is  - NON IMPLEMENTE FAUTE DE TEMPS
        } else if (menu == "B") {


//            menu="B";
            //Les instructions qui suivent affichent le menu BIS - NON IMPLEMENTE FAUTE DE TEMPS
            System.out.println("41 - Afficher la liste des livre");
            System.out.println("42 - Séléctionner un livre");
            System.out.println("43 - Statistique sur le livre sélectionné");
            System.out.println("4 - Retour menu précédent");
            Scanner sc2 = new Scanner(System.in);
            choiceMenu = sc2.nextLine();
        }
        //renvoi du choix utilisateur saisie au clavier
        return choiceMenu;
    }

    //NON IMPLEMENTE FAUTE DE TEMPS
//    public static String mMenuBis() {
///        System.out.println("MENU BIS- Saisisser le chiffre de la fonction souhaitée");
//        System.out.println("41 - Afficher la liste des fichiers");
//        System.out.println("42 - Séléctionner un fichier");
//        System.out.println("43 - Statistique du fichier sélectionné");
//        System.out.println("4 - Retour menu précédent");
//        Scanner sc2 = new Scanner(System.in);
//        String choiceMenu = sc2.nextLine();
//        System.out.println("lE CHOIX DANS LE MENU BIS EST " + choiceMenu);
//
//
//        return choiceMenu;
//    }

    //public static String mAction(String valAction ) {

//        System.out.println("MENU - Saisisser le chiffre de la fonction souhaitée");
//        System.out.println("1 - Lister les fichiers");
//        System.out.println("2 - Ajouter un fichier");
//        System.out.println("3 - Supprimer un fichier");
//        System.out.println("4 - Afficher des informations sur un livre");
//        System.out.println("5 - Quitter le programme");
//        Scanner sc2 = new Scanner(System.in);
//        String choiceMenu = sc2.nextLine();
//        return choiceMenu;
    //}//


}






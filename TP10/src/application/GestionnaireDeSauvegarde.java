package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GestionnaireDeSauvegarde {

    public static LivreRecettes charger(String chemin) throws IOException, ClassNotFoundException {
        LivreRecettes retour;
        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(chemin))) {
            retour = (LivreRecettes) reader.readObject();
        }
        return retour;
    }

    public static void sauvegarder(String chemin, LivreRecettes bouquin) throws IOException {
        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(chemin))) {
            writer.writeObject(bouquin);
        }
    }
}

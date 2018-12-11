package be.ehb.veganapp;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


// Ik maak gebruik van een stringDef omdat het gebruik van een enumeration sterk wordt afgeraden op vlak van performance.
public class CategorieDef {

    @Retention(RetentionPolicy.SOURCE)
    @StringDef({MILIEU, BEWEGING, VOEDING})

    // Om de types te valideren die evt. meegegeven worden aan de constructor
    public @interface CategorieDefinition{}

    public static final String MILIEU = "milieu";
    public static final String BEWEGING = "beweging";
    public static final String VOEDING = "voeding";

    public final String categorie;
    public CategorieDef (@CategorieDefinition String categorie) {
        this.categorie = categorie;
    }

}

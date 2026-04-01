package duckcorp.duck;

import java.util.Objects;

/**
 * Classe abstraite représentant un canard en plastique.
 *
 * TODO (Ex1) :
 *   - Faites implémenter l'interface Qualifiable à cette classe
 *   - Implémentez equals() et hashCode() basés uniquement sur l'id
 *   - Implémentez les méthodes abstraites dans les sous-classes
 * @author Roussille Philippe <roussille@3il.fr>
 */
public abstract class Duck implements Qualifiable {

    private static int counter = 0;

    private final String   id;
    private final DuckType type;
    private final int      qualityScore;

    /** Constructeur fourni. Génère automatiquement un identifiant unique. */
    protected Duck(DuckType type, int qualityScore) {
        this.id           = type.name().charAt(0) + String.format("%04d", ++counter);
        this.type         = type;
        this.qualityScore = Math.max(0, Math.min(100, qualityScore));
    }

    // --- Getters fournis ---

    public String   getId()          { return id; }
    public DuckType getType()        { return type; }

    @Override
    public int getQualityScore(){ return qualityScore; }   // satisfera Qualifiable

    @Override
    public boolean isDefective() {
        return qualityScore < 20;
    }

    @Override
    public String getQualityLabel() {
        if (qualityScore >= 80) return "Excellent";
        else if (qualityScore >= 50) return "Bon";
        else if(qualityScore >= 20) return "Médiocre";
        else return "Défectueux";
    }

    // --- Méthodes abstraites à implémenter dans les sous-classes ---

    public abstract double getBasePrice();
    public abstract String describe();

    // --- TODO : equals et hashCode ---


    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Duck)) return false;
        return ((Duck) obj).id.equals(this.id);
    }


    // --- toString fourni ---

    @Override
    public String toString() {
        return String.format("[%s] %s — qualité : %d/100", id, describe(), qualityScore);
    }
}

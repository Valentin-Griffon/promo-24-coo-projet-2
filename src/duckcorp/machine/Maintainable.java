package duckcorp.machine;

/**
 * Interface représentant une machine pouvant être entretenue.
 *
 * TODO (Ex2) :
 *   - Implémentez needsMaintenance() et getConditionLabel() (méthodes default)
 * @author Roussille Philippe <roussille@3il.fr>
 */
public interface Maintainable {

    /** Retourne l'état de la machine (entre 0 et 100). */
    int getCondition();

    /** Effectue une opération de maintenance sur la machine. */
    void maintain();

    /**
     * Retourne true si la machine nécessite une maintenance (condition < 30).
     * TODO : implémentez cette méthode default.
     */
    default boolean needsMaintenance() {
        return getCondition() < 30;
    }

    /**
     * Retourne un libellé décrivant l'état de la machine :
     *   condition >= 80 -> "Parfait" / >= 50 -> "Correct" / >= 30 -> "Usé" / < 30 -> "Critique"
     * TODO : implémentez cette méthode default.
     */
    default String getConditionLabel() {
        if (getCondition()>= 80 ) return "Parfait";
        else if (getCondition() >= 50) return "Correct";
        else if (getCondition() >= 30) return "Usé";
        else return "Critique";
    }
}

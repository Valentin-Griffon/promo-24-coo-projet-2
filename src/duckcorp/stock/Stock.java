package duckcorp.stock;

import duckcorp.duck.Duck;
import duckcorp.duck.DuckType;
import duckcorp.duck.LuxuryDuck;

import java.util.*;

/**
 * Stock générique de canards.
 *
 * TODO (Ex3) :
 *   - Implémentez remove(), count(), countDefective(), countByType()
 *
 * Les méthodes add(), getAll() et total() sont fournies.
 *
 * @param <T> type de canard stocké (doit étendre Duck)
 * @author Roussille Philippe <roussille@3il.fr>
 */
public class Stock<T extends Duck> {

    private final List<T> items = new ArrayList<>();

    // --- Méthodes fournies ---

    /** Ajoute un canard au stock. */
    public void add(T duck) {
        items.add(duck);
    }

    /** Retourne une vue non modifiable de tous les canards en stock. */
    public List<T> getAll() {
        return Collections.unmodifiableList(items);
    }

    /** Retourne le nombre total de canards en stock. */
    public int total() {
        return items.size();
    }

    // --- TODO ---

    /**
     * Retire exactement {@code count} canards du type {@code type} du stock
     * et les retourne dans une liste.
     *
     * @param type  le type de canard à retirer
     * @param count le nombre à retirer
     * @return la liste des canards retirés
     * @throws IllegalStateException si le stock ne contient pas assez de canards du type demandé
     *
     * Conseil : parcourez items en une seule passe.
     * Attention à la signature de retour : elle doit conserver le type générique T.
     */
    public List<T> remove(DuckType type, int count) {
        List<T> result = new ArrayList<>();

        Iterator<T> iterator = items.iterator();
        while (iterator.hasNext() && result.size() < count) {
            T duck = iterator.next();
            if (duck.getType() == type) {
                result.add(duck);
                iterator.remove();
            }
        }

        if (result.size() < count) {
            throw new IllegalStateException(
                    "Pas assez de canards de type " + type +
                            " : demandé " + count + ", disponible " + result.size()
            );
        }

        return result;
    }

    /**
     * Retourne le nombre de canards du type {@code type} présents dans le stock.
     *
     * @param type le type à compter
     */
    public int count(DuckType type) {
        int count = 0;

        for (T item : items) {
            if (item.getType() == type) count += 1;
        }
        return count;
    }

    /**
     * Retourne le nombre de canards défectueux dans le stock.
     * Un canard est défectueux si isDefective() retourne true.
     *
     * Conseil : appelez isDefective() plutôt que de comparer le score manuellement.
     */
    public int countDefective() {
        int count = 0;

        for (T item : items) {
            if (item.isDefective()) count += 1;
        }
        return count;
    }

    /**
     * Retourne une Map associant chaque DuckType au nombre de canards
     * de ce type présents dans le stock.
     *
     * Conseil : construisez la map en une seule passe sur items.
     * Tous les types doivent apparaître dans la map (avec 0 si absent).
     */
    public Map<DuckType, Integer> countByType() {

        Map<DuckType, Integer> result = new EnumMap<>(DuckType.class);

        for (DuckType type : DuckType.values()) {
            result.put(type, 0);
        }

        for (T duck : items) {
            result.merge(duck.getType(), 1, Integer::sum);
        }

        return result;
    }
}

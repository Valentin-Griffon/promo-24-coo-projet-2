### Question 1 

Une méthode default appartient à l 'interface, elle n'a accès qu'à ce que l'interface connaît, c'est-à-dire uniquement 
les méthodes de l'interface elle-même.
Pour que la méthode connaisse les attributs de la classe, il faut donc l'implémenté en public comme avec isDefectible() de Duck

### Question 2 

On ne peux pas faire l'inverse car une interface ne peut pas avoir de contructeurs. Or Machine est obligé d'avoir un contructeur
alors que maintenable n'en a pas besoin. De plus maintenable est concidérer comme un "peut faire" alors qu'une machine "est un".

### Question 3

Avec Stock\<Duck>, on n'accepte exactement q'un Stock\<Duck>, rien d'autre.
Avec Stock\<? extends Duck>, on accepte tout stock de n'importe quel sous-type de Duck.
Donc Stock\<Duck> est plus restrictif.

Exemple : 
````
// Avec la signature restrictive
boolean canBeFulfilled(Stock<Duck> stock) { ... }

// Avec la signature flexible
boolean canBeFulfilled(Stock<? extends Duck> stock) { ... }

````
````
Stock<LuxuryDuck> luxuryDuckStock = new Stock<>();
luxuryDuckStock.add(new LuxuryDuck());

// Ne compile pas : Stock<LuxuryDuck> n'est pas un Stock<Duck>
canBeFulfilled(luxuryDuckStock);

// Compile : Stock<? extends Duck> accepte Stock<LuxuryDuck>
canBeFulfilled(luxuryDuckStock);

````

